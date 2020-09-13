package cn.tedu.nybike.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.nybike.pojo.OperationDo;
import cn.tedu.nybike.pojo.OperationVO;
import cn.tedu.nybike.pojo.OptTypeCountDO;
import cn.tedu.nybike.pojo.StationClickCountDO;
import cn.tedu.nybike.pojo.UserIPCountDO;
import cn.tedu.nybike.pojo.genderAgeDo;
import cn.tedu.nybike.pojo.stationCountDo;

@RunWith(SpringRunner.class)//两个测试必须要有的注解
@SpringBootTest
public class OperationMapperTest {
	@Autowired
	OperationMapper mapper;//不需要创建实例，spring框架根据注解会自动生成mapper的实例

	
	@Test
	public void listOptTypeCount() {
		List<OptTypeCountDO> list=mapper.listOptTypeCount("2020-07-20");
		list.forEach(item->System.err.println(item));
	}
	
	@Test
	public void listStationClickCount() {
		List<StationClickCountDO> list=mapper.listStationClickCount("2020-07-20", 5);
		list.forEach(item->System.err.println(item));
	}
	
	@Test
	public void listUserIPCount() {
		List<UserIPCountDO> list=mapper.listUserIPCount("2020-07-21", 5);
		list.forEach(item->System.err.println(item));
	}
	
	@Test
	public void insertOperation() {
		OperationDo opt=new OperationDo(null, 0, "0.0.0.1", 
				789, 127.77, 43.56, 
				127.88, 46.33, 15, 
				16, null);
		Integer row=mapper.insertOperation(opt);
		System.err.println("row="+row);
	}
	@Test
	public void listStationCount() {
		List<stationCountDo> list=mapper.listStationCount();
		list.forEach(item->System.err.println(item));
	}
	@Test
	public void listEndStationCount() {
		List<stationCountDo> list=mapper.listEndStationCount();
		list.forEach(item->System.err.println(item));
	}
	@Test
	public void listGenderAgeCount() {
		List<genderAgeDo> list=mapper.listGenderAgeCount();
		list.forEach(item->System.err.println(item));
	}

}
