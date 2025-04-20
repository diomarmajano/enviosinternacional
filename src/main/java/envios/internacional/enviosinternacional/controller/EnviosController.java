package envios.internacional.enviosinternacional.controller;

import envios.internacional.enviosinternacional.model.Envios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import envios.internacional.enviosinternacional.service.enviosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/envios")
@CrossOrigin("*")
public class EnviosController {

    @Autowired
    private enviosService enviosService;

    @PostMapping
    public Envios createEnvio(@RequestBody Envios envio) {
        return enviosService.createEnvio(envio);
    }

    @PutMapping("/{id}")
    public Envios updateEnvio(@PathVariable Long id, @RequestBody Envios envio) {
        return enviosService.updateEnvio(id, envio);
    }

    @DeleteMapping("/{id}")
    public void deleteEnvio(@PathVariable Long id) {
        enviosService.deleteEnvioById(id);
    }

    @GetMapping
    public List<Envios> getAllEnvios() {
        return enviosService.getAllEnvios();
    }

    @GetMapping("/{id}")
    public Optional<Envios> findEnvioById(@PathVariable Long id) {
        return enviosService.findEnvioById(id);
    }
}
