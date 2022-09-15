package ua.kv.klykavka.andrii.registrationprocess.repository;

import org.springframework.stereotype.Repository;
import ua.kv.klykavka.andrii.registrationprocess.dto.Project;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RegistrationRepository {

    private Set<Project> registrations = new HashSet<>();

    public Set<Project> getAll(){
        return registrations;
    }

    public void add(Project project){

        registrations.add(project);
    }
}
