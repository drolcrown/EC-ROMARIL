package eventos;

import org.jgroups.util.Tuple;
import util.JsonUtil;

import javax.json.Json;
import java.util.List;

public class teste {
    public static void main(String[] args){

//        Evento evento = new Evento("Rafa3", "12/03/2016", "22/03/2016", "Brasilia", "9h", "");
//
//        EventoDAO eventoDAO = new EventoDAO();
//        eventoDAO.salvar(evento);
//        Evento evento = eventoDAO.consultarPorId(Evento.class, 7L);

//        System.out.println(evento.getId());
//        eventoDAO.excluir(evento);


        JsonUtil a = new JsonUtil();

        String json = "{\"nome\" : \"Rafael\", \n\"dataInicio\" : \"22/02/2019\"}";
        List<Tuple> vetor = a.desmembrarJson(json);

        for(Tuple tupla : vetor){
            System.out.println(tupla.getVal1());
        }
    }
}
