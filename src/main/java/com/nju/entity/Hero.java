package com.nju.entity;

import java.util.Date;

public class Hero {
	private int hid;
	private String hname;
	private Date hborndate;
	private String imgpath;
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public Date getHborndate() {
		return hborndate;
	}
	public void setHborndate(Date date) {
		this.hborndate = date;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public Hero() {
	}
	public Hero(String hname, Date hborndate) {
		this.hname = hname;
		this.hborndate = hborndate;
	}
	public Hero(int hid, String hname,Date date) {
		this.hid = hid;
		this.hname = hname;
		this.hborndate = date;
	}
	
	public Hero(String hname, Date hborndate, String imgpath) {
		this.hname = hname;
		this.hborndate = hborndate;
		this.imgpath = imgpath;
	}
	public Hero(int hid, String hname, Date hborndate, String imgpath) {
		this.hid = hid;
		this.hname = hname;
		this.hborndate = hborndate;
		this.imgpath = imgpath;
	}
	@Override
	public String toString() {
		return "Hero [hid=" + hid + ", hname=" + hname + ", hborndate=" + hborndate + ", imgpath=" + imgpath + "]";
	}
	

}
