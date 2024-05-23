package com.mobilidade.mobilidade.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobilidade.mobilidade.model.Avaliacao;
import com.mobilidade.mobilidade.model.AvaliacaoDTO;
import com.mobilidade.mobilidade.service.AvaliacaoService;
import com.mongodb.client.result.DeleteResult;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/avaliacao")
public class AvaliacaoController {
    
    private AvaliacaoService service;

    @PostMapping("/avaliar")
    public ResponseEntity<Avaliacao> avaliar(@RequestBody AvaliacaoDTO avaliacao) {
        return ResponseEntity.ok(service.avaliar(avaliacao));
    }
    
    @GetMapping("/avaliacao/{id}")
    public ResponseEntity<Avaliacao> avaliacaoPorId(@NotNull @PathVariable("id") String id) {
        return ResponseEntity.ok(service.avaliacaoPorId(id));
    }
    
    @GetMapping("/avaliacao")
    public ResponseEntity<List<Avaliacao>> avaliacao() {
        return ResponseEntity.ok(service.avaliacao());
    }
    
    @DeleteMapping("/avaliacao/{id}")
    public DeleteResult excluirAvaliacaoPorId(@NotNull @PathVariable("id") String id) {
        return service.excluirPorId(id);
    }
    
    @PutMapping("/alterarAvaliacao")
    public ResponseEntity<Avaliacao> alterarAvaliacao(@RequestBody AvaliacaoDTO avaliacao) {
        return ResponseEntity.ok(service.alterarAvaliacao(avaliacao));
    }
}
