package ImageHoster.service;

import ImageHoster.model.User;
import ImageHoster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Call the registerUser() method in the UserRepository class to persist the user record in the database
    public void registerUser(User newUser) {
        userRepository.registerUser(newUser);
    }

    //Since we did not have any user in the database, therefore the user with username 'upgrad' and password 'password' was hard-coded
    //This method returned true if the username was 'upgrad' and password is 'password'
    //But now let us change the implementation of this method
    //This method receives the User type object
    //Calls the checkUser() method in the Repository passing the username and password which checks the username and password in the database
    //The Repository returns User type object if user with entered username and password exists in the database
    //Else returns null
    public User login(User user) {
        User existingUser = userRepository.checkUser(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return existingUser;
        } else {
            return null;
        }
    }
    
    //We are verifying the password strength in this method by checking through the conditions 
    //3 checks are conducted for alphabets, numbers and special characters respectively
	public boolean verifyPasswordStrength(String password) {
		// TODO Auto-generated method stub
		boolean isAlphabet = false;
		boolean isNumber = false;
		boolean isSpecial = false;
		int asciiOfCharacter;
		for(char character : password.toCharArray()) {
			asciiOfCharacter = (int)character;
			if(isAlphabet && isNumber && isSpecial)
				break;
			if(asciiOfCharacter>=48 && asciiOfCharacter<=57) {
				isNumber = true;
			}
			else if((asciiOfCharacter>=65 && asciiOfCharacter<=90) || (asciiOfCharacter>=97 && asciiOfCharacter<=122)) {
				isAlphabet = true;
			}
			else {
				isSpecial = true;
			}
		}
		if(isAlphabet && isNumber && isSpecial)
			return true;
		return false;
	}

}
