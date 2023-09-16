package com.example.travel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel labelusername,labelName;
    JComboBox comboId;
    JTextField tfnumber,tfcountry ,tfaddress,tfphone,tfemail,tfId,tfgender;
    JRadioButton rmale,rfemale;
    JButton Add,Back;

    UpdateCustomer(String username){
        setBounds(500,200,850,550);
        setLayout(null);

        JLabel text=new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(text);

        JLabel lblusername=new JLabel("username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername=new JLabel("username");
        labelusername.setBounds(30,50,150,25);
        add(labelusername);

        JLabel lbluserId=new JLabel("ID Proof");
        lbluserId.setBounds(30,90,150,25);
        add(lbluserId);

        tfId=new JTextField();
        tfId.setBounds(220,90,150,25);
        add(tfId);

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

        tfgender =new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);


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

        Add=new JButton("UPDATE");
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.white);
        Add.setBounds(70,430,100,25);
        Add.addActionListener( this);
        add(Add);

        Back=new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.setBounds(180,430,100,25);
        Back.addActionListener((ActionListener) this);
        add(Back);

        ImageIcon i1=new ImageIcon(ForgetPassword.class.getResource("/icons/update.png"));
        Image i2 =i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,100,450,300);
        add(image);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where username='"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelName.setText(rs.getString("name"));
                tfId.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Add){
            String username=labelusername.getText();
            String id = tfId.getText();
            String number =tfnumber.getText();
            String name=labelName.getText();
            String gender=tfgender.getText();
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();

            try{
                Conn c=new Conn();
                String query="update into customer set username='"+username+"',id='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Details updated Successfully ");
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
        new UpdateCustomer("");
    }
}
