package com.example.android_listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

/**
 * 照片墙主活动，使用GridView展示照片墙。
 * 
 * @author guolin
 */
public class MainActivity extends Activity {

	/**
	 * 用于展示照片墙的GridView
	 */
	private GridView mPhotoWall;

	/**
	 * GridView的适配器
	 */
	private PhotoWallAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mPhotoWall = (GridView) findViewById(R.id.photo_wall);
		adapter = new PhotoWallAdapter(this, 0, Images.getImages(), mPhotoWall);
		mPhotoWall.setAdapter(adapter);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 退出程序时结束所有的下载任务
		adapter.cancelAllTasks();
	}

}
