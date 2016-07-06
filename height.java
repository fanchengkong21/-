 height = getWindowManager().getDefaultDisplay().getHeight();
        Log.i("高度","没有带虚拟导航栏的屏幕高度"+height);

        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        @SuppressWarnings("rawtypes")
        Class c;
        try {
            c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics",DisplayMetrics.class);
            method.invoke(display, dm);
            dpi=dm.heightPixels;
        }catch(Exception e){
            e.printStackTrace();
        }
        Log.i("高度","带有虚拟导航栏的屏幕高度"+dpi);
        if (height==dpi){//没有虚拟导航栏的界面
            setContentView(R.layout.new_activity_person_none);
        }else {//有虚拟导航栏的界面
            setContentView(R.layout.new_activity_person);
        }
