import javax.swing.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class flower
{
    JFrame f ;
    ImageIcon flower1,flower2,flower3,flower4;
    JButton b1,b2,b3,b4;
    JLabel i1,i2,i3,i4,p1,p2,p3,p4;
    Statement stn;
   
    
    
    flower()
    {
        f= new JFrame("BOUQUETS");
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(183,249,242));

        // CREATING ICONS 
        flower1 = new ImageIcon("Flowers/tulip.jpg");
        Image im1 = flower1.getImage().getScaledInstance(100, 100, Image.SCALE_REPLICATE);
        ImageIcon flower11 = new ImageIcon(im1);
        JLabel flower12= new JLabel(flower11);

        flower2 = new ImageIcon("Flowers/rose.jpg");
        Image im2 = flower2.getImage().getScaledInstance(100, 100, Image.SCALE_REPLICATE);
        ImageIcon flower21 = new ImageIcon(im2);
        JLabel flower22= new JLabel(flower21);

        flower3 = new ImageIcon("Flowers/lilly.jpg");
        Image im3 = flower3.getImage().getScaledInstance(100, 100, Image.SCALE_REPLICATE);
        ImageIcon flower31 = new ImageIcon(im3);
        JLabel flower32= new JLabel(flower31);

        flower4 = new ImageIcon("Flowers/mixed.jpg");
        Image im4 = flower4.getImage().getScaledInstance(100, 100, Image.SCALE_REPLICATE);
        ImageIcon flower41 = new ImageIcon(im4);
        JLabel flower42= new JLabel(flower41);

        // BUTTONS 
        b1=new JButton("BUY");
        b2=new JButton("BUY"); 
        b3=new JButton("BUY"); 
        b4=new JButton("BUY"); 
        
       

        // LABELS
        i1=new JLabel("TULIP"); p1=new JLabel("PRICE : 650/-");
        i2=new JLabel("ROSE"); p2=new JLabel("PRICE : 600/-");
        i3=new JLabel("LILLY"); p3=new JLabel("PRICE : 500/-");
        i4=new JLabel("MIXED FLOWER"); p4=new JLabel("PRICE : 700/-");
        


        // SET BOUNDS 
        flower12.setBounds(70,50,100,100); b1.setBounds(80,205,80,20);
        flower22.setBounds(280,50,100,100); b2.setBounds(290,205,80,20);
        flower32.setBounds(70,260,100,100); b3.setBounds(80,415,80,20);
        flower42.setBounds(280,260,100,100); b4.setBounds(290,415,80,20);

        i1.setBounds(85,160,100,20); p1.setBounds(85,175,100,20);
        i2.setBounds(275,160,120,20); p2.setBounds(295,175,100,20);
        i3.setBounds(65,370,120,20); p3.setBounds(85,385,100,20);
        i4.setBounds(310,370,100,20); p4.setBounds(295,385,100,20);
        

        // ADDING FRAME 
        f.add(flower12); f.add(flower22); f.add(flower32); f.add(flower42);
        f.add(b1);f.add(b2);f.add(b3);f.add(b4);
        f.add(i1);f.add(p1); f.add(i2); f.add(p2); f.add(i3); f.add(p3); f.add(i4); f.add(p4);
        f.setLayout(null);
        f.setVisible(true);

       
        
    
    b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            
                
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con=DriverManager.getConnection("jdbc:ucanaccess://D://Javaproject//Bouquetshop//bouquetshop.accdb");
            stn=con.createStatement();
           String sq="create table product(proname char(20),proprice char(20))";
            stn.executeUpdate(sq);
           String record="insert into product(proname,proprice)values('Tulip','650')";
            stn.executeUpdate(record);
            con.commit();
           
            stn.close();
            con.close();
            // System.out.print(pname+price);
        }
        catch (Exception se1)
        {
            JOptionPane.showMessageDialog(null,se1);
        }
        pay p = new pay();
            f.dispose();
        }
        });
     b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con=DriverManager.getConnection("jdbc:ucanaccess://D://Javaproject//Bouquetshop//bouquetshop.accdb");
            stn=con.createStatement();
           String sq="create table product(proname char(20),proprice char(20))";
            stn.executeUpdate(sq);
           String record="insert into product(proname,proprice)values('Rose','600')";
            stn.executeUpdate(record);
            con.commit();
           
            stn.close();
            con.close();
            // System.out.print(pname+price);
        }
        catch (Exception se1)
        {
            JOptionPane.showMessageDialog(null,se1);
        }
                pay p = new pay();
                f.dispose();
            // 
            }

        });
     b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con=DriverManager.getConnection("jdbc:ucanaccess://D://Javaproject//Bouquetshop//bouquetshop.accdb");
            stn=con.createStatement();
           String sq="create table product(proname char(20),proprice char(20))";
            stn.executeUpdate(sq);
           String record="insert into product(proname,proprice)values('Lilly','500')";
            stn.executeUpdate(record);
            con.commit();
            
            stn.close();
            con.close();
            // System.out.print(pname+price);
        }
        catch (Exception se1)
        {
            JOptionPane.showMessageDialog(null,se1);
        }
                pay p = new pay();
                f.dispose();
            }
        });
     b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con=DriverManager.getConnection("jdbc:ucanaccess://D://Javaproject//Bouquetshop//bouquetshop.accdb");
            stn=con.createStatement();
           String sq="create table product(proname char(20),proprice char(20))";
            stn.executeUpdate(sq);
           String record="insert into product(proname,proprice)values('Mixed Flower','700')";
            stn.executeUpdate(record);
            con.commit();
           
            stn.close();
            con.close();
            // System.out.print(pname+price);
        }
        catch (Exception se1)
        {
            JOptionPane.showMessageDialog(null,se1);
        }
               pay p = new pay();      
               f.dispose();
            }
        });
    
    }
       
}
class home
{
    public static void main(String args[])
    {
        flower d = new flower();
    }
}