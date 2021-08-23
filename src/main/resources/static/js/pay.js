const tossPayments = TossPayments("test_ck_JQbgMGZzorzzXdypGB7rl5E1em4d");
const button1 = document.getElementById("payment-button1");
const button2 = document.getElementById("payment-button2");
const button3 = document.getElementById("payment-button3");
const button4 = document.getElementById("payment-button4");
const orderId = new Date().getTime();

button1.addEventListener("click", function () {
    let paymentData = {
        amount: 1000,
        orderId: orderId,
        orderName: "이등병",//상품명
        customerName: "고객 이름", //고객이름
        successUrl: window.location.origin + "/success",
        failUrl: window.location.origin + "/fail",
    };

    tossPayments.requestPayment(paymentData);
});

button2.addEventListener("click", function () {
    let paymentData = {
        amount: 2000,
        orderId: orderId,
        orderName: "일병",//상품명
        customerName: "고객 이름", //고객이름
        successUrl: window.location.origin + "/success",
        failUrl: window.location.origin + "/fail",
    };

    tossPayments.requestPayment(paymentData);
});

button3.addEventListener("click", function () {
    let paymentData = {
        amount: 3000,
        orderId: orderId,
        orderName: "상병",//상품명
        customerName: "고객 이름", //고객이름
        successUrl: window.location.origin + "/success",
        failUrl: window.location.origin + "/fail",
    };

    tossPayments.requestPayment(paymentData);
});

button4.addEventListener("click", function () {
    let paymentData = {
        amount: 4000,
        orderId: orderId,
        orderName: "병장",//상품명
        customerName: "고객 이름", //고객이름
        successUrl: window.location.origin + "/success",
        failUrl: window.location.origin + "/fail",
    };

    tossPayments.requestPayment(paymentData);
});