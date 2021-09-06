package entity;

/**
 * @description:
 * @projectName:spring
 * @see:entity
 * @author:赵冲
 * @createTime:2021/8/4 9:57
 * @version:1.0
 */

public class UserSys {
	private String name;
	private String age;

	public UserSys() {
	}

	public UserSys(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserSys{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				'}';
	}
}
