//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

class splash {
    splash() {
    }

    public static void main(String[] s) {
        sframe f1 = new sframe("Employee Management System");
        f1.setVisible(true);
        int x = 1;

        for(int i = 2; i <= 600; ++x) {
            f1.setLocation(800 - (i + x) / 2, 500 - i / 2);
            f1.setSize(i + x, i);

            try {
                Thread.sleep(10L);
            } catch (Exception var5) {
            }

            i += 4;
        }

    }
}
