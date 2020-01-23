package me.erase.ytmp3;

import me.erase.ytmp3.gui.Components;
import me.erase.ytmp3.gui.Gui;
import me.erase.ytmp3.listener.Listener;
import me.erase.ytmp3.setup.Setup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final String DATA_PATH = System.getProperty("user.home") + "\\.ytmp3";
    private static final Components COMPONENTS = new Components();
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) {
        new Gui();
        new Setup();
        new Listener();
    }

    public static Components getComponents() {
        return COMPONENTS;
    }

    public static void run(Runnable runnable) {
        THREAD_POOL.submit(runnable);
    }
}
