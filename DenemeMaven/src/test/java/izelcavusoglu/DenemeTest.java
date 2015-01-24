package izelcavusoglu;

import static org.junit.Assert.*;

import org.junit.Test;

public class DenemeTest {
@Test
public void testBol() throws Exception {
	Deneme deneme = new Deneme();
	int i = deneme.bol();
	assertEquals(50, i);
}
}
