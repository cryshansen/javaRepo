package entity;

import org.springframework.validation.*;

/**
 * This class is used the validate the fields in the entity class Office.
 * @author swu
 * @version 2007.09.21
 */
public class OfficeValidator implements Validator {
	
	// These constants define the maximum string length for each field
	private static final int OFFICECODE_MAXLENGTH = 10;
	private static final int CITY_MAXLENGTH = 50;
	private static final int PHONE_MAXLENGTH = 50;
	private static final int ADDRESSLINE1_MAXLENGTH = 50;
	private static final int ADDRESSLINE2_MAXLENGTH = 50;
	private static final int STATE_MAXLENGTH = 50;
	private static final int COUNTRY_MAXLENGTH = 50;
	private static final int POSTALCODE_MAXLENGTH = 15;
	private static final int TERRITORY_MAXLENGTH = 10;	
	
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return Office.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		// specify which fields are required.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officeCode", "field.required","OfficeCode is a required field.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "field.required","City is a required field.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "field.required","Phone is a required field.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", "field.required","Address 1 is a required field.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "field.required","Country is a required field.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postalCode", "field.required","Postal Code is a required field.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "territory", "field.required","Territory is a required field.");
		
		// specify which string fields contain too many characters 
		Office office = (Office) target;
		if( office.getOfficeCode() != null &&  office.getOfficeCode().length() > OFFICECODE_MAXLENGTH ) {
			errors.rejectValue("officeCode", "field.max.length","OfficeCode cannot contain more than " + OFFICECODE_MAXLENGTH + " characters.");
		}
		if( office.getCity() != null &&  office.getCity().length() > CITY_MAXLENGTH ) {
			errors.rejectValue("city", "field.max.length","City cannot contain more than " + CITY_MAXLENGTH + " characters.");
		}
		if( office.getPhone() != null &&  office.getPhone().length() > PHONE_MAXLENGTH ) {
			errors.rejectValue("phone", "field.max.length","Phone cannot contain more than " + PHONE_MAXLENGTH + " characters.");
		}
		if( office.getAddressLine1() != null &&  office.getAddressLine1().length() > ADDRESSLINE1_MAXLENGTH ) {
			errors.rejectValue("addressLine1", "field.max.length","Address 1 cannot contain more than " + ADDRESSLINE1_MAXLENGTH + " characters.");
		}
		if( office.getAddressLine2() != null &&  office.getAddressLine2().length() > ADDRESSLINE2_MAXLENGTH ) {
			errors.rejectValue("addressLine2", "field.max.length","Address 2 cannot contain more than " + ADDRESSLINE2_MAXLENGTH + " characters.");
		}
		if( office.getProvince()!= null &&  office.getProvince().length() > STATE_MAXLENGTH ) {
			errors.rejectValue("state", "field.max.length","State cannot contain more than " + STATE_MAXLENGTH + " characters.");
		}
		if( office.getCountry() != null &&  office.getCountry().length() > COUNTRY_MAXLENGTH ) {
			errors.rejectValue("country", "field.max.length","Country cannot contain more than " + COUNTRY_MAXLENGTH + " characters.");
		}
		if( office.getPostalCode()!= null &&  office.getPostalCode().length() > POSTALCODE_MAXLENGTH ) {
			errors.rejectValue("postalCode", "field.max.length","Postal Code cannot contain more than " + POSTALCODE_MAXLENGTH + " characters.");
		}
		if( office.getTerritory() != null &&  office.getTerritory().length() > TERRITORY_MAXLENGTH ) {
			errors.rejectValue("territory", "field.max.length","Territory cannot contain more than " + TERRITORY_MAXLENGTH + " characters.");
		}
		//errors.rejectValue("field","errorCode","default message");
		//errors.reject("code","default message");
	}

}
