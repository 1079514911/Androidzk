package com.example.android_1506d_viewpager;

import java.util.List;

import android.R.integer;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewPagerAdapter extends PagerAdapter{

	private List<Integer> list;
	private Context context;//������  ��ǰ��Activity
	public ViewPagerAdapter(List<Integer> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;//��ͼƬ���������õ����޴�
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}
	
	//������ͼ
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		//����ImagetView
		ImageView imageView=new ImageView(context);
		//���������ø�ImafeView
		imageView.setImageResource(list.get(position%list.size()));
		
		container.addView(imageView);		
		
		return  imageView;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View)object);
	
	}
	
	
	
}
