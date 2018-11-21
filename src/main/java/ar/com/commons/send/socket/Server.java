package ar.com.commons.send.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    private String directory;
    private int port;

    public Server( String directory){
        this.directory = directory;
        this.port = 5000;
    }
    public Server( String directory,int port){
        this.directory = directory;
        this.port = port;
    }

    public void run(){

        ServerSocket server;
        Socket connection;

        DataOutputStream output;
        BufferedInputStream bis;
        BufferedOutputStream bos;

        byte[] receivedData;
        int in;
        String file;

        try{
            //Servidor Socket en el puerto 5000
            server = new ServerSocket( port );
            System.out.println("iniciando");
            while ( true ) {
                //Aceptar conexiones
                connection = server.accept();
                //Buffer de 1024 bytes
                receivedData = new byte[1024];
                bis = new BufferedInputStream(connection.getInputStream());
                DataInputStream dis=new DataInputStream(connection.getInputStream());
                //Recibimos el nombre del fichero
                file = dis.readUTF();
                file = file.substring(file.indexOf('\\')+1,file.length());
                file = directory +"//"+ file;
                System.out.println("file: " +file.toString());
                //Para guardar fichero recibido
                bos = new BufferedOutputStream(new FileOutputStream(file));
                while ((in = bis.read(receivedData)) != -1){
                    bos.write(receivedData,0,in);
                }
                bos.close();
                dis.close();
            }
        }catch (Exception e ) {
            System.err.println(e);
        }
    }
}
