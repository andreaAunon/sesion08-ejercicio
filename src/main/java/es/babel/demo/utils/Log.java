package es.babel.demo.utils;

import es.babel.demo.Sesion08EjercicioApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final Logger logger = LogManager.getLogger(Sesion08EjercicioApplication.class);

    public static void trace(String message){
        logger.trace(message);
    }

    public static void debug(String message){
        logger.trace(message);
    }

    public static void info(String message){
        logger.trace(message);
    }

    public static void warn(String message){
        logger.trace(message);
    }

    public static void error(String message){
        logger.trace(message);
    }

    public static void fatal(String message){
        logger.trace(message);
    }
}
