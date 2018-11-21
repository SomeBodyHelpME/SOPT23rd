package org.sopt.report3.service;

import org.sopt.report3.model.DefaultRes;
import org.sopt.report3.model.User;
import java.util.List;

public interface UserService {
    DefaultRes getAllUsers();

    DefaultRes findByUserIdx(final int userIdx);

    DefaultRes findByName(final String name);

    DefaultRes findByPart(final String part);

    DefaultRes save(final User user);

    DefaultRes update(final int userIdx, final User user);

    DefaultRes deleteByUserIdx(final int userIdx);
}
