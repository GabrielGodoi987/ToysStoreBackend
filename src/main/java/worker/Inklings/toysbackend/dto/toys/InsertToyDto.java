package worker.Inklings.toysbackend.dto.toys;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class InsertToyDto {
    private String name;
    private Double price;
    private String description;
    private String shortDescription;
    private Long categoryId;
    private List<String> specifications = new ArrayList<>();
    @Getter
    private List<MultipartFile> photos = new ArrayList<>();
}
