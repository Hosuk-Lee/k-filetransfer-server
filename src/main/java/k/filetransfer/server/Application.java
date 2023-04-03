package k.filetransfer.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

//    @PostMapping(value="uploadFile")
//    public ResponseEntity<String> uploadFile(MultipartFile file) throws IllegalStateException, IOException{
//
//        if( !file.isEmpty() ) {
//            log.debug("file org name = {}", file.getOriginalFilename());
//            log.debug("file content type = {}", file.getContentType());
//            try {
//                file.transferTo(new File(file.getOriginalFilename()));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        return new ResponseEntity<>("", HttpStatus.OK);
//    }
}
