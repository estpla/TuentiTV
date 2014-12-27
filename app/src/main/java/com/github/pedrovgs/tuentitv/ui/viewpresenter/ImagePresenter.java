package com.github.pedrovgs.tuentitv.ui.viewpresenter;

import android.content.Context;
import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.github.pedrovgs.tuentitv.ui.data.ImageInfo;
import com.squareup.picasso.Picasso;
import com.tuenti.tuentitv.R;

public class ImagePresenter extends Presenter {

  public static final int IMAGE_HEIGHT = 200;
  public static final int IMAGE_WIDTH = 300;
  private static Context context;

  static class ViewHolder extends Presenter.ViewHolder {

    private ImageView imageView;

    public ViewHolder(View view) {
      super(view);
      imageView = (ImageView) view.findViewById(R.id.iv_media_element);
    }

    protected void updateCardViewImage(String url) {
      Picasso.with(context)
          .load(url)
          .resize(IMAGE_WIDTH, IMAGE_HEIGHT)
          .centerCrop()
          .placeholder(R.color.third_color)
          .into(imageView);
    }
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent) {
    context = parent.getContext();
    View view = LayoutInflater.from(context).inflate(R.layout.image_item, null);
    ImageView imageView = (ImageView) view.findViewById(R.id.iv_media_element);
    imageView.setMinimumHeight(IMAGE_HEIGHT);
    imageView.setMinimumWidth(IMAGE_WIDTH);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
    ImageInfo imageInfo = (ImageInfo) item;
    if (imageInfo.getImageUrl() != null) {
      ((ViewHolder) viewHolder).updateCardViewImage(imageInfo.getImageUrl());
    }
  }

  @Override public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
    //Empty
  }

  @Override public void onViewAttachedToWindow(Presenter.ViewHolder viewHolder) {
    //Empty
  }
}
