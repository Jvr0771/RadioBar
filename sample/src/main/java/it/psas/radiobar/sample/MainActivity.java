package it.psas.radiobar.sample;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import it.psas.radiobar.RadioBar;
import it.psas.radiobar.RadioImageView;
import it.psas.radiobarsample.R;

public class MainActivity extends AppCompatActivity {

	int mSelectedRadioImageViewPosition = 0;
	int mSelectedRadioImageViewOldPosition = 0;
	private CoordinatorLayout mCoordinatorLayout;
	private RadioBar mRadioBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
		mRadioBar = (RadioBar) findViewById(R.id.radioBar1);
		mRadioBar.setOnSelectedItemChangeListener(new RadioBar.OnSelectedItemChangeListener() {
			@Override
			public void onSelectedItemChange(RadioBar radioBar, int id, int position) {
				mSelectedRadioImageViewOldPosition = mSelectedRadioImageViewPosition;
				mSelectedRadioImageViewPosition = position;
				RadioImageView mSelectedRadioImageView = (RadioImageView) findViewById(id);
				Snackbar.make(mCoordinatorLayout, "Selected item at position " + position + "!", Snackbar.LENGTH_LONG)
						.setAction("UNDO", mSnackBarActionClickListener)
						.show();
			}
		});
		mRadioBar.checkAtPosition(0);
		int mSelectedRadioImageViewId = mRadioBar.getSelectedRadioImageViewId();
		RadioImageView mSelectedRadioImageView = (RadioImageView) findViewById(mSelectedRadioImageViewId);
	}

	View.OnClickListener mSnackBarActionClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			mRadioBar.checkAtPosition(mSelectedRadioImageViewOldPosition);
		}
	};
}
