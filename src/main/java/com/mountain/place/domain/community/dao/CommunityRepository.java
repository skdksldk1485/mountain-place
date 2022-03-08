package com.mountain.place.domain.community.dao;


import com.mountain.place.domain.community.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> , JpaSpecificationExecutor<Community> {


}