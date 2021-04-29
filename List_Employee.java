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

public class List_Employee extends JFrame implements ActionListener {
    JTable j1;
    JButton b1;
    String[] h = new String[]{"Emp id", "Name", "Gender", "Address", "State", "City", "Email id", "Phone"};
    String[][] d = new String[20][8];
    int i = 0;
    int j = 0;

    List_Employee() {
        super("View Employees");
        this.setSize(1000, 400);
        this.setLocation(450, 200);

        try {
            String q = "select * from employee";
            conn c1 = new conn();

            for(ResultSet rs = c1.s.executeQuery(q); rs.next(); this.j = 0) {
                this.d[this.i][this.j++] = rs.getString("id");
                this.d[this.i][this.j++] = rs.getString("name");
                this.d[this.i][this.j++] = rs.getString("gender");
                this.d[this.i][this.j++] = rs.getString("address");
                this.d[this.i][this.j++] = rs.getString("state");
                this.d[this.i][this.j++] = rs.getString("city");
                this.d[this.i][this.j++] = rs.getString("email");
                this.d[this.i][this.j++] = rs.getString("phone");
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

    public static void main(String[] s) {
        (new List_Employee()).setVisible(true);
    }
}
