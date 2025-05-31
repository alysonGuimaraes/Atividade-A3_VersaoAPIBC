package com.bca3.valoresareceber.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.bca3.valoresareceber.dto.ValorDTO;
import com.bca3.valoresareceber.models.ValoresReceber;
import com.bca3.valoresareceber.repository.ProponenteRepository;
import com.bca3.valoresareceber.repository.ValoresReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bca3.valoresareceber.models.Proponente;

@RestController
@RequestMapping("/valores-a-receber")
public class controller {

    @Autowired
    private ProponenteRepository proponenteRepository;

    @Autowired
    private ValoresReceberRepository valoresReceberRepository;

    @GetMapping("/{cpf}")
    public ResponseEntity<?> consultarValores(@PathVariable String cpf){
        Optional<Proponente> proponenteOpt = proponenteRepository.findByCpf(cpf);

        if (proponenteOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proponente não encontrado.");
        }

        Proponente proponente = proponenteOpt.get();
        List<ValoresReceber> valores = valoresReceberRepository.findByProponenteId(proponente.getId());

        if (valores.isEmpty()) {
            return ResponseEntity.ok("Proponente não possui valores a receber.");
        }

        List<ValorDTO> valoresDTO = valores.stream().map(valor -> new ValorDTO(
                valor.getNomeInstituicao(),
                valor.getCnpj(),
                valor.getValor(),
                valor.getTipoValor(),
                valor.getObservacao(),
                valor.getDtaReferencia()
        )).toList();

        Map<String, Object> response = new HashMap<>();
        response.put("Nome proponente", proponente.getNome());
        response.put("valores_a_receber", valoresDTO);
        response.put("Success", true);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proponente adicionar(@RequestBody Proponente proponente) {
        return proponenteRepository.save(proponente);
    }
}
