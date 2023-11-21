package br.com.fiap.global.backend.service;

import br.com.fiap.global.backend.dto.indicador.IndicadorDtoODS;
import br.com.fiap.global.backend.dto.objetivo.ObjetivoDto;
import br.com.fiap.global.backend.dto.ods.ODSDto;
import br.com.fiap.global.backend.model.Indicador;
import br.com.fiap.global.backend.model.ODS;
import br.com.fiap.global.backend.model.Objetivo;
import br.com.fiap.global.backend.repository.ODSRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

public class ODSServiceTest {

    private AutoCloseable autoCloseable;

    @Spy
    @InjectMocks
    private ODSService service;

    @Mock
    private ODSRepository repository;

    @Before
    public void setUp() throws Exception {
       autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    public void buscaListaObjetivos() {
        Objetivo objetivo = new Objetivo(1L, "teste global", "teste brasil");
        Indicador indicador = new Indicador(1L, "codigo", "desc", "ano", 8.5, "regiao");
        ODS ods = new ODS(1L, "teste", objetivo, List.of(indicador));

        Mockito.when(repository.findAll()).thenReturn(List.of(ods));
        ODSDto result = service.buscaListaObjetivos();

        ObjetivoDto objetivoDto = new ObjetivoDto("teste global", "teste brasil");
        IndicadorDtoODS indicadores = new IndicadorDtoODS("codigo", "desc");
        ODSDto expected = new ODSDto("teste", objetivoDto, List.of(indicadores));

        Assert.assertEquals(expected, result);
    }

}