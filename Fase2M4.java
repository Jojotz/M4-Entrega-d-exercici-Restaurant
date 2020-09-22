/*Joan Coll JAVA 2 M4  17/09/2020 */

import java.util.*;

public class Fase2M4 {
	
	public static void main(String[] args) { 
		
		//Preguntamos a usuario numero de platos que quiere introducir:
		//Pasamos primero por el control de excepciones (si el input no es un número);
				
		Scanner entrada = new Scanner(System.in);
		int numDish = 0;
				
		while (true) {
			try	{
				System.out.println("Quants plats vols afegir al menú? ");
				numDish = entrada.nextInt();
				entrada.nextLine();
				break;
				}
			catch (InputMismatchException e) {
				System.err.println("No has introuduït un número! Torna-ho a provar siusplau");
				entrada.nextLine();
				continue;
				}
		}
						
		System.out.println("La nostra carta tindrá " + numDish + " plats.");
		
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
		int continueOrder = 1;
		
		for (int i = 0; i<numDish; i++) {							
		
			Scanner entrada2 = new Scanner(System.in);      //Coge entrada String
			Scanner entrada3 = new Scanner(System.in);      //Coge entrada float
			 
			System.out.println("Introdueix un plat: ");   	//Relleno array menu, primero checkeamos que input no esté ya en array.
						
			boolean dupli = true;
			
			while (dupli == true) {
				
				String newDish = entrada2.nextLine();
			
				dupli = Arrays.stream(menu).anyMatch(newDish::equals);	
			
				if (dupli == false) {
					
					menu [i] = newDish;
										
				} else {
					System.out.println("Aquest plat está repetit, introdueix un altre plat: ");
				}
			}
			
			while (true) {		//Relleno array priceDish pasando por control excepción (check número + entrada decimales)
				try	{
					System.out.println("Introdueix el preu del plat: ");
					priceDish[i]= entrada3.nextFloat();	
					entrada3.nextLine();
					break;
				}
				catch (InputMismatchException e) {
					System.err.println("No has introuduït un preu válid! Torna-ho a provar siusplau (Introdueix números i els decimals amb ','.) ");
					entrada3.nextLine();
					continue;
				}
			}
			
			menuPrice.put(menu[i],priceDish[i]);  //Introduzco en HashMap
		}		
		
		
		for (String i : menuPrice.keySet()) {		//Printo HashMap menu-precio
		      System.out.println(i + " Preu:" + menuPrice.get(i) + "€"); 
		}
		
		
		while (continueOrder == 1) {		//Condicion para seguir pidiendo, inicializada en 1.
			
			Scanner entrada2 = new Scanner(System.in);
			Scanner entrada3 = new Scanner(System.in);
			System.out.println("Demana el plat que vulguis: ");
			order.add(entrada2.nextLine());
			
			while (true) {			//Pregunto si quiere seguir pidiendo + control excepción (check que entrada sea 0 o 1)
				try	{
					System.out.println("Vols seguir demanant? 1 = si / 0 = no ");
					continueOrder = entrada3.nextInt();	
					entrada3.nextLine();
					break;
				}
				catch (InputMismatchException e) {
					System.err.println("Error! Torna-ho a provar siusplau (Introdueix1 = si / 0 = no) ");
					entrada3.nextLine();
					continue;
				}
			}
		}		
		System.out.println("Has demanat: " + order);
	}
}