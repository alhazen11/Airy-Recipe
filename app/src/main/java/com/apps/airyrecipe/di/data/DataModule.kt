package  com.apps.airyrecipe.data.di

import com.apps.airyrecipe.data.services.NetworkServices
import com.apps.airyrecipe.network.Network.retrofitClient
import dagger.Module
import dagger.Provides

@Module class DataModule {

    @Provides @DataScope
    fun provideServices(): NetworkServices {
        return retrofitClient().create(NetworkServices::class.java)
    }

}