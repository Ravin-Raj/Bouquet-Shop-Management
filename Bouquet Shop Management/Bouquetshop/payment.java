import javax.swing.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class pay
{
    JLabel l1,l2,l3,l4,l5;
    JFrame f;
    Statement stn;
    String pname="",price="";
    JButton b1;
    pay()
    {
        f= new JFrame("Payment-Checkout");
        f.setSize(500,500);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(183,249,242));

        l1=new JLabel("BILL-CHECKOUT");
        l1.setFont(new Font("SERIF", Font.PLAIN, 24));

        l2=new JLabel("BOUQUET NAME :");
        l3=new JLabel("PRICE :");
        
        l1.setBounds(100,70,500,30);
        l2.setBounds(100,120,100,20); 
        l3.setBounds(100,140,100,20); 

        
    try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection con=DriverManager.getConnection("jdbc:ucanaccess://D://Javaproject//Bouquetshop//bouquetshop.accdb");
        stn=con.createStatement();
        String select="select * from product";
        ResultSet reset=stn.executeQuery(select);
        if(reset.next())
        {
            pname=reset.getString("proname");
            price= reset.getString("proprice");
        }
        
        
        
            stn.close();
            con.close();
            // reset.close();
        }
        catch(Exception sql)
        {
            System.out.println(sql);
        }
        l4=new JLabel(pname);
        l5=new JLabel(price);
        l4.setBounds(200,120,50,20);
        l5.setBounds(200,140,50,20);

        b1= new JButton("Pay");
        b1.setBounds(200,160,150,30);
        f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(b1);
        b1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    try
                {
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    Connection con=DriverManager.getConnection("jdbc:ucanaccess://D://Javaproject//Bouquetshop//bouquetshop.accdb");
                    stn=con.createStatement();
                    String sq="drop table product";
                    stn.executeUpdate(sq);
                    
                    con.commit();
                   
                    stn.close();
                    con.close();
                    // System.out.print(pname+price);
                }
                catch (Exception se1)
                {
                    JOptionPane.showMessageDialog(null,se1);
                }
                check c = new check();
                f.dispose();
            }
            
            });
        f.setVisible(true);
         
    }
}
class payment
{
    public static void main(String args[])
    {
        pay p = new pay();
    }
}











