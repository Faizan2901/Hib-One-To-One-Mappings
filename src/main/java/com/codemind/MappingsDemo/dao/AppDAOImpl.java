package com.codemind.MappingsDemo.dao;

import com.codemind.MappingsDemo.entity.Instructor;
import com.codemind.MappingsDemo.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {

        System.out.println("Instructor Id which will be deleted : "+id);

        Instructor instructor=entityManager.find(Instructor.class,id);
        System.out.println("Deleting instructor...");
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id) {
        return entityManager.find(InstructorDetails.class,id);
    }
}
