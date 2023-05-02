package egovframework.user.service.impl;

import java.util.List;

import egovframework.user.service.UserVO;
import egovframework.user.service.UserDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : UserMapper.java
 * @Description : User Mapper Class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-04-16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("userMapper")
public interface UserMapper {

	/**
	 * user을 등록한다.
	 * @param vo - 등록할 정보가 담긴 UserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertUser(UserVO vo) throws Exception;

    /**
	 * user을 수정한다.
	 * @param vo - 수정할 정보가 담긴 UserVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateUser(UserVO vo) throws Exception;

    /**
	 * user을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 UserVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteUser(UserVO vo) throws Exception;

    /**
	 * user을 조회한다.
	 * @param vo - 조회할 정보가 담긴 UserVO
	 * @return 조회한 user
	 * @exception Exception
	 */
    public UserVO selectUser(UserVO vo) throws Exception;
    public UserVO selectUserbyId(UserVO vo) throws Exception;

    /**
	 * user 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return user 목록
	 * @exception Exception
	 */
    public List<?> selectUserList(UserDefaultVO searchVO) throws Exception;

    /**
	 * user 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return user 총 갯수
	 * @exception
	 */
    public int selectUserListTotCnt(UserDefaultVO searchVO);
    
    public UserVO checkUserLogin(UserVO userVO);
    public void userJoin(UserVO userVO);

}
