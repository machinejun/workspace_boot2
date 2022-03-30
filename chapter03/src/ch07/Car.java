package ch07;

import java.util.Objects;

public class Car {
	
	private String name;
	private int backNumber;
	
	

	public Car(String name, int backNumber) {
		super();
		this.name = name;
		this.backNumber = backNumber;
	}



	@Override
	public String toString() {
		return "Car [name=" + name + ", backNumber=" + backNumber + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return backNumber == other.backNumber && Objects.equals(name, other.name);
	}






//	@Override
//	public boolean equals(Object obj) {
//		if( obj instanceof Car) {
//			Car car = (Car)obj;
//			if(this.name == car.name) {
//				return true;
//			}else {
//				return false;
//			}
//		}else {
//			return false;
//		}
//	}
//	
	
	
	
	

}
