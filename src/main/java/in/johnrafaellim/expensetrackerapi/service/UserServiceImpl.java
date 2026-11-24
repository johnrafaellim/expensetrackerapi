package in.johnrafaellim.expensetrackerapi.service;

import in.johnrafaellim.expensetrackerapi.entity.User;
import in.johnrafaellim.expensetrackerapi.entity.UserModel;
import in.johnrafaellim.expensetrackerapi.exception.ItemAlreadyExistsException;
import in.johnrafaellim.expensetrackerapi.exception.ResourceNotFoundException;
import in.johnrafaellim.expensetrackerapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public User createUser(UserModel uModel) {
        if (userRepo.existsByEmail(uModel.getEmail())) {
            throw new ItemAlreadyExistsException("User is already registered with email: " + uModel.getEmail());
        }

        User newUser = new User();
        BeanUtils.copyProperties(uModel, newUser);
        return userRepo.save(newUser);
    }

    @Override
    public User read(Long id) throws ResourceNotFoundException {
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for the id: " + id));
    }

    @Override
    public User update(User userUpdates, Long id) throws ResourceNotFoundException {
        User existingUser = read(id);

        Optional.ofNullable(userUpdates.getName()).ifPresent(existingUser::setName);
        Optional.ofNullable(userUpdates.getEmail()).ifPresent(existingUser::setEmail);
        Optional.ofNullable(userUpdates.getPassword()).ifPresent(existingUser::setPassword);
        Optional.ofNullable(userUpdates.getAge()).ifPresent(existingUser::setAge);

        return userRepo.save(existingUser);
    }

}
