package br.com.jkcontrol.gcead.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.jkcontrol.gcead.entity.Movimentacao;

public class MovimentacaoDAOImpl extends HibernateGenericDAO<Movimentacao, Long>{
private static MovimentacaoDAOImpl instance = null;
	
	public static MovimentacaoDAOImpl getInstance() {
		if (instance == null) {
			instance = new MovimentacaoDAOImpl();
		}
		
		return instance;
	}
	
	private MovimentacaoDAOImpl() {
		super(Movimentacao.class);
	}
	
	@Override
	public List<Movimentacao> listar(EntityManager entityManager) {
		TypedQuery<Movimentacao> consulta = entityManager.createNamedQuery("Movimentacao.listar", Movimentacao.class);
		return consulta.getResultList();
	}
}
