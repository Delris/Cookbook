package delris.Cookbook.services;

import delris.Cookbook.dto.UserGetDTO;
import delris.Cookbook.dto.UserPostDTO;
import delris.Cookbook.entities.User;
import delris.Cookbook.mappers.UserMapper;
import delris.Cookbook.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public List<UserGetDTO> findAll() {
        return userMapper.toUsersGetDTOList(userRepository.findAll());
    }

    public UserGetDTO findById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            return userMapper.toUserGetDTO(userRepository.findById(id).get());
        } else {
            return new UserGetDTO();
        }
    }

    public UserPostDTO createUser(UserPostDTO userPostDTO) {
        User user = userMapper.toUser(userPostDTO);
        User createdUser = userRepository.save(user);
        return userMapper.toUserPostDTO(createdUser);

    }
}
