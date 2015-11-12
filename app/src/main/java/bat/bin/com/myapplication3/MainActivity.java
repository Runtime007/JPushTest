package bat.bin.com.myapplication3;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.jpush.android.api.InstrumentedActivity;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends InstrumentedActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //why did you do that!

    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);

    }

    @Override
    protected void onPause() {
        JPushInterface.onPause(this);
        super.onPause();

    }
}
