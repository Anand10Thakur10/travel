package com.example.travel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {
    JButton Back;
    ViewBookedHotel(String username)
    {
        setBounds(400,200,1000,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("VIEW BOOKED HOTEL  DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,0,400,30);
        add(text);


        JLabel lblusername=new JLabel("username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lblHotelName=new JLabel("Hotel Name");
        lblHotelName.setBounds(30,90,150,25);
        add(lblHotelName);

        JLabel labelPackage=new JLabel();
        labelPackage.setBounds(220,90,150,25);
        add(labelPackage);

        JLabel lblNumber=new JLabel("Total Persons");
        lblNumber.setBounds(30,130,150,25);
        add(lblNumber);

        JLabel labelTPerson=new JLabel();
        labelTPerson.setBounds(220,130,150,25);
        add(labelTPerson);


        JLabel lblTDays=new JLabel("Total Days");
        lblTDays.setBounds(30,170,150,25);
        add(lblTDays);

        JLabel labelTDays=new JLabel();
        labelTDays.setBounds(220,170,150,25);
        add(labelTDays);


        JLabel lblAc=new JLabel("AC/NON-AC");
        lblAc.setBounds(30,210,150,25);
        add(lblAc);

        JLabel labelAc=new JLabel();
        labelAc.setBounds(220,210,150,25);
        add(labelAc);


        JLabel lblFood=new JLabel("Food Included?");
        lblFood.setBounds(30,250,150,25);
        add(lblFood);

        JLabel labelFood=new JLabel();
        labelFood.setBounds(220,250,150,25);
        add(labelFood);

        JLabel lblName=new JLabel("Id");
        lblName.setBounds(30,290,150,25);
        add(lblName);

        JLabel labelId=new JLabel();
        labelId.setBounds(220,290,150,25);
        add(labelId);

        JLabel lblGender=new JLabel("Number");
        lblGender.setBounds(30,330,150,25);
        add(lblGender);

        JLabel labelNumber=new JLabel();
        labelNumber.setBounds(220,330,150,25);
        add(labelNumber);

        JLabel lblPhone=new JLabel("Phone");
        lblPhone.setBounds(30,370,150,25);
        add(lblPhone);

        JLabel labelPhone=new JLabel();
        labelPhone.setBounds(220,370,150,25);
        add(labelPhone);

        JLabel lblPrice=new JLabel("Total cost");
        lblPrice.setBounds(30,410,150,25);
        add(lblPrice);

        JLabel labelPrice=new JLabel();
        labelPrice.setBounds(220,410,150,25);
        add(labelPrice);

        Back =new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(130,450,100,25);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1=new ImageIcon(ViewBookedHotel.class.getResource("/icons/bookedDetails.jpg"));
        Image i2 =i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);

        try {
            Conn conn=new Conn();
            String query ="select * from bookhotel where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelPackage.setText(rs.getString("name"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelTPerson.setText(rs.getString("persons"));
                labelPrice.setText(rs.getString("price"));
                labelPhone.setText(rs.getString("phone"));
                labelFood.setText(rs.getString("food"));
                labelAc.setText(rs.getString("ac"));
                labelTDays.setText(rs.getString("days"));

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
        new ViewBookedHotel("Anand");
    }

}

