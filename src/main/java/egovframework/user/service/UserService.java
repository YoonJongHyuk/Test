package egovframework.user.service;

import java.util.List;
import egovframework.user.service.UserDefaultVO;
import egovframework.user.service.UserVO;

/**
 * @Class Name : UserService.java
 * @Description : User Business class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-04-16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface UserService {
	
	/**
	 * user을 등록한다.
	 * @param vo - 등록할 정보가 담긴 UserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertUser(UserVO vo) throws Exception;
    
    /**
	 * user을 수정한다.
	 * @param vo - 수정할 정보가 담긴 UserVO
	 * @return void형
	 * @exception Exception
	 */
    void updateUser(UserVO vo) throws Exception;
    
    /**
	 * user을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 UserVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteUser(UserVO vo) throws Exception;
    
    /**
	 * user을 조회한다.
	 * @param vo - 조회할 정보가 담긴 UserVO
	 * @return 조회한 user
	 * @exception Exception
	 */
    UserVO selectUser(UserVO vo) throws Exception;
    UserVO selectUserbyId(UserVO vo) throws Exception;
    
    /**
	 * user 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return user 목록
	 * @exception Exception
	 */
    List selectUserList(UserDefaultVO searchVO) throws Exception;
    
    /**
	 * user 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return user 총 갯수
	 * @exception
	 */
    int selectUserListTotCnt(UserDefaultVO searchVO);

	UserVO checkUserLogin(UserVO userVO);
	UserVO userJoin(UserVO userVO) throws Exception;


    
}
