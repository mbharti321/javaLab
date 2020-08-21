import java.io.*;
import java.util.*;
import java.lang.String;
interface myinterface
{
	public String LnCommonPrefix(String []str);
	public int givesamosa(int ratings[]);
}

class myclassinterface impements myinterface
{
	static StringBuffer myString=new StringBuffer();
	
	public int givesamosa(int ratings[])
	{
		int size=ratings.length;
		int prev,next;
		int samoosas=0;
		
		for(int i=0;i<size;i++)
		{
			//assigning one samoosa to the kid
			samoosas+=1;
			prev=i-1;
			next=i+1;
			
			if(prev >= 0)
			{
				if(ratings[prev]<ratings[i])
				{
				   samoosas++;
				}
			}
			if(next<size)
			{
				if(ratings[next]<ratings[i])
				{
					samoosas++;
				}
			}
			
		}
		return samoosas; //return total samoosas
	}
	
	
	
	public String LnCommonPrefix(String []str)
	{
	
	    String common;
		int size=str.length;
		int length1,length2;
        myString=new StringBuffer(str[0]);
        int a;
        
		for(int i=1;i<size;i++)
		{
			
			length1=str[i].length();
			length2=myString.length();
			a=0;
		    common="";
			while( a < length1  && a < length2)
			{
				if( str[i].charAt(a) == myString.charAt(a) )
			    {
			    	common+= str[i].charAt(a);
			    }
			    else
			    {
			    	break;
			    }
			    a++;
			}
			
			myString=new StringBuffer(common);
			
		}
		common=myString.toString();
		return common;
		
	}
	
	
	
	public static void main(String[] args)
	{
		myclassinterface obj=new myclassinterface();
		Scanner sc=new Scanner(System.in);
		//int[] ratings=new ratings();
		int kids;
		int minimum_samoosas;
		String common;
		//String[] names= {"Flight","Flog","Flop"};
		//String[] names={"Aura","Augustin","August","Auga"};
		String[] names={"carlot","caribbean","carliac","cardamon"};
		
		System.out.println("Enter the number of kids you want to give samosa");
		kids=sc.nextInt();
		int[] ratings=new int[kids];
		System.out.println("Enter the ratings of the kids");
		for(int i=0;i<kids;i++)
		{
		  ratings[i]=sc.nextInt();
		}
		
		minimum_samoosas=obj.givesamosa(ratings);
		System.out.println("The minimum number of samosas to be given are "+minimum_samoosas);
	    
		common=obj.LnCommonPrefix(names);
		System.out.println("The longest prefix which is common is "+common);
	}
	
}
