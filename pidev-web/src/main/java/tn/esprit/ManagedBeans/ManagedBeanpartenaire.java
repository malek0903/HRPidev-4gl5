package tn.esprit.ManagedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.mission.missionentities.Partenariat;
import tn.esprit.mission.partenariatservices.ServicepartenariatRemote;

@ManagedBean
@ViewScoped
public class ManagedBeanpartenaire {

	
	private int idpartenaire;
	private String nompartenaire;
	private String domainepartenaire;
	private String adressepartenaire;
	private int numtelpartenaire;
	private String emailpartenaire;
	private int pourcentagereduction;
	private int nbreop;
	
	public ServicepartenariatRemote getSer() {
		return ser;
	}

	public void setSer(ServicepartenariatRemote ser) {
		this.ser = ser;
	}

	

	

	public int getNbreop() {
		return nbreop;
	}

	public void setNbreop(int nbreop) {
		this.nbreop = nbreop;
	}

	private List<Partenariat> partenaires;

	

	public void setPartenaires(List<Partenariat> partenaires) {
		this.partenaires = partenaires;
	}

	private int idtoset;

	
	public int getIdpartenaire() {
		return idpartenaire;
	}

	public void setIdpartenaire(int idpartenaire) {
		this.idpartenaire = idpartenaire;
	}

	public String getNompartenaire() {
		return nompartenaire;
	}

	public void setNompartenaire(String nompartenaire) {
		this.nompartenaire = nompartenaire;
	}

	public String getDomainepartenaire() {
		return domainepartenaire;
	}

	public void setDomainepartenaire(String domainepartenaire) {
		this.domainepartenaire = domainepartenaire;
	}


	public String getAdressepartenaire() {
		return adressepartenaire;
	}

	public void setAdressepartenaire(String adressepartenaire) {
		this.adressepartenaire = adressepartenaire;
	}

	public int getNumtelpartenaire() {
		return numtelpartenaire;
	}

	public void setNumtelpartenaire(int numtelpartenaire) {
		this.numtelpartenaire = numtelpartenaire;
	}

	public String getEmailpartenaire() {
		return emailpartenaire;
	}

	public void setEmailpartenaire(String emailpartenaire) {
		this.emailpartenaire = emailpartenaire;
	}

	public int getPourcentagereduction() {
		return pourcentagereduction;
	}

	public void setPourcentagereduction(int pourcentagereduction) {
		this.pourcentagereduction = pourcentagereduction;
	}
	
	
	public int getIdtoset() {
		return idtoset;
	}

	public void setIdtoset(int idtoset) {
		this.idtoset = idtoset;
	}

	@EJB
	ServicepartenariatRemote ser;

	public String ajout()
	{
		
		
		
			Partenariat p= new Partenariat();
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			String domainepartenaire= req.getParameter("dompart");
			p.setDomainepartenaire(domainepartenaire);
			
			
			
			
			p.setAdressepartenaire(adressepartenaire);
			p.setDomainepartenaire(domainepartenaire);
			p.setEmailpartenaire(emailpartenaire);
			p.setNompartenaire(nompartenaire);
			p.setNumtelpartenaire(numtelpartenaire);
			p.setPourcentagereduction(pourcentagereduction);
			
		
		 
			
			ser.ajouterPartenariat(p);
			return  "/missions/admin/template.xhtml ?faces-redirect=true";
		
	}
	public List<Partenariat> getPartenaires()
	{
		
		partenaires=ser.findallpartenaire();
		return partenaires;
	}
	public void supprimer (Integer pid)
	{
		ser.deletepartenaire(pid);
	}
	public void modifier (Partenariat partenaire)
	{
		
		
		this.setAdressepartenaire(partenaire.getAdressepartenaire());
		this.setDomainepartenaire(partenaire.getDomainepartenaire());
		this.setEmailpartenaire(partenaire.getEmailpartenaire());
		this.setNompartenaire(partenaire.getNompartenaire());
		this.setNumtelpartenaire(partenaire.getNumtelpartenaire());
		this.setPourcentagereduction(partenaire.getPourcentagereduction());
		this.setNbreop(partenaire.getNbreop());
	
		this.setIdtoset(partenaire.getIdpartenaire());
		
		
	}

	
	

	

	public void updatedep()
	{
		
		ser.updatedep(new Partenariat(nompartenaire,domainepartenaire,adressepartenaire,numtelpartenaire,emailpartenaire,pourcentagereduction,nbreop,idtoset));
		
	}

}
