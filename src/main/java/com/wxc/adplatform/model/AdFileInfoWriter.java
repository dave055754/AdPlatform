package com.wxc.adplatform.model;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class AdFileInfoWriter {
	private FileOutputStream fos;
	private OutputStreamWriter osw;
	private BufferedWriter writer ;
	private String fileName ;
	private long modifyTime;
	
	
	
	public long getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(long modifyTime) {
		this.modifyTime = modifyTime;
	}
	public FileOutputStream getFos() {
		return fos;
	}
	public void setFos(FileOutputStream fos) {
		this.fos = fos;
	}
	public OutputStreamWriter getOsw() {
		return osw;
	}
	public void setOsw(OutputStreamWriter osw) {
		this.osw = osw;
	}
	public BufferedWriter getWriter() {
		return writer;
	}
	public void setWriter(BufferedWriter writer) {
		this.writer = writer;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
