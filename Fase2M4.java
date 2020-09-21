/*Joan Coll JAVA 2 M4  17/09/2020 */

import java.util.*;
import java.io.*;

public class Fase2M4 {
	
	public static void main(String[] args) { 
		
		//Preguntamos a usuario numero de platos que quiere introducir:
		
		Scanner entrada=new Scanner(System.in);
		System.out.println("Quants plats vols afegir al menú? ");
		int numDish=entrada.nextInt();   //Recoge número platos
		
		int b5   = 5;
		int b10  = 10;
		int b20  = 20;
		int b50  = 50;
		int b100 = 100;
		int b200 = 200;
		int b500 = 500;
		
		float priceTot;
		
		String menu [] = new String [numDish];				//Declaro Array menu
		float priceDish [] = new float [numDish];			//Declaro Array precio
		
		HashMap<String, Float> menuPrice = new HashMap<String, Float>();  //Declaro HashMap menu-precio
		
		List<String> order = new ArrayList<String>();					  //Declaro lista pedido
		int continueOrder = 1;
		
		for (int i = 0; i < numDish; i++) {							
		
			Scanner entrada2 = new Scanner(System.in);      //Coge entrada String
			Scanner entrada3 = new Scanner(System.in);      //Coge entrada float
			 
			System.out.println("Introdueix un plat: ");  
			menu [i]= entrada2.nextLine();				    //Relleno array menu
			
			System.out.println("Introdueix el preu del plat: ");
			priceDish[i]= entrada3.nextFloat();				//Relleno array priceDish
			
			menuPrice.put(menu[i],priceDish[i]);			// Voy introduciendo en HashMap
		}
		
		for (String i : menuPrice.keySet()) {
		      System.out.println(i + " Preu:" + menuPrice.get(i) + "€"); //Printo HashMap menu-precio
		}
		
		while (continueOrder == 1) {
			
			Scanner entrada2 = new Scanner(System.in);
			Scanner entrada3 = new Scanner(System.in);
			System.out.println("Demana el plat que vulguis: ");
			order.add(entrada2.nextLine());
			System.out.println("Vols seguir demanant? 1 = si / 0 = no ");
			continueOrder = entrada3.nextInt();	
		}
		System.out.println("Has demanat: " + order);
	}
}