package loc;

public class Loc {
	private String name;
	private String address;
	private String phone;
	private String distance;

	public Loc() {
		// TODO Auto-generated constructor stub
	}

	public Loc(String name, String address, String phone, String distance) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public void print() {
		System.out.println(name);
		System.out.println(distance);
		System.out.println(phone);
		System.out.println(address);
		System.out.println("-----");
	}
}
