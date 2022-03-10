package com.mountain.place.domain.likedmountain.dao;


import com.mountain.place.domain.likedmountain.model.Likedmountain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikedMountainRepository extends JpaRepository<Likedmountain,Long> {
}