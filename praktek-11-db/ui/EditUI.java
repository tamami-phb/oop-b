package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class EditUI extends JFrame {

    private Container contentPane;
    private JPanel panelForm;
    private JPanel panelButton;
    private JLabel lblNim;
    private JLabel lblNama;
    private JLabel lblKelas;
    private JTextField txtNim;
    private JTextField txtNama;
    private JTextField txtKelas;
    private JButton btnSimpan;
    private JButton btnBatal;
    private MainUI parent;

    public EditUI(MainUI parent) {
        this.parent = parent;
        initUI();
    }

    private void initUI() {
        setTitle("Formulir Ubah Data");

        contentPane = getContentPane();

        lblNim = new JLabel("NIM");
        lblNama = new JLabel("NAMA");
        lblKelas = new JLabel("KELAS");
        txtNim = new JTextField();
        txtNama = new JTextField();
        txtKelas = new JTextField();
        panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(3,2));
        panelForm.add(lblNim); panelForm.add(txtNim);
        panelForm.add(lblNama); panelForm.add(txtNama);
        panelForm.add(lblKelas); panelForm.add(txtKelas);
        contentPane.add(panelForm, BorderLayout.CENTER);

        btnSimpan = new JButton("Simpan");
        btnBatal = new JButton("Batal");
        panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(1, 2));
        panelButton.add(btnSimpan);
        panelButton.add(btnBatal);
        contentPane.add(panelButton, BorderLayout.SOUTH);

        pack();

        btnBatal.addActionListener(new BtnBatalClick());
        btnSimpan.addActionListener(new BtnSimpanClick());
    }

    public void tampilkanForm(String nim,
                              String nama,
                              String kelas) {
        txtNim.setText(nim);
        txtNama.setText(nama);
        txtKelas.setText(kelas);
        setVisible(true);
    }


    // ----- events

    private class BtnSimpanClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {

        }
    }

    private class BtnBatalClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            setVisible(false);
        }
    }

}