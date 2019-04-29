import java.util.*;
public class Radix{
public static void radixsort(int[] data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < buckets.length; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    MyLinkedList<Integer> temp = new MyLinkedList<>();
    int max = max(data) + 1;
    int index = 0;
    while (index < max){
      if (index == 0){
        for (int i = 0; i < data.length;i++){
          int digit = data[i] % 10;
          if (digit < 0){
            buckets[9 + digit].add(data[i]);
          }
          else{
            buckets[10 + digit].add(data[i]);
          }
        }
      }else{
        while (temp.size() > 0){
          int value = temp.removeFront();
          int digit = (int)(value / Math.pow(10, index)) % 10;
          if (digit < 0){
            buckets[9 + digit].add(value);
          }
          else{
            buckets[10 + digit].add(value);
          }
        }
      }
      for (int i = 0; i < buckets.length; i++){
        temp.extend(buckets[i]);
      }
      index++;
    }
    for (int i = 0; i < data.length; i++){
      data[i] = temp.removeFront();
    }
  }

  public static int max(int[] data){
    int m = Math.abs(data[0]);
    for(int i = 0; i < data.length;i++){
      if(Math.abs(data[i]) > m){
        m = Math.abs(data[i]);
      }
    }
    return numberOfDigits(m);
  }

  public static int numberOfDigits(int number){
    if(number < 0){
      number = number * -1;
    }
    int digits = 0;
    while(number > 10){
      number = number / 10;
      digits = digits + 1;
    }
    return digits;
  }

  public static int getDigit(int number, int digit){
    if(digit > numberOfDigits(number)){
      return 0;
    }
    if(number < 0){
      number = number * -1;
    }
    while(digit > 1){
      number = number / 10;
      digit--;
    }
    return number % 10;
  }

  public static void main(String[]args){
   System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
   int[]MAX_LIST = {1000000000,500,10};
   for(int MAX : MAX_LIST){
     for(int size = 31250; size < 2000001; size*=2){
       long rtime=0;
       long btime=0;
       //average of 5 sorts.
       for(int trial = 0 ; trial <=5; trial++){
         int []data1 = new int[size];
         int []data2 = new int[size];
         for(int i = 0; i < data1.length; i++){
           data1[i] = (int)(Math.random()*MAX);
           data2[i] = data1[i];
         }
         long t1,t2;
         t1 = System.currentTimeMillis();
         Radix.radixsort(data2);
         t2 = System.currentTimeMillis();
         rtime += t2 - t1;
         t1 = System.currentTimeMillis();
         Arrays.sort(data1);
         t2 = System.currentTimeMillis();
         btime+= t2 - t1;
         if(!Arrays.equals(data1,data2)){
           System.out.println("FAIL TO SORT!");
           System.exit(0);
         }
       }
       System.out.println(size +"\t\t"+MAX+"\t"+1.0*rtime/btime);
     }
     System.out.println();
   }
 }
}
