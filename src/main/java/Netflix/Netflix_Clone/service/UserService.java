package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.User;

public interface UserService {

    User saveUser(User user);

    public User findUserByJwtToken(String jwt) throws Exception;

    public User findUserByEmail(String email) throws Exception;

    void deleteUser(Long id);

    // createUser( );
}
