/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import javax.swing.*;
import javax.swing.JRadioButton;
import java.awt.*;
//import java.util.Scanner;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.filechooser.FileSystemView;  
import java.io.*;  
import java.net.URL;  
import javax.swing.filechooser.FileNameExtensionFilter;


 class second extends JFrame implements ActionListener {
      byte[] rawBytes = null;  
      FileInputStream fis = null;  
      int totallength=0;
    JPanel screen2;
    JButton b1,b2,b3;    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,pay;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JRadioButton j1,j2,j3,j4,j5,j6,j7;
    ButtonGroup bg1,bg2;
    JTextArea a1,a2;
    JCheckBox jb1,jb2,jb3,jb4;
    JScrollPane js;
     JFileChooser fileChooser;
    JLabel Source;
    JLabel Destination;
    JComboBox sourcelist;
    JComboBox destinationlist;
    String opten,opeleven;
   public second()
    {
        String sd[]={"Zirakpur","Sector 14","Sector 11","Sector 1","Rock Garden","Rose Garden",
            "Sukhna lake","Mohali","Panchkula"};
        screen2 = new JPanel();
        screen2.setLayout(null);
        screen2.setBounds(40,150,800,400);
        screen2.setBackground(Color.LIGHT_GRAY);
        screen2.setPreferredSize(new Dimension(800, 900));
        add(screen2);
        js = new JScrollPane(screen2);
        screen2.setAutoscrolls(true);
        js.setBounds(40,150,800,400);
        this.add(js);      
       
       
       
       
        l1= new JLabel("Name :");
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l1.setBounds(75,10,500,30);
        screen2.add(l1);
        tf1= new JTextField(30);
        tf1.setFont(new Font("Serif", Font.BOLD, 20));
        tf1.setBounds(400,10,300,30);
        screen2.add(tf1);
       
        l2= new JLabel("Father's Name :");
        l2.setFont(new Font("Serif", Font.BOLD, 20));
        l2.setBounds(75,50,500,30);
        screen2.add(l2);
        tf2= new JTextField(30);
        tf2.setFont(new Font("Serif", Font.BOLD, 20));
        tf2.setBounds(400,50,300,30);
        screen2.add(tf2);
       
       
        l3= new JLabel("Mobile:");
        l3.setFont(new Font("Serif", Font.BOLD, 20));
        l3.setBounds(75,90,500,30);
        screen2.add(l3);
        //JPasswordField value = new JPasswordField();
        //value.setBounds(400,160,300,30);
        //screen2.add(l3);
        tf3= new JTextField(30);
        tf3.setFont(new Font("Serif", Font.BOLD, 20));
        tf3.setBounds(400,90,300,30);
        screen2.add(tf3);
       
        l4= new JLabel("Gender:");
        l4.setFont(new Font("Serif", Font.BOLD, 20));
        l4.setBounds(75,130,500,30);
        screen2.add(l4);
       
       
       
        j1=new JRadioButton("Male");
        j1.setActionCommand("Male");
        j2=new JRadioButton("Female");
        j2.setActionCommand("Female");
        j3=new JRadioButton("Others");
        j3.setActionCommand("Others");
        j1.setBounds(400,130,70,30);
        j2.setBounds(520,130,70,30);
        j3.setBounds(630,130,70,30);
        bg1= new ButtonGroup();
        bg1.add(j1);
        bg1.add(j2);
        bg1.add(j3);
        j1.setSelected(true);
        screen2.add(j1);
        screen2.add(j2);
        screen2.add(j3);
       
        l5= new JLabel("Address:");
        l5.setFont(new Font("Serif", Font.BOLD, 20));
        l5.setBounds(75,170,500,30);
        screen2.add(l5);
        a1=new JTextArea();
        a1.setFont(new Font("Serif", Font.BOLD, 20));
        a1.setBounds(400,170,300,60);
        screen2.add(a1);
           
       
        l6= new JLabel("Email -Id:");
        l6.setFont(new Font("Serif", Font.BOLD, 20));
        l6.setBounds(75,240,300,30);
        screen2.add(l6);
        tf4= new JTextField(30);
        tf4.setFont(new Font("Serif", Font.BOLD, 20));
        tf4.setBounds(400,240,300,30);
        screen2.add(tf4);
       
        l7= new JLabel("Adhar Card Number:");
        l7.setFont(new Font("Serif", Font.BOLD, 20));
        l7.setBounds(75,280,300,30);
        screen2.add(l7);
        tf5= new JTextField(30);
        tf5.setFont(new Font("Serif", Font.BOLD, 20));
        tf5.setBounds(400,280,300,30);
        screen2.add(tf5);
       
         
       
       
        l9= new JLabel("Category:");
        l9.setFont(new Font("Serif", Font.BOLD, 20));
        l9.setBounds(75,320,300,30);
        screen2.add(l9);
        jb1 = new JCheckBox("Student");
        jb2 = new JCheckBox("Govt. Employee");
        jb3 = new JCheckBox("Senior Citizen");
        jb4 = new JCheckBox("Handicapped");
        jb1.setBounds(400,320,150,30);
        jb2.setBounds(400,360,150,30);
        jb3.setBounds(400,400,150,30);
        jb4.setBounds(400,440,150,30);
        screen2.add(jb1);
        screen2.add(jb2);
        screen2.add(jb3);
        screen2.add(jb4);
       
        l10 =new JLabel("Service Type:");
        l10.setFont(new Font("Serif", Font.BOLD, 20));
        l10.setBounds(75,480,300,30);
        screen2.add(l10);
        j4=new JRadioButton("AC");
        j5=new JRadioButton("Non AC");
        j4.setBounds(400,480,70,30);
        j5.setBounds(480,480,70,30);
        bg1= new ButtonGroup();
        bg1.add(j4);
        bg1.add(j5);
        j4.setSelected(true);
        screen2.add(j4);
        screen2.add(j5);
       
        l11 =new JLabel("Route Type:");
        l11.setFont(new Font("Serif", Font.BOLD, 20));
        l11.setBounds(75,520,300,30);
        screen2.add(l11);
        j6=new JRadioButton("All Routes");
        j7=new JRadioButton("Particular Route");
        j6.setBounds(400,520,143,30);
        j7.setBounds(550,520,143,30);
        bg1= new ButtonGroup();
        bg1.add(j6);
        bg1.add(j7);
        j6.setSelected(true);
        screen2.add(j6);
        screen2.add(j7);
        
        Source=new JLabel("Source");
         screen2.add(Source);
          Source.setFont(new Font("Serif", Font.BOLD, 20));
           Source.setBounds(75,560,300,30);
           
            sourcelist=new  JComboBox(sd);
         screen2.add(sourcelist);
             sourcelist.setBounds(400,560,300,30);

           
           
       Destination=new JLabel("Destination");
        screen2.add(Destination);
          Destination.setFont(new Font("Serif", Font.BOLD, 20));
           Destination.setBounds(75,600,300,30);
           
           destinationlist=new JComboBox(sd);
        screen2.add(destinationlist);
        destinationlist.setBounds(400,600,300,30);
         
         
         
        l12 = new JLabel("Signature:");
        l12.setFont(new Font("Serif", Font.BOLD, 20));
        l12.setBounds(75,640,300,30);
        screen2.add(l12);
        a2=new JTextArea();
        a2.setBounds(400,640,175,40);
        screen2.add(a2);
        
       b2= new  JButton("Browse");
        b2.setFont(new Font("Serif", Font.BOLD, 25));
        b2.setBounds(580,640,115,26);
       b2.setForeground(Color.WHITE);
        b2.setBackground(Color.GRAY);
       screen2.add(b2);  
       b2.addActionListener(this);
         
       l13 = new JLabel("Password:");
        l13.setFont(new Font("Serif", Font.BOLD, 20));
        l13.setBounds(75,700,300,30);
        screen2.add(l13);
        
        tf6=new JTextField(15);
        tf6.setForeground(Color.RED);
        tf6.setFont(new Font("Serif", Font.BOLD, 20));
        
         tf6.setBounds(400,700,300,30);
        screen2.add(tf6);
        
       
       
        b1= new JButton("COMPUTE FEE");
        b1.setFont(new Font("Serif", Font.BOLD, 20));
        b1.setBounds(300,750,300,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.red);
       screen2.add(b1);    
       b1.addActionListener(this);
//       
//        JLabel pay=new JLabel("hello ");
//          screen2.add(pay);  
//           pay.setForeground(Color.blue);
//          pay.setBounds(500,750,150,30);
       
        b3= new JButton("PAY AND SAVE");
        b3.setFont(new Font("Serif", Font.BOLD, 20));
        b3.setBounds(250,830,400,30);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.blue);
       screen2.add(b3);    
       b3.addActionListener(this);
       
    }
   
   private void SaveImage(String imagePath) {  
        try {  
//            byte[] rawBytes = null;  
//            FileInputStream fis = null;  
  
//            if (imagePath.equals("No File Uploaded")) {  
//                ClassLoader cl = this.getClass().getClassLoader();  
//                URL resouces = cl.getResource("resources/blank-image.png");  
//                imagePath = resouces.getFile();  
//            }  
  
            File fileObj = new File(imagePath);  
            fis = new FileInputStream(fileObj);  

//  
//            //loading the JdbcOdbc driver for Sql Operations  
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
//            //create and specify the DSN as myCon. and since my sql is using windows  
//authentication that's why i'm not ing  
//            //username and word as the second and third parameter in the getConnectionMethod of DriverManager class  
//            Connection con = DriverManager.getConnection("jdbc:odbc:myCon", "", "");  
//            PreparedStatement st = con.prepareStatement("insert into Employee(EName,EAddress,ESalary,EPhoto) values(?,?,?,?)");  
//            st.setString(1, txtName.getText());  
//            st.setString(2, txtAdd.getText());  
//            st.setFloat(3, salary);  
//            //st.setBinaryStream(4, fis);  
//            int imageLength = Integer.parseInt(String.valueOf(fileObj.length()));  
             totallength = Integer.parseInt(String.valueOf(fileObj.length())); 
//            rawBytes = new byte[imageLength];  
//            fis.read(rawBytes, 0, imageLength);  
            //st.setBinaryStream(4, (InputStream) fis, imageLength);  
//            st.setBytes(4, rawBytes);  
//            int count = st.executeUpdate();  
//            if (count > 0) {  
//                JOptionPane.showMessageDialog(this, "Data Saved Successfully");  
//            } else {  
//                JOptionPane.showMessageDialog(this, "Error Saving Data");  
//            }  
        } catch (HeadlessException | IOException |  NumberFormatException  ex) {  
            JOptionPane.showMessageDialog(this, ex.getMessage());  
        }  
    }  
   
   
   public void actionPerformed(ActionEvent e){
       //inserting data into database named as " USER_DATABASE "
       if(e.getSource()==b1){
       b1.setText("300");
       return;
       } 
      
      if(e.getSource()==b2){
           fileChooser = new JFileChooser("C:\\", FileSystemView.getFileSystemView());  
            fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif", "gif", "bmp"));  
            int returnVal = fileChooser.showOpenDialog(screen2);  
            if (returnVal == JFileChooser.APPROVE_OPTION) {  
                String fileName = fileChooser.getSelectedFile().getName();  
                String extension = fileName.substring(fileName.lastIndexOf("."));  
                if (extension.equalsIgnoreCase(".jpg") || extension.equalsIgnoreCase(".png")  
                        || extension.equalsIgnoreCase(".bmp") || extension.equalsIgnoreCase(".tif") ||extension.equalsIgnoreCase(".jfif") 
                        || extension.equalsIgnoreCase(".gif")) {  
                    a2.setText(fileChooser.getSelectedFile().getPath());  
                     SaveImage(a2.getText());
                } else {  
                    JOptionPane.showMessageDialog(this, "Kindly Select Image File Only",  
"Error", JOptionPane.ERROR_MESSAGE);  
                }  
            } else {  
                a2.setText("No File Uploaded");  
            }  
            return;
      }   //end of button b2 
     
        if(e.getSource()==b3){
       Connection con ;
        Statement st;
        
         
         
        String one=tf1.getText();
        String two=tf2.getText();
       String three=tf3.getText();
        String four=  j1.isSelected()?"Male":(j2.isSelected())?"Female":"Others";
        String five=a1.getText();
        String six=tf4.getText();
        String seven=tf5.getText();
        String eight=j4.isSelected()?"AC":"NONAC";
        String nine=j6.isSelected()?"All Routes":"Particular Route";
        
        String ten=(String) sourcelist.getSelectedItem() ;
        String eleven=(String) destinationlist.getSelectedItem() ;
//        String twelve;
        String teran=tf6.getText();
        String fourteen=jb1.isSelected()?"Student":(jb2.isSelected())?"Govt. Employee":(jb3.isSelected())?"Senior"
                + "Citizen":"Handicapped";
       String fifteen="PAID";
      
       try{
          Class.forName("org.apache.derby.jdbc.ClientDriver");
       }
       catch(ClassNotFoundException ex) {
         System.out.println("Drivers not loaded");
         return;
       }//loading of drivers done
       
       
       
        try 
        {
         con = DriverManager.getConnection("jdbc:derby://localhost:1527/egendb");
         System.out.println("connection built");
          PreparedStatement st1 = (PreparedStatement) con.prepareStatement("Insert into "
                  + "USER_DATABASE(NAME,F_NAME,PH_NO,GENDER,"
                  + "ADDRESS,EMAIL,AADHAR_NUM,"
                  + "SERVICE_TYPE,ROUTE_TYPE,SOURCE,DESTINATION,PASSWORD,CATEGORY,PAID,SIGNATURES) "
                  + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
             st1.setString(1, one);
              st1.setString(2, two);
              st1.setString(3,three);
               st1.setString(4,four);
               st1.setString(5,five);
                st1.setString(6,six);
                 st1.setString(7,seven);
                  st1.setString(8,eight);
                   st1.setString(9,nine);
                   st1.setString(10,ten);
                   st1.setString(11,eleven);
                   st1.setString(12,teran);
                   st1.setString(13,fourteen);
                   st1.setString(14,fifteen);
//                     st1.setBytes(15, rawBytes);  
                     st1.setBinaryStream(15, fis, totallength);
              st1.executeUpdate(); 
               System.out.println("Inserted");
               JOptionPane.showMessageDialog(this, "Data is Inserted");
        }
        catch(SQLException ex1){
            System.out.println("SQL exception occured" + ex1);
            JOptionPane.showMessageDialog(this, "Data not Inserted .Try Again!");
        }
        }
        else{
            System.out.println("Select Button");
        }
       
       //////////////////// end of connection ///////////////////
       
       
       
     this.setVisible(false); 
     
    abc frame=new abc();
    
        JButton b;
        //IMAGE
        b= new JButton(new ImageIcon("C:\\Users\\Navpreet Kaur\\Documents\\NetBeansProjects\\EGEN\\L1.png"));
        b.setBounds(380,17,120,120);
        b.setBackground(Color.YELLOW);
        frame.add(b);
        frame.setTitle("E-GEN LOGIN WINDOW");
        frame.setBounds(300,150,900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
   }
       
    }
   
   
   
   
   
public class Front1{
    public static void main(String[] args) {
        // TODO code application logic here
        //new first();
        second frame= new second();
        //IMAGE
       JButton b= new JButton(new ImageIcon("C:\\Users\\Navpreet Kaur\\Documents\\NetBeansProjects\\EGEN\\L1.png"));    
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



