package com.three.zteoa.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.zteoa.bean.BoardroomFacilities;
import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.Receive;
import com.three.zteoa.mapper.BoardroomApplyMapper;
import com.three.zteoa.mapper.BoardroomFacMapper;
import com.three.zteoa.mapper.ProductMapper;
import com.three.zteoa.mapper.ReceiveMapper;
import com.three.zteoa.service.ReceiveService;

/**
 * @author Vintonsen_lcx
 * @date 2018年5月30日
 * @time 下午3:57:50
 * @description :
 * 
 */
@Service
public class ReceiveServiceImpl implements ReceiveService {

	@Resource
	private ReceiveMapper receiveMapper;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private BoardroomFacMapper boardroomFacMapper;

	@Override
	public boolean addReceive(Receive receive) throws Exception {
		// TODO Auto-generated method stub
		receive.setAgree(1);
		Date time = new Date();
		receive.setCreateTime(time);
		receive.setModifyTime(time);
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
	public boolean modifyReceive(Receive receive) {
		Receive oldReceive = receiveMapper.queryById(receive);
		Integer agree = null;
		String category = null;
		if (receive.getAgree() == null) {
			agree = oldReceive.getAgree();
		} else {
			agree = receive.getAgree();
		}
		if (receive.getCategory() == null) {
			category = oldReceive.getCategory();
		} else {
			category = receive.getCategory();
		}
		System.out.println(oldReceive);
		System.out.println(receive);
		// 判断审核状态
		if (agree == 2) {
			// 判断申请类别
			if ("2".equals(category)) {
				BoardroomFacilities boardroomFacilties = new BoardroomFacilities();
				boardroomFacilties.setBid(oldReceive.getBid());
				boardroomFacilties.setPid(oldReceive.getPid());
				boardroomFacilties.setNum(oldReceive.getNum());
				Date time = new Date();
				boardroomFacilties.setModifyTime(time);
				boardroomFacilties.setCreateTime(time);
				boardroomFacMapper.addBoardroomFac(boardroomFacilties);
			}
			Product product = productMapper.queryById(oldReceive.getPid());
			product.setNum(product.getNum() - oldReceive.getNum());
			productMapper.modifyProduct(product);
		}
		return receiveMapper.modifyReceive(receive);
	}

	@Override
	public int getReceiveCount(Receive receive) throws Exception {
		// TODO Auto-generated method stub
		Integer receiveCount = 0;
		try {
			receiveCount = receiveMapper.getReceiveCount(receive);
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
			receive.setCurrPage((receive.getCurrPage() - 1) * receive.getPageSize());
			receiveList = receiveMapper.getReceiveList(receive);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return receiveList;
	}

	@Override
	public Receive queryById(Receive receive) {
		return receiveMapper.queryById(receive);
	}

}
