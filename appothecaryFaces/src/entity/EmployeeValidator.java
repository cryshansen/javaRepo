package entity;

import org.springframework.validation.*;

public class EmployeeValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return Employee.class.equals(clazz);	
	}

	public void validate(Object target, Errors errors) {
		// generate field errors if any of required fields are empty.
		// the required fields for employees are: employeeNumber, lastName,
		// firstName, extension, email, officeCode, jobTitle
		ValidationUtils.rejectIfEmptyOrWhitespace(
			errors, 			// store the field error msg here
			"employeeNumber", 	// the field to validate
			"field.required",	// error code - not important now
			"Employee Number is a required field."	// default error msg
		);			
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "field.required",
			"Last Name is a required field.");			
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "field.required",
			"First Name Name is a required field.");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "extension", "field.required",
			"Extension is a required field.");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required",
			"Email is a required field.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officeCode", "field.required",
		"Office Code Name is a required field.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobTitle", "field.required",
		"Last Name is a required field.");	

		// check the string lengths of selected fields
		Employee emp = (Employee) target;
		// generate an error if the officeCode contains more than 10 characters
		if( emp.getOffice().getOfficeCode() != null && emp.getOffice().getOfficeCode().length() > 10 ) {
			errors.rejectValue("officeCode", "",
				"Office Code cannot contain more than 10 characters.");
		}
		if( emp.getExtension() != null && emp.getExtension().length() > 10 ) {
			errors.rejectValue("extension", "",
				"Extension cannot contain more than 10 characters.");
		}
		if( emp.getEmployeeNumber() <= 0 ) {
			errors.rejectValue("employeeNumber", "",
				"Employee Number must be greater than zero");
		}

	
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
