package worker.Inklings.toysbackend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import worker.Inklings.toysbackend.entities.Category;
import worker.Inklings.toysbackend.entities.Toys;
import worker.Inklings.toysbackend.repository.CategoryRepository;
import worker.Inklings.toysbackend.repository.PhotoRepository;
import worker.Inklings.toysbackend.repository.ToysRepository;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Configuration
@Profile("develop")
public class Instantiation implements CommandLineRunner {
    private final ToysRepository toysRepository;
    private final CategoryRepository categoryRepository;
    private final PhotoRepository photoRepository;

    @Override
    public void run(String... args) throws Exception {
        this.toysRepository.deleteAll();
        this.categoryRepository.deleteAll();

        Category category1 = new Category(
                null,
                "https://example.com/images/action-category.jpg",
                "Ação"
        );

        Category category2 = new Category(
                null,
                "https://example.com/images/educational-category.jpg",
                "Educativos"
        );

        Category category3 = new Category(
                null,
                "https://example.com/images/electronic-category.jpg",
                "Eletrônicos"
        );

        this.categoryRepository.saveAll(Arrays.asList(category1, category2,category3));

    }
}
