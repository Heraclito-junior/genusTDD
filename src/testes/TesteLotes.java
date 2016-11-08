package testes;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import NovasFuncionalidades.Desconto;
import NovasFuncionalidades.FuncionalidadesNovas;
import NovasFuncionalidades.Lotes;
import NovasFuncionalidades.VendaContemPromocao;
import NovasFuncionalidades.VendaModificada;
import exception.ProdutoInexistenteException;
import exception.ProdutoNaoEstaNoCarrinhoException;
import exception.QuantidadeInsuficienteException;
import genus.Funcoes;
import genus.Tipos.Funcionario;
import genus.Tipos.Produto;
import genus.Tipos.Venda;

public class TesteLotes {
	
	@Mock
	private FuncionalidadesNovas novasFuncionalidades;
	
	@Mock
	private VendaModificada novaVenda;
	
	List<Produto> listaDeProdutos;
	List<Lotes> listaDeLotes;
	//List<VendaContemPromocao>listaDeVendaContem;
	List<String>lista;
	Date dataAtual;
	
	@SuppressWarnings("deprecation")
	@Before public void initialize() {
    	MockitoAnnotations.initMocks(this);
    	listaDeProdutos=new ArrayList<Produto>();
    	listaDeLotes=new ArrayList<Lotes>();
		//listaDeVendaContem=new ArrayList<VendaContemPromocao>();
		
		Produto auxiliarParaAlocacaoProdutos;
		Lotes auxiliarParaAlocacaoDesconto;
    	
		when(novasFuncionalidades.retornarProdutoPorID(1)).thenReturn(new Produto(1, "tomate", 91, 0.5, 1));
		when(novasFuncionalidades.retornarProdutoPorID(2)).thenReturn(new Produto(2, "laranja", 106, 0.4, 1));
		when(novasFuncionalidades.retornarProdutoPorID(3)).thenReturn(new Produto(3, "mouse", 30, 20.5, 2));
		when(novasFuncionalidades.retornarProdutoPorID(4)).thenReturn(new Produto(4, "teclado", 25, 50.5, 2));
		when(novasFuncionalidades.retornarProdutoPorID(5)).thenReturn(new Produto(5, "detergente", 100, 2.5, 3));
		when(novasFuncionalidades.retornarProdutoPorID(6)).thenReturn(new Produto(6, "sabao", 100, 1.5, 3));
		when(novasFuncionalidades.retornarProdutoPorID(7)).thenReturn(new Produto(7, "absorvente", 70, 19.5, 4));
		when(novasFuncionalidades.retornarProdutoPorID(8)).thenReturn(new Produto(8, "analgesico", 60, 15.5, 4));
		when(novasFuncionalidades.retornarProdutoPorID(9)).thenReturn(new Produto(9, "batom", 50, 15.5, 5));
		when(novasFuncionalidades.retornarProdutoPorID(10)).thenReturn(new Produto(10, "perfume", 25, 25.5, 5));
		

		
		for(int j=1;j<=10;j++){
			auxiliarParaAlocacaoProdutos=novasFuncionalidades.retornarProdutoPorID(j);
			listaDeProdutos.add(auxiliarParaAlocacaoProdutos);
			
		}
		
		
		//tomate
		when(novasFuncionalidades.retornarLotesPorID(1)).thenReturn(new Lotes(1,2,91,0,0,new Date(2016,02,05),new Date(2016, 11,9)));
		//absorvente
		when(novasFuncionalidades.retornarLotesPorID(2)).thenReturn(new Lotes(2,7,60,10,0,new Date(2016,05,05),new Date(2017, 12,23)));
		//analgesico
		when(novasFuncionalidades.retornarLotesPorID(3)).thenReturn(new Lotes(2,8,40,10,0,new Date(2016,05,05),new Date(2016, 07,05)));
		
		
		
		
	
		
		
		for(int j=1;j<=3;j++){
			auxiliarParaAlocacaoDesconto=novasFuncionalidades.retornarLotesPorID(j);
			listaDeLotes.add(auxiliarParaAlocacaoDesconto);
			
		}
		
		
		
		dataAtual=new Date(2016,11,01);
		
       
    }
	
	@Test    
	public void setarLotesTest() {
    	
    	
		Lotes lote;
		List<Lotes> lotesParaEssaInteracao=new ArrayList<Lotes>();
		
		for(int i=0;i<listaDeLotes.size();i++){
			lote=new Lotes(listaDeLotes.get(i));
			
			lotesParaEssaInteracao.add(lote);
		}
		
		FuncionalidadesNovas funionalidadesParaTeste=new FuncionalidadesNovas();
		
		funionalidadesParaTeste.setarLotes(lotesParaEssaInteracao,dataAtual);
		
		assertEquals(lotesParaEssaInteracao.get(0).getQuantidadeAtual(), 91,0.0001);
		assertEquals(lotesParaEssaInteracao.get(0).getQuantidadeVendida(), 0,0.0001);
		assertEquals(lotesParaEssaInteracao.get(0).getQuantidadeDesperdicada(), 0,0.0001);
		
		
		assertEquals(lotesParaEssaInteracao.get(1).getQuantidadeAtual(), 60,0.0001);
		assertEquals(lotesParaEssaInteracao.get(1).getQuantidadeVendida(), 10,0.0001);
		assertEquals(lotesParaEssaInteracao.get(1).getQuantidadeDesperdicada(), 0,0.0001);
		
		assertEquals(lotesParaEssaInteracao.get(2).getQuantidadeAtual(), 0,0.0001);
		assertEquals(lotesParaEssaInteracao.get(2).getQuantidadeVendida(), 10,0.0001);
		assertEquals(lotesParaEssaInteracao.get(2).getQuantidadeDesperdicada(), 40,0.0001);
		
		
	}
	
	
	
	@Test    
	public void venderLotesTest() {
    	
    	
		Lotes lote;
		List<Lotes> lotesParaEssaInteracao=new ArrayList<Lotes>();
		
		for(int i=0;i<listaDeLotes.size();i++){
			lote=new Lotes(listaDeLotes.get(i));
			
			lotesParaEssaInteracao.add(lote);
		}
		
		FuncionalidadesNovas funionalidadesParaTeste=new FuncionalidadesNovas();
		
		funionalidadesParaTeste.setarLotes(lotesParaEssaInteracao,dataAtual);
		
		VendaModificada vendaTestaFinal=new VendaModificada();
		FuncionalidadesNovas funcionalidadesTeste= new FuncionalidadesNovas();
		
		vendaTestaFinal.setEstoque(listaDeProdutos);
		
		Produto produtoParaAdicionarVenda;
		
		produtoParaAdicionarVenda=listaDeProdutos.get(0);
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3);
		
		produtoParaAdicionarVenda=listaDeProdutos.get(9);
		
		
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 2);
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(5);
		
		
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3);
		
		vendaTestaFinal.finalizarVendaComLotes(1, 1, 1, dataAtual,lotesParaEssaInteracao );
		
		
		assertEquals(57,vendaTestaFinal.getValorTotal(),0.001);
		
		
		assertEquals(lotesParaEssaInteracao.get(0).getQuantidadeAtual(), 88,0.0001);
		assertEquals(lotesParaEssaInteracao.get(0).getQuantidadeVendida(),3,0.0001);
		


	}
	
	@Test    
	public void venderLotesTestVariasVendas() {
    	
    	
		Lotes lote;
		List<Lotes> lotesParaEssaInteracao=new ArrayList<Lotes>();
		
		for(int i=0;i<listaDeLotes.size();i++){
			lote=new Lotes(listaDeLotes.get(i));
			
			lotesParaEssaInteracao.add(lote);
		}
		
		FuncionalidadesNovas funionalidadesParaTeste=new FuncionalidadesNovas();
		
		funionalidadesParaTeste.setarLotes(lotesParaEssaInteracao,dataAtual);

		
		
		VendaModificada vendaTestaFinal=new VendaModificada();
		FuncionalidadesNovas funcionalidadesTeste= new FuncionalidadesNovas();
		
		vendaTestaFinal.setEstoque(listaDeProdutos);
		
		Produto produtoParaAdicionarVenda;
		
		produtoParaAdicionarVenda=listaDeProdutos.get(0);
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3);
		
		produtoParaAdicionarVenda=listaDeProdutos.get(9);
		
		
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 2);
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(5);
		
		
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3);
		
		vendaTestaFinal.finalizarVendaComLotes(1, 1, 1, dataAtual,lotesParaEssaInteracao );
		
		
		assertEquals(57,vendaTestaFinal.getValorTotal(),0.001);
		
		
		assertEquals(lotesParaEssaInteracao.get(0).getQuantidadeAtual(), 88,0.0001);
		assertEquals(lotesParaEssaInteracao.get(0).getQuantidadeVendida(),3,0.0001);
		
		vendaTestaFinal=new VendaModificada();
		
		funcionalidadesTeste= new FuncionalidadesNovas();
		
		vendaTestaFinal.setEstoque(listaDeProdutos);
		
		produtoParaAdicionarVenda=new Produto();
		
		produtoParaAdicionarVenda=listaDeProdutos.get(0);
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3);
		
		produtoParaAdicionarVenda=listaDeProdutos.get(9);
		
		
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 2);
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(5);
		
		
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3);
		
		vendaTestaFinal.finalizarVendaComLotes(1, 1, 1, dataAtual,lotesParaEssaInteracao );
		
		
		assertEquals(57,vendaTestaFinal.getValorTotal(),0.001);
		
		assertEquals(lotesParaEssaInteracao.get(0).getIdProduto(), 85.0,0.0001);
		assertEquals(lotesParaEssaInteracao.get(0).getQuantidadeAtual(), 85.0,0.0001);
		assertEquals(lotesParaEssaInteracao.get(0).getQuantidadeVendida(),6.0,0.0001);


	}
	
	
	 
	
	
	
	
	
	

}
