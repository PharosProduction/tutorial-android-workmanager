package com.pharosproduction.workers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.pharosproduction.AppConstants

class WorkerB(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        // Do work here
        Thread.sleep(2000)
        Log.d(AppConstants.TAG.key, "in B request")

        val resultFromA = inputData.getString(AppConstants.WORKER_A_RESULT.key)

        Log.d(AppConstants.TAG.key, "results - $resultFromA")

        return Result.success()
    }
}