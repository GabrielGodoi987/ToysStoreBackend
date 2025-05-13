package worker.gabrielgodoi.toysbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import worker.gabrielgodoi.toysbackend.dto.category.InsertCategoryDto;
import worker.gabrielgodoi.toysbackend.entities.Category;
import worker.gabrielgodoi.toysbackend.service.CategoryService;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:9000", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody InsertCategoryDto category) {
        Category cat = this.categoryService.create(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(cat.getId()).toUri();
        return ResponseEntity.created(uri).body(cat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        Category cat = this.categoryService.update(id, category);
        return ResponseEntity.ok().body(cat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
