package ua.kv.klykavka.andrii.registrationprocess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kv.klykavka.andrii.registrationprocess.dto.Project;
import ua.kv.klykavka.andrii.registrationprocess.exception.RegistrationException;
import ua.kv.klykavka.andrii.registrationprocess.repository.RegistrationRepository;

import java.util.*;
import java.util.stream.Stream;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Collection<Project> getAll() {
        return  registrationRepository.getAll();
    }

    public void add(Project project) {

        for(Project savedProject : registrationRepository.getAll()){
            if(Objects.equals(savedProject.getProjectName(), project.getProjectName())){
                throw new RegistrationException("Project with this name already exists");
            }
        }
        registrationRepository.add(project);
    }

    public Set<Project> getSuccess(){
        Set<Project> successProjects = new HashSet<>();

        for(Project project : registrationRepository.getAll()){
            if(Objects.equals(project.getResult(), "success")){
                successProjects.add(project);
            }
        }
        return Collections.unmodifiableSet(successProjects);
    }

    public Set<Project> getFailed(){
        Set<Project> failedProjects = new HashSet<>();

        for(Project project : registrationRepository.getAll()){
            if(!Objects.equals(project.getResult(), "success")){
                failedProjects.add(project);
            }
        }
        return Collections.unmodifiableSet(failedProjects);
    }

    public Set<Project> getNormal(){
        Set<Project> normalProjects = new HashSet<>();

        for(Project project : registrationRepository.getAll()){
            if(Integer.parseInt(project.getCompilationTime()) < 1000){
                normalProjects.add(project);
            }
        }
        return Collections.unmodifiableSet(normalProjects);
    }

    public Set<Project> getLong(){
        Set<Project> longProjects = new HashSet<>();

        for(Project project : registrationRepository.getAll()){
            if(Integer.parseInt(project.getCompilationTime()) >= 1000){
                longProjects.add(project);
            }
        }
        return Collections.unmodifiableSet(longProjects);
    }
}
