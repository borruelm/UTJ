package com.utj.permitease.entities;


public class UserEntity {
    private String usrName;
    private String role;
    private  Integer daysAvailable;
    private boolean admin;

    public UserEntity(String usrName, String role, Integer daysAvailable, boolean admin) {
        this.usrName = usrName;
        this.role = role;
        this.daysAvailable = daysAvailable;
        this.admin = admin;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Integer daysAvailable) {
        this.daysAvailable = daysAvailable;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
