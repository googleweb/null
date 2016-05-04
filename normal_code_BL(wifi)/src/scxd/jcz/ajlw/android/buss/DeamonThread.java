package scxd.jcz.ajlw.android.buss;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import scxd.jcz.ajlw.android.common.MD_Car_photo;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.Md_system;

/**
 * 守护线程进行图片上传
 * 
 * @author xxy
 * 
 */
public class DeamonThread extends Thread {

	// 线程命名
	static Thread thread;

	/**
	 * 启动图片上传线程
	 */
	public void run() {
		System.out.println("进入线程...");
		// 封装传递参数
		Map<String, String> parList = new HashMap<String, String>();
		// 守护线程上传图片数据 接口为01J01
		// 判断是否为自定义在用车
		// 如果自定义在用车车辆识别代码为空，则post的时候传入车辆号牌号码与号牌种类
		// 拼接字符串
		// 封装传递参数
		// 拼接sql语句

		while (true) {
			try {
				
				
				if (Md_Car_Temp.getTempCar().ispbzc && Md_Car_Temp.getTempCar().listImageData.size()==0) {
					System.out.println("关闭线程");
					thread.stop();
				}
				if (!Md_Car_Temp.getTempCar().isFlag) {
					thread.sleep(2000);
				}
				MD_Car_photo mcPhoto = Md_Car_Temp.getTempCar().listImageData.get(0);
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.append("<?xml version=\"1.0\" encoding=\"GBK\"?> <root> <Photo> ");
				sBuilder.append("<jclsh>" + mcPhoto.getJclsh() + "</jclsh>");
				sBuilder.append("<hphm>"
						+ URLEncoder.encode(mcPhoto.getHphm(), "UTF-8")
						+ "</hphm>");
				sBuilder.append("<hpzl>" + mcPhoto.getHpzl() + "</hpzl>");
				sBuilder.append("<pssj>" + mcPhoto.getPssj() + "</pssj>");
				sBuilder.append("<zpzl>" + mcPhoto.getZpzl() + "</zpzl>");
				sBuilder.append("<zp>" + mcPhoto.getZp() + "</zp>");
				sBuilder.append("<cllx>" + mcPhoto.getCllx() + "</cllx>");

				sBuilder.append("<sfzdy>" + mcPhoto.getSfzdy() + "</sfzdy>");
				sBuilder.append("<userid>" + mcPhoto.getUserid() + "</userid>");

				parList.put("xtlb", Md_system.getXtlb());
				parList.put("jkxlh", Md_system.getPtkey());
				parList.put("jkid", "01J10");

				if (mcPhoto.getSfzdy().equals("1")
						&& mcPhoto.getClsbdh().equals("")
						&& mcPhoto.getSfxc().equals("1")) {
					parList.put("hphm", mcPhoto.getHphm());
					parList.put("hpzl", mcPhoto.getHpzl());

					parList.put("type", "3");
				} else {
					sBuilder.append("<clsbdh>" + mcPhoto.getClsbdh()
							+ "</clsbdh>");
					parList.put("type", "1");
					sBuilder.append("</Photo> </root> ");
				}

				parList.put("xmldoc",
						URLEncoder.encode(sBuilder.toString(), "UTF-8"));

				String temp = postRequest(parList);
				Md_Car_Temp.getTempCar().listImageData.remove(0);
				System.out.println("线程执行完毕,返回的信息:" + temp);

				Md_Car_Temp.getTempCar().isFlag = false;
				
				
			} catch (Exception e) {
				System.out.println("线程执行异常" + e.getMessage());
			}
		}

	}

	/**
	 * 用post方式提交数据并接收返回数据 --未启用
	 */
	public static String postRequest(Map<String, String> map) throws Exception {
		String result = "";
		StringBuilder builder = new StringBuilder(); // 拼接字符
		// 拿出键值
		if (map != null && !map.isEmpty()) {
			for (Map.Entry<String, String> param : map.entrySet()) {
				builder.append(param.getKey()).append('=')
						.append(URLEncoder.encode(param.getValue(), "utf-8"))
						.append('&');
			}
			builder.deleteCharAt(builder.length() - 1);
		}
		// 下面的Content-Length: 是这个URL的二进制数据长度
		byte b[] = builder.toString().getBytes();
		URL url = new URL(Md_system.getJk_url());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setReadTimeout(5 * 1000);
		con.setDoOutput(true);// 打开向外输出
		con.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");// 内容类型
		con.setRequestProperty("Content-Length", String.valueOf(b.length));// 长度
		OutputStream outStream = con.getOutputStream();
		outStream.write(b);// 写入数据
		outStream.flush();// 刷新内存
		outStream.close();
		// 状态码是不成功
		if (con.getResponseCode() == 200) {
			InputStream inputStream = con.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);// 读字符串用的。

			String inputLine = null;
			// 使用循环来读取获得的数据，把数据都村到result中了
			while (((inputLine = reader.readLine()) != null)) {
				// 我们在每一行后面加上一个"\n"来换行
				result += inputLine + "\n";
			}
			reader.close();// 关闭输入流
			// 关闭http连接
			con.disconnect();
			// 设置显示取得的内容
			if (result != null) {

				result = URLDecoder.decode(result, "UTF-8");

			}

			Md_Car_Temp.getTempCar().webState = true;
			System.out.println("返回的结果:" + result + "  结束时间:"
					+ new java.util.Date().toLocaleString());
			if (result.equals("$EE")) {
				result = "";
			}
			return result;
		}
		return result;

	}

}
