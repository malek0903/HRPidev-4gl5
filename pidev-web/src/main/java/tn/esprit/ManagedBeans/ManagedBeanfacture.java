package tn.esprit.ManagedBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import tn.esprit.mission.factureservices.ServicefactureRemote;
import tn.esprit.mission.missionentities.Facture;
import tn.esprit.mission.missionentities.Mission;
import tn.esprit.mission.missionentities.Partenariat;
import tn.esprit.mission.partenariatservices.ServicepartenariatRemote;

@ManagedBean
@ViewScoped
public class ManagedBeanfacture {

	@PostConstruct
	public void init() {
		mission = new Mission();
		partenariat = new Partenariat();

	}

	private int idfacture;
	private String type;
	private String image;
	private int somme;
	private Mission mission;
	private Partenariat partenariat;
	private Part file;
	private String destination = "C:/xampp/htdocs/Pi/";
	private InputStream inputStream;
	private String fileName;
	private int idtoset;
	private int w;
	private List<Facture> factures;

	@EJB
	ServicefactureRemote ser;
	ServicepartenariatRemote serf;
	Facture f;

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Partenariat getPartenariat() {
		return partenariat;
	}

	public void setPartenariat(Partenariat partenariat) {
		this.partenariat = partenariat;
	}

	public int getIdtoset() {
		return idtoset;
	}

	public void setIdtoset(int idtoset) {
		this.idtoset = idtoset;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public int getIdfacture() {
		return idfacture;
	}

	public void setIdfacture(int idfacture) {
		this.idfacture = idfacture;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSomme() {
		return somme;
	}

	public void setSomme(int somme) {
		this.somme = somme;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Facture getF() {
		return f;
	}

	public void setF(Facture f) {
		this.f = f;
	}

	public String ajout(Mission a) throws IOException

	{

		String path = uploadFile();

		Facture f = new Facture();

		Partenariat p = new Partenariat();

		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String partenariat = req.getParameter("partenariat");
		int idpartenaire = Integer.valueOf(partenariat);
		System.out.println(idpartenaire);
		Partenariat b = new Partenariat();
		b = ser.pfind(idpartenaire);

		f.setPartenariat(b);

		HttpServletRequest rep = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String type = rep.getParameter("type");
		System.out.println(type);
		f.setType(type);

		f.setImage(path);
		f.setMission(mission);

		f.setSomme(somme);

		/*
		 * 
		 * int i=a.getIdmission(); System.out.println(i); String g=a.getEtat();
		 * System.out.println(g); String w=a.getDestination(); System.out.println(w);
		 * 
		 */

		ser.ajouterFacture(f);
		
		return  "/missions/front/templatefront.xhtml ?faces-redirect=true";
	}

	public List<Facture> getFactures() {

		factures = ser.findallfacture();
		return factures;
	}

	public ServicefactureRemote getSer() {
		return ser;
	}

	public void setSer(ServicefactureRemote ser) {
		this.ser = ser;
	}

	public void calculfacture(Partenariat p, Facture f) {
		int sm = f.getSomme();

		int prc = p.getPourcentagereduction();
		System.out.println(idfacture);

		int x = sm + (sm * prc) / 100;
		System.out.println(x);
		this.setSomme(x);

		idfacture = f.getIdfacture();
		this.setIdfacture(idfacture);
		System.out.println(idfacture);
		type = f.getType();
		this.setType(type);
		image = f.getImage();
		this.setImage(image);
		mission = f.getMission();
		this.setMission(mission);
		partenariat = f.getPartenariat();
		this.setPartenariat(partenariat);

		ser.updatesomme(new Facture(type, image, somme, mission, partenariat, idfacture));

		int q = p.getNbreop();
		int w = q + 1;

		int idtoup = p.getIdpartenaire();
		System.out.println(idtoup);
		String nompartenaire = p.getNompartenaire();
		System.out.println(nompartenaire);
		String domainepartenaire = p.getDomainepartenaire();
		String adressepartenaire = p.getAdressepartenaire();
		int numtelpartenaire = p.getNumtelpartenaire();
		String emailpartenaire = p.getEmailpartenaire();
		int pourcentagereduction = p.getPourcentagereduction();
		int idtoset = idtoup;
		System.out.println(idtoset);
		int nbreop = w;

		ser.updatedep(new Partenariat(nompartenaire, domainepartenaire, adressepartenaire, numtelpartenaire,
				emailpartenaire, pourcentagereduction, idtoset, nbreop));
	

	}

	public void copyFile(String fileName, InputStream in) {
		try {
			OutputStream out = new FileOutputStream(new File(destination + fileName));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			in.close();
			out.flush();
			out.close();
			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String uploadFile() throws IOException {

		if (file != null) {
			inputStream = file.getInputStream();
			System.out.println("file name = " + file.getName());
			fileName = file.getSubmittedFileName();
			copyFile(fileName, inputStream);
			file = null;
			inputStream = null;
			return "http://localhost:80/Pi/" + fileName;
		}
		return "";
	}

}
