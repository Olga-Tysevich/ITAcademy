package inProgress.lesson9;

public class Stack<E> {
    private final ElementList<E> elementList = new ElementList<>();

    public void push(E element) {
        elementList.setElementValue(element);
    }

    public E pop() {
        return elementList.deleteFirst();
    }

    public E max() {
        return elementList.deleteMax();
    }

    private static class ElementList<E> {
        private Element<E> firstElement = null;
        private Element<E> maxElement = null;

        private static class Element<E> {
            private final E value;
            private Element<E> prev;
            private Element<E> next;

            private Element<E> nextMaxElement;

            public Element(E element) {
                this.value = element;
            }

            @Override
            public String toString() {
                return String.valueOf(value);
            }
        }

        private void setElementValue(E element) {
            Element<E> updateFirstElement = new Element<>(element);
            updateFirstElement.next = firstElement;
            firstElement = updateFirstElement;
            if (updateFirstElement.next != null) {
                updateFirstElement.next.prev = firstElement;
            }
            if (maxElement != null) {
                Element<E> updateMax = maxElement;
                if (String.valueOf(element).compareTo(String.valueOf(maxElement.value)) >= 0) {
                    maxElement = updateFirstElement;
                    updateFirstElement.nextMaxElement = updateMax;
                } else {
                    Element<E> checkNextMax = maxElement.nextMaxElement;
                    if (checkNextMax != null) {
                        if (String.valueOf(element).compareTo(String.valueOf(checkNextMax.value)) >= 0) {
                            maxElement.nextMaxElement = firstElement;
                            firstElement.nextMaxElement = checkNextMax;
                        }
                    }
                }
            } else {
                maxElement = updateFirstElement;
            }
        }

        private E deleteFirst() {
            if (firstElement != null) {
                Element<E> returnElement = firstElement;
                firstElement = firstElement.next;
                firstElement.prev = null;
                return returnElement.value;
            } else {
                System.out.println("There are no elements on the stack!");
                return null;
            }
        }

        private E deleteMax() {
            if (firstElement != null) {
                Element<E> returnMax = maxElement;
                maxElement = maxElement.nextMaxElement;
                if (returnMax == firstElement) {
                    firstElement = returnMax.next != null ? returnMax.next : null;
                } else {
                    returnMax.prev.next = returnMax.next;
                    returnMax.next.prev = returnMax.prev;
                }
                return returnMax.value;
            } else {
                System.out.println("There are no elements on the stack!");
                return null;
            }
        }

        @Override
        public String toString() {
            StringBuilder elementList = new StringBuilder();
            Element<E> currentElement = firstElement;
            while (currentElement != null) {
                elementList.append("| ").append(currentElement).append(" |");
                currentElement = currentElement.next;
            }
            return elementList.toString();
        }
    }

    @Override
    public String toString() {
        return "Stack: " + elementList;
    }
}
