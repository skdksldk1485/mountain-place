package com.mountain.place.controller.community;

import com.mountain.place.controller.category.dto.ResponseCategoryDTO;
import com.mountain.place.controller.community.dto.RegisterCommuDTO;
import com.mountain.place.controller.community.dto.ResponseCommuDTO;
import com.mountain.place.domain.category.model.Category;
import com.mountain.place.domain.category.service.CategoryService;
import com.mountain.place.domain.community.model.Community;
import com.mountain.place.domain.community.service.CommunityService;
import com.mountain.place.domain.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/communities")
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @Autowired
    CategoryService categoryService;





    //// 커뮤니티 글 조회
    @GetMapping("")
    public Page<ResponseCommuDTO> getCommunityList(Pageable pageable){
        return communityService.findAllCommunity(pageable).map(Community -> new ResponseCommuDTO(Community));
    }

}