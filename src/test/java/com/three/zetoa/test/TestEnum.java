package com.three.zetoa.test;

import com.three.zteoa.bean.Emp;
import com.three.zteoa.bean.Position;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.myenum.PositionEnum;
import com.three.zteoa.vo.UpdateVo;

public class TestEnum {

	public static void main(String[] args) {
		Emp emp = new Emp();
		Emp updateEmp = new Emp();
		Position position1 = new Position();
		position1.setName(PositionEnum.MANAGER.getName());
		Position position2 = new Position();
		position2.setName(PositionEnum.MANAGER.getName());
		emp.setPosition(position1);
		updateEmp.setPosition(position2);
		UpdateVo updateVo = SecurityComponent.isAuthority(emp, updateEmp);
		updateVo = SecurityComponent.isUpdateAuthority(emp, PositionEnum.MANAGER.getName());
		System.out.println(updateVo);
	}

}
