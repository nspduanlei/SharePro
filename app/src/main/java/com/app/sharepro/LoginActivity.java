package com.app.sharepro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by duanlei on 2017/11/14.
 */

public class LoginActivity extends BaseActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
  }

  public void gotoMain(View view) {
    startActivity(new Intent(this, MainActivity.class));
    this.finish();
  }
}
