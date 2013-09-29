package j.com.ikan_task;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources.NotFoundException;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{
	
	private Button mShortInfoBtn;
	private Button mQuestionBtn;
	private Button mToggleBtn;
	private String message="Are you sure you want to exit?"; 
	private String shortInfo=" Provides a user friendly interface and a complete set of core applications.";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// get id's for controls
		getViewById();
		//set events
		setOnClickListener();
		
	}
	/**
	 * This method fetch the id's for all the resources.
	 * 
	 * @throws Exception
	 *             when getViewById returns null
	 */
	private void getViewById() throws NotFoundException {
		mShortInfoBtn = (Button) findViewById(R.id.btn_info);
		mQuestionBtn = (Button) findViewById(R.id.btn_question);
		mToggleBtn = (Button) findViewById(R.id.btn_toggle);
	}
	
	private void setOnClickListener() {
		
		mShortInfoBtn.setOnClickListener(this);
		mQuestionBtn.setOnClickListener(this);
		mToggleBtn.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btn_info:	// show short info	
			Toast.makeText(this, shortInfo, Toast.LENGTH_LONG).show();
			break;

		case R.id.btn_question:// ask question and toast your ans
			AlertMessage(message);
			
			break;
		case R.id.btn_toggle:// display toggle
			break;

		default:
		}

	}
	
	
	/**
	 * Shows alert messages
	 * 
	 * @param message
	 *            QuestionBtn Message
	 * @param title
	 *            Alert Box title
	 */
	private void AlertMessage(String message) {
		try {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(message);
			builder.setTitle("confirmation");
			builder.setIcon(R.drawable.ic_dialog_alert_large_thumb);
			builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					Toast.makeText(getBaseContext(), "You clicked yes", Toast.LENGTH_LONG).show();
					dialog.cancel();
	                
				}
			});
			
			builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					Toast.makeText(getBaseContext(), "You clicked No", Toast.LENGTH_LONG).show();
					dialog.cancel();
	
				}
			});
			
			AlertDialog alert = builder.create();			
			alert.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
