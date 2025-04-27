package hospita.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

     Choice choice;
     JTable table;

        SearchRoom(){

            JPanel panel = new JPanel();
            panel.setBounds(4,4,740,540);
            panel.setBackground(new Color(90,156,163));
            panel.setLayout(null);
            add(panel);

            JLabel For  = new JLabel("Search For Room");
            For.setBounds(250,11,186,31);
            For.setForeground(Color.WHITE);
            For.setFont(new Font("Tahoma",Font.BOLD,20));
            panel.add(For);

            JLabel status = new JLabel("Status");
            status.setBounds(70,70,90,20);
            status.setForeground(Color.WHITE);
            status.setFont(new Font("Tahoma",Font.BOLD,14));
            panel.add(status);

            choice = new Choice();
            choice.setBounds(170,70,120,20);
            choice.add("Available");
            choice.add("Occupied");
            panel.add(choice);

            table = new JTable();
            table.setBounds(0,187,700,210);
            table.setBackground(new Color(90,156,163));
            table.setForeground(Color.WHITE);
            panel.add(table);

            try{
                conn c = new conn();
                String q = "select * from room";
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception e){
                e.printStackTrace();
            }

            JLabel Roomno= new JLabel("Room Number");
            Roomno.setBounds(23,162,150,20);
            Roomno.setForeground(Color.WHITE);
            Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
            panel.add(Roomno);

            JLabel Available = new JLabel("Availability");
            Available.setBounds(175,162,150,20);
            Available.setForeground(Color.WHITE);
            Available.setFont(new Font("Tahoma",Font.BOLD,14));
            panel.add(Available);

            JLabel Price = new JLabel("Price");
            Price.setBounds(400,162,150,20);
            Price.setForeground(Color.WHITE);
            Price.setFont(new Font("Tahoma",Font.BOLD,14));
            panel.add(Price);

            JLabel Bed = new JLabel("Bed Type");
            Bed.setBounds(558,162,150,20);
            Bed.setForeground(Color.WHITE);
            Bed.setFont(new Font("Tahoma",Font.BOLD,14));
            panel.add(Bed);

            JButton Search = new JButton("Search");
            Search.setBounds(200,400,120,30);
            Search.setBackground(Color.BLACK);
            Search.setForeground(Color.WHITE);
            panel.add(Search);
            Search.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String q = "select * from Room where availability = '"+choice.getSelectedItem()+"'";
                    try{
                        conn c = new conn();
                        ResultSet resultSet = c.statement.executeQuery(q);
                        table.setModel(DbUtils.resultSetToTableModel(resultSet));
                    }catch (Exception E){
                        E.printStackTrace();
                    }
                }
            });

            JButton back = new JButton("Back");
            back.setBounds(380,400,120,30);
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
            setSize(750, 500);
            setLayout(null);
            setLocation(450, 250);
            setVisible(true);
        }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
