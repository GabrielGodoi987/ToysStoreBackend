package worker.gabrielgodoi.toysbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import worker.gabrielgodoi.toysbackend.config.FileStorageProperties;
import worker.gabrielgodoi.toysbackend.erros.BadFormatException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class FileUploadService {
    private final Path fileStorageLocation;

    public FileUploadService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
    }

    public String uploadImage(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if (fileName.contains("..") || fileName.startsWith("/") || fileName.contains("\\") || fileName.contains("%")) {
            throw new BadFormatException("Invalid file path: " + fileName);
        }
        if (!(fileName.toLowerCase().endsWith(".jpg") || fileName.toLowerCase().endsWith(".png"))) {
            throw new BadFormatException("This file type is not supported: " + fileName);
        }

        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            file.transferTo(targetLocation);
            return ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/images/").path(fileName).toUriString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
