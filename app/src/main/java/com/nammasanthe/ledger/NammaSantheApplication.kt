package com.nammasanthe.ledger

import android.app.Application
import com.nammasanthe.ledger.data.db.AppDatabase
import com.nammasanthe.ledger.data.repository.LedgerRepository
import com.nammasanthe.ledger.notification.NotificationHelper
import com.nammasanthe.ledger.locale.LocaleManager
import com.nammasanthe.ledger.security.SecurePrefsManager
import com.nammasanthe.ledger.worker.ReminderScheduler

class NammaSantheApplication : Application() {

    lateinit var database: AppDatabase
        private set
    lateinit var repository: LedgerRepository
        private set
    lateinit var securePrefs: SecurePrefsManager
        private set
    lateinit var localeManager: LocaleManager
        private set

    override fun onCreate() {
        super.onCreate()
        database = AppDatabase.getInstance(this)
        repository = LedgerRepository(database)
        securePrefs = SecurePrefsManager(this)
        localeManager = LocaleManager(securePrefs)
        localeManager.applyStoredLocale()
        NotificationHelper.ensureChannel(this)
        if (securePrefs.isProfileSetup()) {
            ReminderScheduler.scheduleDaily(this)
        }
    }
}
