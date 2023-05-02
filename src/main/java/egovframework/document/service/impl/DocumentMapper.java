package egovframework.document.service.impl;

import java.util.List;

import egovframework.document.service.DocumentVO;
import egovframework.document.service.DocumentDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : DocumentMapper.java
 * @Description : Document Mapper Class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-04-28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("documentMapper")
public interface DocumentMapper {

	/**
	 * document을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DocumentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertDocument(DocumentVO vo) throws Exception;

    /**
	 * document을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DocumentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDocument(DocumentVO vo) throws Exception;

    /**
	 * document을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DocumentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDocument(DocumentVO vo) throws Exception;

    /**
	 * document을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DocumentVO
	 * @return 조회한 document
	 * @exception Exception
	 */
    public DocumentVO selectDocument(DocumentVO vo) throws Exception;

    /**
	 * document 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return document 목록
	 * @exception Exception
	 */
    public List<?> selectDocumentList(DocumentDefaultVO searchVO) throws Exception;

    /**
	 * document 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return document 총 갯수
	 * @exception
	 */
    public int selectDocumentListTotCnt(DocumentDefaultVO searchVO);

}
