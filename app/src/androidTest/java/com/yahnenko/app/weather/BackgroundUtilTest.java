package com.yahnenko.app.weather;

import android.support.test.runner.AndroidJUnit4;

import com.yahnenko.app.weather.util.BackgroundUtil;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class BackgroundUtilTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(R.drawable.january, BackgroundUtil.getBackgroundByDate(1484324568L));
        assertEquals(R.drawable.bkg_02_february, BackgroundUtil.getBackgroundByDate(1487002968L));
        assertEquals(R.drawable.bkg_03_march, BackgroundUtil.getBackgroundByDate(1489422168L));
        assertEquals(R.drawable.bkg_04_april, BackgroundUtil.getBackgroundByDate(1492100568L));
        assertEquals(R.drawable.bkg_05_may, BackgroundUtil.getBackgroundByDate(1494692568L));
        assertEquals(R.drawable.bkg_06_june, BackgroundUtil.getBackgroundByDate(1497370968L));
        assertEquals(R.drawable.bkg_07_july, BackgroundUtil.getBackgroundByDate(1499892888L));
        assertEquals(R.drawable.bkg_09_september, BackgroundUtil.getBackgroundByDate(1505319768L));
        assertEquals(R.drawable.bkg_10_october, BackgroundUtil.getBackgroundByDate(1507911768L));
        assertEquals(R.drawable.bkg_11_november, BackgroundUtil.getBackgroundByDate(1510590168L));
        assertEquals(R.drawable.bkg_12_december, BackgroundUtil.getBackgroundByDate(1513182168L));
    }
}