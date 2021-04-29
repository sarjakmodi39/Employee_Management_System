//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class List_Attendence extends JFrame implements ActionListener {
    JTable j1;
    JButton b1;
    String[] h = new String[]{"Emp id", "Date Time", "First Half", "Second Half"};
    String[][] d = new String[15][4];
    int i = 0;
    int j = 0;

    List_Attendence() {
        super("View Employees Attendence");
        this.setSize(800, 300);
        this.setLocation(450, 150);

        try {
            String q = "select * from attendence";
            conn c1 = new conn();

            for(ResultSet rs = c1.s.executeQuery(q); rs.next(); this.j = 0) {
                this.d[this.i][this.j++] = rs.getString("id");
                this.d[this.i][this.j++] = rs.getString("date_tm");
                this.d[this.i][this.j++] = rs.getString("f_half");
                this.d[this.i][this.j++] = rs.getString("s_half");
                ++this.i;
            }

            this.j1 = new JTable(this.d, this.h);
        } catch (Exception var4) {
        }

        this.b1 = new JButton("Print");
        this.add(this.b1, "South");
        JScrollPane s1 = new JScrollPane(this.j1);
        this.add(s1);
        this.b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            this.j1.print();
        } catch (Exception var3) {
        }

    }

    public static void main(String[] args) {
        (new List_Attendence()).setVisible(true);
    }
}
