package worker.gabrielgodoi.toysbackend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import worker.gabrielgodoi.toysbackend.entities.Category;
import worker.gabrielgodoi.toysbackend.entities.Toys;
import worker.gabrielgodoi.toysbackend.repository.CategoryRepository;
import worker.gabrielgodoi.toysbackend.repository.PhotoRepository;
import worker.gabrielgodoi.toysbackend.repository.ToysRepository;

import java.util.ArrayList;
import java.util.Arrays;

@RequiredArgsConstructor
@Configuration
@Profile("test")
public class Instantiation implements CommandLineRunner {
    private final ToysRepository toysRepository;
    private final CategoryRepository categoryRepository;
    private final PhotoRepository photoRepository;

    @Override
    public void run(String... args) throws Exception {
    }
}
