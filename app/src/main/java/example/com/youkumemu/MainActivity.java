package example.com.youkumemu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout level1;

    private RelativeLayout level2;

    private RelativeLayout level3;

    private ImageButton home;

    private ImageButton menu;

    private boolean isLevel3Show = true;

    private boolean isLevel2Show = true;

    private boolean isLevel1Show = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        level1 = (RelativeLayout) findViewById(R.id.level1);
        level2 = (RelativeLayout) findViewById(R.id.level2);
        level3 = (RelativeLayout) findViewById(R.id.level3);
        home = (ImageButton) findViewById(R.id.icon_home);
        menu = (ImageButton) findViewById(R.id.icon_menu);
        home.setOnClickListener(this);
        menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.icon_menu:
                if (isLevel3Show){
                    MyUtils.startAnimOut(level3);
                    isLevel3Show = false;
                }else{
                    MyUtils.startAnimIn(level3);
                    isLevel3Show = true;
                }

                break;
            case R.id.icon_home:
                if (isLevel2Show){
                    MyUtils.startAnimOut(level2, 200);
                    isLevel2Show = false;
                    if (isLevel3Show){
                        MyUtils.startAnimOut(level3);
                        isLevel3Show =false;
                    }
                }else{
                    MyUtils.startAnimIn(level2);
                    isLevel2Show = true;
                }

                break;
            default:
                break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_MENU){
            changeLevel1State();
        }
        return super.onKeyDown(keyCode,event);
    }

    private void changeLevel1State() {

        if (isLevel1Show){

            MyUtils.startAnimOut(level1, 200);
            isLevel1Show = false;
            if (isLevel2Show){

                MyUtils.startAnimOut(level2, 100);
                isLevel2Show = false;
                if (isLevel3Show){
                    MyUtils.startAnimOut(level3);
                    isLevel3Show = false;

                }
            }
        }else{
            MyUtils.startAnimIn(level1);
            MyUtils.startAnimIn(level2, 100);
            isLevel1Show = true;
            isLevel2Show = true;
        }
    }
}
