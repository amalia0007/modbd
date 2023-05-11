package uni.proiect.modbd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "JUDET")
@Getter
@Setter
public class Judet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_judet")
    private Long id;

    @Column(name = "nume", nullable = false)
    private String nume;

}