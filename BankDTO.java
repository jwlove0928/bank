package money;

public class BankDTO {

	private String id;
	private String name;
	private int age;
	private int tel;
	
	@Override
	public String toString() {
		return "BankDTO [id=" + id + ", name=" + name + ", age=" + age + ", tel=" + tel + "]";
	}

	public BankDTO() {
		
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
}
