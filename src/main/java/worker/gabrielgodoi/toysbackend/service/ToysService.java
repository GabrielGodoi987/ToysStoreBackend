package worker.gabrielgodoi.toysbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import worker.gabrielgodoi.toysbackend.entities.Toys;
import worker.gabrielgodoi.toysbackend.erros.EntityNotFoundException;
import worker.gabrielgodoi.toysbackend.repository.ToysRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ToysService {
    private final ToysRepository toysRepository;

    public List<Toys> findAll(){
        return this.toysRepository.findAll();
    }

    public Toys create(Toys toyEntity){
        return this.toysRepository.save(toyEntity);
    }

    public Toys findOne(Long id){
        return this.toysRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Toy not found"));
    }

    public List<Toys> findByCategory(Long categoryId){
        return this.toysRepository.findByCategoryId(categoryId);
    }

    public Toys update(Long id, Toys updateToy){
        try{
            Toys toy = this.toysRepository.getReferenceById(id);
            this.updateData(toy, updateToy);
            return this.toysRepository.save(toy);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    public void delete(Long id){
        this.toysRepository.deleteById(id);
    }
    public void deleteMany(List<Long> id){
        this.toysRepository.deleteAllById(id);
    }

    public void updateData(Toys entity, Toys toy){
        entity.setName(toy.getName());
        entity.setPrice(toy.getPrice());
        entity.setDescription(toy.getDescription());
        entity.setCategoryId(toy.getCategoryId());
    }
}
