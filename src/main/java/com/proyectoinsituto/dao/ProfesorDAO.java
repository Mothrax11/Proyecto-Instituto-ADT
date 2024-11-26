package com.proyectoinsituto.dao;
import java.util.List;
import com.proyectoinsituto.entidades.ProfesorEntidad;

public interface ProfesorDAO {
    public void crearProfesor(ProfesorEntidad profesor);
    public ProfesorEntidad obtenerProfesorPorId(String id);
    public List<ProfesorEntidad> obtenerTodosLosProfesores();
    public boolean actualizarProfesor(ProfesorEntidad profesor);
    public boolean eliminarProfesor(String id);
    public List<String> obtenerModulosPorId();
}
