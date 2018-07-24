package com.neosoft.streamManagerWeb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.neosoft.streamManagerWeb.entities.Eit;




public interface EitRepository extends JpaRepository<Eit, Long> {
	
	List<Eit> findByVideofile(String videofile);

}
