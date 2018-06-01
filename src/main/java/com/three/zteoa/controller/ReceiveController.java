package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Emp;
import com.three.zteoa.bean.Receive;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.service.ReceiveService;
import com.three.zteoa.vo.UpdateVo;

/**
 * @author	Vintonsen_lcx
 * @date	2018年5月31日 
 * @time	上午8:52:44
 * @description :
 * 
 */
@RestController
@RequestMapping("/receive")
public class ReceiveController {

	@Resource
	private ReceiveService receiveSeivice;
	
	@RequestMapping("/add")
	// 添加办公用品申请 
	public boolean addReceive(@RequestBody Receive receive, HttpSession session) throws Exception{
		Emp emp = (Emp) session.getAttribute("empSession");
		receive.setEid(emp.getId());
		return receiveSeivice.addReceive(receive);
	}
		
	@RequestMapping("/delete")
	// 通过申请id，删除申请
	public boolean deleteReceivesById(Integer receive_id) throws Exception{
		return receiveSeivice.deleteReceivesById(receive_id);
	}
	
	@RequestMapping("/update")
	// 修改办公用品申请信息
	public boolean modifyReceive(@RequestBody Receive receive) throws Exception{
		return receiveSeivice.modifyReceive(receive);
	}
	
	@RequestMapping("queryList")
	// 通过条件查询-ReceiveList
	public List<Receive> getReceiveById(@RequestBody Receive receive) throws Exception{
		return receiveSeivice.getReceiveList(receive);
	}
	
	@RequestMapping("/queryTotal")
	// 通过条件查询-记录数查询
	public int getReceiveCount(@RequestBody(required = false) Receive receive) throws Exception{
		if (receive == null) {
			receive = new Receive();
		}
		return receiveSeivice.getReceiveCount(receive);
	}
	
	/**
	 * 鉴权
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/isAuthority")
	public UpdateVo isAuthority(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		return SecurityComponent.isAuthorityProduct(emp);
	}
	
	

}
