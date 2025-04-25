package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.config.JwtConstant;
import Netflix.Netflix_Clone.config.JwtProvider;
import Netflix.Netflix_Clone.model.User;
import Netflix.Netflix_Clone.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByJwtToken(String jwt) throws Exception {

        SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt.substring(7)).getBody();

        String email = claims.get("email", String.class);
        if (email == null || email.isEmpty()) {
            throw new Exception("Email not found in token");
        }

        return findUserByEmail(email);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {

        User user = userRepository.findByEmail(email.toLowerCase());

        if(user==null) {
            throw new Exception("User not found");
        }

        return user;
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);

    }
}
