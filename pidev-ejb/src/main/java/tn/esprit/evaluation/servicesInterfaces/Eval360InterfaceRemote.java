package tn.esprit.evaluation.servicesInterfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.evaluation.entities.Eval360;

@Remote
public interface Eval360InterfaceRemote {

	void addEval360(Eval360 eval);

	void deleteEval360ById(Long id);

	List<Eval360> getAllEval360();

	void AssignEval360ToEmploye(Eval360 eval, Long idEmp);

	List<Eval360> getListEval360Public();

	void deleteEval360(Eval360 eval);

	void updateEval360(Eval360 eval);

}
