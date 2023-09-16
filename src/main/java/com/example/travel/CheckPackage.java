package com.example.travel;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    CheckPackage(){

        String[] package1={"Gold Package","6 Days and 7 Nights","Air Fair","2 Day city tour","Daily Buffet","Welcome Kit on Arrival","Full day 3 Island cruses","English Spiking Guide","Book Now","Summer Special ","120000/- ","package1.jpg"};
        String[] package2={"Silver Package","4 Days and 6 Nights","Airport Assistance","Day city tour","Daily Buffet one time","Welcome Drinks on Arrival","Full day 2 Island cruses","English Spiking Guide for half tour","Book Now","Summer Special ","100000/- ","package2.jpg"};
        String[] package3={"Bronze Package","3 Days and 5 Nights","cab Assistance","Half city tour","2 day Daily Buffet","Welcome Bucky on Arrival","Full day 1 Island cruses"," No English Spiking Guide","Book Now","Winter Special ","50000/- ","package3.jpg"};


        setBounds(450,200,900,600);

        JTabbedPane tab =new JTabbedPane();
        JPanel p1=createPackage(package1);
        tab.addTab("Package 1",null,p1);

        JPanel p2=createPackage(package2);
        tab.addTab("Package 2",null,p2);

        JPanel p3=createPackage(package3);
        tab.addTab("Package 3",null,p3);

        add(tab);
        //setLayout(null);

        setVisible(true);
    }
    public  JPanel createPackage(String[] pack){


        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);

        JLabel l1=new JLabel(pack[0]);
        l1.setBounds(50,5,300,30);
        l1.setForeground((Color.ORANGE));
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l1);



        JLabel l2=new JLabel(pack[1]);
        l2.setBounds(30,60,300,30);
        l2.setForeground(Color.CYAN);
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l2);

        JLabel l3=new JLabel(pack[2]);
        l3.setBounds(30,110,300,30);
        l3.setForeground(Color.PINK);
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l3);

        JLabel l4=new JLabel(pack[3]);
        l4.setBounds(30,160,300,30);
        l4.setForeground(Color.GREEN);
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l4);


        JLabel l5=new JLabel(pack[4]);
        l5.setBounds(30,210,300,30);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l5);

        JLabel l6=new JLabel(pack[5]);
        l6.setBounds(30,260,300,30);
        l6.setForeground(Color.yellow);
        l6.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l6);

        JLabel l7=new JLabel(pack[6]);
        l7.setBounds(30,310,300,30);
        l7.setForeground(Color.GREEN);
        l7.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l7);

        JLabel l8=new JLabel(pack[7]);
        l8.setBounds(30,360,300,30);
        l8.setForeground(Color.PINK);
        l8.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l8);

        JLabel l9=new JLabel("Book Now");
        l9.setBounds(30,410,300,30);
        l9.setForeground(Color.MAGENTA);
        l9.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l9);

        JLabel l10=new JLabel(pack[9]);
        l10.setBounds(60,460,300,30);
        l10.setForeground(Color.RED);
        l10.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l10);

        JLabel l11=new JLabel(pack[10]);
        l11.setBounds(400,460,300,30);
        l11.setBackground(Color.BLUE);
        l11.setForeground(Color.RED);
        l11.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l11);

        ImageIcon i1=new ImageIcon(ForgetPassword.class.getResource("/icons/"+pack[11]));
        Image i2 =i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,20,500,300);
        p1.add(image);

        return p1;


    }
    public static void main(String[] args) {
        new CheckPackage();
    }
}
