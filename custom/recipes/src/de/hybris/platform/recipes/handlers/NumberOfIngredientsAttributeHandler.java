package de.hybris.platform.recipes.handlers;

import de.hybris.platform.recipes.model.RecipeModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;


public class NumberOfIngredientsAttributeHandler implements DynamicAttributeHandler<Integer, RecipeModel>
{
	@Override
	public Integer get(final RecipeModel arg0)
	{
		if (CollectionUtils.isNotEmpty(arg0.getRecipeEntries()))
		{
			return new Integer(arg0.getRecipeEntries().size());
		}
		return NumberUtils.INTEGER_ZERO;
	}

	@Override
	public void set(final RecipeModel arg0, final Integer arg1)
	{
		throw new IllegalStateException();
	}
}
