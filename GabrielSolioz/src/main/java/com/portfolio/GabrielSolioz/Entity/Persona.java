package com.portfolio.GabrielSolioz.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "longitud muy corta")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "longitud muy corta")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 50, message = "longitud muy corta")
    private String img;
    
    
}