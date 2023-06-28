package com.finanzas.trabajoFinanzas.repositories;

import com.finanzas.trabajoFinanzas.entities.PlanPagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanPagosRepository extends JpaRepository<PlanPagos,Long> {
}
