package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  基于TCP协议的Socket通信，实现用户登录，服务端：
 *      ① 创建ServerSocket对象，绑定监听端口
 *      ② 通过accept()方法监听客户端请求
 *      ③ 连接建立后，通过输入流读取客户端发送的请求信息
 *      ④ 通过输出流向客户端发送乡音信息
 *      ⑤ 关闭相关资源
 */
public class ServerSocketDemo {

    public static void main(String[] args) throws Exception{
        //1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        ServerSocket serverSocket =new ServerSocket(10086);//1024-65535的某个端口
        //2、调用accept()方法开始监听，等待客户端的连接
        Socket socket = serverSocket.accept();
        //3、获取输入流，并读取客户端信息
        InputStream is= null;
        InputStreamReader isr = null;
        BufferedReader br= null;

        String info =null;
        while(true){
            is = socket.getInputStream();
            isr =new InputStreamReader(is);
            br =new BufferedReader(isr);
            while((info=br.readLine())!=null){
                System.out.println("我是服务器，客户端说："+info);
            }
            socket.shutdownInput();//关闭输入流
            //4、获取输出流，响应客户端的请求
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write(info+":欢迎您！");
            pw.flush();


            //5、关闭资源
//            pw.close();
//            os.close();
//            br.close();
//            isr.close();
//            is.close();

            //socket.close();
            //serverSocket.close();.close();
        }

    }
}
