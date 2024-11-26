package com.proyectoinsituto.dao;
import java.util.List;
import com.proyectoinsituto.entidades.ModuloEntidad;

public interface ModuloDAO {
    public void crearModulo(ModuloEntidad modulo);
    public ModuloEntidad obtrenerModuloPorId(String id);
    public List <ModuloEntidad> obtenerTodosLosModulos();
    public boolean actualizarModulo(ModuloEntidad modulo);
    public boolean eliminarModulo(String id);
    public List<ModuloEntidad> obtenerModulosPorIdProfesor(String id);
    
}
