import java.util.*;
import ja
public class main {

	public static void main(String[] args) {
		String sucesores;
		int solucion=((int) (Math.random() * 99)-9);
		System.out.println("Solucion a alcanzar: "+solucion+"\n");
		System.out.println("Números y operaciones a utilizar:"+(sucesores=generarSucesores())+"\n");
		Backtracking b = new Backtracking(solucion,sucesores); //Acuerdate de sustituir el -5 por solucion
		char[] v = new char[5];
		b.bactrackingM(-1, v);
	}
	
	
	public static String generarSucesores() {
		List<Character> numeros = new ArrayList<Character>();
		for (int i=0;i<10;i++) numeros.add(Character.forDigit(i,10));
		String[] operaciones= {"*","/","+","-"};
		List<String> l2 = Arrays.asList(operaciones);	
		Collections.shuffle(numeros);	
		Collections.shuffle(l2);
		ArrayList<Character> sucesoresLista = new ArrayList<Character>();
		for(int i=0;i<9;i++) {
			if(i<7) {
				sucesoresLista.add(numeros.get(i));	
			}
			else {
				sucesoresLista.add(l2.get(9-i).charAt(0));
			}
		}
		String sucesores=sucesoresLista.toString().replace(" ", "").replace("[", "").replace("]", "").replace(",", "");
		return sucesores;
	}
	
}
