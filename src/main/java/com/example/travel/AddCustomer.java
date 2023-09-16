package com.example.travel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel labelusername,labelName;
    JComboBox comboId;
    JTextField tfnumber,tfcountry ,tfaddress,tfphone,tfemail;
    JRadioButton rmale,rfemale;
    JButton Add,Back;
    String username;

    AddCustomer(String username){
     this.username=username;
        setBounds(450,200,850,550);
        setLayout(null);

        JLabel lblusername=new JLabel("username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

       labelusername=new JLabel("username");
        labelusername.setBounds(30,50,150,25);
        add(labelusername);

        JLabel lbluserId=new JLabel("ID Proof");
        lbluserId.setBounds(30,90,150,25);
        add(lbluserId);

        comboId= new JComboBox(new String[] {"Passport","Aadhar card","Pan card","driving license"});
        comboId.setBackground(Color.WHITE);
        comboId.setBounds(220,90,150,25);
        add(comboId);

        JLabel lblnumber =new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);

        tfnumber=new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);

        labelName =new JLabel();
        labelName.setBounds(220,170,150,25);
        add(labelName);

        JLabel lblGender=new JLabel("Gender");
        lblGender.setBounds(30,210,150,25);
        //lblGender.setBackground(Color.white);
        add(lblGender);
        rmale=new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.white);
        add(rmale);

        rfemale=new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.white);
        add(rfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rfemale);
        bg.add(rmale);

        JLabel lblcountry =new JLabel("Country");
        lblcountry.setBounds(30   ,250,150,25);
        add(lblcountry);

        tfcountry=new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);

        JLabel lbladdress =new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);

        tfaddress=new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);

        JLabel lblphone =new JLabel("phone Number");
        lblphone.setBounds(30,330,150,25);
        add(lblphone);

        tfphone=new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);

        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(30,370,150,25);
        add(lblemail);

        tfemail=new JTextField();
        tfemail.setBounds(220,370,150,25);
        add(tfemail);

        Add=new JButton("Add");
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.white);
        Add.setBounds(70,430,100,25);
        Add.addActionListener((ActionListener) this);
        add(Add);

        Back=new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.setBounds(180,430,100,25);
        Back.addActionListener((ActionListener) this);
        add(Back);

        ImageIcon i1=new ImageIcon(ForgetPassword.class.getResource("/icons/newcustomer.jpg"));
        Image i2 =i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,40,450,420);
        add(image);

        try{
         Conn c=new Conn();
         ResultSet rs=c.s.executeQuery("select * from account where username='"+username+"'");
         while(rs.next()){
          labelusername.setText(rs.getString("username"));
          labelName.setText(rs.getString("name"));
         }
        } catch (SQLException throwables) {
         throwables.printStackTrace();
        }

     setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==Add){
     String username=labelusername.getText();
     String id = (String)comboId.getSelectedItem();
     String number =tfnumber.getText();
     String name=labelName.getText();
     String gender=null;
     if(rmale.isSelected()){
      gender="Male";

     }else{
      gender="Female";
     }
     String country=tfcountry.getText();
     String address=tfaddress.getText();
     String phone=tfphone.getText();
     String email=tfemail.getText();

     try{
      Conn c=new Conn();
      String query="insert into customer values('"+username+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"')";
      c.s.executeUpdate(query);
      JOptionPane.showMessageDialog(null,"Customer Details Added Successfully ");
      setVisible(false);
     }
     catch (Exception e){
      e.printStackTrace();
     }

     }else{
      setVisible(false);
     }
    }

    public static void main(String[] args) {
        new AddCustomer("Anand");
    }
}
