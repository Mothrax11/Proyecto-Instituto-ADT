package com.proyectoinsituto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.proyectoinsituto.entidades.ModuloEntidad;

public class ModuloDAOImplementacion implements ModuloDAO {

    private static ModuloDAOImplementacion instancia;
    private DataSource dataSource;

    private ModuloDAOImplementacion(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static ModuloDAOImplementacion getInstancia(DataSource dataSource) {
        if(instancia == null) {
            return new ModuloDAOImplementacion(dataSource);
        }
        return instancia;
    }

    @Override
    public void crearModulo(ModuloEntidad modulo) {

    }

    @Override
    public ModuloEntidad obtrenerModuloPorId(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtrenerModuloPorId'");
    }

    @Override
    public List<ModuloEntidad> obtenerTodosLosModulos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodosLosModulos'");
    }

    @Override
    public boolean actualizarModulo(ModuloEntidad modulo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarModulo'");
    }

    @Override
    public boolean eliminarModulo(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarModulo'");
    }
    
}
