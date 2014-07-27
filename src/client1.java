
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
import java.util.Random;

	import javax.swing.JButton;
import javax.swing.JFileChooser;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
import javax.swing.JTextField;

public class client1 implements ActionListener {
	
	public JButton b1= new JButton("Browse");
	public JButton b2= new JButton("Split");
	public JButton b3= new JButton("Send");
	public JLabel la1= new JLabel("Select the file :");
	public JLabel la2= new JLabel("File path         :");
	public JLabel la3= new JLabel("File Size (Bits)   :");
	public JLabel la4= new JLabel("CLIENT 1");
	public JLabel c1= new JLabel();
	public JTextField c2= new JTextField("");
	public JTextArea t2= new JTextArea("");
	public JScrollPane sc=new JScrollPane();
	public JScrollPane sc1=new JScrollPane();
	public JTextArea t1= new JTextArea("");
	public Font l = new Font("Times New roman" , Font.BOLD , 18);
	public Font l2 = new Font("Times New roman" , Font.BOLD , 16);
	public Font l1 = new Font("Times New roman" , Font.BOLD, 30);
	public JFrame jf;
	public Container c;
	client1()
	{
		jf = new JFrame("Client1");
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(1024,736);
		c.setBackground( new Color(236,216,234));
		b1.setBounds(300,110,100,35);
		b1.setFont(l);
		b1.setForeground(new Color(10,70,198));
		b2.setBounds(700,400,100,35);
		b3.setBounds(375,600,100,35);
		b3.setFont(l);
		b3.setForeground(new Color(10,70,198));
		la1.setBounds(100,100,150,50);
		la2.setBounds(100,150,150,50);
		la3.setBounds(100,200,150,50);
		la4.setBounds(420,0,150,50);
		c1.setBounds(300,160,400,35);
		c1.setFont(l2);
		c1.setForeground(new Color(120,0,0));
		c2.setBounds(300,210,100,35);
		
		c2.setForeground(new Color(30,70,98));
		c2.setFont(l);
		sc1.setBounds(400,300,100,200);
		//b1.setBorderPainted(false);
		sc.setBounds(100,300,300,200);
		t1.setColumns(20);
		t1.setRows(10);
		t1.setForeground(Color.BLUE);
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
	       
	       int[] ports = new int[] { 2000 };

			for (int i = 0; i < 1; i++) {
				Thread t = new Thread(new PortListener(ports[i]));
				t.setName("Listener-" + ports[i]);
				t.start();

			}    
	       
	       
	}
	       public static void main (String args[])
	       {
	       	new client1();
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
		   			
		   				    server = new ServerSocket(2000);
		   					
		   				     while (true)
		   				   {
								 System.out.println("hi i am in while block");
		   					                   connection = server.accept();
		   									    System.out.println("hi connection to server block hs been estd");
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
		   					                            
		   					                            
		   					                         byte[] byteArray;			 
			  					                       Socket client = null;
			  					    try     { 
			  						
			  						                  client = new Socket("127.0.0.1", 3000);
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
				    
				    Random r = new Random();
        			Random rm = new Random();
        			Random ran = new Random();
        			int p1 =(Math.abs(r.nextInt()) % 20)+1; 
        			int p2 =(Math.abs(r.nextInt()) % 20)+1;
        			int p3 =(Math.abs(r.nextInt()) % 20)+1;
        			
        			
        			String aString = Integer.toString(p1);
        			String bString = Integer.toString(p2);
        			String cString = Integer.toString(p3);
        			
        			
        			
        			
        			
        			System.err.println("random value1  ="+aString ); 
        			System.err.println("random value2  ="+bString);
        			System.err.println("random value3  ="+cString);
					 
				 if(e.getSource()== b3)
				 {
					 
					 
					 /*Runtime rt = Runtime.getRuntime();
					 Process proc = rt.exec("some.exe");
					 int exitVal = proc.exitValue();
					 System.out.println("Process exitValue: " + exitVal);*/
					 
					 
					/* Runtime r1=Runtime.getRuntime();
					    Process p=null;
					    try
					    {
					     String s="c:\\windows\\notepad.exe";
					      
					     //String s="C:\\Program Files\\VideoLAN\\vlc.exe";
					      p=r1.exec(s);
					    }
					    catch(Exception e1){
					      System.out.println("error==="+e1.getMessage());
					      e1.printStackTrace();
					    }*/
					 
					 if(p1<p2&&p1<p3)
					 {
						 System.err.println("check random value1  ="+aString ); 
						 
						 
						 Socket client = null;
	   					    
							int Port = 1000;
															
							try {
								client = new Socket("127.0.0.1", Port);
								
					    		bos = new BufferedOutputStream(client.getOutputStream()); 
					    		   		 		
					    		
					    		//String rr=ftf;
					    		
					    		
					    		
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
					 if(p2<p1&&p2<p3)
					 {
						 System.err.println("check random value2  ="+bString);
						 
						 
						 Socket client = null;
	   					    
							int Port = 1001;
															
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
					 if(p3<p1&&p3<p2)			
					 {
						 System.err.println("check random value3  ="+cString); 
						 Socket client = null;
	   					    
							int Port = 1002;
															
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
					 
					 
					 
				 }
					 
					 
					 
					 
				 }
		    	 	
				
						
							
	}
				 
	       
	
	
	

