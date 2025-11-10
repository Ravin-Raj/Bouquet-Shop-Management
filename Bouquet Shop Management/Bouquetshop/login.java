import javax.swing.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class log  
{
    JFrame f; JLabel l1,l2,l3,l4; JTextField tf1,tf2; JButton b1,b2;
    PreparedStatement pstm;
    ResultSet reset;
    String sql;
    JLabel bg;

    log()
    {
        f=new JFrame("LOGIN");
        
        f.setLayout(null);
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ADDING LABELS 
        l1=new JLabel("BLOOMING BLOSSOMS");
        l2=new JLabel("MOBILE");
        l3=new JLabel("PASSWORD");
        l4=new JLabel("If You Didn't REGISTER , Please SIGN-UP");

        // ADDING TEXTFIELDS
        tf1=new JTextField();
        tf2=new JTextField();

        b1=new JButton("LOGIN");
        b2=new JButton("SIGN-UP");

        l1.setBounds(200,80,200,30); b1.setBounds(200,240,100,35);
        l2.setBounds(50,130,200,30);  tf1.setBounds(180,130,200,30);
        l3.setBounds(50,170,200,30); tf2.setBounds(180,170,200,30);
        l4.setBounds(50,364,450,20); b2.setBounds(280,363,100,20);

        f.add(l1);f.add(l2);f.add(l3);f.add(l4);
        f.add(tf1); f.add(tf2);
        f.add(b1);f.add(b2);

        // ADDING BACKGROUND 
        ImageIcon img = new ImageIcon("b1.jpg");
        bg= new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,500,500);
        f.add(bg);
        f.setVisible(true);

        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                // GETTING VALUES 
                String mobile=tf1.getText();
                String pass=tf2.getText();

                try
                {
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    Connection conn =DriverManager.getConnection("jdbc:ucanaccess://D://Javaproject//Bouquetshop//bouquetshop.accdb");
                    Statement stmt = conn.createStatement();
                    String query = "SELECT * FROM user WHERE mobile = '" + mobile + "' AND password = '" + pass + "'";

                    ResultSet rs = stmt.executeQuery(query);

                    // Check if the result set has any rows
                    if (rs.next()) 
                    {
                        // JOptionPane.showMessageDialog(null,"Valid User");
                        flower c = new flower();
                      f.dispose();
                    } 
                    else 
                    {
                       JOptionPane.showMessageDialog(null,"Invlaid user please SIGN-UP");
                    }
                    rs.close();
                    stmt.close();
                    conn.close();
                }

                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae2)
            {
               sign s = new sign();
               f.dispose();
            }
        });
        
    }
}
class login
{
    public static void main(String args[])
    {
        log l = new log();
    }
}