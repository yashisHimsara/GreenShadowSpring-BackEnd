package com.example.greenshadowbackend.service.impl;

import com.example.greenshadowbackend.CustomStatusCode.ErrorStatusCodes;
import com.example.greenshadowbackend.Dao.UserDao;
import com.example.greenshadowbackend.dto.UserStatus;
import com.example.greenshadowbackend.dto.impl.UserDto;
import com.example.greenshadowbackend.entity.impl.UserEntity;
import com.example.greenshadowbackend.exception.DataPersistException;
import com.example.greenshadowbackend.exception.UserNotFoundException;
import com.example.greenshadowbackend.service.UserService;
import com.example.greenshadowbackend.util.AppUtil;
import com.example.greenshadowbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapping userMapping;
    @Override
    public void saveUser(UserDto userDto) {
         userDao.save(userMapping.toUserEntity(userDto));

    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapping.asUserDtoList(userDao.findAll());
    }

    @Override
    public UserStatus getUser(String userId) {
        if (userDao.existsById(userId)) {
            var selectedUser = userDao.getReferenceById(userId);
            return userMapping.toUserDto(selectedUser);
        }else {
            return new ErrorStatusCodes(1,"Selected User not found");
        }
    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> selectedUser=userDao.findById(userId);
        if (!selectedUser.isPresent()){
            throw new DataPersistException("Selected User not found");
        }else {
            userDao.deleteById(userId);
        }
    }

    @Override
    public void updateUser(String userId, UserDto userDto) {
        Optional<UserEntity> findUser=userDao.findById(userId);
        if (!findUser.isPresent()){
            throw new UserNotFoundException("Selected User not found");
        }else {
            findUser.get().setEmail(userDto.getEmail());
            findUser.get().setPassword(userDto.getPassword());
            findUser.get().setRole(userDto.getRole());
        }
    }
}
