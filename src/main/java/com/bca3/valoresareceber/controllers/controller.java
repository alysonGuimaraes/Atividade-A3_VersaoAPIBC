package com.bca3.valoresareceber.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import com.bca3.valoresareceber.dto.ValorDTO;
import com.bca3.valoresareceber.models.LogConsulta;
import com.bca3.valoresareceber.models.ValoresReceber;
import com.bca3.valoresareceber.repository.LogConsultaRepository;
import com.bca3.valoresareceber.repository.ProponenteRepository;
import com.bca3.valoresareceber.repository.ValoresReceberRepository;
import com.bca3.valoresareceber.models.Proponente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/valores-a-receber")
public class controller {

    @Autowired
    private ProponenteRepository proponenteRepository;

    @Autowired
    private ValoresReceberRepository valoresReceberRepository;

    @Autowired
    private LogConsultaRepository logConsultaRepository;

    @GetMapping("/consulta")
    public ResponseEntity<?> consultarValores(@RequestParam String cpf, @RequestParam LocalDate dta_nasc){
        Optional<Proponente> proponenteOpt = proponenteRepository.findByCpfAndDtaNascimento(cpf, dta_nasc);

        Map<String, Object> response = new HashMap<>();
        response.put("CPF proponente", cpf);
        List<ValorDTO> valoresDTO = new ArrayList<>();

        //System.out.println(dta_nasc);

        if (proponenteOpt.isEmpty()) {
            salvarLog(cpf, false, false);
            response.put("Valores-a-receber", valoresDTO);
            response.put("Nome proponente", "Desconhecido");
            response.put("Possui_valores_receber", false);
            return ResponseEntity.ok(response);
        }

        Proponente proponente = proponenteOpt.get();
        List<ValoresReceber> valores = valoresReceberRepository.findByProponenteId(proponente.getId());
        valoresDTO.addAll(valores.stream().map(valor -> new ValorDTO(
                valor.getNomeInstituicao(),
                valor.getCnpj(),
                valor.getValor(),
                valor.getTipoValor(),
                valor.getObservacao(),
                valor.getDtaReferencia()
        )).toList());

        response.put("Nome proponente", proponente.getNome());
        response.put("valores_a_receber", valoresDTO);

        if (valores.isEmpty()) {
            salvarLog(cpf, true, false);
            response.put("Possui_valores_receber", false);
            return ResponseEntity.ok(response);
        }

        response.put("Possui_valores_receber", true);

        salvarLog(cpf, true, true);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/proponente")
    @ResponseStatus(HttpStatus.CREATED)
    public Proponente adicionar(@RequestBody Proponente proponente) {
        return proponenteRepository.save(proponente);
    }


    @PostMapping("/valores")
    @ResponseStatus(HttpStatus.CREATED)
    public ValoresReceber adicionar(@RequestBody ValoresReceber valores) {
        return valoresReceberRepository.save(valores);
    }

    private void salvarLog(String cpf, boolean propBanco, boolean possuiValores){
        LogConsulta log = new LogConsulta();
        log.setDtaConsulta(LocalDateTime.now());
        log.setCpfConsultado(cpf);
        log.setPropNoBanco(propBanco);
        log.setPossuiValores(possuiValores);

        logConsultaRepository.save(log);
    }
}
