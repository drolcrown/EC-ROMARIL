//package Examples;
//
//import br.unb.cic.comum.modelo.IEntidade;
//import br.unb.cic.rest.comum.Views;
//import com.fasterxml.jackson.annotation.JsonView;
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.Date;
//
//@Entity
//@Table(name = "TB_HISTORICO")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Data
//public abstract class Historico implements IEntidade<Long> {
//
//    /** Serial Version    */
//    private static final long serialVersionUID = 1L;
//
//    @JsonView(Views.Listagem.class)
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID_HISTORICO")
//    private Long id;
//
//    @JsonView(Views.Listagem.class)
//    @NotNull
//    @Column(name = "DATA", nullable = false, updatable = false)
//    private Date data;
//
//    @JsonView(Views.Listagem.class)
//    @Column(name = "ACAO", nullable = false)
//    private StatusHistoricoEnum acao;
//
//    @JsonView(Views.Listagem.class)
//    @Column(name = "DESTINO", nullable = false)
//    private String destino;
//
//    @JsonView(Views.Listagem.class)
//    @Column(name = "ORIGEM", nullable = false)
//    private String origem;
//
//    @JsonView(Views.Listagem.class)
//    @ManyToOne
//    @JoinColumn(name = "ID_MILITAR")
//    private Militar militar;
//
//    @JsonView(Views.Listagem.class)
//    @ManyToOne
//    @JoinColumn(name = "ID_FUNCAO")
//    private Funcao funcao;
//
//    @JsonView(Views.Listagem.class)
//    @Column(name = "COMENTARIO")
//    private String comentario;
//
//    @Override
//    public Long getId() {
//        return id;
//    }
//}
