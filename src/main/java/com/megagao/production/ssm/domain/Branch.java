package com.megagao.production.ssm.domain;

public class Branch {
private String id;
private String name;
private String shortname;
@Override
public String toString() {
	return "Branch [id=" + id + ", name=" + name + ", shortname=" + shortname
			+ "]";
}
public Branch(String id, String name, String shortname) {
	super();
	this.id = id;
	this.name = name;
	this.shortname = shortname;
}
public Branch() {
	super();
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getShortname() {
	return shortname;
}
public void setShortname(String shortname) {
	this.shortname = shortname;
}

}
