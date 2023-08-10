{/* <div class="mb-3">
<label for="pic" class="form-label">사진첨부</label>
<input type="file" name="photos" class="form-control" id="pic" placeholder="사진 첨부">
</div> */}

const fileBtn = document.getElementById('fileBtn');
const fileList = document.getElementById('fileList');
const df = document.getElementsByClassName('df');
const deletes = document.getElementsByClassName('deletes');

let idx = 0;
let count =0; 
if(deletes !=null){
    count=deletes.length;
}

for(del of deletes){
    del.addEventListener('click',function(){
        let num = this.getAttribute('data-delete-num');
        let check = confirm('삭제시 복구 불가');
        if(check){
            fetch("./fileDelete?fileNum="+num,{method:"GET"})
                .then((result)=>{return result.text()})
                .then((r)=>{
                    if(r.trim()=='1'){
                        console.log(this.previousSibling.previousSibling);
                        this.previousSibling.previousSibling.remove();
                        this.remove();
                        count--;
                    }
                })
        }
    });
}

$('#fileList').on('click',".df",function(){
//    let deleteId = $(this).attr('data-id')
//    $('#'+deleteId).remove();
    $(this).parent().remove();
    count--;
})

// fileList.addEventListener('click',function(event){
//     console.log(event.target);
//     let cl = event.target.classList;
    
//     if(event.target.classList.contains('df')){
//         let deleteId = event.target.getAttribute("data-id");
//         document.getElementById(deleteId).remove();
//         count--;
//     }
// })

$('#fileBtn').click(function(){
    if(count<5){
        let d = '<div class="mb-3">'
        d = d.concat('<lable for="pic" class="form-label">사진첨부</label>');
        d = d.concat('<input type="file" name="photos" class="form-control" id="pic">');
        d = d.concat('<span class="df" data-id="file'+idx+'">X</span>');
        d = d.concat('</div>');
        $('#fileList').append(d);
        count++;
        idx++;
    }else{
        alert('파일은 5개가 최대')
    }
});


// fileBtn.addEventListener("click", function(){
//     if(count<5){
//     //div
//     let f = document.createElement("div")
//     let c = document.createAttribute('class');
//     c.value="mb-3";
//     f.setAttributeNode(c);
//     c = document.createAttribute("id");
//     c.value="file"+idx;
    
//     f.setAttributeNode(c);
    
//     //label
//     let l = document.createElement('label');
//     let p = document.createAttribute('for');
//     p.value="pic";
//     l.setAttributeNode(p);
//     p = document.createAttribute('class');
//     p.value="form-label";
//     l.setAttributeNode(p);
//     p = document.createTextNode('사진첨부');
//     l.appendChild(p);

//     //input
//     let i = document.createElement('input');
//     let t = document.createAttribute('type');
//     t.value="file";
//     i.setAttributeNode(t);
//     t = document.createAttribute('name');
//     t.value="photos"
//     i.setAttributeNode(t);
//     t = document.createAttribute('class')
//     t.value='form-control';
//     i.setAttributeNode(t);
//     t = document.createAttribute('id');
//     t.value='pic';
//     i.setAttributeNode(t);

//     f.appendChild(l);
//     f.appendChild(i);
    
//     let s = document.createElement('span');
//     let x = document.createTextNode('X');
//     let a = document.createAttribute('class');
//     a.value='df';
//     let a1= document.createAttribute('data-id');
//     a1.value='file'+idx;
//     s.appendChild(x);
//     s.setAttributeNode(a);
//     s.setAttributeNode(a1);
//     f.appendChild(s);
    
//     fileList.append(f);
//     count++;
//     }else {
//         alert("파일은 최대 5개까지만 가능");
//     }
//     idx++;
// })


