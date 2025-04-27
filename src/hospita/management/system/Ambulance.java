package hospita.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {

    Ambulance(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,900,550);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,700,300);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));




        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel labelID = new JLabel("Name");
        labelID.setBounds(31,11,100,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,14));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        JLabel labelNumber = new JLabel("Gender");
        labelNumber.setBounds(150,11,100,14);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        JLabel labelName1 = new JLabel("Car name");
        labelName1.setBounds(290,11,100,14);
        labelName1.setFont(new Font("Tahoma",Font.BOLD,14));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);

        JLabel labelGender = new JLabel("Available");
        labelGender.setBounds(440,11,100,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        JLabel labelDisease = new JLabel("Location");
        labelDisease.setBounds(590,11,100,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);



        JButton back = new JButton("BACK");
        back.setBounds(300,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setSize(900,550);
        setLayout(null);
        setLocation(300,170);
        setVisible(true);
    }



    public static void main(String[] args) {
        new Ambulance();
    }


}
