package com.example.selectionsort;

public class LinkedList {

    private Nodo head;
    private Nodo current, previous;

    public LinkedList(){
        head = current = previous = null;
    }

    public int size(){
        int size = 0;
        Nodo theLink = head;

        while (theLink != null){
            theLink = theLink.getNext();
            size++;
        }
        return size;
    }

    public int search(int key){
        int location = 0;
        if (head == null)
            return -1;
        else {
            current = head;
            while (current != null){
                if (current.getData() == key)
                    return location;
                current = current.getNext();
                location++;
            }
        }
        return -1;
    }

    public void insertFirstLink(int data) {
        Nodo newNodo = new Nodo(data);

        if (head == null)
            head = newNodo;
        else {
            newNodo.setNext(head);
            head = newNodo;
        }
    }

    public void insertLastLink(int data){
        Nodo newNodo = new Nodo(data);

        if (head == null)
            head = newNodo;
        else{
            current = head;
            while (current != null){
                previous = current;
                current = current.getNext();
            }
            previous.setNext(newNodo);
        }
    }

    public int get(int pos){
        Nodo theLink = head;

        for (int  i = 0; i < pos; i++){
            theLink = theLink.getNext();
        }
        return theLink.getData();
    }

    public void overwrite(int pos, int data){
        Nodo theLink = head;
        int i = 0;

        while (i<pos){
            theLink = theLink.getNext();
            i++;
        }
        theLink.setData(data);
    }

    public Object swap(Nodo nod1, Nodo nod2){



        Nodo aux = nod1;
        nod1 = nod2;
        nod2 = aux;

        return 1;
    }
}

class Nodo{
    int data;
    Nodo next;

    public Nodo(int data){
        this.data = data;
        this.next = null;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(Nodo nodo){
        this.next = nodo;
    }

    public Nodo getNext(){
        return next;
    }
}