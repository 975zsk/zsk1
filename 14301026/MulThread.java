import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

//author:14301026张苏坤
//客户端可以循环输入，在输入end时结束输入，非法退出客户端有可能抛出Reset异常，请用输入end的方法退出~

public class MulThread extends Thread{

	  public Socket socket = null;
	  
	  //构造器
	  public MulThread(Socket socket){
		  this.socket=socket;
	  }

	  public void run(){
		  		  
		  try{
			  		  
			  BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));   //获取输出流
			  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));  //获取输入流
		      
		      String info = "";
		      String result = "";		   
		     		   
		      boolean flag=true;		      
		      while(flag){   //可循环读取客户端信息
		        info=br.readLine();
		     	
		        if(info!=null){
		             
		          StringBuffer sb = new StringBuffer(info); //倒序输出
		          result = sb.reverse().toString();
		       	       
			      bw.write(result+"\n");
			      bw.flush();			   
		       }
		    }
		   
		      bw.close();
		      socket.close();
		     
		  }catch(IOException e){		
			  e.printStackTrace();
		  }
	  }

}
