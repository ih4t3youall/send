package ar.com.commons.send.socket;


import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    String filename;
    String url;
    int port = 5000;

    public Client(String filename, String url){
       this.filename = filename;
       this.url = url;
    }
    public Client(String filename, String url,int port){
        this.filename = filename;
        this.url = url;
        this.port = port;
    }

    public static void main(String [] args){

      String filename = "/Users/lequerica/Desktop/script";
      Client client = new Client(filename,"localhost");
      Thread t = new Thread(client);
      t.start();

    }
    @Override
    public void run(){
        DataInputStream input;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        int in;
        byte[] byteArray;
        //Fichero a transferir
        //final String filename = "c:\\test.pdf";

        try{
            final File localFile = new File( filename );
            Socket client = new Socket(url, port);
            bis = new BufferedInputStream(new FileInputStream(localFile));
            bos = new BufferedOutputStream(client.getOutputStream());
            //Enviamos el nombre del fichero
            DataOutputStream dos=new DataOutputStream(client.getOutputStream());
            dos.writeUTF(localFile.getName());
            //Enviamos el fichero
            byteArray = new byte[8192];
            while ((in = bis.read(byteArray)) != -1){
                bos.write(byteArray,0,in);
            }

            bis.close();
            bos.close();

        }catch ( Exception e ) {
            e.printStackTrace();
            System.err.println(e);
        }
    }

}
