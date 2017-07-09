package com.example.android_1505d_fragment_day09_dome;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Fragment01 extends Fragment{
	
	private View view;
	private ListView listView;
	private List<String> list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		view=inflater.inflate(R.layout.fragment01, container, false);
		
		//��ȡ��ԴID
		listView=(ListView) view.findViewById(R.id.listview);
		
		return view;
	}
	//����һЩ�߼��Ĳ���
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		list=new ArrayList<String>();
		//�������
		getdate();
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, list);
		//listview����չʾ����
		listView.setAdapter(adapter);
		//��listview��Item��Ӽ���
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//ͨ����ǰ��Activity�ĵ��������ڵĵ�Id
				Fragment02 fragment02=(Fragment02) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment02);
				//��listview��ֵ����fragment����
				fragment02.setTextArs(list.get(position));
			}
		});
		
	}
	public void getdate() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			list.add("С��"+i);
		}
		
		
	}

}
