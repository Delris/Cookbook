package delris.Cookbook.services;

import delris.Cookbook.dto.UserDTO;
import delris.Cookbook.entities.User;
import delris.Cookbook.mappers.UserMapper;
import delris.Cookbook.mappers.UserMapperImpl;
import delris.Cookbook.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapperImpl userMapper;


    public List<UserDTO> findAll() {
        return userMapper.toUsersDTOList(userRepository.findAll());
    }

    public UserDTO findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return userMapper.toUserDTO(user.get());
        }else {
            return new UserDTO();
        }
    }

    public UserDTO findByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            return userMapper.toUserDTO(user.get());
        }else{
            return new UserDTO();
        }
    }

    public UserDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userMapper.toUserDTO(user.get());
        } else {
            return new UserDTO();
        }
    }

}
