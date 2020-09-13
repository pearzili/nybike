create database nybikedb;
​
use nybikedb;
​
create table t_operation(
id bigint primary key auto_increment,
opt_type int comment '操作类型，1-拖拽，2-点击，3-滚轮缩放',
user_ip varchar(50) comment '用户ip地址',
station_id int comment '点击的站点id',
drag_start_lat double comment '拖拽起始地图中心点纬度',
drag_start_lon double comment '拖拽起始地图中心点经度',
drag_end_lat double comment '拖拽终止地图中心点纬度',
drag_end_lon double comment '拖拽终止地图中心点经度',
zoom_start_level tinyint comment '缩放起始级别',
zoom_end_level tinyint comment '缩放终止级别',
created_time datetime comment '数据创建时间'
);
create table t_station_info(
station_id int primary key comment '站点id',
name varchar(50) comment '站点名称',
lat double comment '站点纬度',
lon double comment '站点经度'
);
load data infile '/opt/station_info.csv' 
into table t_station_info 
fields terminated by ',' 
enclosed by '"' 
lines terminated by '\r\n';