package com.portfolio.GabrielSolioz.Repository;
import com.portfolio.GabrielSolioz.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository <Persona,Long>{
    
}
