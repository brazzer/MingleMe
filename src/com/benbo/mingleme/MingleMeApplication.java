package com.benbo.mingleme;


import android.app.Application;
import dagger.ObjectGraph;
import java.util.Arrays;
import java.util.List;

public class MingleMeApplication extends Application {
  private ObjectGraph graph;

  @Override public void onCreate() {
    super.onCreate();

    graph = ObjectGraph.create(getModules().toArray());
  }

  protected List<Object> getModules() {
    return Arrays.asList(
        new AndroidModule(this),
        new ModuleMock()
    );
  }
  
  public void inject(Object object) {
	    graph.inject(object);
	  }
}