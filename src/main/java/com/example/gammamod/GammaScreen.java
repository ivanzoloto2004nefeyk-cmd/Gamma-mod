package com.example.gammamod;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.Text;

public class GammaScreen extends Screen {
    private float gamma = 1.0f;

    protected GammaScreen() {
        super(Text.of("Настройка Gamma"));
    }

    @Override
    protected void init() {
        // Слайдер 0%-500%
        this.addDrawableChild(new SliderWidget(this.width / 2 - 100, this.height / 2, 200, 20,
                Text.of("Gamma: " + (int)(gamma * 100) + "%"), gamma / 5.0f) {
            @Override
            protected void updateMessage() {
                setMessage(Text.of("Gamma: " + (int)(this.value * 500) + "%"));
            }

            @Override
            protected void applyValue() {
                gamma = (float)(this.value * 5.0);
                client.options.gamma = gamma;
            }
        });

        // Кнопка закрытия
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 50, this.height / 2 + 30, 100, 20,
                Text.of("Закрыть"), button -> client.setScreen(null)));
    }
}

