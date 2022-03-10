package com.mountain.place.controller.likedMountain;


import com.mountain.place.controller.likedMountain.dto.LikedMountainDTO;
import com.mountain.place.domain.likedmountain.service.LikedMountainService;
import com.mountain.place.domain.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes/me/mountains")
public class LikedMountainController {

    @Autowired
    LikedMountainService likedMountainService;

    //산 찜하기
    @PostMapping("")
    public void likedMountain(
            @RequestBody LikedMountainDTO likedMountainDTO, Authentication authentication) {

        User user = ((User) authentication.getPrincipal());
        likedMountainService.addMountain(user,likedMountainDTO);
    }


    //찜한산 취소
    @DeleteMapping("/{mountainNo}")
    public void deleteMountain(
            @PathVariable(value = "mountainNo") Long mountainNo,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        likedMountainService.deleteMountain(user,mountainNo);

    }

}