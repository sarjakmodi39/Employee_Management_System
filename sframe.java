//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class sframe extends JFrame implements Runnable {
    Thread t1;

    sframe(String s) {
        super(s);
        this.setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icon/payroll_system.jpg"));
        Image i1 = c1.getImage().getScaledInstance(730, 550, 1);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel m1 = new JLabel(i2);
        this.add(m1);
        this.t1 = new Thread(this);
        this.t1.start();
    }

    public void run() {
        try {
            Thread.sleep(7000L);
            this.setVisible(false);
            new login();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}
