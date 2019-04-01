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

  public MyLinkedList(){}

  public int size(){
    return length;
  }

  public String toString(){
    String ans = "[";
    Node temp = start;
    while (temp != null){
      ans += temp;
      temp = temp.next();
      if (temp != null) ans += ", ";
    }
    ans += "]";
    return ans;
  }

  public void clear(){
    length = 0;
    start = null;
    end = null;
  }

  public boolean add(E value){
   if (start == null){
     start = new Node(value, null, null);
     end = start;
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

}
