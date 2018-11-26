package ar.com.commons.send.dto;

import java.io.Serializable;

public class IpDTO implements Serializable {

    private String nombrePc;
    private String ip;

    public String getNombrePc() {
        return nombrePc;
    }

    public void setNombrePc(String nombrePc) {
        this.nombrePc = nombrePc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
