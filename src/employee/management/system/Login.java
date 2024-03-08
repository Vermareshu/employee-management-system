package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername,tfpswd;
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);
         tfusername=new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);
        
        
        JLabel lblpswd=new JLabel("Password");
        lblpswd.setBounds(40,100,100,30);
        add(lblpswd);
        tfpswd=new JTextField();
        tfpswd.setBounds(150,100,150,30);
        add(tfpswd);
        
        JButton login=new JButton("Login");
        login.setBounds(150,160,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
     
     
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
        
    }
    public static void main(String args[]){
    new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            String username=tfusername.getText();
            String pswd=tfpswd.getText();
            
            Conn c=new Conn();
            String query="Select * from login where username='"+username+"' and pswd='"+pswd+"'";
            
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username and password");
                setVisible(false);
            }
            
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }
}
