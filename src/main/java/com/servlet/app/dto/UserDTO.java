package com.servlet.app.dto;

public class UserDTO {
    private int id;
    private String fullName;
    private String email;
    private int phone;

    public void setId(int id){
        this.id = id;
    }
    public void setFullName(String name){
        this.fullName = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhone(int phone){
        this.phone = phone;
    }
}
