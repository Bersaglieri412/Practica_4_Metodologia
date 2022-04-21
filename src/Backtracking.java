import java.util.Arrays;

public class Backtracking {
	private int n;
	private int solucion;
	private String elementos=null;
	private boolean encontrado=false;
	
	public Backtracking(int solucion, String elementos) {
		super();
		this.solucion = solucion;
		this.elementos=elementos;
	}
	
	public boolean bactrackingM(int etapa, char[] v) {
		if(etapa==4 && esSolucion(v) && !encontrado) {
			System.out.println("Solución encontrada: ");
			for(int i=0; i<v.length+1;i++) {			
				if(i<v.length)System.out.print(v[i]);
				else System.out.println("="+solucion);
			}
			System.out.println();
			encontrado=true;
		}
		else if(etapa<4 && !encontrado) { //No es necesario buscar fracaso, porque si ya está en la etapa final y no es éxito, será también fracaso
			char[] sucesores=genSucesor(v,etapa+1);
			for(int k=0;k<sucesores.length;k++) {
				v[etapa+1]=sucesores[k];
				bactrackingM(etapa+1,v);
			}
		}
		return encontrado;
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
	
	public char[] genSucesor(char[] v, int etapa) {//números disponibles para poner
		char[] sucesores;
		if(etapa==2) {
		sucesores=elementos.substring(7).toCharArray();
		}
		
		else {
		sucesores=elementos.substring(0, 7).toCharArray();
		}
		
		return sucesores;
	}
	
}
