package com.onlineVip.entities;





import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "project")
public class Project {

	@Id
	private String id ;
	private String fondateur;
	private String projectName ;
	private String businesSetor ;
	private Date dateCreation;
	private String city ;
	private String Maturite;
	private Date anneeParticipation;
    private String formeJuridique;
    private String NatureCapital;
    private Double CNSS; 
    private Boolean estEntrprise;
    private String  Description;
   
public Project() {

}


	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getBusinesSetor() {
		return businesSetor;
	}

	public void setBusinesSetor(String businesSetor) {
		this.businesSetor = businesSetor;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getFondateur() {
		return fondateur;
	}


	public void setFondateur(String fondateur) {
		this.fondateur = fondateur;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}




	public String getMaturite() {
		return Maturite;
	}


	public void setMaturite(String maturite) {
		Maturite = maturite;
	}


	public String getFormeJuridique() {
		return formeJuridique;
	}


	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}


	public String getNatureCapital() {
		return NatureCapital;
	}


	public void setNatureCapital(String natureCapital) {
		NatureCapital = natureCapital;
	}


	


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public Date getAnneeParticipation() {
		return anneeParticipation;
	}


	public void setAnneeParticipation(Date anneeParticipation) {
		this.anneeParticipation = anneeParticipation;
	}


	public Double getCNSS() {
		return CNSS;
	}


	public void setCNSS(Double cNSS) {
		CNSS = cNSS;
	}


	public Boolean getEstEntrprise() {
		return estEntrprise;
	}


	public void setEstEntrprise(Boolean estEntrprise) {
		this.estEntrprise = estEntrprise;
	}


	
	
	
	
}
