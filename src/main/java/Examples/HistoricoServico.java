//package Examples;
//
//import br.mil.eb.cds.sisbol.boletim.modelo.*;
//import br.mil.eb.cds.sisbol.boletim.repositorio.HistoricoRepositorioJPA;
//import br.unb.cic.comum.repositorio.RepositorioJPAGenerico;
//import br.unb.cic.comum.servico.ServicoGenerico;
//
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//
//@LocalBean
//@Stateless
//public class HistoricoServico extends ServicoGenerico<Historico> {
//    /**
//     * Serial Version
//     */
//    private static final long serialVersionUID = 1L;
//
//    @Inject
//    private HistoricoRepositorioJPA historicoRepositorioJPA;
//
//    @Override
//    protected RepositorioJPAGenerico<Historico> getRepositorioJPA() {
//        return historicoRepositorioJPA;
//    }
//
//    @Override
//    protected Class<Historico> getClasseEntidade() {
//        return Historico.class;
//    }
//}