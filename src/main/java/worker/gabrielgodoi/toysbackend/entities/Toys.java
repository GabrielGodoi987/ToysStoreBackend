package worker.gabrielgodoi.toysbackend.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_toys")
public class Toys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String shortDescription;

    @Getter
    private List<String> specifications = new ArrayList<>();

    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne
    private Category categoryId;

    @OneToMany(mappedBy = "toyId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos = new ArrayList<>();
}
