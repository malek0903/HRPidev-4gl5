package tn.esprit.ManagedBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import tn.esprit.mission.missionservices.ServicemissionRemote;



@ManagedBean
@ViewScoped
public class ChartJsView {
	private int n;
	private int ac;
	
	@EJB
	ServicemissionRemote ser;
	
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

		int countRef = 10;
		int CountAcc = ser.CountMissionAccepter().intValue();
	
		int countEnAtt= ser.CountmissionEnAttente().intValue();
		int total = ser.CountMission().intValue();

		int pourcentageAcc = (int) (CountAcc * 100) / total;
		int pourcentageEnAtt = (int) (countEnAtt * 100) / total;
		

//		System.out.println("aaaaaaaaaaa "+pourcentageAcc);
//		System.out.println("vbbbbbbbbbbbbb "+pourcentageEnAtt);
//		System.out.println("ccccccccc "+pourcentageRef);
		
		pieModel1 = new PieChartModel();
		pieModel1.set("Accepter "+pourcentageAcc+"%", pourcentageAcc);
		pieModel1.set("Refusé "+pourcentageEnAtt+"%", pourcentageEnAtt);
		
		
		
		pieModel1.setTitle("Statistique sur les missions");
		pieModel1.setLegendPosition("w");
	}

	
	
	
	

}
