package com.finanzas.trabajoFinanzas.controllers;

import com.finanzas.trabajoFinanzas.entities.PlanPagos;
import com.finanzas.trabajoFinanzas.entities.ResultadoPago;
import com.finanzas.trabajoFinanzas.services.IPlanPagosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planPagos")
@CrossOrigin
public class PlanPagosController {
    private IPlanPagosService planPagosService;


    public PlanPagosController(IPlanPagosService planPagosService) {
        this.planPagosService = planPagosService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlanPagos>> findAll() {
        try {
            List<PlanPagos> planPagos = planPagosService.getAll();
            if (!planPagos.isEmpty()) {
                return new ResponseEntity<>(planPagos, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanPagos> findById(@PathVariable("id")Long id){
        try{
            Optional<PlanPagos> planPagos=planPagosService.getById(id);
            if(!planPagos.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(planPagos.get(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanPagos> insertPlanPagos(@Valid @RequestBody PlanPagos planPagos) {
        try {
            List<ResultadoPago> resultados = planPagos.getResultados();
            if (resultados != null && !resultados.isEmpty()) {
                resultados.forEach(resultado -> resultado.setPlanPagos(planPagos));
                planPagos.setResultados(resultados);
            }
            PlanPagos planPagosNew = planPagosService.save(planPagos);
            return ResponseEntity.status(HttpStatus.CREATED).body(planPagosNew);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanPagos> deletePlanPagos(@PathVariable("id")Long id){
        try{
            Optional<PlanPagos> planPagosDelete=planPagosService.getById(id);
            if(!planPagosDelete.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            planPagosService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
