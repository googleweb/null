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
 * @function 对Bitmap转化成字节数组�?
 * @createTime 2014�?1�?8�?
 */
public class FileUtil {
	/**
	 * 写入本地配置文件
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
	 * 获取文件输入�?
	 * 
	 * @param filePath
	 *            文件路径
	 * @return 文件输入�?
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
	 * 写入文件
	 * 
	 * @param desFile
	 *            路径
	 * @param is
	 *            写入�?
	 * @return 是否写入成功
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
	 * 判断文件是否存在
	 * 
	 * @param filePath
	 *            文件路径
	 * @return 判定存在
	 */
	public static boolean isExist(String filePath) {
		try {
			return new File(filePath).exists();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param path
	 *            文件路径
	 * @return 判定删除成功
	 */
	public static boolean deleteFileByPath(String path) {
		if (path.equals(""))
			return false;
		File file = new File(path);
		return file.delete();
	}

	/**
	 * 删除目录下的文件
	 * 
	 * @param directory
	 *            目录路径
	 * @return 判定删除成功
	 */
	public static boolean deleteFilesByDirectory(File directory) {
		try {
			if (directory != null && directory.exists()
					&& directory.isDirectory()) {
				String[] children = directory.list();
				// �ݹ�ɾ��Ŀ¼�е���Ŀ¼��
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
	 * ɾ����Ŀ¼
	 * 
	 * @param dir
	 *            ��Ҫɾ����Ŀ¼·
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
	 * �ݹ�ɾ��Ŀ¼�µ������ļ�����Ŀ¼�������ļ� *
	 * 
	 * @param dir
	 *            ��Ҫɾ�����ļ�Ŀ¼ *
	 * @return boolean Returns "true" if all deletions were successful. * If a
	 *         deletion fails, the method stops attempting to * delete and
	 *         returns "false".
	 */
	private static boolean deleteDir(File dir) {
		if (dir != null && dir.exists() && dir.isDirectory()) {
			String[] children = dir.list();
			// �ݹ�ɾ��Ŀ¼�е���Ŀ¼��
			if (children.length > 0) {
				for (int i = 0; i < children.length; i++) {
					boolean success = deleteDir(new File(dir, children[i]));
					if (!success) {
						return false;
					}
				}
			}
		}
		// Ŀ¼��ʱΪ�գ�����ɾ��
		return dir.delete();
	}
}
