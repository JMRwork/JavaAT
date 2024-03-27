package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ItemService {
    protected static Map<Integer, Item> items = new HashMap<Integer, Item>();
    private static Integer id = 0;
    public static void incluir(Item item) throws Exception {
        item.setItemId(++id);
        items.put(item.getItemId(), item);
    }
    public static void excluir(Integer itemId) {
        items.remove(itemId);
    }
    public static Collection<Item> obterLista(){
        return items.values();
    }
    public static Item obter(Integer itemId){
        return items.get(itemId);
    }
}
