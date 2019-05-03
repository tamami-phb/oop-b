package services;

import java.io.*;
import javax.sound.sampled.*;

public class MyPlayer {

    private AudioInputStream ais;
    private Clip clip;
    private Long posisiPause;
    private String filePath;

    public MyPlayer(String filePath) throws
            UnsupportedAudioFileException,
            LineUnavailableException,
            IOException {
        ais = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(ais);
        this.filePath = filePath;
    }

    public void play() {
        clip.start();
    }

    public void stop() throws
            UnsupportedAudioFileException,
            LineUnavailableException,
            IOException {
        clip.stop();
        reset();
    }

    public void pause() {
        posisiPause = clip.getMicrosecondPosition();
        clip.stop();
    }

    public void resume() throws
            UnsupportedAudioFileException,
            LineUnavailableException,
            IOException {
        reset();
        clip.setMicrosecondPosition(posisiPause);
        clip.start();
    }

    public void reset() throws
            UnsupportedAudioFileException,
            LineUnavailableException,
            IOException {
        clip.close();
        ais = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(ais);
    }

}