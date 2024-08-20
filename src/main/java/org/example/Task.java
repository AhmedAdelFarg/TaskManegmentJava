package org.example;

import java.time.LocalDate;

public class Task {
	private int id;
	private String description;
	private LocalDate from_date;
	private LocalDate  to_date;
	private Status status;
	private int  category_id;
	private int userProfile_id;
	private String category_name;
	public Task(int id , String description, LocalDate  from_date , LocalDate  to_date , Status status  , int category_id , int userProfile_id , String category_name)
	{
		this.id = id;
		this.description = description;
		this.from_date = from_date;
		this.to_date = to_date;
		this.category_id = category_id;
		this.status = status;
		this.userProfile_id=userProfile_id;
		this.category_name = category_name;;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate  getFrom_date() {
		return from_date;
	}
	public void setFrom(LocalDate  from_date) {
		this.from_date = from_date;
	}
	public LocalDate  getto_date() {
		return to_date;
	}
	public void setto_date(LocalDate  to) {
		this.to_date = to;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getUserProfile_id() {
		return userProfile_id;
	}
	public void setuserProfile_id(int userProfile_id) {
		this.userProfile_id = userProfile_id;
	}

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
