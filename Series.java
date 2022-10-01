import java.util.*;
public class Series
{
    public static void main(String args[])
    {
        int i,n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the limit you want to print the series:");
        n=sc.nextInt();
        
        System.out.println("The series is : ");
        for(i=6;i<=n;i=i+2)
        {
           System.out.print(i+" ");
        }
    }
}