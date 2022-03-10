package com.mountain.place.domain.likedmountain.service;


import com.mountain.place.controller.likedMountain.dto.LikedMountainDTO;
import com.mountain.place.domain.likedmountain.dao.LikedMountainRepository;
import com.mountain.place.domain.likedmountain.model.Likedmountain;
import com.mountain.place.domain.mountain.dao.MountainRepository;
import com.mountain.place.domain.mountain.model.Mountain;
import com.mountain.place.domain.user.model.User;
import com.mountain.place.exception.CustomException;
import com.mountain.place.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class LikedMountainService {

    @Autowired
    LikedMountainRepository likedMountainRepository;

    @Autowired
    MountainRepository mountainRepository;




    @Transactional
    public void addMountain( User user, LikedMountainDTO likedMountainDTO) {

        Optional<Mountain> mountain = mountainRepository.findById(likedMountainDTO.getMountainNo());

        if(mountain.isPresent()) {

            Likedmountain likedmountain = Likedmountain.builder()
                    .mountainNo(mountain.get())
                    .user(user)
                    .build();

            likedMountainRepository.save(likedmountain);

        } else throw new CustomException(ErrorCode.NOT_FOUND_MOUNTAIN);

    }
}