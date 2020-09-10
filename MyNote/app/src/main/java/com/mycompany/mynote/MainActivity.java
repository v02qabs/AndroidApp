package com.mycompany.mynote;

import android.app.*;
import android.os.*;
import org.apache.http.client.utils.*;
import android.content.*;
import android.widget.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		makeing_thread();
        setContentView(R.layout.main);
	}
	private void makeing_thread()
	{
		Runnable mr = new MyRunnable(this);
		new Thread(mr).start();
		
	}
	
}

class MyRunnable implements Runnable
{
	Context co;
	public MyRunnable(Context context)
	{
		this.co = context;
	}
	@Override
	public void run()
	{
		Toast.makeText(co, "Hello", Toast.LENGTH_LONG).show();
	}
}

