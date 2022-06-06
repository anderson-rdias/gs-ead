package br.com.jkcontrol.gcead.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.jkcontrol.gcead.entity.Visitante;

public class VisitanteDAOImpl extends HibernateGenericDAO<Visitante, Long>{
private static VisitanteDAOImpl instance = null;
	
	public static VisitanteDAOImpl getInstance() {
		if (instance == null) {
			instance = new VisitanteDAOImpl();
		}
		
		return instance;
	}
	
	private VisitanteDAOImpl() {
		super(Visitante.class);
	}
	
	@Override
	public List<Visitante> listar(EntityManager entityManager) {
		TypedQuery<Visitante> consulta = entityManager.createNamedQuery("Visitante.listar", Visitante.class);
		return consulta.getResultList();
	}
	
	public List<Visitante> listarComCriteriaNome(String nome, EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Visitante> criteriaQuery = builder.createQuery(Visitante.class);
		
		Root<Visitante> visitante = criteriaQuery.from(Visitante.class);
		Predicate predicate = builder.like(
				builder.upper(visitante.get("nome")), "%" + visitante + "%");
		
		criteriaQuery.select(visitante);
		criteriaQuery.where(predicate);
		
		TypedQuery<Visitante> consulta = entityManager.createQuery(criteriaQuery);
		
		return consulta.getResultList();
	}
	
	public List<Visitante> listarComCriteriaCpf(String cpf, EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Visitante> criteriaQuery = builder.createQuery(Visitante.class);
		
		Root<Visitante> visitante = criteriaQuery.from(Visitante.class);
		Predicate predicate = builder.equal(visitante.get("cpf"), cpf);
		
		criteriaQuery.select(visitante);
		criteriaQuery.where(predicate);
		
		TypedQuery<Visitante> consulta = entityManager.createQuery(criteriaQuery);
		
		return consulta.getResultList();
	}
	
	public List<Visitante> listarComCriteriaDataCadastro(LocalDateTime dtCadastro, EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Visitante> criteriaQuery = builder.createQuery(Visitante.class);
		
		Root<Visitante> visitante = criteriaQuery.from(Visitante.class);
		Predicate predicate = builder.greaterThanOrEqualTo(visitante.get("dtCadastro"), dtCadastro);
		
		criteriaQuery.select(visitante);
		criteriaQuery.where(predicate);
		
		TypedQuery<Visitante> consulta = entityManager.createQuery(criteriaQuery);
		
		return consulta.getResultList();
	}

}
