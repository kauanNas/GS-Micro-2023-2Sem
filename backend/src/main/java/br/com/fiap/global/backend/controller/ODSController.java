package br.com.fiap.global.backend.controller;

import br.com.fiap.global.backend.dto.ODSDto;
import br.com.fiap.global.backend.dto.IndicadorDto;
import br.com.fiap.global.backend.service.IndicadorService;
import br.com.fiap.global.backend.service.ODSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ODSController {

    @Autowired
    private ODSService odsService;

    @Autowired
    private IndicadorService indicadorService;


   @RequestMapping(value = "/objetivos", method = RequestMethod.GET)
    public ODSDto objetivos(){
        return odsService.buscaListaObjetivos();
    }

    @RequestMapping(value = "/indicador/{id}")
    public IndicadorDto indicador(@PathVariable Long id){
       return indicadorService.buscaIndicador(id);
    }

}
