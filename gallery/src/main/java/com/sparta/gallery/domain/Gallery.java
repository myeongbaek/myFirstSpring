package com.sparta.gallery.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Gallery extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    public Gallery(GalleryRequestDto galleryRequestDto) {
        this.username = galleryRequestDto.getUsername();
        this.password = galleryRequestDto.getPassword();
        this.title = galleryRequestDto.getTitle();
        this.contents = galleryRequestDto.getContents();
    }

    public void update(GalleryRequestDto galleryRequestDto){
        this.username = galleryRequestDto.getUsername();
        this.password = galleryRequestDto.getPassword();
        this.title = galleryRequestDto.getTitle();
        this.contents = galleryRequestDto.getContents();
    }
}
