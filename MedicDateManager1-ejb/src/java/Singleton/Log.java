/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Startup;

/**
 *
 * @author forjaser
 */
@Singleton
@Startup
@LocalBean
public class Log {

    private static final String path = "/home/forjaser/NetBeansProjects/MedicDateManager1/logs/control.log";
    private static Logger log;
    FileHandler archivos;
    private static int segundos;

    @Lock(LockType.READ)
    public static Logger getLog() {
        return log;
    }
    @PostConstruct
    public void init() {
        log = Logger.getLogger(Log.class.getName());
        segundos = 0;
        for (Handler h : log.getHandlers()) {
            log.removeHandler(h);
        }
        try {
            archivos = new FileHandler(path);
            log.addHandler(archivos);
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Schedule(hour = "*", minute = "*", second = "*/1")
    @Lock(LockType.WRITE)
    public void incrementarSegundos() {
        segundos++;
    }

    @Schedule(hour = "*", minute = "*", second = "*/5")
    @Lock(LockType.WRITE)
    public void actualizarLog() {
        if(segundos>=5){
            log.log(Level.INFO,"Doing nothing");
            segundos=0;
        }
    }

    @Lock(LockType.WRITE)
    public static void saveJSP(String rutaAcceso) {
        log.log(Level.INFO, rutaAcceso);
        segundos=0;
    }

    @Lock(LockType.WRITE)
    public static void saveCommands(String comando) {
        log.log(Level.INFO, comando);
        segundos=0;
    }

    @Lock(LockType.WRITE)
    public static void saveException(String excepcion) {
        log.log(Level.INFO, excepcion);
        segundos=0;
    }

    @Lock(LockType.READ)
    public static String readLog() {
        String resultado = "";
        try {
            BufferedReader lector = new BufferedReader(new FileReader(path));
            try {
                String linea = lector.readLine();
                while (linea != null) {
                    resultado += linea;
                    linea = lector.readLine();
                }
            } catch (IOException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                Log.saveException(ex.getMessage()); //Guardar en mi log
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            Log.saveException(ex.getMessage());
        }
        return resultado;
    }

}
