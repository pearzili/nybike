package cn.tedu.nybike.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.nybike.pojo.OperationDo;
import cn.tedu.nybike.pojo.OperationVO;
import cn.tedu.nybike.pojo.ShowDo;
import cn.tedu.nybike.pojo.genderAgeVo;

@RunWith(SpringRunner.class)//两个测试必须要有的注解
@SpringBootTest
public class OperationServiceTest {
	@Autowired
	IOperationService service;
	@Test
	public void saveOperation() {
		//业务层需要测试正常与不正常的情况
		OperationDo opt=new OperationDo(null,1,"0.0.0.1",
				789,127.77,43.56,null,46.33,
				15,16,null);
		service.saveOperation(opt);
		
	}
	@Test
	public void findOperationData() {
		OperationVO vo=service.findOperationData("2020-07-20", 5, 5);
		System.err.println(vo);
	}
	@Test
	public void findData() {
		ShowDo sd=service.findData();
		System.err.println(sd);
	}
	@Test
	public void getGenderData() {
		genderAgeVo sd=service.getGenderData();
		System.err.println(sd);
	}

}
