import java.util.*;

public class Conjuntos {
	//atributos
	private Set<String> desJava;
	private Set<String> desWeb;
	private Set<String> desCel;
	
	public Conjuntos (int opcion){//Constructor que llama al Factory
		SetFactory<String> sfactory = new SetFactory<String>();
		desJava = sfactory.getSet(opcion);
		desWeb = sfactory.getSet(opcion);
		desCel = sfactory.getSet(opcion);
	}
	//Setters y getters
	public Set<String> getDesJava() {
		return desJava;
	}
	public void setDesJava(Set<String> desJava) {
		this.desJava = desJava;
	}
	public Set<String> getDesWeb() {
		return desWeb;
	}
	public void setDesWeb(Set<String> desWeb) {
		this.desWeb = desWeb;
	}
	public Set<String> getDesCel() {
		return desCel;
	}
	public void setDesCel(Set<String> desCel) {
		this.desCel = desCel;
	}
	public int hashCode(String nombre)//Genera hashCode para poder utilizar
	{
		
		int hashN=0;
		//El hash se genera utilizando los primeros 3 caracteres de los nombres
		hashN=1000*((int)nombre.charAt(0))+100*((int)nombre.charAt(1))+10*((int)nombre.charAt(2));//Se genera el codigo Hash para cada nombre
		return hashN;
	}
	//agrega un nuevo nombre al conjunto indicado
	public void agregar(String nombre, int opcion){
		switch(opcion){
		case 1:
			desJava.add(nombre);
			break;
		case 2:
			desWeb.add(nombre);
			break;
		default:
			desCel.add(nombre);
		}
	}
	//revisa los nombres que se encuentran en los tres conjuntos
	public String[] javaAndWebAndCel(){
		String[] arreglo1 = desJava.toArray(new String[0]);
		String[] arreglo2 = new String[desJava.size()];
		String[] arreglo3 = new String[desJava.size()];
		int contador = 0;
		for(int i = 0; i < arreglo1.length; i++){//revisa los nombres que se repiten en Java y Web
			try{
				if(desWeb.contains(arreglo1[i])){
					arreglo2[contador] = arreglo1[i];
					contador++;
				}
			}
			catch(NullPointerException e){}
		}
		contador = 0;
		for(int i = 0; i < arreglo2.length; i++){//revisa los nombres que se repiten en el conjunto generado anteriormente y Cel
			try{
				if(desCel.contains(arreglo2[i])){
					arreglo3[contador] = arreglo2[i];
					contador++;
				}
			}
		catch(NullPointerException e){}
		}
		return arreglo3;//regrese el conjunto generado
	}
	public String[] javaNotWeb(){
		String[] arreglo1 = desJava.toArray(new String[0]);
		String[] arreglo2 = new String[desJava.size()];
		int contador = 0;
		for(int i = 0; i < arreglo1.length; i++){//revisa los nombres de Java que no est�n en Web
			try{
				if(!desWeb.contains(arreglo1[i])){
					arreglo2[contador] = arreglo1[i];
					contador++;
				}
			}
			catch(NullPointerException e){}
		}
		return arreglo2;
	}
	public String[] webAndCelNotJava(){
		String[] arreglo1 = desWeb.toArray(new String[0]);
		String[] arreglo2 = new String[desWeb.size()];
		String[] arreglo3 = new String[desWeb.size()];
		int contador = 0;
		for(int i = 0; i < arreglo1.length; i++){//revisa los nombres que se repiten en Web y Cel
			try{
				if(desCel.contains(arreglo1[i])){
					arreglo2[contador] = arreglo1[i];
					contador++;
				}
			}
			catch(NullPointerException e){}
		}
		contador = 0;
		for(int i = 0; i < arreglo2.length; i++){//del conjunto anterior, revisa los que no est�n en Java
			try{
				if(!desJava.contains(arreglo2[i])){
					arreglo3[contador] = arreglo2[i];
					contador++;
				}
			}
			catch(NullPointerException e){}	
		}
		return arreglo3;
	}
	public String[] webOrCelNotJava(){
		String[] arreglo1 = desWeb.toArray(new String[0]);
		String[] arreglo2 = desCel.toArray(new String[desWeb.size() + desCel.size()]);
		String[] arreglo3 = new String[desWeb.size() + desCel.size()];
		int contador = 0;
		for(int i = 0; i < arreglo1.length; i++){//revisa los nombres que le hacen falta a Cel de Web
			try{
				if(!desCel.contains(arreglo1[i])){
					arreglo2[desCel.size() + contador] = arreglo1[i];
					contador++;
				}
			}
			catch(NullPointerException e){}
			
		}
		contador = 0;
		for(int i = 0; i < arreglo2.length; i++){//del conjunto anterior, revisa los que no est�n en Java
			try{
				if(!desJava.contains(arreglo2[i])){
					arreglo3[contador] = arreglo2[i];
					contador++;
				}
			}
			catch(NullPointerException e){}
		}
		return arreglo3;
	}
	public boolean javaSubWeb(){
		String[] arreglo1 = desJava.toArray(new String[0]);
		int contador = 0;
		for(int i = 0; i < arreglo1.length; i++){//revisa cu�ntos nombres de Java est�n en Web
			try{
				if(desWeb.contains(arreglo1[i])){
					contador++;
				}
			}
			catch(NullPointerException e){}
		}
		if(contador == desJava.size()){//si todos los nombres de Java est�n en Web, retorna true
			return true;
		}
		else{
			return false;//si no, false
		}
	}
}
