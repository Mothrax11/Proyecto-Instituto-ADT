package com.proyectoinsituto.dto;

import java.io.Serializable;


public class AlumnoDTO implements Serializable {
    private String idAlumno;
    private String nombreAlumno;
    private String apellidoAlumno;
    private int edad;
    private char grupo;

    public AlumnoDTO(String idAlumno, String nombreAlumno, String apellidoAlumno, int edad, char grupo) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.edad = edad;
        this.grupo = grupo;
    }
    
    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }
    
    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "AlumnoDTO [idAlumno=" + idAlumno + ", nombreAlumno=" + nombreAlumno + ", apellidoAlumno="
                + apellidoAlumno + ", edad=" + edad + ", grupo=" + grupo + "]";
    }
}
