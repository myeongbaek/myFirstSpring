package com.sparta.gallery.controller;

import com.sparta.gallery.domain.Gallery;
import com.sparta.gallery.domain.GalleryRepository;
import com.sparta.gallery.domain.GalleryRequestDto;
import com.sparta.gallery.service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GalleryController {
    private final GalleryRepository galleryRepository;
    private final GalleryService galleryService;

    @PostMapping("/api/galleries")
    public Gallery createGallery(@RequestBody GalleryRequestDto galleryRequestDto){
        Gallery gallery = new Gallery(galleryRequestDto);
        return galleryRepository.save(gallery);
    }


    @GetMapping("/api/galleries")
    public List<Gallery> readGallery(){
        return galleryRepository.findAllByOrderByModifiedAtDesc();
    }


    @PutMapping("/api/galleries/{id}")
    public Long updateGallery(@PathVariable Long id, @RequestBody GalleryRequestDto galleryRequestDto){
        galleryService.update(id, galleryRequestDto);
        return id;
    }

    @DeleteMapping("/api/galleries/{id}")
    public Long deleteGallery(@PathVariable Long id){
        galleryRepository.deleteById(id);
        return id;
    }
}
