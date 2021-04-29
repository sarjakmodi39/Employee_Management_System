//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener {
    JLabel l1;
    JLabel l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1;
    JButton b2;

    login() {
        super("Login Page");
        this.setLayout(new BorderLayout());
        this.t2 = new JPasswordField(10);
        this.t1 = new JTextField(10);
        JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon\\defaultpic.png")));
        this.b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
        this.b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon\\Cancel.png")));
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        new JPanel();
        JPanel p2 = new JPanel();
        new JPanel();
        JPanel p4 = new JPanel();
        this.add(l, "West");
        p2.add(new JLabel("User Name  "));
        p2.add(this.t1);
        p2.add(new JLabel("Password "));
        p2.add(this.t2);
        this.add(p2, "Center");
        p4.add(this.b1);
        p4.add(this.b2);
        this.add(p4, "South");
        this.setSize(400, 250);
        this.setLocation(600, 400);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            conn c1 = new conn();
            String u = this.t1.getText();
            String v = this.t2.getText();
            String q = "select * from login where username='" + u + "' and password='" + v + "'";
            ResultSet rs = c1.s.executeQuery(q);
            if (rs.next()) {
                (new project()).setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog((Component)null, "Invalid login");
                this.setVisible(false);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new login();
    }
}
