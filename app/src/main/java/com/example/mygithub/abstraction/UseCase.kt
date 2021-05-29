package com.example.mygithub.abstraction

abstract class UseCase<Params, out T> {
    abstract suspend operator fun invoke(params: Params): T

    object None
}
