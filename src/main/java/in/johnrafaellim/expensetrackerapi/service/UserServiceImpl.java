package in.johnrafaellim.expensetrackerapi.service;

import in.johnrafaellim.expensetrackerapi.entity.User;
import in.johnrafaellim.expensetrackerapi.entity.UserModel;
import in.johnrafaellim.expensetrackerapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public User create(UserModel uModel) {
        User user = new User();
        BeanUtils.copyProperties(uModel, user);
        return userRepo.save(user);
    }

}
