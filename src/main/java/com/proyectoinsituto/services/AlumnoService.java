package com.proyectoinsituto.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.proyectoinsituto.dao.AlumnoDAO;
import com.proyectoinsituto.dao.AlumnoDAOImplementacion;
import com.proyectoinsituto.dto.AlumnoDTO;
import com.proyectoinsituto.entidades.AlumnoEntidad;

public class AlumnoService {
    private static AlumnoService instancia;
    private AlumnoDAOImplementacion alumnoDAOImplementacion;
    private DataSource dataSource;

    private AlumnoService(DataSource dataSource) {
        this.alumnoDAOImplementacion = alumnoDAOImplementacion.getInstancia(dataSource);

    }

    public static AlumnoService getInstancia(DataSource dataSource) {
        if (instancia == null) {
            return new AlumnoService(dataSource);
        }
        return instancia;
    }

    public void crearAlumno(AlumnoDTO alumnoDTO){
        AlumnoEntidad alumnoEntidad = new AlumnoEntidad(
            alumnoDTO.getIdAlumno(), 
            alumnoDTO.getNombreAlumno(),
            alumnoDTO.getApellidoAlumno(), 
            calcularEdadAFecha(alumnoDTO.getEdad()), 
            alumnoDTO.getGrupo());
       AlumnoDAOImplementacion.getInstancia(dataSource).crearAlumno(alumnoEntidad);
    }

    public AlumnoDTO obtenerAlumnoPorId(String id){
        AlumnoEntidad alumnoEntidad = AlumnoDAOImplementacion.getInstancia(dataSource).obtenerAlumnoPorId(id);
        AlumnoDTO alumnoDTO = new AlumnoDTO(
            alumnoEntidad.getCodAlumno(), 
            alumnoEntidad.getNombreAlumno(), 
            alumnoEntidad.getApellidoAlumno(), 
            calcularFechaAEdad(alumnoEntidad.getFechaNacimiento()), 
            alumnoEntidad.getGrupo());
        return alumnoDTO;
    }

    public List<AlumnoDTO> obtenerTodosLosAlumnos(){
        List<AlumnoEntidad> listaalumnoentidad = AlumnoDAOImplementacion.getInstancia(dataSource).obtenerTodosLosAlumnos();
        List <AlumnoDTO> listaalumnoDTO = new ArrayList<>();
        for (int i = 0; i < listaalumnoentidad.size(); i++) {
            int fechaNac = calcularFechaAEdad(listaalumnoentidad.get(i).getFechaNacimiento());
            listaalumnoDTO.add(new AlumnoDTO(
                listaalumnoDTO.get(i).getIdAlumno(),
                listaalumnoDTO.get(i).getNombreAlumno(),
                listaalumnoDTO.get(i).getApellidoAlumno(),
                fechaNac,
                listaalumnoDTO.get(i).getGrupo()));
        }
        return listaalumnoDTO;
    }

    public Boolean actualizarAlumno(String id, AlumnoDTO alumnoDTO){
        AlumnoEntidad alumnoEntidad = new AlumnoEntidad(
                alumnoDTO.getIdAlumno(),
                alumnoDTO.getNombreAlumno(),
                alumnoDTO.getApellidoAlumno(),
                calcularEdadAFecha(alumnoDTO.getEdad()),
                alumnoDTO.getGrupo());
       if(AlumnoDAOImplementacion.getInstancia(dataSource).actualizarAlumno(alumnoEntidad)){
            return true;
       } else {
            return false;
       }
    }

    public boolean eliminarAlumno (String id){
       return AlumnoDAOImplementacion.getInstancia(dataSource).eliminarAlumno(id);
    }

    private AlumnoEntidad mapearDtoAEntidad (AlumnoDTO alumnoDTO){
     AlumnoEntidad alumnoEntidad = new AlumnoEntidad(
        alumnoDTO.getIdAlumno(), 
        alumnoDTO.getNombreAlumno(), 
        alumnoDTO.getApellidoAlumno(), 
        calcularEdadAFecha(alumnoDTO.getEdad()),
        alumnoDTO.getGrupo());
        return alumnoEntidad;
    }

    private AlumnoDTO mapearEntidadADto (AlumnoEntidad alumnoEntidad){
    AlumnoDTO alumnoDTO = new AlumnoDTO(
        alumnoEntidad.getCodAlumno(),
        alumnoEntidad.getNombreAlumno(),
        alumnoEntidad.getApellidoAlumno(),
        calcularFechaAEdad(alumnoEntidad.getFechaNacimiento()),
        alumnoEntidad.getGrupo());
        return alumnoDTO;
    }

    private int calcularFechaAEdad(Date fechaNacimiento){
        LocalDate fechaNacimientoLocal = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(fechaNacimientoLocal, LocalDate.now()).getYears();
    }

    private Date calcularEdadAFecha(int edad){
        LocalDate fechaNacimiento = LocalDate.now().minusYears(edad);
        return Date.from(fechaNacimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
