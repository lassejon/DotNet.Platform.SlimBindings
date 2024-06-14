package com.example.instabugwrapper;
import android.app.Application
import com.instabug.library.*;
import com.instabug.library.invocation.InstabugInvocationEvent

class InstabugSdk {
    companion object {
        var Builder: Builder? = null;
    }
}

class Builder(context: Application, instabugToken: String) {
    private var builder: Instabug.Builder? = null;

    fun setInvocationEvents(event: InstabugInvocationEvent): Builder {
        builder = builder?.setInvocationEvents(event);

        return this;
    }

    fun build() {
        builder?.build()
    }

    init {
        builder = Instabug.Builder(context, instabugToken)
    }
}
