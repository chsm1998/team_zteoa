package com.three.zteoa.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.three.zteoa.bean.Receive;
import com.three.zteoa.mapper.ReceiveMapper;
import com.three.zteoa.service.ReceiveService;
/**
 * @author	Vintonsen_lcx
 * @date	2018年5月30日 
 * @time	下午3:57:50
 * @description :
 * 
 */
@Service
public class ReceiveServiceImpl implements ReceiveService{

	@Resource
	private ReceiveMapper receiveMapper;
	@Override
	public boolean addReceive(Receive receive) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = receiveMapper.addReceive(receive);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteReceivesById(Integer receive_id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = receiveMapper.deleteReceivesById(receive_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean modifyReceive(Receive receive) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = receiveMapper.modifyReceive(receive);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Receive> getReceiveById(Integer eid, Integer pid, String category, Integer currentPageNo,
			Integer pageSize) throws Exception {
		List<Receive> receiveList = null;
		try {
			receiveList = receiveMapper.getReceiveById(eid, pid, category, currentPageNo, pageSize);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return receiveList;
	}

	@Override
	public int getReceiveCount(Integer id, String category) throws Exception {
		// TODO Auto-generated method stub
		Integer receiveCount = 0;
		try {
			receiveCount = receiveMapper.getReceiveCount(id, category);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return receiveCount;
	}

	@Override
	public List<Receive> getReceiveList(Receive receive) throws Exception {
		// TODO Auto-generated method stub
		List<Receive> receiveList = null;
		try {
			receiveList = receiveMapper.getReceiveList(receive);
			} catch (Exception e) {
			// TODO: handle exception
		}
		return receiveList;
	}



}
