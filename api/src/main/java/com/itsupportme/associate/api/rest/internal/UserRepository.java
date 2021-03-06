package com.itsupportme.associate.api.rest.internal;


import com.itsupportme.associate.api.component.security.RoleSecured;
import com.itsupportme.associate.entity.component.security.Role;
import com.itsupportme.associate.entity.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
@RoleSecured(Role.ROLE_USER_READ)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Override
    @RoleSecured(Role.ROLE_USER_WRITE)
    <S extends User>S save(S entity);

    @Override
    @RoleSecured(Role.ROLE_USER_DELETE)
    void delete(Long id);


}
