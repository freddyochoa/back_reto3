/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usa.ciclo3.Reto3final.modelo;

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
 *
 * @author FAOR
 */
@Entity 
@Table(name = "doctors")

public class Doctor implements Serializable {
    /**
     * metodos de valores Integer y string en la  columna idDoctor
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String  department;
    private Integer year;
    private String description;
    /**
     * Metodo JoinColumn para referenciarla como relacion de columna, Getters
     * y Setters Ignoramos la lista de doctores columna specialty
     * @ManyToOne
     */
    @ManyToOne
    @JoinColumn(name="categoryid")
    @JsonIgnoreProperties("doctors")
    private Especialidad specialty;
    /**
     * Metodo OneToMany para referenciarla como relacion uno a muchos,
     * Getters y Setters Ignoramos la lista de doctores y clientes columna
     * messages
     * @OneToMany
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor","client"})
    private List<Mensaje> messages;
    /**
     * Metodo OneToMany para referenciarla como relacion uno a muchos,
     * Getters y Setters Ignoramos la lista de doctores y clientes columna
     * reservations
     * @OneToMany
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor","message"})
    public List<Reservacion> reservations;
    /**
     * despliegue de metodos getters and setters
     * @return 
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Especialidad getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Especialidad specialty) {
        this.specialty = specialty;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservacion> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservacion> reservations) {
        this.reservations = reservations;
    }
   
    
    
}
