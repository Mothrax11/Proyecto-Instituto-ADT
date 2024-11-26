package com.proyectoinsituto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.proyectoinsituto.entidades.ProfesorEntidad;

public class ProfesorDAOImplementacion implements ProfesorDAO {
    
    private static ProfesorDAOImplementacion instancia;
    private DataSource dataSource;

    private ProfesorDAOImplementacion(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public static ProfesorDAOImplementacion getInstancia(DataSource dataSource){
        if(instancia == null){
            return new ProfesorDAOImplementacion(dataSource);
        }
        return instancia;
    }

    @Override
    public void crearProfesor(ProfesorEntidad profesor){
        String sql = "INSERT INTO profesor (cod_profesor, nombre_profesor, ciudad) VALUES (?,?,?)"; 
        try(Connection connection= dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, profesor.getCodProfesor());
                statement.setString(2, profesor.getNombreProfesor());
                statement.setString(3, profesor.getCiudad());
                statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ProfesorEntidad obtenerProfesorPorId(String id) {
        String sql = "SELECT codProfesor, nombreProfesor, ciudad FROM profesor WHERE codProfesor = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()){ 
                    if(resultSet.next()){
                        return mapearResultSetAProfesor(resultSet);
                    }
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
            return null;
    }

    @Override
    public List<ProfesorEntidad> obtenerTodosLosProfesores() {
        List<ProfesorEntidad> profesores = new ArrayList<>();
        String sql = "SELECT cod_profesor, nombre_profesor, ciudad FROM profesor";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                    ProfesorEntidad profesor = mapearResultSetAProfesor(resultSet);
                    profesores.add(profesor);    
                }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return profesores;
    }


    @Override
    public boolean actualizarProfesor(ProfesorEntidad profesor) {
        String sql = "Update profesor set nombre_profesor = ?, ciudad = ? where cod_profesor = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, profesor.getNombreProfesor());
                statement.setString(2, profesor.getCiudad());
                statement.executeUpdate();
                return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarProfesor(String id) {
       
    }

    @Override
    public List<String> obtenerModulosPorId() {
       
    }

    private ProfesorEntidad mapearResultSetAProfesor(ResultSet resultSet) throws SQLException {
        ProfesorEntidad profesor = new ProfesorEntidad();
        profesor.setCodProfesor(resultSet.getString("cod_profesor"));
        profesor.setNombreProfesor(resultSet.getString("nombre_profesor"));
        profesor.setCiudad(resultSet.getString("ciudad"));
        return profesor;
    }
}
