package in.johnrafaellim.expensetrackerapi.service;

import in.johnrafaellim.expensetrackerapi.entity.User;
import in.johnrafaellim.expensetrackerapi.entity.UserModel;

public interface UserService {

    User createUser(UserModel user);

}
