
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class server {
	public JLabel la1= new JLabel("SERVER    ");
	public JLabel la2= new JLabel("Received File         ");
	public JLabel la3= new JLabel("File Size              :    ");
	public JLabel la4= new JLabel("Source IPAddress  :    ");
	public JTextArea t1= new JTextArea("");
	public JTextField c1= new JTextField("");
	public JTextField c2= new JTextField("");
	public Font l=  new Font ("Times New roman" , Font.BOLD, 18);
	public JScrollPane sc=new JScrollPane();
	public Font l1=  new Font ("Times New roman" , Font.BOLD, 30 );
	public JFrame jf;
	public Container c;
	server()
	{
		jf = new JFrame("Server");
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(1024,736);
		c.setBackground( new Color(236,216,234));
		la1.setBounds(430, 50, 200, 35);
		la2.setBounds(150, 200, 200, 35);
		la4.setBounds(150, 130, 200, 50);
		//t1.setBounds(150, 250, 400, 250);
		la3.setBounds(150, 550, 200, 35);
		c1.setBounds(320, 550, 150, 35);
		c2.setBounds(340, 140, 150, 35);
		c1.setForeground(new Color(30,30,98));
		c1.setFont(l);
		
		sc.setBounds(100,300,300,200);
		t1.setColumns(20);
		t1.setRows(10);
		t1.setForeground(new Color(160,35,163));
		t1.setFont(l);
		
		
		sc.setViewportView(t1);
		c.add(la1);
		c.add(la2);
		c.add(la3);
		//c.add(la4);
		c.add(sc);
		c.add(c1);
		//c.add(c2);
		la1.setFont(l1);
		la2.setFont(l);
		la3.setFont(l);
		la4.setFont(l);
		jf.show();
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent win) {
				System.exit(0);
			}
		});
		
		 int[] ports = new int[] { 5000 };

			for (int i = 0; i < 1; i++) {
				Thread t = new Thread(new PortListener(ports[i]));
				t.setName("Listener-" + ports[i]);
				t.start();

			}    
		
	
	}
	
 public static void main (String args[])
 {
	 new server();
	 
 }
 
 
 
 
 
 
 class PortListener implements Runnable {
		
		BufferedOutputStream bos = null;
		
		ServerSocket server;
		Socket connection;
		BufferedReader br = null;
		int port;

		public PortListener(int port) {
			this.port = port;
		}

		public void run() {
			
			try { 
			
				    server = new ServerSocket(5000);
					
				     while (true)
				   {
					                   connection = server.accept();
					
					                   br = new BufferedReader(
							           new InputStreamReader(new BufferedInputStream(
									   connection.getInputStream())));
					
					                      String strLine;
					                    
					                   StringBuffer buffer = new StringBuffer();
					                   System.out.println("hi");
					                   while ((strLine = br.readLine()) != null)
					                  {
						                 
						                   System.out.println(strLine);
						                   buffer.append(strLine + "\n");

					                   }
				                               	br.close();
					                            connection.close();
					                           
					                         t1.setText(buffer.toString());
					                         
					                         String filelen=buffer.toString();
					 					    int len=filelen.length();
					 					    String a=Integer.toString(len);
					 					    c1.setText(a);
					 					       
					                         
	  					    
					
					          				        }
			  }       
			           catch (IOException e)
			            {
			        	   
			             }   
			           finally
			           {
			        	   
			            }
			
		} 

}

 
 
 
 
}
