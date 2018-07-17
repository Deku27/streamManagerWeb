package com.neosoft.streamManagerWeb.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.neosoft.streamManagerWeb.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{
	
	 @Query("select new Video(v.idvideo, v.filename) FROM Video v")
	 List<Video> getVideosInfo();
	
	
	 Video findByFilename(String filename);
	 
	
}