package br.edu.infnet.controller;

import br.edu.infnet.model.domain.Pessoa;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.model.service.PessoaService;
import com.google.gson.Gson;
import spark.Route;

import java.util.Collection;
import java.util.Date;

public class PessoaController {
    public static Route listar = (request, response) -> {
        Collection<Pessoa> pessoas = PessoaService.obterLista();
        if (pessoas.isEmpty()){
            return "Nenhuma pessoa cadastrada.";
        }
        return pessoas.toString();
    };
    public static Route incluir = (request, response) -> {
        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(request.body(), Pessoa.class);
        PessoaService.incluir(pessoa);
        return "Inclusão de Pessoa com sucesso";
    };
    public static Route excluir = (request, response) -> {
        int id = Integer.parseInt(request.params("id"));
        Pessoa pessoa = PessoaService.obter(id);
        if(pessoa == null){
            return "Pessoa de ID: " + id + ", não existe.";
        }
        PessoaService.excluir(id);
        return "Sucesso na Exclusão da Pessoa "+ pessoa.getNome() + " " + pessoa.getUltimoNome() + ", de Id: " + id;
    };
    public static Route obterPorId = (request, response) -> {
        int id = Integer.parseInt(request.params("id"));
        Pessoa pessoa = PessoaService.obter(id);
        if(pessoa == null){
            return "Pessoa de ID: " + id + ", não existe.";
        }
        return pessoa.toString();
    };
}
