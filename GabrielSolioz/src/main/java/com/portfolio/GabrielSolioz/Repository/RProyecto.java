package com.portfolio.GabrielSolioz.Repository;

import com.portfolio.GabrielSolioz.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RProyecto extends JpaRepository<Proyecto, Integer> {

    public Optional<Proyecto> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
