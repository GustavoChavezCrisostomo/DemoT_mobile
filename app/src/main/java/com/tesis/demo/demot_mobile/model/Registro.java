package com.tesis.demo.demot_mobile.model;

/**
 * Created by Alumno on 21/06/2018.
 */

public class Registro {
    private Integer id;
    private long historia;
    private long resultado;
    private  Integer alumno_id;

    public Registro(){

    }

    public Registro(Integer id, long historia, long resultado, Integer alumno_id) {
        this.id = id;
        this.historia = historia;
        this.resultado = resultado;
        this.alumno_id = alumno_id;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public long getHistoria() {return historia;}
    public void setHistoria(long historia) {this.historia = historia;}

    public long getResultado() {return resultado;}
    public void setResultado(long resultado) {this.resultado = resultado;}

    public Integer getAlumno_id() {return alumno_id;}
    public void setAlumno_id(Integer alumno_id) {this.alumno_id = alumno_id;}

    @Override
    public String toString() {
        return "Registro{" +
                "id=" + id +
                ", historia=" + historia +
                ", resultado=" + resultado +
                ", alumno_id=" + alumno_id +
                '}';
    }
}
