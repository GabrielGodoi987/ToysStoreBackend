package worker.Inklings.toysbackend.entities;
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

    public Toys(Long id, String name, Double price, String description, String shortDescription, List<String> specifications, Category categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.shortDescription = shortDescription;
        this.specifications = specifications;
        this.categoryId = categoryId;
    }

    @Getter
    private List<String> specifications = new ArrayList<>();

    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne
    private Category categoryId;

    @OneToMany(mappedBy = "toyId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos = new ArrayList<>();
}
