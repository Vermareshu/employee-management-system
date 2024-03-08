package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Splash extends JFrame implements ActionListener{
    Splash(){
     
     JLabel heading=new JLabel("Employee Management System");
     add(heading);
     heading.setBounds(150,30,1200,60);
     heading.setFont(new Font("serif",Font.PLAIN,60));  
     heading.setForeground(Color.RED);
     
     setLayout(null);
     getContentPane().setBackground(Color.WHITE);//use to change bgcolor   
     
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
     Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(50,100,1050,500);
     add(image);
     
     JButton clickHere=new JButton("Click here to Continue");
     clickHere.setBounds(400,400,300,70);
     clickHere.setBackground(Color.BLACK);
     clickHere.setForeground(Color.WHITE);
     clickHere.addActionListener(this);
     image.add(clickHere);
     
     setSize(1170,650);//(height,width)
     setLocation(100,50);//(distance from left,dis from top)
     setVisible(true);
     
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]){
        new Splash();
    }
    
}
