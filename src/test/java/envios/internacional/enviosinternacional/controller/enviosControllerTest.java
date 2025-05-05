package envios.internacional.enviosinternacional.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import envios.internacional.enviosinternacional.model.Envios;
import envios.internacional.enviosinternacional.service.enviosService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import java.util.List;

@WebMvcTest(EnviosController.class)
public class enviosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private enviosService enviosServiceMock;

    private Envios envio;
    @BeforeEach
    public void setUp() {
        envio = new Envios();
        envio.setId(1L);
        envio.setTrackingId(12345);
        envio.setRemitente("Juan Perez");
        envio.setDestinatario("Maria Lopez");
        envio.setDireccionDestino("Calle Falsa 123, Ciudad X");
        envio.setPaisOrigen("Chile");
        envio.setPaisDestino("Argentina");
        envio.setEstadoEnvio("En tránsito");
        envio.setUbicacionActual("Santiago");
        envio.setFechaEnvio(LocalDate.of(2025, 5, 1));
        envio.setFechaEstimadaEntrega(LocalDate.of(2025, 5, 10));
    }

    @Test
    public void testGetAllEnvio() throws Exception {
        Envios envio = new Envios();
        envio.setId(1L);
        envio.setTrackingId(12345);
        envio.setRemitente("Juan Perez");
        envio.setDestinatario("Maria Lopez");
        envio.setDireccionDestino("Calle Falsa 123, Ciudad X");
        envio.setPaisOrigen("Chile");
        envio.setPaisDestino("Argentina");
        envio.setEstadoEnvio("En tránsito");
        envio.setUbicacionActual("Santiago");
        envio.setFechaEnvio(LocalDate.of(2025, 5, 1));
        envio.setFechaEstimadaEntrega(LocalDate.of(2025, 5, 10));

        when(enviosServiceMock.getAllEnvios()).thenReturn(Arrays.asList(envio));

        mockMvc.perform(get("/envios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.enviosList[0].trackingId").value(12345))
                .andExpect(jsonPath("$._embedded.enviosList[0].remitente").value("Juan Perez"))
                .andExpect(jsonPath("$._embedded.enviosList[0].destinatario").value("Maria Lopez"))
                .andExpect(jsonPath("$._embedded.enviosList[0].direccionDestino").value("Calle Falsa 123, Ciudad X"))
                .andExpect(jsonPath("$._embedded.enviosList[0].paisOrigen").value("Chile"))
                .andExpect(jsonPath("$._embedded.enviosList[0].paisDestino").value("Argentina"))
                .andExpect(jsonPath("$._embedded.enviosList[0].estadoEnvio").value("En tránsito"))
                .andExpect(jsonPath("$._embedded.enviosList[0].ubicacionActual").value("Santiago"))
                .andExpect(jsonPath("$._embedded.enviosList[0].fechaEnvio").value("2025-05-01"))
                .andExpect(jsonPath("$._embedded.enviosList[0].fechaEstimadaEntrega").value("2025-05-10"));
    }
}
