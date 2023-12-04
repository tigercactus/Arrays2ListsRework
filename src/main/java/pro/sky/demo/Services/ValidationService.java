package pro.sky.demo.Services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.demo.Exceptions.IncorrectNameException;
import pro.sky.demo.Exceptions.IncorrectSurnameException;

@Service

public class ValidationService {
  public String validatedName(String name){
      if(!StringUtils.isAlpha(name)){
          throw new IncorrectNameException();
      } else {
         return StringUtils.capitalize(StringUtils.capitalize(name.toLowerCase()));
      }
  }

    public String validatedSurname(String surname){
        if(!StringUtils.isAlpha(surname)){
            throw new IncorrectSurnameException();
        } else {
            return StringUtils.capitalize(StringUtils.capitalize(surname.toLowerCase()));
        }
    }
}
