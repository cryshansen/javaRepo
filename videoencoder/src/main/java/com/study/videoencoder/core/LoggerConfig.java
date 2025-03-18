package com.study.videoencoder.core;

import java.util.logging.*;

public class LoggerConfig {
    public static Logger getLogger(Class<?> clazz) {
        Logger logger = Logger.getLogger(clazz.getName());
        logger.setLevel(Level.INFO);
        return logger;
    }
}
