package tn.esprit.ManagedBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import tn.esprit.mission.missionservices.ServicemissionRemote;



@ManagedBean
@ViewScoped
public class ChartJsView{
	private int n;
	private int ac;
	
	@EJB
	ServicemissionRemote so;
	
	private PieChartModel pieModel1;

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	private void createPieModels() {
		createPieModel1();
	}
	
	

	private void createPieModel1() {

		
		int CountAcc = (int) so.CountMissionAccepter().intValue();
		int countEnAtt = (int) so.CountmissionEnAttente().intValue();
		int total = (int) so.CountMission().intValue();

		int pourcentageAcc = (int) (CountAcc * 100) / total;
		int pourcentageEnAtt = (int) (countEnAtt * 100) / total;
		

//		System.out.println("aaaaaaaaaaa "+pourcentageAcc);
//		System.out.println("vbbbbbbbbbbbbb "+pourcentageEnAtt);
//		System.out.println("ccccccccc "+pourcentageRef);
		
		pieModel1 = new PieChartModel();
		pieModel1.set("Accepter "+pourcentageAcc+"%", pourcentageAcc);
		pieModel1.set("En Attente "+pourcentageEnAtt+"%", pourcentageEnAtt);
		
		
		pieModel1.setTitle("Etude sur le nombre de missions accepté et decliné par rapport au nombre total des demandes");
		pieModel1.setLegendPosition("w");
	}

	
	
	
	

}
