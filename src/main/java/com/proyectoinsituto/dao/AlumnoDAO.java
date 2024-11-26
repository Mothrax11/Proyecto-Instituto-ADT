package com.proyectoinsituto.dao;
import java.util.List;
import com.proyectoinsituto.entidades.AlumnoEntidad;

public interface AlumnoDAO {
    public void crearAlumno(AlumnoEntidad alumno);
    public AlumnoEntidad obtenerAlumnoPorId(String id);
    public List<AlumnoEntidad> obtenerTodosLosAlumnos();
    public boolean actualizarAlumno(AlumnoEntidad alumno);
    public boolean eliminarAlumno(String id);
    public List<String> obtenerModulosPorId();
}
