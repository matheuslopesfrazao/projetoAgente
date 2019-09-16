package principal;

import java.util.Random;

import agente.AgenteLabirinto;
import ambiente.Labirinto;
import geral.PosicaoXY;

public class InteligencaArtificial {

	public static void main(String[] args) throws InterruptedException{
		
		//Labirinto labirinto = new Labirinto(5);
		//labirinto.caracol();// Chama função caracol
		//labirinto.exibirLabirinto();
		
		//AgenteLabirinto agente = new AgenteLabirinto(labirinto);
		//agente.setPosicao(new PosicaoXY(2,2));
		/*
		while(agente.isAindaLimpando()) {
			agente.zerarPilha();
			agente.movimentar(); 
			//labirinto.exibirLabirinto();
			Thread.sleep(1500);
		}
		return;
		*/
		int tamanhoLabirinto=5;
				
		
		// Construir o labirinto	 
			String[][] labirinto = new String [tamanhoLabirinto][tamanhoLabirinto];
			for (int i = 0; i < tamanhoLabirinto; i++) {
				for (int j = 0; j < tamanhoLabirinto; j++) {
					Random random = new Random(); //Instanciando um objeto da classe Random
					int numeroAleatorio = random.nextInt(2); // valor máximo é o 1. Ou seja, vai gerar 0 ou 1 aleatóriamente.				
					if (numeroAleatorio == 0) {
						labirinto[i][j] = "L";
					}
					else {
						labirinto[i][j] = "S";
					}												
				}
		}//Fecha Construir labirinto		
		
			//Começa caracol
			int i = 0;
			int j = 0;
			int right = tamanhoLabirinto-1;
			int left = 0;
			int top = 1; 
			int down = tamanhoLabirinto-1;
			int cont = 1;
			
	        while (cont <= tamanhoLabirinto*tamanhoLabirinto) {
	            while (j <= right) {
	            	labirinto[i][j++] = "L";
	            	Thread.sleep(1500);
	            }
	            right--; j--; i++;
	            while (i <= down) {
	            	labirinto[i++][j] = "L";
	            	Thread.sleep(1500);
	            }
	            down--; i--; j--;
	            while (j >= left) {
	            	labirinto[i][j--] = "L";
	            	Thread.sleep(1500);
	            }
	            left++; j++; i--;
	            while (i >= top) {
	            	labirinto[i--][j] = "L";
	            	Thread.sleep(1500);
	            }
	            top++; i++; j++;
	            Thread.sleep(1500);
	        }
	        for (int lin = 0; lin < tamanhoLabirinto; lin++) {
	            for (int col = 0; col < tamanhoLabirinto; col++) {
	                System.out.printf("%2d ", labirinto[lin][col]);
	            }
	            System.out.println("");
	        }
	        System.out.println("-----------");
	        // Acaba caracol
			
	}

}
