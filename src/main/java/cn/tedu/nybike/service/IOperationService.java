package cn.tedu.nybike.service;

import cn.tedu.nybike.pojo.OperationDo;
import cn.tedu.nybike.pojo.OperationVO;
import cn.tedu.nybike.pojo.ShowDo;
import cn.tedu.nybike.pojo.genderAgeVo;
import cn.tedu.nybike.service.ex.EmptyArgumentException;
import cn.tedu.nybike.service.ex.InsertException;

/**
 * 用户操作的业务层接口
 * 业务层方法不同与持久方法相同
 * @author Administrator
 *
 */
public interface IOperationService {
	/**
	 * 基于日期查询数据大屏所需数据
	 * @param date 日期
	 * @param stationCountLimit 站点排名数量
	 * @param ipLimit ip排名数量
	 * @return
	 */
	OperationVO findOperationData(String date,int stationCountLimit,int ipLimit);
	
	/**
	 * 添加一条用户操作记录
	 * @param opt 用户操作记录
	 */
	void saveOperation(OperationDo opt)
		throws EmptyArgumentException, InsertException;
	/**
	 * 地图用例的数据
	 */
	ShowDo findData();
	genderAgeVo getGenderData();

}
