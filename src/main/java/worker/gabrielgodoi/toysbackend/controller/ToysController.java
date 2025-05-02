package worker.gabrielgodoi.toysbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import worker.gabrielgodoi.toysbackend.entities.Toys;
import worker.gabrielgodoi.toysbackend.service.ToysService;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/toys")
public class ToysController {
    private final ToysService toysService;

    @GetMapping
    public ResponseEntity<List<Toys>> findAll() {
        List<Toys> toysList = this.toysService.findAll();
        return ResponseEntity.ok().body(toysList);
    }

    @GetMapping("/{id}")
    public Toys findOne(@PathVariable Long id){
        return this.toysService.findOne(id);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Toys>> findByCategory(@PathVariable Long categoryId){
        List<Toys> toysList = this.toysService.findByCategory(categoryId);
        return ResponseEntity.ok().body(toysList);
    }
    @PostMapping
    public ResponseEntity<Toys> create(@RequestBody Toys insertToy) {
        Toys toys = this.toysService.create(insertToy);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(insertToy.getId()).toUri();
        return ResponseEntity.created(uri).body(toys);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Toys> update(@PathVariable Long id, @RequestBody Toys updateToy) {
        Toys toy = this.toysService.update(id, updateToy);
        return ResponseEntity.ok().body(toy);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.toysService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/delete/many")
    public ResponseEntity<Void> deleteMany(@RequestBody List<Long> id) {
        this.toysService.deleteMany(id);
        return ResponseEntity.noContent().build();
    }
}
