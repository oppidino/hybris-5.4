/**
 *
 */
package de.hybris.platform.recipes.jobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.jalo.SearchResult;
import de.hybris.platform.recipes.model.MenuModel;
import de.hybris.platform.recipes.model.RecipeModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;

import java.util.List;



/**
 * @author A.Cardinale
 *
 */
public class CreateMenuJob extends AbstractJobPerformable<CronJobModel>
{
	ModelService modelService;

	@Override
	public PerformResult perform(final CronJobModel arg0)
	{

		final String sql = "select {pk} from {Recipe}";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(sql);
		final SearchResult<RecipeModel> result = (SearchResult<RecipeModel>) flexibleSearchService.search(query);
		final List<RecipeModel> recipesList = result.getResult();
		if (recipesList.isEmpty())
		{
			return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
		}
		final MenuModel menu = modelService.create(MenuModel.class);
		menu.setCode("1");
		menu.setName("menu del giorno");
		modelService.save(menu);
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

}
