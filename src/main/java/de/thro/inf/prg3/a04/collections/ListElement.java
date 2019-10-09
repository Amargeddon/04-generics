package de.thro.inf.prg3.a04.collections;

public class ListElement<T> {
    private T item;
    private ListElement<T>next;


    public T getitem(){
        return item;
    }
    public ListElement<T> getNext(){
        return next;
    }


    public void setNext(ListElement<T>e){
        this.next=e.next;
    }

}
