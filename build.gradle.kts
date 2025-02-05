// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    kotlin("jvm") version "2.1.10"
    kotlin("plugin.serialization") version "2.1.10"
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}