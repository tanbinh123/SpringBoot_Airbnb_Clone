package com.example.demo.src.accommodation;


import com.example.demo.config.BaseException;
import com.example.demo.src.member.model.PatchUserReq;
import com.example.demo.src.member.model.PostUserReq;
import com.example.demo.src.member.model.PostUserRes;
import com.example.demo.utils.JwtService;
import com.example.demo.utils.SHA256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.*;

// Service Create, Update, Delete 의 로직 처리
@Service
public class AccomService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AccomDao accomDao;
    private final AccomProvider accomProvider;
    private final JwtService jwtService;


    @Autowired
    public AccomService(AccomDao accomDao, AccomProvider accomProvider, JwtService jwtService) {
        this.accomDao = accomDao;
        this.accomProvider = accomProvider;
        this.jwtService = jwtService;

    }


}
