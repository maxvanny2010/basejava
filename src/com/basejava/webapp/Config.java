package com.basejava.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final File PROPS = new File("config/resumes.properties");
    private static final Config INSTANCE = new Config();

    private Properties properties = new Properties();
    private File storageDir;

    public static Config getInstance() {
        return INSTANCE;
    }

    private Config() {
        try (InputStream is = new FileInputStream(PROPS)) {
            properties.load(is);
            storageDir = new File(properties.getProperty("storage.dir"));
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file" + PROPS.getAbsolutePath());
        }
    }

    public File getStorageDir() {
        return storageDir;
    }
}