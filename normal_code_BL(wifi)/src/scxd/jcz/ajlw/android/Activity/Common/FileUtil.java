package scxd.jcz.ajlw.android.Activity.Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @className FileUtil
 * @author goubaihu
 * @function 瀵笲itmap杞寲鎴愬瓧鑺傛暟缁勩?
 * @createTime 2014骞?1鏈?8鍙?
 */
public class FileUtil {
	/**
	 * 鍐欏叆鏈湴閰嶇疆鏂囦欢
	 * 
	 * @param str
	 */
	public static boolean writeToFile(String str, String fileString) {
		File file = new File(fileString);
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			if (!file.exists()) {
				File file2 = new File(file.getParent());
				file2.mkdir();
			}
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
			return false;
		}
	}

	public static boolean writeToFile(String desFilePath, InputStream is)
			throws Exception {
		return writeToFile(new File(desFilePath), is);
	}

	/**
	 * 鑾峰彇鏂囦欢杈撳叆娴?
	 * 
	 * @param filePath
	 *            鏂囦欢璺緞
	 * @return 鏂囦欢杈撳叆娴?
	 */
	public static InputStream getInputStream(String filePath) {
		File gsyDataFile = new File(filePath);
		if (!gsyDataFile.exists()) {
			return null;
		}
		try {
			return new FileInputStream(gsyDataFile);
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	/**
	 * 鍐欏叆鏂囦欢
	 * 
	 * @param desFile
	 *            璺緞
	 * @param is
	 *            鍐欏叆娴?
	 * @return 鏄惁鍐欏叆鎴愬姛
	 * @throws Exception
	 */
	public static boolean writeToFile(File desFile, InputStream is)
			throws Exception {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(desFile, false);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
			}
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 鍒ゆ柇鏂囦欢鏄惁瀛樺湪
	 * 
	 * @param filePath
	 *            鏂囦欢璺緞
	 * @return 鍒ゅ畾瀛樺湪
	 */
	public static boolean isExist(String filePath) {
		try {
			return new File(filePath).exists();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 鍒犻櫎鏂囦欢
	 * 
	 * @param path
	 *            鏂囦欢璺緞
	 * @return 鍒ゅ畾鍒犻櫎鎴愬姛
	 */
	public static boolean deleteFileByPath(String path) {
		if (path.equals(""))
			return false;
		File file = new File(path);
		return file.delete();
	}

	/**
	 * 鍒犻櫎鐩綍涓嬬殑鏂囦欢
	 * 
	 * @param directory
	 *            鐩綍璺緞
	 * @return 鍒ゅ畾鍒犻櫎鎴愬姛
	 */
	public static boolean deleteFilesByDirectory(File directory) {
		try {
			if (directory != null && directory.exists()
					&& directory.isDirectory()) {
				String[] children = directory.list();
				// 递归删除目录中的子目录下
				if (children.length > 0) {
					for (int i = 0; i < children.length; i++) {
						boolean success = deleteDir(new File(directory,
								children[i]));
						if (!success) {
							return false;
						}
					}
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 删除空目录
	 * 
	 * @param dir
	 *            将要删除的目录路
	 */
	private static boolean doDeleteEmptyDir(String dir) {
		boolean success = (new File(dir)).delete();
		if (success) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 递归删除目录下的所有文件及子目录下所有文件 *
	 * 
	 * @param dir
	 *            将要删除的文件目录 *
	 * @return boolean Returns "true" if all deletions were successful. * If a
	 *         deletion fails, the method stops attempting to * delete and
	 *         returns "false".
	 */
	private static boolean deleteDir(File dir) {
		if (dir != null && dir.exists() && dir.isDirectory()) {
			String[] children = dir.list();
			// 递归删除目录中的子目录下
			if (children.length > 0) {
				for (int i = 0; i < children.length; i++) {
					boolean success = deleteDir(new File(dir, children[i]));
					if (!success) {
						return false;
					}
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}
}
