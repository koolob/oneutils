package com.koolob.oneutils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class V {

	public static class Animations {
		public static TranslateAnimation createTranslateAnimation(float fx,
				float tx, float fy, float ty, long dura) {
			TranslateAnimation ta = new TranslateAnimation(
					Animation.RELATIVE_TO_SELF, fx, Animation.RELATIVE_TO_SELF,
					tx, Animation.RELATIVE_TO_SELF, fy,
					Animation.RELATIVE_TO_SELF, ty);
			ta.setDuration(dura);
			return ta;
		}

		public static TranslateAnimation t2b(long dura) {
			TranslateAnimation ta = createTranslateAnimation(0, 0, 0, 1, dura);
			ta.setFillAfter(true);
			ta.setFillEnabled(true);
			return ta;
		}

		public static TranslateAnimation b2t(long dura) {
			TranslateAnimation ta = createTranslateAnimation(0, 0, 1, 0, dura);
			ta.setFillAfter(true);
			ta.setFillEnabled(true);
			return ta;
		}
	}

	public static void alert(Context c, String oktext, String msg,
			final android.content.DialogInterface.OnClickListener l) {
		new AlertDialog.Builder(c).setMessage(msg).setPositiveButton(oktext, l)
				.setOnKeyListener(new DialogInterface.OnKeyListener() {
					@Override
					public boolean onKey(DialogInterface dialog, int keyCode,
							KeyEvent event) {
						if (keyCode == KeyEvent.KEYCODE_SEARCH
								|| keyCode == KeyEvent.KEYCODE_BACK) {
							dialog.dismiss();
							if (l != null) {
								l.onClick(dialog, 0);
							}
							return true;
						}
						return false;
					}
				}).show();
	}

	public static void choose(Context c, String oktext, String cancelText,
			String msg, final android.content.DialogInterface.OnClickListener l) {
		new AlertDialog.Builder(c)
				.setMessage(msg)
				.setPositiveButton(oktext, l)
				.setNegativeButton(cancelText,
						new android.content.DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();
							}
						})
				.setOnKeyListener(new DialogInterface.OnKeyListener() {
					@Override
					public boolean onKey(DialogInterface dialog, int keyCode,
							KeyEvent event) {
						if (keyCode == KeyEvent.KEYCODE_SEARCH
								|| keyCode == KeyEvent.KEYCODE_BACK) {
							dialog.dismiss();
							return true;
						}
						return false;
					}
				}).show();
	}

	public static class Gradient {
		private int startColor = 0;
		private int centerColor = 0;
		private int endColor = 0;
		private int solid = 0;
		private int strokeWidth = 0;
		private int strokeColor = 0;
		private float topleft = 0;
		private float topright = 0;
		private float bottomleft = 0;
		private float bottomright = 0;
		private GradientDrawable.Orientation ori = null;

		public Gradient setStartColor(int color) {
			this.startColor = color;
			return this;
		}

		public Gradient setCenterColor(int color) {
			this.centerColor = color;
			return this;
		}

		public Gradient setEndColor(int color) {
			this.endColor = color;
			return this;
		}

		public Gradient setOrientation(GradientDrawable.Orientation ori) {
			this.ori = ori;
			return this;
		}

		public Gradient setSolid(int color) {
			this.solid = color;
			return this;
		}

		public Gradient setStoke(int width, int color) {
			this.strokeWidth = width;
			this.strokeColor = color;
			return this;
		}

		public Gradient setCornerRadius(float rad) {
			this.topleft = this.topright = this.bottomleft = this.bottomright = rad;
			return this;
		}

		public void setTopleft(float topleft) {
			this.topleft = topleft;
		}

		public void setTopright(float topright) {
			this.topright = topright;
		}

		public void setBottomleft(float bottomleft) {
			this.bottomleft = bottomleft;
		}

		public void setBottomright(float bottomright) {
			this.bottomright = bottomright;
		}

		public GradientDrawable build() {
			GradientDrawable gd = null;
			if (this.startColor != 0 && this.endColor != 0 && this.ori != null) {
				int[] colors = this.centerColor != 0 ? new int[] {
						this.startColor, this.centerColor, this.endColor }
						: new int[] { this.startColor, this.endColor };
				gd = new GradientDrawable(this.ori, colors);
			} else {
				gd = new GradientDrawable();
			}
			if (this.solid != 0) {
				gd.setColor(solid);
			}
			if (this.strokeWidth > 0 && this.strokeColor != 0) {
				gd.setStroke(this.strokeWidth, this.strokeColor);
			}
			gd.setCornerRadii(new float[] { this.topleft, this.topleft,
					this.topright, this.topright, this.bottomright,
					this.bottomright, this.bottomleft, this.bottomleft });
			return gd;
		}
	}

	public static class Selector {

		private Drawable normal = null;
		private Drawable focused = null;
		private Drawable pressed = null;

		public Selector addNormalDrawable(Drawable d) {
			this.normal = d;
			return this;
		}

		public Selector addFocusedDrawable(Drawable d) {
			this.focused = d;
			return this;
		}

		public Selector addPressedDrawable(Drawable d) {
			this.pressed = d;
			return this;
		}

		public StateListDrawable build() {
			StateListDrawable sd = new StateListDrawable();
			sd.addState(new int[] { android.R.attr.state_enabled,
					android.R.attr.state_focused }, focused);
			sd.addState(new int[] { android.R.attr.state_pressed,
					android.R.attr.state_enabled }, pressed);
			sd.addState(new int[] { android.R.attr.state_focused }, focused);
			sd.addState(new int[] { android.R.attr.state_pressed }, pressed);
			sd.addState(new int[] { android.R.attr.state_enabled }, normal);
			sd.addState(new int[] {}, normal);
			return sd;
		}
	}

}
