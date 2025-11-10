import javax.swing.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class check
{
    JFrame f;
    JLabel l1;
    JRadioButton rb1, rb2, rb3, rb4, rb5;
    ButtonGroup bg;
    JButton b1;

    check()
    { 
        f=new JFrame("Checkout");
        f.setSize(500,500);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(183,249,242));

        l1=new JLabel("CHOOSE YOUR PAYMENT METHOD");
        l1.setFont(new Font("SERIF", Font.PLAIN, 24));
        
        b1=new JButton("CONFIRM");
        

        bg = new ButtonGroup();
        rb1 = new JRadioButton("Credit Card");
        rb2 = new JRadioButton("Debit Card");
        rb3 = new JRadioButton("QR Code");
        rb4 = new JRadioButton("UPI");
        rb5 = new JRadioButton("Net Banking");
        f.add(rb1);
        f.add(rb2);
        f.add(rb3); f.add(rb4); f.add(rb5);

        rb1.setBounds(100,120,200,20);
        rb1.setFont(new Font("SERIF", Font.PLAIN, 20));
        rb1.setBackground(new Color(183,249,242));
        rb2.setBounds(100,150,200,20);
        rb2.setFont(new Font("SERIF", Font.PLAIN, 20));
        rb2.setBackground(new Color(183,249,242));
        rb3.setBounds(100,180,200,20);
        rb3.setFont(new Font("SERIF", Font.PLAIN, 20));
        rb3.setBackground(new Color(183,249,242));
        rb4.setBounds(100,210,200,20);
        rb4.setFont(new Font("SERIF", Font.PLAIN, 20));
        rb4.setBackground(new Color(183,249,242));
        rb5.setBounds(100,240,200,20);
        rb5.setFont(new Font("SERIF", Font.PLAIN, 20));
        rb5.setBackground(new Color(183,249,242));

        b1.setBounds(120,300,100,30);

        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3); bg.add(rb4); bg.add(rb5);
        f.add(l1);f.add(b1);
        
        l1.setBounds(25,70,500,30);
        
        
        f.setVisible(true);

        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if(rb1.isSelected() || rb2.isSelected() ||rb3.isSelected() || rb4.isSelected() || rb5.isSelected())
                {
                    JOptionPane.showMessageDialog(null,"PAYMENT SUCCESSFUL ! THANK YOU VISIT AGAIN");
                    f.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"PLEASE SELECT THE PAYMENT METHOD");
                }
            }
        }
        );
    }
}
class checkout
{
    public static void main(String args[])
    {
        check c = new check();
    }
}