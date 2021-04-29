//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class project extends JFrame implements ActionListener {
    project() {
        this.setSize(2000, 1100);
        this.getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/payroll.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 700, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        this.add(l1);
        JMenuBar mb = new JMenuBar();
        this.setJMenuBar(mb);
        JMenu m1 = new JMenu("Master");
        m1.setForeground(Color.blue);
        JMenuItem t1 = new JMenuItem("New Employee");
        t1.setForeground(Color.blue);
        t1.setFont(new Font("monospaced", 0, 12));
        t1.setMnemonic('N');
        t1.setAccelerator(KeyStroke.getKeyStroke(78, 2));
        t1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/New.png")));
        JMenuItem t3 = new JMenuItem("Salary");
        t3.setForeground(Color.blue);
        t3.setFont(new Font("monospaced", 0, 12));
        t3.setMnemonic('S');
        t3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/schedreport.png")));
        t3.setAccelerator(KeyStroke.getKeyStroke(83, 2));
        JMenuItem t4 = new JMenuItem("List Employee");
        t4.setForeground(Color.blue);
        t4.setFont(new Font("monospaced", 0, 12));
        t4.setMnemonic('L');
        t4.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/newinvoice.png")));
        t4.setAccelerator(KeyStroke.getKeyStroke(76, 2));
        m1.add(t1);
        m1.add(t3);
        m1.add(t4);
        mb.add(m1);
        t1.addActionListener(this);
        t3.addActionListener(this);
        t4.addActionListener(this);
        JMenu edit = new JMenu("Update");
        edit.setForeground(Color.RED);
        mb.add(edit);
        JMenuItem s1 = new JMenuItem("Update Salary");
        s1.setForeground(Color.blue);
        s1.setFont(new Font("monospaced", 0, 12));
        s1.setMnemonic('U');
        s1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EditOpen.png")));
        s1.setAccelerator(KeyStroke.getKeyStroke(85, 2));
        edit.add(s1);
        JMenuItem s2 = new JMenuItem("Update Employee");
        s2.setForeground(Color.blue);
        s2.setFont(new Font("monospaced", 0, 12));
        s2.setMnemonic('p');
        s2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
        s2.setAccelerator(KeyStroke.getKeyStroke(80, 2));
        edit.add(s2);
        JMenuItem s3 = new JMenuItem("Take Attendence");
        s3.setForeground(Color.blue);
        s3.setFont(new Font("monospaced", 0, 12));
        s3.setMnemonic('T');
        s3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EXPENSE.PNG")));
        s3.setAccelerator(KeyStroke.getKeyStroke(84, 2));
        edit.add(s3);
        s1.addActionListener(this);
        s2.addActionListener(this);
        s3.addActionListener(this);
        JMenu rep = new JMenu("Reports");
        rep.setForeground(Color.blue);
        mb.add(rep);
        JMenuItem p1 = new JMenuItem("Generate PaySlip");
        p1.setForeground(Color.blue);
        p1.setFont(new Font("monospaced", 0, 12));
        p1.setMnemonic('P');
        p1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payments.png")));
        p1.setAccelerator(KeyStroke.getKeyStroke(80, 2));
        rep.add(p1);
        JMenuItem p2 = new JMenuItem("List Attendence");
        p2.setForeground(Color.blue);
        p2.setFont(new Font("monospaced", 0, 12));
        p2.setMnemonic('L');
        p2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
        p2.setAccelerator(KeyStroke.getKeyStroke(76, 2));
        rep.add(p2);
        p1.addActionListener(this);
        p2.addActionListener(this);
        JMenu util = new JMenu("Utilities");
        util.setForeground(Color.red);
        mb.add(util);
        JMenuItem u1 = new JMenuItem("Notepad");
        u1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/New.png")));
        u1.setForeground(Color.blue);
        u1.setFont(new Font("monospaced", 0, 12));
        u1.setMnemonic('o');
        u1.setAccelerator(KeyStroke.getKeyStroke(79, 2));
        util.add(u1);
        JMenuItem u2 = new JMenuItem("Calculator");
        u2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/calc.png")));
        u2.setForeground(Color.blue);
        u2.setFont(new Font("monospaced", 0, 12));
        u2.setMnemonic('C');
        u2.setAccelerator(KeyStroke.getKeyStroke(67, 2));
        util.add(u2);
        JMenuItem u3 = new JMenuItem("Web Browser");
        u3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/explorer.jpg")));
        u3.setForeground(Color.blue);
        u3.setFont(new Font("monospaced", 0, 12));
        u3.setMnemonic('E');
        u3.setAccelerator(KeyStroke.getKeyStroke(69, 2));
        util.add(u3);
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        JMenu m8 = new JMenu("Exit");
        m8.setForeground(Color.red);
        mb.add(m8);
        JMenuItem m8i1 = new JMenuItem("Exit");
        m8.add(m8i1);
        m8i1.setForeground(Color.blue);
        m8i1.setFont(new Font("monospaced", 0, 14));
        m8i1.setMnemonic('X');
        m8i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        m8i1.setAccelerator(KeyStroke.getKeyStroke(88, 2));
        m8i1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("New Employee")) {
            (new New_Employee()).setVisible(true);
        } else if (msg.equals("List Employee")) {
            (new List_Employee()).setVisible(true);
        } else if (msg.equals("Update Employee")) {
            (new Update_employee()).setVisible(true);
        } else if (msg.equals("Salary")) {
            (new Salary()).setVisible(true);
        } else if (msg.equals("Update Salary")) {
            (new Update_salary()).setVisible(true);
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception var6) {
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception var5) {
            }
        } else if (msg.equals("Web Browser")) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
            } catch (Exception var4) {
            }
        } else if (msg.equals("Take Attendence")) {
            (new TakeAttendence()).setVisible(true);
        } else if (msg.equals("Exit")) {
            System.exit(0);
        } else if (msg.equals("Generate PaySlip")) {
            (new pay_slip()).setVisible(true);
        } else if (msg.equals("List Attendence")) {
            (new List_Attendence()).setVisible(true);
        }

    }

    public static void main(String[] args) {
        (new project()).setVisible(true);
    }
}
