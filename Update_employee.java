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

public class Update_employee extends JFrame implements ActionListener, ItemListener {
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel l7;
    JLabel emp;
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
    Choice c2;

    Update_employee() {
        super("Update Employee");
        this.setLayout((LayoutManager)null);
        this.getContentPane().setBackground(Color.WHITE);
        this.c2 = new Choice();
        this.c2.setBounds(160, 40, 200, 20);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");

            while(rs.next()) {
                this.c2.add(rs.getString("id"));
            }
        } catch (Exception var3) {
        }

        this.emp = new JLabel("Select Empno");
        this.emp.setBounds(40, 40, 100, 20);
        this.add(this.emp);
        this.add(this.c2);
        this.l1 = new JLabel("Name : ");
        this.t1 = new JTextField(15);
        this.l1.setBounds(40, 80, 100, 20);
        this.t1.setBounds(160, 80, 200, 20);
        this.add(this.l1);
        this.add(this.t1);
        this.c1 = new Choice();
        this.c1.add("Male");
        this.c1.add("Female");
        this.l2 = new JLabel("Gender : ");
        this.l2.setBounds(40, 120, 100, 20);
        this.c1.setBounds(160, 120, 200, 20);
        this.add(this.l2);
        this.add(this.c1);
        this.l3 = new JLabel("Address : ");
        this.t3 = new JTextField(15);
        this.l3.setBounds(40, 160, 100, 20);
        this.t3.setBounds(160, 160, 200, 20);
        this.add(this.l3);
        this.add(this.t3);
        this.l4 = new JLabel("State : ");
        this.t4 = new JTextField(15);
        this.l4.setBounds(40, 200, 100, 20);
        this.t4.setBounds(160, 200, 200, 20);
        this.add(this.l4);
        this.add(this.t4);
        this.l5 = new JLabel("City : ");
        this.t5 = new JTextField(15);
        this.l5.setBounds(40, 240, 100, 20);
        this.t5.setBounds(160, 240, 200, 20);
        this.add(this.l5);
        this.add(this.t5);
        this.l6 = new JLabel("Email : ");
        this.t6 = new JTextField(15);
        this.l6.setBounds(40, 280, 100, 20);
        this.t6.setBounds(160, 280, 200, 20);
        this.add(this.l6);
        this.add(this.t6);
        this.l7 = new JLabel("Phone : ");
        this.t7 = new JTextField(15);
        this.l7.setBounds(40, 320, 100, 20);
        this.t7.setBounds(160, 320, 200, 20);
        this.add(this.l7);
        this.add(this.t7);
        this.b1 = new JButton("Update");
        this.b2 = new JButton("Delete");
        this.b1.setBounds(40, 400, 150, 30);
        this.b2.setBounds(200, 400, 150, 30);
        this.add(this.b1);
        this.add(this.b2);
        this.b1.setBackground(Color.BLACK);
        this.b1.setForeground(Color.WHITE);
        this.b2.setBackground(Color.BLACK);
        this.b2.setForeground(Color.WHITE);
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        this.c2.addItemListener(this);
        this.setVisible(true);
        this.setSize(400, 550);
        this.setLocation(600, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.b1) {
            String n = this.t1.getText();
            String g = this.c1.getSelectedItem();
            String a = this.t3.getText();
            String s = this.t4.getText();
            String c = this.t5.getText();
            String e = this.t6.getText();
            String p = this.t7.getText();
            String qry = "update employee set name='" + n + "',gender='" + g + "',address='" + a + "',state='" + s + "',city='" + c + "',email='" + e + "',phone='" + p + "'   where id=" + this.c2.getSelectedItem();

            try {
                conn c1 = new conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog((Component)null, "Employee Updated");
            } catch (Exception var12) {
                var12.printStackTrace();
            }
        }

        if (ae.getSource() == this.b2) {
            try {
                conn c1 = new conn();
                c1.s.executeUpdate("delete from employee where id=" + this.c2.getSelectedItem());
                JOptionPane.showMessageDialog((Component)null, "Employee Deleted");
                this.setVisible(false);
            } catch (Exception var11) {
                var11.printStackTrace();
            }
        }

    }

    public void itemStateChanged(ItemEvent ie) {
        try {
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from employee where id=" + this.c2.getSelectedItem());
            if (rs.next()) {
                this.t1.setText(rs.getString("name"));
                this.t3.setText(rs.getString("address"));
                this.t4.setText(rs.getString("state"));
                this.t5.setText(rs.getString("city"));
                this.t6.setText(rs.getString("email"));
                this.t7.setText(rs.getString("phone"));
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Update_employee();
    }
}
