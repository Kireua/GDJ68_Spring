let del = document.getElementById('del');

let bookNum;

function setBookNum(num){
    bookNum=num;
}

del.addEventListener('click', function(){
    let check = window.confirm('정말 삭제하시겠습니까?');
    if(check){
        console.log(del.id);
        check = del.getAttribute('data-delete-num');
        console.log(check);
        let parameterName=del.getAttribute('data-delete-name');
        location.href="./delete?"+parameterName+"="+check;
    }
})