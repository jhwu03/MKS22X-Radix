import java.util.*;
class MyLinkedList <E> {
  class Node{
 private E data;
 private Node next,prev;
 public Node(E number, Node prev2, Node next2){
   prev = prev2;
   data = number;
   next = next2;
 }
 public Node next(){
   return next;
 }
 public Node prev(){
   return prev;
 }
 public void setNext(Node other){
   next = other;
 }
 public void setPrev(Node other){
   prev = other;
 }
 public E getData(){
   return data;
 }
 public E setData(E i){
   data = i;
   return data;
 }
 public String toString(){
   return data + "";
 }
}

private int length;
  private Node start,end;

  public MyLinkedList(){
    start = null;
    end = null;
    length = 0;
  }

  public int size(){
    return length;
  }

  public String toString() {
    if( length == 0)
    return "[]";
    String output = "[";
    Node n = start;
    while(n != end) {
      output += n.getData() +", ";
      n = n.next();
    }
    return output + n.getData() + "]";
  }

  public String toStringReverse() {
   if (length == 0)
   return "[]";
   String output = "[";
   Node n = end;
   while( n != start ) {
     output += n.getData() + ", ";
     n = n.prev();
   }
   return output + n.getData() + "]";
 }

  public void clear(){
    length = 0;
    start = null;
    end = null;
  }

  public boolean add(E value){
   if (start == null){
     Node n = new Node(value, null, null);
     start = n;
     end = n;
   }
   else if (end == start){
     end = new Node(value, null, start);
     start.setNext(end);
   }
   else{
     Node temp = new Node(value, null, end);
     end.setNext(temp);
     end = temp;
   }
   length++;
   return true;
 }

 public void add(int index, E value){
    if(index < 0 || index > size()){
       throw new IndexOutOfBoundsException( index + " is out of bounds");
     }
    if(index == size()){
      add(value);
    }else if(index == 0){
      Node temp = new Node(value, start, null);
      start.setPrev(temp);
      start = temp;
      length++;
    }else{
      Node temp = new Node(value, getNthNode(index), getNthNode(index - 1));
      getNthNode(index).setPrev(temp);
      getNthNode(index - 1).setNext(temp);
      length++;
    }
  }

  private Node getNthNode(int index){
    int count = 0;
    Node temp = start;
    while(temp != null){
      if(count == index){
        return temp;
      }
      count++;
      temp = temp.next();
    }
    return null;
  }

  public void extend(MyLinkedList<E> other){
    if (size() == 0){
            start = other.start;
            end = other.end;
            length += other.size();
            other.clear();
          }
          else if (other.size() > 0){
            length += other.size();
            end.setNext(other.start);
            other.start.setPrev(end);
            end = other.end;
            other.clear();
        }
      }

  public E removeFront(){
    if (size() == 0) throw new NoSuchElementException();
      E temp = start.getData();
      if (size() == 1){
        clear();
        return temp;
      }
    start = start.next();
    start.setPrev(null);
    length--;
    return temp;
}


}
