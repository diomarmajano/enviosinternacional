package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "envios")
public class Envios {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @NotNull
    @Size(min = 10, max = 10)
    @Column(name = "trackingId")
    private int trackingId;

    @Getter @Setter
    @NotNull
    @Column(name = "remitente")
    private String remitente;

    @Getter @Setter
    @NotNull
    @Column(name = "destinatario")
    private String destinatario;

    @Getter @Setter
    @NotNull
    @Column(name = "direccionDestino")
    private String direccionDestino;

    @Getter @Setter
    @NotNull
    @Column(name = "paisOrigen")
    private String paisOrigen;

    @Getter @Setter
    @NotNull
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
    private String fechaEnvio;

    @Getter @Setter
    @NotNull
    @Column(name = "fechaEstimadaEntrega")
    private String fechaEstimadaEntrega;
}
