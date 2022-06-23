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
@Table(name = "USER_INFO")
@DynamicInsert
@DynamicUpdate
public class UserinfoBean {
	@Id
	@ApiModelProperty(hidden = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("ID")
	@Column(name = "ID")
	private Integer id;
	
	@ApiModelProperty(hidden = true)
	@JsonProperty("USERID")
	@Column(name = "USER_ID",unique = true,updatable = false)
	private String userid;
	
	@JsonProperty("USERNAME")
	@Column(name = "USER_NAME")
	private String username;
	
	@JsonProperty("GENDER")
	@Column(name = "GENDER" ,columnDefinition = "ENUM")
	private String gender;
	
	@JsonProperty("USERMAIL")
	@Column(name = "USER_MAIL ",unique = true)
	private String usermail;
	
	@JsonProperty("USERTOKEN")
	@Column(name = "USER_TOKEN", insertable = false)
	private String usertoken;
	
	@JsonProperty("ADDRESS")
	@Column(name = "USER_ADDRESS")
	private String address;
	
	@JsonProperty("USERBIRTHDAY")
	@Column(name = "USER_BIRTHDAY")
	private Date userbirthday;
	
	@JsonProperty("USERPHONE")
	@Column(name = "USER_PHONE")
	private String userphone;
	
	@JsonProperty("PHOTOSTICKERS")
	@Column(name = "PHOTO_STICKERS")
	private String photostickers;
	
	@JsonProperty("USERSTATUS")
	@Column(name = "USER_STATUS",columnDefinition = "ENUM")
	private String userstatus;
	
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getUsertoken() {
		return usertoken;
	}

	public void setUsertoken(String usertoken) {
		this.usertoken = usertoken;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getUserbirthday() {
		return userbirthday;
	}

	public void setUserbirthday(Date userbirthday) {
		this.userbirthday = userbirthday;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getPhotostickers() {
		return photostickers;
	}

	public void setPhotostickers(String photostickers) {
		this.photostickers = photostickers;
	}

	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
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
		return "UserinfoBean [id=" + id + ", userid=" + userid + ", username=" + username + ", gender=" + gender
				+ ", usermail=" + usermail + ", usertoken=" + usertoken + ", address=" + address + ", userbirthday="
				+ userbirthday + ", userphone=" + userphone + ", photostickers=" + photostickers + ", userstatus="
				+ userstatus + ", createid=" + createid + ", createtime=" + createtime + ", reviseid=" + reviseid
				+ ", revisetime=" + revisetime + "]";
	}
	
}
