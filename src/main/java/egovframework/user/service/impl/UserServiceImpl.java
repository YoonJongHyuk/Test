package egovframework.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.user.service.UserService;
import egovframework.user.service.UserDefaultVO;
import egovframework.user.service.UserVO;
import egovframework.user.service.impl.UserMapper;
/**
 * @Class Name : UserServiceImpl.java
 * @Description : User Business Implement class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-04-16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("userService")
public class UserServiceImpl extends EgovAbstractServiceImpl implements
        UserService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource(name="userMapper")
    private UserMapper userDAO;
    
    //@Resource(name="userDAO")
    //private UserDAO userDAO;
    
    /** ID Generation */
    //@Resource(name="{egovUserIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * user을 등록한다.
	 * @param vo - 등록할 정보가 담긴 UserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertUser(UserVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	userDAO.insertUser(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * user을 수정한다.
	 * @param vo - 수정할 정보가 담긴 UserVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateUser(UserVO vo) throws Exception {
        userDAO.updateUser(vo);
    }

    /**
	 * user을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 UserVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteUser(UserVO vo) throws Exception {
        userDAO.deleteUser(vo);
    }

    /**
	 * user을 조회한다.
	 * @param vo - 조회할 정보가 담긴 UserVO
	 * @return 조회한 user
	 * @exception Exception
	 */
    public UserVO selectUser(UserVO vo) throws Exception {
        UserVO resultVO = userDAO.selectUser(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
    
    public UserVO selectUserbyId(UserVO vo) throws Exception {
		UserVO resultVO = userDAO.selectUserbyId(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

    /**
	 * user 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return user 목록
	 * @exception Exception
	 */
    public List<?> selectUserList(UserDefaultVO searchVO) throws Exception {
        return userDAO.selectUserList(searchVO);
    }
    
    public UserVO userJoin(UserVO userVO) throws Exception {
    	userDAO.userJoin(userVO);
//    	try {
//    		userVO = selectUserbyId(userVO);
//    	} catch (Exception e) {
//    		userVO = null;
//    	}
    	return selectUserbyId(userVO);
    }

    /**
	 * user 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return user 총 갯수
	 * @exception
	 */
    public int selectUserListTotCnt(UserDefaultVO searchVO) {
		return userDAO.selectUserListTotCnt(searchVO);
	}
    
	public UserVO checkUserLogin(UserVO userVO) {
		return userDAO.checkUserLogin(userVO);
	}
    
}
