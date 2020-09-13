package cn.tedu.nybike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.nybike.pojo.OperationDo;
import cn.tedu.nybike.pojo.OptTypeCountDO;
import cn.tedu.nybike.pojo.StationClickCountDO;
import cn.tedu.nybike.pojo.UserIPCountDO;
import cn.tedu.nybike.pojo.genderAgeDo;
import cn.tedu.nybike.pojo.stationCountDo;

/**
 * 用户操作记录的持久层接口
 * @author Administrator
 *
 */
public interface OperationMapper {
	/**
	 * 添加一条用户操作记录
	 * @param opt用户操作记录
	 * @param 添加成功的数据条数
	 */
	Integer insertOperation(OperationDo opt);
	/**
	 * 基于日期查询所有类型的用户操作的次数
	 * @param date 日期 格式 yyyy-MM-dd
	 * @return
	 */
	List<OptTypeCountDO> listOptTypeCount(String date);
	
	/**
	 * 基于日期查询访问最多的n个站点的信息
	 * @param date 日期 格式 yyyy-MM-dd
	 * @param limit 查询的数据条数
	 * @return
	 */
	List<StationClickCountDO> listStationClickCount(@Param("date")String date, @Param("limit")Integer limit);
	
	/**
	 * 基于日期查询访问最多的n个用户的IP
	 * 如果方法的参数超过1个，或者方法的参数被用于动态SQL
	 * 必须显式在参数前添加@Param("参数名")
	 * @param date 日期 格式 yyyy-MM-dd
	 * @param limit 查询的数据条数
	 * @return
	 */
	List<UserIPCountDO> listUserIPCount(@Param("date")String date, @Param("limit")Integer limit);
	/**
	 * 基于日期查询站点的骑行人数
	 */
	List<stationCountDo> listStationCount();
	List<stationCountDo> listEndStationCount();
	/**
	 * 分析年龄，性别，骑行次数的关系
	 */
	List<genderAgeDo> listGenderAgeCount();
	
}
