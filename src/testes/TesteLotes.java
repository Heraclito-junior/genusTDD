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
import NovasFuncionalidades.VendaModificadaLotes;
import exception.CombProdutoLoteInvalidoException;
import exception.LoteExpiradoException;
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
		
		//Nenhum lote
		when(novasFuncionalidades.retornarLotesPorID(0)).thenReturn(new Lotes(1,0,0,0,0,new Date(1900,01,01),new Date(4000, 01,01) ));
		//tomate
		when(novasFuncionalidades.retornarLotesPorID(1)).thenReturn(new Lotes(2,1,91,0,0,new Date(2016,02,05),new Date(2016, 11,9) ));
		//absorvente
		when(novasFuncionalidades.retornarLotesPorID(2)).thenReturn(new Lotes(3,7,60,10,0,new Date(2016,05,05),new Date(2017, 12,23)));
		//analgesico
		when(novasFuncionalidades.retornarLotesPorID(3)).thenReturn(new Lotes(4,8,40,10,0,new Date(2016,05,05),new Date(2016, 07,05)));
		
		
		
		
	
		
		
		for(int j=0;j<=3;j++){
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
		
		assertEquals(lotesParaEssaInteracao.get(1).getQuantidadeAtual(), 91,0.0001);
		assertEquals(lotesParaEssaInteracao.get(1).getQuantidadeVendida(), 0,0.0001);
		assertEquals(lotesParaEssaInteracao.get(1).getQuantidadeDesperdicada(), 0,0.0001);
		
		
		assertEquals(lotesParaEssaInteracao.get(2).getQuantidadeAtual(), 60,0.0001);
		assertEquals(lotesParaEssaInteracao.get(2).getQuantidadeVendida(), 10,0.0001);
		assertEquals(lotesParaEssaInteracao.get(2).getQuantidadeDesperdicada(), 0,0.0001);
		
		assertEquals(lotesParaEssaInteracao.get(3).getQuantidadeAtual(), 0,0.0001);
		assertEquals(lotesParaEssaInteracao.get(3).getQuantidadeVendida(), 10,0.0001);
		assertEquals(lotesParaEssaInteracao.get(3).getQuantidadeDesperdicada(), 40,0.0001);
		
		
	}
	
	@Test(expected=CombProdutoLoteInvalidoException.class)    
	public void venderAdicionarVendaLoteInvalido() {
    	
    	
		Lotes lote;
		Produto produtoParaAdicionarVenda;
		List<Lotes> lotesParaEssaInteracao=new ArrayList<Lotes>();
		
		for(int i=0;i<listaDeLotes.size();i++){
			lote=new Lotes(listaDeLotes.get(i));
			
			lotesParaEssaInteracao.add(lote);
		}
		
		
		
		FuncionalidadesNovas funionalidadesParaTeste=new FuncionalidadesNovas();
		
		funionalidadesParaTeste.setarLotes(lotesParaEssaInteracao,dataAtual);
		
		VendaModificadaLotes vendaTestaFinal=new VendaModificadaLotes();
		vendaTestaFinal.setDataVenda(dataAtual);
		
		
		funionalidadesParaTeste.setarLotes(lotesParaEssaInteracao, dataAtual);
		
		vendaTestaFinal.setEstoque(listaDeProdutos);
		
		vendaTestaFinal.setLotes(lotesParaEssaInteracao);
		
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(0);
		
		lote=novasFuncionalidades.retornarLotesPorID(2);
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3,lote);
		
		


	}
	
	@Test(expected=LoteExpiradoException.class)    
	public void venderAdicionarVendaLoteExpirado() {
    	
    	
		Lotes lote;
		Produto produtoParaAdicionarVenda;
		List<Lotes> lotesParaEssaInteracao=new ArrayList<Lotes>();
		
		for(int i=0;i<listaDeLotes.size();i++){
			lote=new Lotes(listaDeLotes.get(i));
			
			lotesParaEssaInteracao.add(lote);
		}
		
		
		
		FuncionalidadesNovas funionalidadesParaTeste=new FuncionalidadesNovas();
		
		funionalidadesParaTeste.setarLotes(lotesParaEssaInteracao,dataAtual);
		
		VendaModificadaLotes vendaTestaFinal=new VendaModificadaLotes();
		vendaTestaFinal.setDataVenda(dataAtual);
		
		
		funionalidadesParaTeste.setarLotes(lotesParaEssaInteracao, dataAtual);
		
		vendaTestaFinal.setEstoque(listaDeProdutos);
		
		vendaTestaFinal.setLotes(lotesParaEssaInteracao);
		
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(8);
		
		lote=novasFuncionalidades.retornarLotesPorID(3);
		
		
		vendaTestaFinal.setDataVenda(dataAtual);
		
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3,lote);
		
		


	}
	
	
	
	
	

	
	@Test    
	public void venderLotesTest() {
    	
    	
		Lotes lote;
		Produto produtoParaAdicionarVenda;
		List<Lotes> lotesParaEssaInteracao=new ArrayList<Lotes>();
		
		for(int i=0;i<listaDeLotes.size();i++){
			lote=new Lotes(listaDeLotes.get(i));
			
			lotesParaEssaInteracao.add(lote);
		}
		
		FuncionalidadesNovas funionalidadesParaTeste=new FuncionalidadesNovas();
		
		funionalidadesParaTeste.setarLotes(lotesParaEssaInteracao,dataAtual);
		
		VendaModificadaLotes vendaTestaFinal=new VendaModificadaLotes();
		vendaTestaFinal.setDataVenda(dataAtual);
		
		
		funionalidadesParaTeste.setarLotes(lotesParaEssaInteracao, dataAtual);
		
		vendaTestaFinal.setEstoque(listaDeProdutos);
		
		vendaTestaFinal.setLotes(lotesParaEssaInteracao);
		
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(0);
		
		lote=novasFuncionalidades.retornarLotesPorID(1);
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3,lote);
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(9);
		
		lote=novasFuncionalidades.retornarLotesPorID(0);

		
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 2,lote);
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(5);
		
		lote=novasFuncionalidades.retornarLotesPorID(0);
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3,lote);
		
		vendaTestaFinal.finalizarVendaComLotes(1, 1, 1, dataAtual);
		
		
		assertEquals(57,vendaTestaFinal.getValorTotal(),0.001);
		
		
		assertEquals(vendaTestaFinal.getLotes().get(1).getQuantidadeAtual(), 88,0.0001);
		assertEquals(vendaTestaFinal.getLotes().get(1).getQuantidadeVendida(), 3.0,0.0001);
		


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
		

		
		
		VendaModificadaLotes vendaTestaFinal=new VendaModificadaLotes();
		FuncionalidadesNovas funcionalidadesTeste= new FuncionalidadesNovas();
		vendaTestaFinal.setDataVenda(dataAtual);
		
		vendaTestaFinal.setEstoque(listaDeProdutos);
		vendaTestaFinal.setLotes(lotesParaEssaInteracao);
		
		Produto produtoParaAdicionarVenda;
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(0);
		
		lote=novasFuncionalidades.retornarLotesPorID(1);
		
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3,lote);
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(9);
		
		lote=novasFuncionalidades.retornarLotesPorID(0);

		
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 2,lote);
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(5);
		
		lote=novasFuncionalidades.retornarLotesPorID(0);
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3,lote);
		
		vendaTestaFinal.finalizarVendaComLotes(1, 1, 1, dataAtual);
		
		
		assertEquals(57,vendaTestaFinal.getValorTotal(),0.001);
		
		
		assertEquals(vendaTestaFinal.getLotes().get(1).getQuantidadeAtual(), 88,0.0001);
		assertEquals(vendaTestaFinal.getLotes().get(1).getQuantidadeVendida(), 3.0,0.0001);
		
		List<Lotes> listaLotesAtuais=vendaTestaFinal.getLotes();
		
		vendaTestaFinal=new VendaModificadaLotes();
		vendaTestaFinal.setEstoque(listaDeProdutos);
		vendaTestaFinal.setLotes(listaLotesAtuais);
		vendaTestaFinal.setDataVenda(dataAtual);
		
		produtoParaAdicionarVenda=listaDeProdutos.get(0);
		
		lote=novasFuncionalidades.retornarLotesPorID(1);
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3,lote);
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(9);
		
		lote=novasFuncionalidades.retornarLotesPorID(0);

		
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 2,lote);
		
		
		produtoParaAdicionarVenda=listaDeProdutos.get(5);
		
		lote=novasFuncionalidades.retornarLotesPorID(0);
		
		vendaTestaFinal.adicionarAVenda(produtoParaAdicionarVenda, 3,lote);
		
		vendaTestaFinal.finalizarVendaComLotes(1, 1, 1, dataAtual);
		
		
		assertEquals(57,vendaTestaFinal.getValorTotal(),0.001);
		
		
		assertEquals(vendaTestaFinal.getLotes().get(1).getQuantidadeAtual(), 85,0.0001);
		assertEquals(vendaTestaFinal.getLotes().get(1).getQuantidadeVendida(), 6.0,0.0001);


	}
	
	
	
	 
	
	
	
	
	
	

}

