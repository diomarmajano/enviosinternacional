package envios.internacional.enviosinternacional.controller;

import envios.internacional.enviosinternacional.model.Envios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import envios.internacional.enviosinternacional.service.enviosService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.CollectionModel;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

@RestController
@RequestMapping("/envios")
@CrossOrigin("*")
public class EnviosController {
    private static final Logger log = LoggerFactory.getLogger(EnviosController.class);

    @Autowired
    private enviosService enviosService;

    @PostMapping
    public EntityModel<Envios>createEnvio(@RequestBody Envios envio) {
        Envios createdEnvio = enviosService.createEnvio(envio);
        return EntityModel.of(createdEnvio,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findEnvioById(createdEnvio.getId())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios()).withRel("envios"));
    }

    @PutMapping("/{id}")
    public EntityModel<Envios>updateEnvio(@PathVariable Long id, @RequestBody Envios envio) {
       Optional<Envios> existingEnvio = enviosService.findEnvioById(id);
        if (existingEnvio.isPresent()) {
            Envios updatedEnvio = enviosService.updateEnvio(id, envio);
            return EntityModel.of(updatedEnvio,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findEnvioById(updatedEnvio.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios()).withRel("envios"));
        } else {
            throw new EnvioNotFoundExeption("Envio no encontrado:");
        }
    }

    @DeleteMapping("/{id}")
    public EntityModel<String> deleteEnvio(@PathVariable Long id) {
        enviosService.deleteEnvioById(id);
        return EntityModel.of("Envio eliminado con éxito",
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios()).withRel("envios"));
    }

    @GetMapping
    public CollectionModel<EntityModel<Envios>>getAllEnvios() {
        List<Envios> envios = enviosService.getAllEnvios();
        log.info("GET /envios");
        log.info("Retornando todos los Envios");
        List<EntityModel<Envios>> enviosResources = envios.stream()
        .map(enviosItems -> EntityModel.of(enviosItems,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findEnvioById(enviosItems.getId())).withSelfRel()
        ))
        .collect(Collectors.toList());

    WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios());
    CollectionModel<EntityModel<Envios>> resources = CollectionModel.of(enviosResources, linkTo.withRel("envios"));

    return resources;
    }

    @GetMapping("/{id}")
    public EntityModel<Envios>findEnvioById(@PathVariable Long id) {
        Optional<Envios> envio = enviosService.findEnvioById(id);
        if (envio.isPresent()) {
            return EntityModel.of(envio.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findEnvioById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios()).withRel("usuarios"));
        } else {
            throw new EnvioNotFoundExeption("Envio  no encontrada");
        }
    }
}
