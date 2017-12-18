package com.app.sharepro.entities;

/**
 * Created by duanlei on 2017/12/18.
 */

public class MenuEntity {
  private String title;
  private Class activityClz;

  public MenuEntity(String title, Class activityClz) {
    this.title = title;
    this.activityClz = activityClz;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Class getActivityClz() {
    return activityClz;
  }

  public void setActivityClz(Class activityClz) {
    this.activityClz = activityClz;
  }
}
