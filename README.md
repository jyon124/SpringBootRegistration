# SpringBootRegistration

#Diplay All users
http://52.53.220.209:8080/jpa/users

#Add New User
http://52.53.220.209:8080/jpa/addNewUser
Request-Type: POST
Body-Format:
    {
        "firstName": "any",
        "lastName": "any",
        "email": "any@mail.com",
        "password": "passworD#1234",
        "dateOfBirth": "??/??/????",
        "gender": "Male or Female"
    }

#Update Password from existing user
http://52.53.220.209:8080/jpa/updatePw/{id}
Request-Type: PUT
Body-Format:
    "newPassword12345@"
    
#Delete a User
http://52.53.220.209:8080/jpa/deleteUser/{id}
Request-Type: DELETE
