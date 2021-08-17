const formElem = document.querySelector('#form');
let id = formElem.mid;
let idError = document.getElementById('idError');
let pw = formElem.mpw;
let pwError = document.getElementById('pwError');
let pwError2 = document.getElementById('pwError2');
let pw2 = formElem.mpw2;

let flag1 = false;
let flag2 = false;
let flag3 = false;
id.addEventListener('keyup', e=>{
    if(id.value.length<6){
        idError.innerText='아이디가 너무 짧습니다.(6글자 이상)';
    }else{
        idError.innerText='';
        flag1 = true;
    }
});

pw.addEventListener('keyup', e=>{
    if(pw.value.length<4){
        pwError.innerText='비밀번호가 너무 짧습니다.(4글자 이상)';
    }else{
        pwError.innerText='';
        flag2 = true;
    }
});

pw2.addEventListener('keyup', e=>{
    if(pw.value !== pw2.value){
        pwError2.innerText='비밀번호를 확인해주세요';
    }else{
        pwError2.innerText='';
        flag3 = true;
    }
});

formElem.btn.addEventListener('click',()=>{
    if(flag1 === true && flag2 === true && flag3 == true){
        formElem.submit();
    }else{
        alert('입력 안된 사항이 있습니다.');
    }
});

// formElem.btn.addEventListener('click', e =>{
//     let id = formElem.mid;
//     let idError = document.getElementById('idError');
//     let pw = formElem.mpw;
//     let pwError = document.getElementById('pwError');
//     let pw2 = formElem.mpw2;
//
//     if(pw.value !== pw2.value){
//         pwError.innerText='비밀번호를 확인해주세요';
//     }else if(pw.value.length <4){
//         pwError.innerText='비밀번호가 너무 짧습니다.(4글자 이상)';
//     }else if(id.value < 6){
//         idError.innerText='아이디가 너무 짧습니다.(6글자 이상)';
//     }else{
//
//     }
// });
