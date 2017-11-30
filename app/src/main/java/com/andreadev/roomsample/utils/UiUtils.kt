package com.andreadev.roomsample.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.view.ContextThemeWrapper
import com.andreadev.roomsample.R

/**
 * Created by andrea on 04/11/2017.
 */
class UiUtils {

    companion object {

        fun showInfo(activity: Activity, infoMessage: String) {
            val snackbar = Snackbar.make(
                    activity.findViewById(R.id.frame_container),
                    infoMessage,
                    Snackbar.LENGTH_LONG
            )
            val snackbarView = snackbar.view
            snackbarView.setBackgroundColor(ActivityCompat.getColor(activity, R.color.gray))
            snackbar.show()
        }


        fun showError(activity: Activity, errorMessage: String) {
            val snackbar = Snackbar.make(
                    activity.findViewById(R.id.frame_container),
                    errorMessage,
                    Snackbar.LENGTH_LONG
            )
            val snackbarView = snackbar.view
            snackbarView.setBackgroundColor(ActivityCompat.getColor(activity, R.color.green))
            snackbar.show()
        }

        fun showError(activity: Activity, throwable: Throwable) {
            var res = R.string.error_undefined
            showError(activity, activity.getString(res))
        }

        fun showAlert(activity: Activity, title: String, text: String, positiveListener: DialogInterface.OnClickListener, negativeListener: DialogInterface.OnClickListener){
            val builder = AlertDialog.Builder(ContextThemeWrapper(activity, R.style.AlertDialogTheme)).create()
            builder.setTitle(title)
            builder.setMessage(text)
            builder.setButton(AlertDialog.BUTTON_POSITIVE, activity.getString(R.string.ok), positiveListener)
            builder.setButton(AlertDialog.BUTTON_NEGATIVE,  activity.getString(R.string.cancel), negativeListener)
            builder.show()

        }

        /**
         * Log all events
         */
        fun logMessage(TAG: String, message: String){
            Log.d(TAG, "\n\n\n");
            Log.d(TAG, "--------------------------------------------------------------------------------");
            Log.i(TAG, "Message: "       + message)
            Log.d(TAG, "--------------------------------------------------------------------------------");
            Log.d(TAG, "\n\n\n");
        }
    }
}