package cn.tedu.nybike.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.tedu.nybike.mapper.OperationMapper;
import cn.tedu.nybike.pojo.OperationDo;
import cn.tedu.nybike.pojo.OperationVO;
import cn.tedu.nybike.pojo.OptTypeCountDO;
import cn.tedu.nybike.pojo.ShowDo;
import cn.tedu.nybike.pojo.StationClickCountDO;
import cn.tedu.nybike.pojo.UserIPCountDO;
import cn.tedu.nybike.pojo.genderAgeDo;
import cn.tedu.nybike.pojo.genderAgeVo;
import cn.tedu.nybike.pojo.stationCountDo;
import cn.tedu.nybike.service.IOperationService;
import cn.tedu.nybike.service.ex.EmptyArgumentException;
import cn.tedu.nybike.service.ex.InsertException;


@Service
public class OperationServiceImpl implements IOperationService {
	
	@Autowired
	OperationMapper mapper;
	public int getIndex(List<Integer> mapId,Integer sid) {
		//查找stationId在mapId中的下标位置，修改mapStationCount的该位置的值
		for(int i=0;i<mapId.size();i++) {
			if(mapId.get(i)==sid)
			{
				return i;
			}
		}
		return -1;
	}
	public genderAgeVo getGenderData() {
		List<Integer> agedData=new ArrayList<Integer>();
		List<Integer> countData=new ArrayList<Integer>();
		List<String> genderData=new ArrayList<String>();
		List<genderAgeDo> gad=mapper.listGenderAgeCount();
		for(genderAgeDo g:gad) {
			agedData.add(g.getAge());
			countData.add(g.getCount());
			genderData.add(g.getGender());
		}
		genderAgeVo vo=new genderAgeVo(agedData,countData,genderData);
		return vo;
	}
	public ShowDo findData() {
		List<stationCountDo> sclist=mapper.listStationCount();
		List<stationCountDo> scEndlist=mapper.listEndStationCount();
		List<Integer> mapId=new ArrayList<Integer>();//地图的名字
		List<String> mapName=new ArrayList<String>();//地图的名字
		List<Integer> mapStationCount=new ArrayList<Integer>();//地图站点上数量总和
		List<Double> mapLon=new ArrayList<Double>();//地图站点的经度
		List<Double> mapLat=new ArrayList<Double>();//地图站点的纬度;
		//把数据存放到集合中
		int count=0,flag=0;
		int flog=0;//标记开始站点
		for(int i=0;i<sclist.size();i++) {
			stationCountDo sc=sclist.get(i);
			for(int j=0;j<scEndlist.size();j++) {
				stationCountDo scd=scEndlist.get(j);
				if(sc.getStationId()!=scd.getStationId()&&!mapId.contains(sclist.get(i).getStationId())&&!mapId.contains(scEndlist.get(j).getStationId())) {
					//把两个站点加进去
					mapId.add(sc.getStationId());//把结束站点放进去，并且标志该站点已经被放过
					mapName.add(sc.getName());
					mapStationCount.add(sc.getCount());
					mapLon.add(sc.getLon());
					mapLat.add(sc.getLat());
					mapId.add(scd.getStationId());//把结束站点放进去，并且标志该站点已经被放过
					mapName.add(scd.getName());
					mapStationCount.add(scd.getCount());
					mapLon.add(scd.getLon());
					mapLat.add(scd.getLat());
				}
				if(sc.getStationId()==scd.getStationId()&&mapId.contains(sc.getStationId())){
					//站点相同，作为开始站点在里面了，则把结束站点的值修改在mapStionCount中
					int index=getIndex(mapId,scd.getStationId());
					int tempCount=mapStationCount.get(index);
					//修改mapStaionCount的值
					Integer element= tempCount+scd.getCount();
					mapStationCount.set(index, element);
				}
				if(sc.getStationId()==scd.getStationId()&&mapId.contains(sc.getStationId())){
					//站点相同，作为结束站点在里面了，则把结束站点的值修改在mapStionCount中
					int index=getIndex(mapId,scd.getStationId());
					int tempCount=mapStationCount.get(index);
					//修改mapStaionCount的值
					Integer element= tempCount+sc.getCount();
					mapStationCount.set(index, element);
				}
	
			}
			
		}
		
	/*	for(stationCountDo sc:sclist) {//遍历起始站点的
			for(stationCountDo scd:scEndlist) {//遍历结束站点的
				if(sc.getStationId()!=scd.getStationId()&&flag==0)//如果结束站点没有被放进去过
				{
					mapId.add(scd.getStationId());//把结束站点放进去，并且标志该站点已经被放过
					flag=1;
					mapName.add(scd.getName());
					mapStationCount.add(scd.getCount());
					mapLon.add(scd.getLon());
					mapLat.add(scd.getLat());
				}
				
				if(sc.getStationId()==scd.getStationId()&&flag==1)
				{
					//如果结束站点与开始站点相同了，并且结束站点已经被放进去了,则从这个容器中搜索，修改count的值
					int index=getIndex(mapId,scd.getStationId());
					int tempCount=mapStationCount.get(index);
					//修改mapStaionCount的值
					Integer element= tempCount+sc.getCount();
					mapStationCount.set(index, element);
				}
				
				if(sc.getStationId()==scd.getStationId()&&flag==0)//如果结束站点没有被放进去过
				{
					mapId.add(scd.getStationId());//把结束站点放进去，并且标志该站点已经被放过
					flag=1;
					flog=1;
					mapName.add(scd.getName());
					mapStationCount.add(scd.getCount());
					mapLon.add(scd.getLon());
					mapLat.add(scd.getLat());
				}
				
				if(flog==0) {//如果开始站点没有被放进去过
					mapId.add(sc.getStationId());//把结束站点放进去，并且标志该站点已经被放过
					flog=1;
					mapName.add(sc.getName());
					mapStationCount.add(sc.getCount());
					mapLon.add(sc.getLon());
					mapLat.add(sc.getLat());
				}
				
		}
		
		}*/
		
		ShowDo sd=new ShowDo(mapId,mapName,mapStationCount,mapLon,mapLat);
		return sd;
	}
	
	private String[] optTypeArr= {"综合","拖拽","点击","缩放"};

	public OperationVO findOperationData(String date, int stationCountLimit, int ipLimit) {
		// 调用持久层方法查询数据
		List<OptTypeCountDO> otcList=mapper.listOptTypeCount(date);
		List<StationClickCountDO> sccList=mapper.listStationClickCount(date, stationCountLimit);
		List<UserIPCountDO> uicList=mapper.listUserIPCount(date, ipLimit);
		// 声明目标集合
		List<Integer> accessCountXData=new ArrayList<Integer>(otcList.size()+1);
		List<String> accessCountYData=new ArrayList<String>(otcList.size()+1);
		List<Integer> stationCountXData=new ArrayList<Integer>(stationCountLimit);
		List<String> stationCountNameData=new ArrayList<String>(stationCountLimit);
		List<Integer> stationCountYData=new ArrayList<Integer>(stationCountLimit);
		List<String> ipCountXData=new ArrayList<String>(ipLimit);
		List<Integer> ipCountYData=new ArrayList<Integer>(ipLimit);
		// 遍历数据封装到目标集合中
		Integer tempCount=0;
		for(OptTypeCountDO otc:otcList) {
			accessCountXData.add(otc.getCount());
			accessCountYData.add(optTypeArr[otc.getOptType()]);
			tempCount+=otc.getCount();
		}
		// 添加综合操作数据
		accessCountXData.add(tempCount);
		accessCountYData.add(optTypeArr[0]);
		
		for(StationClickCountDO scc:sccList) {
			stationCountXData.add(scc.getStationId());
			stationCountNameData.add(scc.getName());
			stationCountYData.add(scc.getCount());
		}
		
		for(UserIPCountDO uic:uicList) {
			ipCountXData.add(uic.getUserIP());
			ipCountYData.add(uic.getCount());
		}
		// 创建VO对象，将集合封装到VO中
		OperationVO vo=new OperationVO(accessCountXData, accessCountYData, 
				stationCountXData, stationCountNameData, 
				stationCountYData, ipCountXData, ipCountYData);
		// 返回VO对象
		return vo;
	}

	@Override
	public void saveOperation(OperationDo opt) {
		// 非空验证
		if(opt==null || StringUtils.isEmpty(opt.getUserIp()) || opt.getOptType()==null) {
			throw new EmptyArgumentException("添加操作记录异常：操作记录为空");
		}
		if(opt.getOptType().equals(1)) {// 拖拽操作
			if(opt.getDragStartLat()==null || opt.getDragStartLon()==null || opt.getDragEndLat()==null || opt.getDragEndLon()==null) {
				throw new EmptyArgumentException("添加操作记录异常：拖拽记录为空");
			}
		}
		if(opt.getOptType().equals(2)) {
			if(opt.getStationId()==null) {
				throw new EmptyArgumentException("添加操作记录异常：点击记录为空");
			}
		}
		if(opt.getOptType().equals(3)) {
			if(opt.getZoomStartLevel()==null || opt.getZoomEndLevel()==null) {
				throw new EmptyArgumentException("添加操作记录异常：缩放记录为空");
			}
		}
		// 格式验证 TODO
		// 业务逻辑验证 TODO
		// 调用持久层方法，将数据写入数据库
		Integer row=mapper.insertOperation(opt);
		// 对结果进行判断
		if(row!=1) {
			throw new InsertException("添加操作记录异常：添加失败");
		}
	}

}
