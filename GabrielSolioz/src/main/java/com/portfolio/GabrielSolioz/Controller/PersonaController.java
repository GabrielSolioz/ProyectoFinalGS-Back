package com.portfolio.GabrielSolioz.Controller;
import com.portfolio.GabrielSolioz.Entity.Persona;
import com.portfolio.GabrielSolioz.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaService ipersonaservice;
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona()
    {
        return ipersonaservice.getPersonas();
    }
    
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona)
    {
        ipersonaservice.savePersona(persona);
        return "persona creada exitosamente";
    }
    
    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id)
    {
        ipersonaservice.deletePersona(id);
        return "persona eliminada exitosamente";
    }
    
    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String newNombre,
                                @RequestParam("apellido") String newApellido,
                                @RequestParam("img") String newImg)
    {
        Persona persona = ipersonaservice.findPersona(id);
        persona.setNombre(newNombre);
        persona.setApellido(newApellido);
        persona.setImg(newImg);
        ipersonaservice.savePersona(persona);
        return persona;
    }
}
