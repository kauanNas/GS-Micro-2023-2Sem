package br.com.fiap.global.backend.controller;

import br.com.fiap.global.backend.dto.indicador.IndicadorDto;
import br.com.fiap.global.backend.dto.indicador.IndicadorDtoHomeView;
import br.com.fiap.global.backend.dto.indicador.IndicadorDtoMetricasView;
import br.com.fiap.global.backend.service.IndicadorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {IndicadorController.class})
public class IndicadorControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private IndicadorController indicadorController;

    @Mock
    private IndicadorService indicadorService;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(indicadorController).build();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void indicador() throws Exception {
        IndicadorDto indicadorDto = new IndicadorDto("2023", 8.5);
        Mockito.when(indicadorService.buscaIndicador(1L)).thenReturn(indicadorDto);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/indicador/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((MockMvcResultMatchers.jsonPath("$.ano", is("2023"))))
                .andExpect((MockMvcResultMatchers.jsonPath("$.consumo", is(8.5))));

    }

    @Test
    public void listaIndicadores() throws Exception {
        IndicadorDtoHomeView dtoHomeView = new IndicadorDtoHomeView("teste");
        Mockito.when(indicadorService.buscaListaIndicadores()).thenReturn(List.of(dtoHomeView));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/indicadores").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].codigo", is("teste")));
    }

    @Test
    public void metricasIndicador() throws Exception {
        IndicadorDtoMetricasView dtoMetricasView = new IndicadorDtoMetricasView("teste", "ano", 8.5, "desc", "regiao");
        Mockito.when(indicadorService.buscaMetricas("teste")).thenReturn(List.of(dtoMetricasView));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/buscaMetricas/teste").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is("teste")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ano").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].consumo", is(8.5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].descricao").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].regiao").isNotEmpty());

    }
}