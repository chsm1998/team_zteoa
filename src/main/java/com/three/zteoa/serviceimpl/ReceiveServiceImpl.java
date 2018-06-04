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
import com.three.zteoa.vo.UpdateVo;

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
	public UpdateVo modifyReceive(Receive receive) {
		// 查询出数据库中的申请信息
		Receive oldReceive = receiveMapper.queryById(receive);
		Integer agree = null;
		String category = null;
		// 若新的申请信息为null则使用数据库中的数据
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
		// 判断审核状态
		if (agree == 2) {
			// 判断申请类别
			Product product = productMapper.queryById(oldReceive.getPid());
			int currNum = product.getNum() - oldReceive.getNum();
			if (currNum >= 0) {
				if ("2".equals(category)) {
					BoardroomFacilities boFacilities = boardroomFacMapper.queryByPid(oldReceive.getPid());
					if (boFacilities != null) {
						boFacilities.setNum(boFacilities.getNum() + oldReceive.getNum());
						boardroomFacMapper.updateBoardroomFac(boFacilities);
					} else {
						BoardroomFacilities boardroomFacilties = new BoardroomFacilities();
						boardroomFacilties.setBid(oldReceive.getBid());
						boardroomFacilties.setPid(oldReceive.getPid());
						boardroomFacilties.setNum(oldReceive.getNum());
						Date time = new Date();
						boardroomFacilties.setModifyTime(time);
						boardroomFacilties.setCreateTime(time);
						boardroomFacMapper.addBoardroomFac(boardroomFacilties);
					}
				}
				product.setNum(currNum);
				productMapper.modifyProduct(product);
			} else {
				receive.setAgree(3);
				receiveMapper.modifyReceive(receive);
				return new UpdateVo("库存不足，状态已自动更改为不通过", false);
			}
		}
		return receiveMapper.modifyReceive(receive) ? new UpdateVo("更新成功", true) : new UpdateVo("更新失败", false);
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
