package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Endereco;
import br.edu.infnet.model.domain.Item;
import br.edu.infnet.model.domain.Pessoa;
import br.edu.infnet.model.domain.Usuario;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UsuarioService {
    private static Map<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
    private static Integer id = 0;

    public static void incluir(Usuario usuario) throws Exception {
        usuario.setId(++id);
        usuarios.put(usuario.getId(), usuario);
    }
    public static void excluir(Integer id) {
        usuarios.remove(id);
    }
    public static Collection<Usuario> obterLista(){
        return usuarios.values();
    }
    public static Usuario obter(Integer id){
        return usuarios.get(id);
    }
    public static String atribuirItems(Integer id){
        Collection<Item> items = ItemService.items.values();
        Usuario usuario = usuarios.get(id);
        if(usuario == null){
            return "Usuário de ID: " + id + ", não existe.";
        }
        usuario.setInventario(items);
        return "Foi adicionado a lista de items ao usuário de email: " + usuario.getEmail();
    }
    public static String atribuirPessoa(Integer usuarioId, Integer pessoaId){
        Pessoa pessoa = PessoaService.pessoas.get(pessoaId);
        if(pessoa == null){
            return "Pessoa de ID: " + pessoaId + ", não existe.";
        }
        Usuario usuario = usuarios.get(usuarioId);
        if(usuario == null){
            return "Usuário de ID: " + usuarioId + ", não existe.";
        }
        usuario.setPessoaId(pessoa.getPessoaId());
        usuario.setNome(pessoa.getNome());
        usuario.setUltimoNome(pessoa.getUltimoNome());
        usuario.setDataNascimento(pessoa.getDataNascimento());
        usuario.setCPF(pessoa.getCPF());
        return "Foi adicionado os dados da Pessoa de Id:" + pessoaId + " ao usuário de email: " + usuario.getEmail();

    }

    public static String atribuirEndereco(Integer usuarioId, Integer enderecoId){
        Endereco endereco = EnderecoService.obter(enderecoId);
        if(endereco == null){
            return "Endereco de ID: " + enderecoId + ", não existe.";
        }
        Usuario usuario = usuarios.get(usuarioId);
        if(usuario == null){
            return "Usuário de ID: " + usuarioId + ", não existe.";
        }
        usuario.setEndereco(endereco);
        return "Foi adicionado o endereço de id:" + enderecoId + " ao usuário de email: " + usuario.getEmail();
    }
}