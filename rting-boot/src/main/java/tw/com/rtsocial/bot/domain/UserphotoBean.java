package tw.com.rtsocial.bot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "USER_PHOTO")
@DynamicInsert
@DynamicUpdate
public class UserphotoBean {
//	ID	PHOTO_ID	1ALBUM_ID	USER_ID	PHOTO_NAME	PHOTO_DESC	CREATE_ID	CREATE_TIME	REVISE_ID	REVISE_TIME	

	@Id
	@ApiModelProperty(hidden = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("ID")
	@Column(name = "ID")
	private Integer id;
	
	@JsonProperty("PHOTOID")
	@Column(name = "PHOTO_ID",unique = true,updatable = false)
	private String photoid;
	
	@JsonProperty("ALBUMID")
	@Column(name = "ALBUM_ID")
	private String albumid;
	
	@JsonProperty("USERID")
	@Column(name = "USER_ID")
	private String userid;
	
	@JsonProperty("PHOTONAME")
	@Column(name = "PHOTO_NAME")
	private String photoname;
	
	@JsonProperty("PHOTODESC")
	@Column(name = "PHOTO_DESC")
	private String photodesc;
	
	@ApiModelProperty(hidden = true)
	@JsonProperty("CREATEID")
	@Column(name = "CREATE_ID",updatable = false)
	private String createid;
	
	@ApiModelProperty(hidden = true)
	@JsonProperty("CREATENAME")
	@Column(name = "CREATE_TIME",insertable = false,updatable = false)
	private Date createtime;
	
	@ApiModelProperty(hidden = true)
	@JsonProperty("REVISEID")
	@Column(name = "REVISE_ID" ,insertable = false)
	private String reviseid;
	
	@ApiModelProperty(hidden = true)
	@JsonProperty("REVISETIME")
	@Column(name = "REVISE_TIME" ,insertable = false)
	private Date revisetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhotoid() {
		return photoid;
	}

	public void setPhotoid(String photoid) {
		this.photoid = photoid;
	}

	public String getAlbumid() {
		return albumid;
	}

	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPhotoname() {
		return photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getPhotodesc() {
		return photodesc;
	}

	public void setPhotodesc(String photodesc) {
		this.photodesc = photodesc;
	}

	public String getCreateid() {
		return createid;
	}

	public void setCreateid(String createid) {
		this.createid = createid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getReviseid() {
		return reviseid;
	}

	public void setReviseid(String reviseid) {
		this.reviseid = reviseid;
	}

	public Date getRevisetime() {
		return revisetime;
	}

	public void setRevisetime(Date revisetime) {
		this.revisetime = revisetime;
	}

	@Override
	public String toString() {
		return "UserphotoBean [id=" + id + ", photoid=" + photoid + ", albumid=" + albumid + ", userid=" + userid
				+ ", photoname=" + photoname + ", photodesc=" + photodesc + ", createid=" + createid + ", createtime="
				+ createtime + ", reviseid=" + reviseid + ", revisetime=" + revisetime + "]";
	}
	
}
