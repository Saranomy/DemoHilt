package com.saranomy.demohilt.models

import javax.inject.Inject
import javax.inject.Named

// do constructor injection
class WaterBalloon @Inject constructor(
    // change @Named to test different options from BalloonModule
    @Named("Leather") private val material: String,
    @Named("Salt") private val water: WaterInterface
) {

    fun pop(): String {
        return "Wow! A $material balloon with a PH of ${water.checkPH()} is popped!"
    }
}