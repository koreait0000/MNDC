package com.example.mndc.service;

import com.example.mndc.auth.PrincipalDetails;
import com.example.mndc.dao.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    BoardDAO boardDAO;

    // 로그인 체크
    public boolean isLogin(PrincipalDetails principalDetails){
        return principalDetails == null;
    }
    // 로그인 체크 + 계정일치 체크
    public boolean isLoginMatch(PrincipalDetails principalDetails,int b_pk){

        return isLogin(principalDetails) &&
                principalDetails.getUserEntity().getIuser().intValue() == boardDAO.selectInfoByBPk(b_pk).getM_pk();
    }
}
