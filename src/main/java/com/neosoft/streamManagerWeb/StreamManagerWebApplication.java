package com.neosoft.streamManagerWeb;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neosoft.streamManagerWeb.dao.EitRepository;
import com.neosoft.streamManagerWeb.dao.VideoRepository;
import com.neosoft.streamManagerWeb.entities.Eit;
import com.neosoft.streamManagerWeb.entities.Video;

import com.neosoft.streamManagerWeb.services.StorageService;

@SpringBootApplication
public class StreamManagerWebApplication implements CommandLineRunner {
	
	@Resource
	StorageService storageService;
	
	@Autowired
	private VideoRepository videoRepository;
	
	@Autowired 
	EitRepository eitRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(StreamManagerWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//storageService.init();
	}
}
