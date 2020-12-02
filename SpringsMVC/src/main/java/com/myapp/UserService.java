package com.myapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.exception.EmployeeException;

@Service
public class UserService {
	
	public List<String> validateUserInfo(UserInfo userInfoObj) {
		List<String> errors = new ArrayList<>();
		
		int age = userInfoObj.getAge();
		int teleSize =userInfoObj.getTelephone().length();

		if(age<=18 || age>=60){
			errors.add("Age should be between 18 and 60.");
		}
		if (teleSize!=10){
			errors.add("telephone should be exactly 10 digits");
		}
		if (!userInfoObj.getEmail().contains("@") && !userInfoObj.getEmail().contains(".")){
			errors.add("Invalid email syntax.");
		}
		return errors;
	}

	
	public void processValidation(UserInfo userInfoObj) throws EmployeeException {
			
			if ((userInfoObj.getTelephone().length() !=10)) {
				String errorMsg ="Telephone should be 10 chars..";
				throw new EmployeeException(errorMsg);
				
			}
			if ((userInfoObj.getFirstname().length() < 10)) {
				String errorMsg ="fistname should contain min 10 characters";
				throw new EmployeeException(errorMsg);
			}
			if ((userInfoObj.getLastname().length() < 8)) {
				String errorMsg ="fistname should contain min 8 characters";
				throw new EmployeeException(errorMsg);
			}

			if (userInfoObj.getAge() < 18 || userInfoObj.getAge() > 60) {
				String errorMsg ="age should be min 18, max 60";
				throw new EmployeeException(errorMsg);
			}
	}
}
