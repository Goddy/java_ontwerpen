package service;

import model.Employee;

/**
 * Created by u0090265 on 4/9/14.
 */
public interface AuthenticationService {
    Employee authenticate(String user, String password);
}
