package ua.kv.klykavka.andrii.registrationprocess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.kv.klykavka.andrii.registrationprocess.dto.Project;
import ua.kv.klykavka.andrii.registrationprocess.service.RegistrationService;

import java.util.Collection;
import java.util.Set;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/register-compilation-time", method = RequestMethod.PUT, consumes = "application/json")
    public void add(@RequestBody Project project) {
        registrationService.add(project);
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public Collection<Project> getAll() {
        return registrationService.getAll();
    }

    @RequestMapping(value = "/success-result", method = RequestMethod.GET)
    public Collection<Project> getSuccess(){
        return registrationService.getSuccess();
    }

    @RequestMapping(value = "/failed-result", method = RequestMethod.GET)
    public Collection<Project> getFailed(){
        return registrationService.getFailed();
    }

    @RequestMapping(value = "/normal-compilation", method = RequestMethod.GET)
    public Collection<Project> getNormal(){
        return registrationService.getNormal();
    }

    @RequestMapping(value = "/long-compilation", method = RequestMethod.GET)
    public Collection<Project> getLong(){
        return registrationService.getLong();
    }
}
