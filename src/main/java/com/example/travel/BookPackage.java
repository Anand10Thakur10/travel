package com.example.travel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

        Choice cpackage;
        JTextField tfPersons;
        String username;
        JLabel labelUsername,labelId,labelNumber,labelPhone,labelPrice;
        JButton checkPrice,bookPackage,back;
    BookPackage(String username){

        this.username=username;
        setBounds(350,200,1100,500);
        setLayout(null);

        JLabel text=new JLabel("Book Package");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblusername.setBounds(40,70,100,20);
        add(lblusername);

         labelUsername=new JLabel();
        labelUsername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelUsername.setBounds(250,70,200,20);
        add(labelUsername);

        JLabel lblSelectPackage=new JLabel("Select Package");
        lblSelectPackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblSelectPackage.setBounds(40,110,150,20);
        add(lblSelectPackage);

        cpackage =new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);

        JLabel lblPersons=new JLabel("Total persons");
        lblPersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblPersons.setBounds(40,150,150,25);
        add(lblPersons);

        tfPersons =new JTextField("1");
        tfPersons.setBounds(250,150,200,25);
        add(tfPersons);

        JLabel lblId=new JLabel("ID");
        lblId.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblId.setBounds(40,190,150,20);
        add(lblId);

        labelId=new JLabel();
        labelId.setBounds(250,190,200,25);
        add(labelId);

        JLabel lblNumber=new JLabel("Number");
        lblNumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblNumber.setBounds(40,230,150,25);
        add(lblNumber);

         labelNumber=new JLabel();
        labelNumber.setBounds(250,230,150,25);
        labelNumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelNumber);

        JLabel lblPhone=new JLabel("Phone");
        lblPhone.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblPhone.setBounds(40,270,150,20);
        add(lblPhone);

        labelPhone=new JLabel();
        labelPhone.setBounds(250,270,200,25);
        add(labelPhone);

        JLabel lblTotal=new JLabel("Total Price");
        lblTotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblTotal.setBounds(40,310,150,25);
        add(lblTotal);

         labelPrice=new JLabel();
        labelPrice.setBounds(250,310,150,25);
        labelPrice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelPrice);

        try {
            Conn conn=new Conn();
            String query ="select * from customer where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                 labelPhone.setText(rs.getString("phone"));

            }

        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
        checkPrice=new JButton("Check Price");
        checkPrice.setBounds(60,380,120,25);
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookPackage=new JButton("Book Package");
        bookPackage.setBounds(200,380,120,25);
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.addActionListener(this);
        add(bookPackage);

        back=new JButton("Back");
        back.setBounds(340,380,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(BookPackage.class.getResource("/icons/bookpackage.jpg"));
        Image i2 =i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);
        setVisible(true);

    }
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkPrice){
            String pack=cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package")){
                cost+=1;
            }else if(pack.equals("Silver Package")){
                cost+=5;
            }else{
                cost+=2;
            }
            int persons=Integer.parseInt(tfPersons.getText());
            cost*=persons;
            labelPrice.setText("Rs "+cost);
        }else if(ae.getSource()==bookPackage){
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into Bookpackage values('"+labelUsername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfPersons.getText()+"','"+labelId.getText()+"','"+labelNumber.getText()+"','"+labelPhone.getText()+"','"+labelPrice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked Successful");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==back){
            setVisible(false);
            new Dashboard(username);

        }
    }

    public static void main(String[] args) {
        new BookPackage("Anand");
    }
}
