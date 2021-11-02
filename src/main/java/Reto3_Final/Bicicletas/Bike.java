/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Final.Bicicletas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Entidad que realciona tablas
 * @author migue angel carreño
 */
@Entity
/**
 * Tabla con el nombre bike
 */
@Table(name = "bike")
/**
 * Inicio de la clase constructor bike que implementa la sinterface serializable
 */
public class Bike implements Serializable{
    /**
     * LLave principal
     */
    @Id
    /**
     * Autoincremental
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Atributo integer con el id
     */
    private Integer id;
    /**
     * Atributo string con el name
     */
    private String name;
    /**
     * Atributo string con el brand
     */
    private String brand;
    /**
     * Atributo integer con el year
     */
    private Integer year;
    /**
     * Atributo string con description
     */
    private String description;
    /**
     * Relacion muchos a uno
     */
    @ManyToOne
    /**
     * Columna que se con llave para definir la relacion
     */
    @JoinColumn(name = "categoryId")
    /**
     * Ingora los campos que no estan en la tabla
     */
    @JsonIgnoreProperties("bikes")
    /**
     * Atributo categoria
     */
    private Categoria category;
    /**
     * Relacion uno a muchos
     */
     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "bike")
     /**
      * Ingora los campos que no estan en la tabla
      */
    @JsonIgnoreProperties({"bike", "client"})
     /**
      * Metodo con lista messages
      */
    private List<Mensaje> messages;
     /**
      * Relacion uno a muchos
      */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "bike")
    /**
     * Ingora los campos que no estan en la tabla
     */
    @JsonIgnoreProperties({"bike", "client"})
    /**
     * Metodo con lista reservations
     */
    private List<Reservaciones> reservations;
    /**
     * Metodo para obtener el id
     * @return id
     */
    public Integer getId() {
        return id;
    }
    /**
     * Metodo para asignar el id
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Metodo para obtener el name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Metodo para asignar el name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Metodo para obtener el brand
     * @return brand
     */
    public String getBrand() {
        return brand;
    }
    /**
     * Metodo para asignar el brand
     * @param brand 
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     * Metodo para obtener el year
     * @return year
     */
    public Integer getYear() {
        return year;
    }
    /**
     * Metodo para asignar el year
     * @param year 
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    /**
     * Metodo para obtener description
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Metodo para asignar description
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Metodo para obtener categroty
     * @return category
     */
    public Categoria getCategory() {
        return category;
    }
    /**
     * Metodo para asignar category
     * @param category 
     */
    public void setCategory(Categoria category) {
        this.category = category;
    }
    /**
     * Metodo para obtener lista de message
     * @return message
     */
    public List<Mensaje> getMessages() {
        return messages;
    }
    /**
     * Metodo para asignar lista de message
     * @param messages 
     */
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }
    /**
     * Metodo para obtener lista de reservations
     * @return reservations
     */
    public List<Reservaciones> getReservations() {
        return reservations;
    }
    /**
     * Metodo para asignar lista de reservations
     * @param reservations 
     */
    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
/**
 * fin de la clase
 */  
}
