package testes;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.activity.InvalidActivityException;
import javax.management.BadAttributeValueExpException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mysql.fabric.xmlrpc.base.Data;

import NovasFuncionalidades.Desconto;
import NovasFuncionalidades.FuncionalidadesNovas;
import NovasFuncionalidades.VendaContemPromocao;
import NovasFuncionalidades.VendaModificada;
import genus.Funcoes;
import genus.Tipos.Funcionario;
import genus.Tipos.Produto;
import genus.Tipos.Venda;

public class TestePromocoes {
	
	
	
	@Mock
	private FuncionalidadesNovas novasFuncionalidades;
	
	@Mock
	private VendaModificada novaVenda;
	
	List<Produto> listaDeProdutos;
	List<Desconto>listaDeDescontos;
	//List<VendaContemPromocao>listaDeVendaContem;
	List<String>lista;
	Date dataAtual;
	
	
	
    @SuppressWarnings("deprecation")
	@Before public void initialize() {
    	MockitoAnnotations.initMocks(this);
    	listaDeProdutos=new ArrayList<Produto>();
		listaDeDescontos=new ArrayList<Desconto>();
		//listaDeVendaContem=new ArrayList<VendaContemPromocao>();
		
		Produto auxiliarParaAlocacaoProdutos;
		Desconto auxiliarParaAlocacaoDesconto;
    	
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
		
		
		
		when(novasFuncionalidades.retornarDescontoPorID(0)).thenReturn(new Desconto(0,0,1,"Nenhum"));
		when(novasFuncionalidades.retornarDescontoPorID(1)).thenReturn(new Desconto(1,1,0.2,"Liquidacao de Tomate"));
		when(novasFuncionalidades.retornarDescontoPorID(2)).thenReturn(new Desconto(2,5,0.4,"Liquidacao de Sabão"));
		
		
		for(int j=1;j<=2;j++){
			auxiliarParaAlocacaoDesconto=novasFuncionalidades.retornarDescontoPorID(j);
			listaDeDescontos.add(auxiliarParaAlocacaoDesconto);
			
		}
		
		
		
		dataAtual=new Date(2016,11,01);
    	
       
    }
    
    
    @Test
	public void testAdicionarProduto() {
		VendaModificada vendaTestaAdd=new VendaModificada();
		vendaTestaAdd.setEstoque(listaDeProdutos);
		Produto produtoParaTestarAdd=listaDeProdutos.get(3);
		
		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 3);
		assertEquals(vendaTestaAdd.getListaDeProdutos().get(0).getNome(),"mouse");
		
	}
    
    @Test(expected=BadAttributeValueExpException.class)
	public void testAdicionarProdutoInexistente() {
		VendaModificada vendaTestaAdd=new VendaModificada();
		vendaTestaAdd.setEstoque(listaDeProdutos);
		Produto produtoParaTestarAdd=listaDeProdutos.get(3);
		
		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 3);
		
	}
    
    
    @Test(expected=InvalidActivityException.class)
    public void testAdicionarProdutoInsuficiente() {
		VendaModificada vendaTestaAdd=new VendaModificada();
		vendaTestaAdd.setEstoque(listaDeProdutos);
		Produto produtoParaTestarAdd=listaDeProdutos.get(3);
		
		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 1000000);
		
	}
    
    
    @Test
    public void testAdicionarAumentarQuantidadeProduto() {
		VendaModificada vendaTestaAdd=new VendaModificada();
		vendaTestaAdd.setEstoque(listaDeProdutos);
		Produto produtoParaTestarAdd=listaDeProdutos.get(3);
		
		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 3);
		assertEquals(vendaTestaAdd.getQuantidadeDeProdutos().get(0),3,0.001);
		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 2);
		assertEquals(vendaTestaAdd.getQuantidadeDeProdutos().get(0),5,0.001);
		
	}   
    
    @Test    
	public void testAdicionarVariosProdutos() {
		VendaModificada vendaTestaAdd=new VendaModificada();
		vendaTestaAdd.setEstoque(listaDeProdutos);
		Produto produtoParaTestarAdd=listaDeProdutos.get(2);
		
		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 3);
		assertEquals(vendaTestaAdd.getListaDeProdutos().get(0).getNome(),"mouse");
		
		produtoParaTestarAdd=listaDeProdutos.get(2);
		
		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 4);
		assertEquals(vendaTestaAdd.getListaDeProdutos().get(1).getNome(),"laranja");
		
		
		
	}
    
    
    
    @Test
   	public void testRemoverProdutoVenda() {
   		VendaModificada vendaTestaAdd=new VendaModificada();
   		Produto produtoParaTestarAdd=listaDeProdutos.get(2);
   		vendaTestaAdd.setEstoque(listaDeProdutos);
   		
   		
   		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 3);
   		
   		produtoParaTestarAdd=listaDeProdutos.get(2);
   		
   		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 4);
   		vendaTestaAdd.removerDaVenda(produtoParaTestarAdd, 3);
   		
   		assertEquals(vendaTestaAdd.getListaDeProdutos().get(0).getNome(),"mouse");
   		assertEquals(vendaTestaAdd.getQuantidadeDeProdutos().get(0),1,0.001);
   		
   		
   		
   	}
    
    @Test(expected=BadAttributeValueExpException.class)
   	public void testRemoverProdutoInexistente() {
   		VendaModificada vendaTestaAdd=new VendaModificada();
   		vendaTestaAdd.setEstoque(listaDeProdutos);
   		Produto produtoParaTestarAdd=listaDeProdutos.get(2);
   		
   		
   		
   		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 3);
   		
   		produtoParaTestarAdd=listaDeProdutos.get(2);
   		
   		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 4);
   		vendaTestaAdd.removerDaVenda(produtoParaTestarAdd, 3);
   		
   		assertEquals(vendaTestaAdd.getListaDeProdutos().get(0).getNome(),"mouse");
   		assertEquals(vendaTestaAdd.getQuantidadeDeProdutos().get(0),1,0.001);
   		
   		
   		
   	}
    
    @Test(expected=InvalidActivityException.class)
   	public void testRemoverProdutoInsuficiente() {
   		VendaModificada vendaTestaAdd=new VendaModificada();
   		vendaTestaAdd.setEstoque(listaDeProdutos);
   		Produto produtoParaTestarAdd=listaDeProdutos.get(2);
   		
   		
   		
   		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 3);
   		
   		produtoParaTestarAdd=listaDeProdutos.get(2);
   		
   		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 4);
   		vendaTestaAdd.removerDaVenda(produtoParaTestarAdd, 3);
   		
   		assertEquals(vendaTestaAdd.getListaDeProdutos().get(0).getNome(),"mouse");
   		assertEquals(vendaTestaAdd.getQuantidadeDeProdutos().get(0),1,0.001);
   		
   		
   		
   	}
    
    @Test
	public void testDiminuirProdutoVenda() {
		VendaModificada vendaTestaAdd=new VendaModificada();
		vendaTestaAdd.setEstoque(listaDeProdutos);
		Produto produtoParaTestarAdd=listaDeProdutos.get(2);
		
		
		
		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 3);
		
		produtoParaTestarAdd=listaDeProdutos.get(2);
		
		vendaTestaAdd.adicionarAVenda(produtoParaTestarAdd, 4);
		vendaTestaAdd.removerDaVenda(produtoParaTestarAdd, 2.0);
		
		assertEquals(vendaTestaAdd.getListaDeProdutos().get(0).getNome(),"mouse");
		assertEquals(vendaTestaAdd.getQuantidadeDeProdutos().get(0),1,0.001);
		
		
		
	}
    
    @Test    
	public void testAdicionarProdutoDescontado() {
		VendaModificada vendaTestaDesconto=new VendaModificada();
		vendaTestaDesconto.setEstoque(listaDeProdutos);
		
		Produto produtoParaTestarDesconto=listaDeProdutos.get(0);
		
		FuncionalidadesNovas funcionalidadesTeste= new FuncionalidadesNovas();
		
		
		Produto produtoParaReceberProdutoDescontado=new Produto();
		produtoParaReceberProdutoDescontado=funcionalidadesTeste.calcularDescontoProduto(produtoParaTestarDesconto, listaDeDescontos);
		
		vendaTestaDesconto.adicionarAVenda(produtoParaReceberProdutoDescontado, 3);
		assertEquals(vendaTestaDesconto.getListaDeProdutos().get(0).getPreco(),0.4,0.001);

	}
    
    
    
    
    @Test    
	public void testFinalizarVenda() {
    	
    	
		VendaModificada vendaTestaFinal=new VendaModificada();
		
		vendaTestaFinal.setEstoque(listaDeProdutos);
		
		Produto produtoParaTestarDesconto=listaDeProdutos.get(0);
		
		FuncionalidadesNovas funcionalidadesTeste= new FuncionalidadesNovas();

		
		Produto produtoParaReceberProdutoDescontado=new Produto();
		produtoParaReceberProdutoDescontado=funcionalidadesTeste.calcularDescontoProduto(produtoParaTestarDesconto, listaDeDescontos);
		
		vendaTestaFinal.adicionarAVenda(produtoParaReceberProdutoDescontado, 3);
		
		vendaTestaFinal.finalizarVenda(1, 1, 1, dataAtual);
		
		
		
		
		assertEquals(vendaTestaFinal.getValorTotal(),0.4,0.001);

	}
    
    
    @Test    
	public void testFinalizarVendaContem() {
    	List <VendaContemPromocao> vendaContem=new ArrayList<VendaContemPromocao>();
    	
    	
		VendaModificada vendaTestaFinal=new VendaModificada();
		
		vendaTestaFinal.setEstoque(listaDeProdutos);
		
		Produto produtoParaTestarDesconto=listaDeProdutos.get(0);
		
		FuncionalidadesNovas funcionalidadesTeste= new FuncionalidadesNovas();

		
		Produto produtoParaReceberProdutoDescontado=new Produto();
		produtoParaReceberProdutoDescontado=funcionalidadesTeste.calcularDescontoProduto(produtoParaTestarDesconto, listaDeDescontos);
		
		vendaTestaFinal.adicionarAVenda(produtoParaReceberProdutoDescontado, 3);
		
		
		assertEquals(vendaTestaFinal.getValorTotal(),0.4,0.001);
		
		vendaContem=funcionalidadesTeste.setarVendaContem(vendaTestaFinal, listaDeDescontos);
		
		assertEquals(vendaContem.size(),1);
		

	}
    
    
    
    
	
	
	
	

}
