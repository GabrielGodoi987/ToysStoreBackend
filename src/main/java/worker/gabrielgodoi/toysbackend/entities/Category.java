package worker.gabrielgodoi.toysbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String name;

    @JsonIgnore
    @Getter
    @OneToMany(mappedBy = "categoryId")
    private List<Toys> toysList = new ArrayList<>();

    public Category(Long id, String url, String name) {
        this.id = id;
        this.url = url;
        this.name = name;
    }
}
