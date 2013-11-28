package com.boes.animationdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private RelativeLayout mContainer;
	private RelativeLayout mCard;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Inflate card view and attach to container
		mContainer = (RelativeLayout) findViewById(R.id.layout_main);		
		mCard = (RelativeLayout) getLayoutInflater().inflate(R.layout.item_card, mContainer, true);		
	}
		
	public void onAnimate(View v) {
		Toast.makeText(this, "Animating", Toast.LENGTH_SHORT).show();
		
		// To animate in parallel
		// v.animate().rotation(-90)
		//            .translationY(-mCard.getHeight())
		//            .setInterpolator(new OvershootInterpolator(5.0f))
		//            .setDuration(1500);

		// To animate sequentially
		ObjectAnimator first = ObjectAnimator.ofFloat(v, "rotation", -90).setDuration(1000);
		first.setInterpolator(new OvershootInterpolator(5.0f));
		ObjectAnimator second = ObjectAnimator.ofFloat(v, "translationY", -mCard.getHeight()).setDuration(500);
		AnimatorSet set = new AnimatorSet();
		set.playSequentially(first, second);
		set.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
