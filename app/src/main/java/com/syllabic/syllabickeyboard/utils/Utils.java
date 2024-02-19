package com.syllabic.syllabickeyboard.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;

import com.syllabic.syllabickeyboard.R;
import com.syllabic.syllabickeyboard.config.BaseConfig;

import android.inputmethodservice.Keyboard.Key;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

public class Utils {

    public static void setBackGroundDefault(Key key, Canvas canvas, Paint paint, Context context) {
        if (key.codes[0] == 113) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhiteIcon(key, canvas, paint, context);
        } else if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                || key.codes[0] == -10 || key.codes[0] == -11) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhite(key, canvas, paint, context);
        } else if (key.codes[0] == 97) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwo(key, canvas, paint, context);
        } else if (key.codes[0] == -1) {
            setColorButtonOrange(key, canvas, context);
//            setColorTextWhiteDemo(key, canvas, paint, context);
            drawIconDropRight(key, canvas, context);
        } else if (key.codes[0] == -3) {
            setColorButtonGreen(key, canvas, context);
            drawIconDropLeft(key, canvas, context);
        } else if (key.codes[0] == -2) {
            setColorButtonYellow(key, canvas, context);
            setColorTextWhiteLatin(key, canvas, paint, context);
        } else if (key.codes[0] == -5) {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
            drawIconDelete(key, canvas, context);
        } else {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
        }
    }

    public static void setBackGroundEmoji(Key key, Canvas canvas, Paint paint, Context context) {
        if (key.codes[0] == 1000 || key.codes[0] == -15) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhiteIcon(key, canvas, paint, context);
        } else if (key.codes[0] == 97) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwo(key, canvas, paint, context);
        } else if (key.codes[0] == -1) {
            setColorButtonOrange(key, canvas, context);
            drawIconDropRight(key, canvas, context);
        } else if (key.codes[0] == -3) {
            setColorButtonGreen(key, canvas, context);
            drawIconDropLeft(key, canvas, context);
        } else if (key.codes[0] == -2) {
            setColorButtonYellow(key, canvas, context);
            setColorTextWhiteLatin(key, canvas, paint, context);
        } else if (key.codes[0] == -5) {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
            drawIconDelete(key, canvas, context);
        } else if (key.codes[0] == -16) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhite(key, canvas, paint, context);
        } else {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
        }
    }

    public static void setBackGroundSelectTwoDot(Key key, Canvas canvas, Paint paint, Context context) {
        if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                || key.codes[0] == -18 || key.codes[0] == -19) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhite(key, canvas, paint, context);
        } else if (key.codes[0] == 97) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwo(key, canvas, paint, context);
        } else if (key.codes[0] == -1) {
            setColorButtonOrange(key, canvas, context);
            drawIconDropRight(key, canvas, context);
        } else if (key.codes[0] == -3) {
            setColorButtonGreen(key, canvas, context);
            drawIconDropLeft(key, canvas, context);
        } else if (key.codes[0] == -2) {
            setColorButtonYellow(key, canvas, context);
            setColorTextWhiteLatin(key, canvas, paint, context);
        } else if (key.codes[0] == -5) {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
            drawIconDelete(key, canvas, context);
        } else if (key.codes[0] == 1050) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhiteIcon(key, canvas, paint, context);
        } else {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
        }
    }

    public static void setBackGroundTwoQwerty(Key key, Canvas canvas, Paint paint, Context context) {
        if (key.codes[0] == 2000) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhiteIcon(key, canvas, paint, context);
        } else if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                || key.codes[0] == -20 || key.codes[0] == -21) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhite(key, canvas, paint, context);
        } else if (key.codes[0] == 97) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwo(key, canvas, paint, context);
        } else if (key.codes[0] == -1) {
            setColorButtonOrange(key, canvas, context);
            drawIconDropRight(key, canvas, context);
        } else if (key.codes[0] == -3) {
            setColorButtonGreen(key, canvas, context);
            drawIconDropLeft(key, canvas, context);
        } else if (key.codes[0] == -2) {
            setColorButtonYellow(key, canvas, context);
            setColorTextWhiteLatin(key, canvas, paint, context);
        } else if (key.codes[0] == -5) {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
            drawIconDelete(key, canvas, context);
        } else {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
        }
    }

    public static void setBackGroundTwoSelectOneDot(Key key, Canvas canvas, Paint paint, Context context) {
        if (key.codes[0] == 2050) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhiteIcon(key, canvas, paint, context);
        } else if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                || key.codes[0] == -26) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhite(key, canvas, paint, context);
        } else if (key.codes[0] == -25) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwoDot(key, canvas, paint, context);
        } else if (key.codes[0] == 97) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwo(key, canvas, paint, context);
        } else if (key.codes[0] == -1) {
            setColorButtonOrange(key, canvas, context);
            drawIconDropRight(key, canvas, context);
        } else if (key.codes[0] == -3) {
            setColorButtonGreen(key, canvas, context);
            drawIconDropLeft(key, canvas, context);
        } else if (key.codes[0] == -2) {
            setColorButtonYellow(key, canvas, context);
            setColorTextWhiteLatin(key, canvas, paint, context);
        } else if (key.codes[0] == -5) {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
            drawIconDelete(key, canvas, context);
        } else {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
        }
    }

    public static void setBackGroundThreeQwerty(Key key, Canvas canvas, Paint paint, Context context) {
        if (key.codes[0] == 3000) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhiteIcon(key, canvas, paint, context);
        } else if (key.codes[0] == 97) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwo(key, canvas, paint, context);
        } else if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                || key.codes[0] == -30 || key.codes[0] == -31) {
            setColorButtonOrange(key, canvas, context);
            setColorTextWhite(key, canvas, paint, context);
        } else if (key.codes[0] == -1) {
            setColorButtonOrange(key, canvas, context);
            drawIconDropRight(key, canvas, context);
        } else if (key.codes[0] == -3) {
            setColorButtonGreen(key, canvas, context);
            drawIconDropLeft(key, canvas, context);
        } else if (key.codes[0] == -2) {
            setColorButtonYellow(key, canvas, context);
            setColorTextWhiteLatin(key, canvas, paint, context);
        } else if (key.codes[0] == -5) {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
            drawIconDelete(key, canvas, context);
        } else {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
        }
    }

    public static void setBackGroundThreeSelectOneDot(Key key, Canvas canvas, Paint paint, Context context) {
        if (key.codes[0] == 3050) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhiteIcon(key, canvas, paint, context);
        } else if (key.codes[0] == 97) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwo(key, canvas, paint, context);
        } else if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                || key.codes[0] == -36) {
            setColorButtonOrange(key, canvas, context);
            setColorTextWhite(key, canvas, paint, context);
        } else if (key.codes[0] == -1) {
            setColorButtonOrange(key, canvas, context);
            drawIconDropRight(key, canvas, context);
        } else if (key.codes[0] == -35) {
            setColorButtonOrange(key, canvas, context);
            drawIconDropRightFinal(key, canvas, context);
        } else if (key.codes[0] == -3) {
            setColorButtonGreen(key, canvas, context);
            drawIconDropLeft(key, canvas, context);
        } else if (key.codes[0] == -2) {
            setColorButtonYellow(key, canvas, context);
            setColorTextWhiteLatin(key, canvas, paint, context);
        } else if (key.codes[0] == -5) {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
            drawIconDelete(key, canvas, context);
        } else {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
        }
    }

    public static void setBackGroundFourQwerty(Key key, Canvas canvas, Paint paint, Context context) {
        if (key.codes[0] == 4000) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhiteIcon(key, canvas, paint, context);
        } else if (key.codes[0] == 97) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwo(key, canvas, paint, context);
        } else if (key.codes[0] == -1) {
            setColorButtonOrange(key, canvas, context);
            drawIconDropRight(key, canvas, context);
        } else if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                || key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110
                || key.codes[0] == -40 || key.codes[0] == -41) {
            setColorButtonGreen(key, canvas, context);
            setColorTextWhite(key, canvas, paint, context);
        } else if (key.codes[0] == -2) {
            setColorButtonYellow(key, canvas, context);
            setColorTextWhiteLatin(key, canvas, paint, context);
        } else if (key.codes[0] == -3) {
            setColorButtonGreen(key, canvas, context);
            drawIconDropLeft(key, canvas, context);
        } else if (key.codes[0] == -5) {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
            drawIconDelete(key, canvas, context);
        } else {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
        }
    }

    public static void setBackGroundFourSelectOneDot(Key key, Canvas canvas, Paint paint, Context context) {
        if (key.codes[0] == 4050) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhiteIcon(key, canvas, paint, context);
        } else if (key.codes[0] == 97) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwo(key, canvas, paint, context);
        } else if (key.codes[0] == -1) {
            setColorButtonOrange(key, canvas, context);
            drawIconDropRight(key, canvas, context);
        } else if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                || key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110
                || key.codes[0] == -46) {
            setColorButtonGreen(key, canvas, context);
            setColorTextWhite(key, canvas, paint, context);
        } else if (key.codes[0] == -3) {
            setColorButtonGreen(key, canvas, context);
            setColorTextWhite(key, canvas, paint, context);
            drawIconDropLeft(key, canvas, context);
        } else if (key.codes[0] == -2) {
            setColorButtonYellow(key, canvas, context);
            setColorTextWhiteLatin(key, canvas, paint, context);
        } else if (key.codes[0] == -5) {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
            drawIconDelete(key, canvas, context);
        } else if (key.codes[0] == -45) {
            setColorButtonGreen(key, canvas, context);
            setColorTextWhite(key, canvas, paint, context);
            drawIconDropLeftFinal(key, canvas, context);
        } else {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
        }
    }

    public static void setBackGroundQwertyNumber(Key key, Canvas canvas, Paint paint, Context context) {
        if (key.codes[0] == 5000) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhiteIcon(key, canvas, paint, context);
        } else if (key.codes[0] == 97) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwo(key, canvas, paint, context);
        } else if (key.codes[0] == -1) {
            setColorButtonOrange(key, canvas, context);
            drawIconDropRight(key, canvas, context);
        } else if (key.codes[0] == -3) {
            setColorButtonGreen(key, canvas, context);
            drawIconDropLeft(key, canvas, context);
        } else if (key.codes[0] == -2 || key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == -50 || key.codes[0] == -51) {
            setColorButtonYellow(key, canvas, context);
            setColorTextWhiteLatin(key, canvas, paint, context);
        } else if (key.codes[0] == -5) {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
            drawIconDelete(key, canvas, context);
        } else if (key.codes[0] == 106) {
            setColorButtonYellow(key, canvas, context);
            drawIconBack(key, canvas, context);
        } else if (key.codes[0] == 107) {
            setColorButtonYellow(key, canvas, context);
            drawIconNext(key, canvas, context);
        } else {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
        }
    }

    public static void setBackGroundQwertyNumberTwo(Key key, Canvas canvas, Paint paint, Context context) {
        if (key.codes[0] == 5020) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhiteIcon(key, canvas, paint, context);
        } else if (key.codes[0] == 97) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwo(key, canvas, paint, context);
        } else if (key.codes[0] == -1) {
            setColorButtonOrange(key, canvas, context);
            drawIconDropRight(key, canvas, context);
        } else if (key.codes[0] == -3) {
            setColorButtonGreen(key, canvas, context);
            drawIconDropLeft(key, canvas, context);
        } else if (key.codes[0] == -2 || key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                || key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 || key.codes[0] == 118
                || key.codes[0] == 98 || key.codes[0] == 110 || key.codes[0] == -52 || key.codes[0] == -53) {
            setColorButtonYellow(key, canvas, context);
            setColorTextWhiteLatin(key, canvas, paint, context);
        } else if (key.codes[0] == -5) {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
            drawIconDelete(key, canvas, context);
        } else {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
        }
    }

    public static void setBackGroundQwertyNumberThree(Key key, Canvas canvas, Paint paint, Context context) {
        if (key.codes[0] == 5030) {
            setColorButtonBlack(key, canvas, context);
            setColorTextWhiteIcon(key, canvas, paint, context);
        } else if (key.codes[0] == 97) {
            setColorButtonBlue(key, canvas, context);
            setColorTextWhiteIconTwo(key, canvas, paint, context);
        } else if (key.codes[0] == -1) {
            setColorButtonOrange(key, canvas, context);
            drawIconDropRight(key, canvas, context);
        } else if (key.codes[0] == -3) {
            setColorButtonGreen(key, canvas, context);
            drawIconDropLeft(key, canvas, context);
        } else if (key.codes[0] == -2 || key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                || key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 || key.codes[0] == 118
                || key.codes[0] == 98 || key.codes[0] == 110 || key.codes[0] == -54 || key.codes[0] == -55) {
            setColorButtonYellow(key, canvas, context);
            setColorTextWhiteLatin(key, canvas, paint, context);
        } else if (key.codes[0] == -5) {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
            drawIconDelete(key, canvas, context);
        } else {
            setColorButtonWhite(key, canvas, context);
            setColorTextBlack(key, canvas, paint, context);
        }
    }


    private static void setColorButtonWhite(Key key, Canvas canvas, Context context) {
        Drawable dr = (Drawable) context.getResources().getDrawable(R.drawable.custom_back_ground_white);
        dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
        dr.draw(canvas);
    }

    private static void setColorButtonOrange(Keyboard.Key key, Canvas canvas, Context context) {
        Drawable dr = (Drawable) context.getResources().getDrawable(R.drawable.custom_back_ground_orange);
        dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
        dr.draw(canvas);
    }

    private static void setColorButtonBlue(Keyboard.Key key, Canvas canvas, Context context) {
        Drawable dr = (Drawable) context.getResources().getDrawable(R.drawable.custom_back_ground_blue);
        dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
        dr.draw(canvas);
    }

    private static void setColorButtonBlack(Keyboard.Key key, Canvas canvas, Context context) {
        Drawable dr = (Drawable) context.getResources().getDrawable(R.drawable.custom_back_ground_black);
        dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
        dr.draw(canvas);
    }

    private static void setColorButtonGreen(Keyboard.Key key, Canvas canvas, Context context) {
        Drawable dr = (Drawable) context.getResources().getDrawable(R.drawable.custom_back_ground_green);
        dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
        dr.draw(canvas);
    }

    private static void setColorButtonYellow(Keyboard.Key key, Canvas canvas, Context context) {
        Drawable dr = (Drawable) context.getResources().getDrawable(R.drawable.custom_back_ground_yellow);
        dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
        dr.draw(canvas);
    }

    public static void setColorButtonSelectedKeyboard(Keyboard.Key key, Canvas canvas, Context context) {
        Drawable dr = (Drawable) context.getResources().getDrawable(R.drawable.custom_back_ground_selected);
        dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
        dr.draw(canvas);
    }



    private static void setColorTextWhite(Keyboard.Key key, Canvas canvas, Paint paint, Context context) {
        if (BaseConfig.readNameDevice(context).equals("tablet")) {
            int textSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_keyboard_tablet);
            int textHeight = context.getResources().getDimensionPixelSize(R.dimen.text_height_keyboard);
            Typeface face = ResourcesCompat.getFont(context, R.font.llisarniq_demi);
            paint.setTypeface(face);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(textSize);
            paint.setColor(Color.WHITE);
            if (key.label != null) {
                canvas.drawText(key.label.toString(), key.x + (key.width / 2), (float) ((key.y + (key.height / 2)) + textHeight), paint);
            }
        } else {
            int textSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_keyboard);
            int textHeight = context.getResources().getDimensionPixelSize(R.dimen.text_height_keyboard);
            Typeface face = ResourcesCompat.getFont(context, R.font.llisarniq_demi);
            paint.setTypeface(face);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(textSize);
            paint.setColor(Color.WHITE);
            if (key.label != null) {
                canvas.drawText(key.label.toString(), key.x + (key.width / 2), (float) ((key.y + (key.height / 2)) + textHeight), paint);
            }
        }

    }


    private static void setColorTextWhiteLatin(Keyboard.Key key, Canvas canvas, Paint paint, Context context) {
        if (BaseConfig.readNameDevice(context).equals("tablet")) {
            int textSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_keyboard_tablet);
            int textHeight = context.getResources().getDimensionPixelSize(R.dimen.text_height_keyboard_latin);
            Typeface face = ResourcesCompat.getFont(context, R.font.llisarniq_demi);
            paint.setTypeface(face);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(textSize);
            paint.setColor(Color.WHITE);
            if (key.label != null) {
                canvas.drawText(key.label.toString(), key.x + (key.width / 2), (float) ((key.y + (key.height / 2)) + textHeight), paint);
            }
        } else {
            int textSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_keyboard);
            int textHeight = context.getResources().getDimensionPixelSize(R.dimen.text_height_keyboard_latin);
            Typeface face = ResourcesCompat.getFont(context, R.font.llisarniq_demi);
            paint.setTypeface(face);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(textSize);
            paint.setColor(Color.WHITE);
            if (key.label != null) {
                canvas.drawText(key.label.toString(), key.x + (key.width / 2), (float) ((key.y + (key.height / 2)) + textHeight), paint);
            }
        }


    }

    private static void setColorTextWhiteIcon(Keyboard.Key key, Canvas canvas, Paint paint, Context context) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            int textSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_keyboard_down_up);
            Typeface face = ResourcesCompat.getFont(context, R.font.llisarniq_demi);
                paint.setTypeface(face);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(textSize);
                paint.setColor(Color.WHITE);
                if (key.label != null) {
                    canvas.drawText(key.label.toString(), (key.x + (key.width )/2), (float) ((key.y + (key.height / 2)) *1.3), paint);
                }
        }else {
            int textSizeIconKeyBoard = context.getResources().getDimensionPixelSize(R.dimen.text_size_icon_keyboard_ipad);
            Typeface face = ResourcesCompat.getFont(context, R.font.llisarniq_demi);
            paint.setTypeface(face);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(textSizeIconKeyBoard);
            paint.setColor(Color.WHITE);
            if (key.label != null) {
                canvas.drawText(key.label.toString(), (key.x + (key.width / 2)), (float) ((key.y + (key.height / 2)) + 20), paint);
            }
        }

    }

    private static void setColorTextWhiteIconTwo(Keyboard.Key key, Canvas canvas, Paint paint, Context context) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            int textSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_keyboard_down_up);
//            double relation = Math.sqrt(canvas.getWidth() * canvas.getHeight());
//            relation = relation / 250;
            Typeface face = ResourcesCompat.getFont(context, R.font.llisarniq_demi);
            paint.setTypeface(face);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(textSize);
            paint.setColor(Color.WHITE);
            if (key.label != null) {
                canvas.drawText(key.label.toString(), (key.x + (key.width / 2)), (float) ((key.y + (key.height / 2)) + 20), paint);
            }
        }else {
            int textSizeIconKeyBoard = context.getResources().getDimensionPixelSize(R.dimen.text_size_icon_keyboard_ipad);
            Typeface face = ResourcesCompat.getFont(context, R.font.llisarniq_demi);
            paint.setTypeface(face);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(textSizeIconKeyBoard);
            paint.setColor(Color.WHITE);
            if (key.label != null) {
                canvas.drawText(key.label.toString(), (key.x + (key.width / 2)), (float) ((key.y + (key.height / 2)) + 20), paint);
            }
        }

    }

    private static void setColorTextWhiteIconTwoDot(Keyboard.Key key, Canvas canvas, Paint paint, Context context) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            int textSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_keyboard_down_up);
//            double relation = Math.sqrt(canvas.getWidth() * canvas.getHeight());
//            relation = relation / 250;
            Typeface face = ResourcesCompat.getFont(context, R.font.llisarniq_demi);
            paint.setTypeface(face);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(textSize);
            paint.setColor(Color.WHITE);
            if (key.label != null) {
                canvas.drawText(key.label.toString(), (key.x + (key.width / 2)), (float) ((key.y + (key.height / 2)) * 1.3), paint);
            }
        }else {
            int textSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_icon_keyboard_ipad);
            Typeface face = ResourcesCompat.getFont(context, R.font.llisarniq_demi);
            paint.setTypeface(face);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(textSize);
            paint.setColor(Color.WHITE);
            if (key.label != null) {
                canvas.drawText(key.label.toString(), (key.x + (key.width / 2)), (float) ((key.y + (key.height / 2)) * 1.3), paint);
            }
        }

    }

    private static void setColorTextBlack(Keyboard.Key key, Canvas canvas, Paint paint, Context context) {
        if (BaseConfig.readNameDevice(context).equals("tablet")) {
            int textSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_keyboard_tablet);
            int textHeight = context.getResources().getDimensionPixelSize(R.dimen.text_height_keyboard_latin);
            Typeface face = ResourcesCompat.getFont(context, R.font.llisarniq_demi);
            paint.setTypeface(face);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(textSize);
            paint.setColor(context.getResources().getColor(R.color.text_color_special));
            if (key.label != null) {
                canvas.drawText(key.label.toString(), key.x + (key.width / 2), (float) ((key.y + (key.height / 2)) + textHeight), paint);
            }
        } else {
            int textSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_keyboard);
            int textHeight = context.getResources().getDimensionPixelSize(R.dimen.text_height_keyboard_latin);
            Typeface face = ResourcesCompat.getFont(context, R.font.llisarniq_demi);
            paint.setTypeface(face);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(textSize);
            paint.setColor(context.getResources().getColor(R.color.text_color_special));
            if (key.label != null) {
                canvas.drawText(key.label.toString(), key.x + (key.width / 2), (float) ((key.y + (key.height / 2)) + textHeight), paint);
            }
        }

    }

    private static void drawIconDelete(Keyboard.Key key, Canvas canvas, Context context) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                int textLeft = (int) context.getResources().getDimensionPixelSize(R.dimen.icon_delete_left);
                int textTop = (int) context.getResources().getDimensionPixelSize(R.dimen.icon_delete_top);
                int textRight = (int) context.getResources().getDimensionPixelSize(R.dimen.icon_delete_right);
                int textBottom = (int) context.getResources().getDimensionPixelSize(R.dimen.icon_delete_bottom);
                int left = ((key.x) + textLeft);
                int top = (key.y + textTop);
                int right = (key.x + textRight);
                int bottom = (key.y + textBottom);
                key.icon.setColorFilter(context.getResources().getColor(R.color.text_color_special), PorterDuff.Mode.SRC_ATOP);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            } else {
                int textLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_delete_left_horizontal);
                int textTop = context.getResources().getDimensionPixelSize(R.dimen.icon_delete_top_horizontal);
                int textRight = context.getResources().getDimensionPixelSize(R.dimen.icon_delete_right_horizontal);
                int textBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_delete_bottom_horizontal);
                float left = (float) (key.x + textLeft);
                float top = (float) (key.y + textTop);
                float right = (float) (key.x + textRight);
                float bottom = (float) (key.y + textBottom);
                key.icon.setColorFilter(context.getResources().getColor(R.color.text_color_special), PorterDuff.Mode.SRC_ATOP);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            }
        } else {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                int textLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_delete_ipad_left_vertical);
                int textTop = context.getResources().getDimensionPixelSize(R.dimen.icon_delete_ipad_top_vertical);
                int textRight = context.getResources().getDimensionPixelSize(R.dimen.icon_delete_ipad_right_vertical);
                int textBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_delete_ipad_bottom_vertical);
                float left = (float) (key.x + textLeft);
                float top = (float) (key.y + textTop);
                float right = (float) (key.x + textRight);
                float bottom = (float) (key.y + textBottom);
                key.icon.setColorFilter(context.getResources().getColor(R.color.text_color_special), PorterDuff.Mode.SRC_ATOP);

                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            } else {
                int textLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_delete_ipad_left_horizontal);
                int textTop = context.getResources().getDimensionPixelSize(R.dimen.icon_delete_ipad_top_horizontal);
                int textRight = context.getResources().getDimensionPixelSize(R.dimen.icon_delete_ipad_right_horizontal);
                int textBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_delete_ipad_bottom_horizontal);
                float left = (float) (key.x + textLeft);
                float top = (float) (key.y + textTop);
                float right = (float) (key.x + textRight);
                float bottom = (float) (key.y + textBottom);
                key.icon.setColorFilter(context.getResources().getColor(R.color.text_color_special), PorterDuff.Mode.SRC_ATOP);

                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            }
        }

    }

    private static void drawIconDropRight(Keyboard.Key key, Canvas canvas, Context context) {

        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_left_vertical);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_top_vertical);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_right_vertical);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_bottom_vertical);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
//                key.icon.setBounds(0, 0, , (int) bottom);
                key.icon.draw(canvas);
            } else {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_right_left_vertical);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_right_top_vertical);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_right_right_vertical);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_right_bottom_vertical);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            }
        } else {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_left_vertical);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_top_vertical);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_right_vertical);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_bottom_vertical);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            } else {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_left_horizontal);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_top_horizontal);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_right_horizontal);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_bottom_horizontal);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            }

        }

    }

    private static void drawIconDropRightFinal(Keyboard.Key key, Canvas canvas, Context context) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_right_final_left_vertical);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_right_final_top_vertical);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_right_final_right_vertical);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_right_final_bottom_vertical);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            } else {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_right_final_left_horizontal);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_right_final_top_horizontal);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_right_final_right_horizontal);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_right_final_bottom_horizontal);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            }
        } else {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_final_left_vertical);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_final_top_vertical);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_final_right_vertical);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_final_bottom_vertical);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            } else {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_final_left_horizontal);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_final_top_horizontal);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_final_right_horizontal);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_right_final_bottom_horizontal);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            }
        }
    }

    private static void drawIconDropLeft(Keyboard.Key key, Canvas canvas, Context context) {
        Drawable dr = context.getResources().getDrawable(R.drawable.left_triangle);
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_left_vertical);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_top_vertical);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_right_vertical);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_bottom_vertical);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                dr.setBounds((int) left, (int) top, (int) right, (int) bottom);
//                dr.setBounds(0, 0, dr.getIntrinsicWidth(),dr.getIntrinsicWidth());
                dr.draw(canvas);
            } else {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_left_horizontal);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_top_horizontal);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_right_horizontal);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_bottom_horizontal);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                dr.setBounds((int) left, (int) top, (int) right, (int) bottom);
                dr.draw(canvas);
            }
        } else {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_left_vertical);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_top_vertical);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_right_vertical);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_bottom_vertical);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                dr.setBounds((int) left, (int) top, (int) right, (int) bottom);
                dr.draw(canvas);
            } else {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_left_horizontal);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_top_horizontal);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_right_horizontal);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_bottom_horizontal);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                dr.setBounds((int) left, (int) top, (int) right, (int) bottom);
                dr.draw(canvas);
            }
        }
    }

    private static void drawIconDropLeftFinal(Keyboard.Key key, Canvas canvas, Context context) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_final_left_vertical);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_final_top_vertical);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_final_right_vertical);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_final_bottom_vertical);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            } else {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_final_left_horizontal);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_final_top_horizontal);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_final_right_horizontal);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_mobile_left_final_bottom_horizontal);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            }
        } else {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_final_left_vertical);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_final_top_vertical);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_final_right_vertical);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_final_bottom_vertical);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            } else {
                int iconLeft = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_final_left_horizontal);
                int iconTop = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_final_top_horizontal);
                int iconRight = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_final_right_horizontal);
                int iconBottom = context.getResources().getDimensionPixelSize(R.dimen.icon_drop_ipad_left_final_bottom_horizontal);
                float left = (float) (key.x + iconLeft);
                float top = (float) (key.y + iconTop);
                float right = (float) (key.x + key.width) - iconRight;
                float bottom = (float) (key.y + (key.height / 2) + iconBottom);
                key.icon.setBounds((int) left, (int) top, (int) right, (int) bottom);
                key.icon.draw(canvas);
            }
        }
    }

    private static void drawIconBack(Keyboard.Key key, Canvas canvas, Context context) {
        Drawable dr = (Drawable) context.getResources().getDrawable(R.drawable.ic_left);
        float left = (float) (key.x * (1.0138888889));
        float top = (float) (key.y * (1.2189781022));
        float right = (float) ((key.x + key.width) * (0.9880952381));
        float bottom = (float) ((key.y + (key.height / 2)) * (1.1951219512));
//        float left = (float) (key.x) + 10;
//        float top = (float) (key.y) + 30;
//        float right = (float) (key.x + key.width) - 10;
//        float bottom = (float) (key.y + (key.height / 2) + 40);
        dr.setBounds((int) left, (int) top, (int) right, (int) bottom);
        dr.draw(canvas);
    }

    private static void drawIconNext(Keyboard.Key key, Canvas canvas, Context context) {
        Drawable dr = (Drawable) context.getResources().getDrawable(R.drawable.ic_right);
        float left = (float) (key.x * (1.0119047619));
        float top = (float) (key.y * (1.2189781022));
        float right = (float) ((key.x + key.width) * (0.9895833333));
        float bottom = (float) ((key.y + (key.height / 2)) * (1.1951219512));
//        float left = (float) (key.x) + 10;
//        float top = (float) (key.y) + 30;
//        float right = (float) (key.x + key.width) - 10;
//        float bottom = (float) (key.y + (key.height / 2) + 40);
        dr.setBounds((int) left, (int) top, (int) right, (int) bottom);
        dr.draw(canvas);
    }

    public static void showPopupLongClick(PopupWindow popupWindow, Context context, Key key, TextView tvOne, TextView tvTwo) {
        // keyboard 2 blue
        if (key.text.equals("ᕂ")) {
            tvOne.setBackgroundResource(R.drawable.background_selected_text);
            tvTwo.setBackgroundResource(R.drawable.background_popup_black_text_long_press);
            tvOne.setText("ᕂ");
            tvTwo.setText("ᕃ");
            setBackGroundLongPressPopupWindowBlack(popupWindow, context);
        } else if (key.text.equals("ᐃ") || key.text.equals("ᐄ")) {
            if (key.text.equals("ᐃ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᐃ");
            tvTwo.setText("ᐄ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        } else if (key.text.equals("ᐱ") || key.text.equals("ᐲ")) {
            if (key.text.equals("ᐱ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᐱ");
            tvTwo.setText("ᐲ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        }else if (key.text.equals("ᑎ") || key.text.equals("ᑏ")) {
            if (key.text.equals("ᑎ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᑎ");
            tvTwo.setText("ᑏ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        } else if (key.text.equals("ᑭ") || key.text.equals("ᑮ")) {
            if (key.text.equals("ᑭ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᑭ");
            tvTwo.setText("ᑮ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        } else if (key.text.equals("ᒋ") || key.text.equals("ᒌ")) {
            if (key.text.equals("ᒋ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᒋ");
            tvTwo.setText("ᒌ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        } else if (key.text.equals("ᒥ") || key.text.equals("ᒦ")) {
            if (key.text.equals("ᒥ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᒥ");
            tvTwo.setText("ᒦ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        } else if (key.text.equals("ᓂ") || key.text.equals("ᓃ")) {
            if (key.text.equals("ᓂ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᓂ");
            tvTwo.setText("ᓃ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        } else if (key.text.equals("ᓯ") || key.text.equals("ᓰ")) {
            if (key.text.equals("ᓯ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᓯ");
            tvTwo.setText("ᓰ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        } else if (key.text.equals("ᓕ") || key.text.equals("ᓖ")) {
            if (key.text.equals("ᓕ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᓕ");
            tvTwo.setText("ᒌ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        } else if (key.text.equals("ᔨ") || key.text.equals("ᔩ")) {
            if (key.text.equals("ᔨ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᔨ");
            tvTwo.setText("ᔩ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        } else if (key.text.equals("ᕕ") || key.text.equals("ᕖ")) {
            if (key.text.equals("ᕕ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᕕ");
            tvTwo.setText("ᕖ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        } else if (key.text.equals("ᕆ") || key.text.equals("ᕇ")) {
            if (key.text.equals("ᕆ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᕆ");
            tvTwo.setText("ᕇ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        } else if (key.text.equals("ᕿ") || key.text.equals("ᖀ")) {
            if (key.text.equals("ᕿ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᕿ");
            tvTwo.setText("ᖀ");
            setBackGroundPopupWindowBlue(popupWindow, context);
        } else if (key.text.equals("ᖏ")|| key.text.equals("ᖐ")) {
            if (key.text.equals("ᖏ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᖏ");
            tvTwo.setText("ᖐ");
            setBackGroundPopupWindowBlue(popupWindow, context);
            //key board 3 orange
        } else if (key.text.equals("ᐅ") || key.text.equals("ᐆ")) {
            if (key.text.equals("ᐅ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            }
            tvOne.setText("ᐅ");
            tvTwo.setText("ᐆ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᐳ") || key.text.equals("ᐴ")) {
            if (key.text.equals("ᐳ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᐳ");
            tvTwo.setText("ᐴ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᑐ") || key.text.equals("ᑑ")) {
            if (key.text.equals("ᑐ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᑐ");
            tvTwo.setText("ᑑ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᑯ") || key.text.equals("ᑰ")) {
            if (key.text.equals("ᑯ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᑯ");
            tvTwo.setText("ᑰ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᒍ") || key.text.equals("ᒎ")) {
            if (key.text.equals("ᒍ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᒍ");
            tvTwo.setText("ᒎ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᒧ") || key.text.equals("ᒨ")) {
            if (key.text.equals("ᒧ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᒧ");
            tvTwo.setText("ᒨ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᓄ") || key.text.equals("ᓅ")) {
            if (key.text.equals("ᓄ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᓄ");
            tvTwo.setText("ᓅ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᓱ") || key.text.equals("ᓲ")) {
            if (key.text.equals("ᓱ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᓱ");
            tvTwo.setText("ᓲ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᓗ") || key.text.equals("ᓘ")) {
            if (key.text.equals("ᓗ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᓗ");
            tvTwo.setText("ᓘ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᔪ") || key.text.equals("ᔫ")) {
            if (key.text.equals("ᔪ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᔪ");
            tvTwo.setText("ᔫ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᕗ") || key.text.equals("ᕘ")) {
            if (key.text.equals("ᕗ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᕗ");
            tvTwo.setText("ᕘ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᕈ") || key.text.equals("ᕉ")) {
            if (key.text.equals("ᕈ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᕈ");
            tvTwo.setText("ᕉ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᖁ") || key.text.equals("ᖂ")) {
            if (key.text.equals("ᖁ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᖁ");
            tvTwo.setText("ᖂ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        } else if (key.text.equals("ᖑ") || key.text.equals("ᖒ")) {
            if (key.text.equals("ᖑ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᖑ");
            tvTwo.setText("ᖒ");
            setBackGroundPopupWindowOrange(popupWindow, context);
        }
        // key board 4 green
        else if (key.text.equals("ᐊ") || key.text.equals("ᐋ")) {
            if (key.text.equals("ᐊ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᐊ");
            tvTwo.setText("ᐋ");
            setBackGroundPopupWindowGreen(popupWindow, context);

        } else if (key.text.equals("ᑕ") || key.text.equals("ᑖ")) {
            if (key.text.equals("ᑕ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᑕ");
            tvTwo.setText("ᑖ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᐸ") || key.text.equals("ᐹ")) {
            if (key.text.equals("ᐸ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᐸ");
            tvTwo.setText("ᐹ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᑲ") || key.text.equals("ᑳ")) {
            if (key.text.equals("ᑲ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᑲ");
            tvTwo.setText("ᑳ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᒐ") || key.text.equals("ᒑ")) {
            if (key.text.equals("ᒐ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᒐ");
            tvTwo.setText("ᒑ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᒪ") || key.text.equals("ᒫ")) {
            if (key.text.equals("ᒪ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᒪ");
            tvTwo.setText("ᒫ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᓇ") || key.text.equals("ᓈ")) {
            if (key.text.equals("ᓇ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᓇ");
            tvTwo.setText("ᓈ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᓴ") || key.text.equals("ᓵ")) {
            if (key.text.equals("ᓴ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᓴ");
            tvTwo.setText("ᓵ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᓚ") || key.text.equals("ᓛ")) {
            if (key.text.equals("ᓚ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᓚ");
            tvTwo.setText("ᓛ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᔭ") || key.text.equals("ᔮ")) {
            if (key.text.equals("ᔭ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᔭ");
            tvTwo.setText("ᔮ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᕙ") || key.text.equals("ᕚ")) {
            if (key.text.equals("ᕙ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᕙ");
            tvTwo.setText("ᕚ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᕋ") || key.text.equals("ᕌ")) {
            if (key.text.equals("ᕋ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᕋ");
            tvTwo.setText("ᕌ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᖃ") || key.text.equals("ᖄ")) {
            if (key.text.equals("ᖃ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᖃ");
            tvTwo.setText("ᖄ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᖓ") || key.text.equals("ᖔ")) {
            if (key.text.equals("ᖓ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᖓ");
            tvTwo.setText("ᖔ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᖠ") || key.text.equals("ᖡ")) {
            if (key.text.equals("ᖠ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᖠ");
            tvTwo.setText("ᖡ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᖢ") || key.text.equals("ᖣ")) {
            if (key.text.equals("ᖢ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᖢ");
            tvTwo.setText("ᖣ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        } else if (key.text.equals("ᖤ") || key.text.equals("ᖥ")) {
            if (key.text.equals("ᖤ")) {
                tvOne.setBackgroundResource(R.drawable.background_selected_text);
                tvTwo.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
            } else {
                tvOne.setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                tvTwo.setBackgroundResource(R.drawable.background_selected_text);
            }
            tvOne.setText("ᖤ");
            tvTwo.setText("ᖥ");
            setBackGroundPopupWindowGreen(popupWindow, context);
        }
        // keyboard 5 yellow
//        else if (key.text.equals("0") || key.text.equals("1") || key.text.equals("2") || key.text.equals("3")
//                || key.text.equals("4") || key.text.equals("5") || key.text.equals("6") || key.text.equals("7")
//                || key.text.equals("8") || key.text.equals("9") || key.text.equals("+") || key.text.equals("-")
//                || key.text.equals("*") || key.text.equals("/") || key.text.equals("=") || key.text.equals("%")
//                || key.text.equals("|") || key.text.equals("≠") || key.text.equals("≈") || key.text.equals("≤")
//                || key.text.equals("≥") || key.text.equals("<") || key.text.equals(">") || key.text.equals("°")
//                || key.text.equals("_") || key.text.equals("^") || key.text.equals("\\") || key.text.equals("√")
//                || key.text.equals("π") || key.text.equals("@") || key.text.equals("[") || key.text.equals("]")
//                || key.text.equals("(") || key.text.equals(")") || key.text.equals("«") || key.text.equals("»")
//                || key.text.equals("&") || key.text.equals("{") || key.text.equals("}") || key.text.equals("#")
//                || key.text.equals("cm") || key.text.equals("km") || key.text.equals("'") || key.text.equals("\"")
//                || key.text.equals("m") || key.text.equals("g") || key.text.equals("x") || key.text.equals("y")
//                || key.text.equals("z") || key.text.equals("•") || key.text.equals("$") || key.text.equals("¢")) {
//        }


    }


    public static void setBackGroundPopupWindowBlue(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_blue));
    }

    public static void setBackGroundPopupClickWindowBlue(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_click_blue));
    }

    public static void setBackGroundPopupWindowBlack(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_black));
    }

    public static void setBackGroundLongPressPopupWindowBlack(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_black_long_press));
    }

    public static void setBackGroundPopupClickWindowBlack(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_click_black));
    }

    public static void setBackGroundPopupWindowYellow(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_yellow));
    }

    public static void setBackGroundPopupClickWindowYellow(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_click_yellow));
    }

    public static void setBackGroundPopupWindowGreen(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_green));
    }

    public static void setBackGroundPopupClickWindowGreen(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_click_green));
    }

    public static void setBackGroundPopupWindowOrange(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_orange));
    }

    public static void setBackGroundPopupClickWindowOrange(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_click_orange));
    }

    public static void setBackGroundPopupWindowWhite(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_white));
    }

    public static void setBackGroundPopupClickWindowWhite(PopupWindow popupWindow, Context context) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background_popup_click_white));
    }

    public static void showPopupClickDefault(View mInputView, PopupWindow popupWindow, Context context, Key key, TextView tvClick) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowBlack(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));
                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));
                }
            } else {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowBlack(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));
                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));
                }
            }
        }
    }

    public static void showPopupClickEmoji(View mInputView, PopupWindow popupWindow, Context context, Key key, TextView tvClick) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                if (key.codes[0] != 1000 && key.codes[0] != 97 && key.codes[0] != -1
                        && key.codes[0] != -5 && key.codes[0] != -3 && key.codes[0] != -2 && key.codes[0] != 32
                        && key.codes[0] != 10 && key.codes[0] != -16 && key.codes[0] != -15) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));
                }
            } else {
                if (key.codes[0] != 1000 && key.codes[0] != 97 && key.codes[0] != -1
                        && key.codes[0] != -5 && key.codes[0] != -3 && key.codes[0] != -2 && key.codes[0] != 32
                        && key.codes[0] != 10 && key.codes[0] != -16 && key.codes[0] != -15) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));
                }
            }
        }

    }

    public static void showPopupClickTwoDot(View mInputView, PopupWindow popupWindow, Context context, Key key, TextView tvClick) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                        || key.codes[0] == -18 || key.codes[0] == -19) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowBlack(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));

                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));

                }
            } else {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                        || key.codes[0] == -18 || key.codes[0] == -19) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowBlack(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));

                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));

                }
            }
        }

    }

    public static void showPopupClickTwoQwerty(View mInputView, PopupWindow popupWindow, Context context, Key key, TextView tvClick) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowBlue(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));

                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));

                }
            } else {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowBlue(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));

                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));

                }
            }
        }

    }

    public static void showPopupClickTwoSelectOneDot(View mInputView, PopupWindow popupWindow, Context context, Key key, TextView tvClick) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowBlue(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));
                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    popupWindow.setWidth(160);
                    popupWindow.setWidth(160);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));
                }
            } else {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowBlue(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));
                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    popupWindow.setWidth(160);
                    popupWindow.setWidth(160);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));
                }
            }
        }

    }

    public static void showPopupClickThreeQwerty(View mInputView, PopupWindow popupWindow, Context context, Key key, TextView tvClick) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowOrange(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));
                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));

                }
            } else {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowOrange(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));
                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));

                }
            }
        }

    }

    public static void showPopupClickThreeSelectOneDot(View mInputView, PopupWindow popupWindow, Context context, Key key, TextView tvClick) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowOrange(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));

                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));

                }
            } else {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowOrange(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));

                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));

                }
            }
        }

    }

    public static void showPopupClickFourQwerty(View mInputView, PopupWindow popupWindow, Context context, Key key, TextView tvClick) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                        || key.codes[0] == -18 || key.codes[0] == -19 || key.codes[0] == 118 || key.codes[0] == 98
                        || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowGreen(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));

                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));
                }
            } else {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                        || key.codes[0] == -18 || key.codes[0] == -19 || key.codes[0] == 118 || key.codes[0] == 98
                        || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowGreen(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));

                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));
                }
            }
        }

    }

    public static void showPopupClickFourSelectOneDot(View mInputView, PopupWindow popupWindow, Context context, Key key, TextView tvClick) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                        || key.codes[0] == -18 || key.codes[0] == -19 || key.codes[0] == 118 || key.codes[0] == 98
                        || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowGreen(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));

                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));
                }
            } else {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107
                        || key.codes[0] == -18 || key.codes[0] == -19 || key.codes[0] == 118 || key.codes[0] == 98
                        || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowGreen(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));

                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));
                }
            }
        }


    }

    public static void showPopupClickQwertyNumber(View mInputView, PopupWindow popupWindow, Context context, Key key, TextView tvClick) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowYellow(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));

                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));

                }
            } else {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowYellow(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));

                } else if (key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.BLACK);
                    setBackGroundPopupClickWindowWhite(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));

                }
            }
        }

    }

    public static void showPopupClickQwertyNumberTwo(View mInputView, PopupWindow popupWindow, Context context, Key key, TextView tvClick) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107 ||
                        key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowYellow(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));
                }
            }else {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107 ||
                        key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowYellow(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));
                }
            }
        }

    }

    public static void showPopupClickQwertyNumberThree(View mInputView, PopupWindow popupWindow, Context context, Key key, TextView tvClick) {
        if (BaseConfig.readNameDevice(context).equals("mobile")) {
            if (BaseConfig.readHorizontalOrVertical(context).equals("PORTRAIT")) {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107 ||
                        key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowYellow(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) - x), (int) (key.y + (key.height / 2) * 0.1));
                }
            } else {
                if (key.codes[0] == 119 || key.codes[0] == 101 || key.codes[0] == 114
                        || key.codes[0] == 116 || key.codes[0] == 121 || key.codes[0] == 117 || key.codes[0] == 111
                        || key.codes[0] == 105 || key.codes[0] == 115 || key.codes[0] == 100 || key.codes[0] == 102
                        || key.codes[0] == 103 || key.codes[0] == 104 || key.codes[0] == 106 || key.codes[0] == 107 ||
                        key.codes[0] == 122 || key.codes[0] == 120 || key.codes[0] == 99 ||
                        key.codes[0] == 118 || key.codes[0] == 98 || key.codes[0] == 110) {
                    tvClick.setText(key.text);
                    tvClick.setTextColor(Color.WHITE);
                    setBackGroundPopupClickWindowYellow(popupWindow, context);
                    int width = context.getResources().getDimensionPixelSize(R.dimen.popup_click_width);
                    int x = context.getResources().getDimensionPixelSize(R.dimen.popup_x_horizontal);
                    popupWindow.setWidth(width);
                    popupWindow.setHeight(width);
                    popupWindow.showAtLocation(mInputView, Gravity.NO_GRAVITY, (int) ((key.x) + x), (int) (key.y + (key.height / 2) * 0.1));
                }
            }
        }

    }

    public static String[] list = {
            "ᐁᑉᐸᖓᓐᓂ", "ᐁᑉᐸ", "ᐁᑦᑑᑎ", "ᐁᑦᑕ", "ᐁᑦᑕᐅᑐ", "ᐁᑦᓯ", "ᐁᑦᓯᕋᐅᑎᒃ", "ᐁᑯᓗ", "ᐁᒎᖅ", "ᐁᓚᖓ",
            "ᐁᕆᓕ", "ᐯᐯ", "ᐯᓯᑰ", "ᐯᔪᖓ", "ᐯᕈᓐᓇᕿ", "ᐯᖕᖑᐳᖓ", "ᐯᖕᖑᐹ", "ᑌᑦᓱᒪ", "ᑌᑦᓱᒪᓂ", "ᑌᒃᑯᐊ",
            "ᑌᒣᒻᒪᑦ", "ᑌᒪᖕᖓ", "ᑌᒫ", "ᑌᒫᑦᓯᐊᖅ", "ᑌᒫᖑᖕᖏᑐᖅ", "ᑌᓐᓇ", "ᑌᓗᒍ", "ᑫᐱᒍᑎ", "ᑫᐱᖓᔪ", "ᑫᑦᑕᖅ",
            "ᑫᒥᑦᓯ", "ᑫᓪᓗᕿ", "ᑫᓪᓘᒥᑕ", "ᑫᓪᓚᑐᐃ", "ᑫᕙᓗᐊᖅ", "ᒣᑦᑐᖅ", "ᒣᓪᓕᐅ", "ᓀᐱᑕ", "ᓀᐱᑦᓯᑫᓐᓇ", "ᓀᑦᑐ",
            "ᓀᑫᓐᓇ", "ᓀᒪᔪ", "ᓓᕐᑐᖅ", "ᓓᕐᑐᖓ", "ᓭᒨ", "ᓭᒪᔪ", "ᓭᒻᒪᑎᑕᐅ", "ᓭᒻᒪᖃᔦ", "ᓭᓃᓯ", "ᔦᖕᖑᐊᑐᑦ", "ᔦᖕᖑᐊᑐᖅ",
            "ᔦᖕᖑᐊᑑᒃ", "ᐃᐱ", "ᐃᑉᐸᓴ", "ᐃᑉᐸᓵᓂ", "ᐃᒥᕈᑎ", "ᐃᒥᕐᑕᐅᑎ", "ᐃᒪᕐᓗᑯᓐᓂᐊᕈᑎ", "ᐃᒪᑦᓯᐊ", "ᐃᓄᐃᑦ",
            "ᐃᓄᑦᑎᑐᑦ", "ᐃᓄᒃᔪᐊᒃ", "ᐃᓄᒃᔪᐊᒥ", "ᐃᓅᖃᑎ", "ᐃᓇᑦᓯᓚᐅ", "ᐃᓛᓕ", "ᐃᓱᐃᑦᑐ", "ᐃᓱᐊᕐᑐ", "ᐃᕗᔨᕕᒃ",
            "ᐃᕗᔨᕕᒻᒥ", "ᐃᕿᐊᓇ", "ᐃᖃᓗ", "ᐃᖃᓗᐃᑦ", "ᐃᖃᓗᑉᐱ", "ᐃᖃᓗᓐᓂ", "ᐃᖃᓪᓕᐊ", "ᐄᒃᑭᑮ", "ᐱᐅᓯᑐ", "ᐱᑑᑎ",
            "ᐱᑭᐅ", "ᐱᒋᐊᑦᓯᐊ", "ᐱᒻᒪᕆ", "ᐱᓐᓂᐊ", "ᐱᓗᑲ", "ᐱᓯᑎ", "ᐱᓱᑦᑐ", "ᐱᓱᖃᑎ", "ᐱᕈᑦᓯᐊ", "ᐱᕙᓪᓕᐊ", "ᐱᖃᑎ",
            "ᐱᖃᓐᓈ", "ᐱᖃᓗᔭ", "ᐱᖓᔪᐊᓐᓂ", "ᐱᖕᖑᐊ", "ᑎᐸᐅᑎᒃ", "ᑎᑭᓚᖓᕕ", "ᑎᑭᕐᖁᒍ", "ᑎᑭᕐᖁᖓ", "ᑎᒥᓐᓂᐊ", "ᑎᒻᒥᔫᖅ",
            "ᑎᓇᑉᐳᖓ", "ᑎᓇᒐᒪ", "ᑎᓇᓐᓇᑐᖅ", "ᑎᓯᐱᕆ", "ᑎᔭᓚᖓ", "ᑏᑑᑎ", "ᑏᑐᖃᑎᒌ", "ᑭᑭᐊ", "ᑭᒍᑎ", "ᑭᒍᑕᖏᓐᓀᑦ",
            "ᑭᒻᒥᓀᑦ", "ᑭᒻᒥᓇ", "ᑭᒻᒥᕈ", "ᑭᒻᒥᕈᒻᒥ", "ᑭᒻᒪᐅᑏᒃ", "ᑭᓇᒃᑯ", "ᑭᖑᕙ", "ᑭᖕᙰᑦ", "ᑭᖕᖓᓂ", "ᑮᑕᓗᐊᓗ", "ᑮᓇᐅᔭ",
            "ᑮᓇᑉᐸ", "ᑮᓐᓇᓴ", "ᑮᓯᓲ", "ᒥᑐᐃᔭ", "ᒥᑦᓯᒪᑕᓕ", "ᒥᓇᓐᓂᐊ", "ᒥᓇᓚᖓ", "ᒥᓐᓂ", "ᒥᓚᖓᓯᔪ", "ᒥᓯᕋ", "ᒥᕐᖁ",
            "ᒥᕝᕕᒥ", "ᒥᖕᖏᒪ", "ᓂᐯᑦᑐ", "ᓂᑦᑕᔪ", "ᓂᑦᔭᓗᑦᑖ", "ᓂᑯᕐᕋ", "ᓂᓐᓂᐅ", "ᓂᓪᓛ", "ᓂᕆᑫᓐᓇ", "ᓂᕈᑐᔪ", "ᓂᕈᑭᑦᑐ",
            "ᓂᕈᒥᑦᑐ", "ᓂᕿᑦᓯᕕ", "ᓂᕿᑦᓯᕕᒻᒥ", "ᓂᖏᐅ", "ᓂᖓᐅ", "ᓂᖕᖓᐅᒪ", "ᓕᐅᑎᔫᒃ", "ᓕᓂᐅᖕᖏᑐ", "ᓕᓂᑐᖃ", "ᓕᕇᒥᔪ",
            "ᓕᕐᓕ", "ᓯᐅᐱᕈ", "ᓯᐅᓯᕆ", "ᓯᐅᕋ", "ᓯᑎᐱᕆ", "ᓯᑐᕋᐅᑏᒃ", "ᓯᑦᔭᓕᐊ", "ᓯᑯᖕᖏ", "ᓯᒃᑭᑕ", "ᓯᒃᑭᑕᑯᑖ", "ᓯᓂᓐᓇᓯ",
            "ᓯᓂᓐᓇᓯᒻᒪᑦ", "ᓯᓂᓕᕆ", "ᓯᓂᕇᕈᑦᑕ", "ᓯᓇᕐᔪᑑ", "ᓯᓈᓂ", "ᓯᓚᑉᐱᐊ", "ᓯᓚᑐᔪ", "ᓯᓚᑦᓯᐊ", "ᓯᓚᕐᔪᐊ", "ᓯᓛᐱ",
            "ᓯᓪᓗᔪ", "ᓯᕐᓈ", "ᓯᕿᓂ", "ᓯᕿᖕᖑᔭ", "ᓰᑦᑕᑐ", "ᓰᕐᓇᑐ", "ᓰᕐᖂ", "ᔨᐊᓕᒃ", "ᔨᐊᕗ", "ᔨᐊᖓ", "ᕆᐊᑐᔪᖅ",
            "ᕆᐊᑐᖕᖏᑐᖅ", "ᕆᐊᖃᖕᖏᑐᖅ", "ᕇᑐᐊᕐᐸ", "ᕇᓚᐅᔪᖅ", "ᕇᓚᐅᕐᑐᖅ", "ᕇᕐᖃᐅᔪᖅ", "ᕕᕈᐊᕆ", "ᕿᐊᒃᑲᑕᐅ",
            "ᕿᐊᔪ", "ᕿᐱᓗᑦᑐ", "ᕿᑐᕐᖓ", "ᕿᑭᕐᑕ", "ᕿᑲᕐᑐ", "ᕿᒥᕆᐊ", "ᕿᓂᓚᐅᒍ", "ᕿᓂᕐᑕᐅᔪ", "ᕿᓂᕐᑕᒐ", "ᕿᓚᓗᒐ",
            "ᕿᓯᔭᖅ", "ᕿᖓᑯᑦᑖᓕ", "ᖏᓐᓂᐅᔭᑦᔭᖏᓪᓚ", "ᖏᓪᓚᒍ", "ᖏᓪᓚᖓ", "ᐅᐃᒍᐃᑎᑐᑦ", "ᐅᐃᒍᐃᑦ", "ᐅᐱᓐᓇᕋᓂ",
            "ᐅᑉᐱᓕᕐᖃᐅ", "ᐅᑉᐱᓵ", "ᐅᑦᑐᐱᕆ", "ᐅᒥᐅᔭᒻᒥ", "ᐅᒥᐅᔭᖅ", "ᐅᓂᒃᑲᐅᓯ", "ᐅᓪᓚᓗᑎᑦ", "ᐅᓪᓚᓱᓂ", "ᐅᓰᒻᒪᓗ",
            "ᐅᕐᖂ", "ᐅᕝᕙᓘᓐᓃᑦ", "ᐅᕐᖂᔪ", "ᐅᖁᒣ", "ᐅᖓᓯᑦᑐ", "ᐅᖓᓯᓗᐊᕐᑐ", "ᐆᒪᔪ", "ᐆᒻᒪᑎᒐ", "ᐳᐃᔨ", "ᐳᐊᓘᒃ",
            "ᐳᑐᒍ", "ᐳᑦᔪᓯᐅᑎ", "ᐳᓪᓕᑐ", "ᐳᕕᔫ", "ᐳᕕᕐᓂᑐᒥ", "ᐳᕕᕐᓂᑐᖅ", "ᐴᑯᓗ", "ᐴᕐᓗᒍ", "ᑐᐸᑐᐃᕈᒪ", "ᑐᐸᕋᑖ",
            "ᑐᑭᓯᕖ?", "ᑐᑭᓯᕗᖓ", "ᑐᓱᐹ", "ᑐᓱᔪᖓ", "ᑐᓴᐅᑎ", "ᑐᔪᕐᒥᐊ", "ᑐᖑᔪᐊᖓᔪ", "ᑐᖑᔪᕐᑕ", "ᑯᑕᑦᑐ", "ᑯᑭᑕᐸᐅᑎ",
            "ᑯᑭᑦᓯᐅᑎ", "ᑯᕕᓗᒍ", "ᑯᕕᕐᖃᐅᔪ", "ᑰᑦᔪᐊᒥ", "ᑰᑦᔪᐊᕌᐱᒃ", "ᑰᑦᔪᐊᕌᐱᒻᒥ", "ᑰᑦᔪᐊᖅ", "ᒧᒥᓪᓗᒍ", "ᒧᒥᖕᖓᔪ", "ᓄᐃᓚ",
            "ᓄᑖ", "ᓄᑖᕕᓂᖅ", "ᓄᑭᒃᑲ", "ᓄᑲᒐ", "ᓄᑳᐱᒐ", "ᓄᓂᕙᕆᐊ", "ᓄᓂᕚᑦᓭᑦ", "ᓄᓇᑦᓯᐊᕗᑦ", "ᓄᓇᒥ", "ᓄᓇᓕ",
            "ᓄᓇᓕᑦᑎᓂ", "ᓄᓇᕕᒃ", "ᓄᓇᕗᑦ", "ᓄᕕᐱᕆ", "ᓄᕗᑦᓯᓴᕐᑐᖅ", "ᓄᕗᑦᓯᔪᖅ", "ᓄᕗᔦᑦ", "ᓄᕙᑦᑐᖓ", "ᓄᖑᑦᑐ",
            "ᓄᖑᒪᔪ", "ᓄᖑᒪᔪᑦ", "ᓅᓚᖓᕕ", "ᓗᑐᕐᕿ", "ᓗᑯᐊᓗ", "ᓗᑳᓗ", "ᓱᑲᑦᑐ", "ᓱᓇᐅᓈ?", "ᓱᓕᕖᑦ?", "ᓱᓕᕗᖓ",
            "ᓱᓕᖕᖏᓇᕕᑦ", "ᓱᓚᖓᕕ", "ᓱᔪᖃᓕᕐᖃ?", "ᓱᕕᓯ", "ᓱᖃᑦᓯᕕᓯ", "ᓱᖏᐅᓐᓀ", "ᓱᖏᐅᓐᓂ", "ᓲᖑᔪ", "ᔪᑐᐊᖅ",
            "ᔪᑐᖄᓗᖅ", "ᔪᓓ", "ᔫᓂ", "ᔫᔮᕐᑐᖅ", "ᕈᒪᔭᕐᓱ", "ᕈᓇᐅᑦᓱᓂ", "ᕈᓇᐅᖕᖏᑐᖅ", "ᕈᓐᓇᖁᑎ", "ᕈᓐᓇᖁᓯ",
            "ᕗᒍᓪᓕ", "ᖁᐊᕐᑕᒥ", "ᖁᐊᕐᑕᖅ", "ᖁᐱᕐᕈ", "ᖁᑎᒍᓘ", "ᖁᒥᐅᑫᓐᓇᖃᒋ", "ᖁᒥᐅᖕᖓ", "ᖁᔨᒍᕕᑦ", "ᖁᔨᖕᖏᓇᒪ",
            "ᖁᔭᐅᖕᖏᓚᖓ", "ᖑᐊᓲ", "ᐊᐅᐸᓗᒃ", "ᐊᐅᐸᓗᒻᒥ", "ᐊᐅᑯᓯᑎ", "ᐊᐅᑲ", "ᐊᑕᐅᑦᓯᑯᑦ", "ᐊᑕᐅᓯ", "ᐊᑭᒋᐊ",
            "ᐊᑭᖓ", "ᐊᑯᓕᕕᒃ", "ᐊᑯᓕᕕᒻᒥ", "ᐊᒥᓱᑦ", "ᐊᓪᓕᑐᓂ", "ᐊᓯᐅᔪ", "ᐊᓯᕙᓚᖓ", "ᐊᓯᕙᕐᖃᐅ", "ᐊᓱᒎᒃ", "ᐊᕐᖁᑎ",
            "ᐊᖏᔪᐊᓗ", "ᐊᖏᕐᐳᖓ", "ᐋᑕᑖ", "ᐋᑦᓲ", "ᐋᓐᓂᐊ", "ᐋᓐᓂᓇᕐᑐ", "ᐋᓗᒻᒥ", "ᐋᓚᓖᓐᓇ", "ᐋᕐᕿᐳᖓ",
            "ᐸᐅᕐᖓᑐᕈᒪᐹ", "ᐸᐅᕐᙰᑦ", "ᐸᐱᕈ", "ᐸᓂᒐ", "ᐸᓂᕐᑎᑕ", "ᐸᓂᕐᑐ", "ᐸᓃᑦ", "ᐸᓐᓂᑑᖅ", "ᐸᖓᓕ", "ᐹᓂᐊᓗ",
            "ᐹᓐᓂᓴᖃᑦᑕᓇ", "ᐹᓪᓚᓱᖓ", "ᑕᑭᔪ", "ᑕᑯᑫᓐᓇ", "ᑕᑯᓚᐅᕋᓴᕐᑌ?", "ᑕᑯᕚ", "ᑕᒪᐅᓇ", "ᑕᓯᐅᔭᒥ", "ᑕᓯᐅᔭᖅ",
            "ᑕᓯᐊᓗᒃ", "ᑕᓯᐊᓗᒻᒥ", "ᑕᓯᑯᑖᒃ", "ᑕᓯᑯᑖᒥ", "ᑕᓯᑲᓪᓚᒃ", "ᑕᓯᑲᓪᓚᒥ", "ᑖᒃᑯᓂᖓᑦᓭᓇ", "ᑖᒃᑯᓭᓐᓀᑦ", "ᑖᓂᓯ",
            "ᑲᑎᒪ", "ᑲᒃᑭᐅᕗᖓ", "ᑲᒃᑭᓕᔪᖅ", "ᑲᒃᑭᓕᕗᖓ", "ᑲᒥᓪᓛ", "ᑲᒪᑦᓴᓇ", "ᑲᓇᑕ", "ᑲᓇᑕᒥ", "ᑲᓲᒪ", "ᑲᖏᕐᓱᐊᓗᑦᔪᐊᒥ",
            "ᑲᖏᕐᓱᐊᓗᑦᔪᐊᖅ", "ᑲᖏᕐᓱᑲᓪᓚᒃ", "ᑲᖏᕐᓱᑲᓪᓚᒥ", "ᑲᖏᕐᓱᒃ", "ᑲᖏᕐᓱᒥ", "ᑲᖏᕐᓱᔪᐊᒥ", "ᑲᖏᕐᓱᔪᐊᖅ", "ᑲᖕᖑᒋ", "ᑲᖕᖑᓱ",
            "ᑳᐱᑐ", "ᑳᐱᑐᕈᒪᕕ", "ᑳᐹ", "ᒪᑭᑕ", "ᒪᒣᑦᑐᖁᑏᑦ", "ᒪᒣᑦᑐᖅ", "ᒪᒥᑦᓯᐊᕋ", "ᒪᒥᕐᖁ", "ᒪᒪᕐᑐ", "ᒪᒪᕐᑯᖅ", "ᒪᒪᕐᖄ?",
            "ᒪᓃᑦᑐ", "ᒪᓕᒉᑦ", "ᒪᓕᕈᒪᐹ", "ᒪᓕᕈᒪᕖ", "ᒪᔪᕋ", "ᒪᖏᑦᑕ", "ᒪᙯ", "ᒪᙯᓈᖅ", "ᒫᔨ", "ᓇᑦᓯᕕᓂ", "ᓇᑭᖕᖔᑐ",
            "ᓇᑯᕐᒦᒃ", "ᓇᒧᖕᖓᓚᖓᕕ", "ᓇᒻᒪᒑ", "ᓇᓂᒥᐅᖑᕕ", "ᓇᓗᐹ", "ᓇᓗᓇᕿ", "ᓇᓪᓕᒋᕙᒋᑦ", "ᓇᖏᐊ", "ᓈᒻᒪᑐ", "ᓈᒻᒪᖏᑦᑐ",
            "ᓈᓚᐅᑎ", "ᓈᓚᑦᓯᐊ", "ᓚᐅᕐᖁᖓ", "ᓚᕆᒻᒥ", "ᓚᖓᓯᕗᖓ", "ᓚᖓᕗᖓ", "ᓛᕐᑐᐊᓗᒃ", "ᓴᑭᒐ", "ᓴᓂᑦᑎᓂ", "ᓴᓂᑦᓯᓂ",
            "ᓴᓂᒃᑯᕕ", "ᓴᓐᓂᑐᖓ", "ᓴᓐᓂᖓᔪ", "ᓴᓪᓗᐃᑦ", "ᓴᓪᓗᓂ", "ᓵᓚᖃ", "ᔭᓄᐊᕆ", "ᔭᖏᓪᓚ", "ᔮᐸᓃᓯ", "ᕋᓗᐊᕐᐸᑦ", "ᕋᓛᐱ",
            "ᕋᓱᐊᒻᒪᕆ", "ᕋᓱᓪᓗᑎ", "ᕙᒻᒪᑕ", "ᕙᓗᒻᒪᑕ", "ᕙᓗᒻᒪᑦ", "ᖃᐅᑉᐸᑦ", "ᖃᐅᑉᐸᓵ", "ᖃᐅᑉᐸᓵᑦᓵ", "ᖃᐅᑕᒣᑕ", "ᖃᐅᑕᒫᑦ",
            "ᖃᑕᖕᖑᑏᙰ", "ᖃᑦᓯᖑᑐᐊᕐᐸᑦ?", "ᖃᓄᐃᑉᐲᑦ?", "ᖃᓄᐃᑉᐳᖓ", "ᖃᓄᐃᖕᖏᓚᑏᑦ?", "ᖃᓄᐃᖕᖏᓚᖓ", "ᖃᓪᓗᓈᑎᑐᑦ",
            "ᖃᓪᓗᓈᑦ", "ᖃᕆᑕᐅᔮᕈ", "ᖃᖓ?", "ᖃᖓᑐᐃᓐᓇ"

    };

}
