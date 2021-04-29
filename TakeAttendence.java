//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TakeAttendence extends JFrame implements ActionListener {
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel l7;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField t6;
    JTextField t7;
    JButton b1;
    JButton b2;
    Choice c2;
    Choice fh;
    Choice sh;

    TakeAttendence() {
        this.setLayout(new GridLayout(4, 2, 50, 50));
        this.c2 = new Choice();

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");

            while(rs.next()) {
                this.c2.add(rs.getString("id"));
            }
        } catch (Exception var3) {
        }

        this.add(new JLabel("Select Empno"));
        this.add(this.c2);
        this.l1 = new JLabel("First Half");
        this.fh = new Choice();
        this.fh.add("Present");
        this.fh.add("Absent");
        this.fh.add("Leave");
        this.add(this.l1);
        this.add(this.fh);
        this.l2 = new JLabel("Second Half");
        this.sh = new Choice();
        this.sh.add("Present");
        this.sh.add("Absent");
        this.sh.add("Leave");
        this.add(this.l2);
        this.add(this.sh);
        this.b1 = new JButton("Submit");
        this.b1.setBackground(Color.BLACK);
        this.b1.setForeground(Color.WHITE);
        this.b2 = new JButton("Cancel");
        this.b2.setBackground(Color.BLACK);
        this.b2.setForeground(Color.WHITE);
        this.add(this.b1);
        this.add(this.b2);
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        this.setSize(400, 450);
        this.setLocation(600, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        String f = this.fh.getSelectedItem();
        String s = this.sh.getSelectedItem();
        String dt = (new Date()).toString();
        String id = this.c2.getSelectedItem();
        String qry = "insert into attendence values(" + id + ",'" + dt + "','" + f + "','" + s + "')";

        try {
            conn c1 = new conn();
            c1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog((Component)null, "Attendence confirmed");
            this.setVisible(false);
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }

    public static void main(String[] s) {
        new TakeAttendence();
    }
}
