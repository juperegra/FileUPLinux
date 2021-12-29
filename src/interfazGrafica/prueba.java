package interfazGrafica;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
// como sacar la direccion ip
public class prueba {
	public static void main(String[] args) {
		InetAddress ip;
        String hostname;
        try (Socket s= new Socket("localhost", 40400)){
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
            byte[] b=ip.getAddress();
            for(int i=0;i<b.length;i++) {
            	System.out.println(b[i]);
            }
            
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String mensaje="hola";
            out.write(mensaje.getBytes());
            
        } catch (IOException e) {
 
            e.printStackTrace();
        }
	}
}
