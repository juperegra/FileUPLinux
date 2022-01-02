package interfazGrafica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
// como sacar la direccion ip
public class prueba {
	public static void main(String[] args) {
		//InetAddress ip;
        //String hostname;
        try {
        	Socket s= new Socket("localhost", 40400);
        	DataInputStream in= new DataInputStream(s.getInputStream());
        	DataOutputStream out = new DataOutputStream(s.getOutputStream());
//            ip = InetAddress.getLocalHost();
//            hostname = ip.getHostName();
//            System.out.println("Your current IP address : " + ip);
//            System.out.println("Your current Hostname : " + hostname);
//            byte[] b=ip.getAddress();
//            for(int i=0;i<b.length;i++) {
//            	System.out.println(b[i]);
//            }
            
            
            
        	//BufferedWriter out= new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            //BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            //String men2=in.readLine();
            
            //System.out.println(men2);
            
            String mensaje="hola"+"\n";
            System.out.println(mensaje);
            out.write(mensaje.getBytes());
            out.flush();
            System.out.println("1");
            String men=in.readLine();
            System.out.println(men);
            
            /*while(men.compareTo("")!=0) {
				System.out.println(men);
				
				men=in.readLine();
			}*/
            
            System.out.println("2");
            System.out.println(men);
            System.out.println("3");
            
            in.close();
			out.close();
			s.close();
        } catch (IOException e) {
 
            e.printStackTrace();
        }
	}
}
