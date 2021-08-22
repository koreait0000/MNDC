const tossPayments = TossPayments("test_ck_JQbgMGZzorzzXdypGB7rl5E1em4d");
const button = document.getElementById("payment-button");
const orderId = new Date().getTime();
button.addEventListener("click", function () {
    let paymentData = {
        amount: 19000,
        orderId: orderId,
        orderName: " ",//상품명
        customerName: " ", //고객이름
        successUrl: window.location.origin + "/success",
        failUrl: window.location.origin + "/fail",
    };

    tossPayments.requestPayment(paymentData);
});