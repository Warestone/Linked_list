public class Node<E> {
    private E element;
    private Node<E> nextNode;
    private Node<E> previous;

    public Node(E element, Node<E> previous, Node<E> nextNode) {
        setElement(element);
        setNextNode(nextNode);
        setPrevious(previous);
    }
    public void setElement(E element) { this.element = element; }
    public void setNextNode(Node<E> nextNode) { this.nextNode = nextNode; }
    public void setPrevious(Node<E> previous) { this.previous = previous; }

    public Node<E> getPrevious() { return previous; }
    public E getElement() { return element; }
    public Node<E> getNextNode() { return nextNode; }

    public void clearNode(){
        element = null;
        nextNode = null;
        previous = null;
    }
}
