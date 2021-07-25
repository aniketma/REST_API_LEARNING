package com.practice.DemoRest;
//D:\Executables\apache-tomcat-6.0.53\bin
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AnIkEt
 *
 */
@XmlRootElement
public class Alien
{
private String name;
private int points;
private int id;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPoints() {
	return points;
}
public void setPoints(int points) {
	this.points = points;
}
@Override
public String toString() {
	return "Alien [name=" + name + ", points=" + points + ", id=" + id
			+ ", getId()=" + getId() + ", getName()=" + getName()
			+ ", getPoints()=" + getPoints() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
			+ "]";
}



}
