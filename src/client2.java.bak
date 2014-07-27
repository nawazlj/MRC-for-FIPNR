
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

	import javax.swing.JButton;
import javax.swing.JFileChooser;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
import javax.swing.JTextField;




public class client2 implements ActionListener {
	
	
	String a;
	String b;
	
	public JButton b1= new JButton("Browse");
	public JButton b2= new JButton("Split");
	public JButton b3= new JButton("Send");
	public JLabel la1= new JLabel("Select the file :");
	public JLabel la2= new JLabel("File path         :");
	public JLabel la3= new JLabel("File Size (Bits)   :");
	public JLabel la4= new JLabel("CLIENT 2");
	public JLabel c1= new JLabel();
	public JTextField c2= new JTextField("");
	public JTextArea t2= new JTextArea("");
	public JScrollPane sc=new JScrollPane();
	public JScrollPane sc1=new JScrollPane();
	public JTextArea t1= new JTextArea("");
	public Font l = new Font("Times New roman" , Font.BOLD , 18);
	public Font l1 = new Font("Times New roman" , Font.BOLD, 30);
	public JFrame jf;
	public Container c;
	client2()
	{
		jf = new JFrame("Client2");
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(1024,736);
		c.setBackground( new Color(236,216,234));
		b1.setBounds(300,110,100,35);
		b2.setBounds(700,400,100,35);
		b3.setBounds(375,600,150,50);
		la1.setBounds(100,100,150,50);
		la2.setBounds(100,150,150,50);
		la3.setBounds(100,200,150,50);
		la4.setBounds(420,0,150,50);
		c1.setBounds(300,160,400,35);
		c2.setBounds(300,210,100,35);
		c2.setForeground(new Color(30,70,98));
		c2.setFont(l);
		
		sc1.setBounds(400,300,100,200);
		//b1.setBorderPainted(false);
		sc.setBounds(100,300,300,200);
		t1.setColumns(20);
		t1.setRows(10);
		t1.setForeground(new Color(20,100,100));
		t1.setFont(l);
		sc.setViewportView(t1);
		t2.setBounds(100,300,300,200);
		t2.setColumns(20);
		t2.setRows(10);
		
		sc1.setViewportView(t2);
		c.add(b1);
		c.add(b3);
		c.add(la1);
		c.add(la2);
		c.add(la3);
		c.add(la4);
		c.add(c1);
		c.add(c2);
		 c.add(sc,BorderLayout.CENTER);
		la1.setFont(l);
		la2.setFont(l);
		la3.setFont(l);
		la4.setFont(l1);		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		jf.show();
	       jf.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent win) {
					System.exit(0);
				}
			});
	       
	       int[] ports = new int[] { 3000 };

			for (int i = 0; i < 1; i++) 
			{
				Thread t = new Thread(new PortListener(ports[i]));
				t.setName("Listener-" + ports[i]);
				t.start();

			}    
	       
	       
	       
	}
	       public static void main (String args[])
	       {
	       	new client2();
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
		   				System.out.println("hi i am in try block");
		   			
		   				    server = new ServerSocket(3000);
		   				 System.out.println("hi server established connection");
		   					
		   				     while (true)
		   				   {
		   				    	System.out.println("hi i am in while block");
		   					                   connection = server.accept();
		   					                System.out.println("hi connection to server block hs been estd");
		   					
		   					                   br = new BufferedReader(
		   							           new InputStreamReader(new BufferedInputStream(
		   									   connection.getInputStream())));
		   					                System.out.println("hi i am  reading the input streame");
		   					                      String strLine;
		   					                    
		   					                   StringBuffer buffer = new StringBuffer();
		   					                   System.out.println("hi i am before buffer read");
		   					                   while ((strLine = br.readLine()) != null)
		   					                  {
		   						                 
		   						                   System.out.println(strLine);
		   						                   buffer.append(strLine + "\n");

		   					                   }
		   					                System.out.println(" end of strLine");
		   				                               	br.close();
		   					                            connection.close();
		   					                           
		   					                         t1.setText(buffer.toString());
		   					                     
		   					                         a=buffer.toString();
		   					                      System.out.println("Button a name is"+a);
		   					                          b=a.substring(6,14);
		   					                       System.out.println("Button b name is"+b);
		   					                      
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
		 
	  
		
	       public void actionPerformed(ActionEvent e)
			 {		
			    
			    	BufferedOutputStream bos = null;
			 
			    	
			    	byte[] byteArray;//=str.getBytes();
			    	
			    			    			 
				    String strLine = null;
				//    String newline = "\n";
				    if (e.getSource()== b1)
				    {
		        						
					    
					 JFileChooser chooser = new JFileChooser();
				    			    
				    try {
				        
				        File f = new File(new File("filename.txt").getCanonicalPath());
				    
				        chooser.setSelectedFile(f);
				        }      catch (IOException e1) {
				        }
				    		  
				      chooser.showOpenDialog(b1);
				      int retval = chooser.showOpenDialog(b1);
	                  if (retval == JFileChooser.APPROVE_OPTION){
	                  File field = chooser.getSelectedFile();
	                  c1.setText(field.getAbsolutePath());
	                 }		    
				    
				            File curFile = chooser.getSelectedFile();
				        try{
					    
					        FileInputStream fstream = new FileInputStream(curFile);
					   
					        DataInputStream ins = new DataInputStream(fstream);
					        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
					 
				    		
					        StringBuffer buffer = new StringBuffer();
					    while ((strLine = br.readLine()) != null)   {
					     
					        System.out.println (strLine);
					        buffer.append(strLine+ "\n");
					          
					      
					    }
					       t1.setText(buffer.toString());
					       String filelen=buffer.toString();
						    int len=filelen.length();
						    String a=Integer.toString(len);
						    c2.setText(a);
						       
					       
					    
					    }catch (Exception e1){
					      System.err.println("Error: " + e1.getMessage());
					    }
				    }
				 
					 
				 if(e.getSource()== b3)
				 {
					 //System.out.println("name of e.getSource()="+e.getSource()+" name of button b3 is"+b3);
					 System.out.println("In Button b3 of send button"+b);
					 if(b.equals("Router A"))
					 {
						 System.out.println("In method if");
						 Socket client = null;
						 System.out.println("Client is set to null");
							int Port = 9000;
							System.out.println("port is set to 9000");
																
							try {
								System.out.println("In try block");
								client = new Socket("127.0.0.1", Port);
								//System.out.println(" ");
								
					    		bos = new BufferedOutputStream(client.getOutputStream()); 
					    		
					    		byteArray = t1.getText().getBytes();
					    
					    		bos.write(byteArray, 0, byteArray.length);
					    		bos.flush();
					    		bos.close();
					    		client.close();
							} catch (UnknownHostException e1) {
								
								e1.printStackTrace();
							} catch (Exception e1) {}
								
							finally {}
							 
						
						  
					 }
					 else
					 
					 if(b.equals("Router B"))
					 {

						 Socket client = null;
	   					    
							int Port = 9001;
															
							try {
								client = new Socket("127.0.0.1", Port);
								
					    		bos = new BufferedOutputStream(client.getOutputStream()); 
					    		
					    		byteArray = t1.getText().getBytes();
					    
					    		bos.write(byteArray, 0, byteArray.length);
					    		bos.flush();
					    		bos.close();
					    		client.close();
							} catch (UnknownHostException e1) {
								
								e1.printStackTrace();
							} catch (Exception e1) {}
								
							finally {}
							 
						
						  
					 
						 
					 } 
					 else
					 
					 if(b.equals("Router C"))
					 {

						 Socket client = null;
	   					    
							int Port = 9002;
															
							try {
								client = new Socket("127.0.0.1", Port);
								
					    		bos = new BufferedOutputStream(client.getOutputStream()); 
					    		
					    		byteArray = t1.getText().getBytes();
					    
					    		bos.write(byteArray, 0, byteArray.length);
					    		bos.flush();
					    		bos.close();
					    		client.close();
							} catch (UnknownHostException e1) {
								
								e1.printStackTrace();
							} catch (Exception e1) {}
								
							finally {}
							 
						
						  
					  
					 }
					 
					 System.out.println("The Router Name="+b);
                        
					 
					 
					 
				 }
					 
					 
					 
					 
				 }
		    	 	
				
						
							
	}
				 
	       
	
	
	

