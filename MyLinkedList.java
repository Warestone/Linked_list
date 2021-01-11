import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E>{
    private int size;
    private Node<E> head;
    private Node<E> tail;

    @Override
    public void add(E element) {
        if (head == null){
            head = new Node<>(element,null,null);
            tail = head;
        }
        else {
            Node<E> newNode = new Node<>(element, tail,null);
            tail.setNextNode(newNode);
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        Node<E> oldNode = search(index);
        Node<E> previousNode = oldNode.getPrevious();
        Node<E> newNode = new Node<>(element,previousNode,oldNode);
        if (previousNode!=null) previousNode.setNextNode(newNode);
        oldNode.setPrevious(newNode);
        size++;
    }

    @Override
    public void clear() {
        Node<E> oldNode;
        Node<E> newNode = head;
        while (newNode.getNextNode()!=null){
            oldNode = newNode;
            newNode = newNode.getNextNode();
            oldNode.clearNode();
        }
        newNode.clearNode();
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index==size-1)return tail.getElement();
        if (index==0)return head.getElement();
        else return search(index).getElement(); }

    @Override
    public int indexOf(E element) {
        int index = 0;
        for (E founded : this){
            if (founded.equals(element))return index;
            else index++;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index==size-1){
            Node<E>removed = tail;
            tail = tail.getPrevious();
            return removed.getElement();
        }
        if (index==0){
            Node<E>removed = head;
            head = head.getNextNode();
            return removed.getElement();
        }

        Node<E> deletedNode = search(index);
        Node<E> previousNode = deletedNode.getPrevious();
        Node<E> nextNode = deletedNode.getNextNode();
        if (previousNode!=null) previousNode.setNextNode(nextNode);
        if (nextNode!=null) nextNode.setPrevious(previousNode);
        size--;

        E element = deletedNode.getElement();
        deletedNode.clearNode();
        return element;
    }

    @Override
    public E set(int index, E element) {
        if (index==size-1){
            tail.setElement(element);
            return tail.getElement();
        }
        if (index==0){
            head.setElement(element);
            return head.getElement();
        }
        Node<E> replacementElement = search(index);
        replacementElement.setElement(element);
        return replacementElement.getElement();
    }

    @Override
    public int size() { return size; }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] array) {
        E[] result = (E[])java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
        Node<E> temp = head;
        int counter = 0;
        while (temp.getNextNode()!=null){
            result[counter] = temp.getElement();
            counter++;
            temp = temp.getNextNode();
        }
        result[counter] = temp.getElement();
       return result;
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        outputString.append('[');
        boolean firstElement = true;
        for (E element : this) {
            if (!firstElement)outputString.append(',');
            outputString.append(element);
            firstElement = false;
        }
        outputString.append(']');
        String sf = outputString.toString();
        return outputString.toString();
    }

    @Override
    public Iterator<E> iterator() { return new MyLinkedListIterator(); }

    private class MyLinkedListIterator implements Iterator<E>{
        private int counter = 0;
        private Node<E> current = head;

        @Override
        public boolean hasNext() { return counter<size; }

        @Override
        public E next() {
            E result = current.getElement();
            counter++;
            current = current.getNextNode();
            return result;
        }

        @Override
        public void remove() { MyLinkedList.this.remove(counter); }
    }

    private Node<E> search(int index){
        if (index<0 || index>size) throw new ArrayIndexOutOfBoundsException("Index must be >=0 and <= size of collection");
        Node<E> temp = head;
        for (int i=0; i<index; i++) temp = temp.getNextNode();
        return temp;
    }
}
