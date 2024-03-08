package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener{

    Random r=new Random();
    int number=r.nextInt(999999);
    
    JTextField tfname,tffname,tfadd,tfcont,tfmail,tfAN,tfdes,tfsal;
    JDateChooser dcdob;
    JComboBox cbedu;
    JLabel lblID;
    JButton add,back;
    
    AddEmployee(){
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading =new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("san_serif",Font.BOLD,25));
        add(heading);
        
        JLabel lablename=new JLabel("Name");
        lablename.setBounds(50,150,150,30);
        lablename.setFont(new Font("serif",Font.PLAIN,20));
        add(lablename);
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
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
        
        dcdob=new JDateChooser();
        //JDateChooser dsdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        
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
        
        String course[]={"B.Tech","BCA","BBA","B.Com","Diploma","M.tech","MBA"};
        cbedu=new JComboBox(course);
        cbedu.setBounds(600,300,150,30);
        add(cbedu);
        
        
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
        tfAN=new JTextField();
        tfAN.setBounds(600,350,150,30);
        add(tfAN);
        
        JLabel lableID=new JLabel("Employee ID");
        lableID.setBounds(50,400,150,30);
        lableID.setFont(new Font("serif",Font.PLAIN,20));
        add(lableID);
        
        
        lblID=new JLabel(""+number);
        lblID.setBounds(200,400,150,30);
        lblID.setFont(new Font("serif",Font.PLAIN,20));
        add(lblID);
        
        add=new JButton("Add Details");
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
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            String ename=tfname.getText();
            String fname=tffname.getText();
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary=tfsal.getText();
            String address=tfadd.getText();
            String phone=tfcont.getText();
            String email=tfmail.getText();
            String education=(String)cbedu.getSelectedItem();
            String designation=tfdes.getText();
            String aadhar=tfAN.getText();
            String empid=lblID.getText();
            
            try{
                Conn conn=new Conn();
                String query="insert into addemp values('"+ename+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added Successfully");
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
