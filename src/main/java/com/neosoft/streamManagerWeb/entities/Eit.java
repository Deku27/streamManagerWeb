package com.neosoft.streamManagerWeb.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Eit {

	
	private Long ideit ;                              
	private int lcn ;                            
	private int usi ;                              
	private String name ;                              
	private String description ;                                                   
	private String user1 ;                             
	private String section_0 ;                             
	private String section_1 ;                           
	private boolean enable ;                              
	private Long eit_ts ;                            
	private String videofile ;
	private String address ;                           
	private int port ;                             
	private int tsid ;                             
	private int sid ;                             
	private int onid ;                              
	private String status ;
	@Column(name="protected")
	private Boolean protect;
	
	private Video video;
	
	public Eit() {
		super();
	}
	
	public Eit(String name, Video v ) {
		this.name = name;
		this.setVideo(v);
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdeit() {
		return ideit;
	}


	public void setIdeit(Long ideit) {
		this.ideit = ideit;
	}
	
	@OneToOne	
    @JoinColumn(name = "videoid")
    public Video getVideo() {
        return video;
    }
	
	public void setVideo(Video video) {
        this.video = video;
    }

	public int getLcn() {
		return lcn;
	}

	public void setLcn(int lcn) {
		this.lcn = lcn;
	}

	public int getUsi() {
		return usi;
	}

	public void setUsi(int usi) {
		this.usi = usi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
	}

	public String getSection_0() {
		return section_0;
	}

	public void setSection_0(String section_0) {
		this.section_0 = section_0;
	}

	public String getSection_1() {
		return section_1;
	}

	public void setSection_1(String section_1) {
		this.section_1 = section_1;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Long getEit_ts() {
		return eit_ts;
	}

	public void setEit_ts(Long eit_ts) {
		this.eit_ts = eit_ts;
	}

	public String getVideofile() {
		return videofile;
	}

	public void setVideofile(String videofile) {
		this.videofile = videofile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getTsid() {
		return tsid;
	}

	public void setTsid(int tsid) {
		this.tsid = tsid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getOnid() {
		return onid;
	}

	public void setOnid(int onid) {
		this.onid = onid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getProtect() {
		return protect;
	}

	public void setProtect(Boolean protect) {
		this.protect = protect;
	}	

}
