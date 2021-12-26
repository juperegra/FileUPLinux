package interfazGrafica;

import java.net.InetAddress;
import java.net.UnknownHostException;
// como sacar la direccion ip
public class prueba {
	public static void main(String[] args) {
		InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
            byte[] b=ip.getAddress();
            for(int i=0;i<b.length;i++) {
            	System.out.println(b[i]);
            }
        } catch (UnknownHostException e) {
 
            e.printStackTrace();
        }
	}
}
