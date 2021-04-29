//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class pay_slip extends JFrame implements ActionListener {
    Choice c1;
    JTextArea t1;
    JButton b1;

    pay_slip() {
        this.setSize(800, 700);
        this.setLocation(400, 150);
        this.c1 = new Choice();

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary");

            while(rs.next()) {
                this.c1.add(rs.getString("id"));
            }
        } catch (Exception var4) {
        }

        this.setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Select Id"));
        p1.add(this.c1);
        this.add(p1, "North");
        this.t1 = new JTextArea(30, 80);
        JScrollPane jsp = new JScrollPane(this.t1);
        Font f1 = new Font("arial", 1, 20);
        this.t1.setFont(f1);
        this.b1 = new JButton("Generate Pay Slip");
        this.add(this.b1, "South");
        this.add(jsp, "Center");
        this.b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee where id=" + this.c1.getSelectedItem());
            rs.next();
            String name = rs.getString("name");
            rs.close();
            rs = c.s.executeQuery("select * from salary where id=" + this.c1.getSelectedItem());
            double gross = 0.0D;
            double net = 0.0D;
            Date d1 = new Date();
            int month = d1.getMonth();
            //this.t1.setText(" ----------------   PAY SLIP FOR THE MONTH OF " + month + " ,2019  ------------------------");
            this.t1.append("\n");
            if (rs.next()) {
                this.t1.append("\n     Employee ID " + rs.getString("id"));
                this.t1.append("\n     Employee Name " + name);
                this.t1.append("\n----------------------------------------------------------------");
                this.t1.append("\n");
                double hra = rs.getDouble("hra");
                this.t1.append("\n                  HRA         : " + hra);
                double da = rs.getDouble("da");
                this.t1.append("\n                  DA          : " + da);
                double med = rs.getDouble("med");
                this.t1.append("\n                  MED         : " + med);
                double pf = rs.getDouble("pf");
                this.t1.append("\n                  PF          : " + pf);
                double basic = rs.getDouble("basic_salary");
                gross = hra + da + med + pf + basic;
                net = gross - pf;
                this.t1.append("\n                  BASIC SALARY : " + basic);
                this.t1.append("\n-------------------------------------------------------");
                this.t1.append("\n");
                this.t1.append("\n       GROSS SALARY :" + gross + "    \n       NET SALARY : " + net);
                this.t1.append("\n       Tax   :   2.1% of gross " + gross * 2.1D / 100.0D);
                this.t1.append("\n -------------------------------------------------");
                this.t1.append("\n");
                this.t1.append("\n");
                this.t1.append("\n");
               // this.t1.append("   (  Signature  )      ");
            }
        } catch (Exception var21) {
            var21.printStackTrace();
        }

    }

    public static void main(String[] args) {
        (new pay_slip()).setVisible(true);
    }
}
