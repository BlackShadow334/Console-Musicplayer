package com.blackshadow334.java.console_musicplayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Sound {
    public static void playSound() throws IOException, LineUnavailableException, UnsupportedAudioFileException {

        File sound = new File("Music-Library/Pretty Boy - DJ Freedem.wav");
        AudioInputStream audio_stream = AudioSystem.getAudioInputStream(sound);
        Clip clip = AudioSystem.getClip();
        clip.open(audio_stream);
        Scanner scanner = new Scanner(System.in);
        String response = "";

        System.out.println("Sound Playing...");
        clip.start();

        while (!response.equals("Q")){
            System.out.println("R = Restart, P = Pause/Play, Q = Quit");
            System.out.print("Input: ");
            response = scanner.nextLine().toUpperCase().trim();

            switch (response){

                case "P":
                    if (clip.isActive()) {
                        clip.stop();
                        System.out.println("Music Paused ! ");
                    }else{
                        clip.start();
                        System.out.println("Music is Playing...");
                    }
                    break;

                case "Q":
                    System.out.println("Quitting...");
                    break;
                case "R" :
                    System.out.println("Restarting...");
                    clip.setMicrosecondPosition(0);
                    System.out.println("Music Restarted !");
                    break;
                default:
                    System.out.println("Please enter Valid Input");
                    break;
            }
        }
    }
}

