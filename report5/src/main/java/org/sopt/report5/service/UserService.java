package org.sopt.report5.service;

import lombok.extern.slf4j.Slf4j;
import org.sopt.report5.mapper.UserMapper;
import org.sopt.report5.model.User;
import org.sopt.report5.model.DefaultRes;
import org.sopt.report5.utils.ResponseMessage;
import org.sopt.report5.utils.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Slf4j
@Service
public class UserService {

    private final UserMapper userMapper;

    private final FileUploadService fileUploadService;

    /**
     * UserMapper 생성자 의존성 주입
     * FileUploadService 생성자 의존성 주입
     *
     * @param userMapper        userMapper 서비스 객체
     * @param fileUploadService fileUpload 서비스 객체
     */
    public UserService(final UserMapper userMapper, final FileUploadService fileUploadService) {
        this.userMapper = userMapper;
        this.fileUploadService = fileUploadService;
    }


    /**
     * 모든 회원 조회
     *
     * @return DefaultRes
     */
    public DefaultRes getAllUsers() {
        final List<User> userList = userMapper.findAll();
        if (userList.isEmpty())
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.EMPTY_LIST);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USERLIST, userList);
    }

    /**
     * 유저인덱스로 회원 조회
     *
     * @param user_idx 유저인덱스
     * @return DefaultRes
     */
    public DefaultRes findByUserIdx(final int user_idx) {
        final User user = userMapper.findByUserIdx(user_idx);
        if (user == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, user);
    }

    /**
     * 이름으로 회원 조회
     *
     * @param name 이름
     * @return DefaultRes
     */
    public DefaultRes findByName(final String name) {
        final User user = userMapper.findByName(name);
        if (user == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, user);
    }

    /**
     * 파트로 회원 조회
     *
     * @param part 파트
     * @return DefaultRes
     */
    public DefaultRes findByPart(final String part) {
        final User user = userMapper.findByPart(part);
        if (user == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, user);
    }


    /**
     * 회원 가입
     *
     * @param user 회원 데이터
     * @return DefaultRes
     */
    @Transactional
    public DefaultRes save(User user) {
        try {
            //파일이 있다면 파일을 S3에 저장 후 경로를 저장
            if (user.getProfile() != null)
                user.setProfileUrl(fileUploadService.upload(user.getProfile()));

            userMapper.save(user);
            return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_USER);
        } catch (Exception e) {
            //Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 회원 정보 수정
     *
     * @param user_idx 회원 고유 번호
     * @param user    수정할 회원 데이터
     * @return DefaultRes
     */
    @Transactional
    public DefaultRes update(final int user_idx, final User user) {
        User temp = userMapper.findByUserIdx(user_idx);
        if (temp == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);

        try {
            if (user.getName() != null) temp.setName(user.getName());
            if (user.getPart() != null) temp.setPart(user.getPart());
            userMapper.update(user_idx, temp);
            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.UPDATE_USER);
        } catch (Exception e) {
            //Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 회원 탈퇴
     *
     * @param user_idx 회원 고유 번호
     * @return DefaultRes
     */
    @Transactional
    public DefaultRes deleteByUserIdx(final int user_idx) {
        final User user = userMapper.findByUserIdx(user_idx);
        if (user == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);

        try {
            userMapper.deleteByUserIdx(user_idx);
            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.DELETE_USER);
        } catch (Exception e) {
            //Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }
}
