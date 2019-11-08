package com.example.collageapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.flexbox.FlexDirection;

public class MainActivity extends AppCompatActivity {
    LinearLayout collage_oneView;
    LinearLayout collage_twoxoneView;
    LinearLayout collage_onextwoView;
    LinearLayout collage_twoxtwoView;
    LinearLayout collage_twoxthreeView;
    LinearLayout collage_threextwoView;
    LinearLayout collage_threexthreeView;
    LinearLayout collage_eightxoneview;
    LinearLayout collage_unfocus;
    CollageCreater creater;
    LinearLayout parentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creater = new CollageCreater(this);
        parentView = findViewById(R.id.gridParentView);
        InitializeComponent();
        creater = new CollageCreater(this);
        creater.DoLayout();
    }

    public LinearLayout getParentView() {
        return parentView;
    }

    private void InitializeComponent() {
        collage_oneView = findViewById(R.id.oneimageview);
        collage_twoxoneView = findViewById(R.id.twoxoneview);
        collage_onextwoView = findViewById(R.id.onextwoview);
        collage_twoxtwoView = findViewById(R.id.twoxtwoview);
        collage_twoxthreeView = findViewById(R.id.twoxthreeview);
        collage_threextwoView = findViewById(R.id.threextwoview);
        collage_threexthreeView = findViewById(R.id.threexthreeview);
        collage_eightxoneview = findViewById(R.id.eightxoneview);
        collage_unfocus = collage_oneView;
        collage_unfocus.setBackgroundTintList(getResources().getColorStateList(R.color.collage_state));

        collage_oneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFocus(collage_unfocus, (LinearLayout) v);
                creater.setItemsPerPage(1);
                creater.setItemPerRow(1);
                creater.setFlexDirection(FlexDirection.ROW);
                creater.DoLayout();
            }
        });

        collage_twoxoneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFocus(collage_unfocus, (LinearLayout) v);
                creater.setItemsPerPage(2);
                creater.setItemPerRow(1);
                creater.setFlexDirection(FlexDirection.ROW);
                creater.DoLayout();
            }
        });

        collage_onextwoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFocus(collage_unfocus, (LinearLayout) v);
                creater.setItemsPerPage(2);
                creater.setItemPerRow(2);
                creater.setFlexDirection(FlexDirection.ROW);
                creater.DoLayout();
            }
        });

        collage_twoxtwoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFocus(collage_unfocus, (LinearLayout) v);
                creater.setItemsPerPage(4);
                creater.setItemPerRow(2);
                creater.setFlexDirection(FlexDirection.ROW);
                creater.DoLayout();
            }
        });

        collage_twoxthreeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFocus(collage_unfocus, (LinearLayout) v);
                creater.setItemsPerPage(6);
                creater.setItemPerRow(3);
                creater.setFlexDirection(FlexDirection.ROW);
                creater.DoLayout();
            }
        });

        collage_threextwoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFocus(collage_unfocus, (LinearLayout) v);
                creater.setItemsPerPage(6);
                creater.setItemPerRow(2);
                creater.setFlexDirection(FlexDirection.ROW);
                creater.DoLayout();
            }
        });

        collage_threexthreeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFocus(collage_unfocus, (LinearLayout) v);
                creater.setItemsPerPage(9);
                creater.setItemPerRow(3);
                creater.setFlexDirection(FlexDirection.ROW);
                creater.DoLayout();
            }
        });

        collage_eightxoneview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFocus(collage_unfocus, (LinearLayout) v);
                creater.setItemsPerPage(8);
                creater.setItemPerRow(3);
                creater.setFlexDirection(FlexDirection.COLUMN);
                creater.DoLayout();
            }
        });
    }

    private void setFocus(LinearLayout collage_unfocus, LinearLayout collage_focus) {
        if (collage_unfocus != collage_focus) {
            collage_focus.setBackgroundTintList(MainActivity.this.getResources().getColorStateList(R.color.collage_state));
            collage_unfocus.setBackgroundTintList(MainActivity.this.getResources().getColorStateList(R.color.collage_unfocus));
            this.collage_unfocus = collage_focus;
        }

    }
}
