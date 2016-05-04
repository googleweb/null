package scxd.jcz.ajlw.android.Adapter;

import java.util.ArrayList;
import java.util.List;

import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * @className PicturePreviewAdapter
 * @author goubaihu
 * @function 拍照预览适配�?
 * @createTime 2014�?1�?8�?
 */
public class PicturePreviewAdapter extends PagerAdapter {

	private Context mCon;
	private List<View> views;

	public PicturePreviewAdapter(Context con, List<String> pics) {
		mCon = con;
		views = getViews(pics);
	}

	private List<View> getViews(List<String> pics) {
		List<View> views = new ArrayList<View>();
		for (int i = 0; i < pics.size(); i++) {
			View view = LayoutInflater.from(mCon).inflate(
					R.layout.listview_adapter_picture_preview, null);
			ImageView imageView = (ImageView) view.findViewById(R.id.image);
			imageView.setImageBitmap(getBitmap(getImagePath(pics.get(i))));
			views.add(view);
		}
		return views;
	}

	@Override
	public int getCount() {
		return views == null ? 0 : views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		if (container != null) {
			container.removeView(views.get(position));
		}
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "页面" + (position + 1);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		if (container != null) {
			View view = views.get(position);
			if (view.getParent() != null) {
				((ViewPager) view.getParent()).removeView(view);
			}
			container.addView(view);
		}
		return views.get(position);
	}

	private String getImagePath(String picID) {
		return "/mnt/sdcard/jclwjcz/ggimage/"
				+ Md_Car_Temp.getTempCar().ggbh
				+ "/" + picID + ".jpg";
	}

	private Bitmap getBitmap(String imagePath) {
		Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
		return bitmap;
	}
}
