package com.example.Exam.Portal.Application.entities;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {


    public void setAuthority(String authority) {
        this.authority = authority;
    }

    private String authority;
    public Authority(String authority){
        this.authority=authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

}
