package dev.bongthorn.jetmovieapp.navigation


enum class MovieScreens {
    MainScreen,
    HomeScreen,
    MovieDetail;

    companion object {
        fun fromRoute(route: String?): MovieScreens
        = when (route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            MainScreen.name -> MainScreen
            MovieDetail.name -> MovieDetail
            null -> HomeScreen
            else -> throw IllegalAccessException("Route $route is not register.")
        }
    }
}