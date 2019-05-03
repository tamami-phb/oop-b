package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import services.*;
import javax.sound.sampled.*;
import java.io.*;

public class MainUI extends JFrame {

    private JButton btnPlay;
    private JButton btnStop;
    private JButton btnPause;
    private JButton btnResume;
    private Container contentPane;
    private MyPlayer player;

    public MainUI() {
        try {
            player = new MyPlayer("./audio/sample.au");
        } catch(UnsupportedAudioFileException e) {
            JOptionPane.showMessageDialog(this,
                    "file tidak didukung");
        } catch(LineUnavailableException e) {
            JOptionPane.showMessageDialog(this,
                    "Hubungi developer");
        } catch(IOException e) {
            JOptionPane.showMessageDialog(this,
                    "File tidak dapat diakses");
        }
        initUI();
    }

    private void initUI() {
        btnPlay = new JButton("Putar");
        btnStop = new JButton("Hentikan");
        btnPause = new JButton("Jeda");
        btnResume = new JButton("Lanjutkan");

        contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));

        contentPane.add(btnPlay);
        contentPane.add(btnPause);
        contentPane.add(btnResume);
        contentPane.add(btnStop);

        btnStop.setEnabled(false);
        btnPause.setEnabled(false);
        btnResume.setEnabled(false);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnPlay.addActionListener(new BtnPlayClick());
        btnStop.addActionListener(new BtnStopClick());
        btnPause.addActionListener(new BtnPauseClick());
        btnResume.addActionListener(new BtnResumeClick());
    }


    // ----------- events

    private class BtnPauseClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            player.pause();
            btnPause.setEnabled(false);
            btnPlay.setEnabled(false);
            btnResume.setEnabled(true);
            btnStop.setEnabled(true);
        }
    }

    private class BtnResumeClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            try {
                player.resume();
                btnResume.setEnabled(false);
                btnPlay.setEnabled(false);
                btnPause.setEnabled(true);
                btnStop.setEnabled(true);
            } catch(UnsupportedAudioFileException e) {
                JOptionPane.showMessageDialog(null,
                        "file tidak didukung");
            } catch(LineUnavailableException e) {
                JOptionPane.showMessageDialog(null,
                        "Hubungi developer");
            } catch(IOException e) {
                JOptionPane.showMessageDialog(null,
                        "File tidak dapat diakses");
            }
        }
    }

    private class BtnPlayClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            player.play();
            btnPlay.setEnabled(false);
            btnPause.setEnabled(true);
            btnResume.setEnabled(false);
            btnStop.setEnabled(true);
        }
    }

    private class BtnStopClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            try {
                player.stop();
                btnStop.setEnabled(false);
                btnPlay.setEnabled(true);
                btnPause.setEnabled(false);
                btnResume.setEnabled(false);
            } catch(UnsupportedAudioFileException e) {
                JOptionPane.showMessageDialog(null,
                    "file tidak didukung");
            } catch(LineUnavailableException e) {
                JOptionPane.showMessageDialog(null,
                    "Hubungi developer");
            } catch(IOException e) {
                JOptionPane.showMessageDialog(null,
                    "File tidak dapat diakses");
            }
        }
    }

}