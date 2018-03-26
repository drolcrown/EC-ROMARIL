package Recursos;

import Modelos.Evento;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Servicos.EventoServico;
import com.google.gson.Gson;

/**
 * Created by RSouza on 01/03/18.
 */
@Path("/eventos")
public class EventoRecurso {
    private static String NOME = "nome", LOCAL = "local", DATA = "data";
    private EventoServico servicoEvento = new EventoServico();

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(){
        return Response.ok(new Gson().toJson("Hello World")).build();
    }

    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evento> listarEventos(){
       return servicoEvento.listarEventos();
    }

    @GET
    @Path("/buscar/{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evento> buscarEvento(@PathParam("json") String json){
        return servicoEvento.buscarEvento(json);
    }

    @GET
    @Path("/buscarPorLocal/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evento> buscarEventoPorNome(@PathParam("nome") String nome){
        return servicoEvento.buscarEvento(nome, NOME);
    }

    @GET
    @Path("/buscarPorData/{data}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evento> buscarEventoPorData(@PathParam("data") String data){
        return servicoEvento.buscarEvento(data, DATA);
    }

    @GET
    @Path("/buscarPorLocal/{local}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evento> buscarEventoPorLocal(@PathParam("local") String local){
        return servicoEvento.buscarEvento(local, LOCAL);
    }

    @POST
    @Path("/salvar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Evento salvarEvento(Evento evento) throws Exception{
        return servicoEvento.salvarEvento(evento);
    }

    @DELETE
    @Path("/excluir/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void excluirEvento(@PathParam("id") Long id){
        servicoEvento.excluirEvento(id);
//        return Response.ok(new Gson().toJson("Evento Excluido")).build();
    }
//
//    @GET
//    @Path("/pesquisa")
//    @Produces(MediaType.TEXT_HTML)
//    public Response pesquisarEvento(){
//        return
//
//    }


}
