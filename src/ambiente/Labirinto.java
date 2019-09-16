package ambiente;

import agente.AgenteLabirinto;
import geral.PosicaoXY;
import java.util.Random; //Importando a classe Random para poder gerar números aletórios

public class Labirinto {

	private int tamanhoLabirinto;
	
	private String[][] labirinto; //Aqui ele declara uma variável do tipo Matriz String
	
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
				Random random = new Random(); //Instanciando um objeto da classe Random
				int numeroAleatorio = random.nextInt(2); // valor máximo é o 1. Ou seja, vai gerar 0 ou 1 aleatóriamente.				
				if (numeroAleatorio == 0) {
					this.labirinto[i][j] = "L";
				}
				else {
					this.labirinto[i][j] = "S";
				}												
			}
		}		
	}
	
	public void caracol() throws InterruptedException {
		int i = 0;
		int j = 0;
		int right = this.tamanhoLabirinto-1;
		int left = 0;
		int top = 1; 
		int down = this.tamanhoLabirinto-1;
		int cont = 1;
		
        while (cont <= this.tamanhoLabirinto*this.tamanhoLabirinto) {
            while (j <= right) {
            	this.labirinto[i][j++] = "L";
            	Thread.sleep(1500);
            }
            right--; j--; i++;
            while (i <= down) {
            	this.labirinto[i++][j] = "L";
            	Thread.sleep(1500);
            }
            down--; i--; j--;
            while (j >= left) {
            	this.labirinto[i][j--] = "L";
            	Thread.sleep(1500);
            }
            left++; j++; i--;
            while (i >= top) {
            	this.labirinto[i--][j] = "L";
            	Thread.sleep(1500);
            }
            top++; i++; j++;
            Thread.sleep(1500);
        }
        for (int lin = 0; lin < this.tamanhoLabirinto; lin++) {
            for (int col = 0; col < this.tamanhoLabirinto; col++) {
                System.out.printf("%2d ", this.labirinto[lin][col]);
            }
            System.out.println("");
        }
        System.out.println("-----------");

	}
	
	
	/*public void exibirLabirinto() {
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
	*/
}
