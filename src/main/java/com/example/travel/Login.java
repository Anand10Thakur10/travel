package com.example.travel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton fpassword ,signup,login;
    JTextField tfusername,tfpassword;
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);


        JPanel p1=new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1=new ImageIcon(Login.class.getResource("/icons/login.png"));
        Image i2 =i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);

        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);

        JLabel lblusername =new JLabel("username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(lblusername);

        tfusername=new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel lblpassword =new JLabel("Password");
        lblpassword.setBounds(60,110,100,25);
        lblpassword.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(lblpassword);

        tfpassword=new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login=new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(66, 245, 179));
        login.setForeground(Color.BLACK);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        p2.add(login);
        signup=new JButton("Signup");
        signup.setBounds(210,200,130,30);
        signup.setBackground(new Color(66, 245, 179));
        signup.setForeground(Color.BLACK);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
        p2.add(signup);

        fpassword=new JButton("Forget Password");
        fpassword.setBounds(150,250,130,30);
        fpassword.setBackground(new Color(66, 245, 179));
        fpassword.setForeground(Color.BLACK);
        fpassword.setBorder(BorderFactory.createEmptyBorder());
        fpassword.addActionListener(this);
        p2.add(fpassword);

        JLabel text =new JLabel("Password not remember...?");
        text.setBounds(300,300,150,20);
        text.setForeground(Color.RED);
        p2.add(text);



        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String username=tfusername.getText();
            String Password=tfpassword.getText();
            String query="select * from account where username='"+username+"' AND password='"+Password+"'";
            try{
                Conn C=new Conn();
                ResultSet rs=C.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Dashboard(username);
;
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect username or Password");
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();

        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
      new Login();
    }
}
