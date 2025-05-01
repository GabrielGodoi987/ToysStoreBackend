package worker.gabrielgodoi.toysbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import worker.gabrielgodoi.toysbackend.entities.Toys;
import worker.gabrielgodoi.toysbackend.service.ToysService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/toys")
public class ToysController {
    private final ToysService toysService;

    // findall
    @GetMapping
    public ResponseEntity<List<Toys>> findAll() {
        List<Toys> toysList = this.toysService.findAll();
        return ResponseEntity.ok().body(toysList);
    }

    // create
    @PostMapping
    public ResponseEntity<Toys> create(@RequestBody Toys insertToy) {
        Toys toys = this.toysService.create(insertToy);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(insertToy.getId()).toUri();
        return ResponseEntity.created(uri).body(toys);
    }

    // update
    @PutMapping(value = "/{id}")
    public ResponseEntity<Toys> update(@PathVariable Long id, @RequestBody Toys updateToy) {
        Toys toy = this.toysService.update(id, updateToy);
        return ResponseEntity.ok().body(toy);
    }

    // delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.toysService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // delete many
    @DeleteMapping(value = "/delete/many")
    public ResponseEntity<Void> deleteMany(@RequestBody List<Long> id) {
        this.toysService.deleteMany(id);
        return ResponseEntity.noContent().build();
    }
}
