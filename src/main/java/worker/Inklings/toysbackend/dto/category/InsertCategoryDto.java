package worker.Inklings.toysbackend.dto.category;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class InsertCategoryDto {
    private String name;
    private MultipartFile file;
}
