package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JLabel  LabelEmpId ;
    JTextField TfEducation, TfFname , TfSalary , TfPhone , TfEmail , TfAddress , TfDesignation, TfAadhar ;
    JButton add,back;
    String empId;
    
    UpdateEmployee(String empId)
    {
       this.empId = empId;
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel heading = new JLabel("Update Employee Detail");
       heading.setBounds(320,30,500,50);
       heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
       add(heading);
       
       JLabel LabelName =  new JLabel("Name");
       LabelName.setBounds(50,150,150,30);
       LabelName.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelName);

       JLabel LblName = new JLabel();
       LblName.setBounds(200,150,150,30);
       add(LblName);
       
       JLabel LabelFname =  new JLabel("Father's Name");
       LabelFname.setBounds(400,150,150,30);
       LabelFname.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelFname);

       TfFname = new JTextField();
       TfFname.setBounds(600,150,150,30);
       add(TfFname);
       
       JLabel LabelDob =  new JLabel("Date Of Birth");
       LabelDob.setBounds(50,200,150,30);
       LabelDob.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelDob);

       JLabel LblDob = new JLabel();
       LblDob.setBounds(200,200,150,30);
       add(LblDob);
       
       JLabel LabelSalary =  new JLabel("Salary");
       LabelSalary.setBounds(400,200,150,30);
       LabelSalary.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelSalary);

       TfSalary = new JTextField();
       TfSalary.setBounds(600,200,150,30);
       add(TfSalary);
       
       JLabel LabelAddress =  new JLabel("Address");
       LabelAddress.setBounds(50,250,150,30);
       LabelAddress.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelAddress);

       TfAddress = new JTextField();
       TfAddress.setBounds(200,250,150,30);
       add(TfAddress);
       
       JLabel LabelPhone =  new JLabel("Phone");
       LabelPhone.setBounds(400,250,150,30);
       LabelPhone.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelPhone);

       TfPhone = new JTextField();
       TfPhone.setBounds(600,250,150,30);
       add(TfPhone);

       JLabel LabelEmail =  new JLabel("Email");
       LabelEmail.setBounds(50,300,150,30);
       LabelEmail.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelEmail);

       TfEmail = new JTextField();
       TfEmail.setBounds(200,300,150,30);
       add(TfEmail);
       
       JLabel LabelEducation =  new JLabel("Higest Education");
       LabelEducation.setBounds(400,300,150,30);
       LabelEducation.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelEducation);

       TfEducation = new JTextField();
       TfEducation.setBounds(600,300,150,30);
       add(TfEducation);
       
       JLabel LabelDesignation =  new JLabel("Designation");
       LabelDesignation.setBounds(50,350,150,30);
       LabelDesignation.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelDesignation);

       TfDesignation = new JTextField();
       TfDesignation.setBounds(200,350,150,30);
       add(TfDesignation);
       
       JLabel LabelAadhar =  new JLabel("Aadhar Number");
       LabelAadhar.setBounds(400,350,150,30);
       LabelAadhar.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelAadhar);

       JLabel LblAadhar = new JLabel();
       LblAadhar.setBounds(600,350,150,30);
       add(LblAadhar);
       
       LabelEmpId =  new JLabel("Employee Id");
       LabelEmpId.setBounds(50,400,150,30);
       LabelEmpId.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelEmpId);

       JLabel LblEmpId =  new JLabel();
       LblEmpId.setBounds(200,400,150,30);
       LblEmpId.setFont(new Font("serif",Font.PLAIN,20));
       add(LblEmpId);
       
       
            try {
                Conn c = new Conn();
                String query = "select * from employee where empId = '"+empId+"'";
                ResultSet rs =c.s.executeQuery(query);
 
           while(rs.next()){
               LblName.setText(rs.getString("name"));
               TfFname.setText(rs.getString("fname"));
               LblDob.setText(rs.getString("dob"));
               TfSalary .setText(rs.getString("salary"));
               TfAddress.setText(rs.getString("address"));
               TfPhone.setText(rs.getString("phone"));
               TfEmail.setText(rs.getString("email"));
               TfEducation.setText(rs.getString("education"));
               TfDesignation.setText(rs.getString("designation"));
               LblAadhar.setText(rs.getString("aadhar"));
               LblEmpId.setText(rs.getString("empId"));
               
                             
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }

       add = new JButton("Update Details");
       add.setBounds(250,550,150,40);
       add.addActionListener(this);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
       add(add);
       
       back = new JButton("Back");
       back.setBounds(450,550,150,40);
       back.addActionListener(this);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       add(back);
       
       
       
       
       
       setSize(900,700);
       setLocation(300,50);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add)
        {
            String fname = TfFname.getText();
            String salary = TfSalary.getText();
            String address = TfAddress.getText();
            String phone = TfPhone.getText();
            String email =TfEmail.getText();
            String education = TfEducation.getText();
            String designation = TfDesignation.getText();
                        
            try{
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', Phone ='"+phone+"', email='"+email+"', education='"+education+"', designation  = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated Succesfully");
                setVisible(false);
                new Home();
                
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[])
    {
        new UpdateEmployee("");
    }
    
 }
