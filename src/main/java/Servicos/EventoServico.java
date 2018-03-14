package Servicos;

import DAO.EventoDAO;
import Modelos.Evento;

import java.util.List;

/**
 * Created by RSouza on 01/03/18.
 */
public class EventoServico {
	private EventoDAO repositorioEvento = new EventoDAO();


	public List<Evento> listarEventos(){
		return repositorioEvento.recuperarTodos();
	}

	public List<Evento> buscarEvento(String nome){
	 return repositorioEvento.recuperarEventoPorNome(nome);
	}

	public Evento salvarEvento(Evento evento) throws Exception{
		return repositorioEvento.salvar(evento);
	}

	public void excluirEvento(Long id){
		repositorioEvento.excluirPorId(Evento.class, id);
	}
}
