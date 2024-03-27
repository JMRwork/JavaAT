package br.edu.infnet.model.service;

import br.edu.infnet.client.IEnderecoClient;
import br.edu.infnet.model.domain.Endereco;
import feign.Feign;
import feign.gson.GsonDecoder;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EnderecoService {
    static IEnderecoClient enderecoClient = Feign.builder().decoder(new GsonDecoder()).target(IEnderecoClient.class, "https://viacep.com.br/ws");
    protected static Map<Integer, Endereco> enderecos = new HashMap<Integer, Endereco>();
    private static int id = 0;
    public static String incluir(int cep){
        Endereco endereco = enderecoClient.enderecoPorCep(cep);
        if(endereco == null){
         return "Cep inválido.";
        } else {
            endereco.setEnderecoId(++id);
            enderecos.put(endereco.getEnderecoId(), endereco);
            return "Inclusão de Endereço com sucesso";
        }
    }
    public static void excluir(int id){
        enderecos.remove(id);
    }
    public static Collection<Endereco> obterLista() {
        return enderecos.values();
    }
    public static Endereco obter(Integer id){
        return enderecos.get(id);
    }
}
