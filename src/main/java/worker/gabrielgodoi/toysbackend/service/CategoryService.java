package worker.gabrielgodoi.toysbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import worker.gabrielgodoi.toysbackend.entities.Category;
import worker.gabrielgodoi.toysbackend.erros.EntityNotFoundException;
import worker.gabrielgodoi.toysbackend.repository.CategoryRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category create(Category categoryInsert) {
        return this.categoryRepository.save(categoryInsert);
    }

    public Category findOne(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    public Category update(Long id, Category updateCategory) {
        Category category = this.categoryRepository.getReferenceById(id);
        this.updateData(category, updateCategory);
        return this.categoryRepository.save(category);
    }

    public void delete(Long id) {
        this.categoryRepository.deleteById(id);
    }

    public void deleteMany(List<Long> id) {
        this.categoryRepository.deleteAllById(id);
    }

    public void updateData(Category entity, Category category) {
        entity.setName(category.getName());
    }
}
