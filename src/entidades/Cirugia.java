/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author punib
 */
public class Cirugia extends Empleado {

    private ArrayList<Especialidad> especialidades = new ArrayList<Especialidad>();

//getters
    public ArrayList<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTlfn() {
        return tlfn;
    }

    public String getNIF() {
        return NIF;
    }

    public String getDireccion() {
        return direccion;
    }

    //setters
    public void setEspecialidades(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTlfn(String tlfn) {
        this.tlfn = tlfn;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    //constructores

    public Cirugia() {
        super();
    }

    public Cirugia(ArrayList<Especialidad> especialidades, long id, String nombre, String apellido, String tlfn, String NIF, String direccion) {
        super(id, nombre, apellido, tlfn, NIF, direccion);
        this.especialidades = especialidades;
    }
    
    public Cirugia(Cirugia c){
        this.especialidades = c.especialidades;
        this.NIF = c.NIF;
        this.apellido = c.apellido;
        this.direccion = c.direccion;
        this.id = c.id;
        this.nombre = c.nombre;
        this.tlfn = c.tlfn;
}
    public Cirugia(Empleado e, ArrayList<Especialidad> especialidades){
        super(e);
        this.especialidades = especialidades;              
    }
   
        
    
    }