package vectors;

public class LinkedListVector implements Vector {

    private LinkedList elements;

    public LinkedListVector() {
        elements = new LinkedList();
    }

    @Override
    public double getElement(int index) {
        if (index < 0 || index >= getSize())
            throw new VectorIndexOutOfBoundsException();
        return elements.get(index);
    }

    @Override
    public void setElement(int index, double value) {
        if (index < 0 || index >= getSize())
            throw new VectorIndexOutOfBoundsException();
        elements.set(index, value);
    }

    @Override
    public int getSize() {
        return elements.size();
    }

    @Override
    public double getNorm() {
        try {
            return Vectors.scalarMult(this, this);
        } catch (IncompatibleVectorSizesException e) {
            e.printStackTrace();
        }
        return -1.0;
    }

    public void add(double value) {
        elements.add(value);
    }

    public void add(int index, double value) {
        elements.add(index, value);
    }

    public double remove(int index) {
        return elements.remove(index);
    }

    private class LinkedList {
        private int size;
        private Node head;

        private LinkedList() {
            this.size = 0;
            this.head = null;
        }

        public void add(double value) {
            add(this.size, value);
        }

        public void add(int index, double value) {
            if (this.head == null) {
                this.head = new Node(value);
                this.head.setNext(this.head);
                this.head.setPrevious(this.head);
            } else {
                if (index == 0) {
                    this.head = new Node(value, this.head, this.head.getPrevious());
                } else {
                    Node current = getNode(index);
                    Node newNode = new Node(value, current, current.getPrevious());
                    current.getPrevious().setNext(newNode);
                    current.setPrevious(newNode);
                }
            }
            this.size++;
        }

        public double get(int index) {
            Node current = getNode(index);
            return current.getValue();
        }

        public double remove(int index) {
            Node del = getNode(index);

            del.getPrevious().setNext(del.getNext());
            del.getNext().setPrevious(del.getPrevious());

            if (del == this.head) {
                head = del.getNext();
            }
            this.size--;
            return del.getValue();
        }

        public void set(int index, double value) {
            getNode(index).setValue(value);
        }

        public int size() {
            return this.size;
        }

        private Node getNode(int index) {
            Node current = this.head;

            while (index > 0) {
                current = current.getNext();
                index--;
            }

            return current;
        }


        private class Node {
            private double value;
            private Node next;
            private Node previous;

            private Node(double value) {
                this(value, null, null);
            }

            private Node(double value, Node next, Node previous) {
                this.value = value;
                this.next = next;
                this.previous = previous;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getPrevious() {
                return previous;
            }

            public void setPrevious(Node previous) {
                this.previous = previous;
            }
        }
    }

    public static void main(String[] args) throws IncompatibleVectorSizesException {
        double[] xdata = {1.0, 2.0, 3.0, 4.0};
        double[] ydata = {5.0, 2.0, 4.0, 1.0};

        LinkedListVector x = new LinkedListVector();
        for (double aXdata : xdata) {
            x.add(aXdata);
        }
        LinkedListVector y = new LinkedListVector();
        for (double aYdata : ydata) {
            y.add(aYdata);
        }

        System.out.println("x = " + vectorToString(x));
        System.out.println("y = " + vectorToString(y));
        System.out.println("x + y = " + vectorToString(Vectors.sum(x, y)));
        System.out.println("10x = " + vectorToString(Vectors.mult(x, 10.0)));
        System.out.println("|x| = " + x.getNorm());
        System.out.println("<x, y> = " + Vectors.scalarMult(x, y));
    }

    private static String vectorToString(Vector vector) {
        String result = "";
        for (int i = 0; i < vector.getSize() - 1; i++) {
            result += vector.getElement(i) + ", ";
        }
        return result + vector.getElement(vector.getSize() - 1);
    }
}
