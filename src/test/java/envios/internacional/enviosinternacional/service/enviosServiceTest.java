package envios.internacional.enviosinternacional.service;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import envios.internacional.enviosinternacional.repository.EnviosRepository;
import envios.internacional.enviosinternacional.model.Envios;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class enviosServiceTest {
    @InjectMocks
    private enviosServiceImpl enviosServiceMocks;

    @Mock
    private EnviosRepository enviosRepository;

    @BeforeEach
    public void setUp() {
        enviosRepository.deleteAll();
    }

    @AfterEach
    public void tearDown() {
       enviosRepository.deleteAll();
    }

    @Test
    public void testCreateEnvio() {
        Envios envio = new Envios();
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

        when(enviosRepository.save(any(Envios.class))).thenReturn(envio);

        Envios createdEnvio = enviosServiceMocks.createEnvio(envio);

        assertEquals(envio.getTrackingId(), createdEnvio.getTrackingId());
        assertEquals(envio.getRemitente(), createdEnvio.getRemitente());
        assertEquals(envio.getDestinatario(), createdEnvio.getDestinatario());
        assertEquals(envio.getDireccionDestino(), createdEnvio.getDireccionDestino());
        assertEquals(envio.getPaisOrigen(), createdEnvio.getPaisOrigen());
        assertEquals(envio.getPaisDestino(), createdEnvio.getPaisDestino());
        assertEquals(envio.getEstadoEnvio(), createdEnvio.getEstadoEnvio());
        assertEquals(envio.getUbicacionActual(), createdEnvio.getUbicacionActual());
        assertEquals(envio.getFechaEnvio(), createdEnvio.getFechaEnvio());
        assertEquals(envio.getFechaEstimadaEntrega(), createdEnvio.getFechaEstimadaEntrega());
    }

}
