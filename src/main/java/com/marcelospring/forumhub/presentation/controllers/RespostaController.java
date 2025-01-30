package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.domain.entities.Resposta;
import com.marcelospring.forumhub.presentation.dtos.RespostaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/respostas")
public class RespostaController {

    @PostMapping(value = "/adicionar-resposta")
    public ResponseEntity<Void> adicionarResposta(@RequestBody RespostaDto respostaDto) {





    }
}
