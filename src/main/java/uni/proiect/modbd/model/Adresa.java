package uni.proiect.modbd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ADRESA")
@Getter
@Setter
public class Adresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adresa")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_oras", nullable = false)
    private Oras oras;

    @ManyToOne
    @JoinColumn(name = "id_arie_curierat", nullable = false)
    private ArieCurierat arieCurierat;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "cod_postal", nullable = false)
    private String codPostal;

}