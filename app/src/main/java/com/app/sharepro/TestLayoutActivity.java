package com.app.sharepro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.sharepro.ui.layout.ConstraintTestActivity;
import com.app.sharepro.ui.layout.FrameTestActivity;
import com.app.sharepro.ui.layout.LinearTestActivity;
import com.app.sharepro.ui.layout.RelativeTestActivity;

/**
 * Created by duanlei on 2017/12/15.
 */

public class TestLayoutActivity extends BaseActivity {

  ListView mListView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test_layout);

    mListView = findViewById(R.id.lv_menu);

    String[] data = new String[] {"线性布局", "相对布局", "帧布局", "约束布局"};

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
        this,
        R.layout.item_menu,
        data);

    mListView.setAdapter(adapter);

    mListView.setOnItemClickListener((parent, view, position, id) -> {
      switch (position) {
        case 0: //线性布局
          startActivity(new Intent(TestLayoutActivity.this, LinearTestActivity.class));
          break;
        case 1: //相对布局
          startActivity(new Intent(TestLayoutActivity.this, RelativeTestActivity.class));
          break;
        case 2: //帧布局
          startActivity(new Intent(TestLayoutActivity.this, FrameTestActivity.class));
          break;
        case 3: //约束布局
          startActivity(new Intent(TestLayoutActivity.this, ConstraintTestActivity.class));
          break;
      }
    });
  }


}
