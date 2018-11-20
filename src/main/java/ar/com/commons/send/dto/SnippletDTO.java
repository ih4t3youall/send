package ar.com.commons.send.dto;


import ar.com.commons.send.domain.Snipplet;

import java.io.Serializable;

public class SnippletDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String nombreCategoria;
    private String titulo;
    private String contenido;

    public void setNombreCategoria(String nombreCategoria){
        this.nombreCategoria=nombreCategoria;
    }
    public SnippletDTO(){}
    public String getNombreCategoria(){
        return this.nombreCategoria;

    }
    public SnippletDTO(Snipplet snipplet){
        this.titulo = snipplet.getTitulo();
        this.contenido = snipplet.getContenido();
    }

    public SnippletDTO(Snipplet snipplet, String nombreCategoria){
        this.titulo = snipplet.getTitulo();
        this.contenido = snipplet.getContenido();
        this.nombreCategoria = nombreCategoria;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean buscarTexto(String palabra) {

        if (contenido.indexOf(palabra) != -1 || titulo.indexOf(palabra) != -1) {

            return true;
        } else {

            return false;

        }

    }

    @Override
    public String toString(){
        return this.titulo;

    }




}
