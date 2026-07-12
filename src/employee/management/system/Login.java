package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField TfUsername, TfPassword;
    JLabel LblUsername,LblPassword;
    JButton login ;
    
    Login()
    {
      
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);  
        
        LblUsername = new JLabel ("Username");
        LblUsername.setBounds(40,20,100,30);
        add(LblUsername);
        
        TfUsername = new JTextField();
        TfUsername.setBounds(150,20,150,30);
        add(TfUsername);
        
        LblPassword = new JLabel ("Password");
        LblPassword.setBounds(40,70,100,30);
        add(LblPassword);
        
        TfPassword = new JTextField();
        TfPassword.setBounds(150,70,150,30);
        add(TfPassword);
        
        login =  new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 =i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200 ,200);
        add(image);
        
       
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
           String username = TfUsername.getText();
           String password = TfPassword.getText(); 
           
           Conn c = new Conn();
           String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
          
         ResultSet rs = c.s.executeQuery(query);
         if(rs.next()) {
             setVisible(false);
             new Home();
         }else{
             JOptionPane.showMessageDialog(null, "Invalid username or password");
             setVisible(false);
         }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[])
    {
        new Login();
    }
}
