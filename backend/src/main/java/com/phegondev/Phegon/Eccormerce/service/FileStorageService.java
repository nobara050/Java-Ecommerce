package com.no3ra.Phegon.Eccormerce.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@Slf4j
public class FileStorageService {

    @Value("${file.upload-dir:uploads}")
    private String uploadDir;

    /**
     * Lưu ảnh vào thư mục local và trả về đường dẫn để lưu trong DB.
     */
    public String saveImage(MultipartFile photo) {
        if (photo == null || photo.isEmpty()) {
            throw new RuntimeException("No image provided");
        }

        try {
            String originalFilename = photo.getOriginalFilename();
            String extension = "";
            if (originalFilename != null && originalFilename.contains(".")) {
                extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }

            String storedFileName = UUID.randomUUID() + extension;

            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path targetLocation = uploadPath.resolve(storedFileName);

            try (InputStream inputStream = photo.getInputStream()) {
                Files.copy(inputStream, targetLocation, StandardCopyOption.REPLACE_EXISTING);
            }

            return "/uploads/" + storedFileName;
        } catch (IOException e) {
            log.error("Unable to save image locally", e);
            throw new RuntimeException("Unable to save image locally: " + e.getMessage());
        }
    }
}

