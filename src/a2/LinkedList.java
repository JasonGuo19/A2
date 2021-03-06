package a2;

import java.util.ArrayList;

public class LinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;


    /**
     * Remove the node at index i of the list.
     * Note that the first element is at index 0
     * If i is larger than the size of the list, throw an IndexOutOfBounds Exception
     * <p>
     * ex: list: 1 -> 2 -> 3 -> 4
     * i: 1
     * list after removeAtIndex: 1 -> 3 -> 4
     *
     * @param i - index of node to remove
     */
    public void removeAtIndex(int i) {
        validIndex(i);
        Node current = head, prev = null;
        int j = 0;
        if (i == 0) {
            prev = current;
            current = current.getNext();
            head = current;
            return;
        }
        while (j < i) {
            prev = current;
            current = current.getNext();
            j++;
        }
        prev.setNext(current.getNext());
    }


    /**
     * Compute and return the average of all the numbers in the linked list rounded down to the nearest integer
     *
     * @return an int that is the floor of the mean of the list.
     */
    public int mean() {
        int average = 0;
        int i = 0;
        int[] arr = toArray();
        if (arr.length == 0) {
            return 0;
        }
        while (i < arr.length) {
            int current = arr[i];
            average = average + current;
            i++;
        }
        average = average / arr.length;
        if (average < 0) {
            average = average - 1;
        }
        return average;
    }

    /**
     * Return true if this linked list is equal to the list argument, false otherwise.
     * Two lists are equal if they have the same size, and the same
     * elements in the same order.
     * ex:  list: 1 -> 4 -> 2
     * list2: 1 -> 4 -> 2
     * return: true
     * <p>
     * list: 1 -> 5
     * list2: 2 -> 5
     * return false;
     *
     * @return true if the lists have the same elements in the same order, false otherwise
     */
    public boolean isEqual(LinkedList list2) {
        int[] arr1 = toArray();
        int[] arr2 = list2.toArray();
        if (arr1.length != arr2.length) {
            return false;
        }
        int i = 1;
        while (i < arr1.length) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     * Remove all the nodes at odd indices from the list. Remember that the first Node is at index 0
     * <p>
     * ex: list: 1 -> 3 -> 4 -> 2 -> 8
     * list after removeOdds: 1 -> 4 -> 8
     */
    public void removeOdds() {
        Node current = head;
        int i = 0;
        int [] arr = toArray();
        if(isEmpty()){
            return;
        }
        if(arr.length == 1){
            return;
        }
        if(arr.length == 2){
            remove(1);
        }
        while(i<arr.length){
            if(i%2 != 0) {
                remove(arr[i]);
            }i++;
        }
    }

    /**
     * Return true if the list is symmetrical, false otherwise
     * ex: list: 1 -> 2 -> 3 -> 2 -> 1
     * return: true
     * <p>
     * list: 1 -> 2 -> 3 -> 4 -> 5
     * return: false
     *
     * @return true if the list is symmetrical, false otherwise
     */

    public boolean isSymmetrical() {
        int[] arr = toArray();
        if (arr.length == 0) {
            return true;
        }
        if (arr.length == 1) {
            return true;
        }
        if (arr.length / 2 == 0) {
            return false;
        }
        int i = 0;
        int j = arr.length;
        while (i < arr.length / 2) {
            if (arr[i] != arr[j - 1]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    /**
     * Stretch the list so that each element in the list is represented factor times
     * If the factor is 0 the list should be cleared (have 0 nodes)
     * ex: list: 1 -> 2 -> 3
     * factor: 3
     * list after multiply: 1 -> 1 -> 1 -> 2 -> 2 -> 2 -> 3 -> 3 -> 3
     *
     * @param factor the amount to multiply the number of occurrences of each element by
     */
    public void multiply(int factor) {
        Node current = head, prev = null;
        if(factor == 0){
            clear();
        }
        if(factor == 1){
            return;
        }
        ArrayList<Integer> arr1 = new ArrayList<>();
        int[] arr = toArray();
        int k = arr.length;
        for(int i=0;i<k;i++) {
            for (int j = 0; j < factor; j++) {
                prev = current;
                arr1.add(prev.getValue());
            }
            if (current.hasNext()) {
                current = current.getNext();
            }
        }
    }
    /**
     * Reverse the list
     * <p>
     * ex list:  10 -> 9 -> 8 -> 7
     * list after reverse: 7 -> 8 -> 9 -> 10
     */
    public void reverse() {
        Node current = head;
        if (size == 0) {
            return;
        }
        if (size == 1) {
            return;
        }
        int i = 0;
        int[] arr = toArray();
        int j = arr.length -1;
        head.setValue(arr[j]);
        while (j >= 0) {
            current.setValue(arr[j]);
            head.setNext(current);
            j--;
        }
    }


    /**
     * Given a sorted linked list, remove the duplicate values from the list
     * ex: list: 5 -> 6 -> 7 -> 7 -> 7 -> 8 -> 8 -> 9
     *     list after removeRepeats: 5 -> 6 -> 7 -> 8 -> 9
     *
     */
    public void removeRepeats() {
        Node current = head;
        int i = 0;
        int[] arr = toArray();
        ArrayList<Integer> arr1 = new ArrayList<>();
        for(int j =0; j<arr.length; j++)
            if(arr1.contains(current.getValue())){
                remove(current.getValue());
            }
            arr1.add(current.getValue());
            current = current.getNext();
            if(arr1.contains(current.getValue())){
                remove(current.getValue());
            }
    }

    /**
     * Return true if the list contains a cycle, false otherwise
     * ex: list: 1 -> 2 -> 3 - > 4 --       (4 points to 2)
     *                ^              |
     *                |              |
     *                ---------------
     *      return: true
     *
     *      list: 1 -> 2 -> 3 -> 4
     *      return: false
     *
     * @return true if the list contains a cycle, false otherwise
     */
    public boolean containsCycle() {
        Node current = head, temp = null;
        int[] arr1 = toArray();
        int i =0;
        ArrayList<Node> arr = new ArrayList<>();
        while(i<arr1.length){
            arr.add(current);
            current = current.getNext();
            temp = current;
            if(arr.contains(temp)){
            }return true;
        }
        return false;
    }

    /**
     * Merge the given linked list into the current list. The 2 lists will always be
     * either the same size, or the current list will be longer than list2.
     * The examples below show how to handle each case.
     *
     * Note: Do NOT create and return a new list, merge the second list into the first one.
     *
     * ex: list: 1 -> 2 -> 3
     *     list2: 4 -> 5 -> 6
     *     return: 1 -> 4 -> 2 -> 5 -> 3 -> 6
     *
     *     list: 1 -> 2 -> 3 -> 4
     *     list2: 5 -> 6
     *     return 1 -> 5 -> 2 -> 6 -> 3 -> 4
     *
     * @param list2
     */
    public void merge(LinkedList list2) {
        int[] arr = toArray();
        int[] arr1 = list2.toArray();
        int i = arr.length;
        int j = arr1.length;
        int q = i + j;
        Node current = head, current1 = list2.head;
        if (i == j) { ArrayList<Integer> arr2= new ArrayList();
            for (int k = 0; k < i; k++) {
                arr2.add(current.getValue());
                current = current.getNext();
                arr2.add(current1.getValue());
                current1 = current1.getNext();
            }
        }
    }

    /* Implementation given to you. Do not modify below this. */

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /*
    Returns true if the list contains a node whose value matches the element parameter, false otherwise
     */
    public boolean contains(int element) {
        Node current = head;
        while(current != null) {
            if(current.getValue() == element) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /*
    converts the linked list into an array
     */
    public int[] toArray() {
        int[] arr =  new int[size()];
        Node current = head;
        int i = 0;
        if(isEmpty()) {
            return arr;
        }
        while(current != null){
            arr[i] = current.getValue();
            current = current.getNext();
            i++;
        }
        return arr;
    }

    /*
    adds a node to the end of the list
     */
    public void add(int element) {
        Node newNode = new NodeImpl(element, null);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }

    }

    /*
    removes the element from the list
     */
    public boolean remove(int element) {
        Node current = head;
        if(isEmpty()) {
            return false;
        }
        if(current.getValue() == element){
            head = head.getNext();
            size--;
            return true;
        }
        while(current.getNext().getValue() != element) {
            current = current.getNext();
            if(current == null) {
                return false;
            }
        }
        if(current.getNext().getNext() == null) {
            tail = current;
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    /*
        returns the value at the index parameter.
     */
    public int get(int index) {
        validIndex(index);
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        return current.getValue();
    }

    /*
    sets the value of the node at index to the element
     */
    public int set(int index, int element) {
        validIndex(index);
        Node current = head;
        int prevValue = 1;
        int i = 0;
        if(index == 0) {
            prevValue = head.getValue();
            head.setValue(element);
        } else {
            while(current != null) {
                if(i == index) {
                    prevValue = current.getValue();
                    current.setValue(element);
                    return prevValue;
                }
                current = current.getNext();
                i++;
            }
        }

        return prevValue;
    }

    /*
    adds a node at the given index with the given element as its value
     */
    public void add(int index, int element) {
        if(index > size) {
            validIndex(index);
        }
        Node current = head;
        int i = 0;
        if(index == 0) {
            if(isEmpty()) {
                add(element);
                return;
            } else {
                Node newNode = new NodeImpl(element, head);
                head = newNode;
                size++;
                return;
            }

        }  else if(index == size) {
            add(element);
            return;
        }
        while(current != null) {
            if(i == (index - 1)) {
                Node temp = current.getNext();
                Node newNode = new NodeImpl(element, temp);
                current.setNext(newNode);
                size++;
                return;
            } else {
                current = current.getNext();
                i++;
            }
        }
    }

    /*
    returns the index of the given element
     */
    public int indexOf(int element) {
        Node current = head;
        int index = 0;
        while(current != null) {
            if(current.getValue() == element) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    /*
    returns the last index of the element
     */
    public int lastIndexOf(int element) {
        Node current = head;
        int index = -1;
        int i = 0;
        while(current != null) {
            if(current.getValue() == element) {
                index = i;
            }
            i++;
            current = current.getNext();
        }
        return index;
    }

    public void validIndex(int i) {
        if(i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public Node getHead() {
        return head;
    }

    /* prints out list */
    public String toString() {
        String list = "";
        Node current = head;
        while(current != null) {
            if(current.getNext() == null)
                list+= current.getValue();
            else
                list += current.getValue() + " -> ";
            current = current.getNext();
        }
        return list;
    }
}