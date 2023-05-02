package egovframework.document.web;
import java.io.File;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.document.service.DocumentService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.document.service.DocumentDefaultVO;
import egovframework.document.service.DocumentVO;

/**
 * @Class Name : DocumentController.java
 * @Description : Document Controller class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-04-28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=DocumentVO.class)
public class DocumentController {

    @Resource(name = "documentService")
    private DocumentService documentService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    @Resource(name = "EgovFileMngUtil")
    private EgovFileMngUtil fileUtil;
	
    /**
	 * document 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 DocumentDefaultVO
	 * @return "/document/DocumentList"
	 * @exception Exception
	 */
    @RequestMapping(value="/document/DocumentList.do")
    public String selectDocumentList(@ModelAttribute("searchVO") DocumentDefaultVO searchVO, 
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
		
        List<?> documentList = documentService.selectDocumentList(searchVO);
        model.addAttribute("resultList", documentList);
        
        int totCnt = documentService.selectDocumentListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "forward:/document/mainMgr.do?param=list";
    } 
    
    @RequestMapping(value="/document/searchDocumentVO.do")
    public @ResponseBody ModelAndView searchDocumentVO(DocumentVO vo) throws Exception {
    	vo = documentService.selectDocument(vo);
    	ModelAndView jsonView = new ModelAndView("jsonView");
    	jsonView.addObject("searchVO", vo);
    	return jsonView;
    }
    
    @RequestMapping(value="/document/getDocumentVOListJson.do")
    public @ResponseBody ModelAndView getDocumentVOListJson(DocumentVO vo) throws Exception {
    	List<?> documentList = documentService.selectDocumentList(vo);
    	ModelAndView jsonView = new ModelAndView("jsonView");
    	jsonView.addObject("documentVOList", documentList);
    	return jsonView;
    }
    
    @RequestMapping(value="/document/insertDocumentVO.do")
    public String insertDocumentVO(final MultipartHttpServletRequest multiRequest, DocumentVO vo, ModelMap model
    		) throws Exception {
    	
    	System.out.println("title : " + vo.getTitle() );
    	System.out.println("coontent : " + vo.getContent() );
    	System.out.println("appendix : " + vo.getAppendix() );
    	final Map<String, MultipartFile> files = multiRequest.getFileMap();
    	if(!files.isEmpty()) {
    		Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
    		MultipartFile file;
    		String filePath = "";
    		
    		while (itr.hasNext()) {
    			Entry<String, MultipartFile> entry = itr.next();
    			file = entry.getValue();
    			String orginFileName = file.getOriginalFilename();
    			System.out.println("\n\nn" + orginFileName + "\n");
    			filePath = "C:\\eGovFrame-3.10.0\\workspace.edu\\PrivateProjact\\src\\main\\webapp\\uploads\\" + orginFileName;
    			file.transferTo(new File(filePath));
    			vo.setAppendix("uploads\\" + orginFileName);
    			documentService.insertDocument(vo);
    		}
    	}
    	
    	return "forward:/mainMgr.jsp?param=list";
    	
    }
    
    @RequestMapping(value="/document/mainMgr.do")
    public String mainMgr(DocumentVO vo, ModelMap model
    		, HttpServletRequest request) throws Exception {
       String param = (String)request.getParameter("param");
       if(param.equals("list")) {
          //documentDefaultVO searchVO = new documentDefaultVO();
          List<?> documentList = documentService.selectDocumentList(vo);
          model.addAttribute("resultList", documentList);
       }else if(param.equals("search")) {
    	   //String id = (String)request.getParameter("id");
    	   //documentVO vo = new documentVO();
    	   //vo.setId(Integer.parseInt(id));
    	   System.out.println("id : " + vo.getId());
    	   System.out.println("title : " + vo.getTitle());
    	   vo = documentService.selectDocument(vo);
    	   System.out.println("id : " + vo.getId());
    	   System.out.println("title : " + vo.getTitle());
    	   model.addAttribute("searchVO", vo);
    	   param = "regist";
       } else if(param.equals("regist")) {
    	   System.out.println("param : " + param);
    	   System.out.println("id : " + vo.getId());
    	   System.out.println("content : " + vo.getContent());
    	   if(vo.getId()>0)
    		   documentService.updateDocument(vo);
    	   else
    		   documentService.insertDocument(vo);
    	   return "forward:/document/mainMgr.do?param=list";
       }
       
       System.out.println("\n\n\n /document/mainMgr.do?param=" + param);
       return "forward:/mainMgr.jsp?param=" + param;
    }
    
    @RequestMapping("/document/addDocumentView.do")
    public String addDocumentView(
            @ModelAttribute("searchVO") DocumentDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("documentVO", new DocumentVO());
        return "/document/DocumentRegister";
    }
    
    @RequestMapping("/document/addDocument.do")
    public String addDocument(
            DocumentVO documentVO,
            @ModelAttribute("searchVO") DocumentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        documentService.insertDocument(documentVO);
        status.setComplete();
        return "forward:/document/DocumentList.do";
    }
    
    @RequestMapping("/document/updateDocumentView.do")
    public String updateDocumentView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") DocumentDefaultVO searchVO, Model model)
            throws Exception {
        DocumentVO documentVO = new DocumentVO();
        documentVO.setId(id);        
        // 변수명은 CoC 에 따라 documentVO
        //model.addAttribute(selectDocument(documentVO, searchVO));
        return "/document/DocumentRegister";
    }

    @RequestMapping("/document/selectDocument.do")
    public String selectDocument(
            DocumentVO documentVO,
            HttpServletRequest request) throws Exception {
    	DocumentVO vo = documentService.selectDocument(documentVO);
    	request.getSession().setAttribute("selectedVO", vo);
        return "forward:/mainMgr.jsp?param=regist";
    }

    @RequestMapping("/document/updateDocument.do")
    public String updateDocument(
            DocumentVO documentVO,
            @ModelAttribute("searchVO") DocumentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        documentService.updateDocument(documentVO);
        status.setComplete();
        return "forward:/document/DocumentList.do";
    }
    
    @RequestMapping("/document/deleteDocument.do")
    public String deleteDocument(
            DocumentVO documentVO,
            @ModelAttribute("searchVO") DocumentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        documentService.deleteDocument(documentVO);
        status.setComplete();
        return "forward:/document/DocumentList.do";
    }

}
