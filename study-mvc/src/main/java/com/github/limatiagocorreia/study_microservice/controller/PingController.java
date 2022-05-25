package com.github.limatiagocorreia.study_microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/now")
    public String now() {
        return Instant.now().toString();
    }

    @GetMapping("/{nome}")
    public String welcome(@PathVariable String nome) {
        return "O dia está bom ".concat(nome);
    }

    @GetMapping("/parametros")
    public String parameters(
            @RequestParam String nome,
            @RequestParam String pais
    ) {
        return "O ".concat(nome).concat(" mora no ").concat(pais);
    }

}
