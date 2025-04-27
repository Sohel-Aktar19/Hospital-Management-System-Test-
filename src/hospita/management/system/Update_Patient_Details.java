package hospita.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Patient_Details extends JFrame {

    Update_Patient_Details() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 450);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124, 11, 300, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25, 88, 100, 20);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248, 80, 140, 25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * From Patient_Info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25, 129, 120, 20);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248, 129, 140, 20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25, 174, 100, 20);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldINTime = new JTextField();
        textFieldINTime.setBounds(248, 174, 140, 20);
        panel.add(textFieldINTime);

        JLabel label5 = new JLabel("Amount paid (Rs) :");
        label5.setBounds(25, 216, 200, 20);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldA = new JTextField();
        textFieldA.setBounds(248, 216, 140, 20);
        panel.add(textFieldA);

        JLabel label6 = new JLabel("Pending Amount (Rs) :");
        label6.setBounds(25, 261, 200, 20);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldP = new JTextField();
        textFieldP.setBounds(248, 261, 140, 20);
        textFieldP.setEditable(false);
        panel.add(textFieldP);

        JButton check = new JButton("CHECK");
        check.setBounds(275, 380, 100, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = choice.getSelectedItem();
                String q = "select * from Patient_Info where Name = '" + name + "'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldINTime.setText(resultSet.getString("Time"));
                        textFieldA.setText(resultSet.getString("Deposite"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from Room where room_no = '" + textFieldR.getText() + "'");
                    while (resultSet1.next()) {
                        String price = resultSet1.getString("Price");
                        int pendingAmount = Integer.parseInt(price) - Integer.parseInt(textFieldA.getText());
                        textFieldP.setText("" + pendingAmount);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(150, 380, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String name = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTime.getText();
                    String amount = textFieldA.getText();

                    String query = "update Patient_Info set Room_Number = '" + room + "', Time = '" + time + "', Deposite = '" + amount + "' where Name = '" + name + "'";
                    c.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(400, 380, 100, 30);
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
        setSize(950, 460);
        setLayout(null);
        setLocation(350, 270);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Update_Patient_Details();
    }
}

