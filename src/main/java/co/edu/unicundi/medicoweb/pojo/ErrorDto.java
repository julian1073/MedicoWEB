/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoweb.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Julián Vásquez Corredor, Daniel perez
 * @version 1.0.0
 * @since 11/03/2021
 * @param <T>
 */
public class ErrorDto<T> implements Serializable{
 
    private T mensaje;
    private String path;
    private String fecha;

    public ErrorDto() {
    }

    public ErrorDto(T mensaje, String path) {
        
        this.mensaje = mensaje;
        this.path = path;
        this.fecha = (new Date()).toString();
    }

    public T getMensaje() {
        return mensaje;
    }

    public void setMensaje(T mensaje) {
        this.mensaje = mensaje;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
