package uni.proiect.modbd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CURIER")
@Getter
@Setter
public class Curier {
    @Id
    @Column(name = "id_curier", nullable=false)
    private Long id;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "prenume", nullable = false)
    private String prenume;

    @Column(name = "telefon", nullable = false)
    private String telefon;

    @Column(name = "email", nullable = false)
    private String email;

}