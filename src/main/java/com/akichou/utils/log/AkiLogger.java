package com.akichou.utils.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class AkiLogger {

    private static Logger logger ;

    private static final String DEFAULT_LOG_DIR = "logs" ;

    // Create Logger with Class Name
    public AkiLogger(String name) {

        ensureLogDirectoryExists() ;

        logger = LogManager.getLogger(name) ;
    }

    // Create Logger with CLass
    public AkiLogger(Class<?> clazz) {

        ensureLogDirectoryExists() ;

        logger = LogManager.getLogger(clazz) ;
    }

    private void ensureLogDirectoryExists() {

        try {

            //System.setProperty("log4j.configurationFile", "log4j2-test.xml") ;

            // Get log path from configuration or env variable
            String logPath = System.getProperty("log.dir", DEFAULT_LOG_DIR) ;
            Path path = Paths.get(logPath) ;

            // Create log directory
            if (!Files.exists(path)) Files.createDirectories(path) ;

            // Test isWritable
            if (!Files.isWritable(path)) throw new IOException("Log directory isn't writable: " + path) ;

        } catch (IOException e) {

            String errorMsg = "Failed to create or verify log directory: " + e.getMessage() ;

            System.err.println(errorMsg) ;

            throw new RuntimeException(errorMsg, e) ;
        }
    }

    // Get the current log directory
    public static String getLogDirectory() {

        return System.getProperty("log.dir", DEFAULT_LOG_DIR) ;
    }

    // Update the current log directory
    public static void setLogDirectory(String newPath) {

        System.setProperty("log.dir", newPath) ;
    }

    // ERROR LEVEL
    public void error(String msg) {

        logger.error(msg) ;
    }

    public void error(String msg, Throwable e) {

        logger.error(msg, e) ;
    }

    public void error(String msg, Object... param) {

        logger.error(msg, param) ;
    }

    public String errorAndGet(String msg) {

        logger.error(msg) ;

        return msg ;
    }

    public String errorAndGet(String msg, Throwable e) {

        logger.error(msg, e) ;

        return msg ;
    }

    public String errorAndGet(String msg, Object... param) {

        String formattedMsg = formatMessage(msg, param) ;

        logger.error(formattedMsg) ;

        return formattedMsg ;
    }

    public void errorWithStack(String msg, Throwable e) {       // Log exception whole Stack

        StringBuilder stringBuilder = stackException(msg, e) ;

        logger.error(stringBuilder.toString()) ;
    }

    public String errorWithStackAndGet(String msg, Throwable e) {

        StringBuilder stringBuilder = stackException(msg, e) ;

        logger.error(stringBuilder.toString()) ;

        return stringBuilder.toString() ;
    }

    private StringBuilder stackException(String msg, Throwable e) {

        StringBuilder stringBuilder = new StringBuilder(msg)
                .append("\nException: ")
                .append(e.getClass().getName())
                .append("\nMessage: ")
                .append(e.getMessage())
                .append("\nStack trace:\n") ;

        for (StackTraceElement element : e.getStackTrace()) {

            stringBuilder.append("\tat ").append(element.toString()).append("\n") ;
        }

        return stringBuilder ;
    }

    public void errorRootCause(String msg, Throwable e) {           // Log exception main cause

        Throwable rootCause = getRootCause(e) ;

        logger.error("{} Root cause: {}", msg, rootCause.getMessage(), rootCause) ;
    }

    public String errorRootCauseAndGet(String msg, Throwable e) {

        Throwable rootCause = getRootCause(e) ;

        String formattedMsg = formatMessage("{} Root cause: {}", msg, rootCause.getMessage(), rootCause) ;

        logger.error(formattedMsg) ;

        return formattedMsg ;
    }

    private Throwable getRootCause(Throwable e) {

        Throwable cause = e ;

        while (cause.getCause() != null) {

            cause = cause.getCause() ;
        }

        return cause ;
    }

    public void errorWithPrefix(String prefix, String msg, Object... param) {

        String prefixString = getDefaultPrefix(prefix) ;

        String formattedMsg = formatMessage(msg, param) ;

        logger.error("[{}] {}", prefixString, formattedMsg) ;
    }

    public String errorWithPrefixAndGet(String prefix, String msg, Object... param) {

        String prefixString = getDefaultPrefix(prefix) ;

        String formattedMsg = formatMessage(msg, param) ;

        String formattedMsgWithPrefix = "[" + prefixString + "] " + formattedMsg ;

        logger.error(formattedMsgWithPrefix) ;

        return formattedMsgWithPrefix;
    }

    // WARN LEVEL
    public void warn(String msg) {

        logger.warn(msg) ;
    }

    public void warn(String msg, Object... param) {

        logger.warn(msg, param) ;
    }

    public String warnAndGet(String msg) {

        logger.warn(msg) ;

        return msg ;
    }

    public String warnAndGet(String msg, Object... param) {

        String formattedMsg = formatMessage(msg, param) ;

        logger.warn(msg, param) ;

        return formattedMsg ;
    }

    public void warnWithPrefix(String prefix, String msg, Object... param) {

        String prefixString = getDefaultPrefix(prefix) ;

        String formattedMsg = formatMessage(msg, param) ;

        logger.warn("[{}] {}", prefixString, formattedMsg) ;
    }

    public String warnWithPrefixAndGet(String prefix, String msg, Object... param) {

        String prefixString = getDefaultPrefix(prefix) ;

        String formattedMsg = formatMessage(msg, param) ;

        String formattedMsgWithPrefix = "[" + prefixString + "] " + formattedMsg ;

        logger.warn(formattedMsgWithPrefix) ;

        return formattedMsgWithPrefix ;
    }

    // INFO LEVEL
    public void info(String msg) {

        logger.info(msg) ;
    }

    public void info(String msg, Object... param) {

        logger.info(msg, param) ;
    }

    public String infoAndGet(String msg) {

        logger.info(msg) ;

        return msg ;
    }

    public String infoAndGet(String msg, Object... param) {

        String formattedMsg = formatMessage(msg, param) ;

        logger.info(formattedMsg) ;

        return formattedMsg ;
    }

    public void infoWithPrefix(String prefix, String msg, Object... param) {

        String prefixString = getDefaultPrefix(prefix) ;

        String formattedMsg = formatMessage(msg, param) ;

        logger.info("[{}] {}", prefixString, formattedMsg) ;
    }

    public String infoWithPrefixAndGet(String prefix, String msg, Object... param) {

        String prefixString = getDefaultPrefix(prefix) ;

        String formattedMsg = formatMessage(msg, param) ;

        String formattedMsgWithPrefix = "[" + prefixString + "] " + formattedMsg ;

        logger.info(formattedMsgWithPrefix) ;

        return formattedMsgWithPrefix ;
    }

    // USER OPERATION
    public void logNormalOperation(String operation, String userId) {

        info("User [ID = {}] performed operation: {}", userId, operation) ;
    }

    public void logSensitiveOperation(String operation, String adminId, String targetId) {

        warn("Admin [ID = {}] performed sensitive operation: {} on target: {}",
                adminId, operation, targetId) ;
    }

    // Format message with param using placeholder
    private String formatMessage(String msg, Object... param) {

        return ParameterizedMessage.format(msg, param) ;
    }

    private String getDefaultPrefix(String prefix) {

        if (prefix == null || prefix.isEmpty()) return "Prefix" ;

        return prefix ;
    }
}
