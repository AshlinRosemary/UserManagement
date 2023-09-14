package io.ashlin.restfulwebservices.mapper;

import io.ashlin.restfulwebservices.dto.UserDto;
import io.ashlin.restfulwebservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
/*To use mapstruct , both User & UserDto must have same field names , otherwise we have
    // Suppose UserDto is having field name as emailAddress & User having email
    //In that case , we have to map different field name as below(Source is JPA entity USer & Target is USerDto emailAddress)

@Mapping(source ="email" ,target ="emailAddress")*/
//Mapper utitlity class for implementation at compiling time
    AutoUserMapper Mapper= Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);


}
