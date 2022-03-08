package com.mountain.place.domain.community.service;

import com.mountain.place.controller.community.dto.RegisterCommuDTO;
import com.mountain.place.domain.category.model.Category;
import com.mountain.place.domain.community.dao.CommunityRepository;
import com.mountain.place.domain.community.model.Community;
import com.mountain.place.domain.user.model.User;
import com.mountain.place.exception.CustomException;
import com.mountain.place.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommunityService {

    @Autowired
    CommunityRepository communityRepository;

    public void registerCommu(User user, Long cateId, RegisterCommuDTO registerCommuDTO) {

        Community commu = Community.builder()
                .writerId(user)
                .title(registerCommuDTO.getTitle())
                .content(registerCommuDTO.getContent())
                .build();

        communityRepository.save(commu);
    }


    public Page<Community> findAllCommunity(Pageable pageable) {
        return communityRepository.findAll(pageable);
    }
}