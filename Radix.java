import java.util.*;
public class Radix{
  public static void radixsort(int[]data){
    int m = max(data);
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];

  }

  public static int max(int[] data){
    int m = Math.abs(data[0]);
    for(int i = 0; i < data.length;i++){
      if(Math.abs(data[i]) > m){
        m = data[i];
      }
    }
    return m;
  }
}
