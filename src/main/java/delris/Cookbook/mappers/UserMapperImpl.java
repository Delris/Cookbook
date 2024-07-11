package delris.Cookbook.mappers;

import delris.Cookbook.dto.UserDTO;
import delris.Cookbook.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {


    RecipeMapperImpl recipeMapper;

    public UserMapperImpl(RecipeMapperImpl recipeMapper){
        this.recipeMapper = recipeMapper;
    }

    @Override
    public User toUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDTO.getUserId() );
        user.setName( userDTO.getName() );
        user.setSurname( userDTO.getSurname() );
        user.setRecipes( recipeMapper.toRecipes(userDTO.getRecipeList()) );

        return user;
    }

    @Override
    public UserDTO toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        if ( user.getUserId() != null ) {
            userDTO.setUserId( user.getUserId() );
        }
        userDTO.setName( user.getName() );
        userDTO.setSurname( user.getSurname() );

        return userDTO;
    }

    @Override
    public List<User> toUsersList(List<UserDTO> userDTOList) {
        if ( userDTOList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDTOList.size() );
        for ( UserDTO userDTO : userDTOList ) {
            list.add( toUser( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toUsersDTOList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userList.size() );
        for ( User user : userList ) {
            list.add( toUserDTO( user ) );
        }

        return list;
    }
}

