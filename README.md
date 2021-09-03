# Pokemon App

Consumed pokemon api
Wrote clean code and used  clean architecture which was segmented into 3 folder (data/ domain /presenter)

data layer contain  Repository  which returns data from a Data Source (Cached or Remote).
domain layer contain Use case which combines data from User and Post Repositories.
Presenter contain ViewModel which executes Use case, also contain dependency injection folder to wire all together.

libraries used
-Android Jetpack libraries
-ViewModel
-Navigation controller
-Hilt
-Instrumental testing
-unit testing
-retrofit
-mockwebserver
-truth
-coroutines

also implemented dark mode


