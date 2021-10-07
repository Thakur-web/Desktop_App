/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import javax.swing.*;
import java.awt.*;
//import java.util.Scanner;
import java.awt.event.*;
import java.sql.*;

class abc extends JFrame implements ActionListener {
    JPanel screen1;
    JButton b1,b2;    
    JLabel l1,l2;
    JTextField tf1,tf2; 
    JPasswordField value;
    //action handler
    
    
   public abc()
    {
         
        screen1 = new JPanel();
        screen1.setLayout(null);
        screen1.setBounds(40,150,800,400);
        screen1.setBackground(Color.LIGHT_GRAY);
        add(screen1);
        
        
        
        b1= new JButton("LOGIN");
        b1.setFont(new Font("Serif", Font.BOLD, 30));
        b1.setBounds(180,275,155,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.RED);
       screen1.add(b1);
       b1.addActionListener(this);
      
      // b1.addActionListener(this);
       //getContentPane().add(b1);
        //pack();
        
        
        
        b2 = new JButton("SIGNUP");
        b2.setFont(new Font("Serif", Font.BOLD, 30));
        b2.setBounds(380,275,155,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.GREEN);
       screen1.add(b2);
       b2.addActionListener(this);
        
        
        
        l1= new JLabel("USERNAME :");
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l1.setBounds(75,105,500,30);
        screen1.add(l1);
        tf1= new JTextField(30);
        tf1.setBounds(400,105,300,30);
        screen1.add(tf1);
        
        
        l2= new JLabel("PASSWORD :");
        l2.setFont(new Font("Serif", Font.BOLD, 20));
        l2.setBounds(75,160,500,30);
        screen1.add(l2);
        value = new JPasswordField();
        value.setBounds(400,160,300,30);
        screen1.add(value);
        //tf2= new JTextField(30);
        //tf2.setBounds(400,160,300,30);
        //screen1.add(tf2);
    }
        
    
    
   public void actionPerformed(ActionEvent e) {
 if( e.getSource()==b1){
     
            String paid,source,destination,fair,route,username,passwd;
            String userText;
            String pwdText;
            userText = tf1.getText();
            pwdText = value.getText();
            Connection con ;
            Statement st ;
            ResultSet rs=null;
        try 
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch(ClassNotFoundException ex) 
        {
         System.out.println("Driver Class not found "+ ex);
        } 
       try 
        {
         con = DriverManager.getConnection("jdbc:derby://localhost:1527/egendb");
         System.out.println("connection built");
       /* st = con.createStatement(); 
         String qstring="SELECT * FROM firsttable WHERE UNAME= '"+userText+"' and pword= '"+pwdText+"' ";
         System.out.println(qstring);
        rs = st.executeQuery(qstring);*/
       
       PreparedStatement st1 = (PreparedStatement) con.prepareStatement("Select paid,name, "
               + "password,source,destination,route_type from user_database where name=? and password=?");

                    st1.setString(1, userText);
                    st1.setString(2, pwdText);
                     rs = st1.executeQuery(); 
        System.out.println("statement executed");
        if (rs.next()==false)
            {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        
        else{
            paid=rs.getString(1);
            username=rs.getString(2);
            passwd=rs.getString(3);
            source=rs.getString(4);
             destination=rs.getString(5);
             route=rs.getString(6);
            System.out.println(paid);
     if(paid.equals("PAID"))
     {
//        System.out.println(rs.getString(2)+"  "+ rs.getString(3)); 
        JOptionPane.showMessageDialog(this, "Login Successful");
         this.setVisible(false);
         
         through frame=new through();
    
         JButton b= new JButton(new ImageIcon("C:\\Users\\Navpreet Kaur\\Documents\\NetBeansProjects\\EGEN\\L1.png"));
        b.setBounds(380,17,120,120);
        b.setBackground(Color.YELLOW);
        frame.add(b);
        
           frame.setTitle("E-GEN");
     frame.setBounds(300,150,900,600);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

fair="0";
            
        frame.getRouteInfo(source,destination,fair,username,route,passwd);
        
        }else{
                 JOptionPane.showMessageDialog(this, "You have not paid your Fee");

                }
        
        }//end of if-else
       
   
    }
    catch(SQLException ex1)
    {
         System.out.println("SQL exception occured" + ex1);
    }
        
        
     
     
     ////////////////////////////////////////////////////////////////////////////////////////////////
     
   
 }
 
 if( e.getSource()==b2){
  this.setVisible(false);
   second frame= new second();
        //IMAGE
       JButton b= new JButton(new ImageIcon("C:\\Users\\Navpreet Kaur\\Documents\\NetBeansProjects\\EGEN\\L1.png"));    
        b.setBounds(380,17,120,120);
        b.setBackground(Color.YELLOW);
        frame.add(b);
        frame.setTitle("E-GEN Registration Window");
        frame.setBounds(300,150,900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
 }
     
   }  
    }
    
public class first{ 
    public static void main(String[] args) {
        // TODO code application logic here
        //new first();
        abc frame=new abc();
        JButton b;
        //IMAGE
        b= new JButton(new ImageIcon("C:\\Users\\Navpreet Kaur\\Documents\\NetBeansProjects\\EGEN\\L1.png"));
        b.setBounds(380,17,120,120);
        b.setBackground(Color.YELLOW);
        frame.add(b);
        frame.setTitle("E-GEN Online Payment Window");
        frame.setBounds(300,150,900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        
    }
    
}
    