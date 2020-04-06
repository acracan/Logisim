package com.cburch.logisim.std.ttl;

import java.awt.Graphics;
import java.io.Console;

import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;

public class Ttl7410 extends AbstractTtlGate {

	public Ttl7410() {
		super("7410", (byte) 14, new byte[] { 6, 8, 12 }, true);
	}

	@Override
	public void paintInternal(InstancePainter painter, int x, int y, int height, boolean up) {
		Graphics g = painter.getGraphics();
		int portwidth = 19, portheight = 15;
		int youtput = y + (up ? 20 : 40);
//		Console c = System.console();
//		c.printf("x: %d, y: %d, h: %d, o: %d", x, y, height, up);
		Drawgates.paintAnd(g, x, youtput, portwidth - 4, portheight, true);
		// output line
		Drawgates.paintOutputgate(g, x + 50, y, x + 44, youtput, up);
		// input lines
		Drawgates.paintDoubleInputgate(g, x + 30, y, x + 44 - portwidth, youtput, portheight, up);
	}

	@Override
	public void ttlpropagate(InstanceState state) {
		state.setPort(5,  (state.getPort(2).and(state.getPort(3).and(state.getPort(4))).not()), 1);
		state.setPort(6,  (state.getPort(7).and(state.getPort(8).and(state.getPort(9))).not()), 1);
		state.setPort(10, (state.getPort(0).and(state.getPort(1).and(state.getPort(11))).not()), 1);
	}

}
