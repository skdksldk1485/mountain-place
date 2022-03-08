package com.mountain.place.controller.community.specification;

import com.mountain.place.domain.category.model.Category;
import com.mountain.place.domain.community.model.Community;
import com.mountain.place.domain.user.model.User;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class CommunitySpecification {


    public static Specification<Community> equalCateId(Long cateId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("cateId").get("id"), cateId));
        //root - 제너릭에들어간 Community 객체 가리킴 , get으로 longtype 맞을때까지 꺼내올 수 있음
    }

    public static Specification<Community> equalTitle(String title) {
        return (((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title)));
    }

}