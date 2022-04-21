import java.util.Arrays;

public class Backtracking {
	private int n;
	private int solucion;
	private String sucesores=null;
	private boolean encontrado=false;
	
	public Backtracking(int solucion, String sucesores) {
		super();
		this.solucion = solucion;
		this.sucesores=sucesores;
	}
	
	public void bactrackingM(int etapa, char[] v) {
		if(etapa==4 && esSolucion(v) && !encontrado) {
			System.out.println("Soluci�n: ");
			for(int i=0; i<v.length+1;i++) {			
				if(i<v.length)System.out.print(v[i]);
				else System.out.println("="+solucion);
			}
			System.out.println();
			encontrado=true;
		}
		else if(etapa<4 && !encontrado) { //No es necesario buscar fracaso, porque si ya est� en la etapa final y no es �xito, ser� tambi�n fracaso
			char[] s=genSucesor(v,etapa+1);
			for(int k=0;k<s.length;k++) {
				v[etapa+1]=s[k];
				bactrackingM(etapa+1,v);
			}
		}
		
	}
	
	public boolean esSolucion(char[]v) {
		//System.out.println("Probando");
		boolean s=false;
		String p1,p2;
		int numero1,numero2;
        char[] n = Arrays.copyOfRange(v, 0, 2);
        p1= String.valueOf(n).replace(" ", "").replace("[", "").replace("]", "").replace(",", "");
        char[] n1 = Arrays.copyOfRange(v, 3,5);
        p2=String.valueOf(n1).replace(" ", "").replace("[", "").replace("]", "").replace(",", "");
        numero1=Integer.parseInt(p1);
        numero2=Integer.parseInt(p2);

        switch(v[2]) {
        case '/':
        	if(numero2>0) {
        	if ((numero1/numero2)==solucion){
        		
        		s=true;
        	}
        	}
        	break;
        case '*':
        	if(((numero1*numero2)==solucion)) {
        		
        		s=true;
        	}
        	break;
        case '+':
        	if(((numero1+numero2)==solucion)) {
        		
        		s=true;
        	}
        	break;
        case '-':
        	if(((numero1-numero2)==solucion)) {
        		
        		s=true;
        	}
        	break;
        	
        }
		return s;
	}
	
	public char[] genSucesor(char[] v, int etapa) {//n�meros disponibles para poner
		char[] s;
		if(etapa==2) {
		s=sucesores.substring(7).toCharArray();
		}
		
		else {
		s=sucesores.substring(0, 7).toCharArray();
		}
		
		return s;
	}
	
}
