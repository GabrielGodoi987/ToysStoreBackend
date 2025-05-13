package worker.gabrielgodoi.toysbackend.dto.toys;

import lombok.*;
import worker.gabrielgodoi.toysbackend.entities.Category;
import worker.gabrielgodoi.toysbackend.entities.Toys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ToyDto implements Serializable {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String shortDescription;
    private List<String> specifications = new ArrayList<>();
    private Category categoryId;
    private List<String> photos = new ArrayList<>();

    public ToyDto(Toys entity){
        setId(entity.getId());
        setName(entity.getName());
        setPrice(entity.getPrice());
        setDescription(entity.getDescription());
        setShortDescription(entity.getShortDescription());
        entity.getSpecifications().forEach(e -> getSpecifications().add(e));
        entity.getPhotos().forEach(e -> getPhotos().add(e.getPath()));
    }
}
