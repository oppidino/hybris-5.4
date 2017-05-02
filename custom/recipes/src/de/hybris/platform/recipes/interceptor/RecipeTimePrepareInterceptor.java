package de.hybris.platform.recipes.interceptor;

import de.hybris.platform.recipes.model.RecipeModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;


public class RecipeTimePrepareInterceptor implements PrepareInterceptor<RecipeModel>
{

	@Override
	public void onPrepare(final RecipeModel paramMODEL, final InterceptorContext paramInterceptorContext)
			throws InterceptorException
	{
		int newTime = paramMODEL.getTime().intValue();
		newTime = newTime + 10;
		paramMODEL.setTime(Integer.valueOf(newTime));
	}
}
