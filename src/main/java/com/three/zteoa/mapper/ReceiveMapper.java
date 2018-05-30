package com.three.zteoa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Receive;

/**
 * @author	Vintonsen_lcx
 * @date	2018年5月29日 
 * @time	上午9:48:58
 * @description :receive的mapper接。
 * 
 */
public interface ReceiveMapper {

	/**1
	 * 添加办公用品申请
	 * @param receive
	 * @return
	 * @throws Exception
	 */
	public int add(Receive receive) throws Exception;
	
	/**2
	 * 通过申请id，删除申请
	 * @param receive_id
	 * @return
	 * @throws Exception
	 */
	public int deleteReceivesById(@Param("receive")Integer receive_id) throws Exception;
	
	/**3
	 * 修改申请信息
	 * @param receive
	 * @return
	 * @throws Exception
	 */
	public int modify(Receive receive) throws Exception;
	
	/**4.1
	 * 通过条件查询-ReceiveList
	 * @param eid
	 * @param pid
	 * @param category
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Receive> getReceiveList(@Param("eid")Integer eid,@Param("pid")Integer pid
			,@Param("category")String category,@Param("currenPageNo")Integer currentPageNo,
			@Param("pageSize")Integer pageSize ) throws Exception;
	
	/**4.2
	 * 通过条件查询-记录数查询
	 * @param id
	 * @param category
	 * @return
	 * @throws Exception
	 */
	public int getReceiveCount(@Param("id")Integer id,@Param("category")String category) throws Exception;
}
