package tn.esprit.training.interfaces;


import java.util.List;



import tn.esprit.training.entities.Planification;


public interface PlanificationInterface {
	void AddPlanification(Planification p);

	List<Planification> getAllPlanification();
	public Planification getPlanificationById(int id);

	public void deletePlanificationById(int id);
	public void updatePlanification(Planification p);

	List<Planification> findPlanificationByFormateurIdANDFormationId(int FormateurId, int FormationId);
}
