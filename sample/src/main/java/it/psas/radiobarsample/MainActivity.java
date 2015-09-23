package it.psas.radiobarsample;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import it.psas.radiobar.RadioBar;
import it.psas.radiobar.RadioImageView;

public class MainActivity extends AppCompatActivity {

	int mSelectedRadioImageViewId = 0;
	int mSelectedRadioImageViewOldId = 0;
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
				mSelectedRadioImageViewId = id;
				RadioImageView mSelectedRadioImageView = (RadioImageView) findViewById(id);
				Snackbar.make(mCoordinatorLayout, "Selected item at position " + position + "!", Snackbar.LENGTH_LONG)
						.setAction("UNDO", mSnackBarActionClickListener)
						.show();
			}
		});
		mSelectedRadioImageViewId = mRadioBar.getSelectedRadioImageViewId();
		RadioImageView mSelectedRadioImageView = (RadioImageView) findViewById(mSelectedRadioImageViewId);
	}

	View.OnClickListener mSnackBarActionClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			mRadioBar.check(mSelectedRadioImageViewOldId);
			mSelectedRadioImageViewOldId = mSelectedRadioImageViewId;
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
