public class Personagem{

	private int nivel;
	private int xp;
	private int nivelHab1;
	private int nivelHab2;
	private int nivelHab3;
	private int nivelHab4;
	private int qntManaMax;
	private int qntManaBase1;
	private int qntManaBase2;
	private int qntManaBase3;
	private int qntManaBase4;
	private int cont;


	public Personagem (){

	}

	public Personagem (int qntManaMax, int qntManaBase1, int qntManaBase2, int qntManaBase3, int qntManaBase4){

		this.nivel = 1;
		this.xp = 0;
		this.nivelHab1 = 0;
		this.nivelHab2 = 0;
		this.nivelHab3 = 0;
		this.nivelHab4 = 0;
		this.cont = 1;

		this.qntManaMax = qntManaMax;
		this.qntManaBase1 = qntManaBase1;
		this.qntManaBase2 = qntManaBase2;
		this.qntManaBase3 = qntManaBase3;
		this.qntManaBase4 = qntManaBase4;

	}

	public void adicionarXP(int xp){
	
		this.xp += xp;
		
		if (nivel <= 25) {
			
			if(this.xp == 100) {
				this.nivel += 1;
        this.cont += 1;
			} 
			
			if(this.xp > 100) {
				if(this.xp % 100 == 0) {
					int div = xp/100;
					this.nivel += div;
				}else {
					int resto = xp % 100;
					this.xp += resto;
					this.xp = xp - resto;	
				}
			}
			
			if(nivel >= 25){
		         nivel = 25;
             cont = 25;
		    }
			
			if(this.xp < 100) {
				this.xp += xp;
			}
		}
		     
	}
public boolean melhorarHabilidade(int habilidade){
	
		if(habilidade == 0) {
	     if (this.nivelHab1 < 4 && this.cont >= 1) {
	      this.nivelHab1 += 1;
	      this.qntManaBase1 = this.qntManaBase1 * this.nivelHab1;
	      cont--;

	      return true;
	    }else {
				return false;
			}
		}

		if(habilidade == 1){	
			if((this.nivelHab2 < 4) && (this.cont > 0)) {
				this.nivelHab2 += 1;
				qntManaBase2 = qntManaBase2*nivelHab2;
				qntManaMax -= qntManaBase2;
				this.cont += 1;
				return true;
			}else {
				return false;
			}
		}


		if(habilidade == 2) {
			if((this.nivelHab3 <= 4) && (this.cont > 0)) {
				this.nivelHab3 += 1;
				qntManaBase3 = qntManaBase3*nivelHab3;
				qntManaMax -= qntManaBase3;
				this.cont += 1;
				return true;
			}else {
				return false;
			}
		}

		if((habilidade == 3) && (this.nivel >= 6)){
			
				if((this.nivelHab4 < 3) && (this.cont > 0)) {
					
					this.nivelHab4 += 1;
					qntManaBase4 = qntManaBase4*nivelHab4;
					qntManaMax -= qntManaBase4;
					this.cont += 1;
					
					return true;
				}else {
					return false;
				}
		}	
		
	    
		return false;
		
		

	}
	
	public boolean usarHabilidade(int habilidade){

		if((habilidade == 0) && (qntManaBase1 < qntManaMax)) {
			if((this.nivelHab1 > 0) && (this.cont > 0)) {
				this.nivelHab1 += 1;
			
				return true;
			}
		}

		if((habilidade == 1) && (qntManaBase2 < qntManaMax)) {
			if((this.nivelHab2 > 0) && (this.cont > 0)) {
				this.nivelHab2 += 1;
			
				return true;
			}
		}

		if((habilidade == 2) && (qntManaBase3 < qntManaMax)) {
			if((this.nivelHab3 > 0) && (this.cont > 0)) {
				this.nivelHab3 += 1;          
				
				return true;
			}
		}
	
		if((habilidade == 3) && (qntManaBase4 < qntManaMax)) {
			if((this.nivelHab4 > 0) && (this.cont > 0)) {
				this.nivelHab4 += 1;             
				
				return true;
			}
		}

		else {
			return false;
		}

		return false;


		//custo be multiplicado pelo nivel atual da habilidade
	}

	public void consumirPocao(){
		// recarrega a mana em 350, nao podendo passar da mana maxima
		if(this.qntManaBase1 <= this.qntManaMax) {
			 this.qntManaBase1 += 350;
			
			if(this.qntManaBase1 > this.qntManaMax) {
				int resto =  this.qntManaMax - this.qntManaBase1;
				this.qntManaBase1 -= resto;
       
			}
		}
		
		if(this.qntManaBase2 <= this.qntManaMax) {
	    this.qntManaBase2 += 350;
			
			if(this.qntManaBase2 > this.qntManaMax) {
				int resto =  this.qntManaMax - this.qntManaBase2;
				this.qntManaBase2 -= resto;
       
			}
		}
				
		if(this.qntManaBase3 <= this.qntManaMax) {
			this.qntManaBase3 += 350;
			
			if(this.qntManaBase3 > this.qntManaMax) {
				int resto =  this.qntManaMax - this.qntManaBase1;
				this.qntManaBase3 -= resto;
       
			}
		}
		
		if(this.qntManaBase4 <= this.qntManaMax) {
		this.qntManaBase4 += 350;
			
			if(this.qntManaBase4 > this.qntManaMax) {
				int resto =  this.qntManaMax - this.qntManaBase4;
				this.qntManaBase4 -= resto;
			}
			
		}
  
		
	
	}

	public int getNivel() {
		return nivel;
	}




}