package com.senyer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "senyer.file")
public class GloableFileConfig {
	
	private String path;//文件上传路径
	private String max_upload;//上传允许的文件大小
	
	
	
	
	@Override
	public String toString() {
		return "GloableConfig [path=" + path + ", max_upload=" + max_upload + "]";
	}
	
	
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMax_upload() {
		return max_upload;
	}
	public void setMax_upload(String max_upload) {
		this.max_upload = max_upload;
	}
	
	
	
}
