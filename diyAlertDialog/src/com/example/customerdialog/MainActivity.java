package com.example.customerdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etName;
	private EditText etPwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		findViewById(R.id.btnRegister).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//��ʾ�Ի���
				showDialog();
				
			}
		});
		
		
	}
	
	/**
	 * ��ʾһ���Ի���
	 */
	private void showDialog(){
		//���㶨��Ĳ����ļ������һ��View
		View view = View.inflate(this, R.layout.item, null);
		etName = (EditText) view.findViewById(R.id.etName);
		etPwd = (EditText) view.findViewById(R.id.etPwd);
		
		//����һ�������Ի����һ��Builder��ʵ��
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		//���ָ���������Լ������View
		builder.setView(view);
		//����dialog��ť
		builder.setNegativeButton("ȡ��", null);
		
		builder.setPositiveButton("ע��", new android.content.DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {

				//��������sharedperfrences
				Toast.makeText(MainActivity.this, "ע����", 0).show();
			
				//��ӡ������̨
				System.out.println("�û��� : "+etName.getText().toString()+" " +
						"���� : "+etPwd.getText().toString());
			}
		});
		
		
		//����һ���Ի���
		AlertDialog dialog = builder.create();
		//��ʾ�Ի���
		dialog.show();
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
