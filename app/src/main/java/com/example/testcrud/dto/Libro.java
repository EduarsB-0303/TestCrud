package com.example.testcrud.dto;

import java.io.Serializable;

public class Libro implements Serializable {
    private int codigo;
    private String nombre;
    private int paginas;

    public Libro(){
    }

    public Libro(int codigo, String nombre, int paginas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.paginas = paginas;
    }

    public Libro(String nombre, int paginas) {
        this.nombre = nombre;
        this.paginas = paginas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString()
    {
        return (this.getCodigo() + " || " + this.getNombre() + " (" + getPaginas() + " paginas)");
    }
}
