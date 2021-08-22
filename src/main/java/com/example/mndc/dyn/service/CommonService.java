package com.example.mndc.dyn.service;

import com.example.mndc.sta.auth.PrincipalDetails;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    public int getMpk(PrincipalDetails principalDetails){
        return principalDetails.getUserEntity().getMpk().intValue();
    }
}
