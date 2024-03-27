package br.edu.infnet.client;

import br.edu.infnet.model.domain.Endereco;
import feign.Param;
import feign.RequestLine;

public interface IEnderecoClient {
    @RequestLine("GET /{cep}/json/")
    Endereco enderecoPorCep(@Param("cep") int cep);
}
