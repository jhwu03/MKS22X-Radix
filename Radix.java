import java.util.*;
public class Radix{
  public static void radixsort(int[]data){
    int m = max(data);
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for(int i = 0 ; i < buckets.length;i++){
      if(buckets[i] == null){
        buckets[i] = new MyLinkedList<Integer>();
      }
    }
    for( int i = 1; i <= max(data); i++){
      for(int j = 0; j < data.length ; j++){
        int index = getDigit(data[j], i);
          if(data[j] >= 0){
            buckets[index+10].add(data[j]);
          }else{
            buckets[9 - index].add(data[j]);
          }
      }
    int counter = 0;
    for(int j = 0; j < 20; j++){
      int s = buckets[j].size();
      for(int k = 1; k <= s ; k++){
        int temp = buckets[j].removeFront();
        data[counter] = temp;
        counter++;
      }
    }
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
      digit = digit - 1;
    }
    return number % 10;
  }
}
