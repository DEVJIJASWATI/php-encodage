package org.app.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String matricule , String password);
}
