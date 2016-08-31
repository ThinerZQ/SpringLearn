package com.data.test;

import com.data.exception.UserNotFound;
import com.data.model.User;
import com.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Intellij IDEA
 * Date: 16-4-29
 * Time: 下午10:34
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
@Component
public class Client implements CommandLineRunner{

    @Autowired
    UserService userService;

    public void testAdd(){

        User user = new User();
        user.setAddress(" tianhe 1 hao");
        user.setName("zhengqiang ");
        user.setPhone("2345");
        userService.addUser(user);

    }
    public void testList(){

        List<User> userList = userService.getALlUsers();
        for (User user : userList) {
            printUser(user);
        }
    }
    public void testUpdate(){
        User user = new User();
        user.setId(1);
        user.setAddress("bei jing road one");
        try {
            userService.updateUser(user);
        } catch (UserNotFound userNotFound) {
            userNotFound.printStackTrace();
        }

    }
    public void testDelete(){

    }

    public void findByPhoneStartingWithAndAddressContaining(){

        System.out.println("----------------------------findByPhoneStartingWithAndAddressContaining------------------------------");
        List<User> users = userService.findByPhoneStartingWithAndAddressContaining("156","bei");

        for (User user :
                users) {
            System.out.println(user);
        }
    }
    public void findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc(){

        System.out.println("------------------------findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc---------------------------");
        List<User> users = userService.findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc("156","bei");

        for (User user :
                users) {
            System.out.println(user);
        }
    }

    public void findByPhoneStartingWithAndAddressContainingOrderByPhoneDescPagable(){

        System.out.println("------------------------findByPhoneStartingWithAndAddressContainingOrderByPhoneDescPagable---------------------------");
        Page<User> userPage = userService.findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc("156","bei",new PageRequest(1,3));
        List<User> userList = userPage.getContent();

        for (User user :
                userList) {
            System.out.println(user);
        }
    }


    private void printUser(User user){
        System.out.println(user);
    }

    public void run(String... strings) throws Exception {


        //testAdd();
        //testUpdate();
        //testList();
        //userService.initUsers();

        findByPhoneStartingWithAndAddressContaining();
        findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc();
        findByPhoneStartingWithAndAddressContainingOrderByPhoneDescPagable();
    }
}
