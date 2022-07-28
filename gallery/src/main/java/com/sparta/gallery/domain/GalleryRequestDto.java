package com.sparta.gallery.domain;

import lombok.Getter;

@Getter
public class GalleryRequestDto {
    private String username;
    private String password;
    private String title;
    private String contents;
}
