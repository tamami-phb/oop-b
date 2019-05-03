import javax.swing.*;

import ui.*;

public class Aplikasi extends JFrame {

    private MyAnimasi anim;

    public Aplikasi() {
        super();

        anim = new MyAnimasi();
        add(anim);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Aplikasi app = new Aplikasi();
    }

}