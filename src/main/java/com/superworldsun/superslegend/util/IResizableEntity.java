package com.superworldsun.superslegend.util;

public interface IResizableEntity
{
	void setScale(float scale);
	
	float getScale();
	
	float getScaleForRender(float partialTick);
}
