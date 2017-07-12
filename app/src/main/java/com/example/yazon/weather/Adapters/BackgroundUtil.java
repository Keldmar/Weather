package com.example.yazon.weather.Adapters;

import com.example.yazon.weather.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BackgroundUtil {

    public static int getBackgroundByDate(Long dateLong) {
        int image;
        Date date = new Date(dateLong * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
        String month = sdf.format(date);

        if (month.equals("January ")) {
            image = R.drawable.january;
        } else {
            if (month.equals("February")) {
                image = R.drawable.bkg_02_february;
            } else {
                if (month.equals("March")) {
                    image = R.drawable.bkg_03_march;
                } else {
                    if (month.equals("April")) {
                        image = R.drawable.bkg_04_april;
                    } else {
                        if (month.equals("May")) {
                            image = R.drawable.bkg_05_may;
                        } else {
                            if (month.equals("June")) {
                                image = R.drawable.bkg_06_june;
                            } else {
                                if (month.equals("July")) {
                                    image = R.drawable.bkg_07_july;
                                } else {
                                    if (month.equals("August")) {
                                        image = R.drawable.bkg_08_august;
                                    } else {
                                        if (month.equals("September")) {
                                            image = R.drawable.bkg_09_september;
                                        } else {
                                            if (month.equals("October")) {
                                                image = R.drawable.bkg_10_october;
                                            } else {
                                                if (month.equals("November")) {
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