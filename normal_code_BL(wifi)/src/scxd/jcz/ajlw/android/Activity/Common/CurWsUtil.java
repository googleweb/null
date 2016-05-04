package scxd.jcz.ajlw.android.Activity.Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/**
 * 网络工具类
 * @author Administrator
 *@createtime 
 */
public class CurWsUtil {

	public static long getNetworkSpeed(Context context) {
		ProcessBuilder cmd;
		long readBytes = 0;
		BufferedReader bufferReader = null;
		try {
			String[] args = { "/system/bin/cat", "/proc/net/dev" };
			cmd = new ProcessBuilder(args);
			Process process = cmd.start();
			bufferReader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line;
			while ((line = bufferReader.readLine()) != null) {
				if (line.contains("wlan0") && isWiFiNetworkAvailable(context)) {
					String[] delim = line.split(":");
					if (delim.length >= 2) {
						String values = delim[1].trim();
						values = nSpace2one(values);
						String[] numbers = values.split(",");// 提取数据
						readBytes = Long.parseLong(numbers[0].trim());
						readBytes += Long.parseLong(numbers[8].trim());
						break;
					}
				}
				if (line.contains("eth0") && isNetworkAvailable(context)) {
					String[] delim = line.split(":");
					if (delim.length >= 2) {
						String values = delim[1].trim();
						values = nSpace2one(values);
						String[] numbers = values.split(",");
						readBytes = Long.parseLong(numbers[0].trim());
						readBytes += Long.parseLong(numbers[8].trim());
						break;
					}
				}
			}
			bufferReader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (bufferReader != null) {
				try {
					bufferReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return readBytes;
	}

	// 处理字符串数据的
	private static String nSpace2one(String s) {
		String regEx = "[' ']+"; // 一个或多个空格
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(s);
		String ret = m.replaceAll(",").trim();
		return ret;
	}

	public static boolean isWiFiNetworkAvailable(Context context) {
		boolean netSataus = false;
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netinfo = cm.getActiveNetworkInfo();
		if (netinfo != null
				&& netinfo.getType() == ConnectivityManager.TYPE_WIFI) {
			netSataus = netinfo.isAvailable();
		}
		return netSataus;
	}

	public static boolean isNetworkAvailable(Context context) {
		boolean netSataus = false;
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netinfo = cm.getActiveNetworkInfo();
		if (netinfo != null) {
			netSataus = netinfo.isAvailable();
		}
		return netSataus;
	}

}
