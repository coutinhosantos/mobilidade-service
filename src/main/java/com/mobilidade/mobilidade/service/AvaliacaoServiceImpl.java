package com.mobilidade.mobilidade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mobilidade.mobilidade.model.Avaliacao;
import com.mobilidade.mobilidade.model.AvaliacaoDTO;
import com.mongodb.client.result.DeleteResult;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

    private final MongoTemplate mongoTemplate;

    private AvaliacaoFactory avaliacaoFactory;

    @Autowired
    public AvaliacaoServiceImpl(MongoTemplate mongoTemplate, AvaliacaoFactory avaliacaoFactory) {
        this.mongoTemplate = mongoTemplate;
        this.avaliacaoFactory = avaliacaoFactory;
    }

    @Override
    public Avaliacao avaliar(AvaliacaoDTO avaliacao) {
        return mongoTemplate.save(avaliacaoFactory.getAvaliacao(avaliacao));
    }

    @Override
    public Avaliacao avaliacaoPorId(String id) {
        return mongoTemplate.findById(id, Avaliacao.class);
    }

    @Override
    public List<Avaliacao> avaliacao() {
        return mongoTemplate.findAll(Avaliacao.class);
    }

    @Override
    public DeleteResult excluirPorId(String id) {
        return mongoTemplate.remove(new Query(Criteria.where("id").is(id)),Avaliacao.class);
    }

    @Override
    public Avaliacao alterarAvaliacao(AvaliacaoDTO avaliacao) {
        return mongoTemplate.save(avaliacaoFactory.getAvaliacao(avaliacao));
    }
}
