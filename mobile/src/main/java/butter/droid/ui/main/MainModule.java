/*
 * This file is part of Butter.
 *
 * Butter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Butter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Butter. If not, see <http://www.gnu.org/licenses/>.
 */

package butter.droid.ui.main;

import android.content.Context;
import butter.droid.base.content.preferences.PreferencesHandler;
import butter.droid.base.manager.internal.provider.ProviderManager;
import butter.droid.base.manager.prefs.PrefManager;
import butter.droid.base.ui.ActivityScope;
import butter.droid.base.ui.FragmentScope;
import butter.droid.ui.main.MainModule.MainBindModule;
import butter.droid.ui.main.genre.GenreSelectionFragment;
import butter.droid.ui.main.genre.GenreSelectionModule;
import butter.droid.ui.main.navigation.NavigationDrawerFragment;
import butter.droid.ui.main.navigation.NavigationDrawerModule;
import butter.droid.ui.media.list.MediaListFragment;
import butter.droid.ui.media.list.MediaListModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module(includes = MainBindModule.class)
public class MainModule {

    @Provides @ActivityScope MainPresenter providePresenter(MainView view, ProviderManager providerManager, Context context,
            PreferencesHandler preferencesHandler, PrefManager prefManager) {
        return new MainPresenterImpl(view, providerManager, context, preferencesHandler, prefManager);
    }

    @Module
    public interface MainBindModule {
        @Binds MainView bindView(MainActivity activity);

        @FragmentScope
        @ContributesAndroidInjector(modules = NavigationDrawerModule.class)
        NavigationDrawerFragment contributeNavigationDrawerFragmentInjector();

        @FragmentScope
        @ContributesAndroidInjector(modules = GenreSelectionModule.class)
        GenreSelectionFragment contributeGenreSelecionFragmentInjector();

        @FragmentScope
        @ContributesAndroidInjector(modules = MediaListModule.class)
        MediaListFragment contributeMediaListFragmentInjector();
    }
}

