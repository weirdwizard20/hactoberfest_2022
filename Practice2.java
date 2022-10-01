import java.util.*;
public class Practice2
{
    public static void main (String args[])
    {
        Scanner sc = new Scanner (System.in);
        String arr[] = new String[5];
        System.out.println("Enter The Names: ");
        for (int i=0; i<arr.length; i++)
        {
            arr[i] = sc.nextLine();
        }
        for (int j=0; j<arr.length; j++)
        {
            System.out.print(arr[j]+" ");
        }

    }
}
