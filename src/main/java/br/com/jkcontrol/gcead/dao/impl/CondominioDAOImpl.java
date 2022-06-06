package br.com.jkcontrol.gcead.dao.impl;

import br.com.jkcontrol.gcead.entity.Condominio;

public class CondominioDAOImpl extends HibernateGenericDAO<Condominio, Long> {

    private static CondominioDAOImpl instance = null;

    public static CondominioDAOImpl getInstance() {
        if (instance == null) {
            instance = new CondominioDAOImpl();
        }

        return instance;
    }

    private CondominioDAOImpl() {
        super(Condominio.class);
    }

}
