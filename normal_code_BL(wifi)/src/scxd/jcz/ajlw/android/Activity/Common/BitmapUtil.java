package scxd.jcz.ajlw.android.Activity.Common;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

/**
 * @className BitmapUtil
 * @author goubaihu
 * @function 对Bitmap转化成字节数组�?
 * @createTime 2014�?1�?8�?
 */
public class BitmapUtil {
	/**
	 * 把bitmap对象转换成byte数组
	 * 
	 * @param bm
	 *            �?��转换的bitmap
	 * @return 转换后的数组
	 */
	public static byte[] bitmapToByte(Bitmap bm) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.PNG, 50, bos);
		return bos.toByteArray();
	}

	/**
	 * 把字节数组保存为�?��文件
	 * 
	 * @param b
	 *            字节数组
	 * @outputFile 图片保存的地�?
	 * @return 返回的file对象
	 */
	public static File getFileFromBytes(byte[] b, String outputFile) {
		BufferedOutputStream stream = null;
		File file = null;
		try {
			file = new File(outputFile);
			FileOutputStream fstream = new FileOutputStream(file);
			stream = new BufferedOutputStream(fstream);
			stream.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return file;
	}

	/**
	 * 获取bitmap的字节大�?
	 * 
	 * @param bm
	 * 
	 * @return Bitmap大小
	 */
	public static int getBitmapSize(Bitmap bm) {
		return bm.getRowBytes() * bm.getHeight();
	}

	/**
	 * 从SD卡加载图�?
	 * 
	 * @param imagePath
	 *            图片路径
	 * @return Bitmap
	 */
	public static Bitmap getImageFromLocal(String imagePath) {
		try {
			File file = new File(imagePath);
			if (file.exists()) {
				Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
				return bitmap;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 保存图片到SD�?
	 * 
	 * @param imagePath
	 * @param bitmap
	 * @throws IOException
	 */
	public static int JPG = 1;
	public static int PNG = 2;

	public static void saveBitmap(Bitmap bitmap, String imagePath, int format)
			throws IOException {
		File file;
		file = new File(imagePath);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		if (format == PNG) {
			bitmap.compress(CompressFormat.PNG, 100, fos);
		} else if (format == JPG) {
			bitmap.compress(CompressFormat.JPEG, 100, fos);
		}
		fos.flush();
		fos.close();
	}

	/**
	 * 根据宽度等比例缩放图�?
	 * 
	 * @param defaultBitmap
	 * @param width
	 * @return
	 */
	public static Bitmap resizeImageByWidth(Bitmap defaultBitmap,
			int targetWidth) {
		int rawWidth = defaultBitmap.getWidth();
		int rawHeight = defaultBitmap.getHeight();
		float targetHeight = targetWidth * (float) rawHeight / (float) rawWidth;
		float scaleWidth = targetWidth / (float) rawWidth;
		float scaleHeight = targetHeight / (float) rawHeight;
		Matrix localMatrix = new Matrix();
		localMatrix.postScale(scaleHeight, scaleWidth);
		return Bitmap.createBitmap(defaultBitmap, 0, 0, rawWidth, rawHeight,
				localMatrix, true);
	}
}
