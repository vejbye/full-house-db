/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fullhouse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import src.controller.BaseController;

/**
 *
 * @author Lenovo
 */
public class FullHouse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        BaseController users = new BaseController("user");
        
        ResultSet result = users.getAll();
        
        
        
        while(result.next()){
            String naam = result.getString("name");
            String adres = result.getString("address");
            String postal = result.getString("postal");
            int phone = result.getInt("phone");
            String email = result.getString("email");
           int rating = result.getInt("rating");
           int wins = result.getInt("wins");
           int losses = result.getInt("losses");
            
            System.out.println(naam + "\t" + adres + "\t" + postal + "\t" + phone + "\t" + email + "\t" + rating + "\t" + wins + "\t" + losses + "\n");
            
        }
        
       
        
        
         
        
    }
    
}
