package uni.proiect.modbd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ARIE_CURIERAT")
@Getter
@Setter
public class ArieCurierat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arie_curierat")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_curier", nullable = false)
    private Curier curier;

}