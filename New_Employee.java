//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class New_Employee extends JFrame implements ActionListener {
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
    Choice c1;

    New_Employee() {
        super("New Employee");
        this.setSize(600, 650);
        this.setLocation(600, 200);
        this.getContentPane().setBackground(Color.WHITE);
        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setLayout(new GridLayout(8, 2, 10, 40));
        this.l1 = new JLabel("Name");
        this.t1 = new JTextField(15);
        p1.add(this.l1);
        p1.add(this.t1);
        this.c1 = new Choice();
        this.c1.add("Male");
        this.c1.add("Female");
        this.l2 = new JLabel("Gender");
        p1.add(this.l2);
        p1.add(this.c1);
        this.l3 = new JLabel("Address");
        this.t3 = new JTextField(15);
        p1.add(this.l3);
        p1.add(this.t3);
        this.l4 = new JLabel("State");
        this.t4 = new JTextField(15);
        p1.add(this.l4);
        p1.add(this.t4);
        this.l5 = new JLabel("City");
        this.t5 = new JTextField(15);
        p1.add(this.l5);
        p1.add(this.t5);
        this.l6 = new JLabel("Email");
        this.t6 = new JTextField(15);
        p1.add(this.l6);
        p1.add(this.t6);
        this.l7 = new JLabel("Phone");
        this.t7 = new JTextField(15);
        p1.add(this.l7);
        p1.add(this.t7);
        this.b1 = new JButton("Submit");
        this.b2 = new JButton("Cancel");
        p1.add(this.b1);
        p1.add(this.b2);
        this.setLayout(new BorderLayout());
        this.add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/new_employee.png"))), "West");
        this.add(p1, "Center");
        this.b1.addActionListener(this);
        this.b1.setBackground(Color.BLACK);
        this.b1.setForeground(Color.WHITE);
        this.b2.addActionListener(this);
        this.b2.setBackground(Color.BLACK);
        this.b2.setForeground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {
        String n = this.t1.getText();
        String g = this.c1.getSelectedItem();
        String a = this.t3.getText();
        String s = this.t4.getText();
        String c = this.t5.getText();
        String e = this.t6.getText();
        String p = this.t7.getText();
        String qry = "insert into employee values(null,'" + n + "','" + g + "','" + a + "','" + s + "','" + c + "','" + e + "','" + p + "')";

        try {
            conn c1 = new conn();
            c1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog((Component)null, "Employee Created");
            this.setVisible(false);
        } catch (Exception var11) {
            var11.printStackTrace();
        }

    }

    public static void main(String[] s) {
        (new New_Employee()).setVisible(true);
    }
}
