package br.com.fiap.global.backend.service;

import br.com.fiap.global.backend.dto.indicador.IndicadorDto;
import br.com.fiap.global.backend.dto.indicador.IndicadorDtoHomeView;
import br.com.fiap.global.backend.dto.indicador.IndicadorDtoMetricasView;
import br.com.fiap.global.backend.model.Indicador;
import br.com.fiap.global.backend.repository.IndicadorRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.Assert.*;

public class IndicadorServiceTest {

    private AutoCloseable autoCloseable;

    @Spy
    @InjectMocks
    private IndicadorService service;

    @Mock
    private IndicadorRepository  repository;

    @Before
    public void setUp() throws Exception {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    public void buscaIndicador() {
        Indicador indicador = new Indicador(1L, "codigo", "desc", "ano", 8.5, "regiao");

        Mockito.when(repository.getReferenceById(1L)).thenReturn(indicador);

        IndicadorDto result = service.buscaIndicador(1L);

        IndicadorDto expected = new IndicadorDto("ano", 8.5);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void buscaListaIndicadores() {
        Indicador indicador = new Indicador(1L, "codigo", "desc", "ano", 8.5, "regiao");

        Mockito.when(repository.findAll()).thenReturn(List.of(indicador));

        List<IndicadorDtoHomeView> result = service.buscaListaIndicadores();

        IndicadorDtoHomeView dtoHomeView = new IndicadorDtoHomeView("codigo");

        Assert.assertEquals(List.of(dtoHomeView), result);
    }

    @Test
    public void buscaMetricas() {
        Indicador indicador = new Indicador(1L, "teste", "desc", "ano", 8.5, "regiao");

        Mockito.when(repository.findAllByCodigo("teste")).thenReturn(List.of(indicador));

        List<IndicadorDtoMetricasView> result = service.buscaMetricas("teste");

        IndicadorDtoMetricasView expected = new IndicadorDtoMetricasView("teste", "ano", 8.5, "desc", "regiao");

        Assert.assertEquals(List.of(expected), result);

    }
}