import java.util.*;
public class SetFactory<E> {
	public Set<E> getSet(int opcion){ //De acuerdo a la opción, de vuelve una instancia diferente para el Set
		switch(opcion){
		case 1:
			return new HashSet<E>(); 
		case 2:
			return new TreeSet<E>();
		default:
			return new LinkedHashSet<E>();
		}
	}
}