package hospita.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);


        JTable table = new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel Label1 = new JLabel("Department");
        Label1.setBounds (145,11,105,20);
        Label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Label1);

        JLabel Label2 = new JLabel("Phone Number");
        Label2.setBounds (431,11,105,20);
        Label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Label2);

        JButton back = new JButton("BACK");
        back.setBounds(300,390,130,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });
        setUndecorated(true);
        setSize(680,480);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }


    public static void main(String[] args) {
    new Department();
    }
}