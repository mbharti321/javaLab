import java.util.*;

class display
{
	void patternArray(int a2[],int l)
	{
		int i,j;
		// just copying content 0f a2 to a1 so that next code wont modify the orignal data
		int a1[] = new int [l];
		for(i=0;i<l;i++)
		{
			a1[i]=a2[i];
		}
		
		for(i=0;i<l;i++)
		{
			if(a1[i]==0)
			{
				// k=i+1;
				// for(j=0;j<l;j++)
				// {
				// 	if((a1[k]%2)!=0)
				// 	{
				// 		if(a1[k]>a1[j])
				// 		{
				// 			a2[i]=a1[k];
				// 		}
				// 	}
				// }
				
				for(j=i+1;j<l;j++)
				{
					if((a1[j]%2)!=0)
					{
						if(a1[i] < a1[j])
						{
							a1[i]=a1[j];
						}
					}
				}
			}
		}
		System.out.println("\nArray is : ");
		for(i=0;i<l;i++)
		{
			System.out.print(a1[i]+ " ");
		}
		System.out.println();
	}
	
	void multiple(int a2[])
	{
	    // just copying content 0f a2 to a so that next code wont modify the orignal data
	    int l = a2.length;
		int a[] = new int [l];
		for(int i=0;i<l;i++)
		{
			a[i]=a2[i];
		}
		
		
		int n=a.length;
// 		outside:
// 		for(i=0;i<n;i++)
// 		{
// 			if(a[i]%5==0)// && a[i++]%5!=0)
// 			{
// 				temp=a[i];
// 				for(int j=i+1; j<n; j++)
// 				{
// 					if(a[j]%5!=0)
// 					a[j] = temp;
// 					else
// 					{
// 					temp=a[j];
// 					continue outside;
// 					}
// 				}
// 			}
// 		}
      
		for(int i=0;i<n;i++)
		{
			if(a[i] % 5 == 0)// && a[i++]%5!=0)
			{
				int temp = a[i];
				for(int j = i+1; j<n; j++)
				{
					if(a[j] % 5 != 0){
					    a[j] = temp;
					    i++;
					}
					else{
					    break;
					}
				}
			}
		}
		
		System.out.println("\nArray is : ");
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+ " ");
		}
		System.out.println();
	}
	
	boolean checkArray( int a[])
	{
		int i,j,k;
		
// 		for(i=0;i<a.length;i++)
// 		{
// 			j=i+1;
// 			if((a[i]+1)==a[j])
// 			{
// 				k=j+1;
// 				if((a[j]+1)==a[k])
// 				{
// 					return true;
// 				}
// 			}	
// 		}
        for(i=0;i<a.length - 2;i++)
		{
			
			if((a[i] +1)==a[i + 1])
			{
				if((a[i + 1] +1)==a[i + 2])
				{
					return true;
				}
			}
		}
			return false;
	}	
}

public class a{
    public static void main(String args[]){
        display dis = new display();
        
		int ch,sz,i;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre the Size of the array: ");
		sz = sc.nextInt();
		int [] arr = new int [sz];
		System.out.println("Enter all the Elements of array : ");
		for(i=0;i<sz;i++)
		{
			arr[i]=sc.nextInt();
		}
		while(true)
		{	
		    System.out.println("Choose any one option given below : ");
    		System.out.println("1. convert 0 to greatest odd number");
    		System.out.println("2. check the multiple of 5 and replace that number with other one till you get the next multiple ");
    		System.out.println("3. check the array contains three increasigly adjacent numbers or not ");
    		System.out.println("4. Exit \n");
    		
    		System.out.println("Entre your choice : ");
    		ch = sc.nextInt();
    		
			switch(ch)
			{
				case 1: dis.patternArray(arr,sz);
    					break;
					
				case 2: dis.multiple(arr);
    					break;
					
				case 3: boolean b;
    					b = dis.checkArray(arr);
    					if(b)
    					{
    						System.out.println("Yes, it contains...");
    					}
    					else
    					{
    						System.out.println("No, it doesn't...");
    					}
    					break;
					
				case 4: System.exit(0);
    					break;
					
				default: System.out.println("Enter a valid option...");
			}
		}
    }
}
	