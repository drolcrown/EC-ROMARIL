package Modelos;

import javax.persistence.*;

@Entity
@Table(name ="tb_evento")
public class Evento implements EntidadeGenerica{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column
	private String nome;
    @Column
	private String dataInicio;
    @Column
	private String dataFim;
	@Column
	private String descricao;
    @Column
	private String estado;
    @Column
	private String municipio;
	
	public Evento() {
	}

	public Evento(String nome, String dataI, String dataF, String estado, String municipio, String descricao) {
		this.nome = nome;
		this.dataInicio = dataI;
		this.dataFim = dataF;
		this.estado = estado;
		this.municipio = municipio;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public Class getClasseEntidade() {
		return this.getClass();
	}
}
