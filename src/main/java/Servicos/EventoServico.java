package Servicos;

import DAO.EventoDAO;
import Modelos.Evento;
import org.jgroups.util.Tuple;
import util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RSouza on 01/03/18.
 */
public class EventoServico {
	private EventoDAO repositorioEvento = new EventoDAO();


	public List<Evento> listarEventos(){
		return repositorioEvento.recuperarTodos();
	}

	public List<Evento> buscarEvento(String json) {
		List<Tuple> vetorTupla = new JsonUtil().desmembrarJson(json);
		List<Evento> lista = new ArrayList<Evento>();

		for(Tuple tupla : vetorTupla){
			lista.addAll(buscarEvento(tupla.getVal1().toString(), tupla.getVal2().toString()));
		}
		return lista;
	}

	public List<Evento> buscarEvento(String nome, String tipo){
		return repositorioEvento.recuperarEvento(nome, tipo);
//		if (tipo.equals("nome")) {
//		}
//		if (tipo.equals("data")) {
//			return repositorioEvento.recuperarEventoPorNome(nome);
//		}
//		if (tipo.equals("local")) {
//			return repositorioEvento.recuperarEventoPorNome(nome);
//		}
	}

	public Evento salvarEvento(Evento evento) throws Exception{
		return repositorioEvento.salvar(evento);
	}

	public void excluirEvento(Long id){
		repositorioEvento.excluirPorId(Evento.class, id);
	}
}
