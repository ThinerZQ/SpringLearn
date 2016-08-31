package com.data.repository;

import com.data.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Intellij IDEA
 * Date: 16-4-29
 * Time: 下午10:31
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
@Transactional
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByPhoneStartingWithAndAddressContaining(String phone, String address);

    List<User> findTop2ByPhoneStartingWithAndAddressContaining(String phone, String address);

    List<User> findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc(String phone, String address);


    Page<User> findByPhoneStartingWithAndAddressContainingOrderByPhoneDesc(String phone, String address, Pageable pageable);






}
