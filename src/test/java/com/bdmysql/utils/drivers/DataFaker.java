package com.bdmysql.utils.drivers;

import java.util.Locale;

public class DataFaker {
	 
	static net.datafaker.Faker faker = new net.datafaker.Faker(new Locale("pt-BR"));

	public static String gerarCPF() {
			String cpf = faker.cpf().valid(false);
		return cpf;
	}
	
	public static String gerarRG() {
		//idNumber tem mesmo número de caracteres do RG, mas não é RG válido.
		String RG = faker.idNumber().valid();
		return RG;
	}


	public static String gerarCNPJ() {
		String cnpj = faker.cnpj().valid(false);
		return cnpj;
	}

	public static String gerarEmail() {
		String email = faker.internet().safeEmailAddress();
		return email;
	}

	public static String gerarTelefone() {
		String telefone = faker.phoneNumber().cellPhone()
				.replace("(", "")
				.replace(")", "")
				.replace("-", "")
				.replace(" ", "");
		return telefone;
	}

}
