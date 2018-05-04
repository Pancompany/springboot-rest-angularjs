package com.pancompany.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Terence on 12/02/2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
