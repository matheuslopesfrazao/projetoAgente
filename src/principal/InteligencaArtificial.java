package principal;

import java.util.Scanner;

import agente.AgenteLabirinto;
import ambiente.Labirinto;
import geral.PosicaoXY;

public class InteligencaArtificial {

	public static void main(String[] args) throws InterruptedException	 {
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Informe a capacidade da bateria: ");
		int bateria = entrada.nextInt();		
		
		
		Labirinto labirinto = new Labirinto(4);	
		labirinto.exibirLabirinto();
		
		AgenteLabirinto agente = new AgenteLabirinto(labirinto);
		agente.setPosicao(new PosicaoXY(0,0));				
		
		while(bateria>0) {
			agente.movimentar();
			labirinto.sujarAleatorio();
			bateria = bateria-1;
			System.out.println("Bateria atual: "+bateria+"\n");
			labirinto.exibirLabirinto();
			Thread.sleep(1500);			
		}
	}

}
