package br.com.jkcontrol.gcead.service;

import java.util.List;

import br.com.jkcontrol.gcead.dao.impl.MovimentacaoDAOImpl;
import br.com.jkcontrol.gcead.entity.Movimentacao;

public class MovimentacaoServiceImpl extends GenericService<Movimentacao, Long>{

	private static MovimentacaoServiceImpl instance = null;

    private MovimentacaoDAOImpl movimentacaoDAO;

    private MovimentacaoServiceImpl() {
        movimentacaoDAO = MovimentacaoDAOImpl.getInstance();
    }

    public static MovimentacaoServiceImpl getInstance() {

        if (instance == null) {
            instance = new MovimentacaoServiceImpl();
        }

        return instance;
    }

    @Override
    public void inserir(Movimentacao movimentacao) {
        try {
            movimentacaoDAO.salvar(movimentacao, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Movimentacao movimentacao) {
        try {
            movimentacaoDAO.atualizar(movimentacao, getEntityManager());
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public void remover(Long id) {
        try {
            movimentacaoDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public Movimentacao obter(Long id) {
        Movimentacao movimentacao = null;

        try {
            movimentacao = movimentacaoDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return movimentacao;
    }

    @Override
    public List<Movimentacao> listar() {
        List<Movimentacao> movimentacao = null;

        try {
            movimentacao = movimentacaoDAO.listar(getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return movimentacao;
    }

}
