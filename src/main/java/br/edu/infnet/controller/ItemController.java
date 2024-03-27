package br.edu.infnet.controller;

import br.edu.infnet.model.domain.Item;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.model.service.ItemService;
import com.google.gson.Gson;
import spark.Route;

import java.util.Collection;

public class ItemController {
    public static Route listar = (request, response) -> {
        Collection<Item> items = ItemService.obterLista();
        if (items.isEmpty()){
            return "Nenhum Item cadastrado.";
        }
        return items.toString();
    };
    public static Route incluir = (request, response) -> {
        Gson gson = new Gson();
        Item item = gson.fromJson(request.body(), Item.class);
        ItemService.incluir(item);
        return "Inclusão de Item com sucesso.";
    };
    public static Route excluir = (request, response) -> {
        int id = Integer.parseInt(request.params("id"));
        Item item = ItemService.obter(id);
        if(item == null){
            return "Item de ID: " + id + ", não existe.";
        }
        ItemService.excluir(id);
        return "Sucesso na Exclusão do item "+item.getNome()+" de Id: " + id;
    };
    public static Route obterPorId = (request, response) -> {
        int id = Integer.parseInt(request.params("id"));
        Item item = ItemService.obter(id);
        if(item == null){
            return "Item de ID: " + id + ", não existe.";
        }
        return item.toString();
    };
}
