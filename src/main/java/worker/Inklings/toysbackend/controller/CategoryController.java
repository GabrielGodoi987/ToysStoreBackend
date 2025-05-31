package worker.Inklings.toysbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import worker.Inklings.toysbackend.dto.category.InsertCategoryDto;
import worker.Inklings.toysbackend.entities.Category;
import worker.Inklings.toysbackend.service.CategoryService;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categoryList = this.categoryService.findAll();
        return ResponseEntity.ok().body(categoryList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findOne(@PathVariable Long id) {
        Category category = this.categoryService.findOne(id);
        return ResponseEntity.ok().body(category);
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Category> create(InsertCategoryDto category) {
        Category cat = this.categoryService.create(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(cat.getId()).toUri();
        return ResponseEntity.created(uri).body(cat);
    }

    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, InsertCategoryDto category) {
        Category cat = this.categoryService.update(id, category);
        return ResponseEntity.ok().body(cat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
