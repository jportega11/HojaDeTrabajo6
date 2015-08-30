import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcion1 = 0;
		int opcion2 = 0;
		String nombre = "";
		String[] arreglo = new String[0];
		System.out.println("Bienvenido al sistema de registro de desarroladores");
		System.out.println("Seleccione la implementación a utilizar\n	1. HashSet\n	2. TreeSet\n	3. LinkedHashSet\nOpción:");
		opcion1 = teclado.nextInt();
		Conjuntos conjunto = new Conjuntos(opcion1);
		System.out.println("¿Cuántos desarrolladores desea ingresar)\nNúmero:");
		opcion1 = teclado.nextInt();
		System.out.println("----------------------------------------------------------");
		for (int i = 0; i < opcion1; i++){
			System.out.print("Ingrese el nombre: ");
			nombre = teclado.next();
			System.out.print("¿Es desarrollador Java? 1. Sí 2. No\nOpción: ");
			opcion2 = teclado.nextInt();
			if(opcion2 == 1){
				conjunto.agregar(nombre, 1);
			}
			System.out.print("¿Es desarrollador Web? 1. Sí 2. No\nOpción: ");
			opcion2 = teclado.nextInt();
			if(opcion2 == 1){
				conjunto.agregar(nombre, 2);
			}
			System.out.print("¿Es desarrollador de celulares? 1. Sí 2. No\nOpción: ");
			opcion2 = teclado.nextInt();
			if(opcion2 == 1){
				conjunto.agregar(nombre, 3);
			}
			System.out.println("----------------------------------------------------------");
		}
		arreglo = conjunto.javaAndWebAndCel();
		System.out.println("Desarrolladores con experiencia en las tres ramas:");
		for(int i = 0; i < arreglo.length; i++){
			try{
				if(!arreglo[i].equals(null)){
					System.out.println(arreglo[i]);
				}
			}
			catch(NullPointerException e){}
		}
		
		arreglo = conjunto.javaNotWeb();
		System.out.println("Desarrolladores con experiencia Java sin experiencia Web:");
			for(int i = 0; i < arreglo.length; i++){
				try{
					if(!arreglo[i].equals(null)){
						System.out.println(arreglo[i]);
					}
				}
				catch(NullPointerException e){}
			}
		
		arreglo = conjunto.webAndCelNotJava();
		System.out.println("Desarrolladores web y celulares sin experiencia Java:");
		for(int i = 0; i < arreglo.length; i++){
			try{
				if(!arreglo[i].equals(null)){
					System.out.println(arreglo[i]);
				}
			}
			catch(NullPointerException e){}
		}
		
		/*arreglo = conjunto.webOrCelNotJava();
		System.out.println("Desarrolladores web o celulares sin experiencia Java:");
			for(int i = 0; i < arreglo.length; i++){
				try{
					if(!arreglo[i].equals(null)){
						System.out.println(arreglo[i]);
					}
				}
				catch(NullPointerException e){}
			}
		*/
		if(conjunto.javaSubWeb()){
			System.out.println("Los desarrolladores Java son subconjunto de los web");
		}
		else{
			System.out.println("Los desarrolladores Java no son subconjunto de los web");
		}
	}
}
