package com.bdmysql.scenarios.test;

import com.bdmysql.connectionBD.login.ManipularDados;
import org.junit.jupiter.api.Test;

public class TesteBD {

    @Test
    public void testBD() throws Exception {
        ManipularDados.conectarBD();
        ManipularDados.listarLogins();
//        ManipularDados.removerLogin("1");
//        ManipularDados.inserirLogin("reginaldo", "12345", "reginaldo.com.br");
//        ManipularDados.alterarLogin("2", "solar2", "Claro@2022", "https://clarobrasil3.test.etadirect.com/mobility/");
    }

}
