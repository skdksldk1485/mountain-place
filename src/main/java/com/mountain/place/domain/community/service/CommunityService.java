package com.mountain.place.domain.community.service;

import com.mountain.place.controller.community.dto.RegisterCommuDTO;
import com.mountain.place.domain.category.model.Category;
import com.mountain.place.domain.category.service.CategoryService;
import com.mountain.place.domain.community.dao.CommunityRepository;
import com.mountain.place.domain.community.model.Community;
import com.mountain.place.domain.user.model.User;
import com.mountain.place.exception.CustomException;
import com.mountain.place.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommunityService {

    @Autowired
    CommunityRepository communityRepository;
    @Autowired
    CategoryService categoryService;


    public Community registerCommunity(RegisterCommuDTO registerCommuDTO ,User user ) {

        Category category = categoryService.findCateByNo(registerCommuDTO);

        Community community = Community.builder()
                .writerId(user)
                .title(registerCommuDTO.getTitle())
                .cateId(category)
                .content(registerCommuDTO.getContent())
                .build();

        return communityRepository.save(community);
    }



    public Page<Community> findAll(Specification<Community> spec, Pageable pageable) {
        Page<Community> communities = communityRepository.findAll(spec, pageable);

        if (communities.isEmpty())
            throw new CustomException(ErrorCode.NOT_FOUND_COMMUNITY);

        return communities;
    }
}