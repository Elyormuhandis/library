package uz.muhandis.library.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import uz.muhandis.library.dao.PersonDAO;
import uz.muhandis.library.models.Person;

@Component
public class PersonValidator implements Validator {


    PersonDAO personDAO;
    @Autowired
    PersonValidator(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (personDAO.show(person.getFullName()).isPresent()){
            errors.rejectValue("fullName", "", "Такой пользователь уже зарегистрирован!");
        }
    }
}
