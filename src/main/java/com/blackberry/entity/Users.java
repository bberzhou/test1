package com.blackberry.entity;

import java.util.Date;

/**
 * @author bberzhou@gmail.com
 * @date 7/24/19 14:17
 * Create By IntelliJ IDEA
 */
public class Users {
    private String username;
    private String password;
    private String email;
    private String gender;

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getGender () {
        return gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }




    public Users(){}

}
