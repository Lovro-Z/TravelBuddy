package zubcic.travel.travelapplication.mapper;

import org.springframework.stereotype.Component;
import zubcic.travel.travelapplication.dto.CreateUserDto;
import zubcic.travel.travelapplication.model.Role;
import zubcic.travel.travelapplication.model.User;

@Component
public class UserMapper {

    public User toEntity(CreateUserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.CLIENT);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber((userDto.getPhoneNumber()));
        return user;
    }
}
