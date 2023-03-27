package rats.BM.Service;

import org.springframework.transaction.annotation.Transactional;
import rats.BM.Domain.User;
import rats.BM.Repository.UserRepository;

import java.util.List;

@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User find(User user) throws Exception {
        List<User> m = userRepository.findByID(user.getUserID());
        if(m.isEmpty()){
            throw new IDException("존재하지 않는 ID");
        } else {
            for(User u : m){
                if(u.getUserPW().equals(user.getUserPW())){
                    return u;
                }
            }
            throw new PWException("존재하지 않는 PW");
        }
    }

    public class IDException extends Exception {
        public IDException() {
            super();
        }

        public IDException(String message) {
            super(message);
        }
    }

    public class PWException extends Exception {
        public PWException() {
            super();
        }

        public PWException(String message) {
            super(message);
        }
    }
}
