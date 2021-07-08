package com.KAB.ParticleTextViewAix;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.appinventor.components.annotations.*;
import android.widget.FrameLayout;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.util.YailList;
import rx.android.plugins.*;
import rx.android.schedulers.*;
import rx.android.*;
import rx.functions.Action1;
import java.util.ArrayList;
import java.util.Arrays;
@DesignerComponent(
        version = 1,
        description = "Particle Text View",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "")

@SimpleObject(external = true)
@UsesLibraries(libraries = "rx.jar, rxjava.jar")

public class ParticleTextViewAix extends AndroidNonvisibleComponent {

    //Activity and Context
    private Context context;
    private Activity activity;
    private ParticleTextView particleTextView;
    private ArrayList arr;

    public ParticleTextViewAix(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    @SimpleFunction()
    public void Configure(AndroidViewComponent androidViewComponent, int rowStep, int columnStep, String targetText, double releasing, float particleRadius, double miniDistance, int textSize, String movingStrategy , YailList colors){
FrameLayout frameLayout = (FrameLayout) androidViewComponent.getView();
ParticleTextView particleTextView = new ParticleTextView(this.context); 
RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
ParticleTextViewConfig config = new ParticleTextViewConfig.Builder()
                .setRowStep(rowStep)
                .setColumnStep(columnStep)
                .setTargetText(targetText)
                .setReleasing(releasing)
                .setParticleRadius(particleRadius)
                .setMiniDistance(miniDistance)
                .setTextSize(textSize)
                .setMovingStrategy(randomMovingStrategy)
                .setParticleColorArray(colors.toStringArray())
                .instance();
particleTextView.setConfig(config);
frameLayout.addView(particleTextView, new FrameLayout.LayoutParams(-1, -1));
    }
@SimpleFunction()
public void StartAnimation() {
    particleTextView.startAnimation();
    AnimationStarted();
}
@SimpleFunction()
public void StopAnimation() {
    particleTextView.stopAnimation();
    AnimationStopped();

}
    @SimpleEvent()
    public void AnimationStarted(){
        EventDispatcher.dispatchEvent(this, "Animation Started");
    }
    @SimpleEvent()
    public void AnimationStopped(){
        EventDispatcher.dispatchEvent(this, "Animation Stopped");
    }
    
  //  @SimpleFunction
  //  public void Colors(YailList yailList){
        //Now i would convert yailList to arrayList , first let me convert it to string array
  //      String[] stringArray = yailList.toStringArray();
        //Now i would convert it into arrayList so ;

  //      ArrayList<String> arrayList = new ArrayList<String>();
   //     for(int i = 0 ; i<stringArray.length ; i++){
   //         arrayList.add(stringArray[i]);
   //     }

  //      this.arr = arrayList;
   //     //Now do whatever with arraylist 

  //  }
   
    
}