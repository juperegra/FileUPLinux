package interfazGrafica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
// como sacar la direccion ip
public class prueba {
	public static void main(String[] args) {
		//InetAddress ip;
        //String hostname;
        try (Socket s= new Socket("localhost", 40400)){
//            ip = InetAddress.getLocalHost();
//            hostname = ip.getHostName();
//            System.out.println("Your current IP address : " + ip);
//            System.out.println("Your current Hostname : " + hostname);
//            byte[] b=ip.getAddress();
//            for(int i=0;i<b.length;i++) {
//            	System.out.println(b[i]);
//            }
            
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            DataInputStream in= new DataInputStream(s.getInputStream());
            String mensaje="hola";
            System.out.println(mensaje);
            out.write(mensaje.getBytes());
            System.out.println("1");
            String men=in.readLine();
            System.out.println("2");
            System.out.println(men);
            System.out.println("3");
            
        } catch (IOException e) {
 
            e.printStackTrace();
        }
	}
}
