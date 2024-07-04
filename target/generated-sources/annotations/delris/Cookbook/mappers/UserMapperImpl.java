package delris.Cookbook.mappers;

import delris.Cookbook.dto.UserGetDTO;
import delris.Cookbook.dto.UserPostDTO;
import delris.Cookbook.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-04T13:11:28+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserGetDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDTO.getUserId() );
        user.setName( userDTO.getName() );
        user.setSurname( userDTO.getSurname() );

        return user;
    }

    @Override
    public UserGetDTO toUserGetDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserGetDTO userGetDTO = new UserGetDTO();

        if ( user.getUserId() != null ) {
            userGetDTO.setUserId( user.getUserId() );
        }
        userGetDTO.setName( user.getName() );
        userGetDTO.setSurname( user.getSurname() );

        return userGetDTO;
    }

    @Override
    public List<User> toUsersGetList(List<UserGetDTO> userDTOList) {
        if ( userDTOList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDTOList.size() );
        for ( UserGetDTO userGetDTO : userDTOList ) {
            list.add( toUser( userGetDTO ) );
        }

        return list;
    }

    @Override
    public List<UserGetDTO> toUsersGetDTOList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserGetDTO> list = new ArrayList<UserGetDTO>( userList.size() );
        for ( User user : userList ) {
            list.add( toUserGetDTO( user ) );
        }

        return list;
    }

    @Override
    public User toUser(UserPostDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDTO.getUserId() );
        user.setName( userDTO.getName() );
        user.setSurname( userDTO.getSurname() );
        user.setPassword( userDTO.getPassword() );

        return user;
    }

    @Override
    public UserPostDTO toUserPostDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserPostDTO userPostDTO = new UserPostDTO();

        if ( user.getUserId() != null ) {
            userPostDTO.setUserId( user.getUserId() );
        }
        userPostDTO.setName( user.getName() );
        userPostDTO.setSurname( user.getSurname() );
        userPostDTO.setPassword( user.getPassword() );

        return userPostDTO;
    }
}
