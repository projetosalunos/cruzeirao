package sistema.beans;



import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.modelos.Local;
import sistema.service.CampeonatoService;

@ManagedBean
@ViewScoped
public class CampeonatoMB {

	private Campeonato campeonato = new Campeonato();
	private Local local = new Local();
	private Categoria categoria = new Categoria();
	private CampeonatoService campeonatoService = new CampeonatoService();

	// Getters and Setters
	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public List<Campeonato> buscaCampeonatos() {
		return campeonatoService.getCampeonatos();
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// Service communication

	// Salvar local
	public void salvarLocal() {
		
		System.out.println(local);
		
		if (this.getLocal().getEndereco() == "") {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! O campo de local est� inv�lido.",
					null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			campeonato.getLocais().add(this.getLocal());
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso! O Local " + this.getLocal().getEndereco() + " foi cadastrado", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			local = new Local();
		}
	}

	// Remover local
	public void removerLocal(Local local) {
		if (local.getEndereco() != "") {
			campeonato.getLocais().remove(local);
		}
	}

	// Salvar categoria
	public void salvarCategoria() {
		if (this.getCategoria().getNome() == "") {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro! O campo de categoria est� inv�lido.", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			campeonato.getCategorias().add(this.getCategoria());
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso! A Categoria " + this.getCategoria().getNome() + " foi cadastrada", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			categoria = new Categoria();
		}
	}

	// Salvar categoria
	public void removerCategoria(Categoria categoria) {
		if (categoria.getNome() != "") {
			campeonato.getCategorias().remove(categoria);
		}
	}

	// Salvar campeonato
	public void salvarCampeonato() {
		System.out.println(campeonato);

		this.campeonatoService.salvar(this.getCampeonato());
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! O campeonato foi criado", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		campeonato = new Campeonato();
	}

	// Remover campeonato
	public void removerCampeonato(Campeonato campeonato) {
		this.campeonatoService.remover(campeonato);
	}

	// Wizard manipulation
	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();
	}

	public void onRowEdition(RowEditEvent event) {
		Campeonato c = ((Campeonato) event.getObject());
		campeonatoService.alterar(c);
	}


}
