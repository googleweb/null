package scxd.jcz.ajlw.android.Activity.Common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * д����־������
 * @author Administrator
 *
 */
public class LogWriter {

	private static LogWriter mLogWriter;

	private static String FileBasePath = "/mnt/sdcard/jclwjcz/log2/";

	private static String mPath;

	private static SimpleDateFormat df;

	private LogWriter() {
		this.mPath = getFilePath();
	}

	private static String getFilePath() {
		return FileBasePath
				+ new SimpleDateFormat("yyyyMMdd").format(new Date())
				+ ".txt";
	}

	public static LogWriter open() {
		try{
		if (mLogWriter == null) {
			mLogWriter = new LogWriter();
		}
		File mFile = new File(mPath);

		// �ж��ļ����Ƿ����
		if (!mFile.exists()) {
			File file2 = new File(mFile.getParent());
			file2.mkdir();
		}

		// �ж��ļ��Ƿ����
		if (!mFile.isDirectory()) {
			// ɾ��������ļ�
			deleteFile();
			mFile.createNewFile();
		}

		df = new SimpleDateFormat("[yy-MM-dd hh:mm:ss]: ");
		}catch(Exception e){
			e.printStackTrace();
		}
		return mLogWriter;
	}

	/**
	 * ɾ��һ��֮ǰ��Ϊ��־�ļ�
	 * 
	 * @throws Exception
	 */
	private static void deleteFile() throws Exception {
		File pathRoot = new File(FileBasePath);
		if (pathRoot.exists() && pathRoot.listFiles().length > 0) {
			for (File file : pathRoot.listFiles()) {
				String s=file.getName().substring(0, file.getName().length()-4);
				Date date = new SimpleDateFormat("yyyyMMdd").parse(s);
				if ((new Date().getTime() - date.getTime()) > 2 * 24 * 60 * 60
						* 1000) {
					file.delete();
				}
			}
		}
	}
	/**
	 * д��
	 * @param MethodName
	 * @param cls
	 * @param log
	 */
	public static void appendMethodA(String MethodName, Class cls, String log) {
		RandomAccessFile randomFile=null;
		try {
			String writerLog = df.format(new Date()) + MethodName + cls.getSimpleName()
					+ log + "\n";
			randomFile = new RandomAccessFile(mPath, writerLog);
			long fileLength = randomFile.length();
			randomFile.seek(fileLength);// ��ָ���Ƶ��ļ�β����׼��д������
			randomFile.writeBytes(writerLog);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(randomFile!=null){
				randomFile=null;
			}
		}
	}
	/**
	 * д������׷�ӵ��ļ�β��
	 * 
	 * @throws IOException
	 */
	public static void appendMethodA(Class cls, String log) {
		RandomAccessFile randomFile=null;
		try {
			String writerLog = df.format(new Date()) + cls.getSimpleName()
					+ log + "\n";
			randomFile = new RandomAccessFile(mPath, writerLog);
			long fileLength = randomFile.length();
			randomFile.seek(fileLength);// ��ָ���Ƶ��ļ�β����׼��д������
			randomFile.writeBytes(writerLog);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(randomFile!=null){
				randomFile=null;
			}
		}
	}

	/**
	 * д������׷�ӵ��ļ�β��
	 * 
	 * @throws IOException
	 */
	public static void appendMethodA(String log) {
		RandomAccessFile randomFile=null;
		try {
			String writerLog = df.format(new Date()) + log + "\n";
			randomFile = new RandomAccessFile(mPath, writerLog);
			long fileLength = randomFile.length();
			randomFile.seek(fileLength);// ��ָ���Ƶ��ļ�β����׼��д������
			randomFile.writeBytes(writerLog);
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(randomFile!=null){
				randomFile=null;
			}
		}
	}
	
	public static void appendMethodB(String MethodName, Class cls, String log) {
		FileWriter writer=null;
		try {
			// ���ļ���д������������true��׷����ʽд�ļ�
			writer = new FileWriter(mPath, true);
			writer.write(df.format(new Date())+MethodName+cls.getSimpleName());
			writer.write(log);
			writer.write("\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){
				writer=null;
			}
		}
	}
	
	public static void appendMethodB(Class cls, String log) {
		FileWriter writer=null;
		try {
			// ���ļ���д������������true��׷����ʽд�ļ�
			writer = new FileWriter(mPath, true);
			writer.write(df.format(new Date())+cls.getSimpleName());
			writer.write(log);
			writer.write("\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){
				writer=null;
			}
		}
	}

	public static void appendMethodB(String log) {
		FileWriter writer=null;
		try {
			// ���ļ���д������������true��׷����ʽд�ļ�
			writer = new FileWriter(mPath, true);
			writer.write(df.format(new Date()));
			writer.write(log);
			writer.write("\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){
				writer=null;
			}
		}
	}
}
