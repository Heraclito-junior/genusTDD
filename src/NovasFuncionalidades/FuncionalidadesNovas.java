/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NovasFuncionalidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exception.ProdutoInexistenteException;
import genus.Tipos.Produto;
import genus.Tipos.Venda;

/**
 *
 * @author Heráclito Júnior
 */
public class FuncionalidadesNovas {
	
	public FuncionalidadesNovas(){
		
	}
	
	
	public Produto retornarProdutoPorID(int idProduto){
		
		throw new UnsupportedOperationException();
		
		
	}
	
	public FuncionarioModificado retornarFuncionarioPorID(int idFunc){
		
		throw new UnsupportedOperationException();
		
		
	}
	
	public Faltas retornarFaltaPorID(int idFalta){
		
		throw new UnsupportedOperationException();
		
		
	}
	
	
	public Desconto retornarDescontoPorID(int idDesconto){
		
		throw new UnsupportedOperationException();
		
		
	}
	
	public Lotes retornarLotesPorID(int idLote){
		
		throw new UnsupportedOperationException();
		
		
	}
	
	public Produto calcularDescontoProduto(Produto produtoParaCalcular,List<Desconto> listaDeDescontosParaCalcular,List<Produto> listaEstoque){
		Produto produtoRetornado=new Produto();
		int achouDesconto=-1;
		
		if(!(listaEstoque.contains(produtoParaCalcular))){
			
			throw new ProdutoInexistenteException();
		}
		
		for(int i=0;i<listaDeDescontosParaCalcular.size();i++){
			if(listaDeDescontosParaCalcular.get(i).getIDProduto()==produtoParaCalcular.getIDproduto()){
				achouDesconto=i;
				break;
			}			
		}
		if(achouDesconto!=-1){
			double proporcaoDesconto=(1-(listaDeDescontosParaCalcular.get(achouDesconto).getPorcentagem()));
			double armazenarResultado=produtoParaCalcular.getPreco()*proporcaoDesconto;
			produtoRetornado.setIDproduto(produtoParaCalcular.getIDproduto());
			produtoRetornado.setNome(produtoParaCalcular.getNome());
			produtoRetornado.setQuantidade(produtoParaCalcular.getQuantidade());
			produtoRetornado.setIDCategoria(produtoParaCalcular.getIDCategoria());
			produtoRetornado.setPreco(armazenarResultado);
			
			return produtoRetornado;
			
		}
		produtoRetornado.setIDproduto(produtoParaCalcular.getIDproduto());
		produtoRetornado.setNome(produtoParaCalcular.getNome());
		produtoRetornado.setQuantidade(produtoParaCalcular.getQuantidade());
		produtoRetornado.setIDCategoria(produtoParaCalcular.getIDCategoria());
		produtoRetornado.setPreco(produtoParaCalcular.getPreco());
		
		return produtoRetornado;
		
		
		
	}
	

	

	
	
	
	public List<VendaContemPromocao> setarVendaContem(VendaModificada novaVenda,List<Desconto> listaDescontos){
		List<VendaContemPromocao> novoVendaContem=new ArrayList<VendaContemPromocao>();
		List<Produto> carrinho=new ArrayList<Produto>();
		List<Produto> estoque=new ArrayList<Produto>();
		carrinho=novaVenda.getListaDeProdutos();
		estoque=novaVenda.getEstoque();
		
		boolean descontoEncontradoInteracao=false;
		int idDaPromocao=-1;
		int PosicaoDesconto=-1;
		for(int i=0;i<carrinho.size();i++){
			idDaPromocao=-1;
			PosicaoDesconto=-1;
			descontoEncontradoInteracao=false;
			for(int j=0;j<listaDescontos.size();j++){
				if(carrinho.get(i).getIDproduto()==listaDescontos.get(j).getIDProduto()){
					idDaPromocao=listaDescontos.get(j).IDdesconto;
					PosicaoDesconto=j;
				}
			}
			
			
			if(idDaPromocao==-1){
				int interador=-1;
				
				for(int k=0;k<estoque.size();k++){
					if(carrinho.get(i).getIDproduto()==estoque.get(k).getIDproduto()){
						interador=k;
					}
				}
				
				double precoNormal=estoque.get(interador).getPreco();
				novoVendaContem.add(new VendaContemPromocao(novaVenda.getIDvenda(), carrinho.get(i).getIDproduto(), novaVenda.getQuantidadeDeProdutos().get(i), precoNormal, precoNormal, 0));
			}else{
				int interador=-1;
				
				for(int k=0;k<estoque.size();k++){
					if(carrinho.get(i).getIDproduto()==estoque.get(k).getIDproduto()){
						interador=k;
					}
				}
				double precoNormal=estoque.get(interador).getPreco();
				
				
				novoVendaContem.add(new VendaContemPromocao(novaVenda.getIDvenda(), carrinho.get(i).getIDproduto(), novaVenda.getQuantidadeDeProdutos().get(i), precoNormal,carrinho.get(i).getPreco() ,idDaPromocao));
			}
			
			
		}
		return novoVendaContem;
				
		
	}
	public void setarLotes(List<Lotes> listaLotes,Date dataAtual){
		Date dataFimlote=new Date();
		double quantidadeAtual;
		for(int i=0;i<listaLotes.size();i++){
			dataFimlote=listaLotes.get(i).getDataFimLote();
			if(dataFimlote.before(dataAtual)){
				quantidadeAtual=listaLotes.get(i).getQuantidadeAtual();
				listaLotes.get(i).setQuantidadeAtual(0);
				listaLotes.get(i).setQuantidadeDesperdicada(quantidadeAtual);
			}
		}
				
	}
	
	public int CalcularDiasTrabalhoNoMes(int ano, int mes, FuncionarioModificado func){
		
		String diasTrabalho=func.getDiasTrabalho();
		String[] parts = diasTrabalho.split("-");
		
		int totalDias=0;
		
		int quantosDiasTemOMes=0;
		
		int diaSemana;
		
		if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12){
			quantosDiasTemOMes=31;
		}
		
		if(mes==4||mes==6||mes==9||mes==11){
			quantosDiasTemOMes=31;
		}
		if(mes==2){
			if(ano % 400 == 0){
				quantosDiasTemOMes=29;

	        } else if((ano % 4 == 0) && (ano % 100 != 0)){
				quantosDiasTemOMes=29;

	        } else{
				quantosDiasTemOMes=28;
	        }
		}
		
		
		for(int i=0;i<quantosDiasTemOMes;i++){
			for(int k=0;k<parts.length;k++){
				
				Date dataFalsa=new Date(ano,mes,i);
				diaSemana=dataFalsa.getDay();
				String diaFuncionario=parts[k];
				System.out.println("falsa" + diaSemana + "DiaFunc "+ diaFuncionario);
				if(diaSemana==0&&diaFuncionario.equalsIgnoreCase("DO")){
					totalDias++;
				}
				if(diaSemana==1 && diaFuncionario.equalsIgnoreCase("SG")){
					totalDias++;
				}
				if(diaSemana==2 && diaFuncionario.equalsIgnoreCase("TE")){
					totalDias++;
				}
				if(diaSemana==3 && diaFuncionario.equalsIgnoreCase("QA")){
					totalDias++;
				}
				if(diaSemana==4 && diaFuncionario.equalsIgnoreCase("QI")){
					totalDias++;
				}
				if(diaSemana==5 && diaFuncionario.equalsIgnoreCase("SE")){
					totalDias++;
				}
				if(diaSemana==6 && diaFuncionario.equalsIgnoreCase("SA")){
					totalDias++;
				}
				  
			}
		}
		return totalDias;
	}


	public int CalcularDiasTrabalhoNoMesComFalta(int ano, int mes, FuncionarioModificado func,
		List<Faltas> listaFaltas) {
		int diasFaltados=0;
		List<Faltas> listaFiltrada=new ArrayList<Faltas>();
		for(int i=0;i<listaFaltas.size();i++){
			if(listaFaltas.get(i).getDataFalta().getYear()==ano&& listaFaltas.get(i).getDataFalta().getMonth()==mes){
				Faltas faltaParaFiltrar=listaFaltas.get(i);
				listaFiltrada.add(new Faltas(faltaParaFiltrar));
				diasFaltados++;
			}
		}
		
		for(int i=0;i<listaFiltrada.size();i++){
			
		}
		
		
		String diasTrabalho=func.getDiasTrabalho();
		String[] parts = diasTrabalho.split("-");
		
		int totalDias=0;
		
		int quantosDiasTemOMes=0;
		
		int diaSemana;
		
		if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12){
			quantosDiasTemOMes=31;
		}
		
		if(mes==4||mes==6||mes==9||mes==11){
			quantosDiasTemOMes=31;
		}
		if(mes==2){
			if(ano % 400 == 0){
				quantosDiasTemOMes=29;

	        } else if((ano % 4 == 0) && (ano % 100 != 0)){
				quantosDiasTemOMes=29;

	        } else{
				quantosDiasTemOMes=28;
	        }
		}
		
		for(int i=0;i<quantosDiasTemOMes;i++){
			for(int k=0;k<parts.length;k++){
				
				Date dataFalsa=new Date(ano,mes,i);
				diaSemana=dataFalsa.getDay();
				String diaFuncionario=parts[k];
				System.out.println("falsa" + diaSemana + "DiaFunc "+ diaFuncionario);
				if(diaSemana==0&&diaFuncionario.equalsIgnoreCase("DO")){
					totalDias++;
				}
				if(diaSemana==1 && diaFuncionario.equalsIgnoreCase("SG")){
					totalDias++;
				}
				if(diaSemana==2 && diaFuncionario.equalsIgnoreCase("TE")){
					totalDias++;
				}
				if(diaSemana==3 && diaFuncionario.equalsIgnoreCase("QA")){
					totalDias++;
				}
				if(diaSemana==4 && diaFuncionario.equalsIgnoreCase("QI")){
					totalDias++;
				}
				if(diaSemana==5 && diaFuncionario.equalsIgnoreCase("SE")){
					totalDias++;
				}
				if(diaSemana==6 && diaFuncionario.equalsIgnoreCase("SA")){
					totalDias++;
				}
				  
			}
		}
		return totalDias-diasFaltados;
		
		// TODO Auto-generated method stub
	}
	public void adicionarFalta(List<Faltas> listaDeFaltas, FuncionarioModificado Func,Date diaAtual){
		throw new UnsupportedOperationException();
	}


	


	


	
	

	
	
	
}
