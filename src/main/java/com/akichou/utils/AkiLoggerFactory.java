package com.akichou.utils;

public final class AkiLoggerFactory {

    public static AkiLogger getAkiLogger(String className) {

        return new AkiLogger(className) ;
    }

    public static AkiLogger getAkiLogger(Class<?> clazz) {

        return new AkiLogger(clazz);
    }
}
