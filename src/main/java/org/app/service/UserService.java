package org.app.service;

import org.app.model.User;

public interface UserService {

    void save(User user);

    User findByMatricule(String matricule);
}
