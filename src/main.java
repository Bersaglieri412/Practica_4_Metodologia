import java.util.*;
public class main {

	public static void main(String[] args) {
		String sucesores;
		int solucion=((int) (Math.random() * 99)-9);
		System.out.println(sucesores=generarSucesores());
		System.out.println("Solucion a alcanzar: "+solucion);
		Backtracking b = new Backtracking(-5,sucesores); //Acuerdate de sustituir el -5 por solucion
		char[] v = new char[5];
		b.bactrackingM(-1, v);
	}
	
	
	public static String generarSucesores() {
		List<Character> l = new ArrayList<Character>();
		for (int i=0;i<10;i++) l.add(Character.forDigit(i,10));
		List<Character> l2 = new ArrayList<Character>();
		l2.add('*');
		l2.add('-');
		l2.add('+');
		l2.add('/');		
		ArrayList<Character> l1 = new ArrayList<Character>();
		for(int i=0;i<9;i++) {
			if(i<7) {
			l1.add(l.remove((int) (Math.random() * (l.size()-1))));	
			}
			else {
				l1.add(l2.remove((int) (Math.random() * (l.size()))));
			}
		}
		String sucesores=l1.toString().replace(" ", "");
		sucesores=sucesores.replace("[", "");
		sucesores=sucesores.replace("]", "");
		sucesores=sucesores.replace(",", "");
		return sucesores;
	}
	
}
