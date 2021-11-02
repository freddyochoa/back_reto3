/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usa.ciclo3.Reto3final.servicios;


import Usa.ciclo3.Reto3final.modelo.Reservacion;
import Usa.ciclo3.Reto3final.reportes.ContadorClientes;
import Usa.ciclo3.Reto3final.reportes.StatusReservas;


import Usa.ciclo3.Reto3final.repositorio.RepositorioReservacion;
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
 * @author FAOR
 */
@Service
public class ServiciosReservacion {
    /**
     * Creamos una instancia de RepositorioRESERVACION con la directiva @Autowired
     */
     
    @Autowired
    private RepositorioReservacion metodosCrud;
    
    /**
     * Este método consulta todas las reservas.
     * @return lista de devoluciones
     */
    
    public List<Reservacion> getAll(){
        return metodosCrud.getAll();
    }
    /**
     * Este método consulta la reserva por id.
     * @return id
     */

    public Optional<Reservacion> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
    /**
     * Este método registra y actualiza
     * @return reservation
     */
    public Reservacion save(Reservacion reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservacion> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    /**
     * Este método valida y actualiza la reserva usando el método de guardar
     * @return reservation
     */
    public Reservacion update(Reservacion reservacion){
        if(reservacion.getIdReservation()!=null){
            Optional<Reservacion> e= metodosCrud.getReservation(reservacion.getIdReservation());
            if(!e.isEmpty()){

                if(reservacion.getStartDate()!=null){
                    e.get().setStartDate(reservacion.getStartDate());
                }
                if(reservacion.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservacion.getDevolutionDate());
                }
                if(reservacion.getStatus()!=null){
                    e.get().setStatus(reservacion.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservacion;
            }
        }else{
            return reservacion;
        }
    }
    /**
     * Este método elimina una reserva
     * @return
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public StatusReservas getReporteStatusReservaciones(){
        List<Reservacion>completed= metodosCrud.ReservacionStatus("completed");
        List<Reservacion>cancelled= metodosCrud.ReservacionStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }
    
    public List<Reservacion> getReportesTiempoReservaciones(String datoA, String datoB){
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempo(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }  
    
    public List<ContadorClientes> servicioTopClientes(){
        return metodosCrud.getTopClientes();
    }
}