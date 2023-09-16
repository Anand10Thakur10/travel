package com.example.travel;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    public void run(){
        try{
            for(int i=1;i<=101;i++){
                int max=bar.getMaximum();
                int Value=bar.getValue();
                if(Value<max){
                    bar.setValue(bar.getValue()+1);
                }else{
                    setVisible(false);
                }
                Thread.sleep(50);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    Loading(){
        t=new Thread(this);

        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("T&t Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);

        JProgressBar bar=new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading =new JLabel("Loading, please wait....");
        loading.setBounds(200,140,150,30);
        loading.setForeground(Color.BLUE);
        loading.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        add(loading);

        JLabel username =new JLabel("welcome ...");
        username.setBounds(20,310,400,40);
        username.setForeground(Color.RED);
        username.setFont(new Font("Raleway",Font.BOLD,15));
        add(username);

        t.start();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Loading();
    }
}
