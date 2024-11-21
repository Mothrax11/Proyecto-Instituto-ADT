package com.proyectoinsituto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.proyectoinsituto.entidades.AlumnoEntidad;

public class AlumnoDAOImplementacion implements AlumnoDAO {
     
    private static AlumnoDAOImplementacion instancia; 
    private DataSource dataSource; 
    private AlumnoDAOImplementacion(DataSource dataSource) { 
        this.dataSource = dataSource; 
    } 
    
    public static AlumnoDAOImplementacion getInstancia(DataSource dataSource){
        if (instancia == null) { 
            instancia = new AlumnoDAOImplementacion(dataSource); 
        }
        return instancia;
    }

    public void crearAlumno(AlumnoEntidad alumno) {
        String sql="INSERT INTO alumno (cod_alumno, nombre_alumno, apellidos_alumno, fecha_nacimiento, grupo) VALUES (?,?,?,?,?)";
        try (Connection connection = dataSource.getConnection(); 
            PreparedStatement statement = connection.prepareStatement(sql)) { 
            statement.setString(1, alumno.getCodAlumno()); 
            statement.setString(2, alumno.getNombreAlumno()); 
            statement.setString(3, alumno.getApellidoAlumno()); 
            statement.setDate(4, new java.sql.Date(alumno.getFechaNacimiento().getTime())); 
            statement.setString(5, String.valueOf(alumno.getGrupo())); 
            statement.executeUpdate(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }

    @Override
    public AlumnoEntidad obtenerAlumnoPorId(String id) {
        String sql = "SELECT cod_alumno, nombre_alumno, apellidos_alumno, fecha_nacimiento, grupo FROM alumno WHERE cod_alumno = ?"; 
         try (Connection connection = dataSource.getConnection(); 
              PreparedStatement statement = connection.prepareStatement(sql)) { 
             statement.setString(1, id); 
             try (ResultSet resultSet = statement.executeQuery()) { 
                 if (resultSet.next()) { 
                     return mapearResultSetAAlumno(resultSet); 
                 } 
             } 
         } catch (SQLException e) { 
             e.printStackTrace(); 
         } 
         return null; 
    }
    

    @Override
    public List<AlumnoEntidad> obtenerTodosLosAlumnos() {
        List<AlumnoEntidad> alumnos = new ArrayList<>();
        String sql = "SELECT cod_alumno, nombre_alumno, apellidos_alumno, fecha_nacimiento, grupo FROM alumno";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    AlumnoEntidad alumno = mapearResultSetAAlumno(resultSet);
                    alumnos.add(alumno);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return alumnos;
    }

    @Override
    public boolean actualizarAlumno(AlumnoEntidad alumno) {
        String sql = "UPDATE alumno SET nombre_alumno = ?, apellidos_alumno = ?, fecha_nacimiento = ?, grupo = ? WHERE cod_alumno = ?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, alumno.getNombreAlumno());
            statement.setString(2, alumno.getApellidoAlumno());
            statement.setDate(3, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
            statement.setString(4, String.valueOf(alumno.getGrupo()));
            statement.setString(5, alumno.getCodAlumno());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public void eliminarAlumno(String id) {

        String sql = "DELETE FROM alumno WHERE cod_alumno = ?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private AlumnoEntidad mapearResultSetAAlumno(ResultSet resultSet) throws SQLException { 
        AlumnoEntidad alumno = new AlumnoEntidad();
        alumno.setCodAlumno(resultSet.getString("cod_alumno")); 
        alumno.setNombreAlumno(resultSet.getString("nombre_alumno")); 
        alumno.setApellidoAlumno(resultSet.getString("apellidos_alumno")); 
        alumno.setFechaNacimiento(resultSet.getDate("fecha_nacimiento")); 
        alumno.setGrupo(resultSet.getString("grupo").charAt(0)); 
        return alumno; 
    }   
 
}

