package zubcic.travel.travelapplication.services;

import zubcic.travel.travelapplication.dto.CreateUserDto;
import zubcic.travel.travelapplication.model.User;

public interface UserService {
    String login(String username, String password);

    User register(CreateUserDto userDto);
}
