/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usa.ciclo3.Reto3final.servicios;

import Usa.ciclo3.Reto3final.modelo.Especialidad;
import Usa.ciclo3.Reto3final.repositorio.RepositorioEspecialidad;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAOR
 */
@Service
public class ServiciosEspecialidad {
    @Autowired
    private RepositorioEspecialidad metodosCrud;
    
    public List<Especialidad> getAll(){
        return metodosCrud.getAll();
        
    }

    public Optional<Especialidad> getEspecialidad(int idEspecialidad){
        return metodosCrud.getEspecialidad(idEspecialidad);
    }
    
    
    public Especialidad save(Especialidad especialidad){
        if(especialidad.getId()==null){
            return metodosCrud.save(especialidad);
        }else{
            Optional<Especialidad> evt=metodosCrud.getEspecialidad(especialidad.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(especialidad);
            }else{
                return especialidad;
            }
        }
    }
    public Especialidad update(Especialidad especialidad){
        if(especialidad.getId()!=null){
            Optional<Especialidad>g=metodosCrud.getEspecialidad(especialidad.getId());
            if(!g.isEmpty()){
                if(especialidad.getDescription()!=null){
                    g.get().setDescription(especialidad.getDescription());
                }
                if(especialidad.getName()!=null){
                    g.get().setName(especialidad.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return especialidad;
    }
    public boolean deleteEspecialidad(int especialidadId){
        Boolean d=getEspecialidad(especialidadId).map(especialidad -> {
            metodosCrud.delete(especialidad);
            return true;
        }).orElse(false);
        return d;
    }
}