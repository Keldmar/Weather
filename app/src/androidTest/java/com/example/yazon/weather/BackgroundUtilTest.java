package com.example.yazon.weather;

import android.support.test.runner.AndroidJUnit4;

import com.example.yazon.weather.Adapters.BackgroundUtil;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class BackgroundUtilTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
    }
}