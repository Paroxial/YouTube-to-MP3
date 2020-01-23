package me.erase.ytmp3.setup;

import me.erase.material.component.MaterialButton;
import me.erase.material.component.MaterialTextField;
import me.erase.ytmp3.Main;
import me.erase.ytmp3.gui.Components;
import me.erase.ytmp3.utils.WebUtil;
import net.lingala.zip4j.core.ZipFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static me.erase.ytmp3.Main.DATA_PATH;

public class Setup {
    private static final String ZIP_PATH = DATA_PATH + "\\deps.zip";
    private final Components components = Main.getComponents();

    public Setup() {
        Path dataPath = Paths.get(DATA_PATH);

        if (!Files.exists(dataPath)) {
            try {
                Files.createDirectory(dataPath);
                Files.setAttribute(dataPath, "dos:hidden", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            setupTransfer();
        }
    }

    private void setupTransfer() {
        Runnable runnable = () -> {
            try {
                MaterialButton button = components.materialButton;
                MaterialButton button2 = components.materialButton2;
                MaterialTextField textField = components.materialTextField;

                textField.setVisible(false);
                button.setVisible(false);
                button2.setText("Setting up... Please wait.");                System.out.println(Thread.currentThread().getName());


                String link = WebUtil.getDirectDownload("http://www.mediafire.com/file/o4o5a562o1u6jc6/deps.zip");

                try (ReadableByteChannel channel = Channels.newChannel(new URL(link).openStream())) {
                    try (FileOutputStream stream = new FileOutputStream(ZIP_PATH)) {
                        stream.getChannel().transferFrom(channel, 0, Long.MAX_VALUE);

                        ZipFile zip = new ZipFile(ZIP_PATH);
                        zip.extractAll(DATA_PATH);
                    }

                    Files.deleteIfExists(Paths.get(ZIP_PATH));

                    textField.setVisible(true);
                    button.setVisible(true);
                    button2.setText("Ready. Your converted file will appear on the desktop.");
                }
            } catch (Exception ignored) {
            }
        };

        System.out.println(Thread.currentThread().getName());
        runnable.run();
        System.out.println("yo");

      //  Main.run(runnable);
    }
}
