package zubcic.travel.travelapplication.services;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import zubcic.travel.travelapplication.dto.CreateUserDto;
import zubcic.travel.travelapplication.exception.ExistingUsernameException;
import zubcic.travel.travelapplication.exception.InvalidUserException;
import zubcic.travel.travelapplication.mapper.UserMapper;
import zubcic.travel.travelapplication.model.Role;
import zubcic.travel.travelapplication.model.User;
import zubcic.travel.travelapplication.repositories.UserRepository;
import zubcic.travel.travelapplication.security.JwtTokenProvider;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
    }

    public String login(String username, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, (Role) ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getAuthorities().iterator().next());
        } catch (AuthenticationException ex) {
            throw new InvalidUserException("Invalid username/password", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    @Transactional
    public User register(CreateUserDto userDto) {
        if(!userRepository.existsByUsername(userDto.getUsername())) {
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            User user = userMapper.toEntity(userDto);
            user = userRepository.save(user);
            return user;
        } else {
            throw new ExistingUsernameException("Username is already in use");
        }
    }
}
