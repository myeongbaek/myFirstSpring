package com.sparta.gallery.service;

import com.sparta.gallery.domain.Gallery;
import com.sparta.gallery.domain.GalleryRepository;
import com.sparta.gallery.domain.GalleryRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class GalleryService {

    private final GalleryRepository galleryRepository;


    @Transactional
    public Long update(Long id, GalleryRequestDto galleryRequestDto){
        Gallery gallery = galleryRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        gallery.update(galleryRequestDto);
        return gallery.getId();
    }
}
