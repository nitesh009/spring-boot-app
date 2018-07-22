package com.nk.developer.springbootapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "links")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Link {

    @Id
    @SequenceGenerator(name="link_id_generator", sequenceName="link_id_sequence", initialValue = 100)
    @GeneratedValue(generator = "link_id_generator")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    private LocalDateTime createdOn = LocalDateTime.now();

    public Link(long l, String post_title1, String url1, LocalDateTime now) {
        this.url = url1;
        this.id = l;
        this.title = post_title1;
    }
}
