
/**
 * 3.	Write a Java class Clock for dealing with the day time represented by hours,
 * minutes, and seconds. Your class must have the following features:
•	Three instance variables for the hours (range 0 - 23), minutes (range 0 - 59),
 and seconds (range 0 - 59).
•	Three constructors:
o	default (with no parameters passed; is should initialize the 
represented time to 12:0:0)
o	a constructor with three parameters: hours, minutes, and seconds.
o	a constructor with one parameter: the value of time in seconds since 
midnight (it should be converted into the time value in hours, minutes, and seconds)

•	Instance methods:
o	a set-method method setClock() with one parameter seconds since midnight 
(to be converted into the time value in hours, minutes, and seconds as above).
o	get-methods getHours(), getMinutes(), getSeconds() with no parameters that
 return the corresponding values.
o	set-methods setHours(), setMinutes(), setSeconds() with one parameter each 
that set up the corresponding instance variables.
o	method tick() with no parameters that increments the time stored in a Clock 
object by one second.
o	method addClock() accepting an object of type Clock as a parameter.
 The method should add the time represented by the parameter class to the time 
 represented in the current class.
o	Add an instance method toString() with no parameters to your class.
 toString() must return a String representation of the Clock object in the
 form "(hh:mm:ss)", for example "(03:02:34)".
o	Add an instance method tickDown() which decrements the time stored in a
 Clock object by one second.
o	Add an instance method subtractClock() that takes one Clock parameter and 
returns the difference between the time represented in the current Clock object
 and the one represented by the Clock parameter. Difference of time should be 
 returned as an clock object.
Write a separate class ClockDemo with a main() method. The program should:
•	instantiate a Clock object firstClock using one integer seconds since 
midnight obtained from the keyboard.
•	tick the clock ten times by applying its tick() method and print out the
 time after each tick.
•	Extend your code by appending to it instructions instantiating a Clock
 object  secondClock by using three integers (hours, minutes, seconds) read from
 the keyboard.
•	Then tick the clock ten times, printing the time after each tick.
•	Add the secondClock time in firstClock by calling method addClock.
•	Print both clock objects calling toString method
Create a reference thirdClock that should reference to object of difference
 of firstClock and secondClock by calling the method subtractClock().

 * 
 * @author (me😊) 
 * @version (a version number or a date)
 */
class Clock{
    int hours;
    int minutes;
    int seconds;
    
    Clock(){
        this.hours = 12;
        this.minutes = 0;
        this.seconds = 0;
    }
    Clock(int seconds){
        this.hours = seconds / (60 * 60);
        this.minutes = (seconds - (this.hours * 60 *60)) / 60;
        this.seconds = (seconds - (this.hours * 60 *60)) % 60;
    }
    Clock(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    
    void setClock(int seconds){
        this.hours = seconds / (60 * 60);
        this.minutes = (seconds - (this.hours * 60 *60)) / 60;
        this.seconds = (seconds - (this.hours * 60 *60)) % 60;
    }
    
    int getHours(){
        return this.hours;
    }
    int getMinutes(){
        return this.minutes;
    }
    int getSeconds(){
        return this.seconds;
    }
    
    void setHours(int hours){
        this.hours = hours;
    }
    void setMinutes(int minutes){
        this.minutes = minutes;
    }
    void setSeconds(int seconds){
        this.seconds = seconds;
    }
    
    void tick(){
        if(this.seconds == 59){
            if(this.minutes == 59){
                this.hours += 1;
            }
            this.minutes = (this.minutes + 1) % 60;
        }
        this.seconds = (this.seconds + 1) % 60;
    }
    
    void tickDown(){
        if(this.seconds == 0){
            if(this.minutes == 0){
                this.hours -= 1;
            }
            this.minutes = (this.minutes - 1) % 60;
        }
        this.seconds = (this.seconds - 1) % 60;
    }
    
    String toStrings(){
        return (hours+":" +minutes+ ":" +seconds);
    }
    
    void addClock(Clock passedClock){
        int tempSeconds = this.seconds + passedClock.seconds;
        int tempMinutes = this.minutes + passedClock.minutes;
        int tempHours = this.hours + passedClock.hours;
        
        this.seconds = tempSeconds % 60;
        this.minutes = (tempMinutes + (tempSeconds / 60)) % 60;
        this.hours = (tempHours + (tempMinutes / 60)) % 24;
    }
    
    Clock subtractClock(Clock passedClock){
        Clock tempClock = new Clock();
        
        int tempSeconds = this.seconds - passedClock.seconds;
        int tempMinutes = this.minutes - passedClock.minutes;
        if(tempSeconds < 0){
            tempMinutes -= 1;
            tempSeconds += 60;
        }
        int tempHours = this.hours - passedClock.hours;
        if(tempMinutes < 0){
            tempHours -= 1;
            tempMinutes += 60;
        }
        if(tempHours < 0){
            tempHours += 24;
        }
        tempClock.seconds= tempSeconds;
        tempClock.minutes = tempMinutes;
        tempClock.hours = tempHours;
        
        return tempClock;
    }
}

public class TestClock {
   public static void main(String agrs[]){
       
       Clock firstClock = new Clock(58205);//seconds not more than 86,400
       
       System.out.println("Ticking first clock 10 times :");
       for(int i = 0; i < 10; i++){
           firstClock.tick();
           System.out.println(firstClock.toStrings());
       }
       
       Clock secondClock = new Clock(11, 45, 40);
       System.out.println("Ticking second clock 10 times :");
       for(int i = 0; i < 10; i++){
           secondClock.tick();
           System.out.println(secondClock.toStrings());
       }
       
       firstClock.addClock(secondClock);
       System.out.println("After addition of first and second clock :");
       System.out.println("first clock time :  "+ firstClock.toStrings());
       System.out.println("Second clock time : "+  secondClock.toStrings());
       
       Clock thirdClock = firstClock.subtractClock(secondClock);
       System.out.println("After subtraction of first and second clock :");
       System.out.println("first clock time : "+  firstClock.toStrings());
       System.out.println("Second clock time :  "+ secondClock.toStrings());
       System.out.println("Third clock time : "+  thirdClock.toStrings());
   }
}
