package com.proyectoinsituto.entidades;

import java.util.Date;

public class AlumnoEntidad {
    private String codAlumno;
    private String nombreAlumno;
    private String apellidoAlumno;
    private Date fechaNacimiento;
    private char grupo;

    public AlumnoEntidad(String codAlumno, String nombreAlumno, String apellidoAlumno, Date fechaNacimiento, char grupo) {
        this.codAlumno = codAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.fechaNacimiento = fechaNacimiento;
        this.grupo = grupo;
    }

    public AlumnoEntidad (){

    }

    public String getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Alumno [codAlumno=" + codAlumno + ", nombreAlumno=" + nombreAlumno + ", apellidoAlumno="
                + apellidoAlumno + ", fechaNacimiento=" + fechaNacimiento + ", grupo=" + grupo + "]";
    }
}
