package practice01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(3000);
        System.out.println("ServerSocket created.\nWaiting for connection ...\n\n");

        Socket socket = ss.accept();

        System.out.println("Client connected!\n");

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        Database database = new Database();

        while(true) {

            byte[] buf = new byte[4];
            is.read(buf);

            int index = ((((int)buf[0] & 0xff) << 24) |
                    (((int)buf[1] & 0xff) << 16) |
                    (((int)buf[2] & 0xff) << 8) |
                    (((int)buf[3] & 0xff)));

                    System.out.println("received id : " + index);

            if(index < 1 || index > 10) {
                break;
            }
            else {
                byte[] data = database.getStudent(index).getBytes();
                os.write(data);
            }
        }

    }


}
