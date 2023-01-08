package com.crystal.school.service;

import com.crystal.school.model.Image;
import com.crystal.school.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Transactional
    public Image uploadImage(String name, byte[] data) {
        Image image = new Image();
        image.setName(name);
        image.setData(data);
        return imageRepository.save(image);
    }

    public Image getImage(Long id) {
        return imageRepository.findById(id).orElse(defaultImage());
    }

    private Image defaultImage() {
        return null;
    }


}
