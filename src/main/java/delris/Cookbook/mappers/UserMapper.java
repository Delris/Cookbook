package delris.Cookbook.mappers;

import delris.Cookbook.dto.UserGetDTO;
import delris.Cookbook.dto.UserPostDTO;
import delris.Cookbook.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public User toUser(UserGetDTO userDTO);
    public UserGetDTO toUserGetDTO(User user);
    public List<User> toUsersGetList(List<UserGetDTO> userDTOList);
    public List<UserGetDTO> toUsersGetDTOList(List<User> userList);
    public User toUser(UserPostDTO userDTO);
    public UserPostDTO toUserPostDTO(User user);


}
