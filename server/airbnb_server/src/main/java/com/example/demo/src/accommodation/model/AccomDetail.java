package com.example.demo.src.accommodation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccomDetail {
    private int userIdx;
    private String name;
    private String nickName;
    private String phone;
    private String email;
    private String password;
}
