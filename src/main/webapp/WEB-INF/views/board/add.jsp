<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../temp/bootStrap.jsp"></c:import>
<title>Insert title here</title>
    <!-- include summernote css/js-->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<c:if test="${empty member }">
	<script type="text/javascript">
		alert("로그인하세요");
		location.href="../member/login"
	</script>
</c:if>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<h1 class="mb-5 text-center">${board } 추가</h1>
	
	<form class="mb-5 text-center form-control" action="./add" method="post" id="frm" enctype="multipart/form-data">
		<div class="input-group text-center">
			<span class="input-group-text" id="basic-addon2">제목</span>
			<input id="subject" type="text" name="subject">
		</div><br>
		<div class="input-group text-center">
			<span class="input-group-text" id="basic-addon2">내용</span>
			<textarea class="input-group" rows="" cols="" name="contents" id="contents"></textarea>
		</div><br>
		<div class="input-group text-center">
			<span class="input-group-text" id="basic-addon2">작성자</span>
			<input  type="text" name="name"  value="${member.id }">
		</div><br>
		
		
		<div id="fileList" class="mb-3"></div>
		<div class="mb-3">
			<button id="fileBtn" type="button">File추가</button>
		</div>
		
		
		<button id="btn" type="button">등록</button>

	</form>

	<script src="../resources/js/file.js"></script>
	<script>
		const btn = document.getElementById("btn");
		const subject = document.getElementById("subject");
		const frm = document.getElementById("frm");

		// $("#contents").summernote({
		// 	height: 300,
		// 	callbacks:{
		// 		onImageUpload: function(files) {
		// 			alert("image upload");
      	// 			// upload image to server and create imgNode...
		// 			//이미지를 Server로 전송하고
		// 			//응답으로 이미지경로와 파일명을 받아서
		// 			//img 태그를 만들어서 src 속성에 이미지 경로 넣는것

		// 			let formdata= new FormData();//<form></form>
		// 			formdata.append("files",files[0]); //<input type="file" name="files">
					
		// 			$.ajax({
		// 				type:"post",
		// 				url:'setContentsImg',
		// 				data:formData,
		// 				cache:false,
		// 				enctype:'multipart/form-data',
		// 				contentType:false,
		// 				processData:false,
		// 				success:function(r){
		// 					console.log(r);
		// 				},
		// 				error:function(){
		// 					console.log('error');
		// 				}
		// 			})
      	// 			$summernote.summernote('insertNode', imgNode);
    	// 		}
		// 	}
		// });
		$("#contents").summernote({
            height:400,
            callbacks:{
                onImageUpload:function(files){
                alert('이미지 업로드')
                //이미지를 server로 전송하고
                //응답으로 이미지경로와 파일명을 받아서
                //img 태그를 만들어서 src속성에 이미지경로는 넣는것
                let formData = new FormData();//<form></form>
                formData.append('files',files[0]);//<input type='file' name='files'>
                $.ajax({
                    type:'post',
                    url:'setContentsImg',
                    data:formData,
                    cashe: false,
                    enctype:'multipart/form-data',
                    contentType: false,
                    processData: false,
                    success:function(result){
                        $("#contents").summernote("insertImage",result.trim());
                    },
                    error:function(){
                        console.log('error');
                    }
                });
                },
				onMediaDelete:function(files){
					let path = $(files[0]).attr("src"); // /resources/upload/notice/파일명
					$.ajax({
						type:'post',
						url:'./setContentsImgDelete',
						data:{
							path:path
						},
						success:function(result){
							console.log(result);
						},
						error:function(){
							console.log('error');
						}
					})
				}
            }
        });


		btn.addEventListener("click", function(){
			console.log(subject.value=="");
			console.log(subject.value.length == 0);
			if(subject.value==""){
				alert('제목은 필수 입니다.');
				subject.focus();
			}else {
				frm.submit();
			}
		});

	</script>

</body>
</html>