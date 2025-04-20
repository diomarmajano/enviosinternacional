package envios.internacional.enviosinternacional.service;

import envios.internacional.enviosinternacional.model.Envios;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import envios.internacional.enviosinternacional.repository.EnviosRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class enviosServiceImpl implements enviosService {

    @Autowired
    private EnviosRepository enviosRepository;

    @Override
    public Envios createEnvio(Envios envio){
        return enviosRepository.save(envio);
    }

    @Override
    public Envios updateEnvio(Long id, Envios envio) {
        if(enviosRepository.existsById(id)){
            envio.setId(id);
            return enviosRepository.save(envio);
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteEnvioById(Long id) {
        if(enviosRepository.existsById(id)){
            enviosRepository.deleteById(id);
        }
    }

    @Override
    public List<Envios> getAllEnvios(){
        return enviosRepository.findAll();
    }

    @Override
    public Optional<Envios> findEnvioById(Long id) {
        return enviosRepository.findById(id);
    }

    @PostConstruct
    public void init(){
        Envios envio_1 = new Envios();
        envio_1.setTrackingId(1212348790);
        envio_1.setRemitente("Gregory majano");
        envio_1.setDestinatario("Diomar Majano");
        envio_1.setDireccionDestino("santa rosa 57899");
        envio_1.setPaisOrigen("Chile");
        envio_1.setPaisDestino("Peru");
        envio_1.setEstadoEnvio("Preparando");
        envio_1.setUbicacionActual("centro de distribucion, la reina");
        envio_1.setFechaEnvio(LocalDate.of(2025, 4, 20));
        envio_1.setFechaEstimadaEntrega(LocalDate.of(2025, 4, 30));

        Envios envio_2 = new Envios();
        envio_2.setTrackingId(1274906578);
        envio_2.setRemitente("Margarita Guerra");
        envio_2.setDestinatario("Gabriel Guerra");
        envio_2.setDireccionDestino("La granja 4456");
        envio_2.setPaisOrigen("Argentina");
        envio_2.setPaisDestino("chile");
        envio_2.setEstadoEnvio("Preparando");
        envio_2.setUbicacionActual("centro de distribucion, buenos aires");
        envio_2.setFechaEnvio(LocalDate.of(2025, 4, 20));
        envio_2.setFechaEstimadaEntrega(LocalDate.of(2025, 4, 30));

        Envios envio_3 = new Envios();
        envio_3.setTrackingId(997309123);
        envio_3.setRemitente("Luz parada");
        envio_3.setDestinatario("maria parra");
        envio_3.setDireccionDestino("florianapolis");
        envio_3.setPaisOrigen("santiago chile");
        envio_3.setPaisDestino("Brazil");
        envio_3.setEstadoEnvio("Preparando");
        envio_3.setUbicacionActual("centro de distribucion, las conde");
        envio_3.setFechaEnvio(LocalDate.of(2025, 4, 20));
        envio_3.setFechaEstimadaEntrega(LocalDate.of(2025, 4, 30));

        enviosRepository.save(envio_1);
        enviosRepository.save(envio_2);
        enviosRepository.save(envio_3);

    }
}
