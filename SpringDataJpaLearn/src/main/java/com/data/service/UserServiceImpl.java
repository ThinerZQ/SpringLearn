package com.data.service;

import com.data.exception.UserNotFound;
import com.data.model.User;
import com.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Intellij IDEA
 * Date: 16-4-29
 * Time: 下午10:33
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User updateUser(User user) throws UserNotFound{
        User updateUser = userRepository.findOne(user.getId());

        if (updateUser == null)
            throw new UserNotFound();
        if (user.getName() !=null){
            updateUser.setName(user.getName());
        }
        if (user.getAddress()!= null){
            updateUser.setAddress(user.getAddress());
        }
        if (user.getPhone()!= null){
            updateUser.setPhone(user.getPhone());
        }
        userRepository.save(updateUser);
        return updateUser;
    }

    public User deleteUser(int id) throws UserNotFound {
        User deleteUser = userRepository.findOne(id);
        if (deleteUser == null)
            throw new UserNotFound();
        userRepository.delete(deleteUser);
        return deleteUser;
    }

    public User getUser(int id) {
        return userRepository.findOne(id);
    }

    public List<User> getALlUsers() {
        return userRepository.findAll();
    }

    @Override
    public void initUsers() {
        Random random = new Random(System.currentTimeMillis());
        List<User> users = new ArrayList<User>(1000);
        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setName("zheng"+random.nextInt());
            user.setPhone(""+random.nextInt(745822323));
            user.setAddress("beijing"+random.nextInt(62723)+"hao");
            users.add(user);
        }
        userRepository.save(users);
    }

    @Override
    public List<User> findByPhoneStartingWithAndAddressContaining(String phone, String address) {
        return userRepository.findByPhoneStartingWithAndAddressContaining(phone,address);
    }

    @Override
    public List<User> findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc(String phone, String address) {
        return userRepository.findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc(phone,address);
    }

    @Override
    public Page<User> findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc(String phone, String address, Pageable pageable) {
        return userRepository.findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc(phone,address,pageable);
    }
}
