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
        return elementList.findMax();
    }

    private static class ElementList<E> {
        private Element<E> firstElement = null;
        private Element<E> maxElement = null;

        private static class Element<E> {
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
        }

        private void setElementValue(E element) {
            Element<E> newFirstEl = new Element<>(element);
            newFirstEl.next = firstElement;
            firstElement = newFirstEl;

            if (maxElement != null) {
                Element<E> updateMaxEl = maxElement;
                double checkValue = compareValues(element, maxElement.value);

                if (checkValue >= 0) {
                    maxElement = newFirstEl;
                    newFirstEl.nextMaxElement = updateMaxEl;
                } else {
                    Element<E> newNextMax = maxElement.nextMaxElement;

                    if (newNextMax != null) {
                        checkValue = compareValues(element, newNextMax.value);

                        if (checkValue >= 0) {
                            maxElement.nextMaxElement = firstElement;
                            firstElement.nextMaxElement = newNextMax;
                        }

                    }

                }

            } else {
                maxElement = newFirstEl;
            }

        }

        private double compareValues(E currentElement, E comparableElement) {
            double checkValue;
            if (currentElement instanceof String) {
                checkValue = String.valueOf(currentElement).compareTo(String.valueOf(comparableElement));
            } else {
                checkValue = Double.parseDouble(String.valueOf(currentElement)) - Double.parseDouble(String.valueOf(comparableElement));
            }

            return checkValue;
        }

        private E deleteFirst() {
            if (firstElement != null) {
                Element<E> returnElement = firstElement;
                maxElement = firstElement == maxElement ? maxElement.nextMaxElement : maxElement;
                firstElement = firstElement.next;
                if (maxElement != null) {
                    maxElement.nextMaxElement = returnElement == maxElement.nextMaxElement ? returnElement.nextMaxElement : maxElement.nextMaxElement;
                }
                return returnElement.value;
            } else {
                System.out.println("There are no elements on the stack!");
                return null;
            }
        }

        private E findMax() {
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
            while (currentElement != null) {
                elementList.append("| ").append(currentElement).append(" |");
                currentElement = currentElement.next;
            }
            return elementList.toString();
        }

    }

    @Override
    public String toString() {
        return "testCode.Stack: " + elementList;
    }

}
