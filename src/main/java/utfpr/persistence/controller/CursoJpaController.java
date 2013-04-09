/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import inscricao.persistence.entity.Idioma;
import inscricao.persistence.entity.Cursos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Diogo
 */
public class CursoJpaController extends JpaController {

    public CursoJpaController() {
    }

    public List<Cursos> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Cursos> cq = cb.createQuery(Cursos.class);
            cq.from(Cursos.class);
            TypedQuery<Cursos> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
}
