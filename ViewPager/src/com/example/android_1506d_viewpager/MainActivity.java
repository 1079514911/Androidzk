package com.example.android_1506d_viewpager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	private ViewPager viewPager;
	private List<Integer> list;
	private RadioGroup radioGroup;
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			//����handler���͵���Ϣ
			if(msg.what==0){
				int i=0;
				//����Viewpager��ʾͼƬ��λ��
				i=viewPager.getCurrentItem();
				viewPager.setCurrentItem(i+1);
			}
		};
	};
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        	
        //��ȡ��ԴID
        viewPager=(ViewPager) findViewById(R.id.viewpager);
        radioGroup=(RadioGroup) findViewById(R.id.radiogroup);
        
        list=new ArrayList<Integer>();
        
        //���ͼƬ����
        list.add(R.drawable.c);
        list.add(R.drawable.d);
        list.add(R.drawable.e);
        //��Activity  ����Դ ����adapter
        ViewPagerAdapter adapter=new ViewPagerAdapter(list, this);
        
        viewPager.setAdapter(adapter);
        //û��2���Զ���Handler����һ����Ϣ �л�ͼƬ
        new Thread(){
        	public void run() {
        		
        		while (true) {
					try {
						sleep(2000);
						handler.sendEmptyMessage(0);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
        		
        	};
        }.start();
        
        
        
        
        //����ʾͼƬ��λ�����õ� �м�  ��������
        viewPager.setCurrentItem(list.size()*10000);
    
        //����ѡ�е�ҳ����
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			//ѡ���ҳ��
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				//ͨ��ͼƬ��λ��ѡ��Button
				switch (arg0%list.size()) {
				case 0:
					radioGroup.check(R.id.but1);
					
					break;
				case 1:
					radioGroup.check(R.id.but2);			
					break;
				case 2:
					radioGroup.check(R.id.but3);
					break;

				default:
					break;
				}
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        
    }
    
}
