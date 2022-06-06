package br.com.jkcontrol.gcead.dao.impl;

import br.com.jkcontrol.gcead.entity.FuncionarioPortaria;

public class FuncPortariaDAOImpl extends HibernateGenericDAO<FuncionarioPortaria, Long>{
	
	private static FuncPortariaDAOImpl instance = null;

    public static FuncPortariaDAOImpl getInstance() {
        if (instance == null) {
            instance = new FuncPortariaDAOImpl();
        }

        return instance;
    }

    private FuncPortariaDAOImpl() {
        super(FuncionarioPortaria.class);
    }

}
