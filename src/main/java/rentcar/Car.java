package rentcar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Car {
	@Id
	private int carId;
	private String carName;
	private String carModel;
	private int carNumber;
	private String carOwner;
	private String status="registered";
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarOwner() {
		return carOwner;
	}
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Car(int carId, String carName, String carModel, int carNumber, String carOwner) {
		
		this.carId = carId;
		this.carName = carName;
		this.carModel = carModel;
		this.carNumber = carNumber;
		this.carOwner = carOwner;
	}
	public Car() {
		
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + ", carModel=" + carModel + ", carNumber=" + carNumber
				+ ", carOwner=" + carOwner + ", status=" + status + "]";
	}
	

}