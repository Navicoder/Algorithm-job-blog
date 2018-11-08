package socket.B_mutiToOne;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * ---------------------
 *         作者：雪不化花不开
 *         来源：CSDN
 *         原文：https://blog.csdn.net/u011671986/article/details/70195230
 *         版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class MyClient2 {
    static Socket server;
    public static void main(String[] args)throws Exception{
        server=new Socket(InetAddress.getLocalHost(),5678);

        BufferedReader in=new BufferedReader(new InputStreamReader(server.getInputStream()));

        PrintWriter out=new PrintWriter(server.getOutputStream());

        BufferedReader wt=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str=wt.readLine();
            out.println(str);
            out.flush();
            if(str.equals("end")){
                break;
            }
            System.out.println(in.readLine());
        }

        server.close();

    }

}



