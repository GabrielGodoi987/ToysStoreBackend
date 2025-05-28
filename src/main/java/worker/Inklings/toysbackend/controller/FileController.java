package worker.Inklings.toysbackend.controller;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import worker.Inklings.toysbackend.config.FileStorageProperties;
import worker.Inklings.toysbackend.service.FileUploadService;

import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

@RestController
@RequestMapping("/files/images/")
public class FileController {

    @Autowired
    private FileUploadService fileUploadService;
    private final Path fileStorageLocation;

    public FileController(FileStorageProperties fileStorageLocation) {
        this.fileStorageLocation = Paths.get(fileStorageLocation.getUploadDir()).toAbsolutePath().normalize();
    }

    @GetMapping(value = "/{url}")
    public ResponseEntity<Resource> getUrl(@PathVariable String url) {
        try {
            Path paths = this.fileStorageLocation.resolve(url).normalize();
            Resource resource = new UrlResource(paths.toUri());
            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + url + "\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
