package uni.proiect.modbd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "PIESA_CALCULATOR")
@Getter
@Setter
public class PiesaCalculator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piesa_calculator")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_furnizor", nullable = false)
    private Furnizor furnizor;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "descriere", nullable = false)
    private String descriere;

    @Column(name = "tip", nullable = false)
    private String tip;

    @Column(name = "pret", nullable = false)
    private BigDecimal pret;

}