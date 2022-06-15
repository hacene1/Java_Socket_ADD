import java.net.*;
import java.io.*;
import java.lang.*;
public class server {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ServerSocket server_socket = new ServerSocket(2234);
		while(true) {
			Socket Listen_socket=server_socket.accept();
			System.out.println("Srever Started...");
			String str1=" ";
			String[] temp;
			String del="#";
			BufferedReader user_input = new BufferedReader(new InputStreamReader(Listen_socket.getInputStream()));
			DataOutputStream server_output= new DataOutputStream(Listen_socket.getOutputStream());
			str1=user_input.readLine();
			double sum=0.0;
			temp=str1.split(del);
			for(int i=0;i<temp.length;i++) {
				float num=Float.parseFloat(temp[i]);
				sum=sum+num;
			}
			String str2=sum+"\n";
			server_output.writeBytes(str2);
			System.out.println("Sending output...");
		}
	}

}
