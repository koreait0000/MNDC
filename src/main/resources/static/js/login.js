let formElem = document.querySelector('#form');

let buttonElem = formElem.button1;

buttonElem.addEventListener('click', function () {
let idValue = formElem.mid.value
let pwValue = formElem.mpw.value;
    // console.log(idValue);
    // console.log(pwValue);
    fetch('/login',{
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            mid: idValue,
            mpw: pwValue
        })
    }).then(location.href='/')
})
