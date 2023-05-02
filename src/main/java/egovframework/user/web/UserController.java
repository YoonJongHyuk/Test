package egovframework.user.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.user.service.UserService;
import egovframework.user.service.UserDefaultVO;
import egovframework.user.service.UserVO;

/**
 * @Class Name : UserController.java
 * @Description : User Controller class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-04-16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=UserVO.class)
public class UserController {

    @Resource(name = "userService")
    private UserService userService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * user 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 UserDefaultVO
	 * @return "/user/UserList"
	 * @exception Exception
	 */
    @RequestMapping(value="/user/UserList.do")
    public String selectUserList(@ModelAttribute("searchVO") UserDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> userList = userService.selectUserList(searchVO);
        model.addAttribute("resultList", userList);
        
        int totCnt = userService.selectUserListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/user/UserList";
    } 
    
    @RequestMapping("/user/checkUserLogin.do")
    public String checkUserLogin(
            UserVO userVO, Model model, HttpServletRequest request) throws Exception {
    	System.out.println("id : " + userVO.getId());
    	System.out.println("userid : " + userVO.getUserid());
    	System.out.println("userpass : " + userVO.getUserpass());
    	userVO = userService.checkUserLogin(userVO);
    	System.out.println("id : " + userVO.getId());
    	System.out.println("userid : " + userVO.getUserid());
    	System.out.println("userpass : " + userVO.getUserpass());
    	model.addAttribute("result", userVO);
    	
    	request.getSession().setAttribute("loginedUserVO", userVO);
    	return "redirect:/mainMgr.jsp";
    }
    
    @RequestMapping("/user/userLogout.do")
    public String userLogout(HttpServletRequest request) throws Exception {
    	request.getSession().removeAttribute("loginedUserVO");
    	return "redirect:/index.jsp";
    }
    
    @RequestMapping("/user/userJoin.do")
    public String userJoin(
            UserVO userVO, HttpServletRequest request) {
    	try {
    		userVO = userService.userJoin(userVO);
    	} catch (Exception e) {
    		userVO = null;
    	}
    	request.getSession().setAttribute("insertedLogin", userVO);
    	
    	return "redirect:/index.jsp";
    }
    
    @RequestMapping("/user/addUserView.do")
    public String addUserView(
            @ModelAttribute("searchVO") UserDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("userVO", new UserVO());
        return "/user/UserRegister";
    }
    
    @RequestMapping("/user/addUser.do")
    public String addUser(
            UserVO userVO,
            @ModelAttribute("searchVO") UserDefaultVO searchVO, SessionStatus status)
            throws Exception {
        userService.insertUser(userVO);
        status.setComplete();
        return "forward:/user/UserList.do";
    }
    
    @RequestMapping("/user/updateUserView.do")
    public String updateUserView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") UserDefaultVO searchVO, Model model)
            throws Exception {
        UserVO userVO = new UserVO();
        userVO.setId(id);        
        // 변수명은 CoC 에 따라 userVO
        model.addAttribute(selectUser(userVO, searchVO));
        return "/user/UserRegister";
    }

    @RequestMapping("/user/selectUser.do")
    public @ModelAttribute("userVO")
    UserVO selectUser(
            UserVO userVO,
            @ModelAttribute("searchVO") UserDefaultVO searchVO) throws Exception {
        return userService.selectUser(userVO);
    }

    @RequestMapping("/user/updateUser.do")
    public String updateUser(
            UserVO userVO,
            @ModelAttribute("searchVO") UserDefaultVO searchVO, SessionStatus status)
            throws Exception {
        userService.updateUser(userVO);
        status.setComplete();
        return "forward:/user/UserList.do";
    }
    
    @RequestMapping("/user/deleteUser.do")
    public String deleteUser(
            UserVO userVO,
            @ModelAttribute("searchVO") UserDefaultVO searchVO, SessionStatus status)
            throws Exception {
        userService.deleteUser(userVO);
        status.setComplete();
        return "forward:/user/UserList.do";
    }

}
