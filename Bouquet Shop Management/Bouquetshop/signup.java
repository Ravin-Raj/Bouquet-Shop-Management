import javax.swing.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class sign
{
    JFrame f; JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9; JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7; JButton b1,b2;
    // PreparedStatement pstm;
    ResultSet reset;
    String sql;
    JLabel bg;
    sign()
    {
        f=new JFrame("SIGN-UP");
        
        f.setLayout(null);
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ADDING LABELS 
        l1=new JLabel("ELITE BOUQUETS");
        l2=new JLabel("FIRST NAME ");
        l3=new JLabel("LAST NAME ");
        l4=new JLabel("MOBILE ");
        l5=new JLabel("E-MAIL ");
        l6=new JLabel("NEW PASSWORD");
        l7=new JLabel("CONFIRM PASSWORD ");
        l8=new JLabel("ADDRESS ");
        l9=new JLabel("If You Already SIGNED in, Please LOGIN");

        // ADDING TEXTFIELDS
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        tf6=new JTextField();
        tf7=new JTextField();

        b1=new JButton("SIGN-UP");
        b2=new JButton("LOGIN");

        // SETBOUNDS
        l1.setBounds(200,50,200,30); b1.setBounds(200,380,100,25);
        l2.setBounds(50,90,200,30);  tf1.setBounds(180,90,200,30);
        l3.setBounds(50,130,200,30); tf2.setBounds(180,130,200,30);
        l4.setBounds(50,170,200,30); tf3.setBounds(180,170,200,30);
        l5.setBounds(50,210,200,30); tf4.setBounds(180,210,200,30);
        l6.setBounds(50,250,200,30); tf5.setBounds(180,250,200,30);
        l7.setBounds(50,290,200,30); tf6.setBounds(180,290,200,30);
        l8.setBounds(50,330,200,30); tf7.setBounds(180,330,200,30);
        l9.setBounds(50,420,300,30); b2.setBounds(277,425,75,20);
        

        // ADD ON FRAME 
        f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);f.add(l8);
        f.add(tf1); f.add(tf2); f.add(tf3);f.add(tf4); f.add(tf5); f.add(tf6);f.add(tf7);
        f.add(b1);f.add(l9);f.add(b2);

        // ADDING BACKGROUND 
        ImageIcon img = new ImageIcon("b1.jpg");
        bg= new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,500,500);
        f.add(bg);
        f.setVisible(true);

        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // GETTING VALUES 
                String fname=tf1.getText();
                String lname=tf2.getText();
                String mobile=tf3.getText();
                String email=tf4.getText();
                String npass=tf5.getText();
                String cpass=tf6.getText();
                String address=tf7.getText();

                if (npass.equals(cpass))
                {
                    try
                    {
                        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                        Connection conect =DriverManager.getConnection("jdbc:ucanaccess://D://Javaproject//Bouquetshop//bouquetshop.accdb");
                        PreparedStatement ps= conect.prepareStatement("insert into user(first,last,mobile,email,password,cpassword,address) values(?,?,?,?,?,?,?)");
                        ps.setString(1,fname);
                        ps.setString(2,lname);
                        ps.setString(3,mobile);
                        ps.setString(4,email);
                        ps.setString(5,npass);
                        ps.setString(6,cpass);
                        ps.setString(7,address);

                        int ins=ps.executeUpdate();
                        if(ins>0)
                        {
                            JOptionPane.showMessageDialog(null,"REGISTERED ");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"User Not Added");
                        }
                        conect.close(); ps.close();
                    }
                    catch (Exception e1)
                    {
                        JOptionPane.showMessageDialog(null,e1);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Passwords are not same");
                }
                
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae1)
            {
               log l = new log();
             f.dispose();
            }
        });
        
    }
}
public class signup
{
    public static void main(String args[])
    {
        sign s = new sign();
    
    }
}