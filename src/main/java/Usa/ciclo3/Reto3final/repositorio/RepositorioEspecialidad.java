/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usa.ciclo3.Reto3final.repositorio;

import Usa.ciclo3.Reto3final.interfaces.InterfaceEspecialidad;
import Usa.ciclo3.Reto3final.modelo.Especialidad;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FAOR
 * 
 */
@Repository
public class RepositorioEspecialidad {
   @Autowired
   private InterfaceEspecialidad crud2;
   
   public List<Especialidad> getAll(){
       return (List<Especialidad>) crud2.findAll();
   }
   public Optional <Especialidad> getEspecialidad(int id){
       return crud2.findById(id);
   }     
    public Especialidad save(Especialidad especialidad){
        return crud2.save(especialidad);
    }
     public void delete(Especialidad especialidad){
        crud2.delete(especialidad);
    }
 
}
