import java.util.*;

public class MyStack<T extends Object>
{
	private int size;
	private T[] arr;
	private int top;
	
	@SuppressWarnings("unchecked")
	
	public Stack(int size)
	{
		this.size = size;
		this.arr=(T[]) new Object[size];
		this.top=-1;
	}
	
	public void push(T data)
	{
		if(this.isStackFull())
		{
			System.out.println("Stack is full.");
			return;
		}
		
		System.out.println("Pushing data into the stack : "+data);
		this.arr[++top]=data;
	}
	
	public T pop() 
	{
		if(this.isStackEmpty())
		{
			System.out.println("Stack is Empty.");
			return null;
		}
		T data = this.arr[top--];
		System.out.println("Popping data from the stack : " + data);
		return data;
	}
	
	public boolean isStackFull()
	{
		return (top == size-1);
	}
	
	public boolean isStackEmpty()
	{
		return (top == -1);
	}
	
	public static void main(String args[])
	{
		Stack<Integer> S = new Stack<Integer>(4);
		S.pop();
		S.pop();
		S.push(4);
		S.push(6);
		S.pop();
		S.push(9);
		S.push(3);
		S.push(4);
		S.push(7);
	}
}
