package Themas;
import java.io.Serializable;
@SuppressWarnings("serial")
public class Theme implements Serializable{
	private String name;
	public Theme() {
	}
	public Theme(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		@Override
	public String toString() {
		return name;
	}
}