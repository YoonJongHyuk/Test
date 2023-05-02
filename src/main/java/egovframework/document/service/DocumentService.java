package egovframework.document.service;

import java.util.List;
import egovframework.document.service.DocumentDefaultVO;
import egovframework.document.service.DocumentVO;

/**
 * @Class Name : DocumentService.java
 * @Description : Document Business class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-04-28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface DocumentService {
	
	/**
	 * document을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DocumentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertDocument(DocumentVO vo) throws Exception;
    
    /**
	 * document을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DocumentVO
	 * @return void형
	 * @exception Exception
	 */
    void updateDocument(DocumentVO vo) throws Exception;
    
    /**
	 * document을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DocumentVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteDocument(DocumentVO vo) throws Exception;
    
    /**
	 * document을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DocumentVO
	 * @return 조회한 document
	 * @exception Exception
	 */
    DocumentVO selectDocument(DocumentVO vo) throws Exception;
    
    /**
	 * document 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return document 목록
	 * @exception Exception
	 */
    List selectDocumentList(DocumentDefaultVO searchVO) throws Exception;
    
    /**
	 * document 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return document 총 갯수
	 * @exception
	 */
    int selectDocumentListTotCnt(DocumentDefaultVO searchVO);
    
}
