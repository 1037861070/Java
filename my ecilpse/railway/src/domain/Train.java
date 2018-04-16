package domain;

import java.util.Date;

public class Train {
	private int trainId;
	private Date departure;
	private String trainNumber;
	private String route;
	private String startStation;
	private String terminalStation;
	private int hardSeat;
	private int hardBed;
	private int softBed;
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	public String getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getTerminalStation() {
		return terminalStation;
	}
	public void setTerminalStation(String terminalStation) {
		this.terminalStation = terminalStation;
	}
	public int getHardSeat() {
		return hardSeat;
	}
	public void setHardSeat(int hardSeat) {
		this.hardSeat = hardSeat;
	}
	public int getHardBed() {
		return hardBed;
	}
	public void setHardBed(int hardBed) {
		this.hardBed = hardBed;
	}
	public int getSoftBed() {
		return softBed;
	}
	public void setSoftBed(int softBed) {
		this.softBed = softBed;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	private String vehicle;
}
