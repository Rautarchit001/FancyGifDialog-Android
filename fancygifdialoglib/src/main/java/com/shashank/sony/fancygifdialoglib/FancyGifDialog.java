package com.shashank.sony.fancygifdialoglib;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;



public class FancyGifDialog {
    public static class Builder {
        private String title, message, positiveBtnText, negativeBtnText, pBtnColor, nBtnColor, shareBtnText, rateBtnText, sBtnColor, rBtnColor;
        private Activity activity;
        private FancyGifDialogListener pListener, nListener, sListener, rListener;
        private boolean cancel;
        int gifImageResource;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }


        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setPositiveBtnText(String positiveBtnText) {
            this.positiveBtnText = positiveBtnText;
            return this;
        }

        public Builder setPositiveBtnBackground(String pBtnColor) {
            this.pBtnColor = pBtnColor;
            return this;
        }


        public Builder setNegativeBtnText(String negativeBtnText) {
            this.negativeBtnText = negativeBtnText;
            return this;
        }

        public Builder setNegativeBtnBackground(String nBtnColor) {
            this.nBtnColor = nBtnColor;
            return this;
        }
		
		
		
		
		       public Builder setShareBtnText(String shareBtnText) {
            this.shareBtnText = shareBtnText;
            return this;
        }

        public Builder setShareBtnBackground(String sBtnColor) {
            this.sBtnColor = sBtnColor;
            return this;
        }


        public Builder setRateBtnText(String rateBtnText) {
            this.rateBtnText = rateBtnText;
            return this;
        }

        public Builder setRateBtnBackground(String rBtnColor) {
            this.rBtnColor = rBtnColor;
            return this;
        }
		
		
		


        //set Positive listener
        public Builder OnPositiveClicked(FancyGifDialogListener pListener) {
            this.pListener = pListener;
            return this;
        }

		
        //set Negative listener
        public Builder OnNegativeClicked(FancyGifDialogListener nListener) {
            this.nListener = nListener;
            return this;
        }




        //set Positive listener
        public Builder OnShareClicked(FancyGifDialogListener sListener) {
            this.sListener = sListener;
            return this;
        }

		
        //set Negative listener
        public Builder OnRateClicked(FancyGifDialogListener rListener) {
            this.rListener = rListener;
            return this;
        }






		
        public Builder isCancellable(boolean cancel) {
            this.cancel = cancel;
            return this;
        }

        public Builder setGifResource(int gifImageResource) {
            this.gifImageResource = gifImageResource;
            return this;
        }

        public FancyGifDialog build() {
         TextView message1, title1;
            Button nBtn, pBtn, sBtn, rBtn;
            GifImageView gifImageView;
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(cancel);
            dialog.setContentView(R.layout.fancygifdialog);


            //getting resources
            title1 = dialog.findViewById(R.id.title);
            message1 = dialog.findViewById(R.id.message);
            nBtn = dialog.findViewById(R.id.negativeBtn);
            pBtn = dialog.findViewById(R.id.positiveBtn);
			sBtn = dialog.findViewById(R.id.shareBtn);
            rBtn = dialog.findViewById(R.id.rateBtn);
            gifImageView = dialog.findViewById(R.id.gifImageView);
            gifImageView.setImageResource(gifImageResource);



            title1.setText(title);
            message1.setText(message);
            if (positiveBtnText != null) {
                pBtn.setText(positiveBtnText);
                if (pBtnColor != null) {
                    GradientDrawable bgShape = (GradientDrawable) pBtn.getBackground();
                    bgShape.setColor(Color.parseColor(pBtnColor));
                }

                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (pListener != null) pListener.OnClick();
                        dialog.dismiss();
                    }

                });
				
				
            } else {
                pBtn.setVisibility(View.GONE);
            }
            if (negativeBtnText != null) {
                nBtn.setText(negativeBtnText);
                nBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (nListener != null) nListener.OnClick();
                        dialog.dismiss();
                    }
                });
                if (nBtnColor != null) {
                    GradientDrawable bgShape = (GradientDrawable) nBtn.getBackground();
                    bgShape.setColor(Color.parseColor(nBtnColor));
                }
            } else {
                nBtn.setVisibility(View.GONE);
            }
			
			
			
			if (shareBtnText != null) {
                sBtn.setText(shareBtnText);
                if (sBtnColor != null) {
                    GradientDrawable bgShape = (GradientDrawable) sBtn.getBackground();
                    bgShape.setColor(Color.parseColor(sBtnColor));
                }

                sBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (sListener != null) sListener.OnClick();
                        dialog.dismiss();
                    }

                });
				
				
            } else {
                sBtn.setVisibility(View.GONE);
            }
            if (rateBtnText != null) {
                rBtn.setText(rateBtnText);
                rBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (rListener != null) rListener.OnClick();
                        dialog.dismiss();
                    }
                });
                if (rBtnColor != null) {
                    GradientDrawable bgShape = (GradientDrawable) rBtn.getBackground();
                    bgShape.setColor(Color.parseColor(rBtnColor));
                }
            } else {
                rBtn.setVisibility(View.GONE);
            }
			
			
			
            dialog.show();

            return new FancyGifDialog();

        }
    }

}
