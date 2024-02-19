/*
 * Copyright (C) 2008-2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.syllabic.syllabickeyboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.Keyboard.Key;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syllabic.syllabickeyboard.config.BaseConfig;
import com.syllabic.syllabickeyboard.utils.Utils;

import java.util.List;

public class LatinKeyboardView extends KeyboardView {

    static final int KEYCODE_OPTIONS = -100;
    Context context;
    private PopupWindow mPopupKeyboard;
    private Key keys;
    private Key checkPressGray;
    private PassDataLongPress passDataLongPress;
    private PassEventKeyboard passEventKeyboard;
    private CheckDataLongPress checkDataLongPress;
    private PassDataLongPressOneCharator passDataLongPressOneCharator;
    boolean checkAction = false, checkLongPressOneCharactor = false,
            checkLongPressNotActionMove = false,checkDismissPopupLongPress = false;
    private DismissPopupLongPress dismissPopupLongPress;
    private DismissGrayWithButtonDotAndTwoDot dismissGrayWithButtonDotAndTwoDot;

    @SuppressLint({"MissingInflatedId", "InflateParams"})
    public LatinKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mPopupKeyboard = new PopupWindow(context);
        mPopupKeyboard.setContentView(inflater.inflate(R.layout.layout_custom, null));
    }

    public LatinKeyboardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    public void passDataLongPress(PassDataLongPress passDataLongPress) {
        this.passDataLongPress = passDataLongPress;
    }

    public void setPassEventKeyboard(PassEventKeyboard passEventKeyboard) {
        this.passEventKeyboard = passEventKeyboard;
    }

    public void setCheckDataLongPress(CheckDataLongPress checkDataLongPress) {
        this.checkDataLongPress = checkDataLongPress;
    }

    public void setPassDataLongPressOneCharator(PassDataLongPressOneCharator passDataLongPressOneCharator) {
        this.passDataLongPressOneCharator = passDataLongPressOneCharator;
    }

    public void setDismissPopupLongPress( DismissPopupLongPress dismissPopupLongPress) {
        this.dismissPopupLongPress = dismissPopupLongPress;
    }

    public void setDismissGrayWithButtonDotAndTwoDot( DismissGrayWithButtonDotAndTwoDot dismissGrayWithButtonDotAndTwoDot) {
        this.dismissGrayWithButtonDotAndTwoDot = dismissGrayWithButtonDotAndTwoDot;
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            BaseConfig.saveHorizontalOrVertical("LANDSCAPE", context);
        } else {
            BaseConfig.saveHorizontalOrVertical("PORTRAIT", context);
        }
    }

    @Override
    protected boolean onLongPress(Key key) {
        keys = key;
        checkLongPressOneCharactor = false;
        if (key.codes[0] == Keyboard.KEYCODE_CANCEL) {
            getOnKeyboardActionListener().onKey(KEYCODE_OPTIONS, null);
            return super.onLongPress(key);
        } else if (key.label == null || key.codes[0] == 32 || key.codes[0] == -5 ) {
            return super.onLongPress(key);
        } else if (key.codes[0] == 113 || key.codes[0] == 1000 || key.codes[0] == 1050 || key.codes[0] == 2000 ||
                key.codes[0] == 2050 || key.codes[0] == 3000 || key.codes[0] == 3050 || key.codes[0] == 4000 ||
                key.codes[0] == 4050 || key.codes[0] == 5000 || key.codes[0] == 5020 || key.codes[0] == 5030 ||
                key.codes[0] == 97 || key.codes[0] == -1 || key.codes[0] == 10 ||
                key.codes[0] == -2 || key.codes[0] == -10 || key.codes[0] == -11 || key.codes[0] == -40 ||
                key.codes[0] == -41 || key.codes[0] == -45 || key.codes[0] == -46 || key.codes[0] == -15 ||
                key.codes[0] == -16 || key.codes[0] == -50 || key.codes[0] == -51 || key.codes[0] == -54 ||
                key.codes[0] == -55 || key.codes[0] == -52 || key.codes[0] == -53 ||
                key.codes[0] == -18 || key.codes[0] == -19 || key.codes[0] == -30 || key.codes[0] == -31 ||
                key.codes[0] == -35 || key.codes[0] == -36 || key.codes[0] == -20 || key.codes[0] == -21 ||
                key.codes[0] == -25 || key.codes[0] == -26 || key.text.equals("ᐁ") ||
                key.text.equals("ᐯ") || key.text.equals("ᑌ") ||
                key.text.equals("ᑫ") || key.text.equals("ᒉ") || key.text.equals("ᒣ") ||
                key.text.equals("ᓀ") || key.text.equals("ᓭ") || key.text.equals("ᓓ") ||
                key.text.equals("ᔦ") || key.text.equals("ᕓ") ||
                key.text.equals("ᙯ") || key.text.equals("ᙰ") || key.text.equals("ᖖ") ||
                key.text.equals("ᑉ") || key.text.equals("ᑦ") ||
                key.text.equals("ᒃ") || key.text.equals("ᒡ") || key.text.equals("ᒻ") ||
                key.text.equals("ᓐ") || key.text.equals("ᕻ") || key.text.equals("ᔅ") ||
                key.text.equals("ᓪ") || key.text.equals("ᔾ") || key.text.equals("ᕝ") ||
                key.text.equals("ᕐ") || key.text.equals("ᖅ") || key.text.equals("ᖕ") ||
                key.text.equals("ᖦ") || key.text.equals(".") || key.text.equals(",") || key.text.equals("?") ||
                key.text.equals("!") || key.text.equals(";") || key.text.equals(":") ||
                key.text.equals("\uD83C\uDF1A") || key.text.equals("\uD83C\uDF1D") || key.text.equals("\uD83C\uDF1E") ||
                key.text.equals("\uD83C\uDF1F") || key.text.equals("\uD83C\uDF25") || key.text.equals("\uD83C\uDF27") ||
                key.text.equals("\uD83C\uDF28") || key.text.equals("\uD83C\uDF2C") || key.text.equals("\uD83C\uDF89") ||
                key.text.equals("\uD83C\uDF7D") || key.text.equals("\uD83D\uDC15") || key.text.equals("\uD83D\uDC4B") ||
                key.text.equals("\uD83D\uDC4D") || key.text.equals("\uD83E\uDDE1") || key.text.equals("\uD83D\uDE42") ||
                key.text.equals("\uD83D\uDE41") || key.text.equals("\uD83D\uDE22") || key.text.equals("\uD83D\uDE0D") ||
                key.text.equals("\uD83D\uDE18") || key.text.equals("\uD83E\uDD23") || key.text.equals("0") ||
                key.text.equals("1") || key.text.equals("2") || key.text.equals("3")
                || key.text.equals("4") || key.text.equals("5") || key.text.equals("6") || key.text.equals("7")
                || key.text.equals("8") || key.text.equals("9") || key.text.equals("+") || key.text.equals("-")
                || key.text.equals("*") || key.text.equals("/") || key.text.equals("=") || key.text.equals("%")
                || key.text.equals("|") || key.text.equals("≠") || key.text.equals("≈") || key.text.equals("≤")
                || key.text.equals("≥") || key.text.equals("<") || key.text.equals(">") || key.text.equals("°")
                || key.text.equals("_") || key.text.equals("^") || key.text.equals("\\") || key.text.equals("√")
                || key.text.equals("π") || key.text.equals("@") || key.text.equals("[") || key.text.equals("]")
                || key.text.equals("(") || key.text.equals(")") || key.text.equals("«") || key.text.equals("»")
                || key.text.equals("&") || key.text.equals("{") || key.text.equals("}") || key.text.equals("#")
                || key.text.equals("cm") || key.text.equals("km") || key.text.equals("'") || key.text.equals("\"")
                || key.text.equals("m") || key.text.equals("g") || key.text.equals("x") || key.text.equals("y")
                || key.text.equals("z") || key.text.equals("•") || key.text.equals("$") || key.text.equals("¢")) {
            if (keys.label != null && !keys.label.toString().equals("▼") &&
                    !keys.label.toString().equals("▲") && !keys.label.toString().equals("1")
                    && !keys.label.toString().equals("•") && !keys.label.toString().equals("••")) {
                checkLongPressOneCharactor = true;
                dismissGrayWithButtonDotAndTwoDot.dismissGrayWithButtonDotAndTwoDot();
            }
            return true;
        } else {
            checkDataLongPress.checkDataLongPress();
            return customPopup(key);
        }
    }

    public boolean customPopup(Key popupKey) {
        checkLongPressNotActionMove = true;
        if (popupKey.label != null) {
            if (popupKey.label.equals("ᓂ") || popupKey.label.equals("ᓃ") || popupKey.label.equals("ᓄ")
                    || popupKey.label.equals("ᓅ") || popupKey.label.equals("ᖒ") || popupKey.label.equals("ᖑ")
                    || popupKey.label.equals("ᓇ") || popupKey.label.equals("ᖓ") || popupKey.label.equals("ᓈ")
                    || popupKey.label.equals("ᖔ")|| popupKey.label.equals("ᖏ")|| popupKey.label.equals("ᖐ")) {
                Utils.showPopupLongClick(mPopupKeyboard, context, popupKey,
                        mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne),
                        mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo));
                mPopupKeyboard.setClippingEnabled(false);
                mPopupKeyboard.showAtLocation(this, Gravity.NO_GRAVITY, (popupKey.x) - 250, popupKey.y - 100);
                mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setOnClickListener(this);
                mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setOnClickListener(this);
            } else if (popupKey.label.equals("ᒥ") || popupKey.label.equals("ᕿ")
                    || popupKey.label.equals("ᒦ")
                    || popupKey.label.equals("ᖀ") || popupKey.label.equals("ᒧ") || popupKey.label.equals("ᖁ")
                    || popupKey.label.equals("ᒨ") || popupKey.label.equals("ᖂ") || popupKey.label.equals("ᒪ")
                    || popupKey.label.equals("ᖃ") || popupKey.label.equals("ᒫ") || popupKey.label.equals("ᖄ")) {
                Utils.showPopupLongClick(mPopupKeyboard, context, popupKey,
                        mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne),
                        mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo));
                mPopupKeyboard.setClippingEnabled(false);
                mPopupKeyboard.showAtLocation(this, Gravity.NO_GRAVITY, (popupKey.x) - 120, popupKey.y - 100);
                mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setOnClickListener(this);
                mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setOnClickListener(this);
            } else {
                Utils.showPopupLongClick(mPopupKeyboard, context, popupKey,
                        mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne),
                        mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo));
                mPopupKeyboard.setClippingEnabled(false);
                mPopupKeyboard.showAtLocation(this, Gravity.NO_GRAVITY, (popupKey.x), popupKey.y - 100);
                mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setOnClickListener(this);
                mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setOnClickListener(this);
            }
        } else {
            Utils.showPopupLongClick(mPopupKeyboard, context, popupKey,
                    mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne),
                    mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo));
            mPopupKeyboard.setClippingEnabled(false);
            mPopupKeyboard.showAtLocation(this, Gravity.NO_GRAVITY, (popupKey.x), popupKey.y - 100);
            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setOnClickListener(this);
            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setOnClickListener(this);
        }
        return true;
    }


    @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables"})
    @Override
    public boolean onTouchEvent(MotionEvent me) {
        if (me.getAction() == MotionEvent.ACTION_DOWN) {
            checkAction = false;
            checkDismissPopupLongPress = false;
        } else if (me.getAction() == MotionEvent.ACTION_MOVE) {
            int iconRight = context.getResources().getDimensionPixelSize(R.dimen.action_move_left);
            int actionMoveDissmissPopup = context.getResources().getDimensionPixelSize(R.dimen.action_move_dissmiss_popup);
            int actionMoveDissmissPopupRight = context.getResources().getDimensionPixelSize(R.dimen.action_move_dissmiss_popup_right);
            if (keys != null) {
                if (checkLongPressNotActionMove) {
                    Log.d("sonth", "keys.x:"+keys.x+"iconRight"+iconRight+"me.getX()"+me.getX()+"actionMoveDissmissPopup"+actionMoveDissmissPopup);
                    if (me.getX()+actionMoveDissmissPopup < keys.x|| keys.x + iconRight + actionMoveDissmissPopupRight <  me.getX()){
                        Log.d("sonth1", "me.getX()+actionMoveDissmissPopup:"+me.getX()+actionMoveDissmissPopup+"keys.x"+keys.x);
                        checkDismissPopupLongPress = true;
                        checkLongPressNotActionMove = false;
                        dismissPopupLongPress.dismissPopupLongPress();
                        checkAction = false;
                        dismissPopup();
                        checkPressGray = null;
                    } else if ((keys.x + iconRight) > me.getX() ) {
                        if (mPopupKeyboard.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.background_popup_blue).getConstantState())) {
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setBackgroundResource(R.drawable.background_selected_text);
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                        } else if (mPopupKeyboard.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.background_popup_orange).getConstantState())) {
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setBackgroundResource(R.drawable.background_selected_text);
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                        } else if (mPopupKeyboard.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.background_popup_black_long_press).getConstantState())) {
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setBackgroundResource(R.drawable.background_selected_text);
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setBackgroundResource(R.drawable.background_popup_black_text_long_press);
                        } else {
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setBackgroundResource(R.drawable.background_selected_text);
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                        }
                    } else {
                        if (mPopupKeyboard.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.background_popup_blue).getConstantState())) {
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setBackgroundResource(R.drawable.background_popup_blue_text_long_press);
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setBackgroundResource(R.drawable.background_selected_text);
                        } else if (mPopupKeyboard.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.background_popup_orange).getConstantState())) {
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setBackgroundResource(R.drawable.background_popup_orange_text_long_press);
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setBackgroundResource(R.drawable.background_selected_text);
                        }  else if (mPopupKeyboard.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.background_popup_black_long_press).getConstantState())) {
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setBackgroundResource(R.drawable.background_popup_black_text_long_press);
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setBackgroundResource(R.drawable.background_selected_text);
                        } else {
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setBackgroundResource(R.drawable.background_popup_green_text_long_press);
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setBackgroundResource(R.drawable.background_selected_text);
                        }
                    }
                }else {
                    if (me.getX() < keys.x|| keys.x + iconRight  <  me.getX()){
                        Log.d("sonth1", "me.getX()+actionMoveDissmissPopup:"+me.getX()+actionMoveDissmissPopup+"keys.x"+keys.x);
                        dismissPopupLongPress.dismissPopupLongPress();
                        dismissPopup();
                        checkPressGray = null;
                    }
                }
            }
        } else if (me.getAction() == MotionEvent.ACTION_UP) {
            if (checkLongPressOneCharactor) {
                if (keys != null) {
                    if (keys.label != null && !keys.label.toString().equals("▼") &&
                            !keys.label.toString().equals("▲") && !keys.label.toString().equals("1")
                            && !keys.label.toString().equals("•") && !keys.label.toString().equals("••")) {
                        passDataLongPressOneCharator.passDataLongPressOneCharator(keys.label.toString());
                        checkPressGray = null;
                    }
                }
            } else {
                if (checkAction) {
                    if (mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).getBackground() != null) {
                        if (mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).getBackground()
                                .getConstantState().equals(getResources().getDrawable(R.drawable.background_selected_text).getConstantState())) {
                            passDataLongPress.passDataLongPress(((TextView) mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne)).getText().toString(),checkDismissPopupLongPress);
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setBackground(null);

                        } else {
                            passDataLongPress.passDataLongPress(((TextView) mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo)).getText().toString(),checkDismissPopupLongPress);
                            mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setBackground(null);

                        }
                        checkPressGray = null;
                    }
                } else {
                    if (checkLongPressNotActionMove) {
                        if (mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).getBackground() != null) {
                            if (mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).getBackground()
                                    .getConstantState().equals(getResources().getDrawable(R.drawable.background_selected_text).getConstantState())) {
                                passDataLongPress.passDataLongPress(((TextView) mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne)).getText().toString(),checkDismissPopupLongPress);
                                mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressOne).setBackground(null);
                                checkPressGray = null;
                            } else {
                                checkPressGray = null;
                                passDataLongPress.passDataLongPress(((TextView) mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo)).getText().toString(),checkDismissPopupLongPress);
                                mPopupKeyboard.getContentView().findViewById(R.id.tvLongPressTwo).setBackground(null);
                            }
                        }
                        checkLongPressNotActionMove = false;
                    }else {
                        if (keys != null){
                            if (keys.label != null) {
                                if (keys.label.toString().equals("▼") ||
                                        keys.label.toString().equals("▲") || keys.label.toString().equals("1")
                                        || keys.label.toString().equals("•") || keys.label.toString().equals("••"))
                                    dismissGrayWithButtonDotAndTwoDot.dismissGrayWithButtonDotAndTwoDot();
                            }
                        }
                    }
                }
            }
            keys = null;
            passEventKeyboard.passEventKeyboard(me);
            checkPressGray = null;
            dismissPopup();
        }
        return super.onTouchEvent(me);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        @SuppressLint("DrawAllocation")
        Paint paint = new Paint();
        List<Key> keys = getKeyboard().getKeys();
        int checkType;
        for (Key key : keys) {
            checkType = keys.get(0).codes[0];
            if (checkType == 113) {
                if (checkPressGray == null) {
                    Utils.setBackGroundDefault(key, canvas, paint, context);
                }else {
                    if (checkPressGray != key){
                        Utils.setBackGroundDefault(key, canvas, paint, context);
                    }else {
                        Utils.setBackGroundDefault(key, canvas, paint, context);
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }
                }
                if (key.pressed) {
                    checkPressGray = key;
                    Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                }

            } else if (checkType == 1000) {
                if (checkPressGray == null) {
                    Utils.setBackGroundEmoji(key, canvas, paint, context);
                }else {
                    if (checkPressGray != key){
                        Utils.setBackGroundEmoji(key, canvas, paint, context);
                    }else {
                        Utils.setBackGroundEmoji(key, canvas, paint, context);
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }
                }
                    if (key.pressed) {
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }

            } else if (checkType == 1050) {
                if (checkPressGray == null) {
                    Utils.setBackGroundSelectTwoDot(key, canvas, paint, context);
                }else {
                    if (checkPressGray != key){
                        Utils.setBackGroundSelectTwoDot(key, canvas, paint, context);
                    }else {
                        Utils.setBackGroundSelectTwoDot(key, canvas, paint, context);
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }
                }
                if (key.pressed) {
                    checkPressGray = key;
                    Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                }
            } else if (checkType == 2000) {
                if (checkPressGray == null) {
                    Utils.setBackGroundTwoQwerty(key, canvas, paint, context);
                }else {
                    if (checkPressGray != key){
                        Utils.setBackGroundTwoQwerty(key, canvas, paint, context);
                    }else {
                        Utils.setBackGroundTwoQwerty(key, canvas, paint, context);
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }
                }
                if (key.pressed) {
                    checkPressGray = key;
                    Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                }
            } else if (checkType == 2050) {
                if (checkPressGray == null) {
                    Utils.setBackGroundTwoSelectOneDot(key, canvas, paint, context);
                }else {
                    if (checkPressGray != key){
                        Utils.setBackGroundTwoSelectOneDot(key, canvas, paint, context);
                    }else {
                        Utils.setBackGroundTwoSelectOneDot(key, canvas, paint, context);
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }
                }
                if (key.pressed) {
                    checkPressGray = key;
                    Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                }
            } else if (checkType == 3000) {
                if (checkPressGray == null) {
                    Utils.setBackGroundThreeQwerty(key, canvas, paint, context);
                }else {
                    if (checkPressGray != key){
                        Utils.setBackGroundThreeQwerty(key, canvas, paint, context);
                    }else {
                        Utils.setBackGroundThreeQwerty(key, canvas, paint, context);
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }
                }
                if (key.pressed) {
                    checkPressGray = key;
                    Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                }
            } else if (checkType == 3050) {
                if (checkPressGray == null) {
                    Utils.setBackGroundThreeSelectOneDot(key, canvas, paint, context);
                }else {
                    if (checkPressGray != key){
                        Utils.setBackGroundThreeSelectOneDot(key, canvas, paint, context);
                    }else {
                        Utils.setBackGroundThreeSelectOneDot(key, canvas, paint, context);
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }
                }
                if (key.pressed) {
                    checkPressGray = key;
                    Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                }
            } else if (checkType == 4000) {
                if (checkPressGray == null) {
                    Utils.setBackGroundFourQwerty(key, canvas, paint, context);
                }else {
                    if (checkPressGray != key){
                        Utils.setBackGroundFourQwerty(key, canvas, paint, context);
                    }else {
                        Utils.setBackGroundFourQwerty(key, canvas, paint, context);
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }
                }
                if (key.pressed) {
                    checkPressGray = key;
                    Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                }
            } else if (checkType == 4050) {
                if (checkPressGray == null) {
                    Utils.setBackGroundFourSelectOneDot(key, canvas, paint, context);
                }else {
                    if (checkPressGray != key){
                        Utils.setBackGroundFourSelectOneDot(key, canvas, paint, context);
                    }else {
                        Utils.setBackGroundFourSelectOneDot(key, canvas, paint, context);
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }
                }
                if (key.pressed) {
                    checkPressGray = key;
                    Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                }
            } else if (checkType == 5000) {
                if (checkPressGray == null) {
                    Utils.setBackGroundQwertyNumber(key, canvas, paint, context);
                }else {
                    if (checkPressGray != key){
                        Utils.setBackGroundQwertyNumber(key, canvas, paint, context);
                    }else {
                        Utils.setBackGroundQwertyNumber(key, canvas, paint, context);
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }
                }
                if (key.pressed) {
                    checkPressGray = key;
                    Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                }
            } else if (checkType == 5020) {
                if (checkPressGray == null) {
                    Utils.setBackGroundQwertyNumberTwo(key, canvas, paint, context);
                }else {
                    if (checkPressGray != key){
                        Utils.setBackGroundQwertyNumberTwo(key, canvas, paint, context);
                    }else {
                        Utils.setBackGroundQwertyNumberTwo(key, canvas, paint, context);
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }
                }
                if (key.pressed) {
                    checkPressGray = key;
                    Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                }
            } else if (checkType == 5030) {
                if (checkPressGray == null) {
                    Utils.setBackGroundQwertyNumberThree(key, canvas, paint, context);
                }else {
                    if (checkPressGray != key){
                        Utils.setBackGroundQwertyNumberThree(key, canvas, paint, context);
                    }else {
                        Utils.setBackGroundQwertyNumberThree(key, canvas, paint, context);
                        Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                    }
                }
                if (key.pressed) {
                    checkPressGray = key;
                    Utils.setColorButtonSelectedKeyboard(key, canvas, context);
                }
            }
        }
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    void setSubtypeOnSpaceKey(final InputMethodSubtype subtype) {
        final com.syllabic.syllabickeyboard.LatinKeyboard keyboard = (com.syllabic.syllabickeyboard.LatinKeyboard) getKeyboard();
        keyboard.setSpaceIcon(getResources().getDrawable(subtype.getIconResId()));
        invalidateAllKeys();
    }

    public void dismissPopup() {
        if (mPopupKeyboard != null) {
            if (mPopupKeyboard.isShowing()) {
                mPopupKeyboard.dismiss();
            }
        }
    }

    interface PassDataLongPress {
        void passDataLongPress(String text,boolean type);
    }

    interface PassDataLongPressOneCharator {
        void passDataLongPressOneCharator(String text);
    }


    interface CheckDataLongPress {
        void checkDataLongPress();
    }

    interface DismissPopupLongPress {
        void dismissPopupLongPress();
    }

    interface DismissGrayWithButtonDotAndTwoDot {
        void dismissGrayWithButtonDotAndTwoDot();
    }
}
