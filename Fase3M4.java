/*Joan Coll JAVA 2 M4  17/09/2020 */

import java.util.*;

public class Fase3M4 {
	
	public static void main(String[] args) { 
		
		//Preguntamos a usuario numero de platos que quiere introducir:
		//Pasamos primero por el control de excepciones (si el input no es un n�mero);
				
		Scanner entrada = new Scanner(System.in);
		int numDish = 0;
				
		while (true) {
			try	{
				System.out.println("Quants plats vols afegir al men�? ");
				numDish = entrada.nextInt();
				entrada.nextLine();
				break;
				}
			catch (InputMismatchException e) {
				System.err.println("No has introudu�t un n�mero! Torna-ho a provar siusplau");
				entrada.nextLine();
				continue;
				}
		}
						
		System.out.println("La nostra carta tindr� " + numDish + " plats.");
		
		int b5   = 5;
		int b10  = 10;
		int b20  = 20;
		int b50  = 50;
		int b100 = 100;
		int b200 = 200;
		int b500 = 500;
		
		float priceTot = 0;									//Declaro e inicializo precioFactura
		
		String menu [] = new String [numDish];				//Declaro Array menu
		float priceDish [] = new float [numDish];			//Declaro Array precio
		
		HashMap<String, Float> menuPrice = new HashMap<String, Float>();    //Declaro HashMap menu-precio
		
		List<String> order = new ArrayList<String>();		//Declaro lista pedido
		
		
		for (int i = 0; i<numDish; i++) {							
		
			Scanner entrada2 = new Scanner(System.in);      //Coge entrada String
			Scanner entrada3 = new Scanner(System.in);      //Coge entrada float
			 
			System.out.println("Introdueix un plat: ");   	//Relleno array menu, primero checkeamos que input no est� ya en array.
						
			boolean dupli = true;
			
			while (dupli == true) {
				
				String newDish = entrada2.nextLine();
			
				dupli = Arrays.stream(menu).anyMatch(newDish::equals);	
			
				if (dupli == false) {
					
					menu [i] = newDish;
										
				} else {
					System.out.println("Aquest plat est� repetit, introdueix un altre plat: ");
				}
			}
			
			while (true) {	//Relleno array priceDish pasando por control excepci�n (check n�mero + entrada decimales)
				try	{
					System.out.println("Introdueix el preu del plat: ");
					priceDish[i]= entrada3.nextFloat();	
					entrada3.nextLine();
					break;
				}
				catch (InputMismatchException e) {
					System.err.println("No has introudu�t un preu v�lid! Torna-ho a provar siusplau (Introdueix n�meros i els decimals amb ','.) ");
					entrada3.nextLine();
					continue;
				}
			}
			
			menuPrice.put(menu[i],priceDish[i]);  //Introduzco en HashMap
		}		
				
		for (String i : menuPrice.keySet()) {	   //Printo HashMap menu-precio
			
		      System.out.println(i + " Preu:" + menuPrice.get(i) + "�"); 
		}
		
		int continueOrder = 1;
				
		while (continueOrder == 1) {		//Condicion para seguir pidiendo, inicializada en 1.
			
			Scanner entrada2 = new Scanner(System.in);
			Scanner entrada3 = new Scanner(System.in);
			System.out.println("Demana el plat que vulguis: ");
			order.add(entrada2.nextLine());
			
			//int control = 1; 
			
			while (true) {			//Pregunto si quiere seguir pidiendo + control excepci�n (check que entrada sea 0 o 1)
				try	{
					
					System.out.println("Vols seguir demanant? 1 = si / 0 = no ");
					continueOrder = entrada3.nextInt();	
					entrada3.nextLine();
					continueOrder = wrongContinue (continueOrder);  //M�todo para revisar que n�mero sea 1 o 0;
					break;					
				}
				catch (InputMismatchException e) {
					System.err.println("Error! Torna-ho a provar siusplau (Introdueix 1 = si / 0 = no) ");
					entrada3.nextLine();
					continue;
				}
			}
		}		
		
		System.out.println("Has demanat: " + order);
			
		//comparo lista order con array menu para obtener el precio total de la factura
		for (int i = 0; i<numDish; i++){
            		           
			for (int j=0; j<order.size(); j++) { 
            	
				if (order.get(j).equals(menu[i])) {
					priceTot += priceDish[i];
				}
			}
		}
		
		//Paso array "menu" a lista, para obtener los elementos que no est�n en el men�.
		List<String> menuList = Arrays.asList(menu); 
		order.removeAll(menuList);
		boolean extra = order.isEmpty();
		
		if (extra != true) {
			System.out.println("Aquests plats no est�n al men�: " + order);
		}
		
		System.out.println("El preu total de la factura �s de: " + priceTot + "�");
			
		//Como pagar
		if (priceTot <= 5) {
			System.out.println("Haur�s de pagar amb un billet de " + b5 + "�");
		} else if ((priceTot > 5) && (priceTot <= 10)) {
			System.out.println("Haur�s de pagar amb un billet de " + b10 + "�");
		} else if ((priceTot > 10) && (priceTot <= 15)) { 
			System.out.println("Haur�s de pagar amb un billet de " + b10 + "�" + " i un billet de " + b5 + "�" );
		} else if ((priceTot > 15) && (priceTot <= 20)) {
			System.out.println("Haur�s de pagar amb un billet de " + b20 + "�");
		} else if ((priceTot > 20) && (priceTot <= 25)) {
			System.out.println("Haur�s de pagar amb un billet de " + b20 + "�" + " i un billet de " + b5 + "�" );
		} else if ((priceTot > 25) && (priceTot <= 30)) {
			System.out.println("Haur�s de pagar amb un billet de " + b20 + "�" + " i un billet de " + b10 + "�" );
		} else if ((priceTot > 30) && (priceTot <= 35)) {
			System.out.println("Haur�s de pagar amb un billet de " + b20 + "�" + " i un billet de " + b10 + "�" + "I un billet de: " + b5 + "�" );
		} else if ((priceTot > 35) && (priceTot <= 40)) {
			System.out.println("Haur�s de pagar amb dos billets de " + b20 + "�");
		} else if ((priceTot > 40) && (priceTot <= 45)) {
			System.out.println("Haur�s de pagar amb dos billets de " + b20 + "�" + " i un billet de " + b5 + "�");
		} else if ((priceTot > 45) && (priceTot <= 50)) {
			System.out.println("Haur�s de pagar amb un billet de " + b50 + "�");
		} else if ((priceTot > 50) && (priceTot <= 100)) {
			System.out.println("Haur�s de pagar amb un billet de " + b100 + "�");
		} else if ((priceTot > 100) && (priceTot <= 200)) {
			System.out.println("Haur�s de pagar amb un billet de " + b200 + "�");
		} else if ((priceTot > 200) && (priceTot <= 400)) {
			System.out.println("Haur�s de pagar amb dos billets de " + b200+ "�");
		} else {
			System.out.println("Haur�s de pagar un o m�s billets de " + b500+ "�");
		}
	}	
	
	public static int wrongContinue(int num) {
		Scanner entrada = new Scanner(System.in);
		while (num > 1) {
			System.out.println("N�mero massa alt! Recorda: 1 = si / 0 = no");
			num = entrada.nextInt();	
			entrada.nextLine();
		}
		return num;
	}
}