package com.github.gherkin.config;

import javax.inject.Singleton;

import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import com.github.gherkin.persistence.PersonDAO;
import com.github.gherkin.service.ClubService;
import com.github.gherkin.service.ClubServiceImpl;
import com.github.gherkin.service.PersonService;
import com.github.gherkin.service.PersonServiceImpl;
import com.github.gherkin.persistence.ClubDAO;
import com.github.gherkin.persistence.DAO;
import com.github.gherkin.entity.ClubEntity;
import com.github.gherkin.entity.PersonEntity;

public class Application extends ResourceConfig {

    public Application() {

        register(new AbstractBinder() {

            @Override
            protected void configure() {

                bind(PersonServiceImpl.class).to(PersonService.class).in(Singleton.class);
                bind(ClubServiceImpl.class).to(ClubService.class).in(Singleton.class);
                bind(PersonDAO.class).to(new TypeLiteral<DAO<PersonEntity>>(){});
                bind(ClubDAO.class).to(new TypeLiteral<DAO<ClubEntity>>(){});

            }
        });

        packages(true, "com.github.gherkin.api");
    }
}
