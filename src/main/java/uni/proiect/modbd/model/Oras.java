package uni.proiect.modbd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORAS")
@Getter
@Setter
public class Oras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oras")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_judet", nullable = false)
    private Judet judet;

    @Column(name = "nume", nullable = false)
    private String nume;

}


