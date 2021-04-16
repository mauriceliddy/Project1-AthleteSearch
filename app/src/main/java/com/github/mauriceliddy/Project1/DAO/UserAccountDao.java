package com.github.mauriceliddy.Project1.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.mauriceliddy.Project1.Model.UserAccount;

public class UserAccountDao implements DAO<UserAccount>{

    ResultSet rSet;
    Connection connection;
    
    public UserAccountDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insert(UserAccount e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<UserAccount> getAll() {
        
        List<UserAccount> returnedUsers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rSet = statement.executeQuery("select * from useraccounts");
            while(rSet.next()){
                UserAccount user = new UserAccount();
                user.setId(rSet.getInt("userid"));
                user.setName(rSet.getString("aname"));
                user.setPassword(rSet.getString("pass"));
                returnedUsers.add(user);
                System.out.println(user);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return returnedUsers;
    }

    @Override
    public void update(UserAccount e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(UserAccount e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void clearTable() {
        // TODO Auto-generated method stub
        
    }

  
    
}
