package uni.proiect.modbd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "FURNIZOR")
@Getter
@Setter
public class Furnizor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_furnizor")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_adresa", nullable = false)
    private Adresa adresa;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "telefon", nullable = false)
    private String telefon;

}