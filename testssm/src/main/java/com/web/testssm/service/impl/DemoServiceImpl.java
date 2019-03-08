package com.web.testssm.service.impl;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import com.web.testssm.dao.DemoMapper;
import com.web.testssm.dao.KwKcapMapper;
import com.web.testssm.dao.KwXkXxMapper;
import com.web.testssm.entity.Demo;
import com.web.testssm.entity.KwKcap;
import com.web.testssm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoMapper demoMapper;
	@Autowired
	private KwKcapMapper kwKcapMapper;

	@Override
	public Demo findList() {
        return demoMapper.selectByPrimaryKey("1");
	}

	@Override
	public void test() {
		List<KwKcap> list = kwKcapMapper.test();
		list.forEach(kwKcap -> {
			String ksly = "";
			for(String k : kwKcap.getKcxh().split(",")){
				List<Map<String, Object>> l = kwKcapMapper.test1(k, kwKcap.getZydm());
				if(l.size()>0 && ksly.indexOf(l.get(0).get("aaa").toString()) < 0){
					ksly += "+" + l.get(0).get("aaa");
				}

			}
			if(ksly.length()>0){
				ksly = ksly.substring(1,ksly.length());
				kwKcap.setKsly(ksly);
			}
			kwKcapMapper.updateByPrimaryKey(kwKcap);
		});
	}

	@Override
	public void test2() {
		String kcmc = "课程名称,利息理论,数据库,统计学原理,图论与组合数学,中学数学解题研究,偏微分方程,应用随机过程,常微分方程,应用数理统计与SPSS,应用统计方法与SPSS,实变函数,高等代数与解析几何1*,高等代数选讲,抽样调查理论与方法,高等代数与解析几何3*,数学分析1*,数学分析选讲,数学分析3*,中学数学教学设计,统计模拟与计算,信息科学概论";
		List<Map<String, Object>> list = demoMapper.getfilePath(kcmc.split(","));

			list.forEach(a -> {
				try {
					String chulikcmc = a.get("kcmc").toString().replace("*","");
					//B卷地址
					String bjdzPath = a.get("bjdzfilepath").toString();
					String bjdzpdfName = bjdzPath.substring(bjdzPath.lastIndexOf("/"));
					File bjdz = new File("D://test/" + chulikcmc + "/" + "bj" + "/" + bjdzpdfName);
					bjdz.getParentFile().mkdirs();
					bjdz.createNewFile();
					URL bjdzUrl = new URL("http://39.107.224.42:8191/" + bjdzPath);
					//打开链接
					HttpURLConnection conn = (HttpURLConnection)bjdzUrl.openConnection();
					//设置请求方式为"GET"
					conn.setRequestMethod("GET");
					//超时响应时间为5秒
					conn.setConnectTimeout(5 * 1000);
					//通过输入流获取图片数据
					InputStream inStream = conn.getInputStream();
					//得到图片的二进制数据，以二进制封装得到数据，具有通用性
					byte[] data = readInputStream(inStream);
					OutputStream out = new FileOutputStream(bjdz);
					out.write(data);

					//B卷答案
					String bjdadzPath =  a.get("dadzfilepath").toString();
					String bjdadzpdfName = bjdadzPath.substring(bjdadzPath.lastIndexOf("/"));
					File bjdadz = new File("D://test/" + chulikcmc + "/" + "da" + "/" + bjdadzpdfName);


				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception ex){
					ex.printStackTrace();
				}
			});

	}
	public byte[] readInputStream(InputStream inStream) throws Exception{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		//创建一个Buffer字符串
		byte[] buffer = new byte[1024];
		//每次读取的字符串长度，如果为-1，代表全部读取完毕
		int len = 0;
		//使用一个输入流从buffer里把数据读取出来
		while( (len=inStream.read(buffer)) != -1 ){
			//用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
			outStream.write(buffer, 0, len);
		}
		//关闭输入流
		inStream.close();
		//把outStream里的数据写入内存
		return outStream.toByteArray();
	}

}
