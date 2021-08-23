let formElem = document.querySelector('#form');
let buttonElem = formElem.button1;
let isRecaptchachecked = false;


let captcha = 1;
function doVaildRecaptcha(){
    $.ajax({
        url: '/valid-recaptcha',
        type: 'post',
        data: {
            recaptcha: $("#g-recaptcha-response").val()
        },
        success: function (data) {
            switch (data) {
                case 0:
                    console.log("자동 가입 방지 봇 통과");
                    captcha = 0;
                    let idValue = formElem.mid.value
                    let pwValue = formElem.mpw.value;
                    // console.log(idValue);
                    // console.log(pwValue);
                    if(idValue.length != 0 && pwValue.length!=0){
                        fetch('/login',{
                            method: 'post',
                            headers: {
                                'Content-Type': 'application/json'
                            },
                            body: JSON.stringify({
                                mid: idValue,
                                mpw: pwValue
                            })
                        }).catch(err =>{
                            console.log(err);
                        }).then(() =>{
                            location.href= '/';
                        })
                        break;
                    }else{
                        alert('아이디 또는 비밀번호를 확인해주세요.');
                    }
                case 1:
                    location.href= '/login';
                    break;
                default:
                    alert("자동 가입 방지 봇을 실행 하던 중 오류가 발생 했습니다. [Error bot Code : " + Number(data) + "]");
                    location.href= '/login';
                    break;
            }
        }
    });
    if (captcha != 0) {
        return false;
    }
}

function recaptchaCallback(){// 리캡챠 체크 박스 클릭시 isRecaptchachecked 값이 true로 변경
    isRecaptchachecked = true;
}

buttonElem.addEventListener('click', function () {
    if(!isRecaptchachecked){
        alert('인증 체크를 해주세요.');
        $("#recaptcha").focus();
        return false;
    }
    doVaildRecaptcha();

});
