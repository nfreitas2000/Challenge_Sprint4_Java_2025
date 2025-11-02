package org.acme.Service;

import jakarta.inject.Inject;
import org.acme.Repository.RepositoryContaPaciente;
import org.acme.Repository.RepositoryPaciente;

public class ServiceLoginPaciente {
    @Inject
    RepositoryContaPaciente repositoryContaPaciente;
}
