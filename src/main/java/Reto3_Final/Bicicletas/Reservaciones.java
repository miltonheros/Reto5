/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Final.Bicicletas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad que realciona tablas
 * @author migue angel acrreño
 */
@Entity
/**
 * Tabla con el nombre reservation
 */
@Table(name = "reservation")
/**
 * Inicio de la clase Rservaciones que implementa la sinterface serializable
 */
public class Reservaciones implements Serializable  {
    /**
     * LLave principal
     */
    @Id
    /**
     * Autoincremental
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Atributo de tipo integer con idReservation
     */
    private Integer idReservation;
    /**
     * Atributo de tipo date con startDate
     */
    private Date startDate;
    /**
     * atributo de tipo date con devolution
     */
    private Date devolutionDate;
    /**
     * atributo de tipo string
     */
    private String status="created";
     /**
     * Relacion muchos a uno
     */
    @ManyToOne
    /**
     * Columna  con llave para definir la relacion id
     */
    @JoinColumn(name = "id")
     /**
     * Ingora los campos que no estan en la tabla reservations
     */
    @JsonIgnoreProperties("reservations")
    /**
     * metodo bike
     */
    private Bike bike;
    /**
     * Relacion muchos a uno
     */
    @ManyToOne
    /**
     * Columna  con llave para definir la relacion idclient
     */
    @JoinColumn(name = "idClient")
    /**
     * Ingora los campos que no estan en la tabla reservations y message
     */
    @JsonIgnoreProperties({"reservations","messages"})
    /**
     * metodo cliente
     */
    private Cliente client;
    /**
     * atributo score de tipo string
     */
    private String score; 
    /**
     * Metodo para obtener el idReservation
     * @return idReservation
     */
    public Integer getIdReservation() {
        return idReservation;
    }
    /**
     * Metodo para asignar el idReservation
     * @param idReservation
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    /**
     * Metodo para obtener el startDate
     * @return startDate
     */
    public Date getStartDate() {
        return startDate;
    }
     /**
     * Metodo para asignar el startDate
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     * Metodo para obtener el devolutionDate
     * @return devolutionDate
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }
   /**
    * Metodo para asignar el devolutionDate
    * @param devolutionDate 
    */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    /**
     * Metodo para obtener el status
     * @return status
     */
    public String getStatus() {
        return status;
    }
    /**
     * Metodo para asignar el status
     * @param status 
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * Metodo para obtener bike
     * @return bike
     */
    public Bike getBike() {
        return bike;
    }
    /**
     *  Metodo para asignar bike
     * @param bike 
     */
    public void setBike(Bike bike) {
        this.bike = bike;
    }
    /**
     * Metodo para obtener cliente
     * @return client
     */
    public Cliente getClient() {
        return client;
    }
    /**
     * Metodo para asignar client
     * @param client 
     */
    public void setClient(Cliente client) {
        this.client = client;
    }
    /**
     * metodo para obtener score
     * @return score
     */
    public String getScore() {
        return score;
    }
    /**
     * Metodo para asignar el score
     * @param score 
     */
    public void setScore(String score) {
        this.score = score;
    }
/**
 * fin de la clase
 */  
}
