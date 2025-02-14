package com.sha.appointment_booking.repository;
import com.sha.appointment_booking.model.Role;
import com.sha.appointment_booking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

//JpaRepository has different methods we can use. It is a solution for database operations
//JpaRepository has 2 generic parameters, first param is for the model class and the second is for the id class of the model class so in this case <User, Long>

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Modifying // we use this so that the below line can function and the update can be done in our DB
    @Query("update User set role=:role where username=:username")
    void updateUserRole(@Param("username") String username, @Param("role")Role role);
}
