package hospita.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ALL_Patient_Info extends JFrame {
    ALL_Patient_Info(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,870,430);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from Patient_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));




        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel labelID = new JLabel("ID ");
        labelID.setBounds(31,11,100,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,14));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        JLabel labelNumber = new JLabel("Number ");
        labelNumber.setBounds(140,11,100,14);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        JLabel labelName1 = new JLabel("Name ");
        labelName1.setBounds(240,11,100,14);
        labelName1.setFont(new Font("Tahoma",Font.BOLD,14));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);

        JLabel labelGender = new JLabel("Gender ");
        labelGender.setBounds(350,11,100,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        JLabel labelDisease = new JLabel("Disease ");
        labelDisease.setBounds(460,11,100,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        JLabel labelRoom = new JLabel("Room ");
        labelRoom.setBounds(570,11,100,14);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);

        JLabel labelDate = new JLabel("Time ");
        labelDate.setBounds(670,11,100,14);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);

        JLabel labelDeposite = new JLabel("Deposite ");
        labelDeposite.setBounds(780,11,100,14);
        labelDeposite.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDeposite.setForeground(Color.white);
        panel.add(labelDeposite);

        JButton back = new JButton("BACK");
        back.setBounds(350,480,120,30);
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
        new ALL_Patient_Info();
    }
}
