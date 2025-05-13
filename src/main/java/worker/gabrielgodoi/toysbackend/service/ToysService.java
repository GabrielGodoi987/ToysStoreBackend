package worker.gabrielgodoi.toysbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import worker.gabrielgodoi.toysbackend.dto.toys.InsertToyDto;
import worker.gabrielgodoi.toysbackend.dto.toys.ToyDto;
import worker.gabrielgodoi.toysbackend.entities.Category;
import worker.gabrielgodoi.toysbackend.entities.Photo;
import worker.gabrielgodoi.toysbackend.entities.Toys;
import worker.gabrielgodoi.toysbackend.erros.EntityNotFoundException;
import worker.gabrielgodoi.toysbackend.repository.CategoryRepository;
import worker.gabrielgodoi.toysbackend.repository.PhotoRepository;
import worker.gabrielgodoi.toysbackend.repository.ToysRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ToysService {
    private final ToysRepository toysRepository;
    private final CategoryRepository categoryRepository;
    private final FileUploadService fileUploadService;
    private final PhotoRepository photoRepository;

    public List<ToyDto> findAll() {
        List<Toys> toysList = this.toysRepository.findAll();
        return toysList.stream().map(ToyDto::new).collect(Collectors.toList());
    }

    public ToyDto create(InsertToyDto toyDto) {
        Toys toys = new Toys();
        this.entityToDto(toys, toyDto);
        Category category = this.categoryRepository.findById(toyDto.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("Category not found"));
        toys.setCategoryId(category);

        toys = this.toysRepository.save(toys);

        for (MultipartFile multipartFile : toyDto.getPhotos()) {
            String path = this.fileUploadService.uploadImage(multipartFile);
            Photo photo = new Photo(null, path, toys);
            this.photoRepository.save(photo);
            toys.getPhotos().add(photo);
        }

        return new ToyDto(toys);
    }

    public Toys findOne(Long id) {
        return this.toysRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Toy not found"));
    }

    public List<Toys> findByCategory(Long categoryId) {
        return this.toysRepository.findByCategoryId(categoryId);
    }

    public Toys update(Long id, Toys updateToy) {
        try {
            Toys toy = this.toysRepository.getReferenceById(id);
            this.updateData(toy, updateToy);
            return this.toysRepository.save(toy);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    public void delete(Long id) {
        this.toysRepository.deleteById(id);
    }

    public void deleteMany(List<Long> id) {
        this.toysRepository.deleteAllById(id);
    }

    public void updateData(Toys entity, Toys toy) {
        entity.setName(toy.getName());
        entity.setPrice(toy.getPrice());
        entity.setDescription(toy.getDescription());
        entity.setCategoryId(toy.getCategoryId());
    }

    public void entityToDto(Toys toys, InsertToyDto toyDto) {
        toys.setName(toyDto.getName());
        toys.setPrice(toyDto.getPrice());
        toys.setDescription(toyDto.getDescription());
        toys.setShortDescription(toyDto.getShortDescription());
        toyDto.getSpecifications().forEach(e -> toys.getSpecifications().add(e));
    }
}
