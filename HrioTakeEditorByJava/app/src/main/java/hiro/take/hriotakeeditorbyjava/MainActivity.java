package hiro.take.hriotakeeditorbyjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mf = getMenuInflater();
        mf.inflate(R.menu.top_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch
        (item.getItemId())
        {
            case R.id.viewer
                :
                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, page_viewer.class);
            startActivity(intent);
                    return true;
        }
        return false;
    }
}
