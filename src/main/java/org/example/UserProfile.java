package org.example;
import java.util.ArrayList;
import java.util.List;
public class UserProfile {
	private String FirstName  , LastName ;
	private int age , id;
	public UserProfile(int id , String FirstName , String LastName , int age)
	{
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.age = age;

	}
	public void SetFirstName(String FirstName)
	{
		this.FirstName = FirstName;
	}
	public String GetFirstName(){
		return FirstName;
	}
	public void SetLastName( String LastName)
	{
		this.LastName = LastName;
	}
	public String GetLastName(){
		return LastName;
	}
	public void SetAge(int age)
	{
		this.age = age;
	}
	public int GetAge()
	{
		return age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
