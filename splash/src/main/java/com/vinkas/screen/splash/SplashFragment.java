package com.vinkas.screen.splash;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Vinoth on 4-6-16.
 */
public class SplashFragment extends Fragment {

    protected SplashListener listener;

    protected TextView tvStatus, tvFooter;
    protected ImageView ivIcon, ivTitle;

    private String statusText, footerText;
    private Integer iconDrawable, titleDrawable;

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String text) {
        statusText = text;
        if (tvStatus != null)
            tvStatus.setText(statusText);
    }

    public String getFooterText() {
        return footerText;
    }

    public void setFooterText(String text) {
        footerText = text;
        if (tvFooter != null)
            tvFooter.setText(footerText);
    }

    public Integer getTitleDrawable() {
        return titleDrawable;
    }

    public void setTitleDrawable(Integer resId) {
        titleDrawable = resId;
        if(ivTitle != null)
            setTitleDrawable();
    }

    private void setTitleDrawable() {
        ivTitle.setImageDrawable(getContext().getResources().getDrawable(titleDrawable));
    }

    public Integer getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(Integer resId) {
        iconDrawable = resId;
        if(ivIcon != null)
            setIconDrawable();
    }

    private void setIconDrawable() {
        ivIcon.setImageDrawable(getContext().getResources().getDrawable(iconDrawable));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RelativeLayout rl = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);
        tvStatus = (TextView) rl.findViewById(R.id.tvStatusText);
        tvFooter = (TextView) rl.findViewById(R.id.tvFooterText);
        ivIcon = (ImageView) rl.findViewById(R.id.ivIcon);
        ivTitle = (ImageView) rl.findViewById(R.id.ivTitle);
        if (getStatusText() != null)
            tvStatus.setText(getStatusText());
        if (getFooterText() != null)
            tvFooter.setText(getFooterText());
        if(getTitleDrawable() != null)
            setTitleDrawable();
        if(getIconDrawable() != null)
            setIconDrawable();
        return rl;
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SplashFragment);

        String statusText = a.getString(R.styleable.SplashFragment_status_text);
        String footerText = a.getString(R.styleable.SplashFragment_footer_text);
        int titleDrawable = R.styleable.SplashFragment_title_drawable;
        int iconDrawable = R.styleable.SplashFragment_icon_drawable;

        if (statusText != null)
            setStatusText(statusText);
        if (footerText != null)
            setFooterText(footerText);
        if(titleDrawable != 0)
            setTitleDrawable(titleDrawable);
        if(iconDrawable != 0)
            setIconDrawable(iconDrawable);

        a.recycle();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SplashListener) {
            listener = (SplashListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement SplashListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
