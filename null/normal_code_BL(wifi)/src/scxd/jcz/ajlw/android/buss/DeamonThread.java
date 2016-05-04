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
 * �ػ��߳̽���ͼƬ�ϴ�
 * 
 * @author xxy
 * 
 */
public class DeamonThread extends Thread {

	// �߳�����
	static Thread thread;

	/**
	 * ����ͼƬ�ϴ��߳�
	 */
	public void run() {
		System.out.println("�����߳�...");
		// ��װ���ݲ���
		Map<String, String> parList = new HashMap<String, String>();
		// �ػ��߳��ϴ�ͼƬ���� �ӿ�Ϊ01J01
		// �ж��Ƿ�Ϊ�Զ������ó�
		// ����Զ������ó�����ʶ�����Ϊ�գ���post��ʱ���복�����ƺ������������
		// ƴ���ַ���
		// ��װ���ݲ���
		// ƴ��sql���

		while (true) {
			try {
				
				
				if (Md_Car_Temp.getTempCar().ispbzc && Md_Car_Temp.getTempCar().listImageData.size()==0) {
					System.out.println("�ر��߳�");
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
				System.out.println("�߳�ִ�����,���ص���Ϣ:" + temp);

				Md_Car_Temp.getTempCar().isFlag = false;
				
				
			} catch (Exception e) {
				System.out.println("�߳�ִ���쳣" + e.getMessage());
			}
		}

	}

	/**
	 * ��post��ʽ�ύ���ݲ����շ������� --δ����
	 */
	public static String postRequest(Map<String, String> map) throws Exception {
		String result = "";
		StringBuilder builder = new StringBuilder(); // ƴ���ַ�
		// �ó���ֵ
		if (map != null && !map.isEmpty()) {
			for (Map.Entry<String, String> param : map.entrySet()) {
				builder.append(param.getKey()).append('=')
						.append(URLEncoder.encode(param.getValue(), "utf-8"))
						.append('&');
			}
			builder.deleteCharAt(builder.length() - 1);
		}
		// �����Content-Length: �����URL�Ķ��������ݳ���
		byte b[] = builder.toString().getBytes();
		URL url = new URL(Md_system.getJk_url());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setReadTimeout(5 * 1000);
		con.setDoOutput(true);// ���������
		con.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");// ��������
		con.setRequestProperty("Content-Length", String.valueOf(b.length));// ����
		OutputStream outStream = con.getOutputStream();
		outStream.write(b);// д������
		outStream.flush();// ˢ���ڴ�
		outStream.close();
		// ״̬���ǲ��ɹ�
		if (con.getResponseCode() == 200) {
			InputStream inputStream = con.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);// ���ַ����õġ�

			String inputLine = null;
			// ʹ��ѭ������ȡ��õ����ݣ������ݶ��嵽result����
			while (((inputLine = reader.readLine()) != null)) {
				// ������ÿһ�к������һ��"\n"������
				result += inputLine + "\n";
			}
			reader.close();// �ر�������
			// �ر�http����
			con.disconnect();
			// ������ʾȡ�õ�����
			if (result != null) {

				result = URLDecoder.decode(result, "UTF-8");

			}

			Md_Car_Temp.getTempCar().webState = true;
			System.out.println("���صĽ��:" + result + "  ����ʱ��:"
					+ new java.util.Date().toLocaleString());
			if (result.equals("$EE")) {
				result = "";
			}
			return result;
		}
		return result;

	}

}
