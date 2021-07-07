<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form method="post" action="/join" id="form">
        <div>아이디</div>
        <div><input type="text" name="id"></div>
        <div><span id="idError">아이디를 입력해주세요.</span></div>
        <div>비밀번호</div>
        <div><input type="password" name="pw"></div>
        <div>비밀번호확인</div>
        <div><input type="password" name="pw2"></div>
        <div>이름</div>
        <div><input type="text" name="name"></div>
        <div>생년월일</div>
        <div><input type="text" name="birth"></div>
        <div>성별</div>
        <div><input type="text" name="gender"></div>
        <div>이메일</div>
        <div><input type="text" name="email"></div>
        <div>휴대폰</div>
        <div><input type="text" name="phoneNum" placeholder="'-'없이 입력"></div>
        <div><input type="submit" value="회원가입"></div>
    </form>
</div>