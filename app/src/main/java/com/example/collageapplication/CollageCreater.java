package com.example.collageapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.SizeF;

import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.flexbox.AlignContent;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import java.util.ArrayList;

import TouchUtils.MultiTouchListener;

public class CollageCreater {

    private final ArrayList<Bitmap> datasets;
    MainActivity mainActivity;
    int itemPerRow = 1;
    int itemsPerPage = 1;
    int flexDirection = FlexDirection.ROW;
    int flexWrap = FlexWrap.WRAP;
    LinearLayout parentListView;
    int width, height;

    public CollageCreater(MainActivity activity) {
        mainActivity = activity;
        datasets = new ArrayList<>();
        datasets.add(BitmapFactory.decodeResource(mainActivity.getResources(), R.drawable.house1));
        datasets.add(BitmapFactory.decodeResource(mainActivity.getResources(), R.drawable.house2));
        datasets.add(BitmapFactory.decodeResource(mainActivity.getResources(), R.drawable.house3));
        datasets.add(BitmapFactory.decodeResource(mainActivity.getResources(), R.drawable.house4));
        datasets.add(BitmapFactory.decodeResource(mainActivity.getResources(), R.drawable.house5));
        datasets.add(BitmapFactory.decodeResource(mainActivity.getResources(), R.drawable.house6));
        datasets.add(BitmapFactory.decodeResource(mainActivity.getResources(), R.drawable.house7));
        datasets.add(BitmapFactory.decodeResource(mainActivity.getResources(), R.drawable.house8));
        datasets.add(BitmapFactory.decodeResource(mainActivity.getResources(), R.drawable.house9));
        parentListView = mainActivity.findViewById(R.id.gridParentView);


        DisplayMetrics displaymetrics = new DisplayMetrics();
        mainActivity.getWindowManager().getDefaultDisplay()
                .getMetrics(displaymetrics);
        width = displaymetrics.widthPixels;
        height = displaymetrics.heightPixels;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setFlexDirection(int flexDirection) {
        this.flexDirection = flexDirection;
    }

    public void setItemPerRow(int itemPerRow) {
        this.itemPerRow = itemPerRow;
    }

    public void DoLayout() {
        final FlexboxLayout parentView = new FlexboxLayout(mainActivity);
        parentView.setFlexWrap(FlexWrap.WRAP_REVERSE);
        parentView.setFlexDirection(flexDirection);
        parentView.setAlignItems(AlignItems.CENTER);
        parentView.setAlignContent(AlignContent.CENTER);
        FlexboxLayout.LayoutParams params = new FlexboxLayout.LayoutParams(
                FlexboxLayout.LayoutParams.MATCH_PARENT,
                FlexboxLayout.LayoutParams.MATCH_PARENT
        );
        parentView.setLayoutParams(params);
        parentView.setBackgroundColor(mainActivity.getResources().getColor(R.color.grey_91));

        for (int i = 0; i < itemsPerPage; i++) {
            parentView.addView(getCollageView(i));
        }

        if (parentListView.getChildCount() > 0) {
            parentListView.removeAllViews();
        }

        parentListView.addView(parentView);
    }

    public CollageView getCollageView(int position) {
        Bitmap image = datasets.get(position);
        SizeF size = scaleSize(image.getWidth(), image.getHeight(), width / itemPerRow, height/itemPerRow);
        CollageView imageView = new CollageView(mainActivity);
        imageView.setOnTouchListener(new MultiTouchListener());
        GridView.LayoutParams gridParams = new GridView.LayoutParams((int) size.getWidth(), (int) size.getHeight());
        imageView.setLayoutParams(gridParams);
        imageView.setImageBitmap(image);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    private SizeF scaleSize(int width, int height, int maxWidth, int maxHeight) {

        if (width > height) {
            // landscape
            float ratio = (float) width / maxWidth;
            width = maxWidth;
            height = (int) (height / ratio);
        } else if (height > width) {
            // portrait
            float ratio = (float) height / maxHeight;
            height = maxHeight;
            width = (int) (width / ratio);
        } else {
            // square
            height = maxHeight;
            width = maxWidth;
        }

        return new SizeF(width, height);
    }
}
