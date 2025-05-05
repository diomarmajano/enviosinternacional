package envios.internacional.enviosinternacional.repository;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import envios.internacional.enviosinternacional.model.Envios;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class envioaRepositoryTest {
    @Autowired
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
    public void testSaveUser() {
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

        Envios resultado = enviosRepository.save(envio);
        assertNotNull(resultado.getId());
        assertEquals(envio.getRemitente(), resultado.getRemitente());
        assertEquals(envio.getDestinatario(), resultado.getDestinatario());
        assertEquals(envio.getDireccionDestino(), resultado.getDireccionDestino());
        assertEquals(envio.getPaisOrigen(), resultado.getPaisOrigen());
        assertEquals(envio.getPaisDestino(), resultado.getPaisDestino());
        assertEquals(envio.getEstadoEnvio(), resultado.getEstadoEnvio());
        assertEquals(envio.getUbicacionActual(), resultado.getUbicacionActual());
        assertEquals(envio.getFechaEnvio(), resultado.getFechaEnvio());
        assertEquals(envio.getFechaEstimadaEntrega(), resultado.getFechaEstimadaEntrega());
    }
    
}
