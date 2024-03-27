package br.edu.infnet.controller;

import br.edu.infnet.model.domain.Endereco;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.model.service.EnderecoService;
import com.google.gson.Gson;
import spark.Route;

import java.util.Collection;

public class EnderecoController {
    public static Route listar = (request, response) -> {
        Collection<Endereco> enderecos = EnderecoService.obterLista();
        if (enderecos.isEmpty()){
            return "Nenhum endereço cadastrado.";
        }
        return enderecos.toString();
    };
    public static Route incluir = (request, response) -> {
        int cep = Integer.parseInt(request.params("cep"));
        return EnderecoService.incluir(cep);
    };
    public static Route excluir = (request, response) -> {
        int id = Integer.parseInt(request.params("id"));
        Endereco endereco = EnderecoService.obter(id);
        if(endereco == null){
            return "Endereço de ID: " + id + ", não existe.";
        }
        EnderecoService.excluir(id);
        return "Sucesso na Exclusão do endereço "+ endereco.getLogradouro() + " " + endereco.getLocalidade() + ", de Id: " + id;
    };
    public static Route obterPorId = (request, response) -> {
        int id = Integer.parseInt(request.params("id"));
        Endereco endereco = EnderecoService.obter(id);
        if(endereco == null){
            return "Endereço de ID: " + id + ", não existe.";
        }
        return endereco.toString();
    };
}
