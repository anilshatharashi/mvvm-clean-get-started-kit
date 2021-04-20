package com.anil_shatharashi.clean.mvvm.presentation.di.qualifiers

import javax.inject.Scope

@Scope
@MustBeDocumented
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScoped
