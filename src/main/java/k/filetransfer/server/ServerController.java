package k.filetransfer.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class ServerController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping(value="/uploadFile")
    @ResponseStatus(HttpStatus.OK)
    public String uploadFile(@RequestPart(value="file") MultipartFile file) throws IllegalStateException, IOException {
        if( file != null ) {
            log.debug("file size = {}", file.getSize());
            log.debug("file org name = {}", file.getOriginalFilename());
            log.debug("file content type = {}", file.getContentType());
            try {
                String SAVE_PATH = "/Users/hosuk/k-filetransfer-server/";
                File saveFile = new File(SAVE_PATH + file.getOriginalFilename()); //
                file.transferTo(saveFile);
//                try ( OutputStream os = new FileOutputStream(saveFile) ) {
//                    os.write(file.getBytes());
//                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return "success";
        }
        return "no change";

    }

}
