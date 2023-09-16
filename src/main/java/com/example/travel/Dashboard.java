package com.example.travel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addPersonalDetails;
    JButton viewPersonalDetails;
    JButton updatePersonalDetails;
    JButton checkPackages;
    JButton bookPackage;
    JButton viewPackage;
    JButton viewHotels;
    JButton destinations;
    JButton bookHotel;
    JButton viewBookedHotels;
    JButton deletePersonalDetails;
    JButton payments,calculators,notepad,about;
    Dashboard(String username){

        this.username=username;

        //setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);

        ImageIcon i1=new ImageIcon(Dashboard.class.getResource("/icons/dashboard.png"));
        Image i2 =i1.getImage().getScaledInstance(70,50,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(5,0,70,50);
        p1.add(image);

        JLabel heading=new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);

        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

        addPersonalDetails=new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);


        updatePersonalDetails=new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails=new JButton("View Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails=new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackages=new JButton("Check Package");
        checkPackages.setBounds(0,200,300,50);
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackage=new JButton("Book Package");
        bookPackage.setBounds(0,250,300,50);
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage =new JButton("View Packages");
        viewPackage.setBounds(0,300,300,50);
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        viewHotels =new JButton("View Hotels");
        viewHotels.setBounds(0,350,300,50);
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotel =new JButton("Book Hotels");
        bookHotel.setBounds(0,400,300,50);
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        viewBookedHotels =new JButton("View Booked Hotels");
        viewBookedHotels.setBounds(0,450,300,50);
        viewBookedHotels.addActionListener(this);
        p2.add(viewBookedHotels);

        destinations =new JButton("view Destinations");
        destinations.setBounds(0,500,300,50);
        destinations.addActionListener(this);
        p2.add(destinations);

        payments =new JButton("View payments");
        payments.setBounds(0,550,300,50);
        payments.addActionListener(this);
        p2.add(payments);

         calculators=new JButton("calculator");
        calculators.setBounds(0,600,300,50);
        calculators.addActionListener(this);
        p2.add(calculators);

         notepad=new JButton("notepad");
        notepad.setBounds(0,650,300,50);
        notepad.addActionListener(this);
        p2.add(notepad);

        about=new JButton("About");
        about.setBounds(0,700,300,50);
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4=new ImageIcon(Login.class.getResource("/icons/home.jpg"));
        Image i5 =i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(0,0,1650,1000);
        add(image2);

        JLabel text=new JLabel(" T & T management System ");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.PLAIN,55));
        image2.add(text);


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addPersonalDetails){
            new AddCustomer(username);
        }
        else if(ae.getSource()==viewPersonalDetails){
            new ViewCustomer(username);
        }else if (ae.getSource()==updatePersonalDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource()==checkPackages){
            new CheckPackage();
        }else if(ae.getSource()==bookPackage){
            new BookPackage(username);
        }else if(ae.getSource()==viewPackage){
            new ViewPackage(username);
        }else if(ae.getSource()==viewHotels){
            new CheckHotels();
        }else if(ae.getSource()==destinations){
            new Destination();
        }else if(ae.getSource()==bookHotel){
            new BookHotel(username);
        }else if(ae.getSource()== viewBookedHotels){
            new ViewBookedHotel(username);
        }else if(ae.getSource()==payments){
            new Payment();
        }else if(ae.getSource()==calculators){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==about){
            new About();
        }else if(ae.getSource()==deletePersonalDetails){
            new DeleteDetails(username);
        }
    }
    public static void main(String[] args) {
        new Dashboard("username");
    }
}
