package br.com.jkcontrol.gcead.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.jkcontrol.gcead.dao.impl.VisitanteDAOImpl;
import br.com.jkcontrol.gcead.entity.Visitante;

public class VisitanteServiceImpl extends GenericService<Visitante, Long>{

	private static VisitanteServiceImpl instance = null;

    private VisitanteDAOImpl visitanteDAO;

    private VisitanteServiceImpl() {
        visitanteDAO = VisitanteDAOImpl.getInstance();
    }

    public static VisitanteServiceImpl getInstance() {

        if (instance == null) {
            instance = new VisitanteServiceImpl();
        }

        return instance;
    }

    @Override
    public void inserir(Visitante visitante) {
        try {
            visitanteDAO.salvar(visitante, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Visitante visitante) {
        try {
            visitanteDAO.atualizar(visitante, getEntityManager());
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public void remover(Long id) {
        try {
            visitanteDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public Visitante obter(Long id) {
        Visitante visitante = null;

        try {
            visitante = visitanteDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return visitante;
    }

    @Override
    public List<Visitante> listar() {
        List<Visitante> visitantes = null;

        try {
            visitantes = visitanteDAO.listar(getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return visitantes;
    }
    
    public List<Visitante> listarComCriteriaNome(String nome) {
		List<Visitante> visitantes = null;
		
		try {
			visitantes = visitanteDAO.listarComCriteriaNome(nome, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return visitantes;
	}
    
    public List<Visitante> listarComCriteriaCpf(String cpf) {
		List<Visitante> visitantes = null;
		
		try {
			visitantes = visitanteDAO.listarComCriteriaCpf(cpf, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return visitantes;
	}
    
    public List<Visitante> listarComCriteriaDataCadastro(LocalDateTime dtCadastro) {
		List<Visitante> visitantes = null;
		
		try {
			visitantes = visitanteDAO.listarComCriteriaDataCadastro(dtCadastro, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return visitantes;
	}

}
