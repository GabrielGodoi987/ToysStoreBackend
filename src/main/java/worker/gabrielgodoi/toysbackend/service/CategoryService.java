package worker.gabrielgodoi.toysbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import worker.gabrielgodoi.toysbackend.dto.category.InsertCategoryDto;
import worker.gabrielgodoi.toysbackend.entities.Category;
import worker.gabrielgodoi.toysbackend.erros.EntityCouldNotBeDeleted;
import worker.gabrielgodoi.toysbackend.erros.EntityNotFoundException;
import worker.gabrielgodoi.toysbackend.repository.CategoryRepository;

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

    public Category update(Long id, Category updateCategory) {
        Category category = this.categoryRepository.getReferenceById(id);
        this.updateData(category, updateCategory);
        return this.categoryRepository.save(category);
    }

    public void delete(Long id) {
        Category cat = this.findOne(id);
        if (cat == null){
            throw new EntityNotFoundException("Category: " + id + " doesn't exists");
        }
        if (!cat.getToysList().isEmpty()){
            throw new EntityCouldNotBeDeleted("Category: " + id + " could not be deleted, because there're toys related to her");
        }
        this.categoryRepository.deleteById(id);
    }

    public void deleteMany(List<Long> id) {
        this.categoryRepository.deleteAllById(id);
    }

    public void updateData(Category entity, Category category) {
        entity.setName(category.getName());
    }

    public void entityToDto(Category entity, InsertCategoryDto dto){
        entity.setName(dto.getName());
    }
}
