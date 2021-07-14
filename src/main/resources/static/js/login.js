let formElem = document.querySelector('#form');

let buttonElem = formElem.button1;

buttonElem.addEventListener('click', function () {
let idValue = formElem.id.value
let pwValue = formElem.pw.value;
    // console.log(idValue);
    // console.log(pwValue);
    fetch('/login',{
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: idValue,
            pw: pwValue
        })
    })
})
