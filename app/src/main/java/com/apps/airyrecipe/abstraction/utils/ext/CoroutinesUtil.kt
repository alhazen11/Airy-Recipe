package com.apps.airyrecipe.abstraction.utils.ext

import com.apps.airyrecipe.abstraction.utils.state.ResultState
import java.net.ConnectException

suspend fun <T: Any> fetchState(call: suspend () -> ResultState<T>): ResultState<T> {
    return try {
        call.invoke()
    } catch (e: ConnectException) {
        ResultState.Error(e.message)
    } catch (e: Exception) {
        ResultState.Error(e.message)
    } catch (e: Throwable) {
        ResultState.Error(e.message)
    }
}