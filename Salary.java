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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Salary extends JFrame implements ActionListener {
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

    Salary() {
        super("Set Salary");
        this.setLayout(new GridLayout(8, 2, 20, 20));
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
        this.l1 = new JLabel("HRA");
        this.t1 = new JTextField(15);
        this.add(this.l1);
        this.add(this.t1);
        this.l3 = new JLabel("DA");
        this.t3 = new JTextField(15);
        this.add(this.l3);
        this.add(this.t3);
        this.l4 = new JLabel("MED");
        this.t4 = new JTextField(15);
        this.add(this.l4);
        this.add(this.t4);
        this.l5 = new JLabel("PF");
        this.t5 = new JTextField(15);
        this.add(this.l5);
        this.add(this.t5);
        this.l6 = new JLabel("Basic Salary");
        this.t6 = new JTextField(15);
        this.add(this.l6);
        this.add(this.t6);
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
        this.setSize(450, 550);
        this.setLocation(500, 200);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {
        String hra = this.t1.getText();
        String id = this.c2.getSelectedItem();
        String da = this.t3.getText();
        String med = this.t4.getText();
        String pf = this.t5.getText();
        String basic = this.t6.getText();
        String qry = "insert into salary values(" + id + "," + hra + "," + da + "," + med + "," + pf + "," + basic + ")";

        try {
            conn c1 = new conn();
            c1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog((Component)null, "Salary updated");
            this.setVisible(false);
        } catch (Exception var10) {
            var10.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Salary();
    }
}
