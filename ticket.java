/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
////We need the library below to write the final PDF file which has our image converted to PDF
//import java.io.FileOutputStream;
////The image class which will hold the input image
//import com.itextpdf.text.Image;
////PdfWriter object to write the PDF document
//import com.itextpdf.text.pdf.PdfWriter;
////Document object to add logical image files to PDF
//import com.itextpdf.text.Document;

class screenticket extends JFrame implements ActionListener {
    JPanel screen6;
    JLabel[] labels=new JLabel[10];
    JTextField[] tf=new JTextField[10];
    JButton download;
    String name,fair,passwd;
    
    public void getinfo(String n,String f,String p){
        name=n;
        fair=f;
        passwd=p;
        System.out.println(name+" " +fair+""+passwd);

    }
    public  screenticket()
    {
        
        System.out.println(name+"and " +fair+"and "+passwd);
        screen6=new JPanel();
        screen6.setLayout(null);
       screen6.setBounds(300,150,900,600);
       screen6.setBackground(Color.LIGHT_GRAY);
        add(screen6);
        
        for(int i=1;i<=9;i++)
        {
            labels[i] =new JLabel(" "+i);
             tf[i] = new JTextField(15);
        }
        
        labels[1].setText("DEPOT NO:");
         labels[1].setFont(new Font("Serif", Font.BOLD, 20));
        labels[1].setBounds(75,45,500,30);
        screen6.add(labels[1]);
      
        
         
        tf[1].setBounds(400,45,300,30);
        screen6.add(tf[1]);
          tf[1].setText("Depot-4");
        
         labels[2].setText("TICKET NO:");
         labels[2].setFont(new Font("Serif", Font.BOLD, 20));
        labels[2].setBounds(75,100,500,30);
        screen6.add(labels[2]);
         
        
          tf[2].setBounds(400,100,300,30);
        screen6.add(tf[2]);
            tf[2].setText("TICKET-15312");
        
        labels[6]=new JLabel("Amount");
        labels[6].setForeground(Color.BLUE);
         labels[6].setFont(new Font("Serif", Font.BOLD, 30));
         labels[6].setBounds(300,150,500,30);
         screen6.add(labels[6]);
        
         
         labels[7]=new JLabel("hello ");
        labels[7].setForeground(Color.red);
         labels[7].setFont(new Font("Serif", Font.BOLD, 20));
         labels[7].setBounds(450,150,500,30);
         screen6.add(labels[7]);
         labels[7].setText(String.valueOf(fair));
      

   
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy  HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
   System.out.println(dtf.format(now));  
  

          labels[3].setText("ISSUE DATE AND TIME");
           labels[3].setFont(new Font("Serif", Font.BOLD, 20));
        labels[3].setBounds(75,200,500,30);
        screen6.add(labels[3]);
        
          tf[3].setBounds(400,200,300,30);
        screen6.add(tf[3]);
        tf[3].setText(dtf.format(now));
        
          labels[4].setText("NAME:");
          labels[4].setFont(new Font("Serif", Font.BOLD, 20));
        labels[4].setBounds(75,250,500,30);
        screen6.add(labels[4]);
        
          tf[4].setBounds(400,250,300,30);
          tf[4].setText(String.valueOf(name));
        screen6.add(tf[4]);
        
        
          labels[5].setText("SIGNATURE:");
          labels[5].setFont(new Font("Serif", Font.BOLD, 20));
        labels[5].setBounds(75,300,500,30);
        screen6.add(labels[5]);
        
//          tf[5].setBounds(400,300,300,30);
//        screen6.add(tf[5]);
        
        download = new JButton("UPDATE");
       download.setFont(new Font("Serif", Font.BOLD, 30));
         download.setBounds(300,400,250,50);
         download.setForeground(Color.WHITE);
           download.setBackground(Color.RED);
         screen6.add(download);
         download.addActionListener(this);
    addWindowListener(new WindowAdapter() {
   
        @Override
        public void windowOpened(WindowEvent e) {
             tf[4].setText(String.valueOf(name));
             labels[7].setText(String.valueOf(fair));
             download.setText("DOWNLOAD");
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
          PreparedStatement ps=con.prepareStatement("select SIGNATURES from USER_DATABASE "
                  + "where NAME=? and PASSWORD=?");  
          ps.setString(1,name);
           ps.setString(2,passwd);
         rs=ps.executeQuery();  
if(rs.next()){//now on 1st row  
              
Blob b=rs.getBlob(1);//1 means 1st column data  
byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  
    
FileOutputStream fout=new FileOutputStream("d:\\sonoo.jpg");  
fout.write(barr);  
              

fout.close();  

 JButton sign= new JButton(new ImageIcon("d:\\sonoo.jpg"));
        sign.setBounds(400,300,300,90);
        sign.setBackground(Color.LIGHT_GRAY);
        screen6.add(sign);
        }
        }    catch(Exception ex1){
            System.out.println("SQL exception occured" + ex1);
//            JOptionPane.showMessageDialog(this, "Data not Inserted .Try Again!");
        }
        }


    });
    }//end of constructor
      public void actionPerformed(ActionEvent e)
      {
//           public final long serialVersionUID = 1L;
     
       ///////////////////////////////////////////////
        try {
//            Thread.sleep(120);
            Robot r = new Robot();
  
            // It saves screenshot to desired path
            String path = "C:\\Users\\Navpreet Kaur\\Desktop\\Shot.jpg";
  
            // Used to get ScreenSize and capture image
            Rectangle capture = 
            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage Image = r.createScreenCapture(capture);
            ImageIO.write(Image, "jpg", new File(path));
            System.out.println("Screenshot saved");
        }
        catch (AWTException | IOException ex) {
            System.out.println(ex);
        }
    

          ///////////////////////////////////////////
////   try (BufferedInputStream inputStream = new BufferedInputStream(new URL("http://example.com/my-file-path.txt").openStream());
//          try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\Navpreet Kaur\\Documents\\NetBeansProjects\\start\\src\\start\\ticket.java"));
////  FileOutputStream fileOS = new FileOutputStream("/Users/username/Documents/file_name.txt"))
//        FileOutputStream fileOS = new FileOutputStream("C:\\Users\\Navpreet Kaur\\Desktop\\ticket.txt"))
//          
//    byte data[] = new byte[1024];
//    int byteContent;
//    while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
//        fileOS.write(data, 0, byteContent);
//    }
//} catch (IOException eve) {
//    // handles IO exceptions
//}
   }

}//end of class

public class ticket{ 
    public static void main(String[] args) {
          screenticket frame=new screenticket();
         JButton b= new JButton(new ImageIcon("C:\\Users\\Navpreet Kaur\\Documents\\NetBeansProjects\\EGEN\\L1.png"));
        b.setBounds(700,17,120,120);
        b.setBackground(Color.YELLOW);
        frame.add(b);
       frame.setTitle("E-GEN Online Payment Window");
       frame.setBounds(0,0,2000,1600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

      
    }}
