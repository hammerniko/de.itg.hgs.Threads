package a01_ThreadErzeugen;

import java.util.Scanner;

public class StartKlasse {
	
	public static void main(String[] args) {
		//beginn main Thread
		System.out.println("Main Thread gestartet");
		
		//Thread Objekt erzeugen
		MyThread a = new MyThread("a",300);
		MyThread x = new MyThread("x",100);
		
		//Thread starten
		
		a.start();
		
		
		x.start();
		
		
		
		System.out.println("Main Thread zuende");

	}
}
