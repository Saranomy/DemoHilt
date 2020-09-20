package com.saranomy.demohilt.modules

import com.saranomy.demohilt.models.ColaWater
import com.saranomy.demohilt.models.SaltWater
import com.saranomy.demohilt.models.WaterInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named

@InstallIn(ApplicationComponent::class)
@Module
object BalloonModule {
    @Provides
    @Named("Salt")
    fun provideSaltWater() : WaterInterface {
        return SaltWater()
    }

    @Provides
    @Named("Cola")
    fun provideColaWater() : WaterInterface {
        return ColaWater()
    }

    @Provides
    @Named("Plastic")
    fun providePlastic() : String {
        return "plastic"
    }

    @Provides
    @Named("Leather")
    fun provideLeather() : String {
        return "leather"
    }
}