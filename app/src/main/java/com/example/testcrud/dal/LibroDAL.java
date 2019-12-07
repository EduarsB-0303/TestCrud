package com.example.testcrud.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testcrud.dto.Libro;
import com.example.testcrud.helpers.DatabaseHelper;

import java.util.ArrayList;

public class LibroDAL {
    private DatabaseHelper dbHelper;
    private Libro libro;

    //Constructores
    public LibroDAL(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.libro = new Libro();
    }

    public LibroDAL(Context context, Libro libro){
        this.dbHelper = new DatabaseHelper(context);
        this.libro = libro;
    }

    //Métodos CRUD
    //Insertar
    public boolean insertar(String nombre, int paginas) {
        this.libro.setNombre(nombre);
        this.libro.setPaginas(paginas);

        return this.tryInsert();
    }

    private boolean tryInsert() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put("nombre", this.libro.getNombre());
        c.put("pagina", this.libro.getPaginas());

        try {
            db.insert("libro",null,c);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    //Actualizar
    public boolean actualizar(Libro libro) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put("codigo", libro.getCodigo());
        c.put("nombre", libro.getNombre());
        c.put("paginas", libro.getPaginas());

        try {
            int filasAfectadas;
            filasAfectadas = db.update("libro", c, "codigo = ?", new String[] { String.valueOf(libro.getCodigo())});
            return (filasAfectadas > 0);
        } catch (Exception e) {

        }
        return false;
    }

    //Ver
    public ArrayList<Libro> seleccionar() {
        ArrayList<Libro> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor consulta = db.rawQuery("SELECT * FROM libro", null);

        if(consulta.moveToFirst()) {
            do {
                int codigo = consulta.getInt(0);
                String nombre = consulta.getString(1);
                int paginas = consulta.getInt(3);

                Libro libro = new Libro(codigo,nombre,paginas);
                lista.add(libro);

            } while(consulta.moveToNext());
        }
        return lista;
    }

    //Eliminar
    public boolean eliminar(int codigo) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        int filasAfectadas;

        try {
            filasAfectadas = db.delete("libro","codigo = ?", new String[] { String.valueOf(codigo)});
        } catch (Exception e) {
            return false;
        }

        return (filasAfectadas == 1);
    }

    //????
    public Libro getLibro() {
        return this.libro;
    }
}
