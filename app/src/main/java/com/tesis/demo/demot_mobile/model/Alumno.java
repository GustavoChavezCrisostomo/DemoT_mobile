package com.tesis.demo.demot_mobile.model;

public class Alumno {

    private Integer id;
    private String correo;
    private String password;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String carrera;
    private Integer ciclo;

    public Alumno(){

    }

    public Alumno(Integer id, String correo, String password, String nombre, String apellido, Integer edad, String carrera, Integer ciclo) {
        this.id = id;
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
        this.ciclo = ciclo;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public Integer getEdad() {return edad;}
    public void setEdad(Integer edad) {this.edad = edad;}

    public String getCarrera() {return carrera;}
    public void setCarrera(String carrera) {this.carrera = carrera;}

    public Integer getCiclo() {return ciclo;}
    public void setCiclo(Integer ciclo) {this.ciclo = ciclo;}

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", carrera='" + carrera + '\'' +
                ", ciclo=" + ciclo +
                '}';
    }


}
