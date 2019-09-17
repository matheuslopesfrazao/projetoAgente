package agente;

import java.util.Random;

import ambiente.Labirinto;
import geral.PosicaoXY;

public class AgenteLabirinto {

	// Movimentar para 4 direções (Cima, baixo, esquerda, direita)
	// Referencia do Labiririnto 
	
	private Labirinto labirinto;
	private MovimentosAgenteLabirinto movimento;
	
	private PosicaoXY posXY;	

	public AgenteLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
		labirinto.setAgente(this);
		this.posXY = new PosicaoXY(0,0);
		this.movimento=MovimentosAgenteLabirinto.DIREITA;
//		this.movimento = MovimentosAgenteLabirinto.CIMA;
	}
	
	private MovimentosAgenteLabirinto observar() {
		PosicaoXY posicao = new PosicaoXY();
				if(this.getPosicao().getPosY()-1 >=0) {
					posicao.setPosX(this.getPosicao().getPosX());
					posicao.setPosY(this.getPosicao().getPosY()-1);
					if(this.labirinto.retornarValorPosicaoLabirinto(posicao) =="S") {
						return MovimentosAgenteLabirinto.ESQUERDA;
					}
				}
				
				if(this.getPosicao().getPosX()-1 >= 0) {
					posicao.setPosX(this.getPosicao().getPosX()-1);
					posicao.setPosY(this.getPosicao().getPosY());
					if(this.labirinto.retornarValorPosicaoLabirinto(posicao) =="S") {
						return MovimentosAgenteLabirinto.CIMA;
					}
				}
				
				if (this.getPosicao().getPosY()+1 < this.labirinto.getTamanhoLabirinto()) {
					posicao.setPosX(this.getPosicao().getPosX());
					posicao.setPosY(this.getPosicao().getPosY()+1);
					if(this.labirinto.retornarValorPosicaoLabirinto(posicao) =="S") {
						return MovimentosAgenteLabirinto.DIREITA; 
					}
				}
				
				if (this.getPosicao().getPosX()+1 < this.labirinto.getTamanhoLabirinto()) {
					posicao.setPosX(this.getPosicao().getPosX()+1);
					posicao.setPosY(this.getPosicao().getPosY());
					if(this.labirinto.retornarValorPosicaoLabirinto(posicao) =="S"){
						return MovimentosAgenteLabirinto.BAIXO;
				}
			}						
		return movimentoAleatorio();
	}


	public void movimentar() {		
		if(observar()!=null) {// Observa se existe uma posição suja aos redores para se movimentar para ela
			movimento= observar();
		}
		else if(movimentoAleatorio()!=null) {// Se não encontrou uma posição suja ao redor, irá se movimentar para uma posição aleatório, se possível			
			 movimento = movimentoAleatorio();
		}
		
		if(movimento!=null) {//Reazliza um movimento para posição ao redor
			PosicaoXY proximoMovimento = retornarMovimento();
			this.labirinto.limpar();
			this.posXY = proximoMovimento;}
		else {//Caso não encontre sujeira aos redores e a posição aleatória encontrou uma parede
			movimentar();//Vai tentar de novo
			}
	}
	
	public MovimentosAgenteLabirinto movimentoAleatorio() {
			PosicaoXY posicao = new PosicaoXY();
			Random random = new Random(); //Instanciando um objeto da classe Random
			int numeroAleatorio = random.nextInt(4); // valor máximo é o 4. Ou seja, vai gerar 0 ou 3 aleatóriamente.
			
			if(numeroAleatorio == 0) {
			if(this.getPosicao().getPosY()-1 >=0) {
				posicao.setPosX(this.getPosicao().getPosX());
				posicao.setPosY(this.getPosicao().getPosY()-1);			
				return MovimentosAgenteLabirinto.ESQUERDA;
			}
			}
			
			if(numeroAleatorio ==1 ) {
			if(this.getPosicao().getPosX()-1 >= 0) {
				posicao.setPosX(this.getPosicao().getPosX()-1);
				posicao.setPosY(this.getPosicao().getPosY());			
				return MovimentosAgenteLabirinto.CIMA;
			}
			}
			
			if(numeroAleatorio==2) {
			if (this.getPosicao().getPosY()+1 < this.labirinto.getTamanhoLabirinto()) {
				posicao.setPosX(this.getPosicao().getPosX());
				posicao.setPosY(this.getPosicao().getPosY()+1);		
				return MovimentosAgenteLabirinto.DIREITA; 
				
			}
			}
			
			if(numeroAleatorio==3) {
			if (this.getPosicao().getPosX()+1 < this.labirinto.getTamanhoLabirinto()) {
				posicao.setPosX(this.getPosicao().getPosX()+1);
				posicao.setPosY(this.getPosicao().getPosY());
				return MovimentosAgenteLabirinto.BAIXO;		
		}
			}
			return null;
		}

	




	public PosicaoXY retornarMovimento() {
		int retornoPosX = this.posXY.getPosX();
		int retornoPosY = this.posXY.getPosY();
		switch(movimento) {
			case CIMA:
				if (retornoPosX > 0) {
					retornoPosX -= 1;
				}
				break;
			case BAIXO:
				if (retornoPosX < this.labirinto.getTamanhoLabirinto() - 1) {
					retornoPosX += 1;
				}
				break;
			case ESQUERDA:
				if (retornoPosY > 0) {
					retornoPosY -= 1;
				}
				break;
			case DIREITA:
				if (retornoPosY < this.labirinto.getTamanhoLabirinto() - 1) {
					retornoPosY += 1;
				}
				break;
		}
		return new PosicaoXY(retornoPosX, retornoPosY);
	}

	public PosicaoXY getPosicao() {
		return this.posXY;
	}

	public boolean isAindaLimpando() {
		return pilhaMovimentos < 4;
	}

	public void zerarPilha() {
		this.pilhaMovimentos = 0;
	}

	public void setPosicao(PosicaoXY posicaoXY) {
		this.posXY = posicaoXY;
		
	}
	
}
