
package com.portfolio.GabrielSolioz.Service;

import com.portfolio.GabrielSolioz.Entity.Proyecto;
import com.portfolio.GabrielSolioz.Repository.RProyecto;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SProyecto {
    @Autowired
    RProyecto rproyecto;
    
    public List<Proyecto> list(){
        return rproyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return rproyecto.findById(id);
    }
    
    public Optional<Proyecto> getByNombre(String nombre){
        return rproyecto.findByNombre(nombre);
    }
    
    public void save(Proyecto skill){
        rproyecto.save(skill);
    }
    
    public void delete(int id){
        rproyecto.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rproyecto.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rproyecto.existsByNombre(nombre);
    }
}
