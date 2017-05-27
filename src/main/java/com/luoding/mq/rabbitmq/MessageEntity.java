package com.luoding.mq.rabbitmq;

import java.io.Serializable;
import java.util.Date;

public class MessageEntity implements Serializable{
	
	private String hotelId = "";
	private Date year_month = new Date();
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public Date getYear_month() {
		return year_month;
	}
	public void setYear_month(Date year_month) {
		this.year_month = year_month;
	}
	
	
}
