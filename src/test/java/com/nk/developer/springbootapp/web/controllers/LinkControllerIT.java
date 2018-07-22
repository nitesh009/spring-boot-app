package com.nk.developer.springbootapp.web.controllers;

import com.nk.developer.springbootapp.SpringBootAppApplication;
import com.nk.developer.springbootapp.entities.Link;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAppApplication.class, webEnvironment= RANDOM_PORT)
public class LinkControllerIT {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testPing()
    {
        ResponseEntity<Link[]> respEntity = restTemplate.getForEntity("/api/links", Link[].class);
        assertThat(respEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(respEntity.getBody()).hasSize(3);
    }
}