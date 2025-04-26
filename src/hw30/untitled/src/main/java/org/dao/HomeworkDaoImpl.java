package org.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.dto.Homework;

import java.util.List;

public class HomeworkDaoImpl implements GenericDao<Homework, Long> {

    private final EntityManager entityManager;

    public HomeworkDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Homework homework) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(homework);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Homework findById(Long id) {
        return entityManager.find(Homework.class, id);
    }

    @Override
    public Homework findByEmail(String email) {
        throw new UnsupportedOperationException("Homework entity does not have an email field.");
    }

    @Override
    public List<Homework> findAll() {
        TypedQuery<Homework> query = entityManager.createQuery(
                "SELECT h FROM Homework h", Homework.class);
        return query.getResultList();
    }

    @Override
    public Homework update(Homework homework) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Homework updatedHomework = entityManager.merge(homework);
            transaction.commit();
            return updatedHomework;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Homework homework = entityManager.find(Homework.class, id);
            if (homework != null) {
                entityManager.remove(homework);
                transaction.commit();
                return true;
            }
            transaction.rollback();
            return false;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
