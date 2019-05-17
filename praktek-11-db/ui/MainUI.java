package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;
import util.*;
import java.sql.*;

public class MainUI extends JFrame {

    public static Koneksi koneksi;

    private Container contentPane;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnTambah;
    private JButton btnUbah;
    private JButton btnHapus;
    private JPanel panelButton;
    private DefaultTableModel tableModel;
    private Vector data;
    private Vector columnNames;
    public static TambahUI tambahUI;
    public static EditUI editUI;

    public MainUI() {
        koneksi = new Koneksi();
        tambahUI = new TambahUI(this);
        editUI = new EditUI(this);
        initUI();
        initData();
    }

    private void initData() {
        String query = "select * from mahasiswa";
        try {
            ResultSet result = koneksi.select(query);
            data = new Vector();
            while(result.next()) {
                Vector temp = new Vector();
                temp.add(result.getString(1));
                temp.add(result.getString(2));
                temp.add(result.getString(3));
                data.add(temp);
            }
            tableModel.setDataVector(data, columnNames);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Ada kesalahan query");
        }
    }

    public void refreshTable() {
        initData();
    }

    private void initUI() {
        setTitle("Aplikasi Mahasiswa");

        contentPane = getContentPane();

        columnNames = new Vector();
        columnNames.add("NIM");
        columnNames.add("NAMA");
        columnNames.add("KELAS");
        data = new Vector();
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        btnTambah = new JButton("Tambah");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");
        panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(1, 3));
        panelButton.add(btnTambah);
        panelButton.add(btnUbah);
        panelButton.add(btnHapus);
        contentPane.add(panelButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        table.setSelectionModel(new MyCustomSingleSelection());
        btnTambah.addActionListener(new BtnTambahClick());
        btnUbah.addActionListener(new BtnUbahClick());
    }



    private class MyCustomSingleSelection
            extends DefaultListSelectionModel {
        public MyCustomSingleSelection() {
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    // ------- events

    private class BtnUbahClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            if(table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Pilih dulu data yang akan diubah");
            } else {
                String nim, nama, kelas;
                nim = "" + table.getValueAt(table.getSelectedRow(), 0);
                nama = table.getValueAt(table.getSelectedRow(), 1).toString();
                kelas = (String) table.getValueAt(table.getSelectedRow(), 2);
                editUI.tampilkanForm(nim, nama, kelas);
            }
        }
    }

    private class BtnTambahClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            tambahUI.setVisible(true);
        }
    }

}