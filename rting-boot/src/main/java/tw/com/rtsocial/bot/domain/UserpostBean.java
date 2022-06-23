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
@Table(name = "USER_POST")
@DynamicInsert
@DynamicUpdate
public class UserpostBean {
	//ID	POST_ID	USER_ID	POST_PHOTO	POST_DESC	POST_STATUS	CREATE_ID	CREATE_TIME	REVISE_ID	REVISE_TIME	

	@Id
	@ApiModelProperty(hidden = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("ID")
	@Column(name = "ID")
	private Integer id;
	
	@JsonProperty("POSTID")
	@Column(name = "POST_ID" ,unique = true,updatable = false)
	private String postid;
	
	@JsonProperty("USERID")
	@Column(name = "USER_ID")
	private String userid;
	
	@JsonProperty("POSTDESC")
	@Column(name = "POST_DESC")
	private String postdesc;
	
	@JsonProperty("POSTSTATUS")
	@Column(name = "POST_STATUS" ,columnDefinition = "ENUM")
	private String poststatus;

	
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
}
