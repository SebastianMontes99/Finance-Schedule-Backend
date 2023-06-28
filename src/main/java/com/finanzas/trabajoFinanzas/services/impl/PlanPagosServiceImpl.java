package com.finanzas.trabajoFinanzas.services.impl;

import com.finanzas.trabajoFinanzas.entities.PlanPagos;
import com.finanzas.trabajoFinanzas.repositories.IPlanPagosRepository;
import com.finanzas.trabajoFinanzas.services.IPlanPagosService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly=false)
public class PlanPagosServiceImpl implements IPlanPagosService {
    private final IPlanPagosRepository pagosRepository;


    public PlanPagosServiceImpl(IPlanPagosRepository pagosRepository) {
        this.pagosRepository = pagosRepository;
    }

    @Override
    public PlanPagos save(PlanPagos planPagos) throws Exception {
        return pagosRepository.save(planPagos);
    }

    @Override
    public void delete(Long id) throws Exception {
        pagosRepository.deleteById(id);
    }

    @Override
    public List<PlanPagos> getAll() throws Exception {
        return pagosRepository.findAll();
    }

    @Override
    public Optional<PlanPagos> getById(Long id) throws Exception {
        return pagosRepository.findById(id);
    }
}
