package com.mountain.place.controller.community.dto;


import com.mountain.place.controller.user.dto.UserDTO;
import com.mountain.place.domain.community.model.Community;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseCommuDTO {


    private Long commupostNo;

    private UserDTO user;

    private Long cateId;

    private String category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long viewCount;

    private String title;

    private String content;


    public ResponseCommuDTO(Community community) {
        this.commupostNo = community.getCommupostNo();
        this.cateId = community.getCateId().getId();
        this.category = community.getCateId().getName();
        this.createdAt = community.getFstRegDtm();
        this.updatedAt = community.getLstUpdDtm();
        this.viewCount = community.getViewCount();
        this.title = community.getTitle();
        this.content = community.getContent();
        this.user = new UserDTO(community.getWriterId());
    }

    public ResponseCommuDTO(Long commupostNo) {
        this.commupostNo = commupostNo;
    }

}
