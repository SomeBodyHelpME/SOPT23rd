package org.sopt.report3.service.impl;

import org.sopt.report3.model.DefaultRes;
import org.sopt.report3.model.User;
import org.sopt.report3.service.UserService;
import org.sopt.report3.utils.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final List<User> userList = new LinkedList<>();
    @Override
    public DefaultRes getAllUsers() {
        if (userList.isEmpty()) return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.EMPTY_LIST);
        return DefaultRes.res(HttpStatus.OK.value(), ResponseMessage.READ_USERLIST, userList);
    }

    @Override
    public DefaultRes findByUserIdx(int userIdx) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUser_idx() == userIdx) {
                return DefaultRes.res(HttpStatus.OK.value(), "유저있음", user);
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "유저없음");
    }

    @Override
    public DefaultRes findByName(String name) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getName().equals(name)) {
                return DefaultRes.res(HttpStatus.OK.value(), "유저있음", user);
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "유저없음");
    }

    @Override
    public DefaultRes findByPart(String part) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getPart().equals(part)) {
                return DefaultRes.res(HttpStatus.OK.value(), "유저있음", user);
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "유저없음");
    }

    @Override
    public DefaultRes save(User user) {
        userList.add(user);
        return DefaultRes.res(HttpStatus.OK.value(), "세이브 성공");
    }

    @Override
    public DefaultRes update(int userIdx, User user) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User olduser = iterator.next();
            if (olduser.getUser_idx() == userIdx) {
                userList.set(olduser.getUser_idx(), user);
                return DefaultRes.res(HttpStatus.OK.value(), "잘바뀜", user);
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "안바뀜");
    }

    @Override
    public DefaultRes deleteByUserIdx(int userIdx) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUser_idx() == userIdx) {
                userList.remove(user);
                return DefaultRes.res(HttpStatus.OK.value(), "지워짐");
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "안지워짐");
    }
}
