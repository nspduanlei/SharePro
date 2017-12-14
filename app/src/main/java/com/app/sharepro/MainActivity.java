package com.app.sharepro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.app.sharepro.util.SPUtil;

/**
 * Created by duanlei on 2017/11/14.
 */

public class MainActivity extends BaseActivity {

  private Switch mSwitch;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mSwitch = findViewById(R.id.switch_night);
    mSwitch.setChecked(isNight);

    mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SPUtil.put(MainActivity.this, "isNight", isChecked);
        refresh();
      }
    });
  }

  private void refresh() {
    finish();
    startActivity(new Intent(MainActivity.this, MainActivity.class));
    overridePendingTransition(0, 0);
  }
}
