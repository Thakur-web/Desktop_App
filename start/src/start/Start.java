/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/////////////////////////////////////////////

/*
 start page
 */
package start;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class starting extends JFrame implements ActionListener{
   
    JButton Startb;
    starting()
    {
        ImageIcon img = new ImageIcon(new ImageIcon
        ("C:\\Users\\Navpreet Kaur\\Documents\\NetBeansProjects\\start\\ctu.jpg").
                getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT));
         JButton background   =   new JButton(img);
         background.setLayout(null);
             background.setBounds(0,0,900,800);
             background.setBackground(Color.LIGHT_GRAY);
             add(background);
        
        Startb=new  JButton("START") ;
        Startb.setBackground(Color.blue);
        Startb.setForeground(Color.WHITE);
        Startb.setBounds(350,350,200,80);
       Startb.setFont(new Font("Serif", Font.BOLD, 40));
       
        background.add(Startb);
      
       Startb.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){
        this.setVisible(false);
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
}//end of start c/ass

public class Start {

          
    public static void main(String[] args) {
         starting frame=new starting();
//            JButton background=new JButton("abc");
//               JButton background   =   new JButton(new ImageIcon("C:\\Users\\Navpreet Kaur\\Documents\\NetBeansProjects\\EGEN\\start.jpg"));
//             background.setBounds(0,0,900,800);
//             background.setBackground(Color.LIGHT_GRAY);
//        frame.add(background);
        frame.setTitle("E-GEN E- ticket Generation");
       
        frame.setBounds(300,150,900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
       
        
    }
    
}
