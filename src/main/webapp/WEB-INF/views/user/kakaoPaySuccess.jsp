<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
결제일시:
<div>${info.approved_at}</div>
주문번호:
<div>${info.partner_order_id}</div>
상품명:
<div>${info.item_name}</div>
상품수량:
<div>${info.quantity}</div>
결제금액:
<div>${info.amount.total}</div>
결제방법:
<div>${info.payment_method_type}</div>
</body>
</html>