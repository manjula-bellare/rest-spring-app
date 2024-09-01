import com.springapp.model.FileResource;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(classes = FileControllerTest.class)
@AutoConfigureMockMvc
public class FileControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private FileResource fileResource;

    @Mock
    private FileInputStream fileInputStream;
    @Test
    public void testFileUpload() throws Exception {
        ResponseEntity<FileResource> responseEntity = new ResponseEntity<>(fileResource, HttpStatus.OK);
        MultipartFile multipartFile = new MockMultipartFile("resume_template", fileInputStream);
        this.mockMvc.perform(post("/api/resources/upload")
                .requestAttr("name",  multipartFile)).andReturn();
    }
}
