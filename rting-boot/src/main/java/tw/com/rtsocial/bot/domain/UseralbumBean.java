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
@Table(name = "USER_ALBUM")
@DynamicInsert
@DynamicUpdate
public class UseralbumBean {
//	ID	ALBUM_ID	USER_ID	ALBUM_NAME	ALBUM_CATEGORY	ALBUM_STATUS	CREATE_ID	CREATE_TIME	REVISE_ID	REVISE_TIME	
	@Id
	@ApiModelProperty(hidden = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("ID")
	@Column(name = "ID")
	private Integer id;
	
	@JsonProperty("ALBUMID")
	@Column(name = "ALBUM_ID" ,unique = true,updatable = false)
	private String albumid;
	
	@JsonProperty("USERID")
	@Column(name = "USER_ID")
	private String userid;
	
	@JsonProperty("ALBUMNAME")
	@Column(name = "ALBUM_NAME")
	private String albumname;
	
	@JsonProperty("ALBUMCATEGORY")
	@Column(name = "ALBUM_CATEGORY" ,columnDefinition = "ENUM")
	private String albumcategory;
	
	@JsonProperty("ALBUMSTATUS")
	@Column(name = "ALBUM_STATUS" ,columnDefinition = "ENUM")
	private String albumstatus;
	
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

	public String getAlbumname() {
		return albumname;
	}

	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	public String getAlbumcategory() {
		return albumcategory;
	}

	public void setAlbumcategory(String albumcategory) {
		this.albumcategory = albumcategory;
	}

	public String getAlbumstatus() {
		return albumstatus;
	}

	public void setAlbumstatus(String albumstatus) {
		this.albumstatus = albumstatus;
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
		return "UseralbumBean [id=" + id + ", albumid=" + albumid + ", userid=" + userid + ", albumname=" + albumname
				+ ", albumcategory=" + albumcategory + ", albumstatus=" + albumstatus + ", createid=" + createid
				+ ", createtime=" + createtime + ", reviseid=" + reviseid + ", revisetime=" + revisetime + "]";
	}
}
