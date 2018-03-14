package Examples;
//
//import br.mil.eb.cds.sisbol.boletim.modelo.*;
//import br.unb.cic.comum.repositorio.RepositorioJPAGenerico;
//
//import javax.persistence.TypedQuery;
//import java.util.List;
//
//public class HistoricoRepositorioJPA extends RepositorioJPAGenerico<Historico> {
//    /** Serial Version */
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    protected Class<Historico> getClasseEntidade() {
//        return Historico.class;
//    }
//
//    public List<HistoricoBoletim> recuperaHistoricoBoletim(Long idBoletim){
//        TypedQuery<HistoricoBoletim> query = getEntityManager()
//                .createQuery("SELECT hb FROM  HistoricoBoletim AS hb WHERE hb.boletim.id = " + idBoletim, HistoricoBoletim.class);
//
//        return query.getResultList();
//    }
//
//    public List<HistoricoNota> recuperaHistoricoNota(Long idNota){
//        TypedQuery<HistoricoNota> query = getEntityManager()
//                .createQuery("SELECT hn FROM  HistoricoNota AS hn WHERE hn.nota.id = " + idNota, HistoricoNota.class);
//
//        return query.getResultList();
//    }
//}