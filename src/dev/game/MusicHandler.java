package dev.game;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import java.io.*;


public class MusicHandler {
    private static MusicHandler instance = new MusicHandler();
    private Sequencer sequencer;

    private MusicHandler() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playSong(File file) {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            sequencer.setSequence(is);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MusicHandler getInstance() {
        return instance;
    }
}
