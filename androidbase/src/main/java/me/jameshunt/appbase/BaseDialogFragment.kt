package me.jameshunt.appbase

import android.support.v4.app.DialogFragment

abstract class BaseDialogFragment : DialogFragment() {

    private var cleanedUp = false

    abstract fun cleanUp()

    override fun onPause() {
        super.onPause()
        if (isRemoving || activity?.isChangingConfigurations == true) {
            cleanUpIfNotAlreadyDone()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cleanUpIfNotAlreadyDone()
    }

    private fun cleanUpIfNotAlreadyDone() {
        if (cleanedUp) return

        cleanUp()
        cleanedUp = true
    }
}