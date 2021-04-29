//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Update_salary extends JFrame implements ActionListener, ItemListener {
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField t6;
    JButton b1;
    JButton b2;
    Choice c2;

    Update_salary() {
        this.setLayout((LayoutManager)null);
        this.c2 = new Choice();

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary");

            while(rs.next()) {
                this.c2.add(rs.getString("id"));
            }
        } catch (Exception var3) {
        }

        JLabel emp = new JLabel("Select Empno");
        emp.setBounds(20, 20, 100, 20);
        this.add(emp);
        this.c2.setBounds(120, 20, 200, 20);
        this.add(this.c2);
        this.l1 = new JLabel("Hra");
        this.t1 = new JTextField(15);
        this.l1.setBounds(20, 60, 100, 20);
        this.t1.setBounds(120, 60, 200, 20);
        this.add(this.l1);
        this.add(this.t1);
        this.l2 = new JLabel("Da");
        this.t2 = new JTextField(15);
        this.l2.setBounds(20, 100, 100, 20);
        this.t2.setBounds(120, 100, 200, 20);
        this.add(this.l2);
        this.add(this.t2);
        this.l3 = new JLabel("Med");
        this.t3 = new JTextField(15);
        this.l3.setBounds(20, 140, 100, 20);
        this.t3.setBounds(120, 140, 200, 20);
        this.add(this.l3);
        this.add(this.t3);
        this.l4 = new JLabel("Pf");
        this.t4 = new JTextField(15);
        this.l4.setBounds(20, 180, 100, 20);
        this.t4.setBounds(120, 180, 200, 20);
        this.add(this.l4);
        this.add(this.t4);
        this.l5 = new JLabel("basic_salary");
        this.t5 = new JTextField(15);
        this.l5.setBounds(20, 220, 100, 20);
        this.t5.setBounds(120, 220, 200, 20);
        this.add(this.l5);
        this.add(this.t5);
        this.b1 = new JButton("Update");
        this.b1.setBackground(Color.BLACK);
        this.b1.setForeground(Color.WHITE);
        this.b2 = new JButton("Delete");
        this.b2.setBackground(Color.BLACK);
        this.b2.setForeground(Color.WHITE);
        this.b1.setBounds(40, 280, 100, 20);
        this.b2.setBounds(200, 280, 100, 20);
        this.add(this.b1);
        this.add(this.b2);
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        this.c2.addItemListener(this);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        this.setSize(400, 450);
        this.setLocation(600, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.b1) {
            String hra = this.t1.getText();
            String id = this.c2.getSelectedItem();
            String da = this.t2.getText();
            String med = this.t3.getText();
            String pf = this.t4.getText();
            String basic = this.t5.getText();
            String qry = "update salary set hra=" + hra + ",da=" + da + ",med=" + med + ",pf=" + pf + ",basic_salary=" + basic + "  where id=" + this.c2.getSelectedItem();

            try {
                conn c1 = new conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog((Component)null, "Salary Updated");
                this.setVisible(false);
            } catch (Exception var11) {
                var11.printStackTrace();
            }
        }

        if (ae.getSource() == this.b2) {
            try {
                conn c1 = new conn();
                c1.s.executeUpdate("delete from salary where id=" + this.c2.getSelectedItem());
                JOptionPane.showMessageDialog((Component)null, "Salary Deleted");
                this.setVisible(false);
            } catch (Exception var10) {
                var10.printStackTrace();
            }
        }

    }

    public void itemStateChanged(ItemEvent ie) {
        try {
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from salary where id=" + this.c2.getSelectedItem());
            if (rs.next()) {
                this.t1.setText(rs.getString("hra"));
                this.t2.setText(rs.getString("da"));
                this.t3.setText(rs.getString("med"));
                this.t4.setText(rs.getString("pf"));
                this.t5.setText(rs.getString("basic_salary"));
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Update_salary();
    }
}
