package delris.Cookbook.mappers;

import delris.Cookbook.dto.UserDTO;
import delris.Cookbook.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public User toUser(UserDTO userDTO);

    public UserDTO toUserDTO(User user);

    public List<User> toUsersList(List<UserDTO> userDTOList);

    public List<UserDTO> toUsersDTOList(List<User> userList);

}
