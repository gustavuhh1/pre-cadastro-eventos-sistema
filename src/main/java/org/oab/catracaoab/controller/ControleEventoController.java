package org.oab.catracaoab.controller;

import org.oab.catracaoab.service.ControleEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/control")
public class ControleEventoController {

    @Autowired
    private ControleEventoService controleEventoService;

    public ResponseEntity<?> aprovarParticipante(@RequestBody String cpf, @RequestBody String slugEvento) {
        controleEventoService.aprovarParticipante(cpf, slugEvento);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> recusarParticipante(@RequestBody String cpf, @RequestBody String slugEvento) {
        controleEventoService.recusarParticipante(cpf, slugEvento);

        return ResponseEntity.ok().build();
    }

}
