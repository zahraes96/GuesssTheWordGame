package iRepository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IUser extends JpaRepository<User, Long> {


}
