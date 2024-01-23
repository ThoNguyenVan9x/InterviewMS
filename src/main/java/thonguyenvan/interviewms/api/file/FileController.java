package thonguyenvan.interviewms.api.file;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import thonguyenvan.interviewms.service.file.FileStorageService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileStorageService fileStorageService;

    @GetMapping("/files/**")
    public ResponseEntity<Resource> getFile(HttpServletRequest request) throws IOException {
        String relativePath =
                request.getRequestURL().toString().split("files")[1];
        Resource resource = fileStorageService.loadFileAsResource(relativePath);
        String mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .body(resource);
    }

}
