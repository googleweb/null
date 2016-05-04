package scxd.jcz.ajlw.android.Activity.Common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.Md_system;

public class webservice_call {
	/**
	 * ��д���󷽷�
	 */
	public static String postRequest(String requestData, String method)
			throws Exception {

		String reponseData = "";

		HttpURLConnection con = null;

		try {
			URL url = new URL(Md_system.getJk_url() + "/" + method);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setReadTimeout(30 * 1000);
			con.setConnectTimeout(30 * 1000);
			con.setDoOutput(true);// ���������
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");// ��������

			{
				byte[] requestDataBytes = requestData.getBytes();

				con.setRequestProperty("Content-Length",
						String.valueOf(requestDataBytes.length));// ����

				OutputStream outStream = null;
				try {
					outStream = con.getOutputStream();
					outStream.write(requestDataBytes);// д������
				} catch (Exception e) {
					throw e;
				} finally {
					if (outStream != null) {
						try {
							outStream.close();
						} catch (Exception ee) {
						}
						outStream = null;
					}

					// ����
					requestDataBytes = null;
				}
			}

			// ��ȡ����״̬��
			int responseCode = con.getResponseCode();

			if (responseCode == 200) {

				InputStream inStream = null;
				InputStreamReader inStreamReader = null;
				BufferedReader bufferReader = null;

				try {
					inStream = con.getInputStream();

					inStreamReader = new InputStreamReader(inStream);

					bufferReader = new BufferedReader(inStreamReader);// ���ַ����õġ�

					StringBuilder response = new StringBuilder();
					String line;
					while ((line = bufferReader.readLine()) != null) {
						response.append(line);
						response.append("\n");
					}
					reponseData = response.toString();

					// reponseData = URLDecoder.decode(reponseData);

				} catch (Exception e) {
					// ���粻��
					Md_Car_Temp.getTempCar().webState = false;
					reponseData = "";
				} finally {
					if (bufferReader != null) {
						try {
							bufferReader.close();
						} catch (Exception ee) {
						}
					}
					if (inStreamReader != null) {
						try {
							inStreamReader.close();
						} catch (Exception ee) {
						}
					}
					if (inStream != null) {
						try {
							inStream.close();
						} catch (Exception ee) {
						}
					}
				}

				if (reponseData.equals("$EE")) {
					reponseData = "";
				}

				// ����ܺ�
				Md_Car_Temp.getTempCar().webState = true;

			} else {

				// ���粻��
				Md_Car_Temp.getTempCar().webState = false;
				reponseData = "";
			}
		} catch (Exception e) {
			// ���粻��
			Md_Car_Temp.getTempCar().webState = false;
			reponseData = "";

			// ��ӡ������Ϣ
			e.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.disconnect();
				} catch (Exception e) {
				}
				con = null;
			}
		}

		return getResXml(reponseData);
	}

	/**
	 * �������ݴ���
	 */
	private static String getResXml(String reponseData) {
		if (!reponseData.equals("")) {
			try {
				String temp = reponseData.replace("&lt;", "<").replace("&gt;",
						">");
				int startIndex = temp.indexOf("<root>");
				int endIndex = temp.indexOf("</root>");
				String Resxml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
						+ temp.substring(startIndex, endIndex + 7);
				return Resxml;
			} catch (Exception e) {
				return "";
			}
		}
		return "";
	}
}
