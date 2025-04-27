package hospita.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {
    JTable table;

            Room(){
                JPanel panel = new JPanel();
                panel.setBounds(4,4,890,530);
                panel.setBackground(new Color(90,156,163));
                panel.setLayout(null);
                add(panel);

                ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
                Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
                ImageIcon imageIcon1 = new ImageIcon(image);
                JLabel imageLabel = new JLabel(imageIcon1);
                imageLabel.setBounds(650,130,200,200);
                panel.add(imageLabel);

                table = new JTable();
                table.setBackground(new Color(90,156,163));

                JScrollPane sp = new JScrollPane(table);
                sp.getViewport().setBackground(new Color(90,156,163));
                sp.setBounds(10, 40, 530,400 );
                panel.add(sp);


                try{


                    conn c = new conn();
                    String q = "select * from room";
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception e){
                   e.printStackTrace();
                }

                JButton back = new JButton("Back");
                back.setBounds(670,410,120,30);
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
                setSize(900,600);
                setLayout(null);
                setLocation(300,230);
                setVisible(true);
            }
         public static void main(String[] args) {
               new Room();



    }
}
