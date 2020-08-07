import java.io.*;

interface Movable
{
	public void moveUp();
	public void moveDown();
	public void moveLeft();
	public void moveRight();
}

class MovablePoint implements Movable
{
	public int x,y,xSpeed,ySpeed;
	MovablePoint(int x, int y, int xSpeed, int ySpeed)
	{
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
		
	public void moveUp()
	{
		this.y -= ySpeed;
	}
						
	public void moveDown()
	{
		this.y += ySpeed;
	}
			
	public void moveRight()
	{
		this.x += xSpeed;
	}
			
	public void moveLeft()
	{
		this.x -= xSpeed;
	}
							
	public String toString()
	{
		return "[Position] x : " + x + " y : " + y + "\n"
	       + "[Speed] x : " + xSpeed +" y : " + ySpeed;
	}
																											
}

class MovableCircle implements Movable
{
		private int radius;
		private MovablePoint center;
		
		MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius)
		{
			this.radius = radius;
			this.center = new MovablePoint(x,y,xSpeed,ySpeed);
		}
						
		public void moveUp()
		{
			center.moveUp();
		}
											
		public void moveDown()
		{
			center.moveDown();
		}
		
		public void moveRight()
		{
			center.moveRight();
		}
					
		public void moveLeft()
		{
			center.moveLeft();
		}
				
		public String toString()
		{
			return "[Position] x : " + center.x + " y : " + center.y + "\n"
										       + "[Speed] x : " + center.xSpeed +" y : " + center.ySpeed;
		}
}
		
public class test 
{
	public static void main(String[] args)
	{
		MovablePoint m1 = new MovablePoint(5,5,6,10);
		System.out.println(m1);
		m1.moveLeft();
		System.out.println(m1);
		
		MovableCircle m2 = new MovableCircle(2,1,2,-3,20);
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);

	}
		
}
