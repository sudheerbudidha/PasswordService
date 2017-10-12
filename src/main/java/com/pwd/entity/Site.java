package com.pwd.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;


@QueryEntity
@Document(collection = "sites")
public class Site {

	@Id
	private String id;

	private String username;
	private String password;
	private String siteName;

	public Site() {
	}

	public Site(Builder builder) {
		this.username = builder.username;
		this.password = builder.password;
		this.siteName = builder.siteName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public static Builder getBuilder() {
		return new Builder();
	}

	public static class Builder {
		private String username;
		private String password;
		private String siteName;

		private Builder() {
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder siteName(String siteName) {
			this.siteName = siteName;
			return this;
		}

		public Site build() {
			// We can perform any custom validations here.
			return new Site(this);
		}
	}

}
