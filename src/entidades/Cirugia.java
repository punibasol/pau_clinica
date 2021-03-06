/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Scanner;
import pau_clinica.Validaciones;

/**
 *
 * @author punib
 */
public class Cirugia extends EmpleadoEnt {

    private long idEmp;
    private ArrayList<Especialidad> especialidades = new ArrayList<Especialidad>();

    public long getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(long idEmp) {
        try {
            if (Validaciones.validarId(idEmp)) {
                this.idEmp = idEmp;
            } else {
                throw new Exception("Id Inválido: " + idEmp);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public Cirugia() {
    }

    public Cirugia(EmpleadoEnt e) {
        super(e);
    }

    public Cirugia(EmpleadoEnt e, ArrayList<Especialidad> especialidades) {
        super(e);
        this.especialidades = especialidades;
    }

    public Cirugia(EmpleadoEnt e, ArrayList<Especialidad> especialidades, long idEmp) {
        super(e);
        try {
            if (Validaciones.validarId(idEmp)) {
                this.idEmp = idEmp;
            } else {
                throw new Exception("Id Inválido: " + idEmp);

            }
            this.especialidades = especialidades;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Cirugia(long id, String nombre, String apellido, String tlfn, String NIF, String direccion, ArrayList<Especialidad> especialidades)  {
        super(id, nombre, apellido, tlfn, NIF, direccion);
        this.especialidades = especialidades;

    }
    
       public Cirugia(long id, String nombre, String apellido, String tlfn, String NIF, String direccion, ArrayList<Especialidad> especialidades, long idEmp) {
        super(id, nombre, apellido, tlfn, NIF, direccion);
        try {
            if (Validaciones.validarId(idEmp)) {
                this.idEmp = idEmp;
            } else {
                throw new Exception("Id Inválido: " + idEmp);

            }
            this.especialidades = especialidades;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }


    public Cirugia(Cirugia c) {
        this.id = c.id;
        this.nombre = c.nombre;
        this.apellido = c.apellido;
        this.NIF = c.NIF;
        this.direccion = c.direccion;
        this.tlfn = c.tlfn;
        this.especialidades = especialidades;
    }

    @Override
    public String toString() {
        return "ID: " + id + ". Nombre: " + nombre + " " + apellido + ", DNI: " + NIF + ", dirección " + direccion + ", Tlfn: " + tlfn + ". Especialidades: " + especialidades;
    }

    public static Cirugia nuevoCirujano() {
        EmpleadoEnt empleado = EmpleadoEnt.nuevoEmpleado();
        Cirugia ret = new Cirugia(empleado);
        return ret;
    }

    /**
     * Función que marca el orden de importación/exportación de los campos
     * @return id(PK)|nombre|apellido|tlfn|NIF|direccion|IdEmp
     */
    public String data(){
        String ret;
        ret = super.id + "|" + super.nombre + "|" + super.apellido + "|" + super.tlfn + "|" + super.NIF + "|" + super.direccion+"|"+idEmp;
        return ret;
    }
   
    
    /**
     * Función que se le pasa una lista ArrayList<code>Cirujano</code> y un
     * array de identificadores, y devuelve una sublista con los Cirujanos cuyos
     * ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Cirujanos en las que buscar
     * @param ids array de ids de Cirujanos
     * @return ArrayList<code>Cirujano</code>
     */
    public static ArrayList<Cirugia> arraydeCirugia(ArrayList<Cirugia> lista, int[] ids) {
        ArrayList<Cirugia> ret = new ArrayList<Cirugia>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Cirugia) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static final ArrayList<Cirugia> convertir(Cirugia[] array) {
        ArrayList<Cirugia> ret = new ArrayList<Cirugia>();
        for (Cirugia i : array) {
            ret.add((Cirugia) i);
        }
        return ret;
    }

}
