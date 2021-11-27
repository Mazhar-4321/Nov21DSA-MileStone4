import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class Main
{
    public  static boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer,Integer> h= new HashMap<>();
        for(int x : arr)
        {
            if(h.containsKey(x))
            {
                h.put(x,h.get(x)+1);
            }
            else
            {
                h.put(x,1);
            }
        }
        HashSet<Integer> hs= new HashSet<>();
        for(int x:h.values())
        {
            if(hs.contains(x))
            {
                return false;
            }
            hs.add(x);
        }
return true;
    } // 1. unique occurance
    private static int[] twoSum(int[] arr,int k) {
        int arr1[]= new int[2];
       HashMap<Integer,Integer> h = new HashMap<>();
       for(int i=0;i<arr.length;i++)
       {
           if(h.containsKey(k-arr[i]))
           {
               arr1[0]=h.get(k-arr[i]);
               arr1[1]=i;
           }
           else
           {
               h.put(arr[i],i);
           }
       }
       return arr1;
    }
    public static void main(String[] args)
    {
      // Unique Occurance
        System.out.println(  uniqueOccurrences(new int[]{1,2,2,1,1,3}));
      // Two Sum
        for(int x:twoSum(new int[]{2,7,11,15},9))
        {
            System.out.print(x+" ");
        }
      // Jewel and stones
        String stones="aAAbbbb",jewels="aA";
        HashSet<Character> hset=new HashSet<>();
        for(char x: jewels.toCharArray())
        {
            hset.add(x);
        }
        int count=0;
        System.out.println();
        for(char x: stones.toCharArray())
        {
            if(hset.contains(x))
            {
                count++;
            }
        }
        System.out.println(count);
     // subset array
        HashSet<Integer> hashSet= new HashSet<>();
        int arr1[]= new int[]{1,2,3,4,5,6};
        int arr2[]= new int[]{1,2,4};
        for(int x:arr1)
        {
            hashSet.add(x);
        }
        count=0;
        for(int x:arr2)
        {
            if(hashSet.contains(x))
            {
                count++;
            }
        }
        if(count==arr2.length)
        {
            System.out.println(true);
        }
      // Missing elements
int array[] = new int[]{10,12,11,15};
        int low=10,high=15;
        HashSet<Integer> hh= new HashSet<>();
        for(int x:array)
        {
            hh.add(x);
        }
        for(int i=low;i<=high;i++)
        {
            if(!hh.contains(i))
            {
                System.out.print(i+" ");
            }
        }
    }



}
