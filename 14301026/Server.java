import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try{
    	    ServerSocket serverSocket =new ServerSocket(3333);
    	    Socket socket =null;
    	    
    	    int sum =0; //�Ѿ�������û�����
    	    System.out.println("�ȴ��ͻ��˽���");   
    	    while(true){//ѭ������
    	    	socket =serverSocket.accept();
    	    	
    	    	MulThread mulThread = new MulThread(socket);
    	    	mulThread.start();
    	    	sum++;
    	    }
       }catch(IOException e){
    	   e.printStackTrace();
       }
	}

}
