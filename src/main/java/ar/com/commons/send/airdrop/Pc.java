package ar.com.commons.send.airdrop;

import java.io.Serializable;

/**
 * Created by lequerica on 11/22/18.
 */

public class Pc implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String ip;
    private String nombreEquipo;


    public Pc(String ip){
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }



}
