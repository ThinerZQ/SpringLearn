package com.data.service;

import com.data.exception.UserNotFound;
import com.data.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij IDEA
 * Date: 16-4-29
 * Time: 下午10:33
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */

public interface UserService {
    // add
     void addUser(User user);
    // update
    User updateUser(User user) throws UserNotFound;
    //
    User deleteUser(int id) throws UserNotFound;
    User getUser(int id);
    List<User> getALlUsers();
    void initUsers();

    List<User> findByPhoneStartingWithAndAddressContaining(String phone, String address);

    List<User> findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc(String phone, String address);


    Page<User> findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc(String phone, String address, Pageable pageable);
}
