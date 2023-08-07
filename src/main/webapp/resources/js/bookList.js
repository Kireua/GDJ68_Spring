const list = document.getElementById('list');

list.addEventListener('click', function(){
    let xhttp = new XMLHttpRequest();
    
    //open('method','url')
    xhttp.open("GET", "./list?page=1");

    xhttp.send()

    xhttp.onreadystatechange=function(){
        //4 way hand shaking 이라서 4번째만 본다 정상응답을 보기위해 200번만 보고
        if(this.readyState==4 && this.status==200){
            let r = this.responseText;
            if(r>0){
                alert('가입이 성공되었습니다.');
            }
            else {
                alert('가입 실패');
            }
           console.log(this.responseText);
            // if(this.responseText.trim()=='1'){
            //     alert('수정 성공');
            // }
        }
    }
});