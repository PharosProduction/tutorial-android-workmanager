package com.pharosproduction

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.work.*
import com.pharosproduction.workers.WorkerA
import com.pharosproduction.workers.WorkerB
import java.util.concurrent.TimeUnit

class MainActivityViewModel : ViewModel() {

    // Variables

    private val mWorkManager = WorkManager.getInstance()
    private val mSavedWorkInfo: LiveData<List<WorkInfo>>

    init {
        mSavedWorkInfo = mWorkManager.getWorkInfosByTagLiveData(AppConstants.TAG_INFO.key)
    }

    fun startOneTimeWork() {
        val aRequest = OneTimeWorkRequestBuilder<WorkerA>().build()
        mWorkManager.enqueue(aRequest)
    }

    fun startPeriodicWork() {
        val aRequestPeriodic =
            PeriodicWorkRequestBuilder<WorkerA>(1, TimeUnit.DAYS).build()
        mWorkManager.enqueueUniquePeriodicWork("WORK", ExistingPeriodicWorkPolicy.REPLACE, aRequestPeriodic)
    }

    fun startChainingWork() {
        val aRequest = OneTimeWorkRequest.Builder(WorkerA::class.java).build()
        var continuation = mWorkManager.beginWith(aRequest)
        val bRequest = OneTimeWorkRequest.Builder(WorkerB::class.java).build()
        continuation = continuation.then(bRequest)
        continuation.enqueue()
    }
}