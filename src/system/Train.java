package system;

public class Train {
	private String tCode, trainName, departPlace;
	private int seat, booked;
	private double departTime;
	public Train() {
		// TODO Auto-generated constructor stub
	}
	public Train(String tCode, String trainName, int seat, int booked, double departTime, String departPlace) {
		super();
		this.tCode = tCode;
		this.trainName = trainName;
		this.departPlace = departPlace;
		this.seat = seat;
		this.booked = booked;
		this.departTime = departTime;
	}
	public String gettCode() {
		return tCode;
	}
	public void settCode(String tCode) {
		this.tCode = tCode;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getDepartPlace() {
		return departPlace;
	}
	public void setDepartPlace(String departPlace) {
		this.departPlace = departPlace;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public int getBooked() {
		return booked;
	}
	public void setBooked(int booked) {
		this.booked = booked;
	}
	public double getDepartTime() {
		return departTime;
	}
	public void setDepartTime(double departTime) {
		this.departTime = departTime;
	}
	public int avaiable_seat() {
		return seat - booked;
	}
	@Override
	public String toString() {
		return String.format("|%-10s|%-20s|%-10d|%-10d|%-10f|%-10s|%-10d|", tCode,trainName,seat,booked,departTime,departPlace,avaiable_seat());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tCode == null) ? 0 : tCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		if (tCode == null) {
			if (other.tCode != null)
				return false;
		} else if (!tCode.equals(other.tCode))
			return false;
		return true;
	}
	
	

}
