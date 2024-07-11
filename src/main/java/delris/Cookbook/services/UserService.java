package delris.Cookbook.services;

import delris.Cookbook.dto.UserDTO;
import delris.Cookbook.mappers.UserMapper;
import delris.Cookbook.mappers.UserMapperImpl;
import delris.Cookbook.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapperImpl userMapper;


    public List<UserDTO> findAll() {
        return userMapper.toUsersDTOList(userRepository.findAll());
    }

    public UserDTO findByEmail(String email) {
        if(userRepository.findByEmail(email).isPresent()){
            return userMapper.toUserDTO(userRepository.findByEmail(email).get());
        }else {
            return new UserDTO();
        }
    }

    public UserDTO findByUsername(String username){
        if(userRepository.findByUsername(username).isPresent()){
            return userMapper.toUserDTO(userRepository.findByUsername(username).get());
        }else{
            return new UserDTO();
        }
    }

    public UserDTO findById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            return userMapper.toUserDTO(userRepository.findById(id).get());
        } else {
            return new UserDTO();
        }
    }

}
