/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Final.Bicicletas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Angel Carreño
 */
@Service
/**
 * clase servicios Reservaciones
 */
public class ServiciosReservaciones {
    /**
     * enlaza RepositorioReservaciones
     */
     @Autowired
     /**
      * metodo RepositorioReservaciones
      */
    private RepositorioReservaciones metodosCrud;
     /**
      * metodos con la Lista Reservaciones
      * @return metodos crud 
      */
    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }
    /**
     * metodo reservaciones
     * @param reservationId con el id de cada reservacion
     * @return metodos crud con reservationid
     */
    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
    /**
     * metodo que guarda la reservacion
     * @param reservation con las reservaciones
     * @return las reservaciones guardadas
     */
    public Reservaciones save(Reservaciones reservation){
        /**
         * condicional si la reservacion esta vacia retorna un null
         */
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservaciones> metodo= metodosCrud.getReservation(reservation.getIdReservation());
            if(metodo.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    /**.
     * metodo que actualiza las reservacion
     * @param reservation reservacion
     * @return la reservacion actualizada
     */
    public Reservaciones update(Reservaciones reservation){
        /**
         * condicional si la reservacion esta vacia devuelve un null
         */
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> metodo= metodosCrud.getReservation(reservation.getIdReservation());
            /**
             * condicional si el metodo no esta vacio
             */
            if(!metodo.isEmpty()){
                /**
                 * condicional si la fecha de incio es diferente a null
                 */
                if(reservation.getStartDate()!=null){
                    metodo.get().setStartDate(reservation.getStartDate());
                }
                /**
                 * condicional si la fecha de devolucion es dierente a a null
                 */
                if(reservation.getDevolutionDate()!=null){
                    metodo.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                /**
                 * condicional si el estatus es diferente a null
                 */
                if(reservation.getStatus()!=null){
                    metodo.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(metodo.get());
                return metodo.get();
                /**
                 * si no se cumple las anteriores condiciones devuelve la reservaciones
                 */
            }else{
                return reservation;
            }
            /**
             * si no se cumple las anteriores condiciones devuelve la reservaciones
             */
        }else{
            return reservation;
        }
    }
    /**
     * metodo boleano para eliminar una reservacion
     * @param reservationId id la reservacion
     * @return un boleano falso o verdadero
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    /**
     * metodo con las status de las reservas
     * @return las reservas completadas o conceladas
     */
    public StatusReservas reporteStatusServicio (){
        List<Reservaciones>completed= metodosCrud.ReservacionStatusRepositorio("completed");
        List<Reservaciones>cancelled= metodosCrud.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size() );
    }
    /**
     * metodo con las lista de las reservaciones 
     * @param datoA fecha con el dato uno
     * @param datoB fecha con el dato dos
     * @return los datos almacenados
     */
    public List<Reservaciones> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    }
    /**
     * metodo con los reportes de clientes
     * @return la lista de clientes
     */
    public List<ContadorClientes> reporteClientesServicio(){
            return metodosCrud.getClientesRepositorio();
        }
/**
 * fin de la clase
 */
}
