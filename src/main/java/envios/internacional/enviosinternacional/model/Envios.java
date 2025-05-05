package envios.internacional.enviosinternacional.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Entity
@Table(name = "envios")
public class Envios extends RepresentationModel<Envios>{
    @Getter @Setter 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @NotNull
    @Column(name = "trackingId")
    private int trackingId;

    @Getter @Setter
    @NotNull
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El nombre solo debe tener letras")
    @Column(name = "remitente")
    private String remitente;

    @Getter @Setter
    @NotNull
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El destinatario solo debe tener letras")
    @Column(name = "destinatario")
    private String destinatario;

    @Getter @Setter
    @NotNull
    @Column(name = "direccionDestino")
    private String direccionDestino;

    @Getter @Setter
    @NotNull
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Solo deben haber letras")
    @Column(name = "paisOrigen")
    private String paisOrigen;

    @Getter @Setter
    @NotNull
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Solo deben haber letras")
    @Column(name = "paisDestino")
    private String paisDestino;

    @Getter @Setter
    @NotNull
    @Column(name = "estadoEnvio")
    private String estadoEnvio;

    @Getter @Setter
    @Column(name = "ubicacionActual")
    private String ubicacionActual;

    @Getter @Setter
    @NotNull
    @Column(name = "fechaEnvio")
    private LocalDate fechaEnvio;

    @Getter @Setter
    @NotNull
    @Column(name = "fechaEstimadaEntrega")
    private LocalDate fechaEstimadaEntrega;
}
