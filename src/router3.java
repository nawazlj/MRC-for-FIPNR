
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


public class router3 {

	public JLabel la1= new JLabel("Destination IP  :");
	public JLabel la2= new JLabel("Receive File    ");
	public JLabel la3= new JLabel("File Size       :");
	public JLabel la4= new JLabel("ROUTER C");
	public JLabel la5= new JLabel("Acknowlegment   :");
	public JTextArea t1= new JTextArea("");
	public JTextArea t2= new JTextArea("");
	public JScrollPane sc=new JScrollPane();
	public JTextField c1= new JTextField("");
	public JTextField c2= new JTextField("");
	public JScrollPane sc1=new JScrollPane();
	public Font l = new Font("Times New roman" , Font.BOLD , 18);
	public Font l1 = new Font("Times New roman" , Font.BOLD, 30);
	public JFrame jf;
	public Container c;
	router3()
	{
		jf = new JFrame("Router C");
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(1024,736);
		c.setBackground( new Color(236,216,234));
		la1.setBounds(150,150,150,35);
		c1.setBounds(300,150,150,35);
		la2.setBounds(150,200,150,35);
		//t1.setBounds(150,250,400,240);
		//t2.setBounds(650,250,250,150);
		la3.setBounds(150,530,150,35);
		c2.setBounds(300, 530, 150, 35);
		la4.setBounds(420, 50, 200, 35);
		la5.setBounds(650,200,175,35);
		sc.setBounds(100,300,300,200);
		
		
		t1.setColumns(20);
		t1.setRows(10);
		t1.setForeground(new Color(100,20,10));
		t1.setFont(l);
		sc.setViewportView(t1);
		t2.setColumns(20);
		t2.setRows(10);
		t2.setForeground(Color.RED);
		t2.setFont(l);
		c2.setForeground(new Color(30,30,98));
		c2.setFont(l);
		
		sc1.setViewportView(t2);
		sc1.setBounds(650,250,250,150);
		//c.add(la1);
		c.add(la2);
		//c.add(c1);
		c.add(sc);
		c.add(la3);
		c.add(c2);
		c.add(la4);
		c.add(la5);
		c.add(sc1);
		la1.setFont(l);
		la2.setFont(l);
		la3.setFont(l);
		la4.setFont(l1);
		la5.setFont(l);
		jf.show();
	       jf.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent win) {
					System.exit(0);
				}
			});
	       int[] ports = new int[] { 1002,4001,9001 };

			for (int i = 0; i < 3; i++) {
				Thread t = new Thread(new PortListener(ports[i]));
				t.setName("Listener-" + ports[i]);
				t.start();

			}      
	       
	}
		public static void main (String args[])
		{
			new router3();
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
	   			if(this.port==1002)
	   			{
	   			try { 
	   			
	   				    server = new ServerSocket(1002);
	   					
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
	   									    c2.setText(a);
	   									       
	   					                            
	   					                         byte[] byteArray;			 
		  					                       Socket client = null;
		  					                       
		  					                       
		  					                       
		  					                     try     { 
		  					           			
		  							                  client = new Socket("127.0.0.1", 4002);
		  				   		                  bos = new BufferedOutputStream(client.getOutputStream()); 
		  				   		                      
		  				   		                  
		  				   		                  byteArray =t1.getText().getBytes();
		  				   		                  bos.write(byteArray, 0, byteArray.length);
		  				   		                  bos.flush();
		  				   		                  bos.close();
		  				   		                  client.close();
		  						           }
		  						              
		  						    catch (UnknownHostException e1) 
		  						          {
		  							        
		  							           e1.printStackTrace();
		  						         }
		  						    catch (IOException e1) 
		  						         {}
		  						    
		  						    
		  						   
		  						    finally 
		  						           {}           
		  						  String str="This 'Router C' failure physical problem occured. Therefore this data tranfer using subpath ";
		  						t2.setText(str);               
		  					                       
		  					    try     { 
		  						
		  						                  client = new Socket("127.0.0.1", 2000);
		  			    		                  bos = new BufferedOutputStream(client.getOutputStream()); 
		  			    		                      
		  			    		                  
		  			    		                  byteArray =str.getBytes();
		  			    		                  bos.write(byteArray, 0, byteArray.length);
		  			    		                  bos.flush();
		  			    		                  bos.close();
		  			    		                  client.close();
		  					           }
		  					              
		  					    catch (UnknownHostException e1) 
		  					          {
		  						        
		  						           e1.printStackTrace();
		  					         }
		  					    catch (IOException e1) 
		  					         {}
		  					    
		  					    
		  					   
		  					    finally 
		  					           {}
		  					    
		  					    
		  					    
		  					    
		  					  
		   
		  					    
	   					
	   					          				        }
	   			  }       
	   			           catch (IOException e)
	   			            {
	   			        	   
	   			             }   
	   			           finally
	   			           {
	   			        	   
	   			            }
	   			
	   		} 
	   			
	   			
	   			if(this.port==4001)
	   			{

		   			try { 
		   			
		   				    server = new ServerSocket(4001);
		   					
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
		   									    c2.setText(a);
		   									           
		   									 String str="Data Successfully Transfered ";
					                          t2.setText(str);   
		   					                         
		   					                    //  String str="This 'Router C' failure physical problem occured. Therefore this data tranfer using subpath ";
	 					                                  
		   					                            
		   					                         byte[] byteArray;			 
			  					                       Socket client = null;
			  					    try     { 
			  						
			  						                  client = new Socket("127.0.0.1", 5000);
			  			    		                  bos = new BufferedOutputStream(client.getOutputStream()); 
			  			    		                      
			  			    		                  
			  			    		                  byteArray =t1.getText().getBytes();
			  			    		                  bos.write(byteArray, 0, byteArray.length);
			  			    		                  bos.flush();
			  			    		                  bos.close();
			  			    		                  client.close();
			  					           }
			  					              
			  					    catch (UnknownHostException e1) 
			  					          {
			  						        
			  						           e1.printStackTrace();
			  					         }
			  					    catch (IOException e1) 
			  					         {}
			  					    
			  					    
			  					   
			  					    finally 
			  					           {}
			  					    
		   					
		   					          				        }
		   			  }       
		   			           catch (IOException e)
		   			            {
		   			        	   
		   			             }   
		   			           finally
		   			           {
		   			        	   
		   			            }
		   			
		   			
	   			}
	   			
	   			if(this.port==9001)
	   			{


		   			try { 
		   				    server = new ServerSocket(9001);
		   					
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
		   									    c2.setText(a);
		   									       
		   					                            
		   					                         byte[] byteArray;			 
			  					                       Socket client = null;
			  					    try     { 
			  						
			  						                  client = new Socket("127.0.0.1", 5000);
			  			    		                  bos = new BufferedOutputStream(client.getOutputStream()); 
			  			    		                      
			  			    		                  
			  			    		                  byteArray =t1.getText().getBytes();
			  			    		                  bos.write(byteArray, 0, byteArray.length);
			  			    		                  bos.flush();
			  			    		                  bos.close();
			  			    		                  client.close();
			  					           }
			  					              
			  					    catch (UnknownHostException e1) 
			  					          {
			  						        
			  						           e1.printStackTrace();
			  					         }
			  					    catch (IOException e1) 
			  					         {}
			  					    
			  					    
			  					   
			  					    finally 
			  					           {}
			  					    
		   					 
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
	


}
