import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
         
        	 Socket socket = new Socket("localhost",3333);
        	 
        	 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));  //获取输出流
        	 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));     //获取输入流
        	 
        	 String str="";
        	 System.out.println("我是客户端，请输入一行字符串");
        	 Scanner sc = new Scanner(System.in);
        	 str=sc.nextLine();
        	 
        	 boolean flag= true;
        	 while(flag || !str.equals("end")){
               	    	 
        	    bw.write(str+"\n");  
        	    bw.flush();
        		
        	    String info="";       	 
        	    info=br.readLine();
        	    System.out.println(info);
        	        	 	         	         	        	 
        	    Scanner sc2 = new Scanner(System.in);
        	    str=sc2.nextLine();
        	 
        	 }
        	
        	 socket.close();
        	 br.close();
         
	}

	
}
