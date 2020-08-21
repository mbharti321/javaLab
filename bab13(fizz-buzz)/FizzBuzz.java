class fizzbuzz{
	int n;
	public fizzbuzz(int number){
		this.n = number;
	}
	synchronized void fizz(){
		if(n%3==0 && n%15!=0)
			System.out.println("fizz");
			else if(n%5!=0)
			System.out.println(n);
	}
	synchronized void buzz(){
		if(n%5==0 && n%15!=0)
			System.out.println("buzz");
	}
	synchronized void fizzbuzzz(){
		if(n%15==0)
			System.out.println("fizzbuzz");
	}
}
class threadA extends Thread{
	int a;
	public threadA(int m){
		this.a = m;
	}
public void run(){
	fizzbuzz ob1 = new fizzbuzz(a);
		ob1.fizz();
	}
}

class threadB extends Thread{
	int b;
	public threadB(int m){
		this.b = m;
	}
public void run(){
		fizzbuzz ob2 = new fizzbuzz(b);
		ob2.buzz();
	}
}

class threadC extends Thread{
	int c;
		public threadC(int m){
		this.c = m;
	}
public void run(){
	fizzbuzz ob3 = new fizzbuzz(c);
		ob3.fizzbuzzz();
	}
}

public class FizzBuzz{
	public static void main(String args[]){
		for(int i=1;i<=5;i++){
			threadA A = new threadA(i);
			threadB B = new threadB(i);
			threadC C = new threadC(i);
			A.start();
			B.start();
			C.start();
		}
	}
}
