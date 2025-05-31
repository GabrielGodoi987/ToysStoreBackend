package worker.Inklings.toysbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import worker.Inklings.toysbackend.dto.category.InsertCategoryDto;
import worker.Inklings.toysbackend.dto.category.UpdateCategoryDto;
import worker.Inklings.toysbackend.entities.Category;
import worker.Inklings.toysbackend.erros.EntityCouldNotBeDeleted;
import worker.Inklings.toysbackend.erros.EntityNotFoundException;
import worker.Inklings.toysbackend.repository.CategoryRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final FileUploadService fileUploadService;

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category create(InsertCategoryDto categoryInsert) {
        Category category = new Category();
        this.entityToDto(category, categoryInsert);
        String filePath = this.fileUploadService.uploadImage(categoryInsert.getFile());
        category.setUrl(filePath);
        return this.categoryRepository.save(category);
    }

    public Category findOne(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    public Category update(Long id, UpdateCategoryDto updateCategory) {
        Category category = this.categoryRepository.getReferenceById(id);
        category.setName(updateCategory.getName());
        return this.categoryRepository.save(category);
    }

    public void delete(Long id) {
        Category cat = this.findOne(id);
        if (cat == null) {
            throw new EntityNotFoundException("Category: " + id + " doesn't exists");
        }
        if (!cat.getToysList().isEmpty()) {
            throw new EntityCouldNotBeDeleted("Category: " + id + " could not be deleted, because there're toys related to her");
        }
        this.categoryRepository.deleteById(id);
    }

    public void entityToDto(Category entity, InsertCategoryDto dto) {
        entity.setName(dto.getName());
    }
}
