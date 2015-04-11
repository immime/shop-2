
package com.lingxiang2014.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "lx_friend_link")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "lx_friend_link_sequence")
public class FriendLink extends OrderEntity {

	private static final long serialVersionUID = 3019642557500517628L;

	public enum Type {

		text,

		image
	}

	private String name;

	private Type type;

	private String logo;

	private String url;

	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Column(nullable = false)
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Length(max = 200)
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}