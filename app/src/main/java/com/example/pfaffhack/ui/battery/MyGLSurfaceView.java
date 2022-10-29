package com.example.pfaffhack.ui.battery;
import android.content.Context;
import android.opengl.GLSurfaceView;

import com.example.pfaffhack.ui.battery.MyGLRenderer;

class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer renderer;

    public MyGLSurfaceView(Context context){
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        renderer = new MyGLRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(renderer);
    }
}

