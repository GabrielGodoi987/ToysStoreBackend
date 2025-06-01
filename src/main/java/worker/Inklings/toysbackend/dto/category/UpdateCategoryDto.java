package worker.Inklings.toysbackend.dto.category;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryDto {
    private Integer id;
    private String name;
    private String url;
}
