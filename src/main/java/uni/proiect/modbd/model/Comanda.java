package uni.proiect.modbd.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uni.proiect.modbd.LocalDateTimeDeserializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMANDA")
@Getter
@Setter
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comanda")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_plata", nullable = false)
    private Plata plata;

    @ManyToOne
    @JoinColumn(name = "id_piesa_calculator", nullable = false)
    private PiesaCalculator piesaCalculator;

    @ManyToOne
    @JoinColumn(name = "id_curier", nullable = false)
    private Curier curier;

    @Column(name = "stare", nullable = false)
    private String stare;

    @Column(name = "cost", nullable = false)
    private BigDecimal cost;

    @Column(name = "cantitate", nullable = false)
    private int cantitate;

    @Column(name = "data", nullable = false)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime data;

}