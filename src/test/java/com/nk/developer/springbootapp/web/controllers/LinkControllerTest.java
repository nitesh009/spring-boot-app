package com.nk.developer.springbootapp.web.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.*;
import java.time.LocalDateTime;
import java.util.Arrays;

import com.nk.developer.springbootapp.entities.Link;
import com.nk.developer.springbootapp.repositories.LinkRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers= LinkController.class)
public class LinkControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LinkRepository linkRepository;

    @Test
    public void allLinks() throws Exception {
        Link link1 = new Link(1L, "Post Title1","URL1", LocalDateTime.now());
        Link link2 = new Link(2L, "Post Title2","URL2", LocalDateTime.now());

        given(this.linkRepository.findAll(any(Sort.class))).willReturn(Arrays.asList(link1, link2));
        this.mvc.perform(get("/api/links")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
        ;
        verify(linkRepository).findAll(any(Sort.class));
    }
}
