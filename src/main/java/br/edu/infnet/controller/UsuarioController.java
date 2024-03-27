package br.edu.infnet.controller;

import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.model.service.UsuarioService;
import com.google.gson.Gson;
import spark.Route;

import java.util.Collection;

public class UsuarioController {
    public static Route listar = (request, response) -> {
        Collection<Usuario> usuarios = UsuarioService.obterLista();
        if (usuarios.isEmpty()){
            return "Nenhum Usuario cadastrado.";
        }
        return usuarios.toString();
    };
    public static Route incluir = (request, response) -> {
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(request.body(), Usuario.class);
        UsuarioService.incluir(usuario);
        return "Inclusão de usuário realizada com sucesso";
    };
    public static Route excluir = (request, response) -> {
        int id = Integer.parseInt(request.params("id"));
        Usuario usuario = UsuarioService.obter(id);
        if(usuario == null){
            return "Usuário de ID: " + id + ", não existe.";
        }
        UsuarioService.excluir(id);
        return "Sucesso na Exclusão do usuario "+usuario.getEmail()+" de Id: " + id;
    };
    public static Route obterPorId = (request, response) -> {
        int id = Integer.parseInt(request.params("id"));
        Usuario usuario = UsuarioService.obter(id);
        if(usuario == null){
            return "Usuário de ID: " + id + ", não existe.";
        }
        return usuario.toString();
    };
    public static Route atribuirItems = (request, response) -> {
        int id = Integer.parseInt(request.params("id"));
        return UsuarioService.atribuirItems(id);
    };
    public static Route atribuirPessoa = (request, response) -> {
        int usuarioId = Integer.parseInt(request.params("usuarioId"));
        int pessoaId = Integer.parseInt(request.params("pessoaId"));
        return UsuarioService.atribuirPessoa(usuarioId, pessoaId);
    };
    public static Route atribuirEndereco = (request, response) -> {
        int usuarioId = Integer.parseInt(request.params("usuarioId"));
        int enderecoId = Integer.parseInt(request.params("enderecoId"));
        return UsuarioService.atribuirEndereco(usuarioId, enderecoId);
    };
}
