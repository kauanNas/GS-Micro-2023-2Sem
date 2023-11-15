package br.com.fiap.global.backend.controller;

import br.com.fiap.global.backend.dto.ODSDto;
import br.com.fiap.global.backend.model.ODS;
import br.com.fiap.global.backend.service.ODSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ODSController {

    @Autowired
    private ODSService service;


   @RequestMapping(value = "/objetivos", method = RequestMethod.GET)
    public ODSDto objetivos(){
        return service.buscaListaObjetivos();
    }


}
