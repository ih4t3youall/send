package ar.com.commons.send.airdrop.services;

import ar.com.commons.send.airdrop.Constantes;
import ar.com.commons.send.airdrop.Mensaje;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class EnviarMensaje extends Thread{

    public Mensaje mensaje;
    private static int PUERTO = Constantes.PUERTO;

    public EnviarMensaje(Mensaje mensaje){
        this.mensaje = mensaje;
    }

    public void run(){



        Socket socket = null;
        ObjectOutputStream buffer = null;

        try {
            //TODO ver que pasa aca que en debian trae localhost en ves de la ip
            //TODO esto tiene que ser un thread
            socket = new Socket(mensaje.getIpDestino(), PUERTO);

            buffer = new ObjectOutputStream(socket.getOutputStream());

            buffer.writeObject(mensaje);

        } catch (Exception e) {

            String error = "Error con el socket al acceder al puerto : ";
            e.printStackTrace();

        } finally {

            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    String error = "Error al cerrar el socket : ";
                    e.printStackTrace();
                }

            }

        }
    }

}





