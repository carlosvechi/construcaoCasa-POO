package controle;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import visualizacao.EntradaSaida;
import modelo.*;
public class Controladora {

	private Casa casa = null;
	
	public void exibeMenu() {
		int opcao;
		do {
			opcao = EntradaSaida.solicitaOpcao();
			
			switch(opcao) {
			case 0:
				this.casa = new Casa();
				
				String descricao = EntradaSaida.solicitaDescricao("casa", 0);
				String cor = EntradaSaida.solicitaCor();
				int qtdePortas = EntradaSaida.solicitaQtdeAberturas("portas");
				
				if(qtdePortas <= 0) {
					JOptionPane.showMessageDialog(null, "O número de portas não pode ser igual ou menor que zero. ");
					System.exit(0);
				}
				
				int qtdeJanelas = EntradaSaida.solicitaQtdeAberturas("janelas");
				
				if(qtdeJanelas <= 0) {
					JOptionPane.showMessageDialog(null, "O número de janelas não pode ser igual ou menor que zero. ");
					System.exit(0);
				}
				
				ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();
				
				for (int i=0; i<qtdePortas; i++) {
					Porta porta = new Porta();
					porta.setDescricao(EntradaSaida.solicitaDescricao("porta", (i+1)));
					porta.setEstado(EntradaSaida.solicitaEstado("porta"));
					listaDePortas.add(porta);
				}
				
				ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();
				
				for (int i=0; i<qtdeJanelas; i++) {
					Janela janela = new Janela();
					janela.setDescricao(EntradaSaida.solicitaDescricao("janela", (i+1)));
					janela.setEstado(EntradaSaida.solicitaEstado("janela"));
					listaDeJanelas.add(janela);
				}
				
				this.casa.constroiCasa(descricao, cor, listaDePortas, listaDeJanelas);
				
				System.out.println("Descricao da casa: " + casa.getDescricao() + "\n" );
				System.out.println("Cor da casa: " + casa.getCor() + "\n");
				
				for(Aberturas porta: casa.getListaDePortas() ) {
					System.out.println("Descrição da porta: " + porta.getDescricao() + "\n");
					System.out.println("EStado da porta: " + porta.getEstado() + "\n");
				}
				
				for(Aberturas janela: casa.getListaDeJanelas() ) {
					System.out.println("Descricão da janela: " + janela.getDescricao() + "\n");
					System.out.println("Estado da janela: " + janela.getEstado() + "\n");
				}
				
				break;
			case 1:
				String tipoAbertura = EntradaSaida.solicitaTipoAbertura();
				
				ArrayList<Aberturas> listaDeAberturas = new ArrayList<Aberturas>();
				
				if(tipoAbertura.equals("porta")) {
					listaDeAberturas = this.casa.getListaDePortas();
				}else {
					listaDeAberturas = this.casa.getListaDeJanelas();
				}
				
				int indiceAbertura = EntradaSaida.solicitaAberturaMover(listaDeAberturas);
				
				if(indiceAbertura != -1 && indiceAbertura < listaDeAberturas.size()) {
					String novoEstado = EntradaSaida.solicitaEstado(tipoAbertura);
					
					Aberturas abertura = listaDeAberturas.get(indiceAbertura);
					this.casa.moverAbertura(abertura, novoEstado);
					System.out.println("Novo estado da " + tipoAbertura + " : " + abertura.getEstado());
				}else {
					EntradaSaida.exibeMsgAbertura();
				}
				break;
			case 2:
				String informacoes = this.casa.geraInfoCasa();
				EntradaSaida.exibeInfoCasa(informacoes);
				break;
			}
			
		}while(opcao != 3);
		
		EntradaSaida.exibeMsgEncerraPrograma();
		
		System.exit(0);
		
	}
	
}