package scxd.jcz.ajlw.android.Activity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.Md_Car_TongYong;
import scxd.jcz.ajlw.android.model.Md_system;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
/**
 * ����
 * @author Administrator
 *@time
 */
public class TakePhotoActivity extends BaseActivity implements
		SurfaceHolder.Callback {
	List<Md_Car_TongYong> list;
	ProgressDialog p_dialog;
	Bitmap bitmap;
	private SurfaceView surfaceView = null;
	private SurfaceHolder surfaceHolder = null;
	private Camera camera = null;
	private View controlPanel; // �������
	private boolean isPreviewing; // �Ƿ� ����Ԥ��
	private SeekBar mSeekBar;
	private ToggleButton lightTogBtn; // �Ƿ� �����
	private ToggleButton autoFocusTogBtn; // �Ƿ� �Զ��Խ�
	private ImageView tempImgView;
	private boolean isTakingPhoto = true; // �Ƿ� ����Ԥ��
	private boolean isSurfaceViewCreate = true; // �Ƿ� ����Ԥ��
	private Button btnSubmit;
	private TextView imgNameTxt;
	private Bitmap currentTakePhoto;
	private boolean safeToTakePicture = false;
	Bitmap bitmapes;
	Map<String, Object> requestMap = null;
	Map<String, Object> requestDate = null;
	private int width;// ��Ƭ���صĿ�
	private int height;// ��Ƭ���ظ�
	private boolean modle = false;
	private RelativeLayout sufaceViewLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.takephoto_layout);
		this.init();
		// this.getLTGG();
		modleType();

	}
/**
 * �ж�����
 */
	// �жϻ���
	private void modleType() {
		if (!android.os.Build.MODEL.equals("Lenovo K860i")
				&& !android.os.Build.MODEL.equals("Lenovo K860")) {
			modle = true;
		}
	}

	
/**
 * ��ʼ��
 */
	private void init() {
		this.setContentView(R.layout.takephoto_layout);
		TextView hphmTxt = (TextView) findViewById(R.id.txtCamera_hphm);
		hphmTxt.setText(hphmTxt.getText() + Md_Car_Temp.getTempCar().car_hphm);
		imgNameTxt = (TextView) findViewById(R.id.txtCamera_imgName);
		imgNameTxt.setText(imgNameTxt.getText()
				+ Md_Car_Temp.getTempCar().car_xmName);
		TextView vinTxt = (TextView) findViewById(R.id.txtCamera_clsbdh);
		vinTxt.setText(vinTxt.getText() + Md_Car_Temp.getTempCar().car_vin);
		tempImgView = (ImageView) findViewById(R.id.img_tempCamera);
		mSeekBar = (SeekBar) this.findViewById(R.id.seekbar);
		mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				surfaceView.setClickable(true);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				surfaceView.setClickable(false);
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				if (camera == null) {
					return;
				}
				if (camera.getParameters().isZoomSupported()) {
					Parameters params = camera.getParameters();
					params.setZoom(progress);
					camera.setParameters(params);
				}
			}
		});
		sufaceViewLayout = (RelativeLayout) findViewById(R.id.sufaceViewLayout);

		lightTogBtn = (ToggleButton) findViewById(R.id.btn_light);
		autoFocusTogBtn = (ToggleButton) findViewById(R.id.btn_autoFocus);
		controlPanel = findViewById(R.id.control_layout);
		surfaceView = (SurfaceView) findViewById(R.id.surfaceView_camera);
		surfaceHolder = surfaceView.getHolder();
		surfaceHolder.addCallback(this);
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

		btnSubmit = (Button) findViewById(R.id.btn_over);

		/**
		 * �����Ļ ����
		 */
		surfaceView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!isTakingPhoto || !isSurfaceViewCreate) {
					return;
				}
				isTakingPhoto = false;
				if (isPreviewing) {
					surfaceView.setClickable(false);// ������� �ذ� �쳣
					takePhoto();
				}
				isTakingPhoto = true;
			}
		});

		/**
		 * �������
		 */
		btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				btnSubmit.setEnabled(false);
				setPreview(false);
				TakePhotoActivity.this.request("18C63", getPhotoMap(),
						R.string.SUBMITPHOTO_MESSAGE, new String[] { "1" });
				Pzlx_Activity.isCameraSave = true;
			}
		});

		/**
		 * ��������
		 */
		findViewById(R.id.btn_retake).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (currentTakePhoto != null && !currentTakePhoto.isRecycled()) {
					currentTakePhoto.recycle();
					currentTakePhoto = null;
				}
				if (bitmapes != null && !bitmapes.isRecycled()) {
					bitmapes.recycle();
					bitmapes = null;
				}
				safeToTakePicture = false;
				sufaceViewLayout.setVisibility(View.VISIBLE);
				controlPanel.setVisibility(View.GONE);
				surfaceView.setClickable(true);
				mSeekBar.setEnabled(true);
				lightTogBtn.setEnabled(true);
				autoFocusTogBtn.setEnabled(true);

				setPreview(true);
			}
		});
	}

	/**
	 * ��ȡ��Ƭxml
	 * 
	 * @return
	 */
	private Map<String, Object> getPhotoMap() {
		if (requestMap != null) {
			requestMap = null;
		}
		if (requestDate != null) {
			requestDate = null;
		}
		try {

			requestMap = new HashMap<String, Object>();
			requestDate = new HashMap<String, Object>();
			requestDate.put("jylsh", Md_Car_Temp.getTempCar

			().car_lsh);
			requestDate.put("jyjgbh", Md_system.getDzkey());
			requestDate.put("jcxdh", 1);
			requestDate.put("jycs", Md_Car_Temp.getTempCar().car_jycs);
			requestDate.put("hphm", Md_Car_Temp.getTempCar().car_hphm);
			requestDate.put("hpzl", Md_Car_Temp.getTempCar

			().car_hpzl);
			requestDate.put("clsbdh", Md_Car_Temp.getTempCar

			().car_vin);

			ByteArrayOutputStream currentPhotoBAOS = null;

			try {
				currentPhotoBAOS = new ByteArrayOutputStream();
				if (currentTakePhoto.compress(Bitmap.CompressFormat.JPEG, 50,
						currentPhotoBAOS)) {

					byte[] imageBytes = currentPhotoBAOS.toByteArray();
					currentPhotoBAOS.flush();
					currentPhotoBAOS.close();
					currentPhotoBAOS = null;

					requestDate.put("zp",
							Base64.encodeToString(imageBytes, Base64.DEFAULT));

					imageBytes = null;

				}
			} catch (Exception e) {
				throw e;
			} finally {
				if (currentPhotoBAOS != null) {
					try {
						currentPhotoBAOS.close();
						currentPhotoBAOS = null;
					} catch (Exception ee) {
					}
				}
			}

			requestDate.put("pssj", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date()));
			requestDate.put("jyxm", "");
			requestDate.put("zpzl", Md_Car_Temp.getTempCar().pz_code);
			requestMap.put("vehispara", requestDate);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return requestMap;

	}

	private boolean isCameraSupportZoom() {
		if (android.os.Build.MODEL.equals("YP-G70")) {
			return false;
		}
		return camera != null && camera.getParameters().isZoomSupported();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		try{
		camera = Camera.open();
		}catch(Exception e)
		{
			Toast.makeText(getApplicationContext(), "�����ռ�ã������������ֻ�",
					Toast.LENGTH_LONG).show();
		}
		// ��ǰ�õ�����֧�ֵ����س���
		List<Size> PictureSizes = camera.getParameters()
				.getSupportedPictureSizes();
		int i = PictureSizes.size();
		if (PictureSizes.get(0).height > PictureSizes.get(i - 1).height) {// ȡ�������
			width = PictureSizes.get(0).width;
			height = PictureSizes.get(0).height;
		} else {
			width = PictureSizes.get(i - 1).width;
			height = PictureSizes.get(i - 1).height;
		}
		mSeekBar.setMax(camera.getParameters().getMaxZoom());
		mSeekBar.setProgress(camera.getParameters().getZoom());
		if (isCameraSupportZoom()) {
			mSeekBar.setVisibility(View.VISIBLE);
		} else {
			mSeekBar.setVisibility(View.GONE);
		}
		
		try {
			camera.setPreviewDisplay(holder); // ���� holder
		} catch (IOException e) {
			camera.release();
			camera = null;
			Toast.makeText(getApplicationContext(), "������쳣,������",
					Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		setPreview(false);
		if (surfaceHolder.getSurface() == null) {
			return;
		}

		try {
			camera.setPreviewDisplay(surfaceHolder);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setPreview(true);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		setPreview(false);
		if (camera != null) {
			camera.release();
			camera = null;
		}
	}

	/**
	 * ����
	 */
	private void takePhoto() {
		/**
		 * ���ε���shutter��onShutter()����, raw��onPictureTaken����,
		 * jpeg��onPictureTaken����
		 * ������camera.takePiture������camera�ر���Ԥ������ʱ��Ҫ����startPreview()�����¿���Ԥ��
		 */
		mSeekBar.setEnabled(false);
		lightTogBtn.setEnabled(false);
		autoFocusTogBtn.setEnabled(false);
		Camera.Parameters parameterss = camera.getParameters();
		 if (parameterss.getSupportedFocusModes().contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)) {
	            parameterss.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
	        }
		 camera.setParameters(parameterss);
		if (lightTogBtn.isChecked()) {
			// ���������
			Camera.Parameters parameters = camera.getParameters();
			parameters.setFlashMode(Camera.Parameters.FLASH_MODE_ON);
			if (modle) {
				parameters.setPictureSize(width, height);
			}
			camera.setParameters(parameters);

			camera.autoFocus(new AutoFocusCallback() {
				@Override
				public void onAutoFocus(boolean success, Camera camera) {
					if (safeToTakePicture) {
						camera.takePicture(null, null, new PictureCallback() {
							@Override
							public void onPictureTaken(byte[] data,
									Camera camera) {
								if (data == null) {
									return;
								}
								Camera.Parameters parameters = camera
										.getParameters();
								parameters
										.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
								camera.setParameters(parameters);
								processPhoto(data);

								//
								sufaceViewLayout.setVisibility(View.GONE);
								controlPanel.setVisibility(View.VISIBLE);
								setPreview(false);
								tempImgView.setImageBitmap(currentTakePhoto);
								// �ύ��ťΪ�ɵ��
								btnSubmit.setEnabled(true);
								safeToTakePicture = true;
							}
						});
						safeToTakePicture = false;
					}
				}
			});

		} else if (autoFocusTogBtn.isChecked()) {
			if (modle) {
				Camera.Parameters parameters = camera.getParameters();
				parameters.setPictureSize(width, height);
				camera.setParameters(parameters);
			}
			camera.autoFocus(new AutoFocusCallback() {
				@Override
				public void onAutoFocus(boolean success, Camera camera) {
					if (safeToTakePicture) {
						camera.takePicture(null, null, new PictureCallback() {
							@Override
							public void onPictureTaken(byte[] data,
									Camera camera) {
								if (data == null) {
									return;
								}
								processPhoto(data);
								sufaceViewLayout.setVisibility(View.GONE);
								controlPanel.setVisibility(View.VISIBLE);
								setPreview(false);
								tempImgView.setImageBitmap(currentTakePhoto);

								// �ύ��ťΪ�ɵ��
								btnSubmit.setEnabled(true);
								safeToTakePicture = true;
							}
						});
						safeToTakePicture = false;
					}
				}
			});
		} else {
			if (modle) {
				Camera.Parameters parameters = camera.getParameters();
				parameters.setPictureSize(width, height);
				camera.setParameters(parameters);
			}
			if (safeToTakePicture) {
				camera.takePicture(null, null, new PictureCallback() {
					@Override
					public void onPictureTaken(byte[] data, Camera camera) {
						if (data == null) {
							return;
						}
						processPhoto(data);
						sufaceViewLayout.setVisibility(View.GONE);
						controlPanel.setVisibility(View.VISIBLE);
						setPreview(false);
						tempImgView.setImageBitmap(currentTakePhoto);
						// �ύ��ťΪ�ɵ��
						btnSubmit.setEnabled(true);
						safeToTakePicture = true;
					}
				});
				safeToTakePicture = false;
			}
		}

	}
/**
 * ѹ����Ƭ
 * @param data ��Ƭ����
 */
	private void processPhoto(byte[] data) {
		System.out.println("data" + (data.length) / 1024);
		if (currentTakePhoto != null) {
			currentTakePhoto.recycle();
		}
		BitmapFactory.Options options = new BitmapFactory.Options();
		if ((data.length) / 1024 < 512) { // 0-20
			options.inSampleSize = 0;
			System.out.println("1");
		}else if ((data.length) / 1024 < 1024) {
			options.inSampleSize = 2;
			System.out.println("2");
		}else {
			options.inSampleSize = 4;
		}
		
		Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length,
				options).copy(Bitmap.Config.ARGB_8888, true);
		try {
			currentTakePhoto = resizeBitmap(bitmap, bitmap.getWidth(),
					bitmap.getHeight());
		} catch (Exception e) {
			currentTakePhoto = null;
			currentTakePhoto = bitmap;
		} finally {
			bitmap = null;
			data = null;
		}
	}

	// }

	/**
	 * ��Ƭѹ���� ���ˮӡ
	 * 
	 * @param bitmap
	 * @param srate
	 * @return
	 */
	private Bitmap resizeBitmap(Bitmap bitmap, int newWidth, int newHeight) {

		try {
			// ѹ��
			float scaleWidth = (float) newWidth / bitmap.getWidth();
			float scaleHeight = (float) newHeight / bitmap.getHeight();
			Matrix matrix = new Matrix();
			matrix.postScale(scaleWidth, scaleHeight);
			bitmapes = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
					bitmap.getHeight(), matrix, false);
			Canvas canvas_temp = new Canvas(bitmapes);
			Paint paint = new Paint();
			paint.setTextSize(25);
			paint.setColor(Color.RED);
			String date_text = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date());
			canvas_temp
					.drawText(String.format("%s  %s %s",
							Md_Car_Temp.getTempCar().car_hphm, date_text,"�����ˣ�"+Md_Car_Temp.getTempCar().userxingming), 5,
							20, paint);
			bitmap.recycle();

		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					e.getMessage() + "resizeBitmap", Toast.LENGTH_LONG).show();
		}
		return bitmapes;
	}

	/**
	 * ���� ��� Ԥ��״̬
	 * 
	 * @param is
	 */
	private void setPreview(boolean is) {
		if (camera == null) {
			return;
		}
		Camera.Parameters parameters = camera.getParameters();
		 if (parameters.getSupportedFocusModes().contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)) {
	            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
	        }
		 camera.setParameters(parameters);
		if (is) {
			if (!isPreviewing)
				camera.startPreview();
			safeToTakePicture = true;
			isPreviewing = true;
		} else {
			if (isPreviewing)
				camera.stopPreview();
			isPreviewing = false;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			setPreview(false);
			finish();
		}
		if (keyCode == 25) {// down
			/* �Զ������պ��� */
			if (isPreviewing) {
				surfaceView.setClickable(false);// ������� �ذ� �쳣
				// ���������
				Camera.Parameters parameters = camera.getParameters();
				if (lightTogBtn.isChecked())
					parameters.setFlashMode(Camera.Parameters.FLASH_MODE_ON);
				else
					parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
				camera.setParameters(parameters);

				parameters = null;

				// �Զ��Խ�
				if (autoFocusTogBtn.isChecked()) {
					camera.autoFocus(new AutoFocusCallback() {
						@Override
						public void onAutoFocus(boolean success, Camera camera) {
							takePhoto();
						}
					});
				} else
					takePhoto();
			}
		}
		if (keyCode == 24) {// up
			setPreview(false);
			btnSubmit.setEnabled(false);
			TakePhotoActivity.this.request("18C63", getPhotoMap(),
					R.string.SUBMITPHOTO_MESSAGE, new String[] { "1" });
		}
		return true;
	}

	static final int UPLOAD_PIC_FAILED = 0;
	static final int UPLOAD_PIC_SUCCESS = 1;

	@Override
	public void onRequestSuccess(String jkid, Object result) {
		try {
			if ("18C63".equals(jkid)) {
				List<Md_Car_TongYong> uploadPicResult = (List<Md_Car_TongYong>) result;
				Md_Car_TongYong tongYongResult = (Md_Car_TongYong) uploadPicResult
						.get(0);
				String code = tongYongResult.code;
				this.btnSubmit.setEnabled(true);
				dealResultSubPhoto(code);
			} else if ("18C49".equals(jkid)) {
				final HashMap<String, String> hm = (HashMap<String, String>) result;
				if (hm.get("ltgg") != null && !hm.get("ltgg").equals("")) {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							TakePhotoActivity.this.imgNameTxt.setText("��Ƭ���ƣ�"
									+ Md_Car_Temp.getTempCar().car_xmName + "-"
									+ hm.get("ltgg"));
						}
					});
				}
			}
		} catch (Exception e) {
			DefautDialog.showDialog(TakePhotoActivity.this, R.string.SYS_TITLE,
					R.string.serviceerrpr, false, null, null);
		}
	}

	/**
	 * �����ϴ���Ƭ�������
	 * 
	 * @param code
	 */
	private void dealResultSubPhoto(String code) {
		try {
			switch (Integer.parseInt(code)) {

			case UPLOAD_PIC_FAILED:
				Md_Car_Temp.getTempCar().isFinish = false;
				Toast.makeText(getApplicationContext(), "��Ƭ�ϴ�ʧ��!",
						Toast.LENGTH_LONG).show();
				return;

			case UPLOAD_PIC_SUCCESS:
				// ����
				// Md_Car_JYXM.message=Md_Car_JYXM.message+Md_Car_Temp.getTempCar().pz_code+",";
				if (Md_Car_Temp.getTempCar().zdyPZXM != null
						&& Md_Car_Temp.getTempCar().zdyPZXM
								.contains(Md_Car_Temp.getTempCar().pz_code)) {

					if (Md_Car_Temp.getTempCar().zdyHasTakeCodes == null) {
						Md_Car_Temp.getTempCar().zdyHasTakeCodes = new ArrayList<String>();
					}

					if (!Md_Car_Temp.getTempCar().zdyHasTakeCodes
							.contains(Md_Car_Temp.getTempCar().pz_code)) {
						Md_Car_Temp.getTempCar().zdyHasTakeCodes
								.add(Md_Car_Temp.getTempCar().pz_code);
					}
				}
				Md_Car_Temp.getTempCar().isFinish = true;
				Toast.makeText(getApplicationContext(), "��Ƭ�ϴ��ɹ�!",
						Toast.LENGTH_LONG).show();
				finish();
				break;
			case 4:
				Md_Car_Temp.getTempCar().isFinish = false;
				Toast.makeText(getApplicationContext(), "��ѯ�޴˳�����Ϣ,��ֹ����!",
						Toast.LENGTH_LONG).show();
				break;
			case 5:
				Md_Car_Temp.getTempCar().isFinish = false;
				Toast.makeText(getApplicationContext(), "�����쳣����������!",
						Toast.LENGTH_LONG).show();
				break;
			default:
				Md_Car_Temp.getTempCar().isFinish = false;
				Toast.makeText(getApplicationContext(), "��Ƭ�ϴ��쳣!",
						Toast.LENGTH_LONG).show();
				break;
			}
		} catch (Exception e) {
			Md_Car_Temp.getTempCar().isFinish = false;
			Toast.makeText(getApplicationContext(),
					"��Ƭ�ϴ��쳣�������²���!" + e.getMessage(), Toast.LENGTH_LONG).show();
			return;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Photofinish();
		if (camera != null) {
			camera.release();
			camera = null;
		}
	}

	public void Photofinish() {
		super.finish();
		if (this.currentTakePhoto != null && !currentTakePhoto.isRecycled()) {
			currentTakePhoto.recycle();
			currentTakePhoto = null;
		}
		if (this.bitmapes != null && !bitmapes.isRecycled()) {
			bitmapes.recycle();
			bitmapes = null;
		}
	}
}
