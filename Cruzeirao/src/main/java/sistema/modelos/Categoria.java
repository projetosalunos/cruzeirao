package sistema.modelos;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

import enumerator.Sexo;

@Entity
public class Categoria {
	@Id
	private int id;
	
	private String nome;
	private int apartirDe;
	private ArrayList<Inscricao> inscricoes = new ArrayList<Inscricao>();
	private Campeonato campeonato;
	private ArrayList<Fase> fases = new ArrayList<Fase>();
	private int minJogadores;
	private int maxJogadores;
	private Sexo sexo;
	private int attribute74;
	//Gets E Sets & ToString
	public Categoria() {
		super();
	}
	public Categoria(int id, String nome, int apartirDe, ArrayList<Inscricao> inscricoes, Campeonato campeonato,
			ArrayList<Fase> fases, int minJogadores, int maxJogadores, Sexo sexo, int attribute74) {
		super();
		this.id = id;
		this.nome = nome;
		this.apartirDe = apartirDe;
		this.inscricoes = inscricoes;
		this.campeonato = campeonato;
		this.fases = fases;
		this.minJogadores = minJogadores;
		this.maxJogadores = maxJogadores;
		this.sexo = sexo;
		this.attribute74 = attribute74;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getApartirDe() {
		return apartirDe;
	}
	public void setApartirDe(int apartirDe) {
		this.apartirDe = apartirDe;
	}
	public ArrayList<Inscricao> getInscricoes() {
		return inscricoes;
	}
	public void setInscricoes(ArrayList<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public ArrayList<Fase> getFases() {
		return fases;
	}
	public void setFases(ArrayList<Fase> fases) {
		this.fases = fases;
	}
	public int getMinJogadores() {
		return minJogadores;
	}
	public void setMinJogadores(int minJogadores) {
		this.minJogadores = minJogadores;
	}
	public int getMaxJogadores() {
		return maxJogadores;
	}
	public void setMaxJogadores(int maxJogadores) {
		this.maxJogadores = maxJogadores;
	}
	public int getAttribute74() {
		return attribute74;
	}
	public void setAttribute74(int attribute74) {
		this.attribute74 = attribute74;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	@Override
	public String toString() {
		return "Categoria [nome=" + nome + ", apartirDe=" + apartirDe + ", inscricoes=" + inscricoes + ", campeonato="
				+ campeonato + ", fases=" + fases + ", minJogadores=" + minJogadores + ", maxJogadores=" + maxJogadores
				+ ", sexo=" + sexo + ", attribute74=" + attribute74 + "]";
	}
}