package com.neosoft.streamManagerWeb.web;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neosoft.streamManagerWeb.dao.EitRepository;
import com.neosoft.streamManagerWeb.dao.VideoRepository;
import com.neosoft.streamManagerWeb.entities.Eit;
import com.neosoft.streamManagerWeb.entities.Video;

import com.neosoft.streamManagerWeb.services.StorageService;
@RestController
@CrossOrigin("*")
public class VideoRestService {	
	
	@Autowired
	private VideoRepository videoRepository;
	
	@Autowired
	
	StorageService storageService;
	
	@Autowired 
	
	EitRepository eitRepository;
	
	/**
	 * this method returns the list of all videos,
	 * @return the list of videos
	 */
	
	@RequestMapping(value ="/videos",method=RequestMethod.GET)
	public List<Video> getVideos(){
		return videoRepository.findAll();
	}
	
	/**
	 * this method returns a video by its id 
	 * @param id the video id
	 * @return the list of videos
	 */
	
	@RequestMapping(value ="/video/{id}",method=RequestMethod.GET)
	public Optional<Video> getVideo(@PathVariable Long id){
		return videoRepository.findById(id);
	}
	
	/**
	 * this method save a video in the database
	 * @param video Object
	 * @return the saved video
	 */
	
	@RequestMapping(value ="/videos",method=RequestMethod.POST)
	public Video save(@RequestBody Video v ){
		return videoRepository.save(v);
	}
	
	/**
	 * this method delete a video 
	 * @param video id
	 * @return true in case video has been successfully deleted
	 */
	
	@RequestMapping(value ="/video/{id}",method=RequestMethod.DELETE)
	public List<Eit> delete(@PathVariable Long id ){
		List<Eit> eits = new ArrayList<>();
		Optional<Video> v = videoRepository.findById(id);
		if(v.isPresent()) {
			eits = eitRepository.findByVideofile(v.get().getFilename());
			for (Eit eit : eits) {
				eitRepository.delete(eit);
			}
		}
		videoRepository.deleteById(id);
		return eits;
	}
	
	/**
	 * this method update a video in the database
	 * @param video id
	 * @param video Object
	 * @return the updated video
	 */
	
	@RequestMapping(value ="/video/{id}",method=RequestMethod.PUT)
	public Video save(@PathVariable Long id , @RequestBody Video v ){
		v.setIdvideo(id);
		return videoRepository.save(v);
	}
	
	@RequestMapping(value ="/getVideosInfo",method=RequestMethod.GET)
	public List<Video> getVideosinfo(){
		List <Video> listVideo = new ArrayList<>();
		listVideo = videoRepository.getVideosInfo();
		
		listVideo.remove("description");
		return listVideo;
	}
	
	
	@RequestMapping(value="/uploadVideo" , method = RequestMethod.POST)
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			storageService.store(file);
			//Files.add(file.getOriginalFilename());
 
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
	
	
	
}
