package com.bdmysql.connectionBD.contatos;

import javax.swing.*;
import java.util.List;

public class AgendaDeContatos {
	
	static ContatoBD dao;
	
	public static void conectarBD(){
		// grave nessa conexão!!
		 dao = new ContatoBD();

	}
	
	public static void inserirContato(){

		String nome = JOptionPane.showInputDialog("Digite o nome:");
		String email = JOptionPane.showInputDialog("Digite o email:");
		String endereco = JOptionPane.showInputDialog("Digite o endereco:");
		String telefone = JOptionPane.showInputDialog("Digite o telefone:");
		
		// pronto para gravar
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setTelefone(telefone);
		// método elegante
		dao.adiciona(contato);

		System.out.println("Gravado!");
	}
	
	public static void listarContatos(){
		List<Contato> contatos = dao.getLista();

		for (Contato c : contatos) {
			System.out.println("Nome: " + c.getNome());
			System.out.println("Email: " + c.getEmail());
			System.out.println("Endereço: " + c.getEndereco());
			System.out.println("Telfone: " +  c.getTelefone() + "\n");
		}
	}
	
	public static void alterarContato(){

		
		String nome = JOptionPane.showInputDialog("Digite o nome:");
		String email = JOptionPane.showInputDialog("Digite o email:");
		String endereco = JOptionPane.showInputDialog("Digite o endereco:");
		String telefone = JOptionPane.showInputDialog("Digite o telefone:");
		
		// pronto para gravar
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setTelefone(telefone);

		// método elegante
		dao.altera(contato);

		System.out.println("Alterado!");
	}
	
	public static void removerContato(){

		String entrada = JOptionPane.showInputDialog("Digite o id do contato:");
		long id = Integer.parseInt(entrada);
			
		// método elegante
		dao.remove(id);

		System.out.println("Removido!");
	}
	
	

	public static void main(String[] args) {
				
		String operacao;
		
		conectarBD();
		
		do{
			 operacao = JOptionPane.showInputDialog(null, "####### Agenda de Contatos ####### \n \t\t Informe a operação: \n [i] Inserir contato \n [l] Listar contatos\n [r] Remover contato \n [a] Alterar contato \n [f] fim\n");
						
			if (operacao.charAt(0) == 'i'){
				inserirContato();
				
			}else if (operacao.charAt(0) == 'l'){
				listarContatos();
				
			}else if (operacao.charAt(0) == 'r'){
				removerContato();
				
			}else if (operacao.charAt(0) == 'a'){
				alterarContato();
				
			}
			
		}while(operacao.charAt(0)!= 'f');
		 
		System.exit(0);
	}

}
