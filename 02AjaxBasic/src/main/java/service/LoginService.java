package service;

import exceptions.WrongPasswordException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by u0090265 on 4/3/14.
 */
public interface LoginService {
    void login (HttpServletRequest request) throws WrongPasswordException;
}
