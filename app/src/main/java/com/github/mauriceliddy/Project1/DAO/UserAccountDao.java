package com.github.mauriceliddy.Project1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.mauriceliddy.Project1.Model.UserAccount;

public class UserAccountDao implements DAO<UserAccount>{

    ResultSet rSet;
    Connection connection;
    PreparedStatement pStatement;
    
    public UserAccountDao(Connection connection) {
        this.connection = connection;
    }
    
    
    public UserAccount insertUser(UserAccount user) {
        
        try {
            System.out.println("adding user now");
            pStatement = connection.prepareStatement("insert into useraccounts (aname,pass) values(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, user.getName());
            pStatement.setString(2, user.getPassword());
            pStatement.execute();
            rSet = pStatement.getGeneratedKeys();
            if (rSet.next()) {
                user.setId(rSet.getInt(1));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return user;
        
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
    public void delete(UserAccount user) {
        try {
            System.out.println("Deleting user now in sql");
            pStatement = connection.prepareStatement("delete from useraccounts where userid = ?");
            pStatement.setInt(1, user.getId());
            pStatement.execute();
            
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }

    @Override
    public void clearTable() {
        try {
            PreparedStatement pStatement = connection.prepareStatement("delete from useraccounts");
            pStatement.execute();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }

    @Override
    public void insert(UserAccount e) {
        // TODO Auto-generated method stub
        
    }

  public UserAccount getUser(String uName){
    UserAccount user = new UserAccount();
    
    try {
        pStatement = connection.prepareStatement("select * from useraccounts where aname = ?");
        pStatement.setString(1, uName);
        ResultSet rSet = pStatement.executeQuery();
        while(rSet.next()){
            user.setId(rSet.getInt("userid"));
            user.setName(rSet.getString("aname"));
            user.setPassword(rSet.getString("pass"));
            System.out.println("Single user from database: "+ user);
        }

    } catch (SQLException e) {

        e.printStackTrace();
    }
    return user;
  }
    
}
