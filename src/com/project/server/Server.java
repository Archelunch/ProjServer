package com.project.server;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


	public class Server {
		 private static ServerSocket serverSocket;
		    private static Socket clientSocket;
		     
		    private static String message;
		     
		    private static String answer;
		    public static void main(String[] args) throws IOException {
		 
		        try {
		            serverSocket = new ServerSocket(4444);  //Server socket
		 
		        } catch (IOException e) {
		            System.out.println("Could not listen on port: 4444");
		        }
		 
		        System.out.println("Server started. Listening to the port 4444");
		        clientSocket = serverSocket.accept();  
		        InputStream sin = clientSocket.getInputStream();
                OutputStream sout = clientSocket.getOutputStream();
                DataInputStream in = new DataInputStream(sin);
                DataOutputStream out = new DataOutputStream(sout);
                message = "";
		        while (true) {
		        	
	                
		                message = in.readUTF();
		                System.out.println(message);
		                 
		                if(message.equals("Task#1TestTask")){
		                	 out.writeUTF("2+2= ");
		                	 out.flush();
		                	System.out.println("Yep");
		                	answer = in.readUTF();
		                	 
		                	if(answer.equals("4")){
		                		out.writeUTF("Абсолютли правильно");
		                		 out.flush();
		                	}else{
		                		out.writeUTF("Даже первоклассник это знает");
		                		 out.flush();
		                	}
		                }else{
		                	out.writeUTF("Error404");
		                	 out.flush();
		                	System.out.println("Error404");
		                }
		                
		                
		                 
		                 
		                
		 
		             
		        }
		         
		    }
	}

