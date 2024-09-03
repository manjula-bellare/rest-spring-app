package com.springapp;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FileControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testUploadFile() throws Exception {
        MockMultipartFile mockMultipartFile
                = new MockMultipartFile("name", "resume_template.txt", MediaType.MULTIPART_FORM_DATA_VALUE, "multipartfile".getBytes()
        );
        this.mockMvc.perform(multipart("/api/resources/upload")
                .file(mockMultipartFile)
                .requestAttr("name",  mockMultipartFile))
                .andExpect(status().isOk());

    }

    @Test
    public void testUserProfile() throws Exception {
        this.mockMvc.perform(get("/api/resources/user?id=1"))
                .andExpect(status().isOk());

    }
}
