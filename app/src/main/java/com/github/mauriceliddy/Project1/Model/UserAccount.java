package com.github.mauriceliddy.Project1.Model;

public class UserAccount {

    private int id;
    private String name;
    private String password;
  

    public UserAccount() {
    }
    public UserAccount(int id) {
        this.id = id;
    }

    public UserAccount(int id,String name,  String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "UserAccount [id=" + id + ", name=" + name + ", password=" + password + "]";
    }


 
   
    
}
