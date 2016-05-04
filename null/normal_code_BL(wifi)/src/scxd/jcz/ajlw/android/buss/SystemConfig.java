package scxd.jcz.ajlw.android.buss;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.Md_system;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * 操作系统配置信息
 * 
 * @author xxy
 */
public class SystemConfig {
	/**
	 * 获取系统配置信息->静态方法 返回类型INT类型
	 * 
	 * @return 1 没有找到系统配置文件 2 获取系统配置信息异常 0 获取系统配置信息成功
	 */
	public static int GetSystemConfigData(Context context) {
		try {
			File file = new File("/mnt/sdcard/jclwjcz/config-ajlw.xml");
			if (!file.isFile()) {
				return 1;
			} else {
				DocumentBuilderFactory docFactory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder builder = docFactory.newDocumentBuilder();
				Document doc = builder.parse(file);
				NodeList nl = doc.getElementsByTagName("system");
				for (int i = 0; i < nl.getLength(); i++) {
					Md_system.setJk_url(doc.getElementsByTagName("url").item(i)
							.getFirstChild().getNodeValue());
					Md_system.setDzkey(doc.getElementsByTagName("dzkey")
							.item(i).getFirstChild().getNodeValue()); // 检验机构编号编码之前的值
					Md_system.setPtkey(doc.getElementsByTagName("ptkey")
							.item(i).getFirstChild().getNodeValue()); // 检验机构编号编码之后的值
					Md_system.setXtlb(doc.getElementsByTagName("xtlb").item(i)
							.getFirstChild().getNodeValue());
					try {
						Md_system.setHphmlb(doc.getElementsByTagName("hphmlb")
								.item(i).getFirstChild().getNodeValue());
						/*Md_system.setZpbh(doc.getElementsByTagName("zpbh")
								.item(i).getFirstChild().getNodeValue());
						Md_system.setZpmc(doc.getElementsByTagName("zpmc")
								.item(i).getFirstChild().getNodeValue());*/
						Md_system.setDq(doc.getElementsByTagName("dq").item(i)
								.getFirstChild().getNodeValue());
						//System.out.println(Md_system.dq);
						Md_system.setSfhj(doc.getElementsByTagName("sfhj")
								.item(i).getFirstChild().getNodeValue());
						Md_system.setSfSign(doc.getElementsByTagName("sfsign")
								.item(i).getFirstChild().getNodeValue());
						Md_system.setSiglelogin(doc.getElementsByTagName("sigle")
								.item(i).getFirstChild().getNodeValue());
						Md_system.setSfchose(doc.getElementsByTagName("sfchose")
								.item(i).getFirstChild().getNodeValue());
						Md_system.setSfzj(doc.getElementsByTagName("sfzj")
								.item(i).getFirstChild().getNodeValue());
						Md_system.setSfgxjyxm(doc
								.getElementsByTagName("sfgxjyxm").item(i)
								.getFirstChild().getNodeValue());
						Md_system.setSfdtdp(doc
								.getElementsByTagName("sfdtdp").item(i)
								.getFirstChild().getNodeValue());
						Md_system.setLsxh(doc
								.getElementsByTagName("lsxh").item(i)
								.getFirstChild().getNodeValue());
					} catch (Exception r) {
					}
					PackageManager pm = context.getPackageManager();
					PackageInfo info = context.getPackageManager()
							.getPackageInfo(context.getPackageName(), 0);
					Md_system.setVersion(info.versionName);
				}
			}

		} catch (Exception e) {
			System.out.println("错误日志：" + e.getMessage());
			return 2;
		}

		return 0;

	}

	/**
	 * 读取配置文件
	 */
	public static String readFilePzXm(String fileName) {
		String read;
		String readStr = "";
		FileReader fileread;
		BufferedReader bufread;
		try {
			if (Md_Car_Temp.getTempCar().sfxc.equals("0")) {
				fileread = new FileReader("/mnt/sdcard/jclwjcz/" + fileName
						+ "1.xml");
			} else {
				fileread = new FileReader("/mnt/sdcard/jclwjcz/" + fileName
						+ ".xml");
			}

			bufread = new BufferedReader(fileread);
			try {
				while ((read = bufread.readLine()) != null) {
					readStr = readStr + read + "\r\n";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readStr;
	}

	/**
	 * 检测拍照项目 在用车 01.xml 02.xml 03.xml 04.xml 05.xml 新车 01N.xml 02N.xml 03N.xml
	 * 04N.xml 05N.xml
	 */
	public static boolean IsCzPzXm() {

		File file = new File("/mnt/sdcard/jclwjcz/01.xml");
		if (!file.isFile()) {

			return false;
		} else {

			return true;
		}
	}

	/**
	 * 写入拍照项目文件
	 * 
	 * @param str文件名
	 * 
	 */
	public static void writeFile_PzXm(String msg, String fileName) {
		if (!msg.equals("")) {

			File file;
			file = new File("/mnt/sdcard/jclwjcz/" + fileName);
			FileOutputStream fos = null;
			FileInputStream fis = null;
			try {
				file.createNewFile();
				fos = new FileOutputStream(file);
				fos.write(msg.getBytes());
				fos.close();
				fis = new FileInputStream(file);
				fis.close();
			} catch (IOException e) {

			}
		}
	}

	/**
	 * 写入文件
	 * 
	 * @param str文件名
	 * 
	 */
	public static void writeFile(String str) {
		File file;

		file = new File("/mnt/sdcard/jclwjcz/pbwym.txt");

		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			file.createNewFile();
			fos = new FileOutputStream(file);

			fos.write(str.getBytes());

			fos.close();
			fis = new FileInputStream(file);

			fis.close();
		} catch (IOException e) {

		}
	}

	/**
	 * 写入本地配置文件
	 * 
	 * @param str
	 */
	public static boolean writeConfigFile(String str, String fileString) {
		File file = new File(fileString);
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			// 判断文件夹是否存在，不存在创建该文件夹
			if (!file.exists()) {
				File file2 = new File(file.getParent());

				if (file2.mkdir()) {
					System.out.println("创建文件夹成功！");
				} else {
					System.out.println("创建文件夹失败！");
				}
			}
			// 判断文件是否存在，不存在创建该文件
			if (!file.isDirectory()) {
				file.createNewFile();
			}

			fos = new FileOutputStream(file);
			fos.write(str.getBytes());
			fos.close();
			fis = new FileInputStream(file);

			fis.close();
			return true;
		} catch (IOException e) {
			System.err.println("异常:" + e.getMessage());
			return false;
		}
	}

	/**
	 * 从网上下载
	 * 
	 * @param url
	 *            下载路径
	 * @param outputFile
	 *            创建本地保存流的文件
	 * @return 下载失败返回1(比如没有网络等情况)下载成功返回0
	 */
	public static int downloadFile(String urlPsth, File outputFile) {

		int result = 0;

		try {

			URL url = new URL(urlPsth);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setDoInput(true);

			conn.connect();

			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK)

			{

				InputStream is = conn.getInputStream();

				FileOutputStream fos = new FileOutputStream(outputFile);

				byte[] bt = new byte[1024];

				int count = 0;

				int i = 0;

				while ((i = is.read(bt)) > 0) {

					fos.write(bt, 0, i);

				}

				fos.flush();

				fos.close();

				is.close();

			} else {

				result = 1;

			}

		} catch (FileNotFoundException e) {

			result = 1;

		} catch (IOException e) {

			result = 1;

		}

		return result;

	}

	/**
	 * 读取升级配置文件
	 */
	public static String readVersion() {
		String readStr = "";
		int b;
		try {
			URL url = new URL(Md_system.getJk_url().substring(0,
					Md_system.getJk_url().lastIndexOf("/"))
					+ "/version.txt");
			InputStream is = url.openStream();
			BufferedInputStream bis = new BufferedInputStream(is);

			while ((b = is.read()) != -1) {
				readStr = readStr + (char) b;
			}
			is.close();
			bis.close();
			readStr = new String(readStr.getBytes("UTF-8")).trim().replace(" ",
					"");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return readStr;
	}

}
