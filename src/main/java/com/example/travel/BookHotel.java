package com.example.travel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {

    Choice cHotel,cac,cFood;
    JTextField tfPersons,tfDays;
    String username;
    JLabel labelUsername,labelId,labelNumber,labelPhone,labelPrice;
    JButton checkPrice,bookHotel,back;
    BookHotel(String username){

        this.username=username;
        setBounds(350,200,1100,600);
        setLayout(null);

        JLabel text=new JLabel("Book Hotel");
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

        JLabel lblSelectPackage=new JLabel("Select Hotel");
        lblSelectPackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblSelectPackage.setBounds(40,110,150,20);
        add(lblSelectPackage);

        cHotel =new Choice();
        cHotel.setBounds(250,110,200,20);
        add(cHotel);

        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from hotel");
            while(rs.next()){
                cHotel.add(rs.getString("name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblPersons=new JLabel("Total persons");
        lblPersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblPersons.setBounds(40,150,150,25);
        add(lblPersons);

        tfPersons =new JTextField("1");
        tfPersons.setBounds(250,150,200,25);
        add(tfPersons);

        JLabel lblDays=new JLabel("Total no. of  Days");
        lblDays.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblDays.setBounds(40,190,150,25);
        add(lblDays);

        tfDays =new JTextField("1");
        tfDays.setBounds(250,190,200,25);
        add(tfDays);

        JLabel lblac=new JLabel("Room type AC or non AC");
        lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblac.setBounds(40,230,150,25);
        add(lblac);

        cac=new Choice();
        cac.add("AC");
        cac.add("NON-AC");
        cac.setBounds(250,230,200,20);
        add(cac);

        JLabel lblFood=new JLabel("Food Included");
        lblFood.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblFood.setBounds(40,270,150,25);
        add(lblFood);

        cFood=new Choice();
        cFood.add("YES");
        cFood.add("NO");
        cFood.setBounds(250,270,200,20);
        add(cFood);


        JLabel lblId=new JLabel("ID");
        lblId.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblId.setBounds(40,310,150,20);
        add(lblId);

        labelId=new JLabel();
        labelId.setBounds(250,310,200,25);
        add(labelId);

        JLabel lblNumber=new JLabel("Number");
        lblNumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblNumber.setBounds(40,350,150,25);
        add(lblNumber);

        labelNumber=new JLabel();
        labelNumber.setBounds(250,350,150,25);
        labelNumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelNumber);

        JLabel lblPhone=new JLabel("Phone");
        lblPhone.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblPhone.setBounds(40,390,150,20);
        add(lblPhone);

        labelPhone=new JLabel();
        labelPhone.setBounds(250,390,200,25);
        add(labelPhone);

        JLabel lblTotal=new JLabel("Total Price");
        lblTotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblTotal.setBounds(40,430,150,25);
        add(lblTotal);

        labelPrice=new JLabel();
        labelPrice.setBounds(250,430,150,25);
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
        checkPrice.setBounds(60,490,120,25);
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookHotel=new JButton("Book Hotel");
        bookHotel.setBounds(200,490,120,25);
        bookHotel.setBackground(Color.BLACK);
        bookHotel.setForeground(Color.WHITE);
        bookHotel.addActionListener(this);
        add(bookHotel);

        back=new JButton("Back");
        back.setBounds(340,490,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(BookHotel.class.getResource("/icons/book.jpg"));
        Image i2 =i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,50,600,300);
        add(image);

        setVisible(true);

    }
    public  void actionPerformed(ActionEvent ae){

        try {
            if (ae.getSource() == checkPrice) {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name='" + cHotel.getSelectedItem() + "' ");
                while (rs.next()) {

                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(tfPersons.getText());
                    int days = Integer.parseInt(tfDays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodSelected = cFood.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodSelected.equals("YES") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelPrice.setText("Rs " + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter valid entry");
                    }
                }
            } else if (ae.getSource() == back) {
                setVisible(false);
                new Dashboard(username);

            }else if(ae.getSource()==bookHotel){
                try{
                    Conn c=new Conn();
                    c.s.executeUpdate("insert into bookHotel values('"+labelUsername.getText()+"','"+cHotel.getSelectedItem()+"','"+tfPersons.getText()+"','"+tfDays.getText()+"','"+cac.getSelectedItem()+"','"+cFood.getSelectedItem()+"','"+labelId.getText()+"','"+labelNumber.getText()+"','"+labelPhone.getText()+"','"+labelPrice.getText()+"')");
                    JOptionPane.showMessageDialog(null,"Hotel Booked Successful");
                    setVisible(false);

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new BookHotel("Anand");
    }
}
