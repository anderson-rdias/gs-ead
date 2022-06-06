package br.com.jkcontrol.gcead.service;

import java.util.List;

import br.com.jkcontrol.gcead.dao.impl.PortariaDAOImpl;
import br.com.jkcontrol.gcead.entity.Portaria;
import br.com.jkcontrol.gcead.service.GenericService;

public class PortariaServiceImpl extends GenericService<Portaria, Long>{

	private static PortariaServiceImpl instance = null;

    private PortariaDAOImpl portariaDAO;


    private PortariaServiceImpl() {
        portariaDAO = PortariaDAOImpl.getInstance();
    }

    public static PortariaServiceImpl getInstance() {

        if (instance == null) {
            instance = new PortariaServiceImpl();
        }

        return instance;
    }

    @Override
    public void inserir(Portaria portaria) {
        try {
            portariaDAO.salvar(portaria, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Portaria portaria) {
        try {
            portariaDAO.atualizar(portaria, getEntityManager());
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public void remover(Long id) {
        try {
            portariaDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public Portaria obter(Long id) {
        Portaria portaria = null;

        try {
            portaria = portariaDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return portaria;
    }

    @Override
    public List<Portaria> listar() {
        List<Portaria> portarias = null;

        try {
            portarias = portariaDAO.listar(getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return portarias;
    }

}
