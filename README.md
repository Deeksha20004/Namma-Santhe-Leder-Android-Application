# Namma-Santhe Ledger (ನಮ್ಮ ಸಂತೆ ಲೆಡ್ಜರ್)

A standalone, offline-first native Android application designed to digitize and simplify traditional credit tracking and transaction management for small marketplace vendors and micro-merchants.

---

## Project Overview

In busy open-air weekly markets (*santhes*), bookkeeping is historically managed using fragile physical paper logs (*khatas*). These paper records are highly vulnerable to ink fading, water damage, page tearing, or total misplacement. 

**Namma-Santhe Ledger** replaces those risky analog methods with a secure, high-performance digital alternative. The application is specifically engineered to operate reliably in low-infrastructure, remote rural environments without demanding continuous internet access or cloud dependencies.

---

## Key Features

* **Offline-First Architecture:** Records, updates, and audits transactions completely on-device. Works 100% without an internet connection, ensuring reliability in remote market areas.
* **Automated Collection Reminders:** Uses a smart background system that tracks outstanding dues and pushes localized reminder alerts to optimize merchant recovery cycles.
* **Secure Access Gateway:** Shields sensitive customer debt profiles and business financial metrics behind a secure 4-digit login PIN layout.
* **Real-Time Financial Dashboard:** Instantly calculates total outstanding balances, extended credits, and transaction histories without screen stuttering or layout freezing.

---

## 🛠️ Built With (Tech Stack)

* **Language:** Kotlin 1.9.x (utilizing Coroutines for smooth asynchronous background math processing).
* **Architecture:** MVVM (Model-View-ViewModel) pattern for clean separation of UI presentation from core data logic.
* **User Interface:** Responsive native XML Layouts styled with Material Design 3 theme tokens.
* **Local Storage:** Room Database library providing a robust abstraction layer over localized SQLite files.
* **Background Processing:** Jetpack WorkManager and Broadcast Receivers for battery-efficient event scheduling.
* **Code Optimization:** ProGuard rules for dead-code stripping, performance optimization, and bundle shrinking.

---

## Project Architecture

The project follows clean architecture principles using the **MVVM** layout structure:

* **View (XML & Activities):** Handles UI presentation and captures user touch interactions.
* **ViewModel:** Serves as the operational middleman; executes financial calculations and safely exposes data states to the View.
* **Model (Room DB):** Manages the physical relational data rows, entities, and DAOs deep inside the phone storage.

---

## How It Works Under the Hood

1. **The Core File:** Room DB saves all your data rows securely inside a single, protected SQLite database file located in the app's sandboxed internal storage directory.
2. **The Safety Lock:** When entries are modified, changes are logged to a temporary Write-Ahead Log (`.db-wal`) first, preventing data corruption if the phone suddenly loses battery power.
3. **The Alarm Clock:** Jetpack WorkManager runs persistent checking scripts in the background, surviving device restarts to guarantee your collection timelines stay accurate.

---

## License & Copyright

Copyright © 2026. All rights reserved. 

The source code, assets, and design elements of this project are personal property. Unauthorized copying, modification, or distribution of this codebase is strictly prohibited.
