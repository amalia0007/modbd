package uni.proiect.modbd.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uni.proiect.modbd.LocalDateTimeDeserializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PLATA")
@Getter
@Setter
public class Plata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plata")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @Column(name = "tip", nullable = false)
    private String tip;

    @Column(name = "cost", nullable = false)
    private BigDecimal cost;

    @Column(name = "cifre_card", nullable = false)
    private int cifreCard;

    @Column(name = "data", nullable = false)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime data;

}