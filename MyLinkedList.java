class MyLinkedList <E> {
  class Node{
 private E data;
 private Node next,prev;
 public Node(Node prev2, E number, Node next2){
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

}
