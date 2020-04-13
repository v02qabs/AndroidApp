package hiro.take.hriotakeeditorbyjava;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class page_viewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewer);
        webviewer();
    }

    private void webviewer() {
        WebView v = findViewById(R.id.viewer);
        v.loadUrl("https://www.google.com");

    }
}

