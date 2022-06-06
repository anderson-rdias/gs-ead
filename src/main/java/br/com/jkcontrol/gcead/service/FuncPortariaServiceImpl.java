package br.com.jkcontrol.gcead.service;

import java.util.List;

import br.com.jkcontrol.gcead.dao.impl.FuncPortariaDAOImpl;
import br.com.jkcontrol.gcead.entity.FuncionarioPortaria;
import br.com.jkcontrol.gcead.service.GenericService;
import br.com.jkcontrol.gcead.entity.FuncionarioPortaria;

public class FuncPortariaServiceImpl extends GenericService<FuncionarioPortaria, Long>{

	private static FuncPortariaServiceImpl instance = null;

    private FuncPortariaDAOImpl funcPortariaDAO;


    private FuncPortariaServiceImpl() {
        funcPortariaDAO = FuncPortariaDAOImpl.getInstance();
    }

    public static FuncPortariaServiceImpl getInstance() {

        if (instance == null) {
            instance = new FuncPortariaServiceImpl();
        }

        return instance;
    }

    @Override
    public void inserir(FuncionarioPortaria funcPortaria) {
        try {
            funcPortariaDAO.salvar(funcPortaria, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(FuncionarioPortaria funcPortaria) {
        try {
            funcPortariaDAO.atualizar(funcPortaria, getEntityManager());
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public void remover(Long id) {
        try {
            funcPortariaDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public FuncionarioPortaria obter(Long id) {
        FuncionarioPortaria funcPortaria = null;

        try {
            funcPortaria = funcPortariaDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return funcPortaria;
    }

    @Override
    public List<FuncionarioPortaria> listar() {
        List<FuncionarioPortaria> funcionarios = null;

        try {
            funcionarios = funcPortariaDAO.listar(getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return funcionarios;
    }

}
