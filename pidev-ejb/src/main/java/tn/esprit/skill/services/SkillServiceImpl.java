package tn.esprit.skill.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.skill.entities.Skill;
import tn.esprit.skill.servicesInterfaces.SkillServiceRemote;

@Stateless
@LocalBean
public class SkillServiceImpl implements SkillServiceRemote {
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager entityManager;

	@Override
	public Skill findBySkillById(Long skillId) {
		return entityManager.find(Skill.class, skillId);
	}

	@Override
	public List<Skill> findAllSkills() {
		TypedQuery<Skill> query = entityManager.createQuery("SELECT s FROM Skill s", Skill.class);
		return query.getResultList();
	}

	@Override
	public void addSkill(Skill skill) {
		entityManager.persist(skill);
	}

	@Override
	public void updateSkill(Skill skill) {
		entityManager.merge(skill);
	}

	@Override
	public void deleteSkill(Skill skill) {
		entityManager.remove(entityManager.find(Skill.class, skill.getSkillId()));
	}

}
