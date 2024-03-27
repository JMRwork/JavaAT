package br.edu.infnet;

import br.edu.infnet.controller.EnderecoController;
import br.edu.infnet.controller.ItemController;
import br.edu.infnet.controller.PessoaController;
import br.edu.infnet.controller.UsuarioController;
import spark.Spark;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Spark.port(8080);
        Spark.get("/test", (request, response) -> { return "Hello World";});
        Spark.get("/", (request, response) -> { return Main.class.getResourceAsStream("/index.html");});
        //Usuários
        Spark.get("/usuarios/listar", UsuarioController.listar);
        Spark.post("/usuarios/incluir", UsuarioController.incluir);
        Spark.delete("/usuarios/:id/excluir", UsuarioController.excluir);
        Spark.get("/usuarios/:id", UsuarioController.obterPorId);
        Spark.put("/usuarios/:id/atribuirItems", UsuarioController.atribuirItems);
        Spark.put("/usuarios/:usuarioId/atribuirPessoa/:pessoaId", UsuarioController.atribuirPessoa);
        Spark.put("/usuarios/:usuarioId/atribuirEndereco/:enderecoId", UsuarioController.atribuirEndereco);

        //Endereços
        Spark.get("/enderecos/listar", EnderecoController.listar);
        Spark.post("/enderecos/incluir/:cep", EnderecoController.incluir);
        Spark.delete("/enderecos/:id/excluir", EnderecoController.excluir);
        Spark.get("/enderecos/:id", EnderecoController.obterPorId);

        //Items
        Spark.get("/items/listar", ItemController.listar);
        Spark.post("/items/incluir", ItemController.incluir);
        Spark.delete("/items/:id/excluir", ItemController.excluir);
        Spark.get("/items/:id", ItemController.obterPorId);

        //Pessoas
        Spark.get("/pessoas/listar", PessoaController.listar);
        Spark.post("/pessoas/incluir", PessoaController.incluir);
        Spark.delete("/pessoas/:id/excluir", PessoaController.excluir);
        Spark.get("/pessoas/:id", PessoaController.obterPorId);
        }
    }