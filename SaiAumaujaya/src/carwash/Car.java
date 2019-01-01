package carwash;

public class Car {

protected int arrivalTime;
    
	Vehicle v;
    public Car(Vehicle v) { 
    	
    this.v = v;	
    }   
    public Car (int nextArrivalTime)
    {
        arrivalTime = nextArrivalTime;
    }
    
    public int getArrivalTime()
    {
        return arrivalTime;
    }
    
}
