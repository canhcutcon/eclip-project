package system;

public class Custumer {

	private String ccode, cus_name, phone;

	public Custumer() {
		// TODO Auto-generated constructor stub
	}
	
	public Custumer(String ccode, String cus_name, String phone) {
		super();
		this.ccode = ccode;
		this.cus_name = cus_name;
		this.phone = phone;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return String.format("|%-10s|%-10s|%-10s|", ccode,cus_name,phone);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccode == null) ? 0 : ccode.hashCode());
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
		Custumer other = (Custumer) obj;
		if (ccode == null) {
			if (other.ccode != null)
				return false;
		} else if (!ccode.equals(other.ccode))
			return false;
		return true;
	}
	
	

}
