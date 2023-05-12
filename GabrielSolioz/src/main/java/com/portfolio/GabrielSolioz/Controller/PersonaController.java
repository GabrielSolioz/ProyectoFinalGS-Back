package com.portfolio.GabrielSolioz.Controller;
import com.portfolio.GabrielSolioz.DTO.dtoPersona;
import com.portfolio.GabrielSolioz.Entity.Persona;
import com.portfolio.GabrielSolioz.Security.Controller.Mensaje;
import com.portfolio.GabrielSolioz.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://portfolio-gabriel-8b168.web.app","http://localhost:4200"})
public class PersonaController {
    @Autowired
    ImpPersonaService personaservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaservice.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaservice.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona experiencia = personaservice.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    /*
    No se utilizaran
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!personaservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        personaservice.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopers){      
        if(StringUtils.isBlank(dtopers.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(personaservice.existsByNombreE(dtopers.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Persona experiencia = new Persona(dtopers.getNombreE(), dtopers.getDescripcionE(),dtopers.getPeriodoE());
        personaservice.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
    */    

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopers){
        //validacion id
        if(!personaservice.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //compara si escribio lo mismo
        if(personaservice.existsByNombre(dtopers.getNombre()) && personaservice.getByNombre(dtopers.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //verifica si puso el nombre
        if(StringUtils.isBlank(dtopers.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = personaservice.getOne(id).get();
        persona.setNombre(dtopers.getNombre());
        persona.setApellido((dtopers.getApellido()));
        persona.setImg(dtopers.getImg());
        persona.setDescripcion(dtopers.getDescripcion());
        
        //actualizo la experiencia
        personaservice.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
             
    }
}
