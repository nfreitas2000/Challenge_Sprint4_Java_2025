package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Repository.RepositoryContaPaciente;
import org.acme.Repository.RepositoryPaciente;

@ApplicationScoped
public class ServiceLoginPaciente {
    @Inject
    RepositoryContaPaciente repositoryContaPaciente;
}
