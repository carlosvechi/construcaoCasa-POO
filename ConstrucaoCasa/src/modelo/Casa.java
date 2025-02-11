package modelo;
import java.util.ArrayList;
public class Casa {

	private String descricao;
	private String cor;
	private ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();
	private ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();
	
	
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public ArrayList<Aberturas> getListaDePortas(){
		return listaDePortas;
	}
	
	public void setListaDePortas(ArrayList<Aberturas> ListaDePortas) {
		this.listaDePortas = ListaDePortas;
	}
	
	public ArrayList<Aberturas> getListaDeJanelas(){
		return listaDeJanelas;
	}
	
	public void setListaDeJanelas(ArrayList<Aberturas> ListaDeJanelas) {
		this.listaDeJanelas = ListaDeJanelas;
	}
	
	public void constroiCasa(String descricao, String cor, ArrayList<Aberturas> listaDePortas,
							ArrayList<Aberturas> listaDeJanelas) {
		setDescricao(descricao);
		setCor(cor);
		setListaDePortas(listaDePortas);
		setListaDeJanelas(listaDeJanelas);
	}
	
	public Aberturas retornaAbertura(int posicao, String tipoAbertura) {
		if(tipoAbertura.equals("porta")) {
			return this.listaDePortas.get(posicao);
		}else {
			return this.listaDeJanelas.get(posicao);
		}
	}
	
	public void moverAbertura(Aberturas abertura, String novoEstado) {
		abertura.setEstado(novoEstado);
	}
	
	public String geraInfoCasa() {
		String informacoes = "Descrição: " + this.descricao+"\nCor: " + this.cor+"\nLista de portas:\n";
		
		for(Aberturas abertura:this.listaDePortas) {
			informacoes += abertura.getDescricao() + "Estado: " + abertura.getEstado() + "\n";
		}
		
		informacoes += "\nLista de janelas:\n";
		
		for(Aberturas abertura:this.listaDeJanelas) {
			informacoes += abertura.getDescricao() + " Estado: " + abertura.getEstado()+ "\n";
		}
		
		return informacoes;
	}
	
}
