package com.portfolio.GabrielSolioz.Repository;
import com.portfolio.GabrielSolioz.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia>  findByNombreE(String nombreE);
    public Boolean existsByNombreE(String nombreE);
}
