package com.example.travel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfusername,tfname,tfsquestion,tfsanswer,tfpassword;
    JButton search,retrieve,Back;
    ForgetPassword(){
       setBounds(350,200,850,380);
       getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ForgetPassword.class.getResource("/icons/forgotpassword.jpg"));
        Image i2 =i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);

        JLabel lblusername =new JLabel("username");
        lblusername.setBounds(40,20,100,25);
        lblusername.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(lblusername);

        tfusername=new JTextField();
        tfusername.setBounds(220,20,150,20);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search =new JButton("Search ");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);

        JLabel lblname =new JLabel("Name");
        lblname.setBounds(40,60,100,25);
        lblname.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(lblname);

        tfname=new JTextField();
        tfname.setBounds(220,60,150,20);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblquestion =new JLabel("security question");
        lblquestion.setBounds(40,100,150,25);
        lblquestion.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(lblquestion);

        tfsquestion=new JTextField();
        tfsquestion.setBounds(220,100,150,20);
        tfsquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfsquestion);

        JLabel lblanswer =new JLabel("security answer");
        lblanswer.setBounds(40,140,150,25);
        lblanswer.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(lblanswer);

        tfsanswer=new JTextField();
        tfsanswer.setBounds(220,140,150,20);
        tfsanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfsanswer);

        retrieve =new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40,180,150,25);
        lblpassword.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(lblpassword);

        tfpassword=new JTextField();
        tfpassword.setBounds(220,180,150,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        Back =new JButton("Back");
        Back.setBackground(Color.GRAY);
        Back.setForeground(Color.WHITE);
        Back.setBounds(150,230,100,25);
        Back.addActionListener(this);
        p1.add(Back);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==search){

      try{
       String query="select * from account where username='"+tfusername.getText()+"'";
       Conn c=new Conn();
       ResultSet rs =c.s.executeQuery(query);
       while(rs.next()){
        tfname.setText(rs.getString("name"));
        tfsquestion.setText(rs.getString("security"));
       }
      }catch (Exception e){
       e.printStackTrace();
      }
     }else if(ae.getSource()==retrieve){
      try{
       String query="select * from account where answer='"+tfsanswer.getText()+"'AND username='"+tfusername.getText()+"'";
       Conn c=new Conn();
       ResultSet rs =c.s.executeQuery(query);
       while(rs.next()){
        tfpassword.setText(rs.getString("password"));

       }
      }catch (Exception e){
       e.printStackTrace();
      }

     }else{
      setVisible(false);
      new Login();
     }

    }

    public static void main(String[] args) {
        new ForgetPassword();

    }
}
