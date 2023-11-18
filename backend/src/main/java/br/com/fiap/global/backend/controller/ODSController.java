package br.com.fiap.global.backend.controller;

import br.com.fiap.global.backend.dto.ods.ODSDto;
import br.com.fiap.global.backend.service.ODSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ODSController {

    @Autowired
    private ODSService odsService;

   @RequestMapping(value = "/objetivos", method = RequestMethod.GET)
    public ODSDto objetivos(){
        return odsService.buscaListaObjetivos();
    }

}
