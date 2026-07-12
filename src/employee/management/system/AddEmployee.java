package employee.management.system;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran =new Random();
    int number = ran.nextInt(111111);
    
    JLabel heading , LabelName , LabelEmail,LabelFname ,LabelDob ,LblEmpId,LabelDesignation,LabelSalary , LabelAddress , LabelPhone,LabelEducation ,LabelAadhar ,LabelEmpId;
    JTextField TfName ,TfFname ,TfSalary , TfPhone , TfEmail , TfAddress , TfDesignation , TfAadhar;
    JButton add,back;
    JDateChooser DcDob;
    JComboBox cbeducation;
    
    AddEmployee()
    {
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       heading = new JLabel("Add Employee Detail");
       heading.setBounds(320,30,500,50);
       heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
       add(heading);
       
       LabelName =  new JLabel("Name");
       LabelName.setBounds(50,150,150,30);
       LabelName.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelName);

       TfName = new JTextField();
       TfName.setBounds(200,150,150,30);
       add(TfName);
       
       LabelFname =  new JLabel("Father's Name");
       LabelFname.setBounds(400,150,150,30);
       LabelFname.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelFname);

       TfFname = new JTextField();
       TfFname.setBounds(600,150,150,30);
       add(TfFname);
       
       LabelDob =  new JLabel("Date Of Birth");
       LabelDob.setBounds(50,200,150,30);
       LabelDob.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelDob);

       DcDob = new JDateChooser();
       DcDob.setBounds(200,200,150,30);
       add(DcDob);
       
       LabelSalary =  new JLabel("Salary");
       LabelSalary.setBounds(400,200,150,30);
       LabelSalary.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelSalary);

       TfSalary = new JTextField();
       TfSalary.setBounds(600,200,150,30);
       add(TfSalary);
       
       LabelAddress =  new JLabel("Address");
       LabelAddress.setBounds(50,250,150,30);
       LabelAddress.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelAddress);

       TfAddress = new JTextField();
       TfAddress.setBounds(200,250,150,30);
       add(TfAddress);
       
       LabelPhone =  new JLabel("Phone");
       LabelPhone.setBounds(400,250,150,30);
       LabelPhone.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelPhone);

       TfPhone = new JTextField();
       TfPhone.setBounds(600,250,150,30);
       add(TfPhone);

       LabelEmail =  new JLabel("Email");
       LabelEmail.setBounds(50,300,150,30);
       LabelEmail.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelEmail);

       TfEmail = new JTextField();
       TfEmail.setBounds(200,300,150,30);
       add(TfEmail);
       
       LabelEducation =  new JLabel("Higest Education");
       LabelEducation.setBounds(400,300,150,30);
       LabelEducation.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelEducation);

       String courses[] = {"BBA","BCA","B.COM","BTech","BA","BSC","MBA","MCA","MA","MTech","M.COM","MSC","PHD"};
       cbeducation = new JComboBox(courses);
       cbeducation.setBackground(Color.WHITE);
       cbeducation.setBounds(600,300,150,30);
       add(cbeducation);
       
       LabelDesignation =  new JLabel("Designation");
       LabelDesignation.setBounds(50,350,150,30);
       LabelDesignation.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelDesignation);

       TfDesignation = new JTextField();
       TfDesignation.setBounds(200,350,150,30);
       add(TfDesignation);
       
       LabelAadhar =  new JLabel("Aadhar Number");
       LabelAadhar.setBounds(400,350,150,30);
       LabelAadhar.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelAadhar);

       TfAadhar = new JTextField();
       TfAadhar.setBounds(600,350,150,30);
       add(TfAadhar);
       
       LabelEmpId =  new JLabel("Employee Id");
       LabelEmpId.setBounds(50,400,150,30);
       LabelEmpId.setFont(new Font("serif",Font.PLAIN,20));
       add(LabelEmpId);

       LblEmpId =  new JLabel(""+ number);
       LblEmpId.setBounds(200,400,150,30);
       LblEmpId.setFont(new Font("serif",Font.PLAIN,20));
       add(LblEmpId);

       add = new JButton("Add Details");
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

    public static void main(String args[])
    {
        new AddEmployee();
    }

   
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() != add)
        {
            setVisible(false);
            new Home();
        }
        else
        {
            String name = TfName.getText();
            String fname = TfFname.getText();
            String dob = ((JTextField) DcDob.getDateEditor().getUiComponent()).getText();
            String salary = TfSalary.getText();
            String address = TfAddress.getText();
            String phone = TfPhone.getText();
            String email =TfEmail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = TfDesignation.getText();
            String aadhar = TfAadhar.getText();
            String empId = LblEmpId.getText();
            
            try{
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added Succesfully");
                setVisible(false);
                new Home();
                
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
 }
