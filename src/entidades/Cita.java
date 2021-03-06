/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
import pau_clinica.Utilidades;
import pau_clinica.Validaciones;

/**
 *
 * @author punib
 */
public class Cita {

    protected long id; // >0
    protected Date fecha; //VAL: Del 01/01/2000 hasta el 31/12/2100
    protected char rangoHorario; //caracteres M, m, T, t
    protected Time hora; // 
    protected Secretariado secretario;
    protected ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
    protected long idTrat;
    protected long idPaciente;
    protected long idSecret;

    public long getIdTrat() {
        return idTrat;
    }

    public void setIdTrat(long idTrat) {
        try {
            if (Validaciones.validarId(idTrat)) {
                this.idTrat = idTrat;
            } else {
                throw new Exception("Id Inválido: " + idTrat);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        try {
            if (Validaciones.validarId(idPaciente)) {
                this.idPaciente = idPaciente;
            } else {
                throw new Exception("Id Inválido: " + idPaciente);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public long getIdSecret() {
        return idSecret;
    }

    public void setIdSecret(long idSecret) {
        try {
            if (Validaciones.validarId(idSecret)) {
                this.idSecret = idSecret;
            } else {
                throw new Exception("Id Inválido: " + idSecret);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //getters
    public long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public char getRangoHorario() {
        return rangoHorario;
    }

    public Time getHora() {
        return hora;
    }

    public Secretariado getSecretario() {
        return secretario;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    //setters
    public void setId(long id) {
        try {
            if (Validaciones.validarId(id)) {
                this.id = id;
            } else {
                throw new Exception("Id Inválido: " + id);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setRangoHorario(char rangoHorario) {
        try {
            if (Validaciones.validarrangoHorario(rangoHorario)) {
                this.rangoHorario = rangoHorario;
            } else {
                throw new Exception("Rango inválido: " + rangoHorario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setSecretario(Secretariado secretario) {
        this.secretario = secretario;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    //constructores
    public Cita() {

    }

    public Cita(long id, Date fecha, char rangoHorario, Time hora, Secretariado secretario, ArrayList<Medicamento> medicamentos) {
        try {
            if (Validaciones.validarId(id)) {
                this.id = id;
            } else {
                throw new Exception("Id Inválido: " + id);
            }
            this.fecha = fecha;

            if (Validaciones.validarrangoHorario(rangoHorario)) {
                this.rangoHorario = rangoHorario;
            } else {
                throw new Exception("Rango inválido: " + rangoHorario);
            }
            this.hora = hora;
            this.secretario = secretario;
            this.medicamentos = medicamentos;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Cita(long id, Date fecha, char rangoHorario, Time hora, Secretariado secretario, ArrayList<Medicamento> medicamentos, long idTrat, long idPaciente, long idSecret) {

        try {
            if (Validaciones.validarId(id)) {
                this.id = id;
            } else {
                throw new Exception("Id Inválido: " + id);
            }
            this.fecha = fecha;

            if (Validaciones.validarrangoHorario(rangoHorario)) {
                this.rangoHorario = rangoHorario;
            } else {
                throw new Exception("Rango inválido: " + rangoHorario);
            }
            this.hora = hora;
            this.secretario = secretario;
            this.medicamentos = medicamentos;
            if (Validaciones.validarId(idTrat)) {
                this.idTrat = idTrat;
            } else {
                throw new Exception("Id Inválido: " + idTrat);

            }
            if (Validaciones.validarId(idSecret)) {
                this.idSecret = idSecret;
            } else {
                throw new Exception("Id Inválido: " + idSecret);

            }
            if (Validaciones.validarId(idSecret)) {
                this.idSecret = idSecret;
            } else {
                throw new Exception("Id Inválido: " + idSecret);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Cita(Cita c) {
        this.id = c.id;
        this.fecha = c.fecha;
        this.rangoHorario = c.rangoHorario;
        this.hora = c.hora;
        this.secretario = c.secretario;
    }

    @Override
    public String toString() {
        return "ID: " + id + ". fecha: " + fecha + ", rangoHorario: " + rangoHorario + ", hora: " + hora + ", secretario: " + secretario + ", medicamentos recetados: " + medicamentos;
    }

//METODOS
    /**
     * Función que marca el orden de importación/exportación de los campos
     *
     * @return id(PK)|fecha|rangoHorario|hora|idSecret|idTrat|idPaciente
     */
    public String data() {
        String ret;
        ret = id + "|" + fecha + "|" + rangoHorario + "|" + hora + "|" + idSecret + "|" + idTrat + "|" + idPaciente;
        return ret;
    }

    public static long nextIdCita() {
        long ret = 0;
        for (int i = 0; i < Utilidades.CITAS.length; i++) {
            if (Utilidades.CITAS[i].id > ret);
            ret = Utilidades.CITAS[i].id;
        }
        return ret + 1;
    }

    //Funcion para ver todas las citas//
    public static void verCitas() {
        System.out.println("Listado de citas: ");
        for (int i = 0; i < Utilidades.numCitas; i++) {
            System.out.println(Utilidades.CITAS[i]);
        }
    }

    public static Cita nuevaCita() {
        Cita ret = new Cita();
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        long id = nextIdCita();
        ret.setId(id);
        Date fecha = Utilidades.Fecha.nuevaFecha().conversorFecha();
        ret.setFecha(fecha);
        char rangoHorario = 's';
        do {
            System.out.println("Introduce el rango horario (Mañana M, Tarde T: ");
            rangoHorario = in.nextLine().charAt(0);
            if (!Validaciones.validarrangoHorario(rangoHorario)) {
                System.out.println("El valor es incorrecto. " + rangoHorario);
            }
        } while (Validaciones.validarrangoHorario(rangoHorario));

        Time hora = Utilidades.Hora.nuevaHora().conversorHora();
        ret.setHora(hora);
        System.out.println("Se ha creado la cita: " + ret);
        return ret;
    }

    public static void buscarCita(ArrayList<Cita> citas) {

        Scanner in = new Scanner(System.in, "ISO-8859-1");
        System.out.println("Introduce el id de la cita: ");
        Cita ret = null;
        int idCita = in.nextInt();
        for (Cita e : Cita.convertir(Utilidades.CITAS)) {
            if (e.getId() == idCita) {
                ret = e;
                System.out.println("Id: " + ret.getId() + ", fecha: " + ret.getFecha() + " , hora: " + ret.getHora() + ", rango Horario: " + ret.getRangoHorario());
            }
        }
    }

    public static Cita buscarCitadoporId(int id, ArrayList<Cita> citas) {
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        System.out.println("Introduce el id del empleado: ");
        Cita ret = null;
        for (Cita e : Cita.convertir(Utilidades.CITAS)) {
            if (e.getId() == id) {
                ret = e;
                break;
            }
        }
        return ret;
    }

//         protected long id; // >0
//    protected Date fecha; //VAL: Del 01/01/2000 hasta el 31/12/2100
//    protected char rangoHorario; //caracteres M, m, T, t
//    protected Time hora; // 
//        
//    }
    /**
     * Función que se le pasa una lista ArrayList<code>Citas</code> y un array
     * de identificadores, y devuelve una sublista con los Cirujanos cuyos ids
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de Citas en las que buscar
     * @param ids array de ids de Citas
     * @return ArrayList<code>Citas</code>
     */
    public static ArrayList<Cita> arrayde(ArrayList<Cita> lista, int[] ids) {
        ArrayList<Cita> ret = new ArrayList<Cita>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Cita) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static final ArrayList<Cita> convertir(Cita[] array) {
        ArrayList<Cita> ret = new ArrayList<Cita>();
        for (Cita i : array) {
            ret.add((Cita) i);
        }
        return ret;
    }

         
     /**
     * Función a la que se le pasa el id del paciente y devuelve la lista 
     * de citas en un archivo.dat
     *
     * @param idPaciente para buscar
     * 
     * @return void
     */
     public static void exportarCitasBinario(long idPaciente) {
        String path = "citas.dat";
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream escritor = new ObjectOutputStream(fichero);
            for (Cita c : Utilidades.CITAS) {
                if(idPaciente == c.getIdPaciente()){               
               
                escritor.writeObject((Cita) c);
                escritor.flush();
                 }
            }
            escritor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Se ha producido una IOException" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una Exception" + e.getMessage());
        }
    }

}
    
    
