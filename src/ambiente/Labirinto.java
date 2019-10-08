package ambiente;

import java.util.Random;

import agente.AgenteLabirinto;
import geral.PosicaoXY;
import principal.InteligencaArtificial;


public class Labirinto {

	private int tamanhoLabirinto;
	
	private String[][] labirinto;
	
	private AgenteLabirinto agente;
	
	/* Valores
	 * S - Sujo
	 * L - Limpo
	 * *A* - Agente
	 */
	
	public Labirinto(int tamanhoLabirinto) {
		this.tamanhoLabirinto = tamanhoLabirinto;
		this.construirNovoLabirinto();
	}
	
	// Construir o labirinto
	private void construirNovoLabirinto() {
		labirinto = new String[this.tamanhoLabirinto][this.tamanhoLabirinto];
		for (int i = 0; i < this.tamanhoLabirinto; i++) {
			for (int j = 0; j < this.tamanhoLabirinto; j++) {
				this.labirinto[i][j] = "S";
			}
		}
	}
	
	public void exibirLabirinto() {		
		atualizarPosicaoAgente();
		for (int i = 0; i < tamanhoLabirinto; i++) {
			for (int j = 0; j < tamanhoLabirinto; j++) {
				if (labirinto[i][j].equals("*A*")) {
					System.out.print("|" + labirinto[i][j] + "|");
				} else {
					System.out.print("| " + labirinto[i][j] + " |");
				}
				
			}
			System.out.println("");
		}
		System.out.println("");
	}

	private void atualizarPosicaoAgente() {
		if (this.agente != null) {
			PosicaoXY posAgente = this.agente.getPosicao();
			labirinto[posAgente.getPosX()][posAgente.getPosY()] = "*A*";
		}
	}

	public int getTamanhoLabirinto() {
		
		return this.tamanhoLabirinto;
	}

	public String retornarValorPosicaoLabirinto(PosicaoXY posicao) {
		return this.labirinto[posicao.getPosX()][posicao.getPosY()];
	}

	public void setAgente(AgenteLabirinto agente) {
		this.agente = agente;
	}

	public void limpar() {
		PosicaoXY posicao = this.agente.getPosicao();
		labirinto[posicao.getPosX()][posicao.getPosY()] = "L";
	}

	public void sujarAleatorio() {
		Random random = new Random(); //Instanciando um objeto da classe Random
		int numeroAleatorio = random.nextInt(2); // valor máximo é o 1. Ou seja, vai gerar 0 ou 1 aleatóriamente.				
		if (numeroAleatorio == 1) {
			int i = random.nextInt(this.getTamanhoLabirinto()-1);
			int j = random.nextInt(this.getTamanhoLabirinto()-1);
			this.labirinto[i][j] = "S";
		}			
	}
	
}
