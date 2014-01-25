/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amclos.view;

import com.amclos.services.EmpleadoManager;
import com.amclos.services.SpringContext;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Administrador
 */

@javax.inject.Named
@SessionScoped
public class EmpleadoView {
    private String nombre="Escriba el nombre del Empleado";
    private String cedula,apellido,sexo;
    private Date fechaNacimiento;
    private EmpleadoManager empleadoManager;
    private SpringContext context;
    public EmpleadoView (){
        context = SpringContext.getInstance();
        // Obtenemos el servicio ArbolManager
        empleadoManager = (EmpleadoManager) context.getBean("EmpleadoManager");
    }
 
    /**
     * Este metodo permite guardar un empleado en la base de datos
     */
    
    public void guardar(){
        boolean resultado =  empleadoManager.save(Long.getLong(cedula), nombre, apellido, sexo, fechaNacimiento);
        if(resultado){
            System.out.println("Empleado Creado");
        }else {
            System.out.println("Error al crear el empleado, por favor contactar al administrador del sistema");
        }
        
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}
