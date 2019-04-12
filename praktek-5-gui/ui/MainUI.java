package ui;

import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {

    private JLabel lblNim;
    private JLabel lblNama;
    private JLabel lblKelas;
    private JTextField txtNim;
    private JTextField txtNama;
    private JTextField txtKelas;
    private JButton btnProses;
    private Container contentPane;
    private JPanel panel;

    public MainUI() {
        initUI();
    }

    private void initUI() {
        lblNim = new JLabel("NIM");
        lblNama = new JLabel("NAMA");
        lblKelas = new JLabel("KELAS");
        txtNim = new JTextField();
        txtNama = new JTextField();
        txtKelas = new JTextField();
        btnProses = new JButton("Proses");

        contentPane = getContentPane();

        panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
        panel.add(lblNim); panel.add(txtNim);
        panel.add(lblNama); panel.add(txtNama);
        panel.add(lblKelas); panel.add(txtKelas);

        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(btnProses, BorderLayout.SOUTH);

        setSize(300, 200);
        setTitle("Aplikasi Entry Data");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}