package vectors;

import java.io.*;

public class Vectors {

    public static ArrayVector mult(Vector vector, double n) {
        ArrayVector result = new ArrayVector(vector.getSize());
        for (int i = 0; i < vector.getSize(); i++) {
            result.setElement(i, vector.getElement(i) * n);
        }
        return result;
    }

    public static Vector sum(Vector vector1, Vector vector2) throws IncompatibleVectorSizesException {
        if (vector1.getSize() != vector2.getSize())
            throw new IncompatibleVectorSizesException();
        Vector result = new ArrayVector(vector1.getSize());
        for (int i = 0; i < result.getSize(); i++) {
            result.setElement(i, vector1.getElement(i) + vector2.getElement(i));
        }
        return result;
    }

    public static double scalarMult(Vector vector1, Vector vector2) throws IncompatibleVectorSizesException {
        if (vector1.getSize() != vector2.getSize())
            throw new IncompatibleVectorSizesException();
        double result = 0.0;
        for (int i = 0; i < vector1.getSize(); i++) {
            result += vector1.getElement(i) * vector2.getElement(i);
        }
        return result;
    }

    public static void outputVector(Vector v, OutputStream out) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(out);
        outputStream.writeInt(v.getSize());
        for (int i = 0; i < v.getSize(); i++) {
            outputStream.writeDouble(v.getElement(i));
        }
        outputStream.close();
    }

    public static Vector inputVector(InputStream in) throws IOException {
        DataInputStream inputStream = new DataInputStream(in);
        int length = inputStream.readInt();
        Vector vector = new ArrayVector(length);
        for (int i = 0; i < length; i++) {
            vector.setElement(i, inputStream.readDouble());
        }
        inputStream.close();
        return vector;
    }

    public static void writeVector(Vector v, Writer out) {
        PrintWriter writer = new PrintWriter(out);
        writer.print(v.getSize());
        for (int i = 0; i < v.getSize(); i++) {
            writer.print(' ');
            writer.print(v.getElement(i));
        }
        writer.close();
    }

    public static Vector readVector(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        int length = (int) tokenizer.nval;
        Vector vector = new ArrayVector(length);
        for (int i = 0; i < length; i++) {
            tokenizer.nextToken();
            vector.setElement(i, tokenizer.nval);
        }
        in.close();
        return vector;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Vector vector = new ArrayVector(5);
        vector.setElement(0, 1.2);
        vector.setElement(1, 3.4);
        vector.setElement(2, 5.6);
        vector.setElement(3, 7.8);
        vector.setElement(4, 9.0);

        // Текстовые потоки
        String textFileName = "text.txt";

        printToConsole(vector);

        FileWriter fileWriter = new FileWriter(textFileName);
        Vectors.writeVector(vector, fileWriter);

        FileReader fileReader = new FileReader(textFileName);
        vector = Vectors.readVector(fileReader);

        printToConsole(vector);

        // Байтовые потоки
        String byteFileName = "byte.txt";
        System.out.println();

        printToConsole(vector);

        FileOutputStream fileOutputStream = new FileOutputStream(byteFileName);
        Vectors.outputVector(vector, fileOutputStream);

        FileInputStream fileInputStream = new FileInputStream(byteFileName);
        vector = Vectors.inputVector(fileInputStream);

        printToConsole(vector);


        // --------------------------------------------------
        Vector vector1 = new ArrayVector(5);
        vector1.setElement(0, 1.2);
        vector1.setElement(1, 3.4);
        vector1.setElement(2, 5.6);
        vector1.setElement(3, 7.8);
        vector1.setElement(4, 9.0);

        LinkedListVector vector2 = new LinkedListVector();
        vector2.add(1.2);
        vector2.add(3.4);
        vector2.add(5.6);
        vector2.add(7.8);
        vector2.add(9.0);

        System.out.println("\nДо сериализации:\t");
        printToConsole(vector1);
        printToConsole(vector2);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.txt"));
        out.writeObject(vector1);
        out.writeObject(vector2);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.txt"));
        vector1 = (Vector) in.readObject();
        vector2 = (LinkedListVector) in.readObject();

        System.out.println("После сериализации:\t");
        printToConsole(vector1);
        printToConsole(vector2);
    }

    private static void printToConsole(Vector vector) {
        System.out.print(vector.getSize() + " ");
        for (int i = 0; i < vector.getSize(); i++) {
            System.out.print(vector.getElement(i) + " ");
        }
        System.out.println();
    }
}
