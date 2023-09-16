package com.example.travel;
import java.sql.*;


public class Conn {

    Connection C;
    Statement s;
    Conn(){
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        C=DriverManager.getConnection("jdbc:mysql://localhost:3306/travel","root","javaprojects");
        s=C.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
