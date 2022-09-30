package com.ipartek.shockets;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Server {
	private static boolean AUTOFLUSH=true;

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(1234);
		Socket s = ss.accept();//espera a que alguien se conecte al server
		
		PrintWriter pw = new PrintWriter(s.getOutputStream(),AUTOFLUSH);
		Scanner sc = new Scanner(s.getInputStream());
		pw.println("Bienvenido al server");
		String texto=sc.nextLine();
		pw.println(texto.toUpperCase());
		
		pw.close();
		sc.close();
		s.close();
		ss.close();
	}

}
