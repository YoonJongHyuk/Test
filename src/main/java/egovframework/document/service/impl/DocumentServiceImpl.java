package egovframework.document.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.document.service.DocumentService;
import egovframework.document.service.DocumentDefaultVO;
import egovframework.document.service.DocumentVO;
import egovframework.document.service.impl.DocumentMapper;
/**
 * @Class Name : DocumentServiceImpl.java
 * @Description : Document Business Implement class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-04-28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("documentService")
public class DocumentServiceImpl extends EgovAbstractServiceImpl implements
        DocumentService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentServiceImpl.class);

    @Resource(name="documentMapper")
    private DocumentMapper documentDAO;
    
    //@Resource(name="documentDAO")
    //private DocumentDAO documentDAO;
    
    /** ID Generation */
    //@Resource(name="{egovDocumentIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * document을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DocumentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertDocument(DocumentVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	documentDAO.insertDocument(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * document을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DocumentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDocument(DocumentVO vo) throws Exception {
        documentDAO.updateDocument(vo);
    }

    /**
	 * document을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DocumentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDocument(DocumentVO vo) throws Exception {
        documentDAO.deleteDocument(vo);
    }

    /**
	 * document을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DocumentVO
	 * @return 조회한 document
	 * @exception Exception
	 */
    public DocumentVO selectDocument(DocumentVO vo) throws Exception {
        DocumentVO resultVO = documentDAO.selectDocument(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * document 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return document 목록
	 * @exception Exception
	 */
    public List<?> selectDocumentList(DocumentDefaultVO searchVO) throws Exception {
        return documentDAO.selectDocumentList(searchVO);
    }

    /**
	 * document 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return document 총 갯수
	 * @exception
	 */
    public int selectDocumentListTotCnt(DocumentDefaultVO searchVO) {
		return documentDAO.selectDocumentListTotCnt(searchVO);
	}
    
}
