package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class RemoveEmployee extends JFrame implements ActionListener{
   
    Choice cEmpId;
    JButton delete,back;        
    RemoveEmployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        JLabel LblEmpId = new JLabel("Employee Id");
        LblEmpId.setBounds(50,50,100,30);
        add(LblEmpId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(200,50,150,30);
        add(cEmpId);
        
        try {
            Conn c = new Conn();
            String query = "select *from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                cEmpId.add(rs.getString("empId"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel Labelname = new JLabel("Name");
        Labelname.setBounds(50,100,100,30);
        add(Labelname);
        
        JLabel LblName = new JLabel();
        LblName.setBounds(200,100,100,30);
        add(LblName);
        
        JLabel LabelPhone = new JLabel("Phone");
        LabelPhone.setBounds(50,150,100,30);
        add(LabelPhone);
        
        JLabel LblPhone = new JLabel();
        LblPhone.setBounds(200,150,100,30);
        add(LblPhone);
        
        JLabel LabelEmail = new JLabel("Email");
        LabelEmail.setBounds(50,200,100,30);
        add(LabelEmail);
        
        JLabel LblEmail = new JLabel();
        LblEmail.setBounds(200,200,100,30);
        add(LblEmail);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                LblName.setText(rs.getString("name"));
                LblPhone.setText(rs.getString("phone"));
                LblEmail.setText(rs.getString("email"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie)
            {
                try{
                    Conn c = new Conn();
                    String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next())
                    {
                        LblName.setText(rs.getString("name"));
                        LblPhone.setText(rs.getString("phone"));
                        LblEmail.setText(rs.getString("email"));
                    }
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
            }
         });
                
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 =i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 600 ,370);
        add(image); 
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
       
    }
    
    public static void main(String args[])
    {
        new RemoveEmployee();
    }


    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == delete)
        {
           try{
               Conn c =  new Conn();
               String query ="delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Employee information Deleted sucessfully");
               setVisible(false);
               new Home();
           } catch(Exception e){
               e.printStackTrace();
           }
        }else{
            setVisible(false);
            new Home();
        }
    }

    
}
