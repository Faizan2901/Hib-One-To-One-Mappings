package com.codemind.MappingsDemo.dao;

import com.codemind.MappingsDemo.entity.Instructor;
import com.codemind.MappingsDemo.entity.InstructorDetails;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetails findInstructorDetailsById(int id);
}
