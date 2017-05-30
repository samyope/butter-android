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

package butter.droid.tv.ui.detail;

import butter.droid.base.providers.media.models.Media;
import butter.droid.base.providers.media.models.Movie;
import butter.droid.base.providers.media.models.Show;
import butter.droid.tv.ui.detail.movie.TVMovieDetailsFragment;
import butter.droid.tv.ui.detail.show.TVShowDetailsFragment;

public class TVMediaDetailPresenterImpl implements TVMediaDetailPresenter {

    private final TVMediaDetailView view;

    public TVMediaDetailPresenterImpl(final TVMediaDetailView view) {
        this.view = view;
    }

    @Override public void onCreate(final Media media) {
        view.updateBackground(media.headerImage);

        if (media instanceof Movie) {
            view.displayFragment(TVMovieDetailsFragment.newInstance(media));
        } else if (media instanceof Show) {
            view.displayFragment(TVShowDetailsFragment.newInstance(media));
        } else {
            throw new IllegalStateException("Unknow media type");
        }
    }
}