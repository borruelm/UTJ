package com.example.utj.entity;

import lombok.Data;

@Data
public class UserResponse {
    private String usrName;
    private String role;
    private Integer daysAvailable;
    private boolean isAdmin;
}
