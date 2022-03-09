package com.mountain.place.controller.mountainComment;


import com.mountain.place.controller.mountainComment.dto.RegisterMTCommentDTO;
import com.mountain.place.controller.mountainComment.dto.ResponseMTCommentDTO;
import com.mountain.place.domain.comment.service.CommentService;
import com.mountain.place.domain.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mountains")
public class MountainCommentController {


    @Autowired
    CommentService commentService;

    @PostMapping("/{mountainNo}/comments")
    public ResponseMTCommentDTO createMTComment (@PathVariable(value = "mountainNo")Long mountainNo,
                                                 @RequestBody RegisterMTCommentDTO registerMTCommentDTO,
                                                 Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        return new ResponseMTCommentDTO(commentService.createMTComment(user, mountainNo, registerMTCommentDTO));

    }
}