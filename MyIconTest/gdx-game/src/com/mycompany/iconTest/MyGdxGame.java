package com.mycompany.iconTest;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import android.service.carrier.*;

public class MyGdxGame implements ApplicationListener
{
	Sprite car_sprite;
	SpriteBatch batch;
	Texture car_texture;
	@Override
	public void create()
	{
		batch = new SpriteBatch();
		//car_texture = new Texture(Gdx.files.internal("assets/car.png"));
		
	}

	@Override
	public void render()
	{        
	    Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(car_texture, 50,50);
		batch.end();
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
