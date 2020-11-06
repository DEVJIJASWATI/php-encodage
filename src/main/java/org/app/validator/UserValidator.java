package org.app.validator;

import org.app.model.User;
import org.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matricule" , "NotEmpty");
        if (user.getMatricule().length() < 6 || user.getMatricule().length() > 30){
            errors.rejectValue("matricule","Size.userForm.matricule");
        }
        if (userService.findByMatricule(user.getMatricule()) != null){
            errors.rejectValue("matricule","Duplicate.userForm.matricule");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","NotEmpty");
        if (user.getPassword().length() < 6 || user.getPassword().length() > 20){
            errors.rejectValue("password","Size.userForm.password");
        }
        if (!user.getPasswordConfirm().equals(user.getPassword())){
            errors.rejectValue("passwordConfirm","Diff.userForm.passwordConfirm");
        }
    }
}
