package lesson9_Collections;

public class Stack<E extends Comparable<E>> {
    private Element<E> firstElement = null;
    private Element<E> maxElement = null;

    private static class Element<E extends Comparable<E>> implements Comparable<E> {
        private final E value;
        private Element<E> next;
        private Element<E> nextMaxElement;

        public Element(E element) {
            this.value = element;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @Override
        public int compareTo(E comparableElement) {
            return value.compareTo(comparableElement);
        }
    }

    public void push(E element) {
        Element<E> newFirstEl = new Element<>(element);
        newFirstEl.next = firstElement;
        firstElement = newFirstEl;

        if (maxElement != null) {

            if (firstElement.compareTo(maxElement.value) >= 0) {
                firstElement.nextMaxElement = maxElement;
                maxElement = firstElement;
            }

        } else {
            maxElement = newFirstEl;
        }

    }

    public E pop() {
        if (firstElement != null) {
            Element<E> returningEl = firstElement;
            maxElement = firstElement == maxElement ? maxElement.nextMaxElement : maxElement;
            firstElement = firstElement.next;

            return returningEl.value;

        } else {
            System.out.println("There are no elements on the stack!");
            return null;
        }
    }

    public E max() {
        if (maxElement != null) {
            return maxElement.value;
        } else {
            System.out.println("There are no elements on the stack!");
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder elementList = new StringBuilder();
        Element<E> currentElement = firstElement;

        System.out.print("Stack: ");
        while (currentElement != null) {
            elementList.append("| ").append(currentElement).append(" |");
            currentElement = currentElement.next;
        }

        return elementList.toString();
    }

}
