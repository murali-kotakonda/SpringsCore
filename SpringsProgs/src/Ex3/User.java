package Ex3;

public class User {

	String name;
	String mobileNo;
	String gender;

	public User(String name, String mobileNo, String gender) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", mobileNo=" + mobileNo + ", gender=" + gender + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
