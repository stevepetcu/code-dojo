/*
 * This file is part of the DiamondKata application.
 *
 * © Stefan Petcu <hello@stefanpetcu.com>
 *
 * For the full copyright and license information, please view
 * the LICENSE file that was distributed with this source code.
 */
package test.java.codedojo.kata.junittdd.diamond;

import main.java.codedojo.kata.junittdd.diamond.Diamond;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DiamondTest {
    @Test
    public void shouldOutputADiamondRendering() {
        Diamond diamond = new Diamond();

        String rendering = diamond.toString();

        assertThat(rendering, equalTo(" A\nB B\n A"));
    }
}
