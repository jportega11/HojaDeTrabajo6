import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcion1 = 0;
		int opcion2 = 0;
		String nombre = "";
		String ingreso = "";
		String[] arreglo = new String[0];

		System.out.println("Bienvenido al sistema de registro de desarroladores");
		while(true){
			try{
				System.out.println("Seleccione la implementación a utilizar\n	1. HashSet\n	2. TreeSet\n	3. LinkedHashSet\nOpción:");
				ingreso = teclado.next();
				opcion1 = Integer.parseInt(ingreso);
				break;
			}
			catch(Exception e){}
		}
		
		Conjuntos conjunto = new Conjuntos(opcion1);
		while(true){
			try{
				System.out.println("¿Cuántos desarrolladores desea ingresar?\nNúmero:");				 
				ingreso = teclado.next();
				opcion1 = Integer.parseInt(ingreso);
				break;
			}
			catch(Exception e){}
		}
		System.out.println("----------------------------------------------------------");
		for (int i = 0; i < opcion1; i++){
			while(true){
				System.out.print("Ingrese el nombre: ");
				nombre = teclado.next();
				if(nombre.length() >= 3){
					break;
				}
				else{
					System.out.println("Por favor, ingrese un nombre con mínimo tres caracteres");
				}
			}
			
			
			
			while(true){
				try{
					System.out.print("¿Es desarrollador JAVA? 1. Sí 2. No\nOpción: ");
					ingreso = teclado.next();
					opcion2 = Integer.parseInt(ingreso);
					if(opcion2==1||opcion2==2)
						break;
					else
						System.out.print("¡Debe ingresar 1 o 2!\n");
				}
				catch(Exception e){System.out.print("¡Debe ingresar un NUMERO entre 1 y 2!\n");}
			}
			if(opcion2 == 1){
				conjunto.agregar(nombre, 1);
			}
			
			
			while(true){
				try{
					System.out.print("¿Es desarrollador WEB? 1. Sí 2. No\nOpción: ");
					ingreso = teclado.next();
					opcion2 = Integer.parseInt(ingreso);
					if(opcion2==1||opcion2==2)
						break;
					else
						System.out.print("¡Debe ingresar 1 o 2!\n");
				}
				catch(Exception e){System.out.print("¡Debe ingresar un NUMERO entre 1 y 2!\n");}
			}
			if(opcion2 == 1){
				conjunto.agregar(nombre, 2);
			}
			while(true){
				try{
					System.out.print("¿Es desarrollador de CELULARES? 1. Sí 2. No\nOpción: ");
					ingreso = teclado.next();
					opcion2 = Integer.parseInt(ingreso);
					if(opcion2==1||opcion2==2)
						break;
					else
						System.out.print("¡Debe ingresar 1 o 2!\n");
				}
				catch(Exception e){System.out.print("¡Debe ingresar un NUMERO entre 1 y 2!\n");}
			}
			if(opcion2 == 1){
				conjunto.agregar(nombre, 3);
			}
			System.out.println("----------------------------------------------------------");
		}
		arreglo = conjunto.javaAndWebAndCel();
		if(arreglo.length == 0){
			System.out.println("No hay desarrolladores que dominen las tres ramas");
		}
		else{
			System.out.println("Desarrolladores con experiencia en las tres ramas:");
			for(int i = 0; i < arreglo.length; i++){
				try{
					if(!arreglo[i].equals(null)){
						System.out.println(arreglo[i]);
					}
				}
				catch(NullPointerException e){}
			}
		}
		arreglo = conjunto.javaNotWeb();
		if(arreglo.length == 0){
			System.out.println("No hay desarrolladores Java sin experiencia en Web");
		}
		else{
			System.out.println("Desarrolladores con experiencia Java sin experiencia Web:");
			for(int i = 0; i < arreglo.length; i++){
				try{
					if(!arreglo[i].equals(null)){
						System.out.println(arreglo[i]);
					}
				}
				catch(NullPointerException e){}
			}
		}
		arreglo = conjunto.webAndCelNotJava();
		if(arreglo.length == 0){
			System.out.println("No hay desarrolladores web y de celulares sin experiencia Java");
		}
		else{
			System.out.println("Desarrolladores web y celulares sin experiencia Java:");
			for(int i = 0; i < arreglo.length; i++){
				try{
					if(!arreglo[i].equals(null)){
						System.out.println(arreglo[i]);
					}
				}
				catch(NullPointerException e){}
			}
		}
		arreglo = conjunto.webOrCelNotJava();
		if(arreglo.length == 0){
			System.out.println("No hay desarrolladores web o de celulares sin experiencia Java");
		}
		else{
			System.out.println("Desarrolladores web o celulares sin experiencia Java:");
			for(int i = 0; i < arreglo.length; i++){
				try{
					if(!arreglo[i].equals(null)){
						System.out.println(arreglo[i]);
					}
				}
				catch(NullPointerException e){}
			}
		}
		if(conjunto.javaSubWeb()){
			System.out.println("Los desarrolladores Java son subconjunto de los web");
		}
		else{
			System.out.println("Los desarrolladores Java no son subconjunto de los web");
		}
		Set<String> arreglo2 = conjunto.getDesJava();
		int cantC1=arreglo2.size();
		
		arreglo2 = conjunto.getDesWeb();
		int cantC2=arreglo2.size();
		
		arreglo2 = conjunto.getDesCel();
		int cantC3=arreglo2.size();
		
		
		if(cantC1>cantC2&&cantC1>cantC3)
		{
			System.out.println("El conjunto de Desarrolladores JAVA es el mas grande, los integrantes son:");
			arreglo2 = conjunto.getDesJava();
			arreglo =arreglo2.toArray(new String[0]);
			for(int i = 0; i < arreglo.length; i++){
				try{
					if(!arreglo[i].equals(null)){
						System.out.println(arreglo[i]);
					}
				}
				catch(NullPointerException e){}
			}
			//En caso que este sea el conjunto con mayor desarrolladores se imprimen los nombres de forma ascendente
			System.out.println("Los nombres en orden alfabetico son: ");
			int[] arregloHash = new int[arreglo.length];
			for(int i=0;i < arreglo.length;i++)
			{
				arregloHash[i]=conjunto.hashCode(arreglo[i]);
			}
			
			Arrays.sort(arregloHash);//Se ordena el arreglo de hashCode
			for(int j=0;j<arregloHash.length;j++)
			{
				//System.out.println(arregloHash[j]);//Solo sirve para ver el Hash
				for(int i=0;i<arreglo.length;i++)
				{
					if(arregloHash[j]==conjunto.hashCode(arreglo[i]))
					System.out.println(arreglo[i]);
				}
			}
			
			
			
		}
		else if(cantC2>cantC1&&cantC2>cantC3)
		{
			System.out.println("El conjunto de Desarrolladores WEB es el mas grande, los integrantes son:");
			arreglo2 = conjunto.getDesWeb();
			arreglo =arreglo2.toArray(new String[0]);
			for(int i = 0; i < arreglo.length; i++){
				try{
					if(!arreglo[i].equals(null)){
						System.out.println(arreglo[i]);
					}
				}
				catch(NullPointerException e){}
			}
			//En caso que este sea el conjunto con mayor desarrolladores se imprimen los nombres de forma ascendente
			System.out.println("Los nombres en orden alfabetico son: ");
			int[] arregloHash = new int[arreglo.length];
			for(int i=0;i < arreglo.length;i++)
			{
				arregloHash[i]=conjunto.hashCode(arreglo[i]);
			}
			
			Arrays.sort(arregloHash);//Se ordena el arreglo de hashCode
			for(int j=0;j<arregloHash.length;j++)
			{
				//System.out.println(arregloHash[j]);//Solo sirve para ver el Hash
				for(int i=0;i<arreglo.length;i++)
				{
					if(arregloHash[j]==conjunto.hashCode(arreglo[i]))
					System.out.println(arreglo[i]);
				}
			}
		}
		else if(cantC3>cantC1&&cantC3>cantC2)
		{
			System.out.println("El conjunto de Desarrolladores de CELULARES es el mas grande, los integrantes son:");
			arreglo2 = conjunto.getDesCel();
			arreglo =arreglo2.toArray(new String[0]);
			for(int i = 0; i < arreglo.length; i++){
				try{
					if(!arreglo[i].equals(null)){
						System.out.println(arreglo[i]);
					}
				}
				catch(NullPointerException e){}
			}
			//En caso que este sea el conjunto con mayor desarrolladores se imprimen los nombres de forma ascendente
			System.out.println("Los nombres en orden alfabetico son: ");
			int[] arregloHash = new int[arreglo.length];
			for(int i=0;i < arreglo.length;i++)
			{
				arregloHash[i]=conjunto.hashCode(arreglo[i]);
			}
			
			Arrays.sort(arregloHash);//Se ordena el arreglo de hashCode
			for(int j=0;j<arregloHash.length;j++)
			{
				//System.out.println(arregloHash[j]);//Solo sirve para ver el Hash
				for(int i=0;i<arreglo.length;i++)
				{
					if(arregloHash[j]==conjunto.hashCode(arreglo[i]))
					System.out.println(arreglo[i]);
				}
			}
		}
		else{
			System.out.println("No hay un solo conjunto con más miembros que los otros");
		}
	}
}
