/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.controller;

import fullhouse.FullHouse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import src.database.Adapter;

/**
 *
 * @author Lenovo
 */
public class BaseController {
    
    Statement stat;
    Connection conn;
   
    
    String table;
    
    public BaseController(String table){
        
        this.table = table;
        
        try{
            init();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void init() throws SQLException{
        
        Adapter adapter = new Adapter("root","fullhouse","admin","localhost");
        
        conn = adapter.getConnection();
        stat = conn.createStatement();
        
    }
    
    public ResultSet getAll() throws SQLException{
      
         String query = "SELECT * FROM " + this.table;
        return stat.executeQuery(query)  ; 
    } 
    
    
    public ResultSet get(int id) throws SQLException{
        
         String query = "SELECT * FROM " + this.table + " WHERE id = " + id;
         
         
         
        return stat.executeQuery(query)  ; 
    
    
    
    };
    
    
    public ResultSet insert(){   
    return null;
    }
    
    public ResultSet update(){
    return null;
    }
    
    public ResultSet delete(int id) throws SQLException{
    String query  = "DELETE FROM " + this.table + " WHERE id = " + id;    
    return stat.executeQuery(query);
    }
    
    
    
    
    
    
    
    
    
}
