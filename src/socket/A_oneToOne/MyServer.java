package socket.A_oneToOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *         作者：雪不化花不开
 *         来源：CSDN
 *         原文：https://blog.csdn.net/u011671986/article/details/70195230
 *         版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class MyServer {

    public static void main(String[] args) throws IOException {

        ServerSocket server=new ServerSocket(5678);

        Socket client=server.accept();

        BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));

        PrintWriter out=new PrintWriter(client.getOutputStream());

        while(true){

            String str=in.readLine();

            System.out.println(str);

            out.println("has receive....");

            out.flush();

            if(str.equals("end"))

                break;

        }

        client.close();

    }

}
