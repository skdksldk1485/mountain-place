package com.mountain.place.controller.mountainComment.dto;


import com.mountain.place.controller.user.dto.UserDTO;
import com.mountain.place.domain.comment.model.Comment;
import com.mountain.place.domain.mountain.model.Mountain;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseMTCommentDTO {

    private Long commentNo;

    private UserDTO user;

    private Mountain mountainNo;

    private String commentContent;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;


    public ResponseMTCommentDTO(Comment mtComment) {
        this.commentNo = mtComment.getCommentNo();
        this.user = new UserDTO(mtComment.getUser());
        this.commentContent = mtComment.getCommentContent();
        this.createdAt = mtComment.getFstRegDtm();
        this.updateAt = mtComment.getLstUpdDtm();
        this.mountainNo = mtComment.getMountainNo();
    }

}
