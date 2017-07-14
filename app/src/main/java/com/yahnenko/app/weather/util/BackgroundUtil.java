package com.yahnenko.app.weather.util;

import com.yahnenko.app.weather.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BackgroundUtil {

    public static int getBackgroundByDate(Long dateLong) {
        int image;
        Date date = new Date(dateLong * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("M");
        String month = sdf.format(date);

        if (month.equals("1 ")) {
            image = R.drawable.january;
        } else {
            if (month.equals("2")) {
                image = R.drawable.bkg_02_february;
            } else {
                if (month.equals("3")) {
                    image = R.drawable.bkg_03_march;
                } else {
                    if (month.equals("4")) {
                        image = R.drawable.bkg_04_april;
                    } else {
                        if (month.equals("5")) {
                            image = R.drawable.bkg_05_may;
                        } else {
                            if (month.equals("6")) {
                                image = R.drawable.bkg_06_june;
                            } else {
                                if (month.equals("7")) {
                                    image = R.drawable.bkg_07_july;
                                } else {
                                    if (month.equals("8")) {
                                        image = R.drawable.bkg_08_august;
                                    } else {
                                        if (month.equals("9")) {
                                            image = R.drawable.bkg_09_september;
                                        } else {
                                            if (month.equals("10")) {
                                                image = R.drawable.bkg_10_october;
                                            } else {
                                                if (month.equals("11")) {
                                                    image = R.drawable.bkg_11_november;
                                                } else {
                                                        image = R.drawable.bkg_12_december;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }

            }
        }
        return image;
    }
}