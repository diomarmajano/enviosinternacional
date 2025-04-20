package envios.internacional.enviosinternacional.service;
import envios.internacional.enviosinternacional.model.Envios;
import java.util.List;
import java.util.Optional;

public interface enviosService {
    Envios createEnvio(Envios envio);
    Envios updateEnvio(Long id, Envios envio);
    void deleteEnvioById(Long id);
    List<Envios> getAllEnvios();
    Optional<Envios> findEnvioById(Long id);
}
