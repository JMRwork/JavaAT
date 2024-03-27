package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Pessoa;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PessoaService {
    protected static Map<Integer, Pessoa> pessoas = new HashMap<Integer, Pessoa>();
    private static int id = 0;

    public static void incluir(Pessoa pessoa) {
        pessoa.setPessoaId(++id);
        pessoas.put(pessoa.getPessoaId(), pessoa);
    }
    public static void excluir(Integer id) {
        pessoas.remove(id);
    }
    public static Collection<Pessoa> obterLista(){
        return pessoas.values();
    }
    public static Pessoa obter(Integer id){
        return pessoas.get(id);
    }
}
