package listaDuplaEncadeada;

public class ListaDupla {
	
	Automovel inicio;
	Automovel fim;
	int tamanho;
	
	
	public void inserirInicio(String marca, String modelo, String cor , String placa) {
		Automovel aux = new Automovel();
		aux.marca = marca;
		aux.modelo = modelo;
		aux.cor = cor;
		aux.placa = placa;
		aux.anterior = null;
		aux.proximo = inicio;
		if(inicio != null) {
			inicio.anterior = aux;
		}
		inicio = aux;
		if (tamanho == 0) {
			fim = inicio;
		}
		tamanho++;
	}
	
	public void inserirFim(String marca, String modelo, String cor , String placa) {
		Automovel aux = new Automovel();
		aux.marca = marca;
		aux.modelo = modelo;
		aux.cor = cor;
		aux.placa = placa;
		aux.proximo = null;
		aux.anterior = fim;
		if(fim != null) {
			fim.proximo = aux;
		}
		fim = aux;
		if(tamanho == 0) {
			inicio = fim;
		}
		tamanho++;
	}
	
	public void inserirMeio(int indice,String marca, String modelo, String cor , String placa ) {
		if(indice <= 0) {
			
			inserirInicio(marca,modelo,cor,placa);
		} else if (indice >= tamanho) {
			
			inserirFim(marca,modelo,cor,placa);
		} else {
			Automovel auxLocal = inicio;
			for(int i = 0 ; i < indice -1; i++) {
				auxLocal = auxLocal.proximo;
			}
			Automovel aux = new Automovel();
			aux.marca = marca;
			aux.modelo = modelo;
			aux.cor = cor;
			aux.placa = placa;
			aux.anterior = auxLocal;
			aux.proximo = auxLocal.proximo;
			auxLocal.proximo = aux;
			aux.proximo.anterior = aux;
			tamanho++;
		}
		
	}
	
	public String retirarInicio() {
		if(inicio == null) {
			return null;
		}
		String retiraMarca,retiraModelo,retiraCor,retiraPlaca;
		retiraMarca = inicio.marca; 
		retiraModelo = inicio.modelo;
		retiraCor = inicio.cor;
		retiraPlaca = inicio.placa;
		inicio = inicio.proximo;
		if(inicio != null) {
			inicio.anterior = null;
		} else {
			fim = null;
		}
		tamanho --;
		return retiraMarca + retiraModelo + retiraCor + retiraPlaca ;
		
	}
	
	
	public String retirarFim() {
		if(fim == null) {
			return null;
		}
		String retiraMarca,retiraModelo,retiraCor,retiraPlaca;
		retiraMarca = inicio.marca;
		retiraModelo = inicio.modelo;
		retiraCor = inicio.cor;
		retiraPlaca = inicio.placa;
		fim = fim.anterior;
		if(fim != null) {
			fim.proximo = null;
		}
		tamanho--;
		return retiraMarca + retiraModelo + retiraCor + retiraPlaca ;
		
	}
	
	public void inicioFim() {
		Automovel auxLocal = inicio;
		System.out.println("--- MARCA --- MODELO ---- COR ---- PLACA ---- ");
		while(auxLocal != null) {
			/*System.out.print(" "+auxLocal.marca+"   "+auxLocal.modelo+"   "+auxLocal.cor+"   "+auxLocal.placa+"\n");*/
			System.out.print(String.format("|%9s|", auxLocal.marca)+String.format("%9s|", auxLocal.modelo)+String.format("%9s|", auxLocal.cor)+String.format("%9s|", auxLocal.placa)+"\n");
			auxLocal = auxLocal.proximo;
		}
		
	}
	
	public void fimInicio() {
		Automovel auxLocal = fim;
		System.out.println("--- MARCA --- MODELO ---- COR ---- PLACA ----");
		while(auxLocal != null) {
			System.out.print(String.format("|%9s|", auxLocal.marca)+String.format("%9s|", auxLocal.modelo)+String.format("%9s|", auxLocal.cor)+String.format("%9s|", auxLocal.placa)+"\n");
			auxLocal = auxLocal.anterior;
		}
		
	}
	
	public void pesquisar(String pesquisa) {
		
		Automovel auxLocal = inicio;
		Automovel auxTrue = new Automovel();
		boolean encontrou = false;
		
		if(inicio == null) {
			System.out.print("A lista está vazia");
		}
		else {
			while(auxLocal != null){
				if(auxLocal.placa.equalsIgnoreCase(pesquisa)) { 
					auxTrue.marca = auxLocal.marca;
					auxTrue.modelo = auxLocal.modelo;
					auxTrue.cor = auxLocal.cor;
					encontrou = true;
				}
				auxLocal = auxLocal.proximo;
				}
			if(encontrou == true) {
				System.out.print("Encontrou o Marca: "+auxTrue.marca+"\n"
						       + "Modelo: "+auxTrue.modelo+"\n"
						       + "Cor: "+auxTrue.cor);
			} else {
				System.out.print("Não encontrado");
			}
		}
				
	} 
	
	
	//Debug
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDupla listaDupla = new ListaDupla();
		
		listaDupla.inserirInicio("FERRARI","AKM12","VERMELHO","KPK556");
		listaDupla.inserirInicio("FORD","F-1000","AZUL","NPC536");
		listaDupla.inicioFim();
		
		System.out.println(" ");
		System.out.println("      ------INSERI NO INICIO------   ");
		listaDupla.inserirInicio("RENAULT", "SANDERO", "CINZA", "KKP444");
		
		listaDupla.inicioFim();
		
		System.out.println(" ");
		System.out.println("      ------INSERI NO MEIO------   ");
		listaDupla.inserirMeio(2, "BUGATTI", "BG556", "AMARELO", "MKM556");
		
		listaDupla.inicioFim();
		
		System.out.println(" ");
		System.out.println("      ------INSERI NO FIM------   ");
		listaDupla.inserirFim( "MAZDA", "M776", "GRAFITE", "TTP335");
		
		listaDupla.inicioFim();
		
		System.out.println(" ");
		System.out.println("      ------RETIREI DO INICIO------   ");
		listaDupla.retirarInicio();
		listaDupla.inicioFim();
		System.out.println(" ");
		
		System.out.println(" ");
		System.out.println("      ------RETIREI DO FIM------   ");
		listaDupla.retirarFim();
		listaDupla.inicioFim();
		
		System.out.println(" ");
		System.out.println("      ------BUSCA PELA PLACA-------");
		listaDupla.pesquisar("NPC53"); // PLACA QUE NAO ESTA NA LISTA
		System.out.println(" ");
		
		System.out.println(" ");
		System.out.println("      ------BUSCA PELA PLACA-------");
		listaDupla.pesquisar("MKM556"); // PLACA DO BUGATT
		System.out.println(" ");
		
		System.out.println(" ");
		System.out.println("      ------BUSCA PELA PLACA-------");
		listaDupla.pesquisar("NPC536"); // PLACA DO FORD
		System.out.println(" ");
		
		System.out.println(" ");
		System.out.println("      ------BUSCA PELA PLACA-------");
		listaDupla.pesquisar("KPK556"); // PLACA DA FERRARI
		System.out.println(" ");
		
		System.out.println(" ");
		System.out.println("      ------LISTA DO FIM AO INICIO------   ");
		listaDupla.fimInicio();
		
	}

}
