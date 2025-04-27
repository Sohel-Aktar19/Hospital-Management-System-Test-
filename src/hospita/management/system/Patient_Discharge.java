package hospita.management.system;

import javax.management.relation.RelationNotification;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_Discharge extends JFrame {
        Patient_Discharge(){
            JPanel panel = new JPanel();
            panel.setBounds(5,5,790,390);
            panel.setBackground(new Color(90,156,163));
            panel.setLayout(null);
            add(panel);

            JLabel labelID = new JLabel("CHECK-OUT ");
            labelID.setBounds(100,20,150,20);
            labelID.setFont(new Font("Tahoma",Font.BOLD,14));
            labelID.setForeground(Color.white);
            panel.add(labelID);

            JLabel label1 = new JLabel("Customer ID");
            label1.setBounds(30,80,150,20);
            label1.setFont(new Font("Tahoma",Font.BOLD,14));
            label1.setForeground(Color.white);
            panel.add(label1);

            Choice choice = new Choice();
            choice.setBounds(200,80,150,25);
            panel.add(choice);

            try{
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery("select * from patient_Info");
                while (resultSet.next()){
                    choice.add(resultSet.getString("ID"));
                }

            }catch (Exception e){
                e.printStackTrace();
            }

            JLabel label2 = new JLabel("Room Number");
            label2.setBounds(30,130,150,20);
            label2.setFont(new Font("Tahoma",Font.BOLD,14));
            label2.setForeground(Color.white);
            panel.add(label2);

            JLabel labelRNo = new JLabel();
            labelRNo.setBounds(200,130,150,20);
            labelRNo.setFont(new Font("Tahoma",Font.BOLD,14));
            labelRNo.setForeground(Color.white);
            panel.add(labelRNo);

            JLabel label4 = new JLabel("In Time");
            label4.setBounds(30,180,250,20);
            label4.setFont(new Font("Tahoma",Font.BOLD,14));
            label4.setForeground(Color.white);
            panel.add(label4);

            JLabel labelINTime= new JLabel();
            labelINTime.setBounds(200,180,250,20);
            labelINTime.setFont(new Font("Tahoma",Font.BOLD,14));
            labelINTime.setForeground(Color.white);
            panel.add(labelINTime);

            JLabel label5 = new JLabel("Out Time");
            label5.setBounds(30,230,150,20);
            label5.setFont(new Font("Tahoma",Font.BOLD,14));
            label5.setForeground(Color.white);
            panel.add(label5);

            Date date = new Date();

            JLabel labelOUTTime= new JLabel(""+date);
            labelOUTTime.setBounds(200,230,250,20);
            labelOUTTime.setFont(new Font("Tahoma",Font.BOLD,14));
            labelOUTTime.setForeground(Color.white);
            panel.add(labelOUTTime);

            JButton D = new JButton("Discharge");
            D.setBounds(30,300,120,30);
            D.setBackground(Color.BLACK);
            D.setForeground(Color.WHITE);
            panel.add(D);
            D.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    conn c = new conn();
                    try {
                        c.statement.executeUpdate("delete from Patient_Info Where ID = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability = 'Available' Where room_no = '"+labelRNo.getText()+"'");
                   JOptionPane.showMessageDialog(null,"Done");
                   setVisible(false);
                    }catch (Exception E){
                        E.printStackTrace();
                    }

                }
            });

            JButton C = new JButton("Check");
            C.setBounds(170,300,120,30);
            C.setBackground(Color.BLACK);
            C.setForeground(Color.WHITE);
            panel.add(C);
            C.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    conn c = new conn();
                    try {
                        ResultSet resultSet = c.statement.executeQuery("select * from patient_Info Where ID ='" + choice.getSelectedItem() + "'");
                        while (resultSet.next()) {
                            labelRNo.setText(resultSet.getString("Room_Number"));
                            labelINTime.setText(resultSet.getString("Time"));
                        }
                    }catch (Exception Ex){
                        Ex.printStackTrace();
                    }
                }
            });

            JButton B = new JButton("Back");
            B.setBounds(300,300,120,30);
            B.setBackground(Color.BLACK);
            B.setForeground(Color.WHITE);
            panel.add(B);
            B.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });
            setUndecorated(true);
            setSize(800,400);
            setLayout(null);
            setLocation(400,250);
            setVisible(true);
        }
    public static void main(String[] args) {
        new Patient_Discharge();
    }
}
