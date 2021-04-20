package com.anil_shatharashi.clean.mvvm.presentation.di.qualifiers

import javax.inject.Scope

@Scope
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScoped
