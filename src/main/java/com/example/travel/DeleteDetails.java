package com.example.travel;

import com.sun.glass.ui.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeleteDetails extends JFrame implements ActionListener {
    JButton Back;
    String username;
    DeleteDetails(String username)
    {
        this.username=username;
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel lblusername=new JLabel("username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lblId=new JLabel("ID");
        lblId.setBounds(30,110,150,25);
        add(lblId);

        JLabel labelId=new JLabel();
        labelId.setBounds(220,110,150,25);
        add(labelId);

        JLabel lblNumber=new JLabel("Number");
        lblNumber.setBounds(30,170,150,25);
        add(lblNumber);

        JLabel labelNumber=new JLabel();
        labelNumber.setBounds(220,170,150,25);
        add(labelNumber);

        JLabel lblName=new JLabel("Name");
        lblName.setBounds(30,230,150,25);
        add(lblName);

        JLabel labelName=new JLabel();
        labelName.setBounds(220,230,150,25);
        add(labelName);

        JLabel lblGender=new JLabel("Gender");
        lblGender.setBounds(30,300,150,25);
        add(lblGender);

        JLabel labelGender=new JLabel();
        labelGender.setBounds(220,300,150,25);
        add(labelGender);

        JLabel lblCountry=new JLabel("Country");
        lblCountry.setBounds(500,50,150,25);
        add(lblCountry);

        JLabel labelCountry=new JLabel();
        labelCountry.setBounds(690,50,150,25);
        add(labelCountry);

        JLabel lblAddress=new JLabel("Address");
        lblAddress.setBounds(500,110,150,25);
        add(lblAddress);

        JLabel labelAddress=new JLabel();
        labelAddress.setBounds(690,110,150,25);
        add(labelAddress);

        JLabel lblPhone=new JLabel("Phone");
        lblPhone.setBounds(500,170,150,25);
        add(lblPhone);

        JLabel labelPhone=new JLabel();
        labelPhone.setBounds(690,170,150,25);
        add(labelPhone);

        JLabel lblEmail=new JLabel("Email");
        lblEmail.setBounds(500,230,150,25);
        add(lblEmail);

        JLabel labelEmail=new JLabel();
        labelEmail.setBounds(690,230,150,25);
        add(labelEmail);

        Back =new JButton("Delete");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(350,350,100,25);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1=new ImageIcon(DeleteDetails.class.getResource("/icons/viewall.jpg"));
        Image i2 =i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(20,400,600,200);
        add(image);

        ImageIcon i4=new ImageIcon(DeleteDetails.class.getResource("/icons/viewall.jpg"));
        Image i5 =i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image1=new JLabel(i6);
        image1.setBounds(600,400,600,200);
        add(image1);

        try {
            Conn conn=new Conn();
            String query ="select * from customer where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelName.setText(rs.getString("Name"));
                labelGender.setText(rs.getString("gender"));
                labelCountry.setText(rs.getString("country"));
                labelAddress.setText(rs.getString("address"));
                labelPhone.setText(rs.getString("phone"));
                labelEmail.setText(rs.getString("email"));

            }

        }
        catch (Exception e )
        {
            e.printStackTrace();
        }

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try {
            Conn c=new Conn();
            c.s.executeUpdate("delete from account where username='"+username+"'");
            c.s.executeUpdate("delete from customer where username='"+username+"'");
            c.s.executeUpdate("delete from bookpackage where username='"+username+"'");
            c.s.executeUpdate("delete from bookhotel where username='"+username+"'");

            JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
            setVisible(false);
            System.exit(0);
        }catch (Exception e){

        }
    }

    public static void main(String[] args) {
        new DeleteDetails("Anand");
    }

}
