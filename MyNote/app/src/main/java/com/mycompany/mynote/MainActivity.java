package com.mycompany.mynote;

import android.app.*;
import android.os.*;
import org.apache.http.client.utils.*;
import android.content.*;
import android.widget.*;
import java.lang.*;
import android.support.v7.app.*;
public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		try
		{
			makeing_thread();
        }catch(Exception error)
		{
			
		}//setContentView(R.layout.main);
	}
	private void makeing_thread()
	{
		MyRunnable mr = new MyRunnable(getApplicationContext());
		mr.start();
	}
	
}

