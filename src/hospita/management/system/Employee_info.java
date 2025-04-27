package hospita.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {

    Employee_info(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,820,510);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,800,400);
        table.setBackground(new Color(109,164,170));
       table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);


        try{
            conn c = new conn();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel Label1 = new JLabel("Name");
        Label1.setBounds (41,9,70,20);
        Label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Label1);

        JLabel Label2 = new JLabel("Age");
        Label2.setBounds (180,9,70,20);
        Label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Label2);

        JLabel Label3 = new JLabel("Phone Number");
        Label3.setBounds (350,9,150,20);
        Label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Label3);

        JLabel Label4 = new JLabel("Salary");
        Label4.setBounds (550,9,150,20);
        Label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Label4);

        JLabel Label5 = new JLabel("Gmail");
        Label5.setBounds (710,9,150,20);
        Label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Label5);

        JLabel Label6 = new JLabel("Aadhar Number");
        Label6.setBounds (830,9,150,20);
        Label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Label6);


        JButton back = new JButton("BACK");
        back.setBounds(340,440,130,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        setUndecorated(true);
        setSize(820,510);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Employee_info();
    }
}
