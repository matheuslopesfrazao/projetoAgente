package principal;

import agente.AgenteLabirinto;
import ambiente.Labirinto;
import geral.PosicaoXY;

public class InteligencaArtificial {

	public static void main(String[] args) throws InterruptedException	 {
		
		Labirinto labirinto = new Labirinto(6);	
		labirinto.exibirLabirinto();
		
		AgenteLabirinto agente = new AgenteLabirinto(labirinto);
		agente.setPosicao(new PosicaoXY(0,0));

		while(1>0) {
			agente.movimentar();
			labirinto.sujarAleatorio();
			labirinto.exibirLabirinto();
			Thread.sleep(1500);
		}
	}

}
