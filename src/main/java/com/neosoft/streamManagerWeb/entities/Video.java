package com.neosoft.streamManagerWeb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Video {

	
	private Long idvideo;
	private String filename;
	private String description;
	private boolean color;
	private String resolution;
	private boolean ocs;
	private boolean csa5;
	private String format;
	private String status;
	private boolean enabled;
	private String audio;
	private String subtitle;
	private String pmt;
	


	public Video() {
		super();
	}
	
	public Video( String filename) {
		this.filename = filename;
	}
	
	
	public Video(Long idvideo, String filename) {
		super();
		this.idvideo = idvideo;
		this.filename = filename;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdvideo() {
		return idvideo;
	}


	public void setIdvideo(Long idvideo) {
		this.idvideo = idvideo;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isColor() {
		return color;
	}


	public void setColor(boolean color) {
		this.color = color;
	}


	public String getResolution() {
		return resolution;
	}


	public void setResolution(String resolution) {
		this.resolution = resolution;
	}


	public boolean isOcs() {
		return ocs;
	}


	public void setOcs(boolean ocs) {
		this.ocs = ocs;
	}


	public boolean isCsa5() {
		return csa5;
	}


	public void setCsa5(boolean csa5) {
		this.csa5 = csa5;
	}


	public String getFormat() {
		return format;
	}


	public void setFormat(String format) {
		this.format = format;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getAudio() {
		return audio;
	}


	public void setAudio(String audio) {
		this.audio = audio;
	}


	public String getSubtitle() {
		return subtitle;
	}


	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}


	public String getPmt() {
		return pmt;
	}


	public void setPmt(String pmt) {
		this.pmt = pmt;
	}
	
	
}
