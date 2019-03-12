package com.pharosproduction.workers

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.pharosproduction.AppConstants

class WorkerA(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {


    override fun doWork(): Result {
        // Do work here
        Thread.sleep(1000)
        Log.d(AppConstants.TAG.key, "in A request")

        val data = Data.Builder().putString(AppConstants.WORKER_A_RESULT.key, "Result WorkerA success").build()

        // Return Result
        return Result.success(data)
    }
}