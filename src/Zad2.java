
import java.io.*;

public class Zad2 {

    public static void main(String[] args){

        File zip = new File("D:\\�����\\OOP\\����� 2 �������\\� � 2\\movies.zip");
        try {
            DataInputStream dis1 = new DataInputStream(new FileInputStream(zip));
            byte[] arr1 = new byte[10];
            dis1.skipBytes(30);
            dis1.read(arr1);
            String name = new String(arr1);
            System.out.println("1.��� ����� � ������ - "+name);

            DataInputStream dis2 = new DataInputStream(new FileInputStream(zip));
            dis2.skipBytes(4);
            byte[] arr2 = new byte[2];
            dis2.read(arr2);
            //Short version = Short.reverseBytes(dis2.readShort());       
            System.out.println("2.������ ���������� - "+(double)arr2[0]/10);//������ ���� - ������ ����������
            System.out.println("����-������� �� ������� �������� ���������� - "+arr2[1] + " - UNIX"); //������� ����
            DataInputStream dis3 = new DataInputStream(new FileInputStream(zip));             
            dis3.skipBytes(18);
             int size1 = Integer.reverseBytes(dis3.readInt());
             int size2 = Integer.reverseBytes(dis3.readInt());
            System.out.println("3.������ ������ - "+size1+" bytes");
            System.out.println("4.�������� ������ - "+size2+" bytes");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
