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
import java.util.List;

@RequiredArgsConstructor
@Configuration
@Profile("production")
public class Instantiation implements CommandLineRunner {
    private final ToysRepository toysRepository;
    private final CategoryRepository categoryRepository;
    private final PhotoRepository photoRepository;

    @Override
    public void run(String... args) throws Exception {
        Category c1 = new Category(null, "", "carrinhos");
        Toys t1 = new Toys(null, "carrinho de controle remoto", 2.99, "carrinho de cria", "carrinho pros cria sorri", List.of("1", "2", "3"), c1);

        this.categoryRepository.saveAll(List.of(c1));
        this.toysRepository.saveAll(List.of(t1));
    }
}
