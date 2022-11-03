package package01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Student {

    private static final String className = "Student";

    private String name;
    private String address;
    private int age;

    public Student(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public byte[] getBytes() throws IOException {

        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        // 객체 직렬화
        byte[] classNameBytes = className.getBytes();
        byte[] nameBytes = name.getBytes();
        byte[] addressBytes = address.getBytes();

        buf.write((byte)(classNameBytes.length >> 24));
        buf.write((byte)(classNameBytes.length >> 16));
        buf.write((byte)(classNameBytes.length >> 8));
        buf.write((byte)(classNameBytes.length));
        buf.write(classNameBytes);

        buf.write((byte)(nameBytes.length >> 24));
        buf.write((byte)(nameBytes.length >> 16));
        buf.write((byte)(nameBytes.length >> 8));
        buf.write((byte)(nameBytes.length));
        buf.write(nameBytes);

        buf.write((byte)(addressBytes.length >> 24));
        buf.write((byte)(addressBytes.length >> 16));
        buf.write((byte)(addressBytes.length >> 8));
        buf.write((byte)(addressBytes.length));
        buf.write(addressBytes);

        buf.write((byte)(age >> 24));
        buf.write((byte)(age >> 16));
        buf.write((byte)(age >> 8));
        buf.write((byte)(age));

        return buf.toByteArray();

    }

    public static Student bytesToStudent(byte[] bytes) {

        // 역직렬화
        int index = 0;

        int size;

        size = ((((int)bytes[index++] & 0xff) << 24) |
                (((int)bytes[index++] & 0xff) << 16) |
                (((int)bytes[index++] & 0xff) << 8) |
                (((int)bytes[index++] & 0xff)));

        String className = new String(bytes, index, size);
        index += size;

        size = ((((int)bytes[index++] & 0xff) << 24) |
                (((int)bytes[index++] & 0xff) << 16) |
                (((int)bytes[index++] & 0xff) << 8) |
                (((int)bytes[index++] & 0xff)));

        String name = new String(bytes, index, size);
        index += size;

        size = ((((int)bytes[index++] & 0xff) << 24) |
                (((int)bytes[index++] & 0xff) << 16) |
                (((int)bytes[index++] & 0xff) << 8) |
                (((int)bytes[index++] & 0xff)));

        String address = new String(bytes, index, size);
        index += size;

        int age = ((((int)bytes[index++] & 0xff) << 24) |
                (((int)bytes[index++] & 0xff) << 16) |
                (((int)bytes[index++] & 0xff) << 8) |
                (((int)bytes[index++] & 0xff)));


        return new Student(name, address, age);

    }
}

