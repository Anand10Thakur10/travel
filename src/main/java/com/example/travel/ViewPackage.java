package com.example.travel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener {
    JButton Back;
    ViewPackage(String username)
    {
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);


        JLabel lblusername=new JLabel("username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lblId=new JLabel("Package");
        lblId.setBounds(30,90,150,25);
        add(lblId);

        JLabel labelPackage=new JLabel();
        labelPackage.setBounds(220,90,150,25);
        add(labelPackage);

        JLabel lblNumber=new JLabel("Total Persons");
        lblNumber.setBounds(30,130,150,25);
        add(lblNumber);

        JLabel labelTPerson=new JLabel();
        labelTPerson.setBounds(220,130,150,25);
        add(labelTPerson);

        JLabel lblName=new JLabel("Id");
        lblName.setBounds(30,170,150,25);
        add(lblName);

        JLabel labelId=new JLabel();
        labelId.setBounds(220,170,150,25);
        add(labelId);

        JLabel lblGender=new JLabel("Number");
        lblGender.setBounds(30,210,150,25);
        add(lblGender);

        JLabel labelNumber=new JLabel();
        labelNumber.setBounds(220,210,150,25);
        add(labelNumber);

        JLabel lblPhone=new JLabel("Phone");
        lblPhone.setBounds(30,250,150,25);
        add(lblPhone);

        JLabel labelPhone=new JLabel();
        labelPhone.setBounds(220,250,150,25);
        add(labelPhone);

        JLabel lblPrice=new JLabel("Price");
        lblPrice.setBounds(30,290,150,25);
        add(lblPrice);

        JLabel labelPrice=new JLabel();
        labelPrice.setBounds(220,290,150,25);
        add(labelPrice);

        Back =new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(130,360,100,25);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1=new ImageIcon(ViewPackage.class.getResource("/icons/bookedDetails.jpg"));
        Image i2 =i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);

        try {
            Conn conn=new Conn();
            String query ="select * from Bookpackage where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelPackage.setText(rs.getString("pakage"));
                labelPrice.setText(rs.getString("price"));
                labelPhone.setText(rs.getString("phone"));
                labelTPerson.setText(rs.getString("persons"));
                labelPhone.setText(rs.getString("phone"));

            }

        }
        catch (Exception e )
        {
            e.printStackTrace();
        }

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewPackage("Anand");
    }

}

