package com.metacube.parkingSystem.models;

import javax.validation.constraints.NotBlank;

public class VehicleModel {
	
	@Override
	public String toString() {
		return "VehicleCommands [vehname=" + vehname + ", vehtype=" + vehtype + ", vehno=" + vehno + "]";
	}
	
	private int vid=0;
	
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	@NotBlank
	private String vehname;
	@NotBlank
	private String vehtype;
	@NotBlank
	private String vehno;
	public String getVehname() {
		return vehname;
	}
	public void setVehname(String vehname) {
		this.vehname = vehname;
	}
	public String getVehtype() {
		return vehtype;
	}
	public void setVehtype(String vehtype) {
		this.vehtype = vehtype;
	}
	public String getVehno() {
		return vehno;
	}
	public void setVehno(String vehno) {
		this.vehno = vehno;
	}

}
