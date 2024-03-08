package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateEmployee extends JFrame implements ActionListener{

    
    JTextField tfeducation,tffname,tfadd,tfcont,tfmail,tfAN,tfdes,tfsal;
    JLabel lblID;
    JButton add,back;
    String empId;
    UpdateEmployee(String empId){
        this.empId=empId;
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading =new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("san_serif",Font.BOLD,25));
        add(heading);
        
        JLabel lablename=new JLabel("Name");
        lablename.setBounds(50,150,150,30);
        lablename.setFont(new Font("serif",Font.PLAIN,20));
        add(lablename);
        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        JLabel lablefname=new JLabel("Father's Name");
        lablefname.setBounds(400,150,150,30);
        lablefname.setFont(new Font("serif",Font.PLAIN,20));
        add(lablefname);
        tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        
        JLabel labledob=new JLabel("Date Of Birth");
        labledob.setBounds(50,200,150,30);
        labledob.setFont(new Font("serif",Font.PLAIN,20));
        add(labledob);
        
        JLabel lbldob=new JLabel();
        //JDateChooser dsdob=new JDateChooser();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        
        JLabel lablesal=new JLabel("Salary");
        lablesal.setBounds(400,200,150,30);
        lablesal.setFont(new Font("serif",Font.PLAIN,20));
        add(lablesal);
        tfsal=new JTextField();
        tfsal.setBounds(600,200,150,30);
        add(tfsal);
        
        JLabel lableadd=new JLabel("Address");
        lableadd.setBounds(50,250,150,30);
        lableadd.setFont(new Font("serif",Font.PLAIN,20));
        add(lableadd);
        tfadd=new JTextField();
        tfadd.setBounds(200,250,150,30);
        add(tfadd);
        
        JLabel lablecont=new JLabel("Contact");
        lablecont.setBounds(400,250,150,30);
        lablecont.setFont(new Font("serif",Font.PLAIN,20));
        add(lablecont);
        tfcont=new JTextField();
        tfcont.setBounds(600,250,150,30);
        add(tfcont);
        
        JLabel lablemail=new JLabel("Email");
        lablemail.setBounds(50,300,150,30);
        lablemail.setFont(new Font("serif",Font.PLAIN,20));
        add(lablemail);
        tfmail=new JTextField();
        tfmail.setBounds(200,300,150,30);
        add(tfmail);
        
        JLabel lableEdu=new JLabel("Highest Qualification");
        lableEdu.setBounds(400,300,150,30);
        lableEdu.setFont(new Font("serif",Font.PLAIN,20));
        add(lableEdu);
        
        //String course[]={"B.Tech","BCA","BBA","B.Com","Diploma","M.tech","MBA"};
        tfeducation=new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        
        JLabel labledes=new JLabel("Designation");
        labledes.setBounds(50,350,150,30);
        labledes.setFont(new Font("serif",Font.PLAIN,20));
        add(labledes);
        tfdes=new JTextField();
        tfdes.setBounds(200,350,150,30);
        add(tfdes);
        
        JLabel lableAN=new JLabel("Aadhar Number");
        lableAN.setBounds(400,350,150,30);
        lableAN.setFont(new Font("serif",Font.PLAIN,20));
        add(lableAN);
        JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
        
        JLabel lableID=new JLabel("Employee ID");
        lableID.setBounds(50,400,150,30);
        lableID.setFont(new Font("serif",Font.PLAIN,20));
        add(lableID);
        
        
        lblID=new JLabel();
        lblID.setBounds(200,400,150,30);
        lblID.setFont(new Font("serif",Font.PLAIN,20));
        add(lblID);
        
        try{
            Conn c=new Conn();
            String query="select * from addemp where empId='"+empId+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("ename"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfadd.setText(rs.getString("address"));
                tfsal.setText(rs.getString("salary"));
                tfcont.setText(rs.getString("phone"));
                tfmail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdes.setText(rs.getString("designation"));
                lblID.setText(rs.getString("empid"));
                lblaadhar.setText(rs.getString("aadhar"));
                
            }
        }
        catch(Exception e){e.printStackTrace();}
        
        add=new JButton("Update Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
       
        back=new JButton("Back");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
       
        
    }
    public static void main(String ars[]){
        new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
           // String ename=tfname.getText();
            String fname=tffname.getText();
            //String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary=tfsal.getText();
            String address=tfadd.getText();
            String phone=tfcont.getText();
            String email=tfmail.getText();
            String education=tfeducation.getText();
            String designation=tfdes.getText();
            //String aadhar=tfAN.getText();
            //String empid=lblID.getText();
            
            try{
                Conn conn=new Conn();
                String query="update addemp set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empid='"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
                new Home();
            
            }
            
            
            catch(Exception e){e.printStackTrace();}
        }else{
            setVisible(false);
            new Home();
        }
        }
}
