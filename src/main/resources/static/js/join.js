

//휴대폰 인증
$('#sendPhoneNumber').click(function(){
    let phoneNumber = $('#inputPhoneNumber').val();
    let checkNum = /^[0-9]/g;
    if(checkNum.test(phoneNumber) && phoneNumber.length == 11){
        $('.ok').show();
        $('.error').hide();
        $('#sendPhoneNumber').text('재발송');
        $.ajax({
            type: "GET",
            url: "check/sendSMS",
            data: {
                "phoneNumber" : phoneNumber
            },
            success: function(res){
                if(res === 'fail'){
                    $('.ok').text('coolSMS의 보유잔액이 부족합니다.');
                }else{
                    $('#checkBtn').click(function(){
                        if($.trim(res) ==$('#inputCertifiedNumber').val()){
                            $('.ok').text('휴대폰 인증이 정상적으로 완료되었습니다.');
                            $('#inputCertifiedNumber').attr("disabled",true);
                            $('#checkBtn').attr('disabled',true);
                        }else{
                            $('.ok').text('인증코드가 올바르지 않습니다.');
                        }
                    })
                }
            }
        })
    }else{
        $('.error').show();
        $('.ok').hide();
    }
});