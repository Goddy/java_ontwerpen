package service;


import model.Employee;
import persistence.DaoFactory;
import persistence.EmployeeDao;
import utils.PassCrypter;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class AuthenticationServiceImpl implements AuthenticationService {
	private EmployeeDao emDao;
	
	public AuthenticationServiceImpl(){
		emDao = DaoFactory.getEmployeeDao();
	}
			
	/**
	 * Verify password and return employee when ok
	 * - basic solution	
	 * @param user
	 * @param password
	 * @return
	 */
	@Override
    public Employee authenticate(String user, String password){
		Employee result = null;
		try {
			Employee emp = emDao.findEmployeeByUser(user);
			if(emp != null && PassCrypter.validatePassword(password, emp.getPassword()))
				result = emp;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
