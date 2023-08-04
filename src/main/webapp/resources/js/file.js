{/* <div class="mb-3">
<label for="pic" class="form-label">사진첨부</label>
<input type="file" name="photos" class="form-control" id="pic" placeholder="사진 첨부">
</div> */}

const fileBtn = document.getElementById('fileBtn');
const fileList = document.getElementById('fileList');
const df = document.getElementsByClassName('df');
let idx = 0;
let count = 0;

fileList.addEventListener('click',function(event){
    console.log(event.target);
    let cl = event.target.classList;
    
    if(event.target.classList.contains('df')){
        let deleteId = event.target.getAttribute("data-id");
        document.getElementById(deleteId).remove();
        count--;
    }
})



fileBtn.addEventListener("click", function(){
    if(count<5){
    //div
    let f = document.createElement("div")
    let c = document.createAttribute('class');
    c.value="mb-3";
    f.setAttributeNode(c);
    c = document.createAttribute("id");
    c.value="file"+idx;
    
    f.setAttributeNode(c);
    
    //label
    let l = document.createElement('label');
    let p = document.createAttribute('for');
    p.value="pic";
    l.setAttributeNode(p);
    p = document.createAttribute('class');
    p.value="form-label";
    l.setAttributeNode(p);
    p = document.createTextNode('사진첨부');
    l.appendChild(p);

    //input
    let i = document.createElement('input');
    let t = document.createAttribute('type');
    t.value="file";
    i.setAttributeNode(t);
    t = document.createAttribute('name');
    t.value="photos"
    i.setAttributeNode(t);
    t = document.createAttribute('class')
    t.value='form-control';
    i.setAttributeNode(t);
    t = document.createAttribute('id');
    t.value='pic';
    i.setAttributeNode(t);

    f.appendChild(l);
    f.appendChild(i);
    
    let s = document.createElement('span');
    let x = document.createTextNode('X');
    let a = document.createAttribute('class');
    a.value='df';
    let a1= document.createAttribute('data-id');
    a1.value='file'+idx;
    s.appendChild(x);
    s.setAttributeNode(a);
    s.setAttributeNode(a1);
    f.appendChild(s);
    
    fileList.append(f);
    count++;
    }else {
        alert("파일은 최대 5개까지만 가능");
    }
    idx++;
})
