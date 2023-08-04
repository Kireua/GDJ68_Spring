console.log("member");

const id = document.getElementById("id");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const names = document.getElementById("name");
const email = document.getElementById("email");
const birth = document.getElementById("birth");
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");
//idcheck결과 
let idCheckResult=false;
let pwCheckResult=false;
let pw2CheckResult=false;
let nameCheckResult=false;
let emailCheckResult=false;

let chekResults=[false,false,false,false,false, false];

//---- ID Check-----
//비어X, 최대 10
id.addEventListener("blur", function(){
    const idResult = document.getElementById(id.id+"Result")
    console.log(idResult);
    

    if(id.value == "" || id.value.length>10){
        console.log("xxxxxx");
        idResult.innerHTML="ID는 비어있으면 X, 10글자 미만이어야 한다";
        idResult.className="f";
       chekResults[0]=false;
        
    }else {
        console.log("ok");
        idResult.innerHTML="가능한 ID입니다.";
        idResult.className="s";
        chekResults[0]=true;
    }
});

//-----------------------------



//---------- PW check
pw.addEventListener("blur", function(){
    const pwResult = document.getElementById(pw.id+"Result")
    if(pw.value.length>5 && pw.value.length<12){
        pwResult.innerHTML="올바른 비번입니다";
        pwResult.className="s";
        chekResults[1]=true;
    }else {
        pwResult.innerHTML="비번은 6글자 이상 12글자 미만이어야 함";
        pwResult.className="f";
        chekResults[1]=false;
    }
})

pw.addEventListener("change", function(){
    pw2.value="";
    chekResults[2]=false;
    pw2Result.innerHTML="";
})

//-------- Pw Equal Check
pw2.addEventListener("keyup",function(){
    const pw2Result = document.getElementById("pw2Result")
    if(pw2.value==pw.value){
        pw2Result.innerHTML="비밀번호가 같다"
        pw2Result.className="s"
        chekResults[2]=true;
    }else {
        pw2Result.innerHTML="비밀번호가 틀리다"
        pw2Result.className="f"
        chekResults[2]=false;
    }
});

//-------- name check
names.addEventListener("blur", function(){
    let check = emptyCheck(names);
    const nameResult = document.getElementById("nameResult");
    nameResult.innerHTML="비어있으면 X";
    nameResult.className='f';
    chekResults[3]=false;

    if(!check){
        nameResult.innerHTML="OK";
        nameResult.className='s';
        chekResults[3]=true;
    }

});

//-------- email check
email.addEventListener("blur", function(){
    let check = emptyCheck(email);
    const nameResult = document.getElementById("emailResult");
    nameResult.innerHTML="비어있으면 X";
    nameResult.className='f';
    chekResults[4]=false;

    if(!check){
        nameResult.innerHTML="OK";
        nameResult.className='s';
        chekResults[4]=true;
    }

});

//------- 생일 체크
birth.addEventListener("change",function(){
    let check = emptyCheck(birth);
    const birthResult = document.getElementById("birthResult");
    birthResult.innerHTML="비어있으면 X";
    birthResult.className='f';
    chekResults[5]=false;

    if(!check){
        birthResult.innerHTML="OK";
        birthResult.className='s';
        chekResults[5]=true;
    }
})



btn.addEventListener("click",function(){
    let c = chekResults.includes(false);
    if(!c){
        //form 전송
        console.log("form 전송")
        frm.onsubmit();
    }else {
        alert("필수 항목은 입력해");
    }
})



//비어있는지 체크하는 함수
function emptyCheck(element){
    if(element.value==null || element.value.length==0){
        return true;
    }else {
        return false;
    }
}