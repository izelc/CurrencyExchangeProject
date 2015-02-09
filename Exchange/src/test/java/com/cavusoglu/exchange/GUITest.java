package com.cavusoglu.exchange;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.testng.annotations.*;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.finder.JOptionPaneFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.util.Range.From;

public class GUITest {

	private FrameFixture window;

	@Before
	public void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() {
		Form frame = GuiActionRunner.execute(new GuiQuery<Form>() {

			protected Form executeInEDT() {
				return new Form();
			}
		});
		window = new FrameFixture(frame);
		frame.setVisible(true);
	}

	@After
	public void tearDown() {
		window.cleanUp();
	}

	@Test
	public void shouldCalculteWhenGivenRightInputs() {
		window.textBox("amountTextField").enterText("1");
		window.comboBox("fromComboBox").selectItem("EUR");
		window.comboBox("toComboBox").selectItem("USD");
		window.button("calcButton").click();
		window.textBox("resultTextField").requireText("1.12");
	}

	@Test
	public void whenExceptionOccursJOptionPaneAppears() {
        // when user doesn't enter a value to amount field
		window.comboBox("fromComboBox").selectItem("EUR");
		window.comboBox("toComboBox").selectItem("USD");
		window.button("calcButton").click();
		window.dialog().requireEnabled();
		window.dialog().button().click();

		// when user enter negative amount
		window.textBox("amountTextField").enterText("-1");
		window.comboBox("fromComboBox").selectItem("EUR");
		window.comboBox("toComboBox").selectItem("USD");
		window.button("calcButton").click();
		window.dialog().requireEnabled();
	}

	@Test
	public void addButtonSetsResultUnitComboBoxDisabled() throws Exception {
		window.tabbedPane().selectTab(1);
		window.textBox("addentCurrencyAmountTextField").enterText("1");
		window.button("addButton").click();
		window.comboBox("resultUnitComboBox").requireDisabled();
	}

	@Test
	public void addButtonWorksProperly() throws Exception {
		window.tabbedPane().selectTab(1);
		window.comboBox("resultUnitComboBox").selectItem("TL");
		window.textBox("addentCurrencyAmountTextField").enterText("1");
		window.button("addButton").click();
		window.textBox("resultOfSumTextField").requireText("2.70");
	}

	// @Test
	// public void addButtonRecordsOperationAtOperationTextField() throws
	// Exception {
	// window.tabbedPane().selectTab(1);
	// window.comboBox("resultUnitComboBox").selectItem("TL");
	// window.textBox("addentCurrencyAmountTextField").enterText("1");
	// window.button("addButton").click();
	// window.textBox("operationTextField").requireText("1 TL +");
	//
	// }

}
