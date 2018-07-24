package com.neosoft.streamManagerWeb.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.streamManagerWeb.dao.EitRepository;
import com.neosoft.streamManagerWeb.dao.VideoRepository;
import com.neosoft.streamManagerWeb.entities.Eit;
import com.neosoft.streamManagerWeb.entities.Video;

@RestController
@CrossOrigin("*")
public class EitRestService {
	
	@Autowired
	private EitRepository eitRepository;
	
	@Autowired 
	
	private VideoRepository videoRepository;
		
	 final Logger logger = LoggerFactory.getLogger(EitRestService.class);
	
	/**
	 * this method returns the list of all Eit,
	 * @return the list of eit;
	 */
	@RequestMapping(value ="/eit",method=RequestMethod.GET)
	public List<Eit> getVideos(){
		return eitRepository.findAll();
	}
	
	/**
	 * this method returns a video by its id 
	 * @param id the video id
	 * @return the list of videos
	 */
	
	@RequestMapping(value ="/eit/{id}",method=RequestMethod.GET)
	public Optional<Eit> getEit(@PathVariable   Long id){
		return eitRepository.findById(id);
	}
	
	/**
	 * this method save a video in the database
	 * @param video Object
	 * @return the saved video
	 */
	
	@RequestMapping(value ="/eit",method=RequestMethod.POST)
	public Eit save(@RequestBody Eit e ){
		Video v = videoRepository.findByFilename(e.getVideofile());
		e.setVideo(v);
		return eitRepository.save(e);
	}
	
	/**
	 * this method delete a video 
	 * @param video id
	 * @return true in case video has been successfully deleted
	 */
	@RequestMapping(value ="/eit/{id}",method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id ){
		
		eitRepository.deleteById(id);
		return true;
	}
	
	/**
	 * this method update a video in the database
	 * @param video id
	 * @param video Object
	 * @return the updated video
	 */
	
	@RequestMapping(value ="/eit/{id}",method=RequestMethod.PUT)
	public Eit save(@PathVariable Long id , @RequestBody Eit e ){
		e.setIdeit(id);
		Video v = videoRepository.findByFilename(e.getVideofile());
		e.setVideo(v);
		return eitRepository.save(e);
	}
}