package carwash;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Carwash {
	int numberOfBays = 0;
	int maxNumbofVehicleCanWash=100;
	int countVehiclesWashed=0;
	int nextDepartureTime=0;
	int currentTime = 0;
	public final static int MAX_SIZE = 5; //Max allowed
	public final static int WASH_TIME = 5; // 5 seconds to wash Vehicle
	 protected Queue<Car> carQueue;  
	 
	public Carwash(int numberOfBays) {
		carQueue = new LinkedList<>();
		
		this.numberOfBays = numberOfBays;
	}
	
	public void addVehicleToQueue(Vehicle v) {
		if (carQueue.size() == MAX_SIZE) 
        {
			
        }else {
        	carQueue.add (new Car (v));
        	countVehiclesWashed++;
        }
	}
	
	public void openCarwash() {
		
	}
	
	public void startWashingVehicles() {
		try {
			nextDepartureTime = currentTime + WASH_TIME; //WASH_TIME;
			if(countVehiclesWashed<=maxNumbofVehicleCanWash) {
				TimeUnit.SECONDS.sleep(WASH_TIME);
			}else {
				System.out.println("Max vehicles already Washed");
				closeCarWash();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void closeCarWash() {
		if (!carQueue.isEmpty())
        {
             Car car = carQueue.remove();
        } 
	}
}

