package com.proyectoinsituto.entidades;

public class ModuloEntidad {
    private String codModulo;
    private String nombreModulo;
    private String codCiclo;
    private int curso;
    private String codProfesor;

    public ModuloEntidad(String codModulo, String nombreModulo, String codCiclo, int curso, String codProfesor) {
        this.codModulo = codModulo;
        this.nombreModulo = nombreModulo;
        this.codCiclo = codCiclo;
        this.curso = curso;
        this.codProfesor = codProfesor;
    }

    public ModuloEntidad (){

    }

    public String getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(String codModulo) {
        this.codModulo = codModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public String getCodCiclo() {
        return codCiclo;
    }

    public void setCodCiclo(String codCiclo) {
        this.codCiclo = codCiclo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(String codProfesor) {
        this.codProfesor = codProfesor;
    }

    @Override
    public String toString() {
        return "ModuloEntidad [codModulo=" + codModulo + ", nombreModulo=" + nombreModulo + ", codCiclo=" + codCiclo
                + ", curso=" + curso + ", codProfesor=" + codProfesor + "]";
    }
}
