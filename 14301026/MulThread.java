import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

//author:14301026������
//�ͻ��˿���ѭ�����룬������endʱ�������룬�Ƿ��˳��ͻ����п����׳�Reset�쳣����������end�ķ����˳�~

public class MulThread extends Thread{

	  public Socket socket = null;
	  
	  //������
	  public MulThread(Socket socket){
		  this.socket=socket;
	  }

	  public void run(){
		  		  
		  try{
			  		  
			  BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));   //��ȡ�����
			  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));  //��ȡ������
		      
		      String info = "";
		      String result = "";		   
		     		   
		      boolean flag=true;		      
		      while(flag){   //��ѭ����ȡ�ͻ�����Ϣ
		        info=br.readLine();
		     	
		        if(info!=null){
		             
		          StringBuffer sb = new StringBuffer(info); //�������
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
