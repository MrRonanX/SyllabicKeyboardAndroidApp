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


import static android.view.WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Handler;
import android.os.Looper;
import android.text.InputType;
import android.text.method.MetaKeyKeyListener;
import android.util.Log;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.inputmethodservice.Keyboard.Key;

import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.syllabic.syllabickeyboard.config.BaseConfig;
import com.syllabic.syllabickeyboard.utils.Utils;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * Example of writing an input method for a soft keyboard.  This code is
 * focused on simplicity over completeness, so it should in no way be considered
 * to be a complete soft keyboard implementation.  Its purpose is to provide
 * a basic example for how you would get started writing an input method, to
 * be fleshed out as appropriate.
 */
public class SoftKeyboard extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener, View.OnClickListener,
        LatinKeyboardView.PassDataLongPress, PassEventKeyboard, LatinKeyboardView.CheckDataLongPress,
        LatinKeyboardView.PassDataLongPressOneCharator,LatinKeyboardView.DismissPopupLongPress,
        LatinKeyboardView.DismissGrayWithButtonDotAndTwoDot{
    /**
     * This boolean indicates the optional example code for performing
     * processing of hard keys in addition to regular text generation
     * from on-screen interaction.  It would be used for input methods that
     * perform language translations (such as converting text entered on
     * a QWERTY keyboard to Chinese), but may not be used for input methods
     * that are primarily intended to be used for on-screen text entry.
     */
    static final boolean PROCESS_HARD_KEYS = true;

    private InputMethodManager mInputMethodManager;

    private LatinKeyboardView mInputView;
    private CandidateView mCandidateView;
    private CompletionInfo[] mCompletions;

    private StringBuilder mComposing = new StringBuilder();
    private boolean mPredictionOn;
    private boolean mCompletionOn;
    private int mLastDisplayWidth;
    private boolean mCapsLock;
    private long mLastShiftTime;
    private long mMetaState;

    private LatinKeyboard mSymbolsKeyboard;
    private LatinKeyboard mSymbolsShiftedKeyboard;
    private LatinKeyboard mQwertyKeyboard;
    private LatinKeyboard mQwertyEmoji;
    private LatinKeyboard mQwertySelectTwoDot;
    private LatinKeyboard mQwertyTwo;
    private LatinKeyboard mQwertyTwoSelectOneDot;
    private LatinKeyboard mQwertyThree;
    private LatinKeyboard mQwertyThreeSelectOneDot;
    private LatinKeyboard mQwertyFour;
    private LatinKeyboard mQwertyFourSelectOneDot;
    private LatinKeyboard mQwertyNumber;
    private LatinKeyboard mQwertyNumberTwo;
    private LatinKeyboard mQwertyNumberThree;

    private LatinKeyboard mCurKeyboard;

    private String mWordSeparators;
    private String textEditText = "", textClick = "";
    private View myKeyboardView, viewSuggestOne, viewSuggestTwo,viewBlur;
    private LinearLayout layoutSuggest;
    private LinearLayout layoutSuggestOne, layoutSuggestTwo, layoutSuggestThree;
    private TextView textSuggestOne, textSuggestTwo, textSuggestThree;
    private int count = 0;
    private boolean check = false;

    private PopupWindow mPopupKeyboard;
    private Handler handler;
    Keyboard currentKeyboard;

    /**
     * Main initialization of the input method component.  Be sure to call
     * to super class.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        mWordSeparators = getResources().getString(R.string.word_separators);
    }
//    public void setData(PassData passData){
//        this.passData = passData;
//    }
    /**
     * This is the point where you can do all of your UI initialization.  It
     * is called after creation and any configuration change.
     */
    @Override
    public void onInitializeInterface() {
        if (mQwertyKeyboard != null) {
            // Configuration changes can happen after the keyboard gets recreated,
            // so we need to be able to re-build the keyboards if the available
            // space has changed.
            int displayWidth = getMaxWidth();
            if (displayWidth == mLastDisplayWidth) return;
            mLastDisplayWidth = displayWidth;
        }
//        if (mQwertyTwo != null) {
//            // Configuration changes can happen after the keyboard gets recreated,
//            // so we need to be able to re-build the keyboards if the available
//            // space has changed.
//            int displayWidth = getMaxWidth();
//            if (displayWidth == mLastDisplayWidth) return;
//            mLastDisplayWidth = displayWidth;
//        }
//        if (currentKeyboard != null) {
//            // Configuration changes can happen after the keyboard gets recreated,
//            // so we need to be able to re-build the keyboards if the available
//            // space has changed.
//            int displayWidth = getMaxWidth();
//            if (displayWidth == mLastDisplayWidth) return;
//            mLastDisplayWidth = displayWidth;
//        }

        if (BaseConfig.readNameDevice(getApplicationContext()).equals("mobile")) {
            mQwertyKeyboard = new LatinKeyboard(this, R.xml.qwerty);
            mSymbolsKeyboard = new LatinKeyboard(this, R.xml.symbols);
            mSymbolsShiftedKeyboard = new LatinKeyboard(this, R.xml.symbols_shift);
            mQwertyEmoji = new LatinKeyboard(this, R.xml.one_emoji);
            mQwertySelectTwoDot = new LatinKeyboard(this, R.xml.select_two_dot);
            mQwertyTwo = new LatinKeyboard(this, R.xml.two_qwerty);
            mQwertyTwoSelectOneDot = new LatinKeyboard(this, R.xml.two_select_one_dot);
            mQwertyThree = new LatinKeyboard(this, R.xml.three_qwerty);
            mQwertyThreeSelectOneDot = new LatinKeyboard(this, R.xml.three_select_one_dot);
            mQwertyFour = new LatinKeyboard(this, R.xml.four_qwerty);
            mQwertyFourSelectOneDot = new LatinKeyboard(this, R.xml.four_qwerty_select_one_dot);
            mQwertyNumber = new LatinKeyboard(this, R.xml.qwerty_number);
            mQwertyNumberTwo = new LatinKeyboard(this, R.xml.qwerty_number_two);
            mQwertyNumberThree = new LatinKeyboard(this, R.xml.qwerty_number_three);
        }else {
            mQwertyKeyboard = new LatinKeyboard(this, R.xml.qwerty_ipad);
            mSymbolsKeyboard = new LatinKeyboard(this, R.xml.symbols);
            mSymbolsShiftedKeyboard = new LatinKeyboard(this, R.xml.symbols_shift);
            mQwertyEmoji = new LatinKeyboard(this, R.xml.one_emoji_ipad);
            mQwertySelectTwoDot = new LatinKeyboard(this, R.xml.select_two_dot_ipad);
            mQwertyTwo = new LatinKeyboard(this, R.xml.two_qwerty_ipad);
            mQwertyTwoSelectOneDot = new LatinKeyboard(this, R.xml.two_select_one_dot_ipad);
            mQwertyThree = new LatinKeyboard(this, R.xml.three_qwerty_ipad);
            mQwertyThreeSelectOneDot = new LatinKeyboard(this, R.xml.three_select_one_dot_ipad);
            mQwertyFour = new LatinKeyboard(this, R.xml.four_qwerty_ipad);
            mQwertyFourSelectOneDot = new LatinKeyboard(this, R.xml.four_qwerty_select_one_dot_ipad);
            mQwertyNumber = new LatinKeyboard(this, R.xml.qwerty_number_ipad);
            mQwertyNumberTwo = new LatinKeyboard(this, R.xml.qwerty_number_two_ipad);
            mQwertyNumberThree = new LatinKeyboard(this, R.xml.qwerty_number_three_ipad);
        }

    }

    /**
     * Called by the framework when your view for creating input needs to
     * be generated.  This will be called the first time your input method
     * is displayed, and every time it needs to be re-created such as due to
     * a configuration change.
     */
    @Override
    public View onCreateInputView() {
        myKeyboardView = getLayoutInflater().inflate(R.layout.input, null);
        mInputView = myKeyboardView.findViewById(R.id.keyboard);
        layoutSuggest = myKeyboardView.findViewById(R.id.layoutSuggest);
        layoutSuggestOne = myKeyboardView.findViewById(R.id.layoutSuggestOne);
        layoutSuggestTwo = myKeyboardView.findViewById(R.id.layoutSuggestTwo);
        layoutSuggestThree = myKeyboardView.findViewById(R.id.layoutSuggestThree);
        viewSuggestOne = myKeyboardView.findViewById(R.id.viewSuggestOne);
        viewSuggestTwo = myKeyboardView.findViewById(R.id.viewSuggestTwo);
        textSuggestOne = myKeyboardView.findViewById(R.id.textSuggestOne);
        textSuggestTwo = myKeyboardView.findViewById(R.id.textSuggestTwo);
        textSuggestThree = myKeyboardView.findViewById(R.id.textSuggestThree);
        viewBlur= myKeyboardView.findViewById(R.id.viewBlur);
        mInputView.setOnKeyboardActionListener(this);
        if (currentKeyboard == null){
            mInputView.setKeyboard(mQwertyKeyboard);
            currentKeyboard = mQwertyKeyboard;
        }else {
            if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyKeyboard.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyKeyboard);
                currentKeyboard = mQwertyKeyboard;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyEmoji.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyEmoji);
                currentKeyboard = mQwertyEmoji;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertySelectTwoDot.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertySelectTwoDot);
                currentKeyboard = mQwertySelectTwoDot;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyTwo.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyTwo);
                currentKeyboard = mQwertyTwo;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyTwoSelectOneDot.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyTwoSelectOneDot);
                currentKeyboard = mQwertyTwoSelectOneDot;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyThree.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyThree);
                currentKeyboard = mQwertyThree;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyThreeSelectOneDot.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyThreeSelectOneDot );
                currentKeyboard = mQwertyThreeSelectOneDot;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyFour.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyFour);
                currentKeyboard = mQwertyFour;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyFourSelectOneDot.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyFourSelectOneDot);
                currentKeyboard = mQwertyFourSelectOneDot;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyNumber.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyNumber);
                currentKeyboard = mQwertyNumber;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyNumberTwo.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyNumberTwo);
                currentKeyboard = mQwertyNumberTwo;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyNumberThree.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyNumberThree);
                currentKeyboard = mQwertyNumberThree;
            }
        }
//        mInputView.setKeyboard(mQwertyKeyboard);
        mInputView.setPreviewEnabled(false);
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mPopupKeyboard = new PopupWindow(getApplicationContext());
        mPopupKeyboard.setContentView(inflater.inflate(R.layout.popup_click, null));
        mInputView.passDataLongPress(this);
        mInputView.setPassEventKeyboard(this);
        mInputView.setCheckDataLongPress(this);
        mInputView.setPassDataLongPressOneCharator(this);
        mInputView.setDismissPopupLongPress(this);
        mInputView.setDismissGrayWithButtonDotAndTwoDot(this);
        return myKeyboardView;

    }

    @Override
    public void onComputeInsets(Insets outInsets) {
        super.onComputeInsets(outInsets);
        outInsets.contentTopInsets = outInsets.visibleTopInsets;
    }

    /**
     * Called by the framework when your view for showing candidates needs to
     * be generated, like {@link #onCreateInputView}.
     */

    @Override
    public View onCreateCandidatesView() {
        mCandidateView = new CandidateView(this);
//        mCandidateView.setService(this);
        return null;
    }


    /**
     * This is the main point where we do our initialization of the input method
     * to begin operating on an application.  At this point we have been
     * bound to the client, and are now receiving all of the detailed information
     * about the target of our edits.
     */
    @Override
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        super.onStartInput(attribute, restarting);

        // Reset our state.  We want to do this even if restarting, because
        // the underlying state of the text editor could have changed in any way.
        mComposing.setLength(0);
        updateCandidates();

        if (!restarting) {
            // Clear shift states.
            mMetaState = 0;
        }

        mPredictionOn = false;
        mCompletionOn = false;
        mCompletions = null;

        // We are now going to initialize our state based on the type of
        // text being edited.
        switch (attribute.inputType & InputType.TYPE_MASK_CLASS) {
            case InputType.TYPE_CLASS_NUMBER:
            case InputType.TYPE_CLASS_DATETIME:
                // Numbers and dates default to the symbols keyboard, with
                // no extra features.
                mCurKeyboard = mSymbolsKeyboard;
                break;

            case InputType.TYPE_CLASS_PHONE:
                // Phones will also default to the symbols keyboard, though
                // often you will want to have a dedicated phone keyboard.
                mCurKeyboard = mSymbolsKeyboard;
                break;

            case InputType.TYPE_CLASS_TEXT:
                // This is general text editing.  We will default to the
                // normal alphabetic keyboard, and assume that we should
                // be doing predictive text (showing candidates as the
                // user types).
//                mCurKeyboard =  mQwertyKeyboard;
                if (currentKeyboard == null){
//                    mInputView.setKeyboard(mQwertyKeyboard);
                    mCurKeyboard = mQwertyKeyboard;
                }else {
                    if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyKeyboard.getKeys().get(0).codes[0]){
//                        mInputView.setKeyboard(mQwertyKeyboard);
                        mCurKeyboard = mQwertyKeyboard;
                    }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyEmoji.getKeys().get(0).codes[0]){
//                        mInputView.setKeyboard(mQwertyEmoji);
                        mCurKeyboard = mQwertyEmoji;
                    }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertySelectTwoDot.getKeys().get(0).codes[0]){
//                        mInputView.setKeyboard(mQwertySelectTwoDot);
                        mCurKeyboard = mQwertySelectTwoDot;
                    }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyTwo.getKeys().get(0).codes[0]){
//                        mInputView.setKeyboard(mQwertyTwo);
                        mCurKeyboard = mQwertyTwo;
                    }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyTwoSelectOneDot.getKeys().get(0).codes[0]){
//                        mInputView.setKeyboard(mQwertyTwoSelectOneDot);
                        mCurKeyboard = mQwertyTwoSelectOneDot;
                    }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyThree.getKeys().get(0).codes[0]){
//                        mInputView.setKeyboard(mQwertyThree);
                        mCurKeyboard = mQwertyThree;
                    }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyThreeSelectOneDot.getKeys().get(0).codes[0]){
//                        mInputView.setKeyboard(mQwertyThreeSelectOneDot );
                        mCurKeyboard = mQwertyThreeSelectOneDot;
                    }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyFour.getKeys().get(0).codes[0]){
//                        mInputView.setKeyboard(mQwertyFour);
                        mCurKeyboard = mQwertyFour;
                    }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyFourSelectOneDot.getKeys().get(0).codes[0]){
//                        mInputView.setKeyboard(mQwertyFourSelectOneDot);
                        mCurKeyboard = mQwertyFourSelectOneDot;
                    }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyNumber.getKeys().get(0).codes[0]){
//                        mInputView.setKeyboard(mQwertyNumber);
                        mCurKeyboard = mQwertyNumber;
                    }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyNumberTwo.getKeys().get(0).codes[0]){
//                        mInputView.setKeyboard(mQwertyNumberTwo);
                        mCurKeyboard = mQwertyNumberTwo;
                    }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyNumberThree.getKeys().get(0).codes[0]){
//                        mInputView.setKeyboard(mQwertyNumberThree);
                        mCurKeyboard = mQwertyNumberThree;
                    }
                }

                mPredictionOn = true;

                // We now look for a few special variations of text that will
                // modify our behavior.
                int variation = attribute.inputType & InputType.TYPE_MASK_VARIATION;
                if (variation == InputType.TYPE_TEXT_VARIATION_PASSWORD ||
                        variation == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    // Do not display predictions / what the user is typing
                    // when they are entering a password.
                    mPredictionOn = false;
                }

                if (variation == InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                        || variation == InputType.TYPE_TEXT_VARIATION_URI
                        || variation == InputType.TYPE_TEXT_VARIATION_FILTER) {
                    // Our predictions are not useful for e-mail addresses
                    // or URIs.
                    mPredictionOn = false;
                }

                if ((attribute.inputType & InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE) != 0) {
                    // If this is an auto-complete text view, then our predictions
                    // will not be shown and instead we will allow the editor
                    // to supply their own.  We only show the editor's
                    // candidates when in fullscreen mode, otherwise relying
                    // own it displaying its own UI.
                    mPredictionOn = false;
                    mCompletionOn = isFullscreenMode();
                }

                // We also want to look at the current state of the editor
                // to decide whether our alphabetic keyboard should start out
                // shifted.
                updateShiftKeyState(attribute);
                break;

            default:
                // For all unknown input types, default to the alphabetic
                // keyboard with no special features.
//                mCurKeyboard = mQwertyKeyboard;
                updateShiftKeyState(attribute);
        }

        // Update the label on the enter key, depending on what the application
        // says it will do.
        mCurKeyboard.setImeOptions(getResources(), attribute.imeOptions);
        textEditText = "";
        count = 0;

    }

    /**
     * This is called when the user is done editing a field.  We can use
     * this to reset our state.
     */
    @Override
    public void onFinishInput() {
        super.onFinishInput();

        // Clear current composing text and candidates.
        mComposing.setLength(0);
        updateCandidates();

        // We only hide the candidates window when finishing input on
        // a particular editor, to avoid popping the underlying application
        // up and down if the user is entering text into the bottom of
        // its window.
//        setCandidatesViewShown(false);

//        mCurKeyboard = mQwertyKeyboard;
        if (mInputView != null) {
            mInputView.closing();
        }
    }

    @Override
    public void onStartInputView(EditorInfo attribute, boolean restarting) {
        super.onStartInputView(attribute, restarting);
        if (currentKeyboard == null){
            mInputView.setKeyboard(mQwertyKeyboard);
            currentKeyboard = mQwertyKeyboard;
        }else {
            if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyKeyboard.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyKeyboard);
                currentKeyboard = mQwertyKeyboard;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyEmoji.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyEmoji);
                currentKeyboard = mQwertyEmoji;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertySelectTwoDot.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertySelectTwoDot);
                currentKeyboard = mQwertySelectTwoDot;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyTwo.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyTwo);
                currentKeyboard = mQwertyTwo;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyTwoSelectOneDot.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyTwoSelectOneDot);
                currentKeyboard = mQwertyTwoSelectOneDot;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyThree.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyThree);
                currentKeyboard = mQwertyThree;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyThreeSelectOneDot.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyThreeSelectOneDot );
                currentKeyboard = mQwertyThreeSelectOneDot;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyFour.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyFour);
                currentKeyboard = mQwertyFour;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyFourSelectOneDot.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyFourSelectOneDot);
                currentKeyboard = mQwertyFourSelectOneDot;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyNumber.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyNumber);
                currentKeyboard = mQwertyNumber;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyNumberTwo.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyNumberTwo);
                currentKeyboard = mQwertyNumberTwo;
            }else if (currentKeyboard.getKeys().get(0).codes[0] == mQwertyNumberThree.getKeys().get(0).codes[0]){
                mInputView.setKeyboard(mQwertyNumberThree);
                currentKeyboard = mQwertyNumberThree;
            }
        }
        mInputView.closing();
        final InputMethodSubtype subtype = mInputMethodManager.getCurrentInputMethodSubtype();
        mInputView.setSubtypeOnSpaceKey(subtype);
        textEditText = "";
        count = 0;
        layoutSuggestOne.setOnClickListener(this);
        layoutSuggestTwo.setOnClickListener(this);
        layoutSuggestThree.setOnClickListener(this);
        getWindow().getWindow().setNavigationBarColor(getResources().getColor(R.color.background_keyboard));
        getWindow().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);

    }

    @Override
    public void onCurrentInputMethodSubtypeChanged(InputMethodSubtype subtype) {
        mInputView.setSubtypeOnSpaceKey(subtype);
    }


    /**
     * Deal with the editor reporting movement of its cursor.
     */
    @Override
    public void onUpdateSelection(int oldSelStart, int oldSelEnd,
                                  int newSelStart, int newSelEnd,
                                  int candidatesStart, int candidatesEnd) {
        super.onUpdateSelection(oldSelStart, oldSelEnd, newSelStart, newSelEnd,
                candidatesStart, candidatesEnd);

        // If the current selection in the text view changes, we should
        // clear whatever candidate text we have.
        if (mComposing.length() > 0 && (newSelStart != candidatesEnd
                || newSelEnd != candidatesEnd)) {
            mComposing.setLength(0);
            updateCandidates();
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) {
                ic.finishComposingText();
            }
        }
    }

    @Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        super.dump(fd, fout, args);
        Log.d("TAG", "dump: ");
    }

    /**
     * This tells us about completions that the editor has determined based
     * on the current text in it.  We want to use this in fullscreen mode
     * to show the completions ourself, since the editor can not be seen
     * in that situation.
     */
    @Override
    public void onDisplayCompletions(CompletionInfo[] completions) {
        if (mCompletionOn) {
            mCompletions = completions;
            if (completions == null) {
                setSuggestions(null, false, false);
                return;
            }

            List<String> stringList = new ArrayList<String>();
            for (int i = 0; i < completions.length; i++) {
                CompletionInfo ci = completions[i];
                if (ci != null) stringList.add(ci.getText().toString());
            }
            setSuggestions(stringList, true, true);
        }
    }

    /**
     * This translates incoming hard key events in to edit operations on an
     * InputConnection.  It is only needed when using the
     * PROCESS_HARD_KEYS option.
     */
    private boolean translateKeyDown(int keyCode, KeyEvent event) {
        mMetaState = MetaKeyKeyListener.handleKeyDown(mMetaState,
                keyCode, event);
        int c = event.getUnicodeChar(MetaKeyKeyListener.getMetaState(mMetaState));
        mMetaState = MetaKeyKeyListener.adjustMetaAfterKeypress(mMetaState);
        InputConnection ic = getCurrentInputConnection();
        if (c == 0 || ic == null) {
            return false;
        }

        boolean dead = false;

        if ((c & KeyCharacterMap.COMBINING_ACCENT) != 0) {
            dead = true;
            c = c & KeyCharacterMap.COMBINING_ACCENT_MASK;
        }

        if (mComposing.length() > 0) {
            char accent = mComposing.charAt(mComposing.length() - 1);
            int composed = KeyEvent.getDeadChar(accent, c);

            if (composed != 0) {
                c = composed;
                mComposing.setLength(mComposing.length() - 1);
            }
        }

        onKey(c, null);

        return true;
    }

    /**
     * Use this to monitor key events being delivered to the application.
     * We get first crack at them, and can either resume them or let them
     * continue to the app.
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        mInputView.dismissPopup();
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                // The InputMethodService already takes care of the back
                // key for us, to dismiss the input method if it is shown.
                // However, our keyboard could be showing a pop-up window
                // that back should dismiss, so we first allow it to do that.
                if (event.getRepeatCount() == 0 && mInputView != null) {
                    if (mInputView.handleBack()) {
                        return true;
                    }
                }
                break;

            case KeyEvent.KEYCODE_DEL:
                // Special handling of the delete key: if we currently are
                // composing text for the user, we want to modify that instead
                // of let the application to the delete itself.
                if (mComposing.length() > 0) {
                    onKey(Keyboard.KEYCODE_DELETE, null);
                    return true;
                }
                break;

            case KeyEvent.KEYCODE_ENTER:
                // Let the underlying text editor always handle these.
                return false;

            default:
                // For all other keys, if we want to do transformations on
                // text being entered with a hard keyboard, we need to process
                // it and do the appropriate action.
                if (PROCESS_HARD_KEYS) {
                    if (keyCode == KeyEvent.KEYCODE_SPACE && (event.getMetaState() & KeyEvent.META_ALT_ON) != 0) {
                        // A silly example: in our input method, Alt+Space
                        // is a shortcut for 'android' in lower case.
                        InputConnection ic = getCurrentInputConnection();
                        if (ic != null) {
                            // First, tell the editor that it is no longer in the
                            // shift state, since we are consuming this.
                            ic.clearMetaKeyStates(KeyEvent.META_ALT_ON);
                            keyDownUp(KeyEvent.KEYCODE_A);
                            keyDownUp(KeyEvent.KEYCODE_N);
                            keyDownUp(KeyEvent.KEYCODE_D);
                            keyDownUp(KeyEvent.KEYCODE_R);
                            keyDownUp(KeyEvent.KEYCODE_O);
                            keyDownUp(KeyEvent.KEYCODE_I);
                            keyDownUp(KeyEvent.KEYCODE_D);
                            // And we consume this event.
                            return true;
                        }
                    }
                    if (mPredictionOn && translateKeyDown(keyCode, event)) {
                        return true;
                    }
                }
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * Use this to monitor key events being delivered to the application.
     * We get first crack at them, and can either resume them or let them
     * continue to the app.
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // If we want to do transformations on text being entered with a hard
        // keyboard, we need to process the up events to update the meta key
        // state we are tracking.
        if (PROCESS_HARD_KEYS) {
            if (mPredictionOn) {
                mMetaState = MetaKeyKeyListener.handleKeyUp(mMetaState,
                        keyCode, event);
            }
        }

        return super.onKeyUp(keyCode, event);
    }

    /**
     * Helper function to commit any text being composed in to the editor.
     */
    private void commitTyped(InputConnection inputConnection) {
        if (mComposing.length() > 0) {
            inputConnection.commitText(mComposing, mComposing.length());
            mComposing.setLength(0);
            updateCandidates();
        }
    }

    /**
     * Helper to update the shift state of our keyboard based on the initial
     * editor state.
     */
    private void updateShiftKeyState(EditorInfo attr) {
//        if (attr != null
//                && mInputView != null && mQwertyKeyboard == mInputView.getKeyboard()) {
//            int caps = 0;
//            EditorInfo ei = getCurrentInputEditorInfo();
//            if (ei != null && ei.inputType != InputType.TYPE_NULL) {
//                caps = getCurrentInputConnection().getCursorCapsMode(attr.inputType);
//            }
//            mInputView.setShifted(mCapsLock || caps != 0);
//        }
    }

    /**
     * Helper to determine if a given character code is alphabetic.
     */
    private boolean isAlphabet(int code) {
        if (Character.isLetter(code)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Helper to send a key down / key up pair to the current editor.
     */
    private void keyDownUp(int keyEventCode) {
        getCurrentInputConnection().sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, keyEventCode));
        getCurrentInputConnection().sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, keyEventCode));
    }

    /**
     * Helper to send a character to the editor as raw key events.
     */
    private void sendKey(int keyCode) {
        switch (keyCode) {
            case '\n':
                keyDownUp(KeyEvent.KEYCODE_ENTER);
                break;
            default:
                if (keyCode >= '0' && keyCode <= '9') {
                    keyDownUp(keyCode - '0' + KeyEvent.KEYCODE_0);
                } else {
                    if (keyCode >= '0' && keyCode <= '9') {
                        keyDownUp(keyCode - '0' + KeyEvent.KEYCODE_0);
                    } else {
                        getCurrentInputConnection().commitText(String.valueOf((char) keyCode), 1);
                        if (BaseConfig.readLastButtonPressed(getApplicationContext())) {
                            int count = 0;
                            ArrayList<String> arrayList = new ArrayList<>();
                            if (BaseConfig.getListFromLocal(getApplicationContext()) != null) {
                                for (String key : BaseConfig.getListFromLocal(getApplicationContext())) {
                                    if (key.equals(textEditText)) {
                                        count++;
                                    }
                                }
                                if (count < 2) {
                                    if (BaseConfig.getListFromLocal(getApplicationContext()) != null) {
                                        arrayList = BaseConfig.getListFromLocal(getApplicationContext());
                                    }
                                    arrayList.add(textEditText);
                                    BaseConfig.saveListInLocal(arrayList, getApplicationContext());
                                } else if (count == 2) {
                                    if (BaseConfig.getListSuggestion(getApplicationContext()) != null) {
                                        arrayList = BaseConfig.getListSuggestion(getApplicationContext());
                                    }
                                    arrayList.add(0, textEditText);
                                    BaseConfig.saveListSuggestion(arrayList, getApplicationContext());
                                }
                            } else {
                                arrayList.add(textEditText);
                                BaseConfig.saveListInLocal(arrayList, getApplicationContext());
                            }

                        }
                        count = 0;
                        textEditText = "";
                    }
                }
                break;
        }
    }

    public void onKey(int primaryCode, int[] keyCodes) {
        if (isWordSeparator(primaryCode)) {
            // Handle separator
//            if (mComposing.length() > 0) {
//                commitTyped(getCurrentInputConnection());
//            }
//            commitTyped(getCurrentInputConnection());
            sendKey(primaryCode);
//            updateShiftKeyState(getCurrentInputEditorInfo());
        } else if (primaryCode == Keyboard.KEYCODE_DELETE) {
            handleBackspace();
        } else if (primaryCode == Keyboard.KEYCODE_SHIFT) {
            currentKeyboard = mQwertyThree;
            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == Keyboard.KEYCODE_CANCEL) {
            currentKeyboard = mQwertyFour;
            mInputView.setKeyboard(currentKeyboard);
//            handleClose();
//            return;
        } else if (primaryCode == LatinKeyboardView.KEYCODE_OPTIONS) {
            // Show a menu or somethin'
        } else if (primaryCode == Keyboard.KEYCODE_MODE_CHANGE && mInputView != null) {
            currentKeyboard = mQwertyNumber;
            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == 97) {
            currentKeyboard = mQwertyTwo;
            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == 106) {
//            if (textEditText.length() !=0 || !textEditText.equals("")){
                getCurrentInputConnection().sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_LEFT));
                getCurrentInputConnection().sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_LEFT));
//            }
        } else if (primaryCode == 107) {
//            if (textEditText.length() !=0 || !textEditText.equals("")){
                getCurrentInputConnection().sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_RIGHT));
                getCurrentInputConnection().sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_RIGHT));
//            }
        } else if (primaryCode == 113 || primaryCode == 2000 || primaryCode == 3000 ||
                primaryCode == 5000 || primaryCode == 4000 || primaryCode == 1000 ||
                primaryCode == 5020 || primaryCode == 5030 || primaryCode == 2050 ||
                primaryCode == 1050 || primaryCode == 3050 || primaryCode == 4050) {
            currentKeyboard = mQwertyKeyboard;
            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -10) {
            currentKeyboard = mQwertyEmoji;
            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -11) {
            currentKeyboard = mQwertySelectTwoDot;
            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -15) {
            currentKeyboard = mQwertyKeyboard;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -16) {
            currentKeyboard = mQwertySelectTwoDot;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -20) {
            currentKeyboard = mQwertyTwoSelectOneDot;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -21) {
            currentKeyboard = mQwertySelectTwoDot;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -25) {
            currentKeyboard = mQwertyTwo;
            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -26) {
            currentKeyboard = mQwertySelectTwoDot;
            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -30) {
            currentKeyboard = mQwertyThreeSelectOneDot;
            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -31) {
            currentKeyboard = mQwertySelectTwoDot;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -35) {
            currentKeyboard = mQwertyThree;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -36) {
            currentKeyboard = mQwertySelectTwoDot;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -40) {
            currentKeyboard = mQwertyFourSelectOneDot;
            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -41) {
            currentKeyboard = mQwertySelectTwoDot;
            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -45) {
            currentKeyboard = mQwertyFour;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -46) {
            currentKeyboard = mQwertySelectTwoDot;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -50) {
            currentKeyboard = mQwertyNumberTwo;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -51) {
            currentKeyboard = mQwertyNumberThree;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -52) {
            currentKeyboard = mQwertyNumber;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -53) {
            currentKeyboard = mQwertyNumberThree;
            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -54) {
            currentKeyboard = mQwertyNumberTwo;

            mInputView.setKeyboard(currentKeyboard);
        } else if (primaryCode == -55) {
            currentKeyboard = mQwertyNumber;

            mInputView.setKeyboard(currentKeyboard);
        } else {
            handleCharacter(primaryCode, keyCodes);
        }
    }

    public void onText(CharSequence text) {
        InputConnection ic = getCurrentInputConnection();
        if (ic == null) return;
        ic.beginBatchEdit();
        if (mComposing.length() > 0) {
            commitTyped(ic);
        }
        ic.commitText(text, 0);
        ic.getSelectedText(2);
        ic.endBatchEdit();
//        updateShiftKeyState(getCurrentInputEditorInfo());
        textSuggestOne.setText("");
        textSuggestThree.setText("");
        textSuggestTwo.setText("");
        textEditText = textEditText + text;
        count++;

        if (BaseConfig.readLastButtonPressed(getApplicationContext())) {
            for (int l = 0; l < BaseConfig.getListSuggestion(getApplicationContext()).size(); l++) {
                if (textSuggestOne.getText().toString().equals("")) {
                    if (BaseConfig.getListSuggestion(getApplicationContext()).get(l).contains(textEditText)) {
                        textSuggestOne.setText(BaseConfig.getListSuggestion(getApplicationContext()).get(l));
                        layoutSuggest.setVisibility(View.VISIBLE);
                        layoutSuggestThree.setVisibility(View.VISIBLE);
                        layoutSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestOne.setVisibility(View.VISIBLE);
                    }
                } else if (textSuggestTwo.getText().toString().equals("")) {
                    if (BaseConfig.getListSuggestion(getApplicationContext()).get(l).contains(textEditText)) {
                        textSuggestTwo.setText(BaseConfig.getListSuggestion(getApplicationContext()).get(l));
                        layoutSuggestThree.setVisibility(View.VISIBLE);
                        layoutSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestOne.setVisibility(View.VISIBLE);
                    }
                } else if (textSuggestThree.getText().toString().equals("")) {
                    if (BaseConfig.getListSuggestion(getApplicationContext()).get(l).contains(textEditText)) {
                        textSuggestThree.setText(BaseConfig.getListSuggestion(getApplicationContext()).get(l));
                        layoutSuggestThree.setVisibility(View.VISIBLE);
                        viewSuggestTwo.setVisibility(View.VISIBLE);
                    }
                }
            }
        } else {
            for (int l = 0; l < Utils.list.length; l++) {
                if (textSuggestOne.getText().toString().equals("")) {
                    if (Utils.list[l].contains(textEditText)) {
                        textSuggestOne.setText(Utils.list[l]);
                        layoutSuggest.setVisibility(View.VISIBLE);
                        layoutSuggestThree.setVisibility(View.VISIBLE);
                        layoutSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestOne.setVisibility(View.VISIBLE);
                    }
                } else if (textSuggestTwo.getText().toString().equals("")) {
                    if (Utils.list[l].contains(textEditText)) {
                        textSuggestTwo.setText(Utils.list[l]);
                        layoutSuggestThree.setVisibility(View.VISIBLE);
                        layoutSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestOne.setVisibility(View.VISIBLE);
                    }
                } else if (textSuggestThree.getText().toString().equals("")) {
                    if (Utils.list[l].contains(textEditText)) {
                        textSuggestThree.setText(Utils.list[l]);
                        layoutSuggestThree.setVisibility(View.VISIBLE);
                        viewSuggestTwo.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
        if (textSuggestOne.getText().toString().equals("")) {
            layoutSuggest.setVisibility(View.GONE);
        } else if (textSuggestTwo.getText().toString().equals("")) {
            layoutSuggestThree.setVisibility(View.GONE);
            layoutSuggestTwo.setVisibility(View.GONE);
            viewSuggestTwo.setVisibility(View.GONE);
            viewSuggestOne.setVisibility(View.GONE);
        } else if (textSuggestThree.getText().toString().equals("")) {
            layoutSuggestThree.setVisibility(View.GONE);
            viewSuggestTwo.setVisibility(View.GONE);
        }

    }


    private void updateCandidates() {
        if (!mCompletionOn) {
            if (mComposing.length() > 0) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(mComposing.toString());
                setSuggestions(list, true, true);
            } else {
                setSuggestions(null, false, false);
            }
        }
    }

    public void setSuggestions(List<String> suggestions, boolean completions,
                               boolean typedWordValid) {
        if (suggestions != null && suggestions.size() > 0) {
            setCandidatesViewShown(true);
        } else if (isExtractViewShown()) {
            setCandidatesViewShown(true);
        }
        if (mCandidateView != null) {
//            mCandidateView.setSuggestions(suggestions, completions, typedWordValid);
        }
    }

    private void handleBackspace() {
        Log.d("sonth", "handleBackspace:" + "delete");
//        final int length = mComposing.length();
//        if (length > 1) {
//            mComposing.delete(length - 1, length);
//            getCurrentInputConnection().setComposingText(mComposing, 1);
//            updateCandidates();
//        } else if (length > 0) {
//            mComposing.setLength(0);
//            getCurrentInputConnection().commitText("", 0);
//            updateCandidates();
//        } else {
//            keyDownUp(KeyEvent.KEYCODE_DEL);
//        }
        keyDownUp(KeyEvent.KEYCODE_DEL);
        if (count > 0) {
            count--;
        }

        textSuggestOne.setText("");
        textSuggestThree.setText("");
        textSuggestTwo.setText("");
        if (textEditText.length() != 0){
            textEditText = textEditText.substring(0,textEditText.length() -1);
        }

        if (BaseConfig.readLastButtonPressed(getApplicationContext())) {
            for (int l = 0; l < BaseConfig.getListSuggestion(getApplicationContext()).size(); l++) {
                if (textSuggestOne.getText().toString().equals("")) {
                    if (BaseConfig.getListSuggestion(getApplicationContext()).get(l).contains(textEditText)) {
                        textSuggestOne.setText(BaseConfig.getListSuggestion(getApplicationContext()).get(l));
                        layoutSuggest.setVisibility(View.VISIBLE);
                        layoutSuggestThree.setVisibility(View.VISIBLE);
                        layoutSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestOne.setVisibility(View.VISIBLE);
                    }
                } else if (textSuggestTwo.getText().toString().equals("")) {
                    if (BaseConfig.getListSuggestion(getApplicationContext()).get(l).contains(textEditText)) {
                        textSuggestTwo.setText(BaseConfig.getListSuggestion(getApplicationContext()).get(l));
                        layoutSuggestThree.setVisibility(View.VISIBLE);
                        layoutSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestOne.setVisibility(View.VISIBLE);
                    }
                } else if (textSuggestThree.getText().toString().equals("")) {
                    if (BaseConfig.getListSuggestion(getApplicationContext()).get(l).contains(textEditText)) {
                        textSuggestThree.setText(BaseConfig.getListSuggestion(getApplicationContext()).get(l));
                        layoutSuggestThree.setVisibility(View.VISIBLE);
                        viewSuggestTwo.setVisibility(View.VISIBLE);
                    }
                }
            }
        } else {
            for (int l = 0; l < Utils.list.length; l++) {
                if (textSuggestOne.getText().toString().equals("")) {
                    if (Utils.list[l].contains(textEditText)) {
                        textSuggestOne.setText(Utils.list[l]);
                        layoutSuggest.setVisibility(View.VISIBLE);
                        layoutSuggestThree.setVisibility(View.VISIBLE);
                        layoutSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestOne.setVisibility(View.VISIBLE);
                    }
                } else if (textSuggestTwo.getText().toString().equals("")) {
                    if (Utils.list[l].contains(textEditText)) {
                        textSuggestTwo.setText(Utils.list[l]);
                        layoutSuggestThree.setVisibility(View.VISIBLE);
                        layoutSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestTwo.setVisibility(View.VISIBLE);
                        viewSuggestOne.setVisibility(View.VISIBLE);
                    }
                } else if (textSuggestThree.getText().toString().equals("")) {
                    if (Utils.list[l].contains(textEditText)) {
                        textSuggestThree.setText(Utils.list[l]);
                        layoutSuggestThree.setVisibility(View.VISIBLE);
                        viewSuggestTwo.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
        if (textSuggestOne.getText().toString().equals("") || count == 0) {
            layoutSuggest.setVisibility(View.GONE);
        } else if (textSuggestTwo.getText().toString().equals("")) {
            layoutSuggestThree.setVisibility(View.GONE);
            layoutSuggestTwo.setVisibility(View.GONE);
            viewSuggestTwo.setVisibility(View.GONE);
            viewSuggestOne.setVisibility(View.GONE);
        } else if (textSuggestThree.getText().toString().equals("")) {
            layoutSuggestThree.setVisibility(View.GONE);
            viewSuggestTwo.setVisibility(View.GONE);
        }
//        updateShiftKeyState(getCurrentInputEditorInfo());
    }

//    private void handleShift() {
//        if (mInputView == null) {
//            return;
//        }
//
//        Keyboard currentKeyboard = mInputView.getKeyboard();
//        if (mQwertyKeyboard == currentKeyboard) {
//            // Alphabet keyboard
//            checkToggleCapsLock();
//            mInputView.setShifted(mCapsLock || !mInputView.isShifted());
//        } else if (currentKeyboard == mSymbolsKeyboard) {
//            mSymbolsKeyboard.setShifted(true);
//            mInputView.setKeyboard(mSymbolsShiftedKeyboard);
//            mSymbolsShiftedKeyboard.setShifted(true);
//        } else if (currentKeyboard == mSymbolsShiftedKeyboard) {
//            mSymbolsShiftedKeyboard.setShifted(false);
//            mInputView.setKeyboard(mSymbolsKeyboard);
//            mSymbolsKeyboard.setShifted(false);
//        }
//    }

    private void handleCharacter(int primaryCode, int[] keyCodes) {
        if (isInputViewShown()) {
            if (mInputView.isShifted()) {
                primaryCode = Character.toUpperCase(primaryCode);
            }
        }
        if (isAlphabet(primaryCode) && mPredictionOn) {
            mComposing.append((char) primaryCode);
            getCurrentInputConnection().setComposingText(mComposing, 1);
            updateShiftKeyState(getCurrentInputEditorInfo());
            updateCandidates();
        } else {
            getCurrentInputConnection().commitText(String.valueOf((char) primaryCode), 1);
        }
    }

    private void handleClose() {
        commitTyped(getCurrentInputConnection());
        requestHideSelf(0);
        mInputView.closing();
    }

    private void checkToggleCapsLock() {
        long now = System.currentTimeMillis();
        if (mLastShiftTime + 800 > now) {
            mCapsLock = !mCapsLock;
            mLastShiftTime = 0;
        } else {
            mLastShiftTime = now;
        }
    }

    private String getWordSeparators() {
        return mWordSeparators;
    }

    public boolean isWordSeparator(int code) {
        String separators = getWordSeparators();
        return separators.contains(String.valueOf((char) code));
    }

    public void pickDefaultCandidate() {
        pickSuggestionManually(0);
    }

    public void pickSuggestionManually(int index) {
        if (mCompletionOn && mCompletions != null && index >= 0
                && index < mCompletions.length) {
            CompletionInfo ci = mCompletions[index];
            getCurrentInputConnection().commitCompletion(ci);
            if (mCandidateView != null) {
                mCandidateView.clear();
            }
            updateShiftKeyState(getCurrentInputEditorInfo());
        } else if (mComposing.length() > 0) {
            // If we were generating candidate suggestions for the current
            // text, we would commit one of them here.  But for this sample,
            // we will just commit the current text.
            commitTyped(getCurrentInputConnection());
        }
    }

    public void swipeRight() {
        if (mCompletionOn) {
            pickDefaultCandidate();
        }
    }


    public void swipeLeft() {
        handleBackspace();
    }

    public void swipeDown() {
        handleClose();
    }

    public void swipeUp() {
    }

    public void onPress(int primaryCode) {
        mInputView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY, HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
        mInputView.dismissPopup();
        List<Keyboard.Key> keys = mInputView.getKeyboard().getKeys();
        int checkType;
        for (Keyboard.Key key : keys) {
            checkType = keys.get(0).codes[0];
            if (checkType == 113) {
                if (key.codes[0] == primaryCode) {
                    Utils.showPopupClickDefault(mInputView, mPopupKeyboard, getApplicationContext(), key,
                            mPopupKeyboard.getContentView().findViewById(R.id.tvClick));
                    break;
                }
            } else if (checkType == 1000) {
                if (key.codes[0] == primaryCode) {
                    Utils.showPopupClickEmoji(mInputView, mPopupKeyboard, getApplicationContext(), key,
                            mPopupKeyboard.getContentView().findViewById(R.id.tvClick));
                    break;
                }
            } else if (checkType == 1050) {
                if (key.codes[0] == primaryCode) {
                    Utils.showPopupClickTwoDot(mInputView, mPopupKeyboard, getApplicationContext(), key,
                            mPopupKeyboard.getContentView().findViewById(R.id.tvClick));
                    break;
                }
            } else if (checkType == 2000) {
                if (key.codes[0] == primaryCode) {
                    Utils.showPopupClickTwoQwerty(mInputView, mPopupKeyboard, getApplicationContext(), key,
                            mPopupKeyboard.getContentView().findViewById(R.id.tvClick));
                    break;
                }
            } else if (checkType == 2050) {
                if (key.codes[0] == primaryCode) {
                    Utils.showPopupClickTwoSelectOneDot(mInputView, mPopupKeyboard, getApplicationContext(), key,
                            mPopupKeyboard.getContentView().findViewById(R.id.tvClick));
                    break;
                }
            } else if (checkType == 3000) {
                if (key.codes[0] == primaryCode) {
                    Utils.showPopupClickThreeQwerty(mInputView, mPopupKeyboard, getApplicationContext(), key,
                            mPopupKeyboard.getContentView().findViewById(R.id.tvClick));
                    break;
                }
            } else if (checkType == 3050) {
                if (key.codes[0] == primaryCode) {
                    Utils.showPopupClickThreeSelectOneDot(mInputView, mPopupKeyboard, getApplicationContext(), key,
                            mPopupKeyboard.getContentView().findViewById(R.id.tvClick));
                    break;
                }
            } else if (checkType == 4000) {
                if (key.codes[0] == primaryCode) {
                    Utils.showPopupClickFourQwerty(mInputView, mPopupKeyboard, getApplicationContext(), key,
                            mPopupKeyboard.getContentView().findViewById(R.id.tvClick));
                    break;
                }
            } else if (checkType == 4050) {
                if (key.codes[0] == primaryCode) {
                    Utils.showPopupClickFourSelectOneDot(mInputView, mPopupKeyboard, getApplicationContext(), key,
                            mPopupKeyboard.getContentView().findViewById(R.id.tvClick));
                    break;
                }
            } else if (checkType == 5000) {
                if (key.codes[0] == primaryCode) {
                    Utils.showPopupClickQwertyNumber(mInputView, mPopupKeyboard, getApplicationContext(), key,
                            mPopupKeyboard.getContentView().findViewById(R.id.tvClick));
                    break;
                }
            } else if (checkType == 5020) {
                if (key.codes[0] == primaryCode) {
                    Utils.showPopupClickQwertyNumberTwo(mInputView, mPopupKeyboard, getApplicationContext(), key,
                            mPopupKeyboard.getContentView().findViewById(R.id.tvClick));
                    break;
                }
            } else if (checkType == 5030) {
                if (key.codes[0] == primaryCode) {
                    Utils.showPopupClickQwertyNumberThree(mInputView, mPopupKeyboard, getApplicationContext(), key,
                            mPopupKeyboard.getContentView().findViewById(R.id.tvClick));
                    break;
                }
            }
        }
    }

    public void onRelease(int primaryCode) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layoutSuggestOne:
//                getCurrentInputConnection().commitText(textSuggestOne.getText().toString().substring(count) + " ", 1);
                getCurrentInputConnection().deleteSurroundingText(count, 0);
                getCurrentInputConnection().commitText(textSuggestOne.getText().toString() + " ", 1);
                textEditText = "";
                count = 0;
                layoutSuggest.setVisibility(View.GONE);
                break;
            case R.id.layoutSuggestTwo:
                getCurrentInputConnection().deleteSurroundingText(count, 0);
                getCurrentInputConnection().commitText(textSuggestTwo.getText().toString() + " ", 1);
                textEditText = "";
                count = 0;
                layoutSuggest.setVisibility(View.GONE);
                break;
            case R.id.layoutSuggestThree:
                getCurrentInputConnection().deleteSurroundingText(count, 0);
                getCurrentInputConnection().commitText(textSuggestThree.getText().toString() + " ", 1);
                textEditText = "";
                count = 0;
                layoutSuggest.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            BaseConfig.saveHorizontalOrVertical("LANDSCAPE", getApplicationContext());
            Log.e("On Config Change", "LANDSCAPE");
        } else {
            BaseConfig.saveHorizontalOrVertical("PORTRAIT", getApplicationContext());
            Log.e("On Config Change", "PORTRAIT");
        }
    }

    @Override
    public void passDataLongPress(String text,boolean type) {
//        textEditText = textEditText + text;
//        count++;
        if (!type){
            getCurrentInputConnection().commitText(text, 1);
        }
        mInputView.dismissPopup();
        viewBlur.setVisibility(View.GONE);
        mInputView.setKeyboard(currentKeyboard);
        check = false;
    }

    @Override
    public void passEventKeyboard(MotionEvent me) {
        if (me.getAction() == MotionEvent.ACTION_DOWN) {

        } else if (me.getAction() == MotionEvent.ACTION_MOVE) {

        } else if (me.getAction() == MotionEvent.ACTION_UP) {
//            if (mPopupKeyboard.isShowing()) {
//                mPopupKeyboard.dismiss();
//            }
//            if (keyPress.label != null){
//                getCurrentInputConnection().commitText(keyPress.label, 1);
                handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(() -> {
                    if (mPopupKeyboard.isShowing()) {
                        mPopupKeyboard.dismiss();
                        viewBlur.setVisibility(View.GONE);
                        mInputView.setKeyboard(currentKeyboard);
                    }
                }, 100);
//            }
            check = false;
        }
    }

    @Override
    public void passDataLongPressOneCharator(String text) {
        if (!check){
            if (mPopupKeyboard.isShowing()) {
                mPopupKeyboard.dismiss();
            }
            getCurrentInputConnection().commitText(text, 1);
            viewBlur.setVisibility(View.GONE);
            mInputView.setKeyboard(currentKeyboard);
        }
    }


    @Override
    public void checkDataLongPress() {
        if (mPopupKeyboard.isShowing()) {
            mPopupKeyboard.dismiss();
        }
        viewBlur.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissPopupLongPress() {
        if (!check){
            mInputView.setKeyboard(currentKeyboard);
            viewBlur.setVisibility(View.GONE);
            check = true;
            if (mPopupKeyboard.isShowing()) {
                mPopupKeyboard.dismiss();
            }
        }
    }

    @Override
    public void dismissGrayWithButtonDotAndTwoDot() {
        mInputView.setKeyboard(currentKeyboard);
        viewBlur.setVisibility(View.GONE);
    }
}
