/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class jdbcHelper {
    public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dburl="jdbc:sqlserver://localhost:1433;databaseName=QLKhachSan";
    public static String username="sa";
    public static String password="songlong";
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbcHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       
       public static PreparedStatement getStmt(String sql,Object...args)throws SQLException{
        Connection conn=DriverManager.getConnection(dburl, username, password);
        PreparedStatement stmt;
           if (sql.trim().startsWith("{")) {
               stmt = conn.prepareCall(sql);
           }else{
               stmt = conn.prepareStatement(sql);
           }
           for (int i = 0; i < args.length; i++) {
               stmt.setObject(i + 1, args[i]);
           }
           return stmt;
    }
       
       
       public static ResultSet query(String sql , Object...args) throws SQLException{
           PreparedStatement stmt = jdbcHelper.getStmt(sql, args);
           return stmt.executeQuery();
    }
       
       
       public static Object value(String sql , Object...args) {
           try {
               ResultSet rs = jdbcHelper.query(sql, args);
               if (rs.next()) {
                   return rs.getObject(0);
               }
               rs.getStatement().getConnection().close();
               return null ;
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
    }
       public static int update(String sql , Object...args){
           try {
               PreparedStatement stmt = jdbcHelper.getStmt(sql, args);
               try {
                   return stmt.executeUpdate();
               }
               finally{
                   stmt.getConnection().close();
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
        return 0;
    }
}
