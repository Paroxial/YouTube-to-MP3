package me.erase.ytmp3.listener;

import me.erase.ytmp3.Main;
import me.erase.ytmp3.gui.Components;

import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static me.erase.ytmp3.Main.DATA_PATH;
import static me.erase.ytmp3.Main.run;

public class Listener {
    private static final String YOUTUBE_REGEX = "http(?:s?):\\/\\/(?:www\\.)?youtu(?:be\\.com\\/watch\\?v=|\\.be\\/)([\\w\\-\\_]*)(&(amp;)?\u200C\u200B[\\w\\?\u200C\u200B=]*)?";
    private static final String DESKTOP_PATH = System.getProperty("user.home") + "\\Desktop";
    private final Components components = Main.getComponents();

    public Listener() {
        setupListener();
    }

    private void setupListener() {
        components.materialButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                runProcess();
            }
        });

        components.materialTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (components.materialTextField.getText().equals(" Insert link here")) {
                    components.materialTextField.setText("");
                }
            }
        });
    }

    private void runProcess() {
        Runnable runnable = () -> {
            try {
                String inputText = components.materialTextField.getText().trim();
                String actualUrl = inputText.split("&")[0];

                if (!inputText.equals(actualUrl)) {
                    inputText = actualUrl;
                    components.materialTextField.setText(inputText);
                }

                if (!inputText.matches(YOUTUBE_REGEX)) {
                    components.materialButton2.setText("Please enter a valid URL.");
                    return;
                }

                components.materialButton.setVisible(false);

                String command = "cmd.exe /c" + DATA_PATH + "\\youtube-dl.exe --extract-audio --audio-format mp3 --audio-quality 0 -o \"" + DESKTOP_PATH + "\\%(title)s~~%(id)s.%(ext)s\" " + inputText;
                Process process = Runtime.getRuntime().exec(command);

                components.materialButton2.setText("Converting... Please wait.");

                process.waitFor();

                components.materialButton2.setText("Finished and saved to desktop!");
                components.materialButton.setText("Convert Next");
                components.materialButton.setVisible(true);

                File desktopFolder = new File(DESKTOP_PATH);
                File foundFile = null;
                String videoId = inputText.split("v=")[1];
                String newFileName = DESKTOP_PATH + "\\ytmp3-downloaded-" + UUID.randomUUID() + ".mp3";

                for (File next : desktopFolder.listFiles()) {
                    String name = next.getName();
                    String[] splitName = name.split("~~");

                    if (splitName.length > 1 && splitName[1].substring(0, splitName[1].length() - 4).equals(videoId)) {
                        newFileName = DESKTOP_PATH + "\\" + splitName[0] + ".mp3";
                        foundFile = next;
                    }
                }

                if (foundFile == null) {
                    components.materialButton2.setText("Something went wrong. Please try again.");
                } else {
                    File renamedFile = new File(newFileName);
                    foundFile.renameTo(renamedFile);

                    components.materialButton2.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent event) {
                            try {
                                Desktop.getDesktop().open(renamedFile);
                            } catch (IOException ignored) {
                            }
                        }
                    });

                    components.materialButton2.setText("Finished and saved to desktop! Click to open.");
                }
            } catch (Exception ignored) {
            }
        };

        runnable.run();

      //  Main.run(runnable);
    }
}
