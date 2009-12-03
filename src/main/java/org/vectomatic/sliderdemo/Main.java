package org.vectomatic.sliderdemo;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.widgetideas.client.HSliderBar;
import com.google.gwt.widgetideas.client.SliderBar;
import com.google.gwt.widgetideas.client.VSliderBar;
import com.google.gwt.widgetideas.client.SliderBar.LabelFormatter;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint {
	interface Binder extends UiBinder<HorizontalPanel, Main> {
	}

	private static Binder binder = GWT.create(Binder.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		HorizontalPanel panel = binder.createAndBindUi(this);
		panel.getElement().getStyle().setPadding(25, Style.Unit.PX);
		panel.setSpacing(10);
		RootPanel.get("sliders").add(panel);
	}
	
	@UiFactory
	HSliderBar makeHSliderBar() {
		final String[] labels = {"1", "2", "3", "4", "5", "6"};
		HSliderBar sliderBar = new HSliderBar(0, 5, new LabelFormatter() {
		    protected String formatLabel(SliderBar slider, double value) {
		    	return labels[(int)value];
		    }			
		});
		sliderBar.setStepSize(1);
		sliderBar.setNumTicks(5);
		sliderBar.setNumLabels(5);
		sliderBar.setCurrentValue(0);
		sliderBar.setPixelSize(150, 50);
		return sliderBar;
	}

	@UiFactory
	VSliderBar makeVSliderBar() {
		final String[] labels = {"A", "B", "C", "D"};
		VSliderBar sliderBar = new VSliderBar(0, 3, new LabelFormatter() {
		    protected String formatLabel(SliderBar slider, double value) {
		    	return labels[(int)value];
		    }			
		});
		sliderBar.setStepSize(1);
		sliderBar.setNumTicks(3);
		sliderBar.setNumLabels(3);
		sliderBar.setCurrentValue(0);
		sliderBar.setPixelSize(50, 150);
		return sliderBar;
	}

}
